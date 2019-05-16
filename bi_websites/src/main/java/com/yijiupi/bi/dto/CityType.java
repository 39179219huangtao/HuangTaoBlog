package com.yijiupi.bi.dto;

/**
 * Created by ZhouXin on 2016/6/23.
 */
public enum CityType {

    v1(1),

    v2(2);

    public Integer value;

    CityType(Integer value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return this.value.toString();
    }
}
