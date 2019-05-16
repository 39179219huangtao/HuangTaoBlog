package com.yijiupi.bi.service.db2.impl;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.toolkit.StringUtils;
import com.google.common.collect.Lists;
import com.yijiupi.bi.constant.WebConstants;
import com.yijiupi.bi.dto.*;
import com.yijiupi.bi.entity.*;
import com.yijiupi.bi.kit.easyui.EasyUiPage;
import com.yijiupi.bi.mapper.FrUserMapper;
import com.yijiupi.bi.service.db1.impl.BaseServiceImpl;
import com.yijiupi.bi.service.db2.*;
import com.yijiupi.bi.utils.HttpUtils;
import org.apache.commons.collections.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author huangtao
 * @Title: bi_websites
 * @Package com.yijiupi.bi.service.db2.impl
 * @Description:
 * @date 2018/7/24  17:18
 */
@Service
public class FRUserServiceImpl extends BaseServiceImpl<FrUserMapper, FrUser> implements FRUserService {
    private static Logger log = LoggerFactory.getLogger(FRUserServiceImpl.class);

    @Value("${yjp.fineBi.serverUrl}")
    private String serverUrl;
    @Value("${yjp.fineBi.adminPassword}")
    private String adminPassword;

    @Autowired
    FRCustomRoleUserService frCustomRoleUserService;

    @Autowired
    FRRoleService frRoleService;

    @Autowired
    FRDepartmentService frDepartmentService;

    @Autowired
    FRPostService frPostService;

    @Autowired
    FRDepartmentPostUserService frDepartmentPostUserService;

    @Autowired
    FRCompanyroleService frCompanyroleService;

    @Override
    public int syncUser(List<AdminUser> adminUsers) {
        List<FrUser> syncLists = Lists.newArrayList();
        List<Long> deleteLists = Lists.newArrayList();
        if (CollectionUtils.isNotEmpty(adminUsers)) {
            for (AdminUser adminUser : adminUsers) {
                if (StringUtils.isNotEmpty(adminUser.getMobileNo())) {
                    // 只同步启用的 删除禁用的
                    if (adminUser.getEnableState().intValue() == EnableState.启用.value.intValue()) {
                        FrUser frUser = new FrUser();
                        frUser.setUsername(adminUser.getMobileNo());
                        frUser.setRealname(adminUser.getTrueName());
                        frUser.setPassword(adminUser.getPassword());
                        frUser.setMobile(adminUser.getMobileNo());
                        frUser.setEmail(adminUser.getEmail());

                        EntityWrapper<FrUser> wrapper = new EntityWrapper<>();
                        wrapper.eq("username", adminUser.getMobileNo());
                        Integer num = baseMapper.selectCount(wrapper);
                        if (0 == num) {
                            syncLists.add(frUser);
                        }
                    } else if (adminUser.getEnableState().intValue() == EnableState.停用.value.intValue()) {
                        EntityWrapper<FrUser> wrapper = new EntityWrapper<>();
                        wrapper.eq("username", adminUser.getMobileNo());
                        List<FrUser> frUserList = baseMapper.selectList(wrapper);
                        if (CollectionUtils.isNotEmpty(frUserList)) {
                            log.info("删除禁用的用户：{}", JSON.toJSONString(adminUser));
                            deleteLists.add(frUserList.get(0).getId());
                        }
                    }
                }
            }
        }
        if (CollectionUtils.isNotEmpty(syncLists)) {
            insertBatch(syncLists);
        }
        if (CollectionUtils.isNotEmpty(deleteLists)) {
            deleteBatchIds(deleteLists);
        }
        return syncLists.size() + deleteLists.size();
    }



