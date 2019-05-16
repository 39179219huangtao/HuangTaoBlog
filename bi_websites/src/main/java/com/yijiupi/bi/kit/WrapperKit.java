package com.yijiupi.bi.kit;

import com.baomidou.mybatisplus.entity.TableFieldInfo;
import com.baomidou.mybatisplus.entity.TableInfo;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.toolkit.ReflectionKit;
import com.baomidou.mybatisplus.toolkit.TableInfoHelper;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class WrapperKit {

	public static<T> void appendEqual(Wrapper<T> wrapper, Object model, String... attrs) {
		for (String attr : attrs) {
			Object attrValue = ReflectionKit.getMethodValue(model, attr);
			wrapper.eq(attr, attrValue);
		}
	}
	
	public static<T> void appendDynamicEqual(Wrapper<T> wrapper, Object model, String... attrs) {

		TableInfo tableInfo = TableInfoHelper.getTableInfo(model.getClass());
		List<TableFieldInfo> fieldList = tableInfo.getFieldList();
		Map<String, TableFieldInfo> collect = fieldList.stream().collect(Collectors.toMap(TableFieldInfo::getProperty, account -> account));
		for (String attr : attrs) {
			String[] attrArray = attr.split(":");
			//最后一个就是真实的
			String reallyAttrName = attrArray[attrArray.length-1];
			Object attrValue = ReflectionKit.getMethodValue(model, reallyAttrName);
			if(attrValue == null)
				continue;
			if(String.class.equals(attrValue.getClass()) && StrKit.isEmpty((String)attrValue))
				continue;

			TableFieldInfo tableFieldInfo = collect.get(reallyAttrName);
			if(attrArray.length > 1){
				switch (attrArray[0]){
					case "in":
						wrapper.in(tableFieldInfo.getColumn(), attrValue.toString());
						break;
					case "like":
						wrapper.like(tableFieldInfo.getColumn(), attrValue.toString());
						break;
					case "notlike":
						wrapper.notLike(tableFieldInfo.getColumn(), attrValue.toString());
						break;
					default:
						wrapper.eq(tableFieldInfo.getColumn(), attrValue);
						break;
				}
			}else{
				wrapper.eq(tableFieldInfo.getColumn(), attrValue);
			}
		}
	}


	
}
