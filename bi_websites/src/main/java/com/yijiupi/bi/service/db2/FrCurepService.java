package com.yijiupi.bi.service.db2;

import com.yijiupi.bi.entity.FrCurep;
import com.yijiupi.bi.service.db1.BaseService;

import java.util.List;

/**
 * @Decription:
 * @Author: Huang Yuansheng
 * @Date: Create in 16:42 2018/7/27 0027
 * @Email: huangyuansheng@yijiupi.cn
 **/
public interface FrCurepService extends BaseService<FrCurep> {
	
	/**
	 * 通过角色id查找所有的菜单以及权限
	 *
	 * @param roleId 角色id
	 * @return 所有菜单权限
	 */
	List<FrCurep> getAllCurepByRoleId(Long roleId);
}
