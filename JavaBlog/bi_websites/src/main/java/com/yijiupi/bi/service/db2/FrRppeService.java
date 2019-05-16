package com.yijiupi.bi.service.db2;

import com.yijiupi.bi.entity.FrRppe;
import com.yijiupi.bi.service.db1.BaseService;

/**
 * @Decription:
 * @Author: Huang Yuansheng
 * @Date: Create in 17:32 2018/7/27 0027
 * @Email: huangyuansheng@yijiupi.cn
 **/
public interface FrRppeService extends BaseService<FrRppe> {
	
	/**
	 * 通过id 获取Rppe
	 *
	 * @param id
	 * @return
	 */
	FrRppe getRppeById(Long id);
}
