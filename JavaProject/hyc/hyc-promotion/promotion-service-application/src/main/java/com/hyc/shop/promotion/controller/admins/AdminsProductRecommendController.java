package com.hyc.shop.promotion.controller.admins;


import com.hyc.shop.common.vo.CommonResult;
import com.hyc.shop.product.bo.ProductSpuBO;
import com.hyc.shop.product.service.ProductSpuService;
import com.hyc.shop.promotion.ProductRecommendService;
import com.hyc.shop.promotion.bo.ProductRecommendBO;
import com.hyc.shop.promotion.bo.ProductRecommendPageBO;
import com.hyc.shop.promotion.convert.ProductRecommendConvert;
import com.hyc.shop.promotion.dto.ProductRecommendAddDTO;
import com.hyc.shop.promotion.dto.ProductRecommendPageDTO;
import com.hyc.shop.promotion.dto.ProductRecommendUpdateDTO;
import com.hyc.shop.promotion.vo.admins.AdminsProductRecommendPageVO;
import com.hyc.shop.promotion.vo.admins.AdminsProductRecommendVO;
import com.hyc.shop.system.sdk.context.AdminSecurityContextHolder;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


import static com.hyc.shop.common.vo.CommonResult.success;

@RestController
@RequestMapping("admins/product_recommend")
@Api("商品推荐模块")
public class AdminsProductRecommendController {

    @Reference(validation = "true", version = "${dubbo.provider.ProductRecommendService.version}")
    private ProductRecommendService productRecommendService;
    @Reference(validation = "true", version = "${dubbo.consumer.ProductSpuService.version}")
    private ProductSpuService productSpuService;

    @GetMapping("/page")
    @ApiOperation(value = "商品推荐分页")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "type", value = "推荐类型", example = "1"),
            @ApiImplicitParam(name = "pageNo", value = "页码，从 1 开始", example = "1"),
            @ApiImplicitParam(name = "pageSize", value = "每页条数", required = true, example = "10"),
    })
    public CommonResult<AdminsProductRecommendPageVO> page(@RequestParam(value = "type", required = false) Integer type,
                                                           @RequestParam(value = "pageNo", defaultValue = "1") Integer pageNo,
                                                           @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize) {
        ProductRecommendPageBO result = productRecommendService.getProductRecommendPage(new ProductRecommendPageDTO().setType(type).setPageNo(pageNo).setPageSize(pageSize));
        // 获得商品集合
        List<ProductSpuBO> spus = productSpuService.getProductSpuList(
                result.getList().stream().map(ProductRecommendBO::getProductSpuId).collect(Collectors.toSet()));
        Map<Integer, ProductSpuBO> spuMap = spus.stream().collect(Collectors.toMap(ProductSpuBO::getId, account -> account));
        // 拼装结果
        AdminsProductRecommendPageVO response = ProductRecommendConvert.INSTANCE.convert(result);
        response.getList().forEach(recommendVO -> recommendVO.setProductSpuName(spuMap.get(recommendVO.getProductSpuId()).getName()));
        return CommonResult.success(response);
    }

    @PostMapping("/add")
    @ApiOperation(value = "创建商品推荐")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "type", value = "推荐类型", required = true, example = "1"),
            @ApiImplicitParam(name = "productSpuId", value = "商品编号", required = true, example = "1"),
            @ApiImplicitParam(name = "sort", value = "排序", required = true, example = "10"),
            @ApiImplicitParam(name = "memo", value = "备注", example = "活动很牛逼"),
    })
    public CommonResult<AdminsProductRecommendVO> add(@RequestParam("type") Integer type,
                                                      @RequestParam("productSpuId") Integer productSpuId,
                                                      @RequestParam("sort") Integer sort,
                                                      @RequestParam(value = "memo", required = false) String memo) {
        ProductRecommendAddDTO bannerAddDTO = new ProductRecommendAddDTO().setType(type).setProductSpuId(productSpuId)
                .setSort(sort).setMemo(memo);
        return success(ProductRecommendConvert.INSTANCE.convert(productRecommendService.addProductRecommend(AdminSecurityContextHolder.getContext().getAdminId(), bannerAddDTO)));
    }

    @PostMapping("/update")
    @ApiOperation(value = "更新商品推荐")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "商品推荐编号", required = true, example = "1"),
            @ApiImplicitParam(name = "type", value = "推荐类型", required = true, example = "1"),
            @ApiImplicitParam(name = "productSpuId", value = "商品编号", required = true, example = "1"),
            @ApiImplicitParam(name = "sort", value = "排序", required = true, example = "10"),
            @ApiImplicitParam(name = "memo", value = "备注", example = "活动很牛逼"),
    })
    public CommonResult<Boolean> update(@RequestParam("id") Integer id,
                                        @RequestParam("type") Integer type,
                                        @RequestParam("productSpuId") Integer productSpuId,
                                        @RequestParam("sort") Integer sort,
                                        @RequestParam(value = "memo", required = false) String memo) {
        ProductRecommendUpdateDTO bannerUpdateDTO = new ProductRecommendUpdateDTO().setId(id).setType(type).setProductSpuId(productSpuId)
                .setSort(sort).setMemo(memo);
        return success(productRecommendService.updateProductRecommend(AdminSecurityContextHolder.getContext().getAdminId(), bannerUpdateDTO));
    }

    @PostMapping("/update_status")
    @ApiOperation(value = "更新商品推荐状态")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "商品推荐编号", required = true, example = "1"),
            @ApiImplicitParam(name = "status", value = "状态。1 - 开启；2 - 禁用", required = true, example = "1"),
    })
    public CommonResult<Boolean> updateStatus(@RequestParam("id") Integer id,
                                              @RequestParam("status") Integer status) {
        return success(productRecommendService.updateProductRecommendStatus(AdminSecurityContextHolder.getContext().getAdminId(), id, status));
    }

    @PostMapping("/delete")
    @ApiOperation(value = "删除商品推荐")
    @ApiImplicitParam(name = "id", value = "商品推荐编号", required = true, example = "1")
    public CommonResult<Boolean> delete(@RequestParam("id") Integer id) {
        return success(productRecommendService.deleteProductRecommend(AdminSecurityContextHolder.getContext().getAdminId(), id));
    }

}
