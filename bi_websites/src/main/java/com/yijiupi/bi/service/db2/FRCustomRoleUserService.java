package com.yijiupi.bi.service.db2;

import com.yijiupi.bi.entity.FrCustomRoleUser;
import com.yijiupi.bi.service.db1.BaseService;

import java.util.List;

/**
 * @author huangtao
 * @Title: bi_websites
 * @Package com.yijiupi.bi.service.db2
 * @Description:
 * @date 2018/7/25  18:46
 */
public interface FRCustomRoleUserService extends BaseService<FrCustomRoleUser> {
	
	/**
	 * 获取用户 Role id
	 *
	 * @param userId 用户id
	 * @return Role id
	 */
	List<FrCustomRoleUser> getByUserId(Long userId);
}
