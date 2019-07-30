package com.hyc.shop.promotion.controller.users;


import com.hyc.shop.admin.sdk.context.UserSecurityContextHolder;
import com.hyc.shop.common.vo.CommonResult;
import com.hyc.shop.promotion.CouponService;
import com.hyc.shop.promotion.bo.CouponCardBO;
import com.hyc.shop.promotion.bo.CouponCardPageBO;
import com.hyc.shop.promotion.bo.CouponTemplateBO;
import com.hyc.shop.promotion.convert.CouponCardConvert;
import com.hyc.shop.promotion.convert.CouponTemplateConvert;
import com.hyc.shop.promotion.dto.CouponCardPageDTO;
import com.hyc.shop.promotion.vo.users.UsersCouponCardPageVO;
import com.hyc.shop.promotion.vo.users.UsersCouponCardVO;
import com.hyc.shop.promotion.vo.users.UsersCouponTemplateVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.*;

import static com.hyc.shop.common.vo.CommonResult.success;

@RestController
@RequestMapping("users/coupon")
@Api("优惠劵（码）模块")
public class UsersCouponController {

    @Reference(validation = "true", version = "${dubbo.provider.CouponService.version}")
    private CouponService couponService;

    // ========== 优惠劵（码）模板 ==========

    @GetMapping("/template/get")
    @ApiOperation(value = "优惠劵（码）模板信息")
    @ApiImplicitParam(name = "id", value = "优惠劵（码）模板编号", required = true, example = "10")
    public CommonResult<UsersCouponTemplateVO> templateGet(@RequestParam("id") Integer id) {
        CouponTemplateBO template = couponService.getCouponTemplate(id);
        return success(CouponTemplateConvert.USERS.convert2(template));
    }

    // ========== 优惠劵 ==========

    @GetMapping("/card/page")
    @ApiOperation(value = "优惠劵分页")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "status", value = "状态", example = "参考 CouponCardStatusEnum 枚举"),
            @ApiImplicitParam(name = "pageNo", value = "页码，从 1 开始", example = "1"),
            @ApiImplicitParam(name = "pageSize", value = "每页条数", required = true, example = "10"),
    })
    public CommonResult<UsersCouponCardPageVO> cardPage(@RequestParam(value = "status", required = false) Integer status,
                                                        @RequestParam(value = "pageNo", defaultValue = "0") Integer pageNo,
                                                        @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize) {
        CouponCardPageBO result = couponService.getCouponCardPage(new CouponCardPageDTO()
                .setStatus(status).setUserId(UserSecurityContextHolder.getContext().getUserId())
                .setPageNo(pageNo).setPageSize(pageSize));
        return success(CouponCardConvert.INSTANCE.convert2(result));
    }

    @PostMapping("/card/add")
    @ApiOperation(value = "领取优惠劵")
    @ApiImplicitParam(name = "templateId", value = "优惠劵（码）模板编号", required = true, example = "10")
    public CommonResult<UsersCouponCardVO> cardAdd(@RequestParam("templateId") Integer templateId) {
        CouponCardBO result = couponService.addCouponCard(UserSecurityContextHolder.getContext().getUserId(), templateId);
        return success(CouponCardConvert.INSTANCE.convert(result));
    }

    // ========== 优惠码 ==========


}
