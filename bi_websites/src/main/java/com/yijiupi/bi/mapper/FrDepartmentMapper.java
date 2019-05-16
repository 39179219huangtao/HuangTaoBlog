package com.yijiupi.bi.mapper;


import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.yijiupi.bi.entity.FrDepartment;

public interface FrDepartmentMapper extends BaseMapper<FrDepartment> {
    int deleteByPrimaryKey(Long id);

    int insertSelective(FrDepartment record);

    FrDepartment selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(FrDepartment record);

    int updateByPrimaryKey(FrDepartment record);
}