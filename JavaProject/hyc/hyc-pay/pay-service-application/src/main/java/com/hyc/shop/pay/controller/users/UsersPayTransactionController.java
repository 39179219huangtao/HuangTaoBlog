package com.hyc.shop.pay.controller.users;


import com.hyc.shop.admin.sdk.context.UserSecurityContextHolder;
import com.hyc.shop.common.util.HttpUtil;
import com.hyc.shop.common.vo.CommonResult;
import com.hyc.shop.pay.bo.transaction.PayTransactionBO;
import com.hyc.shop.pay.bo.transaction.PayTransactionSubmitBO;
import com.hyc.shop.pay.constant.PayChannelEnum;
import com.hyc.shop.pay.dto.transaction.PayTransactionGetDTO;
import com.hyc.shop.pay.dto.transaction.PayTransactionSubmitDTO;
import com.hyc.shop.pay.service.PayTransactionService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.dubbo.config.annotation.Reference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.IOException;

import static com.hyc.shop.common.vo.CommonResult.success;

@RestController
@RequestMapping("users/transaction")
@Api("【用户】支付交易 API")
public class UsersPayTransactionController {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Reference(validation = "true", version = "${dubbo.provider.PayTransactionService.version}")
    private PayTransactionService payTransactionService;

    @GetMapping("/get")
    @ApiOperation("获得支付交易")
    public CommonResult<PayTransactionBO> get(PayTransactionGetDTO payTransactionGetDTO) {
        payTransactionGetDTO.setUserId(UserSecurityContextHolder.getContext().getUserId());
        return success(payTransactionService.getTransaction(payTransactionGetDTO));
    }

    @PostMapping("/submit")
    @ApiOperation("提交支付交易")
    public CommonResult<PayTransactionSubmitBO> submit(HttpServletRequest request,
                                                       PayTransactionSubmitDTO payTransactionSubmitDTO) {
        payTransactionSubmitDTO.setCreateIp(HttpUtil.getIp(request));
        // 提交支付提交
        return success(payTransactionService.submitTransaction(payTransactionSubmitDTO));
    }

    @PostMapping(value = "pingxx_pay_success", consumes = MediaType.APPLICATION_JSON_VALUE)
//    @GetMapping(value = "pingxx_pay_success")
    public String pingxxPaySuccess(HttpServletRequest request) throws IOException {
        logger.info("[pingxxPaySuccess][被回调]");
        // 读取 webhook
        StringBuilder sb = new StringBuilder();
        try (BufferedReader reader = request.getReader()) {
            String line;
            while ((line = reader.readLine()) != null) {
                sb.append(line);
            }
        }

//        JSONObject bodyObj = JSON.parseObject(sb.toString());
//        bodyObj.put("webhookId", bodyObj.remove("id"));
//        String body = bodyObj.toString();
        payTransactionService.updateTransactionPaySuccess(PayChannelEnum.PINGXX.getId(), sb.toString());
        return "success";
    }

}
