package com.yijiupi.bi.dto;
/**
 * Created by ZhouXin on 2016/10/18.
 */
public enum EnableState {
	停用(0), 启用(1), NULL(null);
	public Integer value;

	EnableState(Integer value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return String.valueOf(this.value);
	}
}
