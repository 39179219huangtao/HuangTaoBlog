package com.yijiupi.bi.mapper;

import com.yijiupi.bi.entity.UserRole;

import org.apache.ibatis.annotations.Param;

import com.baomidou.mybatisplus.mapper.BaseMapper;


public interface UserRoleDao extends BaseMapper<UserRole> {

	Integer deleteByUserId(@Param("userId")String userId);
	
}
