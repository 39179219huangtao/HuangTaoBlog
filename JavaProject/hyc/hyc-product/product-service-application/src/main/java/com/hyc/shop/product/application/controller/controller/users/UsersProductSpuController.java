package com.hyc.shop.product.application.controller.controller.users;


import com.hyc.shop.common.vo.CommonResult;
import com.hyc.shop.product.application.controller.convert.ProductSpuConvert;
import com.hyc.shop.product.application.controller.vo.users.UsersProductSpuDetailVO;
import com.hyc.shop.product.application.controller.vo.users.UsersProductSpuPageVO;
import com.hyc.shop.product.bo.ProductSpuPageBO;
import com.hyc.shop.product.dto.ProductSpuPageDTO;
import com.hyc.shop.product.service.ProductSpuService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import static com.hyc.shop.common.vo.CommonResult.success;

@RestController
@RequestMapping("users/spu")
@Api("商品 SPU + SKU")
public class UsersProductSpuController {

    @Reference(validation = "true", version = "${dubbo.provider.ProductSpuService.version}")
    private ProductSpuService productSpuService;

    @GetMapping("/info")
    @ApiOperation("商品 SPU 明细")
    @ApiImplicitParam(name = "id", value = "SPU 编号", required = true, example = "100")
    public CommonResult<UsersProductSpuDetailVO> info(@RequestParam("id") Integer id) {
        return success(ProductSpuConvert.INSTANCE.convert4(productSpuService.getProductSpuDetail(id)));
    }

    @GetMapping("/page")
    @ApiOperation("商品 SPU 分页列表")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "cid", value = "分类编号", example = "1"),
            @ApiImplicitParam(name = "pageNo", value = "页码，从 1 开始", example = "1"),
            @ApiImplicitParam(name = "pageSize", value = "每页条数", required = true, example = "10"),
    })
    @Deprecated // 使用商品搜索接口
    public CommonResult<UsersProductSpuPageVO> page(@RequestParam(value = "cid", required = false) Integer cid,
                                                    @RequestParam(value = "pageNo", defaultValue = "0") Integer pageNo,
                                                    @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize) {
        // 创建 ProductSpuPageDTO 对象
        ProductSpuPageDTO productSpuPageDTO = new ProductSpuPageDTO().setCid(cid).setVisible(true)
                .setPageNo(pageNo).setPageSize(pageSize);
        // 查询分页
        ProductSpuPageBO result = productSpuService.getProductSpuPage(productSpuPageDTO);
        // 返回结果
        return success(ProductSpuConvert.INSTANCE.convert3(result));
    }

}
