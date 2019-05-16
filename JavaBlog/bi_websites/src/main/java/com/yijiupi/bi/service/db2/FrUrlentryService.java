package com.yijiupi.bi.service.db2;

import com.yijiupi.bi.entity.FrUrlentry;
import com.yijiupi.bi.service.db1.BaseService;

/**
 * @Decription:
 * @Author: Huang Yuansheng
 * @Date: Create in 17:42 2018/7/27 0027
 * @Email: huangyuansheng@yijiupi.cn
 **/
public interface FrUrlentryService extends BaseService<FrUrlentry> {

    /**
     * 通过id 获取Urlentry
     *
     * @param id
     * @return
     */
    FrUrlentry getUrlentryById(Long id);
}
