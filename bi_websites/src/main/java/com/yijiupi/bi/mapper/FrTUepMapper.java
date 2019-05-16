package com.yijiupi.bi.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.yijiupi.bi.entity.FrTUep;

public interface FrTUepMapper extends BaseMapper<FrTUep> {
    int deleteByPrimaryKey(Long id);

    int insertSelective(FrTUep record);

    FrTUep selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(FrTUep record);

    int updateByPrimaryKey(FrTUep record);
}