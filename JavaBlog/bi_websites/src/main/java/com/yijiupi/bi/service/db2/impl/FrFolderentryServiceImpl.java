package com.yijiupi.bi.service.db2.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.yijiupi.bi.entity.FrFolderMenu;
import com.yijiupi.bi.entity.FrFolderentry;
import com.yijiupi.bi.mapper.FrFolderentryMapper;
import com.yijiupi.bi.service.db1.impl.BaseServiceImpl;
import com.yijiupi.bi.service.db2.FrFolderentryService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Decription:
 * @Author: Huang Yuansheng
 * @Date: Create in 17:58 2018/7/27 0027
 * @Email: huangyuansheng@yijiupi.cn
 **/
@Service
public class FrFolderentryServiceImpl extends BaseServiceImpl<FrFolderentryMapper, FrFolderentry> implements FrFolderentryService {
    @Override
    public FrFolderentry getFolderentryById(Integer id) {
        EntityWrapper<FrFolderentry> wrapper = new EntityWrapper<>();
        wrapper.eq("id", id)
                .in("mobileDeviceConfig", new Integer[]{1, 3, 5, 7});
        List<FrFolderentry> folderentries = super.baseMapper.selectList(wrapper);
        if (folderentries.size() > 0) {
            return folderentries.get(0);
        }
        return null;
    }

    @Override
    public List<FrFolderMenu> loadAllMenu() {
        return super.baseMapper.loadAllMenu();
    }
}
