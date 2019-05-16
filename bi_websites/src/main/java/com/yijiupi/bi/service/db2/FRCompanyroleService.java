package com.yijiupi.bi.service.db2;

import com.yijiupi.bi.entity.FrCompanyrole;
import com.yijiupi.bi.service.db1.BaseService;

/**
 * @author huangtao
 * @Title: bi_websites
 * @Package com.yijiupi.bi.service.db2
 * @Description:
 * @date 2018/7/25  18:46
 */
public interface FRCompanyroleService extends BaseService<FrCompanyrole> {
	
	/**
	 * 通过城市id和职位id获取对应角色
	 *
	 * @param deptId 城市id
	 * @param postId 角色id
	 * @return role
	 */
	FrCompanyrole getByDeptIdAndPostId(Long deptId, Long postId);
}
