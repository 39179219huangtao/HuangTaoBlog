package com.yijiupi.bi.service.db2;

import com.yijiupi.bi.entity.FrReportletentry;
import com.yijiupi.bi.service.db1.BaseService;

/**
 * @Decription:
 * @Author: Huang Yuansheng
 * @Date: Create in 17:23 2018/7/27 0027
 * @Email: huangyuansheng@yijiupi.cn
 **/
public interface FrReportletentryService extends BaseService<FrReportletentry> {

    /**
     * 通过id获取FrReportletentry
     *
     * @param id
     * @return
     */
    FrReportletentry getReportletentryById(Long id);
}
