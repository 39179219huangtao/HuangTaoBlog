package com.yijiupi.bi.service.db2.impl;

import com.yijiupi.bi.entity.FrRole;
import com.yijiupi.bi.mapper.FrRoleMapper;
import com.yijiupi.bi.service.db1.impl.BaseServiceImpl;
import com.yijiupi.bi.service.db2.FRRoleService;
import org.springframework.stereotype.Service;

/**
 * @author huangtao
 * @Title: bi_websites
 * @Package com.yijiupi.bi.service.db2.impl
 * @Description:
 * @date 2018/7/24  17:18
 */
@Service
public class FRRoleServiceImpl extends BaseServiceImpl<FrRoleMapper, FrRole> implements FRRoleService {
	
	public FrRole getRoleById(int id) {
		return super.selectById(id);
	}
	
}
