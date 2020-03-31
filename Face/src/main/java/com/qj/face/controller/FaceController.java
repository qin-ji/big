package com.qj.face.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import java.io.PrintWriter;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.qj.face.base.BaseAction;
import com.qj.face.base.BaseRedisService;
import com.qj.face.base.ResponseBase;
import com.qj.face.constants.Constants;
import com.qj.face.entity.MenEntity;
import com.qj.face.entity.RoleEntity;
import com.qj.face.entity.UserEntity;
import com.qj.face.service.RoleService;
import com.qj.face.service.UserService;
import com.qj.face.utils.CookieUtil;
import com.qj.face.utils.DateUtils;
import com.qj.face.utils.MD5Util;
import com.smart.utils.StringUtils;

@Controller
@RequestMapping("/face")
public class FaceController extends BaseAction {

	@Autowired
	private UserService userService;

	@Autowired
	private RoleService roleService;

	@Autowired
	protected BaseRedisService baseRedisService;



	// ************************************************************************

	/**
	 * 获取角色
	 */
//	@RequestMapping(value = "/upload/img", method = RequestMethod.POST)
//	@ResponseBody
//	public void getUploadImg(MultipartFile file) {
//		JSONObject result = new JSONObject();
//		String ertName = file.getOriginalFilename();// 获取文件格式
//		final String uploadPath = "F:\\QJ\\Face\\src\\main\\webapp\\Uploads\\"+ertName; // 上传的组合路径
//		try {
//			File saveFile = new File( uploadPath);
//			if (!saveFile.exists()) {
//				FileCopyUtils.copy(file.getInputStream(), new FileOutputStream(saveFile));// 把文件写入磁盘
//			}
//			result.put("code", 200);
//			result.put("msg", "上传成功");
//			result.put("data", new HashMap<String, Object>() {
//				{
//					put("src", ertName );
//				}
//			});
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//
//		writeStream(result.toString(), "utf-8");
//	}
//
//
//	/**
//	 * 获取角色
//	 */
//	@RequestMapping(value = "/getRole", method = RequestMethod.POST)
//	@ResponseBody
//	public void getRole() {
//		JSONObject result = new JSONObject();
//		List<RoleEntity> roleList = roleService.selectRoleByRoleName();
//		result.put("msg", "查询成功");
//		result.put("roleList", roleList);
//		writeStream(result.toString(), "utf-8");
//
//	}
//
	/**
	 * 获取用户管理页面按钮
	 */
	@RequestMapping(value = "/getFaceButton", method = RequestMethod.POST)
	@ResponseBody
	public void getFaceButton() {
		JSONObject result = new JSONObject();
		String jsonMenListStr = (String) baseRedisService.getString("menList");
		List<MenEntity> menList = JSONObject.parseArray(jsonMenListStr, MenEntity.class);
		List<MenEntity> newList = new ArrayList<MenEntity>();
		for (MenEntity m : menList) {
			if (m.getMenId()==18) {
				for (MenEntity mm : menList) {
					if (mm.getParentId() == m.getMenId() && mm.getMenType().equals("button")) {
						newList.add(mm);
					}
				}
			}
		}
		result.put("success", "查询成功");
		result.put("faceButtonList", newList);
		writeStream(result.toString(), "utf-8");

	}
//
//	@RequestMapping(value = "/queryUser", method = RequestMethod.GET)
//	@ResponseBody
//	public void queryUser() {
//		JSONObject result = new JSONObject();
//		Integer indexPage = Integer.valueOf(request.getParameter("indexPage"));
//		Integer pageSize = Integer.valueOf(request.getParameter("pageSize"));
//
//		String userName = request.getParameter("userName");
//		String phone = request.getParameter("phone");
//		String date_D = request.getParameter("date_D");
//		String date_c = "";
//		String date_e = "";
//		if (StringUtils.isNotEmpty(date_D)) {
//			date_c = date_D.split(" - ")[0];
//			date_e = date_D.split(" - ")[1];
//		}
//
//		List<UserEntity> userList = (List<UserEntity>) userService.queryUser(indexPage, pageSize, userName, phone,
//				date_c, date_e);
//		result.put("status", 200);
//		result.put("msg", "查询成功");
//		result.put("total", userService.queryOrderByParamCount(userName, phone, date_c, date_e));
//		result.put("data", userList);
//		writeStream(result.toString(), "utf-8");
//
//	}
//
//	@RequestMapping(value = "/deleteUser", method = RequestMethod.POST)
//	@ResponseBody
//	public void deleteUser() {
//		JSONObject result = new JSONObject();
//
//		String ids = request.getParameter("ids");
//
//		if (userService.deleteUserByIds(ids) > 0) {
//			result.put("msg", "删除成功");
//
//		} else {
//			result.put("msg", "删除失败");
//		}
//		writeStream(result.toString(), "utf-8");
//	}
//
//	@RequestMapping(value = "/updateUser", method = RequestMethod.POST)
//	@ResponseBody
//	public void updateUser() {
//		JSONObject result = new JSONObject();
//		Integer id = Integer.valueOf(request.getParameter("id"));
//		String username = request.getParameter("username");
//		String password = request.getParameter("password");
//		String phone = request.getParameter("phone");
//		String email = request.getParameter("email");
//		String roleName = request.getParameter("roleName");
//		String img_url = request.getParameter("img_url");
//		
//		UserEntity user = new UserEntity();
//		user.setId(id);
//		user.setUsername(username);
//		if (password != null && StringUtils.isNotEmpty(password)) {
//			user.setPassword(MD5Util.MD5(password));
//		} else {
//			user.setPassword(null);
//		}
//		user.setPhone(phone);
//		user.setEmail(email);
//		user.setUpdated(DateUtils.currentFormatDate(DateUtils.DATE_TO_STRING_DETAIAL_PATTERN));
//		user.setRoleName(roleName);
//		user.setImg_url(img_url);
//		List<Integer> roleId = getRoleId(roleName);
//
//		if (roleName != null && StringUtils.isNotEmpty(roleName) && roleId != null && roleId.size() > 0) {
//			Integer del = roleService.selectRole(id);
//			if (del > 0) {
//				roleService.deleteRole(id);
//			}
//
//			for (Integer r_id : roleId) {
//				roleService.userAddRole(r_id, id);// 用户角色修改
//			}
//		}
//
//		if (userService.updateUser(user) > 0) {
//			result.put("msg", "修改成功");
//		} else {
//			result.put("msg", "修改失败");
//		}
//
//		writeStream(result.toString(), "utf-8");
//
//	}
//
//	@RequestMapping(value = "/addUser", method = RequestMethod.POST)
//	@ResponseBody
//	public void addUser() {
//		JSONObject result = new JSONObject();
//		String username = request.getParameter("username");
//		String password = request.getParameter("password");
//		String phone = request.getParameter("phone");
//		String email = request.getParameter("email");
//		String roleName = request.getParameter("roleName");
//		String img_url=request.getParameter("img_url");;
//		
//		UserEntity user = new UserEntity();
//		user.setImg_url(img_url);
//		user.setUsername(username);
//		if (password != null && StringUtils.isNotEmpty(password)) {
//			user.setPassword(MD5Util.MD5(password));
//		} else {
//			user.setPassword(null);
//		}
//		user.setPhone(phone);
//		user.setEmail(email);
//		user.setCreated(DateUtils.currentFormatDate(DateUtils.DATE_TO_STRING_DETAIAL_PATTERN));
//		user.setRoleName(roleName);
//
//		userService.regUser(user);
//
//		List<Integer> roleId = getRoleId(roleName);
//		if (roleName != null && StringUtils.isNotEmpty(roleName) && roleId != null && roleId.size() > 0) {
//			int addId = userService.getMaxId();
//			for (Integer r_id : roleId) {
//				roleService.userAddRole(r_id, addId);// 用户角色修改
//			}
//		}
//		result.put("msg", "新增成功");
//		writeStream(result.toString(), "utf-8");
//
//	}
//
//	public List<Integer> getRoleId(String roleName) {
//		String[] roleNameNew = new String[99];
//		if (roleName != null && roleName.contains(",")) {
//			roleNameNew = roleName.split(",");
//		} else {
//			roleNameNew[0] = roleName;
//		}
//
//		List<Integer> roleId = new ArrayList<Integer>();
//		List<RoleEntity> roleList = roleService.selectRoleByRoleName();
//		if (roleNameNew != null) {
//			for (int i = 0; i < roleNameNew.length; i++) {
//				for (RoleEntity roleEntity : roleList) {
//					if (roleEntity.getRoleName().equals(roleNameNew[i])) {
//						roleId.add(roleEntity.getRoleId());
//					}
//				}
//			}
//		}
//
//		return roleId;
//
//	}



}
