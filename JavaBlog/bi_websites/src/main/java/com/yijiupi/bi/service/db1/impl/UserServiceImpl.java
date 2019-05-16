package com.yijiupi.bi.service.db1.impl;

import com.yijiupi.bi.entity.User;
import com.yijiupi.bi.kit.easyui.EasyUiPage;
import com.yijiupi.bi.mapper.UserDao;
import com.yijiupi.bi.service.db1.UserService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户 服务实现类
 * </p>
 *
 * @author huangtao
 * @since 2018-05-11
 */
@Service
public class UserServiceImpl extends BaseServiceImpl<UserDao, User> implements UserService {

    @Override
    public User selectUserByUsername(String username) {
        return super.baseMapper.selectUserByUsername(username);
    }

	@Override
	public EasyUiPage<User> page(EasyUiPage<User> page, User user) {
		page.setRecords(baseMapper.list(page, user));
		return page;
	}
}
