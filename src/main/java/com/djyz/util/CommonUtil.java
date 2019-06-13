package com.djyz.util;

import com.alibaba.fastjson.JSONObject;

/**
 * @author: hxy
 * @description: 本后台接口系统常用的json工具类
 * @date: 2017/10/24 10:12
 */
public class CommonUtil {

	/**
	 * 返回一个info为空对象的成功消息的json
	 */
	public static JSONObject successJson() {
		return successJson(new JSONObject());
	}

	/**
	 * 返回一个返回码为100的json
	 */
	public static JSONObject successJson(Object info) {
		JSONObject resultJson = new JSONObject();
		resultJson.put("code", StatusEnum.S_100.getErrorCode());
		resultJson.put("msg", StatusEnum.S_100.getErrorMsg());
		resultJson.put("info", info);
		return resultJson;
	}

	/**
	 * 返回错误信息JSON
	 */
	public static JSONObject errorJson(StatusEnum statusEnum) {
		JSONObject resultJson = new JSONObject();
		resultJson.put("code", statusEnum.getErrorCode());
		resultJson.put("msg", statusEnum.getErrorMsg());
		resultJson.put("info", new JSONObject());
		return resultJson;
	}
}
