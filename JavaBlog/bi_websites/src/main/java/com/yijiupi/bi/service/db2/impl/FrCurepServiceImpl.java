package com.yijiupi.bi.service.db2.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.yijiupi.bi.entity.FrCurep;
import com.yijiupi.bi.mapper.FrCurepMapper;
import com.yijiupi.bi.service.db1.impl.BaseServiceImpl;
import com.yijiupi.bi.service.db2.FrCurepService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Decription:
 * @Author: Huang Yuansheng
 * @Date: Create in 17:00 2018/7/27 0027
 * @Email: huangyuansheng@yijiupi.cn
 **/
@Service
public class FrCurepServiceImpl extends BaseServiceImpl<FrCurepMapper, FrCurep> implements FrCurepService {
	@Override
	public List<FrCurep> getAllCurepByRoleId(Long roleId) {
		EntityWrapper<FrCurep> wrapper = new EntityWrapper<>();
		wrapper.eq("roleid", roleId);
		return super.baseMapper.selectList(wrapper);
	}
}
