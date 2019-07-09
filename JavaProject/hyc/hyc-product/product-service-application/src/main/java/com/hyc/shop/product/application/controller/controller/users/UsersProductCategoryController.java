package com.hyc.shop.product.application.controller.controller.users;


import com.hyc.shop.common.vo.CommonResult;
import com.hyc.shop.product.application.controller.convert.ProductCategoryConvert;
import com.hyc.shop.product.application.controller.vo.users.UsersProductCategoryVO;
import com.hyc.shop.product.bo.ProductCategoryBO;
import com.hyc.shop.product.service.ProductCategoryService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("users/category")
@Api("商品分类")
public class UsersProductCategoryController {

    @Reference(validation = "true", version = "${dubbo.provider.ProductCategoryService.version}")
    private ProductCategoryService productCategoryService;

    @GetMapping("/list")
    @ApiOperation("获得指定编号下的子分类的数组")
    @ApiImplicitParam(name = "pid", value = "指定分类编号", required = true, example = "0")
    public CommonResult<List<UsersProductCategoryVO>> list(@RequestParam("pid") Integer pid) {
        List<ProductCategoryBO> result = productCategoryService.getListByPid(pid);
        return CommonResult.success(ProductCategoryConvert.Users.INSTANCE.convertToVO(result));
    }

}
