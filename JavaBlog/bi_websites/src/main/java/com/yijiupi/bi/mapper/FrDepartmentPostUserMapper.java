package com.yijiupi.bi.mapper;


import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.yijiupi.bi.entity.FrDepartmentPostUser;

public interface FrDepartmentPostUserMapper extends BaseMapper<FrDepartmentPostUser> {
	int deleteByPrimaryKey(Long id);
	
	int insertSelective(FrDepartmentPostUser record);
	
	FrDepartmentPostUser selectByPrimaryKey(Long id);
	
	int updateByPrimaryKeySelective(FrDepartmentPostUser record);
	
	int updateByPrimaryKey(FrDepartmentPostUser record);
}