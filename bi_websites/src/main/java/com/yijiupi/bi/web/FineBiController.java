package com.yijiupi.bi.web;

import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import com.yijiupi.bi.config.SessionConst;
import com.yijiupi.bi.entity.*;
import com.yijiupi.bi.kit.AjaxJson;
import com.yijiupi.bi.service.db2.*;
import com.yijiupi.bi.utils.BaseResult;
import com.yijiupi.bi.utils.HttpUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.UnsupportedEncodingException;
import java.util.*;

/**
 * @Decription:
 * @Author Huang Yuansheng
 * @Date Create in 16:55 2018/8/7
 * @Email: huangyuansheng@yijiupi.cn
 */
@Controller
@RequestMapping("/FineBi")
public class FineBiController extends BaseController {

    private static Logger LOG = LoggerFactory.getLogger(FineBiController.class);

    @Value("${yjp.fineBi.serverUrl}")
    private String serverUrl;
    @Value("${yjp.fineBi.adminPassword}")
    private String adminPassword;

    @Autowired
    private Environment env;

    @Autowired
    private FRCustomRoleUserService customRoleUserService;

    @Autowired
    private FrFolderentryService frFolderentryService;

    @Autowired
    private FRDepartmentPostUserService departmentPostUserService;

    @Autowired
    private FRCompanyroleService companyRoleService;

    @Autowired
    private FrCurepService curepService;

    @Autowired
    private FrCorepService corepService;

    @Autowired
    private FrUepService uepService;

    @Autowired
    private IconClsMenuService iconService;

    @Autowired
    private AllFrMenu allFrMenu;

    @ResponseBody
    @RequestMapping("serverUrl")
    public String getServerUrl() {
        return serverUrl;
    }

    @ResponseBody
    @RequestMapping("resetCache")
    public BaseResult resetCache() {
        LOG.info("reset_cache:{}", serverUrl);
        HttpUtils.resetCache(serverUrl, adminPassword);

        return BaseResult.getSuccessResult();
    }

    @ResponseBody
    @RequestMapping("getProfiles")
    public String getProfiles() {
        return env.getProperty("spring.profiles.active");
    }

    @ResponseBody
    @RequestMapping("getAllFrMenu")
    public AjaxJson getAllFrFolderMenu() {
        FrUser user = getSessionAttr(SessionConst.SESSION_USER);
        if (null != user) {
            FrFolderMenu rootFolder = FrFolderMenu.getRootFolder();
            buildSubTreeMenuList(allFrMenu.getAllCloneFrMenuList(), rootFolder);
            return AjaxJson.success().setData(rootFolder.getChildren());
        }
        return AjaxJson.failure().setMsg("请登录后操作!");
    }

    @ResponseBody
    @RequestMapping("getFrMenu")
    public AjaxJson getFrFolderMenu() {
        FrUser user = getSessionAttr(SessionConst.SESSION_USER);
        if (null != user) {
            Set<FrFolderMenu> allMenuSet = Sets.newHashSet();
            addCustomRoleMenu(user.getId(), allMenuSet);
            addCompanyRoleMenu(user.getId(), allMenuSet);
            addUserMenu(user.getId(), allMenuSet);
            if (0 != allMenuSet.size()) {
                List<FrFolderMenu> menus = Lists.newArrayList(allMenuSet);
                FrFolderMenu rootFolder = FrFolderMenu.getRootFolder();
                buildSubTreeMenuList(menus, rootFolder);

                return AjaxJson.success().setData(rootFolder.getChildren());
            }
            return AjaxJson.failure().setMsg("用户没有权限访问该站点!");
        }
        return AjaxJson.failure().setMsg("请登录后操作!");
    }

    @ResponseBody
    @RequestMapping("getAllIconCls")
    public List<Iconcls> getAllIconCls() {
        return allFrMenu.getAllIconCls();
    }

    @ResponseBody
    @RequestMapping("updateMenuIcon")
    public AjaxJson updateMenuIcon(Long entryId, Integer menuType, Long iconId) throws UnsupportedEncodingException {
        FrUser user = getSessionAttr(SessionConst.SESSION_USER);
        if (null != user) {
            IconclsMenu iconclsMenu = new IconclsMenu(entryId, menuType, iconId, user.getRealname(), new Date());
            boolean result = iconService.upsertIconByEntryId(iconclsMenu);
            if (result) {
                updateAllMenu();
                return AjaxJson.success();
            }
        }
        return AjaxJson.failure();
    }

    @ResponseBody
    @RequestMapping("updateAllMenu")
    public String updateAllMenu() throws UnsupportedEncodingException {
        allFrMenu.setAllFrMenu(allFrMenu.transUrl(frFolderentryService.loadAllMenu()));
        return "更新菜单成功";
    }

