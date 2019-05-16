package com.yijiupi.bi.service.db2.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.yijiupi.bi.entity.IconclsMenu;
import com.yijiupi.bi.mapper.IconclsMenuMapper;
import com.yijiupi.bi.service.db1.impl.BaseServiceImpl;
import com.yijiupi.bi.service.db2.IconClsMenuService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Decription:
 * @Author Huang Yuansheng
 * @Date Create in 11:22 2018/8/16
 * @Email: huangyuansheng@yijiupi.cn
 */
@Service
public class IconClsMenuServiceImpl extends BaseServiceImpl<IconclsMenuMapper, IconclsMenu> implements IconClsMenuService {

    @Override
    public IconclsMenu getByEntryId(Long entryId) {
        EntityWrapper<IconclsMenu> wrapper = new EntityWrapper<>();
        wrapper.eq("entryid", entryId);
        List<IconclsMenu> list = super.baseMapper.selectList(wrapper);
        if (list.size() > 0) {
            return list.get(0);
        }
        return null;
    }

    @Override
    public boolean upsertIconByEntryId(IconclsMenu iconclsMenu) {
        int result = super.baseMapper.upsertIconByEntryId(iconclsMenu);
        if (result != 0) {
            return true;
        }
        return false;
    }
}
