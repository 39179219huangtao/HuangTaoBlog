package com.yijiupi.bi.config;

import com.yijiupi.bi.config.DbContextHolder;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 * @author huangtao
 * @Title: bi_websites
 * @Package com.yijiupi.bi.constant
 * @Description:
 * @date 2018/7/23  16:20
 */

public class DynamicDataSource extends AbstractRoutingDataSource {
    /**
     * 取得当前使用哪个数据源
     * @return
     */
    @Override
    protected Object determineCurrentLookupKey() {
        return DbContextHolder.getDbType();
    }
}