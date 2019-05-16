package com.yijiupi.bi.constant;

import org.springframework.util.StringUtils;

/**
 * @description:
 * @param:
 * @return:
 * @author: huangtao
 * @date: 2019/2/21
 */
public enum ExceptionEnum {
    /**
     *
     */
    NULL(new Exception(), "------"),
    /**
     * 越界异常
     */
    IndexOutOf(new IndexOutOfBoundsException(), "越界"),

    NullPointer(new NullPointerException(), "空指针");

    ExceptionEnum(Exception type, String text) {
        this.type = type;
        this.text = text;
    }

    private Exception type;
    private String text;

    public Exception getType() {
        return type;
    }

    public String getText() {
        return text;
    }

    public static ExceptionEnum getEnum(Exception type) {
        ExceptionEnum e = ExceptionEnum.NULL;

        if (type != null) {
            for (ExceptionEnum o : ExceptionEnum.values()) {

                if (type.getClass().equals(o.type.getClass())) {
                    e = o;
                }

            }
        }

        return e;
    }

    public static ExceptionEnum getEnum(String text) {
        ExceptionEnum e = ExceptionEnum.NULL;

        if (!StringUtils.isEmpty(text)) {
            for (ExceptionEnum o : ExceptionEnum.values()) {
                if (o.getText().equals(text)) {
                    e = o;
                }
            }
        }

        return e;
    }

    public static void main(String[] args) {

        IndexOutOfBoundsException e = new IndexOutOfBoundsException();
        System.out.println(getEnum(e).text);
    }

}
