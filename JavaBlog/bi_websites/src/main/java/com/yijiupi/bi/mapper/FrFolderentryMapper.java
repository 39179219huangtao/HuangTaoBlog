package com.yijiupi.bi.mapper;


import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.yijiupi.bi.entity.FrFolderMenu;
import com.yijiupi.bi.entity.FrFolderentry;

import java.util.List;

public interface FrFolderentryMapper extends BaseMapper<FrFolderentry> {
    int deleteByPrimaryKey(Integer id);


    int insertSelective(FrFolderentry record);

    FrFolderentry selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(FrFolderentry record);

    int updateByPrimaryKey(FrFolderentry record);

    List<FrFolderMenu> loadAllMenu();
}