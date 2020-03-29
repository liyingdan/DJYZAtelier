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
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

@Controller
@Api(value = "/EmployeeLogin", tags = "EmployeeLogin接口")
public class EmployeeLoginController {
	final String TOKENX = "1234";
	/**
	 * employee登录
	 */
	@PostMapping("/login/{username}/{password}")
	@ResponseBody
	public JSONObject authLogin(@PathVariable String username, @PathVariable String password, HttpServletResponse response) {
		JSONObject info = new JSONObject();
		Subject currentUser = SecurityUtils.getSubject();
		UsernamePasswordToken token = new UsernamePasswordToken(username, password);
		try {
			currentUser.login(token);
			info.put("username",username);
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
//	@RequiresPermissions("all")
	@GetMapping("/getInfo")
	public Object getInfo() {
		//从session获取用户信息
		JSONObject info = new JSONObject();
		info.put("username", SecurityUtils.getSubject().getPrincipal());
		return CommonUtil.successJson(info);
	}

	/**
	 * 退出登录
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
