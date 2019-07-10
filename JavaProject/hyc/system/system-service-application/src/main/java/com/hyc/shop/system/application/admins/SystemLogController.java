package com.hyc.shop.system.application.admins;


import com.hyc.shop.common.vo.CommonResult;
import com.hyc.shop.system.application.convert.AccessLogConvert;
import com.hyc.shop.system.application.vo.log.AccessLogPageVo;
import com.hyc.shop.system.bo.systemlog.AccessLogPageBO;
import com.hyc.shop.system.dto.systemlog.AccessLogPageDTO;
import com.hyc.shop.system.service.SystemLogService;
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

/**
 * @author:ycjx
 * @descriptio
 * @create:2019-06-23 16:42
 */
@RestController
@RequestMapping("admins/system/logs")
@Api("系统日志")
public class SystemLogController {

    @Reference(validation = "true", version = "${dubbo.provider.AdminAccessLogService.version}")
    private SystemLogService systemLogService;

    @GetMapping("access/page")
    @ApiOperation(value = "访问日志分页")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userId", value = "用户id", example = "1"),
            @ApiImplicitParam(name = "pageNo", value = "页码，从 1 开始", example = "1"),
            @ApiImplicitParam(name = "pageSize", value = "每页条数", required = true, example = "10"),
    })
    public CommonResult<AccessLogPageVo> page(@RequestParam(value = "userId", required = false) Integer userId,
                                              @RequestParam(value = "pageNo", defaultValue = "1") Integer pageNo,
                                              @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize) {


        AccessLogPageDTO accessLogPageDTO = new AccessLogPageDTO().setUserId(userId)
                .setPageNo(pageNo).setPageSize(pageSize);
        // 查询分页
        AccessLogPageBO result = systemLogService.getAccessLogPage(accessLogPageDTO);
        // 转换结果
        return success(AccessLogConvert.INSTANCE.convert(result));

    }


}
