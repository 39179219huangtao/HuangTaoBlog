package com.yijiupi.bi.service.db2;

import com.yijiupi.bi.entity.FrTUep;
import com.yijiupi.bi.service.db1.BaseService;

import java.util.List;

/**
 * @Decription:
 * @Author Huang Yuansheng
 * @Date Create in 10:25 2018/8/8
 * @Email: huangyuansheng@yijiupi.cn
 */
public interface FrUepService extends BaseService<FrTUep> {

    List<FrTUep> getAllUepByUserId(Long userId);
}
