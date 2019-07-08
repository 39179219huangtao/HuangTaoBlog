package com.hyc.shop.product.application.controller.controller.admins;


import com.hyc.shop.common.vo.CommonResult;
import com.hyc.shop.product.application.controller.convert.ProductCategoryConvert;
import com.hyc.shop.product.application.controller.vo.admins.AdminsProductCategoryTreeNodeVO;
import com.hyc.shop.product.application.controller.vo.admins.AdminsProductCategoryVO;
import com.hyc.shop.product.bo.ProductCategoryBO;
import com.hyc.shop.product.constants.ProductCategoryConstants;
import com.hyc.shop.product.dto.ProductCategoryAddDTO;
import com.hyc.shop.product.dto.ProductCategoryUpdateDTO;
import com.hyc.shop.product.service.ProductCategoryService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import com.hyc.shop.product.application.controller.convert.*;
import static com.hyc.shop.common.vo.CommonResult.success;
import com.hyc.shop.system.sdk.context.AdminSecurityContextHolder;
@RestController
@RequestMapping("admins/category")
@Api("商品分类")
public class AdminsProductCategoryController {

    @Reference(validation = "true", version = "${dubbo.provider.ProductCategoryService.version}")
    private ProductCategoryService productCategoryService;

    @GetMapping("/tree")
    @ApiOperation("获得分类树结构")
    public CommonResult<List<AdminsProductCategoryTreeNodeVO>> tree() {
        List<ProductCategoryBO> productCategories = productCategoryService.getAll();
        // 创建 ProductCategoryTreeNodeVO Map
        Map<Integer, AdminsProductCategoryTreeNodeVO> treeNodeMap = productCategories.stream().collect(Collectors.toMap(ProductCategoryBO::getId, ProductCategoryConvert.Admins.INSTANCE::convert));
        // 处理父子关系
        treeNodeMap.values().stream()
                .filter(node -> !node.getPid().equals(ProductCategoryConstants.PID_ROOT))
                .forEach((childNode) -> {
                    // 获得父节点
                    AdminsProductCategoryTreeNodeVO parentNode = treeNodeMap.get(childNode.getPid());
                    if (parentNode.getChildren() == null) { // 初始化 children 数组
                        parentNode.setChildren(new ArrayList<>());
                    }
                    // 将自己添加到父节点中
                    parentNode.getChildren().add(childNode);
                });
        // 获得到所有的根节点
        List<AdminsProductCategoryTreeNodeVO> rootNodes = treeNodeMap.values().stream()
                .filter(node -> node.getPid().equals(ProductCategoryConstants.PID_ROOT))
                .sorted(Comparator.comparing(AdminsProductCategoryTreeNodeVO::getSort))
                .collect(Collectors.toList());
        return success(rootNodes);
    }

    @PostMapping("/add")
    @ApiOperation(value = "创建商品分类")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pid", value = "父级分类编号", required = true, example = "1"),
            @ApiImplicitParam(name = "name", value = "分类名字（标识）", required = true, example = "admin/info"),
            @ApiImplicitParam(name = "description", value = "描述", required = true, example = "1"),
            @ApiImplicitParam(name = "picUrl", value = "分类图片", example = "http://www.iocoder.cn/images/common/wechat_mp_2017_07_31_bak.jpg/"),
            @ApiImplicitParam(name = "sort", value = "排序", required = true, example = "1"),
    })
    public CommonResult<AdminsProductCategoryVO> add(@RequestParam("pid") Integer pid,
                                                     @RequestParam("name") String name,
                                                     @RequestParam("description") String description,
                                                     @RequestParam(value = "picUrl", required = false) String picUrl,
                                                     @RequestParam("sort") Integer sort) {
        // 创建 ProductCategoryAddDTO 对象
        ProductCategoryAddDTO productCategoryAddDTO = new ProductCategoryAddDTO().setPid(pid).setName(name)
                .setDescription(description).setPicUrl(picUrl).setSort(sort);
        // 创建商品分类
        ProductCategoryBO result = productCategoryService.addProductCategory(AdminSecurityContextHolder.getContext().getAdminId(), productCategoryAddDTO);
        // 返回结果
        return success(ProductCategoryConvert.Admins.INSTANCE.convert2(result));
    }

    @PostMapping("/update")
    @ApiOperation(value = "更新商品分类")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "分类编号", required = true, example = "1"),
            @ApiImplicitParam(name = "pid", value = "父级分类编号", required = true, example = "1"),
            @ApiImplicitParam(name = "name", value = "分类名字（标识）", required = true, example = "admin/info"),
            @ApiImplicitParam(name = "description", value = "描述", required = true, example = "1"),
            @ApiImplicitParam(name = "picUrl", value = "分类图片", example = "http://www.iocoder.cn/images/common/wechat_mp_2017_07_31_bak.jpg/"),
            @ApiImplicitParam(name = "sort", value = "排序", required = true, example = "1"),
    })
    public CommonResult<Boolean> update(@RequestParam("id") Integer id,
                                        @RequestParam("pid") Integer pid,
                                        @RequestParam("name") String name,
                                        @RequestParam("description") String description,
                                        @RequestParam(value = "picUrl", required = false) String picUrl,
                                        @RequestParam("sort") Integer sort) {
        // 创建 ProductCategoryUpdateDTO 对象
        ProductCategoryUpdateDTO productCategoryAddDTO = new ProductCategoryUpdateDTO().setId(id).setPid(pid).setName(name)
                .setDescription(description).setPicUrl(picUrl).setSort(sort);
        // 更新商品分类
        return success(productCategoryService.updateProductCategory(AdminSecurityContextHolder.getContext().getAdminId(), productCategoryAddDTO));
    }

    @PostMapping("/update_status")
    @ApiOperation(value = "更新商品分类状态")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "商品分类编号", required = true, example = "1"),
            @ApiImplicitParam(name = "status", value = "状态。1 - 开启；2 - 禁用", required = true, example = "1"),
    })
    public CommonResult<Boolean> updateStatus(@RequestParam("id") Integer id,
                                              @RequestParam("status") Integer status) {
        return success(productCategoryService.updateProductCategoryStatus(AdminSecurityContextHolder.getContext().getAdminId(), id, status));
    }

    @PostMapping("/delete")
    @ApiOperation(value = "删除商品分类")
    @ApiImplicitParam(name = "id", value = "商品分类编号", required = true, example = "1")
    public CommonResult<Boolean> delete(@RequestParam("id") Integer id) {
        return success(productCategoryService.deleteProductCategory(AdminSecurityContextHolder.getContext().getAdminId(), id));
    }

}
