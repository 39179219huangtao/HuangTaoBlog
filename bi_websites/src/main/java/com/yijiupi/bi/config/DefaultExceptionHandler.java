/*
 * Copyright © 2016 北京易酒批电子商务有限公司. All rights reserved.
 */

package com.yijiupi.bi.config;


import com.baomidou.mybatisplus.toolkit.StringUtils;
import com.yijiupi.bi.utils.BaseResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;


@ControllerAdvice
public class DefaultExceptionHandler {

    private static final Logger LOG = LoggerFactory.getLogger(DefaultExceptionHandler.class);

    @ExceptionHandler({Exception.class})
    @ResponseBody
    public BaseResult processUnauthenticatedException(HttpServletRequest request, Exception exception) {
        String servletPath = request.getServletPath(); // 获取请求的URL
        BaseResult failedResult = null;
        String message = getFinalMessage(exception);
        String msg = "请求URL：" + servletPath + "，发生错误：" + message;

        LOG.error(msg, exception);
        failedResult = new BaseResult("运行异常，请联系运维人员！" + getTruncateMessage(message), exception);

        return failedResult;
    }

    /**
     * 获取最末层的异常提示信息
     *
     * @param exception 异常
     * @return 最末层的异常提示信息
     */
    private String getFinalMessage(Exception exception) {
        String message = exception.getMessage();
        Throwable cause = exception.getCause();
        //循环3层获取到异常提示信息
        int i = 0;
        while (null != cause && i < 3) {
            message = cause.getMessage();
            cause = cause.getCause();
            i++;
        }
        return message;
    }

    /**
     * 超过500长度截断返回消息
     *
     * @param message
     * @return String
     */
    private String getTruncateMessage(String message) {
        String truncateMessage = message;
        if (StringUtils.isNotEmpty(message) && message.length() > 500) {
            truncateMessage = message.substring(0, 499);
            truncateMessage = truncateMessage + "...";
        }
        return truncateMessage;
    }

}
