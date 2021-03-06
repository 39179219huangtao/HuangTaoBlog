package com.hyc.shop.product.application.controller.controller.users;


import com.hyc.shop.common.vo.CommonResult;
import com.hyc.shop.product.service.ProductSpuCollectionService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.hyc.shop.common.vo.CommonResult.success;

/**
 * 商品收藏接口
 * @author xiaofeng
 * @date 2019/07/01 23:21
 * @version 1.0
 */
@RestController
@RequestMapping("users/spu")
@Api("商品收藏")
public class UsersProductSpuCollectionController {

    @Reference(validation = "true", version = "${dubbo.provider.ProductSpuCollectionService.version}")
    private ProductSpuCollectionService productSpuCollectionService;

    @PostMapping("/collection/{spuId}/{hasCollectionType}")
    @ApiOperation("商品收藏")
//    @RequiresLogin
    public CommonResult<Boolean> productSpuCollection(@PathVariable("spuId") Integer spuId,
                                                      @PathVariable("hasCollectionType") Integer hasCollectionType) {
//        final Integer userId = UserSecurityContextHolder.getContext().getUserId();

        return success(productSpuCollectionService.productSpuCollection(spuId, hasCollectionType,140));
    }
}
