package com.yijiupi.bi.service.db2.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.yijiupi.bi.entity.FrCompanyrole;
import com.yijiupi.bi.mapper.FrCompanyroleMapper;
import com.yijiupi.bi.service.db1.impl.BaseServiceImpl;
import com.yijiupi.bi.service.db2.FRCompanyroleService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author huangtao
 * @Title: bi_websites
 * @Package com.yijiupi.bi.service.db2.impl
 * @Description:
 * @date 2018/7/25  18:49
 */
@Service
public class FRCompanyroleServiceImpl extends BaseServiceImpl<FrCompanyroleMapper, FrCompanyrole> implements FRCompanyroleService {
	
	@Override
	public FrCompanyrole getByDeptIdAndPostId(Long deptId, Long postId) {
		EntityWrapper<FrCompanyrole> wrapper = new EntityWrapper<>();
		wrapper.eq("postid", postId);
		wrapper.eq("departmentid", deptId);
		List<FrCompanyrole> companyroles = super.baseMapper.selectList(wrapper);
		if (companyroles.size() > 0) {
			return companyroles.get(0);
		}
		return null;
	}
}
