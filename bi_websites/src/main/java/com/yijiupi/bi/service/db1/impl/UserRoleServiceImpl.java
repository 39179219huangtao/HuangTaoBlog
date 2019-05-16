package com.yijiupi.bi.service.db1.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.yijiupi.bi.entity.UserRole;
import com.yijiupi.bi.mapper.UserRoleDao;
import com.yijiupi.bi.service.db1.UserRoleService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户角色关系表 服务实现类
 * </p>
 *
 * @author huangtao
 * @since 2018-05-11
 */
@Service
public class UserRoleServiceImpl extends ServiceImpl<UserRoleDao, UserRole> implements UserRoleService {

	@Override
	public Integer deleteByUserId(String userId) {
		return baseMapper.deleteByUserId(userId);
	}

}
