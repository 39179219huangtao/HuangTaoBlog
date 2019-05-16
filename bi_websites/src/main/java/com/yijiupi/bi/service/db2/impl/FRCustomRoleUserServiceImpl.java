package com.yijiupi.bi.service.db2.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.yijiupi.bi.entity.FrCustomRoleUser;
import com.yijiupi.bi.mapper.FrCustomRoleUserMapper;
import com.yijiupi.bi.service.db1.impl.BaseServiceImpl;
import com.yijiupi.bi.service.db2.FRCustomRoleUserService;
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
public class FRCustomRoleUserServiceImpl extends BaseServiceImpl<FrCustomRoleUserMapper, FrCustomRoleUser> implements FRCustomRoleUserService {
	
	
	@Override
	public List<FrCustomRoleUser> getByUserId(Long userId) {
		EntityWrapper<FrCustomRoleUser> wrapper = new EntityWrapper<>();
		wrapper.eq("Userid", userId);
		return super.baseMapper.selectList(wrapper);
	}
}
