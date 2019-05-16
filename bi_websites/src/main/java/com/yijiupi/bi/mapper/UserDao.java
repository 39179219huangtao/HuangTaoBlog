package com.yijiupi.bi.mapper;

import com.yijiupi.bi.entity.User;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;


public interface UserDao extends BaseMapper<User> {

	public User selectUserByUsername(String username);
	
	public List<User> list(Pagination page, @Param("user") User user);
	
}
