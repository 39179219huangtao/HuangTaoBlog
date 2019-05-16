package com.yijiupi.bi.mapper;

import com.yijiupi.bi.entity.Role;
import com.yijiupi.bi.vo.RoleVo;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;


public interface RoleDao extends BaseMapper<Role> {

	public List<RoleVo> listByUserId(Pagination page, @Param("userId") String userId);
	
}
