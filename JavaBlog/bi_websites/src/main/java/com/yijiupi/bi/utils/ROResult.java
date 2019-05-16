package com.yijiupi.bi.utils;


import com.yijiupi.bi.constant.WebConstants;

public class ROResult<T> extends BaseResult {

    T data;

    public ROResult() {
        super.setResult("success");
        super.setMessage(WebConstants.RESULT_SUCCESS);
    }

    public ROResult(T data) {
        super.setResult("success");
        this.data = data;
        super.setMessage(WebConstants.RESULT_SUCCESS);
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public void getSuccess(Integer totalCount) {
        super.setTotalCount(totalCount);
        super.setResult("success");
        super.setMessage(WebConstants.RESULT_SUCCESS);
    }
}
