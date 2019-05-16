/**
 * Copyright © 2017 北京易酒批电子商务有限公司. All rights reserved.
 */
package com.yijiupi.bi.utils;

import com.alibaba.fastjson.JSON;
import org.apache.commons.collections.MapUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Map;

/**
 * Created by hukaiyang on 2017/10/24.
 */

@Component
public class HttpClientService {
    private static final Logger LOG = LoggerFactory.getLogger(HttpClientService.class);

    @Autowired
    private RestTemplate restTemplate;

    public <T> T doPost(final String uri, final Map<String, Object> params, Class<T> cls) {
        if (LOG.isInfoEnabled()) {
            LOG.debug("请求 URL：" + uri);
            LOG.debug("请求参数：" + JSON.toJSONString(params));
        }
        final HttpHeaders headers = new HttpHeaders();
        headers.add(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_UTF8_VALUE);
        final HttpEntity<Map<String, Object>> entity = new HttpEntity<>(params, headers);
        return restTemplate.postForObject(uri, entity, cls);
    }

    public <T> T doPost(final String uri, final Object params, Class<T> cls) {
        if (LOG.isInfoEnabled()) {
            LOG.debug("请求 URL：" + uri);
            LOG.debug("请求参数：" + JSON.toJSONString(params));
        }
        final HttpHeaders headers = new HttpHeaders();
        headers.add(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_UTF8_VALUE);
        final HttpEntity<Object> entity = new HttpEntity<>(params, headers);
        return restTemplate.postForObject(uri, entity, cls);
    }

    public <T> T doGet(final String uri, final Map<String, Object> params, Class<T> cls) {
        final StringBuilder uriBuilder = new StringBuilder(uri);
        if (!uri.contains("?")) {
            uriBuilder.append("?");
        }
        uriBuilder.append("t=").append(System.currentTimeMillis());
        if (MapUtils.isNotEmpty(params)) {
            params.forEach((key, value) -> {
                uriBuilder.append("&");
                uriBuilder.append(key).append("=");
                try {
                    uriBuilder.append(URLEncoder.encode(String.valueOf(value), "UTF-8"));
                } catch (UnsupportedEncodingException e) {
                    LOG.info(e.getCause().getMessage());
                }
            });
        }

        if (LOG.isInfoEnabled()) {
            LOG.debug("请求 URL：" + uriBuilder.toString());
        }
        return restTemplate.getForObject(uriBuilder.toString(), cls);
    }

    public <T> T doGet(final String uri, String param, Class<T> cls) {
        final String url = uri + "/" + param;
        if (LOG.isInfoEnabled()) {
            LOG.debug("请求 URL：" + url);
        }
        return restTemplate.getForObject(url, cls);
    }

    public <T> T doGet(final String uri, Class<T> cls) {
        if (LOG.isInfoEnabled()) {
            LOG.debug("请求 URL：" + uri);
        }
        return restTemplate.getForObject(uri, cls);
    }
}
