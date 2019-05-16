package com.yijiupi.bi.service.db2.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.yijiupi.bi.entity.FrReportletentry;
import com.yijiupi.bi.mapper.FrReportletentryMapper;
import com.yijiupi.bi.service.db1.impl.BaseServiceImpl;
import com.yijiupi.bi.service.db2.FrReportletentryService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Decription:
 * @Author: Huang Yuansheng
 * @Date: Create in 17:25 2018/7/27 0027
 * @Email: huangyuansheng@yijiupi.cn
 **/
@Service
public class FrReportletentryServiceImpl extends BaseServiceImpl<FrReportletentryMapper, FrReportletentry> implements FrReportletentryService {

    @Override
    public FrReportletentry getReportletentryById(Long id) {
        EntityWrapper<FrReportletentry> wrapper = new EntityWrapper<>();
        wrapper.eq("id", id)
                .in("mobileDeviceConfig", new Integer[]{1, 3, 5, 7});
        List<FrReportletentry> reportletentries = super.baseMapper.selectList(wrapper);
        if (reportletentries.size() > 0) {
            return reportletentries.get(0);
        }
        return null;
    }
}
