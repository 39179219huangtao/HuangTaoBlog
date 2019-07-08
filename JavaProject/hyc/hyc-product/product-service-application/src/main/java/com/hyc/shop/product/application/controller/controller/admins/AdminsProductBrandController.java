package com.hyc.shop.product.application.controller.controller.admins;


import com.hyc.shop.common.vo.CommonResult;
import com.hyc.shop.product.application.controller.vo.admins.AdminsProductBrandVO;
import com.hyc.shop.product.application.controller.vo.admins.AdminsProductBrangPageVO;
import com.hyc.shop.product.bo.ProductBrandBO;
import com.hyc.shop.product.bo.ProductBrangPageBO;
import com.hyc.shop.product.dto.ProductBrandAddDTO;
import com.hyc.shop.product.dto.ProductBrandPageDTO;
import com.hyc.shop.product.dto.ProductBrandUpdateDTO;
import com.hyc.shop.product.service.ProductBrandService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.*;
import com.hyc.shop.product.application.controller.convert.*;
import static com.hyc.shop.common.vo.CommonResult.success;
import com.hyc.shop.system.sdk.context.AdminSecurityContextHolder;
@RestController
@RequestMapping("admins/brand")
@Api("商品品牌")
public class AdminsProductBrandController {

    @Reference(validation = "true", version = "${dubbo.provider.ProductBrandService.version}")
    private ProductBrandService productBrandService;

    @PostMapping("/add")
    @ApiOperation("创建品牌")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "name", value = "品牌名称", required = true, example = "安踏"),
            @ApiImplicitParam(name = "description", value = "品牌描述", required = true, example = "安踏拖鞋"),
            @ApiImplicitParam(name = "picUrl", value = "品牌图片", required = true, example = "http://www.iocoder.cn"),
            @ApiImplicitParam(name = "status", value = "状态 1开启 2禁用", required = true, example = "1")
    })
    public CommonResult<AdminsProductBrandVO> add(@RequestParam("name") String name,
                                                  @RequestParam("description") String description,
                                                  @RequestParam("picUrl") String picUrl,
                                                  @RequestParam("status") Integer status) {
        // 创建 ProductBrandAddDTO 对象
        ProductBrandAddDTO productBrandAddDTO = new ProductBrandAddDTO().setName(name).setDescription(description)
                .setPicUrl(picUrl).setStatus(status);
        // 保存商品
        ProductBrandBO result = productBrandService.addProductBrand(AdminSecurityContextHolder.getContext().getAdminId(), productBrandAddDTO);
        // 返回结果
        return success(ProductBrandConvert.INSTANCE.convert(result));
    }

    @PostMapping("/update")
    @ApiOperation("更新商品")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "品牌主键", required = true, example = "1"),
            @ApiImplicitParam(name = "name", value = "品牌名称", required = true, example = "安踏"),
            @ApiImplicitParam(name = "description", value = "品牌描述", required = true, example = "安踏拖鞋"),
            @ApiImplicitParam(name = "picUrl", value = "品牌图片", required = true, example = "http://www.iocoder.cn"),
            @ApiImplicitParam(name = "status", value = "状态 1开启 2禁用", required = true, example = "1")
    })
    public CommonResult<Boolean> update(@RequestParam("id") Integer id,
                                        @RequestParam("name") String name,
                                        @RequestParam("description") String description,
                                        @RequestParam("picUrl") String picUrl,
                                        @RequestParam("status") Integer status) {
        // 创建 productBrandUpdateDTO 对象
        ProductBrandUpdateDTO productBrandUpdateDTO = new ProductBrandUpdateDTO().setId(id).setName(name).setDescription(description)
                .setPicUrl(picUrl).setStatus(status);
        // 更新商品
        productBrandService.updateProductBrand(AdminSecurityContextHolder.getContext().getAdminId(), productBrandUpdateDTO);
        return success(true);
    }

    @GetMapping("/get")
    @ApiOperation("获取品牌")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "品牌主键", required = true, example = "1")
    })
    public CommonResult<AdminsProductBrandVO> add(@RequestParam("id") Integer id) {
        // 保存商品
        ProductBrandBO result = productBrandService.getProductBrand(id);
        // 返回结果
        return success(ProductBrandConvert.INSTANCE.convert(result));
    }

    @GetMapping("/page")
    @ApiOperation("获得品牌分页")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "name", value = "品牌名称", required = true, example = "安踏"),
            @ApiImplicitParam(name = "description", value = "品牌描述", required = true, example = "安踏拖鞋"),
            @ApiImplicitParam(name = "status", value = "状态 1开启 2禁用", required = true, example = "1"),
            @ApiImplicitParam(name = "pageNo", value = "页码", required = true, example = "1"),
            @ApiImplicitParam(name = "pageSize", value = "页面大小", required = true, example = "10")
    })
    public CommonResult<AdminsProductBrangPageVO> attrPage(@RequestParam(value = "name", required = false) String name,
                                                           @RequestParam(value = "description", required = false) String description,
                                                           @RequestParam(value = "status", required = false) Integer status,
                                                           @RequestParam(value = "pageNo", defaultValue = "1") Integer pageNo,
                                                           @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize) {
        // 创建 ProductAttrPageDTO 对象
        ProductBrandPageDTO productBrandPageDTO = new ProductBrandPageDTO().setName(name)
                .setDescription(description)
                .setStatus(status)
                .setPageNo(pageNo)
                .setPageSize(pageSize);
        // 查询分页
        ProductBrangPageBO result = productBrandService.getProductBrandPage(productBrandPageDTO);
        // 返回结果
        return success(ProductBrandConvert.INSTANCE.convert(result));
    }


}
