package com.yijiupi.bi.service.db2.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.yijiupi.bi.entity.FrDepartmentPostUser;
import com.yijiupi.bi.mapper.FrDepartmentPostUserMapper;
import com.yijiupi.bi.service.db1.impl.BaseServiceImpl;
import com.yijiupi.bi.service.db2.FRDepartmentPostUserService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author huangtao
 * @Title: bi_websites
 * @Package com.yijiupi.bi.service.db2.impl
 * @Description:
 * @date 2018/7/25  18:49
 */
@Service
public class FRDepartmentPostUserServiceImpl extends BaseServiceImpl<FrDepartmentPostUserMapper, FrDepartmentPostUser> implements FRDepartmentPostUserService {
	
	@Override
	public List<FrDepartmentPostUser> getByUserId(Long userId) {
		EntityWrapper<FrDepartmentPostUser> wrapper = new EntityWrapper<>();
		wrapper.eq("Userid", userId);
		return super.baseMapper.selectList(wrapper);
	}
}
