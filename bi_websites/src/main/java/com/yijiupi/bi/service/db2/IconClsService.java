package com.yijiupi.bi.service.db2;

import com.yijiupi.bi.entity.Iconcls;
import com.yijiupi.bi.service.db1.BaseService;

import java.util.List;

/**
 * @Decription:
 * @Author Huang Yuansheng
 * @Date Create in 11:14 2018/8/16
 * @Email: huangyuansheng@yijiupi.cn
 */
public interface IconClsService extends BaseService<Iconcls> {

    List<Iconcls> getAllIconCls();
}
