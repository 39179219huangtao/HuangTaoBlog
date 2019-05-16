package com.yijiupi.bi.service.db2.impl;

import com.yijiupi.bi.entity.FrRppe;
import com.yijiupi.bi.mapper.FrRppeMapper;
import com.yijiupi.bi.service.db1.impl.BaseServiceImpl;
import com.yijiupi.bi.service.db2.FrRppeService;
import org.springframework.stereotype.Service;

/**
 * @Decription:
 * @Author: Huang Yuansheng
 * @Date: Create in 17:40 2018/7/27 0027
 * @Email: huangyuansheng@yijiupi.cn
 **/
@Service
public class FrRppeServiceImpl extends BaseServiceImpl<FrRppeMapper, FrRppe> implements FrRppeService {
	@Override
	public FrRppe getRppeById(Long id) {
		return super.selectById(id);
	}
}
