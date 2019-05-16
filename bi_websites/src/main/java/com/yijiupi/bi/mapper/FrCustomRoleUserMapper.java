package com.yijiupi.bi.mapper;


import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.yijiupi.bi.entity.FrCustomRoleUser;

public interface FrCustomRoleUserMapper extends BaseMapper<FrCustomRoleUser> {
	int deleteByPrimaryKey(Long id);
	
	
	int insertSelective(FrCustomRoleUser record);
	
	FrCustomRoleUser selectByPrimaryKey(Long id);
	
	int updateByPrimaryKeySelective(FrCustomRoleUser record);
	
	int updateByPrimaryKey(FrCustomRoleUser record);
}