    @Override
    public int syncUserDepartmentPos(List<AdminUser> syncAdminuser) {
        List<FrDepartmentPostUser> frDepartmentPostUsers = Lists.newArrayList();
        List<FrCompanyrole> frCompanyroles = Lists.newArrayList();
        for (AdminUser adminUser : syncAdminuser) {
            // 查询用户
            EntityWrapper<FrUser> frUserwrapper = new EntityWrapper<>();
            frUserwrapper.eq("username", adminUser.getMobileNo());
            List<FrUser> frUserList = selectList(frUserwrapper);
            if (CollectionUtils.isNotEmpty(frUserList)) {
                FrUser frUser = frUserList.get(0);

                List<AdminUserAuth> authList = adminUser.getAuthList();
                for (AdminUserAuth adminUserAuth : authList) {
                    AdminUserRoleType adminUserRoleType = AdminUserRoleType.getAdminUserRoleType(adminUserAuth.getRole().role);
                    // 查询部门角色
                    EntityWrapper<FrPost> frPostwrapper = new EntityWrapper<>();
                    frPostwrapper.eq("postname", adminUserRoleType.name());
                    List<FrPost> frPosts = frPostService.selectList(frPostwrapper);
                    // 获取城市信息
                    Integer cityId = adminUserAuth.getOrg().getId();
                    EntityWrapper<FrDepartment> departmentwrapper = new EntityWrapper<>();
                    departmentwrapper.eq("name", String.valueOf(cityId));
                    List<FrDepartment> frDepartments = frDepartmentService.selectList(departmentwrapper);

                    if (CollectionUtils.isNotEmpty(frPosts) && CollectionUtils.isNotEmpty(frDepartments)) {
                        FrPost frPost = frPosts.get(0);
                        FrDepartment frDepartment = frDepartments.get(0);

                        // 查询部门角色关系关联关系
                        EntityWrapper<FrCompanyrole> frCompanyroleEntityWrapper = new EntityWrapper<>();
                        frCompanyroleEntityWrapper.eq("postid", frPost.getId());
                        frCompanyroleEntityWrapper.eq("departmentid", frDepartment.getId());
                        int frCompanyroleCount = frCompanyroleService.selectCount(frCompanyroleEntityWrapper);

                        FrCompanyrole frCompanyrole = new FrCompanyrole();
                        frCompanyrole.setDepartmentid(frDepartment.getId());
                        frCompanyrole.setPostid(frPost.getId());
                        frCompanyrole.setDescription("酒批城市角色关系");

                        if (frCompanyroleCount == 0 && !frCompanyroles.contains(frCompanyrole)) {
                            frCompanyroles.add(frCompanyrole);
                        }

                        // 查询部门角色用户关系关联关系
                        EntityWrapper<FrDepartmentPostUser> frDepartmentPostUserwrapper = new EntityWrapper<>();
                        frDepartmentPostUserwrapper.eq("Userid", frUser.getId());
                        frDepartmentPostUserwrapper.eq("Departmentid", frDepartment.getId());
                        frDepartmentPostUserwrapper.eq("Postid", frPost.getId());
                        int frDepartmentPostUserCount = frDepartmentPostUserService.selectCount(frDepartmentPostUserwrapper);

                        FrDepartmentPostUser departmentPostUser = new FrDepartmentPostUser();
                        departmentPostUser.setUserid(frUser.getId());
                        departmentPostUser.setDepartmentid(frDepartment.getId());
                        departmentPostUser.setPostid(frPost.getId());
                        if (0 == frDepartmentPostUserCount && !frDepartmentPostUsers.contains(departmentPostUser)) {
                            frDepartmentPostUsers.add(departmentPostUser);
                        }
                    }
                }
            }
        }
        // 同步城市角色
        if (CollectionUtils.isNotEmpty(frCompanyroles)) {
            frCompanyroleService.insertOrUpdateBatch(frCompanyroles);
        }
        // 同步城市角色用户
        if (CollectionUtils.isNotEmpty(frDepartmentPostUsers)) {
            frDepartmentPostUserService.insertOrUpdateBatch(frDepartmentPostUsers);
        }
        if(CollectionUtils.isNotEmpty(frCompanyroles) && CollectionUtils.isNotEmpty(frDepartmentPostUsers)){
            HttpUtils.resetCache(serverUrl,adminPassword);
        }
        return frDepartmentPostUsers.size();
    }


    @Override
    public FrUser getFrUser(FrUser model, String... attrs) {
        return getOneByEqual(model, "username");
    }

    @Override
    public void updateFrUserById(FrUser frUser) {
        updateById(frUser);
    }

    @Override
    public void insertFrUserOrUpdate(FrUser frUser) {
        insertOrUpdate(frUser);
    }

    @Override
    public EasyUiPage<FrUser> getFrUserList(EasyUiPage<FrUser> pageInfo, FrUser frUser, String... attrs) {
        return pageByDynamicEqual(pageInfo, frUser, attrs);
    }
}
