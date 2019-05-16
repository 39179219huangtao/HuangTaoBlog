package com.yijiupi.bi.mapper;


import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.yijiupi.bi.entity.FrCompanyrole;

public interface FrCompanyroleMapper extends BaseMapper<FrCompanyrole> {
	int deleteByPrimaryKey(Long id);
	
	int insertSelective(FrCompanyrole record);
	
	FrCompanyrole selectByPrimaryKey(Long id);
	
	int updateByPrimaryKeySelective(FrCompanyrole record);
	
	int updateByPrimaryKey(FrCompanyrole record);
}