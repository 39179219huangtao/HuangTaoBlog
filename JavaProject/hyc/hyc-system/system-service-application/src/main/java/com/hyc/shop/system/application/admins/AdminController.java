package com.hyc.shop.system.application.admins;

import org.springframework.util.Assert;

import com.hyc.shop.common.constant.MallConstants;
import com.hyc.shop.common.util.CollectionUtil;
import com.hyc.shop.common.vo.CommonResult;
import com.hyc.shop.common.vo.PageResult;
import com.hyc.shop.system.application.convert.AdminConvert;
import com.hyc.shop.system.application.convert.ResourceConvert;
import com.hyc.shop.system.application.vo.admin.AdminMenuTreeNodeVO;
import com.hyc.shop.system.application.vo.admin.AdminRoleVO;
import com.hyc.shop.system.application.vo.admin.AdminVO;
import com.hyc.shop.system.bo.admin.AdminBO;
import com.hyc.shop.system.bo.resource.ResourceBO;
import com.hyc.shop.system.bo.role.RoleBO;
import com.hyc.shop.system.constant.ResourceConstants;
import com.hyc.shop.system.dto.admin.*;
import com.hyc.shop.system.sdk.annotation.RequiresPermissions;
import com.hyc.shop.system.sdk.context.AdminSecurityContextHolder;
import com.hyc.shop.system.service.AdminService;
import com.hyc.shop.system.service.ResourceService;
import com.hyc.shop.system.service.RoleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.stream.Collectors;

import static com.hyc.shop.common.vo.CommonResult.success;

@RestController
@RequestMapping(MallConstants.ROOT_PATH_ADMIN + "/admin")
@Api("管理员模块")
public class AdminController {

    @Reference(validation = "true", version = "${dubbo.provider.ResourceService.version}")
    private ResourceService resourceService;

    @Reference(validation = "true", version = "${dubbo.provider.AdminService.version}")
    private AdminService adminService;

    @Reference(validation = "true", version = "${dubbo.provider.RoleService.version}")
    private RoleService roleService;

    // =========== 当前管理员相关的资源 API ===========

    // TODO 功能：当前管理员

    @SuppressWarnings("Duplicates")
    @GetMapping("/menu_resource_tree")
    @ApiOperation(value = "获得当前登陆的管理员拥有的菜单权限", notes = "以树结构返回")
    public CommonResult<List<AdminMenuTreeNodeVO>> menuResourceTree() {
        List<ResourceBO> resources = resourceService.getResourcesByTypeAndRoleIds(ResourceConstants.TYPE_MENU,
                AdminSecurityContextHolder.getContext().getRoleIds());
        // 创建 AdminMenuTreeNodeVO Map
        Map<Integer, AdminMenuTreeNodeVO> treeNodeMap = new LinkedHashMap<>(); // 使用 LinkedHashMap 的原因，是为了排序 。实际也可以用 Stream API ，就是太丑了。
        resources.stream().sorted(Comparator.comparing(ResourceBO::getSort)).forEach(resourceBO -> treeNodeMap.put(resourceBO.getId(), ResourceConvert.INSTANCE.convert(resourceBO)));
        // 处理父子关系
        treeNodeMap.values().stream()
                .filter(node -> !node.getPid().equals(ResourceConstants.PID_ROOT))
                .forEach((childNode) -> {
                    // 获得父节点
                    AdminMenuTreeNodeVO parentNode = treeNodeMap.get(childNode.getPid());
                    if (parentNode.getChildren() == null) { // 初始化 children 数组
                        parentNode.setChildren(new ArrayList<>());
                    }
                    // 将自己添加到父节点中
                    parentNode.getChildren().add(childNode);
                });
        // 获得到所有的根节点
        List<AdminMenuTreeNodeVO> rootNodes = treeNodeMap.values().stream()
                .filter(node -> node.getPid().equals(ResourceConstants.PID_ROOT))
//                .sorted(Comparator.comparing(AdminMenuTreeNodeVO::getSort))
                .collect(Collectors.toList());
        return success(rootNodes);
    }

