/**
 * Copyright © 2017 北京易酒批电子商务有限公司. All rights reserved.
 */
package com.yijiupi.bi.dto;

/**
 * TODO
 *
 * @author yerenjie
 * @date 2017年2月7日 上午9:58:24
 */
public enum CityMode {
    自营(1), 加盟(2);

    public Integer value;

    CityMode(Integer value) {
        this.value = value;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return this.value.toString();
    }
}
