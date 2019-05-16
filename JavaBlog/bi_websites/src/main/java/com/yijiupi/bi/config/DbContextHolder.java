package com.yijiupi.bi.config;

import com.yijiupi.bi.constant.DBTypeEnum;

/**
 * @author huangtao
 * @Title: bi_websites
 * @Package com.yijiupi.bi.constant
 * @Description:
 * @date 2018/7/23  16:19
 */
public class DbContextHolder {
    private static final ThreadLocal contextHolder = new ThreadLocal<>();
    /**
     * 设置数据源
     * @param dbTypeEnum
     */
    public static void setDbType(DBTypeEnum dbTypeEnum) {
        contextHolder.set(dbTypeEnum.getValue());
    }

    /**
     * 取得当前数据源
     * @return
     */
    public static String getDbType() {
        return (String) contextHolder.get();
    }

    /**
     * 清除上下文数据
     */
    public static void clearDbType() {
        contextHolder.remove();
    }
}
