package com.yijiupi.bi.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.yijiupi.bi.entity.FrCurep;

public interface FrCurepMapper extends BaseMapper<FrCurep> {
    int deleteByPrimaryKey(Long id);

    int insertSelective(FrCurep record);

    FrCurep selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(FrCurep record);

    int updateByPrimaryKey(FrCurep record);
}