package com.qj.face.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class PageController  {

	//登录页面
	private static final String LOGIN = "/login";    
	//用户管理页面
	private static final String USER_USER = "/user/user";
	//页面管理
	private static final String MEN_MEN = "/men/men";
	//角色管理
	private static final String ROLE_ROLE = "/role/role";
	//路由管理
	private static final String ZUUL_ZUUL = "/zuul/zuul";
	//Face 人脸库
	private static final String FACE = "/face/face";
	//Face 用户
	private static final String FACE_USER = "/face/faceUser";
	//Face 用户组
	private static final String FACE_USER_GROUP = "/face/faceUserGroup";
	//聊天页面
	private static final String BB_BB = "/bb/BB";
	
	@RequestMapping("/bb/bb")
	public String bb() {
		return BB_BB;
	}
	
	@RequestMapping("/zuul/zuul") 
	public String zuul() {
		return ZUUL_ZUUL;
	}
	
	@RequestMapping("/user/user")
	public String user() {
		return USER_USER;
	}

	@RequestMapping("/men/men")
	public String men() {
		return MEN_MEN;
	}
	
	@RequestMapping("/login")
	public String login() {
		return LOGIN;
	}
	
	@RequestMapping("/role/role")
	public String role() {
		return ROLE_ROLE;
	}
	
	@RequestMapping("/face/face")
	public String face() {
		return FACE;
	}
	
	@RequestMapping("/face/faceUser")
	public String faceUser() {
		return FACE_USER;
	}
	
	@RequestMapping("/face/faceUserGroup")
	public String faceUserGroup() {
		return FACE_USER_GROUP;
	}
}
