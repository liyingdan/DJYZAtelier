package com.djyz.util;

/**
 * @Modifier        
 * @Description //TODO 
 * @CreateTime 19-6-13 下午6:11
 * @ModifiedTime
 * @Params 
 * @return 
 */
public enum StatusEnum {
	/*
	 * 错误信息
	 * */
    S_100("100", "请求成功"),
	E_400("400", "请求处理异常，请稍后再试"),
	E_500("500", "请求方式有误,请检查 GET/POST"),
	E_502("502", "权限不足"),
	E_20011("20011", "登陆已过期,请重新登陆");
	
	private String errorCode;

	private String errorMsg;

	StatusEnum(String errorCode, String errorMsg) {
		this.errorCode = errorCode;
		this.errorMsg = errorMsg;
	}

	public String getErrorCode() {
		return errorCode;
	}

	public String getErrorMsg() {
		return errorMsg;
	}

}