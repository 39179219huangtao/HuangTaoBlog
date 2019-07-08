package com.hyc.shop.system.service;


import com.hyc.shop.system.bo.systemlog.AccessLogPageBO;
import com.hyc.shop.system.dto.systemlog.AccessLogAddDTO;
import com.hyc.shop.system.dto.systemlog.AccessLogPageDTO;
import com.hyc.shop.system.dto.systemlog.ExceptionLogAddDTO;

/**
 * 系统日志 Service 接口
 *
 * 例如说，访问日志、错误日志、操作日志等等
 */
public interface SystemLogService {

    void addAccessLog(AccessLogAddDTO accessLogAddDTO);

    void addExceptionLog(ExceptionLogAddDTO exceptionLogAddDTO);

    AccessLogPageBO getAccessLogPage(AccessLogPageDTO accessLogPageDTO);
}
