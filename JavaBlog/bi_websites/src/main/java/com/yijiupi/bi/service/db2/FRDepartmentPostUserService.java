package com.yijiupi.bi.service.db2;

import com.yijiupi.bi.entity.FrDepartmentPostUser;
import com.yijiupi.bi.service.db1.BaseService;

import java.util.List;

/**
 * @author huangtao
 * @Title: bi_websites
 * @Package com.yijiupi.bi.service.db2
 * @Description:
 * @date 2018/7/25  18:46
 */
public interface FRDepartmentPostUserService extends BaseService<FrDepartmentPostUser> {
	
	List<FrDepartmentPostUser> getByUserId(Long userId);
}
