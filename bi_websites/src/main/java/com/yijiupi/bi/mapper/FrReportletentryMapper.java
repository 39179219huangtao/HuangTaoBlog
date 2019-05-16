package com.yijiupi.bi.mapper;


import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.yijiupi.bi.entity.FrReportletentry;

public interface FrReportletentryMapper  extends BaseMapper<FrReportletentry> {
    int deleteByPrimaryKey(Integer id);


    int insertSelective(FrReportletentry record);

    FrReportletentry selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(FrReportletentry record);

    int updateByPrimaryKey(FrReportletentry record);
}