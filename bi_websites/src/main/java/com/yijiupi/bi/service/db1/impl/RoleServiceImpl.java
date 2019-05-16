package com.yijiupi.bi.service.db1.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.yijiupi.bi.entity.Role;
import com.yijiupi.bi.kit.easyui.EasyUiPage;
import com.yijiupi.bi.mapper.RoleDao;
import com.yijiupi.bi.service.db1.RoleService;
import com.yijiupi.bi.vo.RoleVo;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 角色 服务实现类
 * </p>
 *
 * @author huangtao
 * @since 2018-05-11
 */
@Service
public class RoleServiceImpl extends ServiceImpl<RoleDao, Role> implements RoleService {

	@Override
	public EasyUiPage<RoleVo> pageByUserId(String userId, EasyUiPage<RoleVo> page) {
		 page.setRecords(baseMapper.listByUserId(page, userId));
		 return page;
	}
	
}
