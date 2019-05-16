package com.yijiupi.bi.mapper;


import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.yijiupi.bi.entity.FrUrlentry;

public interface FrUrlentryMapper extends BaseMapper<FrUrlentry> {
    int deleteByPrimaryKey(Integer id);


    int insertSelective(FrUrlentry record);

    FrUrlentry selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(FrUrlentry record);

    int updateByPrimaryKey(FrUrlentry record);
}