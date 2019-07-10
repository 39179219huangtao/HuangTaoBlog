package com.hyc.shop.system.application.admins;


import com.hyc.shop.common.vo.CommonResult;
import com.hyc.shop.system.bo.sms.PageSmsSignBO;
import com.hyc.shop.system.dto.sms.PageQuerySmsSignDTO;
import com.hyc.shop.system.service.SmsService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * 短信服务
 *
 * @author Sin
 * @time 2019/5/26 12:26 PM
 */
@RestController
@RequestMapping("admins/sms/sign")
@Api("短信服务(签名)")
public class SmsSignController {

    @Reference(validation = "true", version = "${dubbo.provider.SmsService.version}")
    private SmsService smsService;

    @GetMapping("page")
    @ApiOperation("签名-page")
    public CommonResult<PageSmsSignBO> pageSign(@Validated PageQuerySmsSignDTO querySmsSignDTO) {
        return CommonResult.success(smsService.pageSmsSign(querySmsSignDTO));
    }

    @PostMapping("add")
    @ApiOperation("签名-添加")
    public CommonResult addSign(@RequestParam("sign") String sign,
                        @RequestParam("platform") Integer platform) {
        smsService.addSign(sign, platform);
        return CommonResult.success(null);
    }

    @PutMapping("update")
    @ApiOperation("签名-更新")
    public CommonResult updateSign(@RequestParam("id") Integer id,
                                           @RequestParam("sign") String sign,
                                           @RequestParam("platform") Integer platform) {
        smsService.updateSign(id, sign, platform);
        return CommonResult.success(null);
    }

    @DeleteMapping("deleted")
    @ApiOperation("签名-删除")
    public CommonResult deletedSign(@RequestParam("id") Integer id) {
        smsService.deleteSign(id);
        return CommonResult.success(null);
    }
}