    @GetMapping("/url_resource_list")
    @ApiOperation(value = "获得当前登陆的管理员拥有的 URL 权限列表")
    public CommonResult<Set<String>> urlResourceList() {
        List<ResourceBO> resources = resourceService.getResourcesByTypeAndRoleIds(ResourceConstants.TYPE_BUTTON, AdminSecurityContextHolder.getContext().getRoleIds());
        return success(resources.stream().map(ResourceBO::getHandler).collect(Collectors.toSet()));
    }

    // =========== 管理员管理 API ===========

    @GetMapping("/page")
    @RequiresPermissions("system.admin.page")
    @ApiOperation(value = "管理员分页")
    public CommonResult<PageResult<AdminVO>> page(AdminPageDTO adminPageDTO) {
        PageResult<AdminBO> page = adminService.getAdminPage(adminPageDTO);
        PageResult<AdminVO> resultPage = AdminConvert.INSTANCE.convertAdminVOPage(page);
        // 拼接结果
        if (!resultPage.getList().isEmpty()) {
            // 查询角色数组
            Map<Integer, Collection<RoleBO>> roleMap = adminService.getAdminRolesMap(CollectionUtil.convertList(resultPage.getList(), AdminBO::getId));
            resultPage.getList().forEach(admin -> admin.setRoles(AdminConvert.INSTANCE.convertAdminVORoleList(roleMap.get(admin.getId()))));
        }
        return success(resultPage);
    }

    @PostMapping("/add")
    @ApiOperation(value = "创建管理员")
    public CommonResult<AdminBO> add(AdminAddDTO adminAddDTO) {
        return success(adminService.addAdmin(AdminSecurityContextHolder.getContext().getAdminId(), adminAddDTO));
    }

    @PostMapping("/update")
    @ApiOperation(value = "更新管理员")
    public CommonResult<Boolean> update(AdminUpdateDTO adminUpdateDTO) {
        return success(adminService.updateAdmin(AdminSecurityContextHolder.getContext().getAdminId(), adminUpdateDTO));
    }

    @PostMapping("/update_status")
    @ApiOperation(value = "更新管理员状态")
    public CommonResult<Boolean> updateStatus(AdminUpdateStatusDTO adminUpdateStatusDTO) {
        return success(adminService.updateAdminStatus(AdminSecurityContextHolder.getContext().getAdminId(), adminUpdateStatusDTO));
    }

    @PostMapping("/delete")
    @ApiOperation(value = "删除管理员")
    @ApiImplicitParam(name = "id", value = "管理员编号", required = true, example = "1")
    public CommonResult<Boolean> delete(@RequestParam("id") Integer id) {
        return success(adminService.deleteAdmin(AdminSecurityContextHolder.getContext().getAdminId(), id));
    }

    @GetMapping("/role_list")
    @ApiOperation(value = "指定管理员拥有的角色列表")
    @ApiImplicitParam(name = "id", value = "管理员编号", required = true, example = "1")
    public CommonResult<List<AdminRoleVO>> roleList(@RequestParam("id") Integer id) {
        // 获得所有角色列表
        List<RoleBO> allRoleList = roleService.getRoleList();
        // 获得管理员的角色数组
        Set<Integer> adminRoleIdSet = CollectionUtil.convertSet(adminService.getRoleList(id), RoleBO::getId);
        // 转换出返回结果
        List<AdminRoleVO> result = AdminConvert.INSTANCE.convert(allRoleList);
        // 设置每个角色是否赋予给改管理员
        result.forEach(adminRoleVO -> adminRoleVO.setAssigned(adminRoleIdSet.contains(adminRoleVO.getId())));
        return success(result);
    }

    @PostMapping("/assign_role")
    @ApiOperation(value = "分配给管理员角色")
    public CommonResult<Boolean> assignRole(AdminAssignRoleDTO adminAssignRoleDTO) {
        return success(adminService.assignAdminRole(AdminSecurityContextHolder.getContext().getAdminId(), adminAssignRoleDTO));
    }

}
