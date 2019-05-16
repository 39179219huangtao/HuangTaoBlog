package com.yijiupi.bi.constant;

/**
 * @author huangtao
 * @Title: bi_websites
 * @Package com.yijiupi.bi.constant
 * @Description:
 * @date 2018/7/23  16:20
 */
public enum DBTypeEnum {
    db1("db1"), db2("db2");
    private String value;

    DBTypeEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
