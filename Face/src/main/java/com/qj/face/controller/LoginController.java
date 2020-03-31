package com.qj.face.controller;

import java.io.IOException;
import java.util.LinkedHashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.qj.face.base.BaseAction;
import com.qj.face.base.ResponseBase;
import com.qj.face.constants.Constants;
import com.qj.face.entity.UserEntity;
import com.qj.face.service.RoleService;
import com.qj.face.service.UserService;
import com.qj.face.utils.CookieUtil;


@Controller
public class LoginController extends BaseAction {

	@Autowired
	private UserService memberServiceFegin;
	@Autowired
	private UserService userService;
	@Autowired
	private RoleService roleService;
	
	
	
	private static final String LOGIN = "/login";
	private static final String INDEX = "redirect:/";

	@RequestMapping(value = "/tuile", method = RequestMethod.GET)
	public String tuile() {
		CookieUtil.removeCookie(response, Constants.COOKIE_MEMBER_TOKEN);
		return INDEX;
	}

	@RequestMapping("/doLogin")
	public String doLogin(UserEntity user, HttpServletRequest request, HttpServletResponse response) {
		ResponseBase loginBase = memberServiceFegin.login(user);

		// 1.验证参数
		// 2.调用登录接口，获取token信息
		if (!loginBase.getRtnCode().equals(Constants.HTTP_RES_CODE_200)) {
			request.setAttribute("error", "账号或者密码错误!");
			return LOGIN;
		}
		LinkedHashMap loginData = JSON.parseObject(JSON.toJSONString(loginBase.getData()), LinkedHashMap.class);
		String memberToken = (String) loginData.get("memberToken");
		if (StringUtils.isEmpty(memberToken)) {
			request.setAttribute("error", "会话已经失效!");
			return LOGIN;
		}
		// 3.将token信息存放在cookie里面
		setCookie(memberToken, response);
		return INDEX;
	}

	// 注册业务具体实现
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	@ResponseBody
	public void registerPost(UserEntity userEntity, HttpServletRequest reqest, HttpServletResponse response)
			throws IOException {
		response.setHeader("Access-Control-Allow-Origin", "*");
		JSONObject result = new JSONObject();
		// 1. 验证参数
		// 2. 调用会员注册接口
		ResponseBase regUser = memberServiceFegin.regUser(userEntity);

		// 3. 如果失败，跳转到失败页面
		if (!regUser.getRtnCode().equals(Constants.HTTP_RES_CODE_200)) {
			result.put("error", "注册失败！");
			writeStream(result.toString(), "utf-8");
		}
		int addId = userService.getMaxId();

		roleService.userAddRole(1, addId);// 用户角色修改

		result.put("success", "注册成功！");
		writeStream(result.toString(), "utf-8");
	}

	public void setCookie(String memberToken, HttpServletResponse response) {
		CookieUtil.addCookie(response, Constants.COOKIE_MEMBER_TOKEN, memberToken, Constants.COOKIE_TOKEN_MEMBER_TIME);
	}

}
