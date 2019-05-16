package com.yijiupi.bi.service.db2.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.yijiupi.bi.entity.FrUrlentry;
import com.yijiupi.bi.mapper.FrUrlentryMapper;
import com.yijiupi.bi.service.db1.impl.BaseServiceImpl;
import com.yijiupi.bi.service.db2.FrUrlentryService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Decription:
 * @Author: Huang Yuansheng
 * @Date: Create in 17:43 2018/7/27 0027
 * @Email: huangyuansheng@yijiupi.cn
 **/
@Service
public class FrUrlentryServiceImpl extends BaseServiceImpl<FrUrlentryMapper, FrUrlentry> implements FrUrlentryService {
    @Override
    public FrUrlentry getUrlentryById(Long id) {
        EntityWrapper<FrUrlentry> wrapper = new EntityWrapper<>();
        wrapper.eq("id", id)
                .in("mobileDeviceConfig", new Integer[]{1, 3, 5, 7});
        List<FrUrlentry> urlEntries = super.baseMapper.selectList(wrapper);
        if (urlEntries.size() > 0) {
            return urlEntries.get(0);
        }
        return null;
    }
}
