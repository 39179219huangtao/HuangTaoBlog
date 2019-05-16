package com.yijiupi.bi.service.db2.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.yijiupi.bi.entity.FrTUep;
import com.yijiupi.bi.mapper.FrTUepMapper;
import com.yijiupi.bi.service.db1.impl.BaseServiceImpl;
import com.yijiupi.bi.service.db2.FrUepService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Decription:
 * @Author Huang Yuansheng
 * @Date Create in 10:27 2018/8/8
 * @Email: huangyuansheng@yijiupi.cn
 */
@Service
public class FrUepServiceImpl extends BaseServiceImpl<FrTUepMapper, FrTUep> implements FrUepService {
    @Override
    public List<FrTUep> getAllUepByUserId(Long userId) {
        EntityWrapper<FrTUep> wrapper = new EntityWrapper<>();
        wrapper.eq("userid", userId);
        return super.baseMapper.selectList(wrapper);
    }
}
