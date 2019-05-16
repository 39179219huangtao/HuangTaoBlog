package com.yijiupi.bi.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.yijiupi.bi.entity.IconclsMenu;

public interface IconclsMenuMapper extends BaseMapper<IconclsMenu> {
    int deleteByPrimaryKey(Long id);

    int insertSelective(IconclsMenu record);

    IconclsMenu selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(IconclsMenu record);

    int updateByPrimaryKey(IconclsMenu record);

    int upsertIconByEntryId(IconclsMenu iconclsMenu);
}