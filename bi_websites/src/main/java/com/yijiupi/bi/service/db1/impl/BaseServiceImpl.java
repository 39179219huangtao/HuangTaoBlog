package com.yijiupi.bi.service.db1.impl;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.yijiupi.bi.kit.WrapperKit;
import com.yijiupi.bi.kit.easyui.EasyUiPage;
import com.yijiupi.bi.service.db1.BaseService;
import org.springframework.util.CollectionUtils;

import java.util.List;

public class BaseServiceImpl<M extends BaseMapper<T>, T> extends ServiceImpl<M, T> implements BaseService<T> {

	@Override

	public Integer getCountByEqual(T model, String... attrs) {
		Wrapper<T> wrapper = new EntityWrapper<>();
		WrapperKit.appendEqual(wrapper, model, attrs);
		return baseMapper.selectCount(wrapper);
	}

	@Override
	public T getOneByEqual(T model, String... attrs) {
		Wrapper<T> wrapper = new EntityWrapper<>();
		WrapperKit.appendEqual(wrapper, model, attrs);
		List<T> results = baseMapper.selectList(wrapper);
		return CollectionUtils.isEmpty(results) ? null : results.get(0);
	}

	@Override
	public List<T> getListByEqual(T model, String... attrs) {
		Wrapper<T> wrapper = new EntityWrapper<>();
		WrapperKit.appendEqual(wrapper, model, attrs);
		return baseMapper.selectList(wrapper);
	}

	@Override
	public List<T> getListDynamicEqual(T model, String... attrs) {
		Wrapper<T> wrapper = new EntityWrapper<>();
		WrapperKit.appendDynamicEqual(wrapper, model, attrs);
		return baseMapper.selectList(wrapper);
	}

	@Override
	public EasyUiPage<T> pageByDynamicEqual(EasyUiPage<T> pageInfo, T model, String... attrs) {
		Wrapper<T> wrapper = new EntityWrapper<>();
		WrapperKit.appendDynamicEqual(wrapper, model, attrs);
		pageInfo.setRecords(baseMapper.selectPage(pageInfo, wrapper));
		return pageInfo;
	}
	
}