    /**
     * 添加user直接拥有权限查看的菜单
     *
     * @param userId     user id
     * @param allMenuSet 菜单
     */
    private void addUserMenu(long userId, Set<FrFolderMenu> allMenuSet) {
        List<FrTUep> ueps = uepService.getAllUepByUserId(userId);
        for (FrTUep uep : ueps) {
            LOG.debug("通过用户id{},直接查询出一条用户菜单权限:{}", userId, uep);
            setTreeRoot(allMenuSet, uep.getEntryid(), uep.getType());
        }
    }

    /**
     * 添加user的城市职位角色menu
     *
     * @param userId 用户id
     */
    private void addCompanyRoleMenu(long userId, Set<FrFolderMenu> allMenuSet) {
        // 获取用户对应的城市，职位
        List<FrDepartmentPostUser> departmentPostUsers = departmentPostUserService.getByUserId(userId);
        List<FrCorep> coreps;
        List<FrCorep> allDepartmentCoreps;
        for (FrDepartmentPostUser postUser : departmentPostUsers) {
            FrCompanyrole companyRole = companyRoleService.getByDeptIdAndPostId(postUser.getDepartmentid(), postUser.getPostid());
            if (null != companyRole) {
                coreps = corepService.getAllCorepByRoleId(companyRole.getId());
                for (FrCorep corep : coreps) {
                    LOG.debug("通过用户{}的机构部门角色id:{},查询出一条用户菜单权限:{}", userId, companyRole.getId(), corep);
                    setTreeRoot(allMenuSet, corep.getEntryid(), corep.getType());
                }
            }

            // 添加所有部门中该职位的权限
            allDepartmentCoreps = corepService.getAllDepartmentPostCorepByPostId(postUser.getPostid());
            for (FrCorep corep : allDepartmentCoreps) {
                LOG.debug("通过用户:{}的职位:{},查询出一条所有部门下配置的菜单权限:{}", userId, postUser.getPostid(), corep);
                setTreeRoot(allMenuSet, corep.getEntryid(), corep.getType());
            }
        }
    }

    /**
     * 添加user的自定义角色menu
     *
     * @param userId 用户id
     */
    private void addCustomRoleMenu(long userId, Set<FrFolderMenu> allMenuSet) {
        List<FrCustomRoleUser> customRoleUsers = customRoleUserService.getByUserId(userId);
        List<FrCurep> cureps;
        for (FrCustomRoleUser roleUser : customRoleUsers) {
            cureps = curepService.getAllCurepByRoleId(roleUser.getCustomroleid());
            for (FrCurep curep : cureps) {
                LOG.debug("通过用户{}的自定义角色id:{},查询出一条用户菜单权限:{}", userId, roleUser.getId(), curep);
                setTreeRoot(allMenuSet, curep.getEntryid(), curep.getType());
            }
        }
    }

    /**
     * 设置根节点
     *
     * @param allMenuSet 所有菜单列表
     * @param entryId    菜单id
     */
    private void setTreeRoot(Set<FrFolderMenu> allMenuSet, Long entryId, Integer type) {
        List<FrFolderMenu> customMenus = new ArrayList<>();
        if (null != allFrMenu.getAllFrMenu() && 0 != allFrMenu.getAllFrMenu().size()) {
            Optional<FrFolderMenu> optional = allFrMenu.getAllFrMenu().stream().filter(menu -> Long.valueOf(menu.getId()).equals(entryId) && menu.getType().equals(type)).findFirst();
            optional.ifPresent(frFolderMenu -> customMenus.add(frFolderMenu.clone()));
        }
        allMenuSet.addAll(customMenus);
    }

    /**
     * 生成菜单树
     *
     * @param menuList   菜单列表
     * @param parentMenu 父节点
     * @return 组装后的菜单树
     */
    private void buildSubTreeMenuList(List<FrFolderMenu> menuList, FrFolderMenu parentMenu) {
        //添加所有的folder
        for (FrFolderMenu menu : menuList) {
            menu.setTreeFieldId();
            if (menu.getParentId().equals(parentMenu.getId()) && menu.isFolder()) {
                //然后添加folder下的子节点
                buildSubTreeMenuList(menuList, menu);
                //folder下至少有一个子节点
                if (menu.getChildren() != null && menu.getChildren().size() > 0) {
                    parentMenu.getChildren().add(menu);
                }
            }
            //添加所有的直接子节点
            else if (menu.getParentId().equals(parentMenu.getId()) && !menu.isFolder()) {
                parentMenu.getChildren().add(menu);
            }
        }
        parentMenu.getChildren().sort(new FrFolderMenu());
    }
}
