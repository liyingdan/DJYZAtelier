package com.djyz.util;

import com.alibaba.fastjson.JSONObject;

import java.util.UUID;

/**
 * @description: 本后台接口系统常用的json工具类
 */
public class CommonUtil {

	/**
	 * 生成Customer登录成功后使用的token
	 */
	public static String generateToken() {

		return "SIGEND_CUSTOMER" + UUID.randomUUID().toString().replaceAll("-", "");
	}


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
