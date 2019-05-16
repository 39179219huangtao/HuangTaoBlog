package com.yijiupi.bi.mapper;


import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.yijiupi.bi.entity.FrCorep;

import java.util.List;

public interface FrCorepMapper extends BaseMapper<FrCorep> {
    int deleteByPrimaryKey(Long id);

    int insertSelective(FrCorep record);

    FrCorep selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(FrCorep record);

    int updateByPrimaryKey(FrCorep record);

    List<FrCorep> getAllDepartmentPostCorepByPostId(Long postId);
}