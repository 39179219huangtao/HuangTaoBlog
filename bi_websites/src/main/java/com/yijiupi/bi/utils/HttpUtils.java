package com.yijiupi.bi.utils;

import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Maps;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.ParseException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.apache.http.Header;

/**
 * @author huangtao
 * @Title: HttpUtils.java
 * @Package
 * @date 2018/7/24 11:13
 */
public final class HttpUtils {
    private static Logger logger = LoggerFactory.getLogger(HttpUtils.class);
    public static final String UTF8 = "UTF-8";
    public static final String GBK = "GBK";
    private static final String EMPTY = "";

    private HttpUtils() {
        throw new RuntimeException("��ֹʵ����");
    }

    public final static Map<String, Object> post(String url) {
        Map<String, Object> resultMap = Maps.newHashMap();
        CloseableHttpClient httpclient = null;
        try {
            httpclient = HttpClients.createDefault();
            HttpPost httppost = new HttpPost(url);
            CloseableHttpResponse response = httpclient.execute(httppost);
            try {
                HttpEntity entity = response.getEntity();
                if (entity != null) {
                    String postContent = EntityUtils.toString(entity, "utf-8");
                    resultMap = JSONObject.parseObject(postContent);
                }
            } finally {
                response.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resultMap;
    }


    public static String postForm(String url, List<NameValuePair> formparams, String encodeCharset) {

        String postFormContent = EMPTY;
        CloseableHttpClient httpclient = HttpClients.createDefault();
        HttpPost httppost = new HttpPost(url);

        UrlEncodedFormEntity uefEntity;
        try {
            uefEntity = new UrlEncodedFormEntity(formparams, encodeCharset);
            httppost.setEntity(uefEntity);
            System.out.println("executing request " + httppost.getURI());
            CloseableHttpResponse response = httpclient.execute(httppost);
            try {
                HttpEntity entity = response.getEntity();
                if (null != entity) {
                    postFormContent = EntityUtils.toString(entity, encodeCharset);
                }
            } finally {
                response.close();
            }
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e1) {
            e1.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // �ر�����,�ͷ���Դ
            try {
                httpclient.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return postFormContent;
    }

    public static String postForm(String url, List<NameValuePair> formparams, String username, String encodeCharset) {
        String postFormContent = EMPTY;
        CloseableHttpClient httpclient = HttpClients.createDefault();
        HttpPost httppost = new HttpPost(url);
        httppost.setHeader("Cookie", "username=" + username);

        UrlEncodedFormEntity uefEntity;
        try {
            uefEntity = new UrlEncodedFormEntity(formparams, encodeCharset);
            httppost.setEntity(uefEntity);
            System.out.println("executing request " + httppost.getURI());
            CloseableHttpResponse response = httpclient.execute(httppost);
            try {
                HttpEntity entity = response.getEntity();
                if (null != entity) {
                    postFormContent = EntityUtils.toString(entity, encodeCharset);
                }
            } finally {
                response.close();
            }
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e1) {
            e1.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // �ر�����,�ͷ���Դ
            try {
                httpclient.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return postFormContent;
    }


    public static String post(String url, List<NameValuePair> formparams, String encodeCharset) {
        String postContent = EMPTY;
        CloseableHttpClient httpclient = HttpClients.createDefault();
        HttpPost httppost = new HttpPost(url);
        UrlEncodedFormEntity uefEntity;
        try {
            uefEntity = new UrlEncodedFormEntity(formparams, encodeCharset);
            httppost.setEntity(uefEntity);
            CloseableHttpResponse response = httpclient.execute(httppost);
            try {
                HttpEntity entity = response.getEntity();
                if (entity != null) {
                    postContent = EntityUtils.toString(entity, encodeCharset);
                }
            } finally {
                response.close();
            }
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e1) {
            e1.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                httpclient.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return postContent;

    }

    public static String post(String userName, String url, List<NameValuePair> formparams, String encodeCharset) {
        String postContent = EMPTY;
        CloseableHttpClient httpclient = HttpClients.createDefault();
        HttpPost httppost = new HttpPost(url);
        httppost.setHeader("Cookie", "username=" + userName);
        UrlEncodedFormEntity uefEntity;
        try {
            uefEntity = new UrlEncodedFormEntity(formparams, encodeCharset);
            httppost.setEntity(uefEntity);
            CloseableHttpResponse response = httpclient.execute(httppost);
            try {
                HttpEntity entity = response.getEntity();
                if (entity != null) {
                    postContent = EntityUtils.toString(entity, encodeCharset);
                }
            } finally {
                response.close();
            }
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e1) {
            e1.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // �ر�����,�ͷ���Դ
            try {
                httpclient.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return postContent;

    }


    public static String resetCache(String url, String adminPassword) {
        String getContent = EMPTY;
        CloseableHttpClient httpclient = HttpClients.createDefault();
        try {
            // 模拟用admin登录
            HttpGet httpget = new HttpGet(url + "?op=fs_load&cmd=sso&fr_username=admin&fr_password=" + adminPassword);
            CloseableHttpResponse response = httpclient.execute(httpget);
            try {
                HttpEntity entity = response.getEntity();


                Header[] headers = response.getHeaders("Set-Cookie");
                String cookieValue = "";
                for (Header header : headers) {
                    cookieValue += header.getValue();
                }
                //发送清除缓存方法
                String byCookie = getByCookie(cookieValue, url + "?op=fs_main&cmd=reset_cache");
                logger.info("清除缓存：" + byCookie);
            } finally {
                response.close();
            }
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // �ر�����,�ͷ���Դ
            try {
                httpclient.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return getContent;
    }

    public static String getByCookie(String cookieValue, String url) {
        String getContent = EMPTY;
        CloseableHttpClient httpclient = HttpClients.createDefault();
        try {
            HttpGet httpget = new HttpGet(assembleUrl(url));
            httpget.setHeader("Cookie", cookieValue);
            CloseableHttpResponse response = httpclient.execute(httpget);
            try {
                // ��ȡ��Ӧʵ��
                HttpEntity entity = response.getEntity();
                if (entity != null) {
                    getContent = EntityUtils.toString(entity);// ��Ӧ����
                }
            } finally {
                response.close();
            }
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // �ر�����,�ͷ���Դ
            try {
                httpclient.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return getContent;
    }

    public static String get(String userName, String type, String url) {
        String getContent = EMPTY;
        CloseableHttpClient httpclient = HttpClients.createDefault();
        try {
            HttpGet httpget = new HttpGet(assembleUrl(url));
            httpget.setHeader("Cookie", "username=" + userName);
            CloseableHttpResponse response = httpclient.execute(httpget);
            try {
                // ��ȡ��Ӧʵ��
                HttpEntity entity = response.getEntity();
                if (entity != null) {
                    getContent = EntityUtils.toString(entity);// ��Ӧ����
                }
            } finally {
                response.close();
            }
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // �ر�����,�ͷ���Դ
            try {
                httpclient.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return getContent;
    }

    public static String assembleUrl(String url) {
        int flag = url.indexOf("?");
        if (flag > 1) {
            url = url + "&ic_system_type=";
        } else {
            url = url + "?ic_system_type=";
        }
        return url;
    }

    public static byte[] getByte(String userName, String url) {
        byte[] getContent = null;
        CloseableHttpClient httpclient = HttpClients.createDefault();
        try {
            // 创建HttpGet
            HttpGet httpget = new HttpGet(assembleUrl(url));
            httpget.setHeader("Cookie", "username=" + userName);
            // 执行get请求.
            CloseableHttpResponse response = httpclient.execute(httpget);
            try {
                // 获取响应实体
                HttpEntity entity = response.getEntity();
                if (entity != null) {
                    getContent = EntityUtils.toByteArray(entity);// 响应内容
                }
            } finally {
                response.close();
            }
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // 关闭连接,释放资源
            try {
                httpclient.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return getContent;
    }
}
