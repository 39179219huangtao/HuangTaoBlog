package com.yijiupi.bi.service.db2.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.yijiupi.bi.entity.FrCorep;
import com.yijiupi.bi.mapper.FrCorepMapper;
import com.yijiupi.bi.service.db1.impl.BaseServiceImpl;
import com.yijiupi.bi.service.db2.FrCorepService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Decription:
 * @Author Huang Yuansheng
 * @Date Create in 20:19 2018/8/7
 * @Email: huangyuansheng@yijiupi.cn
 */
@Service
public class FrCorepServiceImpl extends BaseServiceImpl<FrCorepMapper, FrCorep> implements FrCorepService {

    @Override
    public List<FrCorep> getAllCorepByRoleId(Long roleId) {
        EntityWrapper<FrCorep> wrapper = new EntityWrapper<>();
        wrapper.eq("roleid", roleId);
        return super.baseMapper.selectList(wrapper);
    }

    @Override
    public List<FrCorep> getAllDepartmentPostCorepByPostId(Long postId) {
        return super.baseMapper.getAllDepartmentPostCorepByPostId(postId);
    }
}
