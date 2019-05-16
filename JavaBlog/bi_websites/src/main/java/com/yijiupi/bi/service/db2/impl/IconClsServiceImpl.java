package com.yijiupi.bi.service.db2.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.yijiupi.bi.entity.Iconcls;
import com.yijiupi.bi.mapper.IconclsMapper;
import com.yijiupi.bi.service.db1.impl.BaseServiceImpl;
import com.yijiupi.bi.service.db2.IconClsService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Decription:
 * @Author Huang Yuansheng
 * @Date Create in 11:19 2018/8/16
 * @Email: huangyuansheng@yijiupi.cn
 */
@Service
public class IconClsServiceImpl extends BaseServiceImpl<IconclsMapper, Iconcls> implements IconClsService {

    @Override
    public List<Iconcls> getAllIconCls() {
        EntityWrapper<Iconcls> wrapper = new EntityWrapper<>();
        return super.baseMapper.selectList(wrapper);
    }
}
