package com.yijiupi.bi.service.db1;

import com.baomidou.mybatisplus.service.IService;
import com.yijiupi.bi.entity.FrRole;
import com.yijiupi.bi.kit.easyui.EasyUiPage;

import java.util.List;

public interface BaseService<T> extends IService<T>{
	public Integer getCountByEqual(T model, String... attrs);
	
	public T getOneByEqual(T model, String... attrs);
	
	public List<T> getListByEqual(T model, String... attrs);
	
	public List<T> getListDynamicEqual(T model, String... attrs);
	
	public EasyUiPage<T> pageByDynamicEqual(EasyUiPage<T> pageInfo, T model, String... attrs);

}
