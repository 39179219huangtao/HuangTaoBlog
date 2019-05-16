package com.yijiupi.bi.utils;

public class DataResult<T> extends BaseResult {

    private T data;

    public DataResult(T data) {
        this.setData(data);
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
