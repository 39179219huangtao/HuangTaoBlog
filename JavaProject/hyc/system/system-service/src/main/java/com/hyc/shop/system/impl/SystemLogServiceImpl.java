package com.hyc.shop.system.impl;


import com.hyc.shop.common.util.StringUtil;
import com.hyc.shop.common.vo.PageResult;
import com.hyc.shop.system.bo.systemlog.AccessLogBO;
import com.hyc.shop.system.bo.systemlog.AccessLogPageBO;

import com.hyc.shop.system.domain.convert.AccessLogConvert;
import com.hyc.shop.system.domain.dao.AccessLogMapper;
import com.hyc.shop.system.domain.dao.ExceptionLogMapper;
import com.hyc.shop.system.domain.dataobject.AccessLogDO;
import com.hyc.shop.system.domain.dataobject.ExceptionLogDO;
import com.hyc.shop.system.dto.systemlog.AccessLogAddDTO;
import com.hyc.shop.system.dto.systemlog.AccessLogPageDTO;
import com.hyc.shop.system.dto.systemlog.ExceptionLogAddDTO;
import com.hyc.shop.system.service.SystemLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
@org.apache.dubbo.config.annotation.Service(validation = "true", version = "${dubbo.provider.AdminAccessLogService.version}")
public class SystemLogServiceImpl implements SystemLogService {

    /**
     * 请求参数最大长度。
     */
    private static final Integer QUERY_STRING_MAX_LENGTH = 4096;
    /**
     * 请求地址最大长度。
     */
    private static final Integer URI_MAX_LENGTH = 4096;
    /**
     * User-Agent 最大长度。
     */
    private static final Integer USER_AGENT_MAX_LENGTH = 1024;

    @Autowired
    private AccessLogMapper accessLogMapper;
    @Autowired
    private ExceptionLogMapper exceptionLogMapper;

    @Override
    @SuppressWarnings("Duplicates")
    public void addAccessLog(AccessLogAddDTO adminAccessLogAddDTO) {
        // 创建 AdminAccessLogDO
        AccessLogDO accessLog = AccessLogConvert.INSTANCE.convert(adminAccessLogAddDTO);
        accessLog.setCreateTime(new Date());
        // 截取最大长度
        if (accessLog.getUri().length() > URI_MAX_LENGTH) {
            accessLog.setUri(StringUtil.substring(accessLog.getUri(), URI_MAX_LENGTH));
        }
        if (accessLog.getQueryString().length() > QUERY_STRING_MAX_LENGTH) {
            accessLog.setQueryString(StringUtil.substring(accessLog.getQueryString(), QUERY_STRING_MAX_LENGTH));
        }
        if (accessLog.getUserAgent().length() > USER_AGENT_MAX_LENGTH) {
            accessLog.setUserAgent(StringUtil.substring(accessLog.getUserAgent(), USER_AGENT_MAX_LENGTH));
        }
        // 插入
        accessLogMapper.insert(accessLog);
    }

    @Override
    @SuppressWarnings("Duplicates")
    public void addExceptionLog(ExceptionLogAddDTO exceptionLogAddDTO) {
        // 创建 AdminAccessLogDO
        ExceptionLogDO exceptionLog = AccessLogConvert.INSTANCE.convert(exceptionLogAddDTO);
        exceptionLog.setCreateTime(new Date());
        // 截取最大长度
        if (exceptionLog.getUri().length() > URI_MAX_LENGTH) {
            exceptionLog.setUri(StringUtil.substring(exceptionLog.getUri(), URI_MAX_LENGTH));
        }
        if (exceptionLog.getQueryString().length() > QUERY_STRING_MAX_LENGTH) {
            exceptionLog.setQueryString(StringUtil.substring(exceptionLog.getQueryString(), QUERY_STRING_MAX_LENGTH));
        }
        if (exceptionLog.getUserAgent().length() > USER_AGENT_MAX_LENGTH) {
            exceptionLog.setUserAgent(StringUtil.substring(exceptionLog.getUserAgent(), USER_AGENT_MAX_LENGTH));
        }
        // 插入
        exceptionLogMapper.insert(exceptionLog);
    }

    @Override
    @SuppressWarnings("Duplicates")
    public AccessLogPageBO getAccessLogPage(AccessLogPageDTO accessLogPageDTO) {
        AccessLogPageBO accessLogPageBO = new AccessLogPageBO();
        PageResult<AccessLogBO> accessLogPageBOPageResult = AccessLogConvert.INSTANCE.convert(
                accessLogMapper.selectPage(accessLogPageDTO));
        accessLogPageBO.setList(accessLogPageBOPageResult.getList());
        accessLogPageBO.setTotal(accessLogPageBOPageResult.getTotal());
        return accessLogPageBO;
    }

}
