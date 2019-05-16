package com.yijiupi.bi.kit;



import java.io.Serializable;

/**
 * 响应报文
 *
 * @author gd_huangtao
 */
public class AjaxJson implements Serializable {
	
	public static final String SUCCESS = "0";
	public static final String FAILURE = "1";
	public static final String MSGSUCCESS = "操作成功！";
	public static final String MSGFAILURE = "操作失败！";
	public static final String MSGNULL = "参数为空！";
	private static final long serialVersionUID = 709774635724055172L;
	
	/*
	 * code 0:成功 ,1:失败
	 * **/
	private String code = SUCCESS;
	
	/*
	 * 返回提示消息
	 * **/
	private String msg = "success";
	/*
	 * 返回对象数据
	 * **/
	private Object data;
	
	public String getCode() {
		return code;
	}
	
	public AjaxJson setCode(String code) {
		this.code = code;
		return this;
	}
	
	public String getMsg() {
		return msg;
	}
	
	public AjaxJson setMsg(String msg) {
		this.msg = msg;
		return this;
	}
	
	public Object getData() {
		return data;
	}
	
	public AjaxJson setData(Object data) {
		this.data = data;
		return this;
	}
	
	public boolean isSuccess() {
		return SUCCESS.equals(this.code);
	}
	
	/**
	 * 操作失败消息报文
	 *
	 * @return
	 */
	public static AjaxJson failure() {
		AjaxJson bp = new AjaxJson();
		bp.setCode(FAILURE);
		bp.setMsg("操作失败");
		return bp;
	}
	
	
	/**
	 * 操作成功
	 *
	 * @return
	 */
	public static AjaxJson success() {
		AjaxJson bp = new AjaxJson();
		bp.setCode(SUCCESS);
		bp.setMsg("操作成功");
		return bp;
	}
	
}
