package com.yijiupi.bi.service.db2;

import com.yijiupi.bi.entity.FrRole;
import com.yijiupi.bi.service.db1.BaseService;

import java.io.Serializable;

/**
 * <p>
 * 用户 服务类
 * </p>
 *
 * @author huangtao
 * @since 2018-05-11
 */
public interface FRRoleService extends BaseService<FrRole> {
	
	@Override
	FrRole selectById(Serializable serializable);
}
