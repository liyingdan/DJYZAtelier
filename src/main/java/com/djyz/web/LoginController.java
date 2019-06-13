package com.djyz.web;

import com.alibaba.fastjson.JSONObject;
import com.djyz.util.CommonUtil;
import io.swagger.annotations.Api;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author: hxy
 * @description: 登录相关Controller
 * @date: 2017/10/24 10:33
 */
@Controller
@Api(value = "/Login", tags = "Login接口")
public class LoginController {

	/**
	 * 登录
	 */
	@PostMapping("/login")
	@ResponseBody
	public JSONObject authLogin(@RequestBody JSONObject requestJson) {
		String username = requestJson.getString("username");
		String password = requestJson.getString("password");
		JSONObject info = new JSONObject();
		Subject currentUser = SecurityUtils.getSubject();
		UsernamePasswordToken token = new UsernamePasswordToken(username, password);
		try {
			currentUser.login(token);
			info.put("result", "success");
		} catch (AuthenticationException e) {
			info.put("result", "fail");
		}
		return CommonUtil.successJson(info);
	}

	/**
	 * 查询当前登录用户的信息
	 */
	@ResponseBody
	@RequiresPermissions("all")
	@GetMapping("/getInfo")
	public Object getInfo() {
		//从session获取用户信息
		JSONObject info = new JSONObject();
		info.put("username", SecurityUtils.getSubject().getPrincipal());
		return CommonUtil.successJson(info);
	}

	/**
	 * 登出
	 */
	@ResponseBody
	@GetMapping("/logout")
	public JSONObject logout() {
		try {
			Subject currentUser = SecurityUtils.getSubject();
			currentUser.logout();
		} catch (Exception e) {
		}
		return CommonUtil.successJson();
	}
}
