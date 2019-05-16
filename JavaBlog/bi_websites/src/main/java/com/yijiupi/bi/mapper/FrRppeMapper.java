package com.yijiupi.bi.mapper;


import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.yijiupi.bi.entity.FrRppe;

public interface FrRppeMapper  extends BaseMapper<FrRppe> {
    int deleteByPrimaryKey(Integer id);


    int insertSelective(FrRppe record);

    FrRppe selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(FrRppe record);

    int updateByPrimaryKey(FrRppe record);
}