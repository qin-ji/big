package com.qj.face.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.qj.face.base.BaseAction;
import com.qj.face.base.BaseRedisService;
import com.qj.face.entity.MenEntity;
import com.qj.face.entity.RoleEntity;
import com.qj.face.service.MenService;
import com.qj.face.service.RoleService;
import com.qj.face.service.UserService;
import com.smart.utils.StringUtils;

import freemarker.template.utility.StringUtil;

@Controller
@RequestMapping("/role")
public class RoleController extends BaseAction {


	@Autowired
	private RoleService roleService;

	@Autowired
	private MenService MenService;
	@Autowired
	protected BaseRedisService baseRedisService;

	private static final String ROLE = "role/role";
	private static final String INDEX = "redirect:/";

	// ************************************************************************

	/**
	 * 获取角色管理页面按钮
	 */
	@RequestMapping(value = "/getRoleButton", method = RequestMethod.POST)
	@ResponseBody
	public void getRoleButton() {
		JSONObject result = new JSONObject();
		String jsonMenListStr = (String) baseRedisService.getString("menList");
		System.out.println("////jsonMenListStr:" + jsonMenListStr);
		List<MenEntity> menList = JSONObject.parseArray(jsonMenListStr, MenEntity.class);
		List<MenEntity> newList = new ArrayList<MenEntity>();
		for (MenEntity m : menList) {
			if (m.getMenId() == 11) {
				for (MenEntity mm : menList) {
					if (mm.getParentId() == m.getMenId() && mm.getMenType().equals("button")) {
						newList.add(mm);
					}
				}
			}
		}
		System.out.println(JSONObject.toJSONString(newList));
		result.put("success", "查询成功");
		result.put("roleButtonList", newList);
		writeStream(result.toString(), "utf-8");

	}

	@RequestMapping(value = "/queryRole", method = RequestMethod.GET)
	@ResponseBody
	public void queryUser() {
		JSONObject result = new JSONObject();
		Integer indexPage = Integer.valueOf(request.getParameter("indexPage"));
		Integer pageSize = Integer.valueOf(request.getParameter("pageSize"));

		String roleID = request.getParameter("roleID");
		String roleName = request.getParameter("roleName");

		List<RoleEntity> roleList = (List<RoleEntity>) roleService.queryRole(indexPage, pageSize, roleID, roleName);
		for (RoleEntity roleEntity : roleList) {
			String men = "";
			for (MenEntity mens : MenService.findMenByroleId(roleEntity.getRoleId())) {
				men += mens.getMenId() + ":" + mens.getMenName() + "/";
			}
			roleEntity.setRoleMen(men);
		}

		result.put("status", 200);
		result.put("msg", "查询成功");
		result.put("total", roleService.queryRoleByParamCount(roleID, roleName));
		result.put("data", roleList);
		writeStream(result.toString(), "utf-8");
	}

	@RequestMapping(value = "/deleteRole", method = RequestMethod.POST)
	@ResponseBody
	public void deleteRole() {
		JSONObject result = new JSONObject();
		String ids = request.getParameter("ids");
		String roleIDs = request.getParameter("roleIDs");
		
		try {

			if (StringUtils.isEmpty(ids)) {
				throw new Exception();
			}
			int suSUM = 0;
			int errSUM = 0;
			int index =0;
			for (String role_id : ids.split(",")) {
				if (StringUtils.isNotEmpty(role_id) && roleService.deleteRole(Integer.valueOf(role_id)) > 0) {
					roleService.deleteRoleMen(Integer.valueOf(roleIDs.split(",")[index]));
					suSUM++;

				} else {
					errSUM++;

				}
				index++;
			}
			result.put("success", "成功删除：" + suSUM + "条角色信息，失败：" + errSUM + "条");
		} catch (Exception e) {
			result.put("error", "删除失败");
			writeStream(result.toString(), "utf-8");
		}

	}

	@RequestMapping(value = "/updateRole", method = RequestMethod.POST)
	@ResponseBody
	public void updateRole() {
		JSONObject result = new JSONObject();
		String roleName = request.getParameter("roleName");
		String menIds = request.getParameter("menIds");
		String roleId = request.getParameter("roleId");
		try {
			if (StringUtils.isEmpty(roleId)) {
				throw new Exception();
			}
			roleService.updateRoleName(Integer.valueOf(roleId), roleName); // 修改角色名
			roleService.deleteRoleMen(Integer.valueOf(roleId)); // 把该角色之前的权限删了
			if (StringUtils.isNotEmpty(menIds)) {
				for (String men_id : menIds.split(",")) {
					roleService.addMenRole(Integer.valueOf(men_id), Integer.valueOf(roleId)); // 新增新的权限
				}
			}

			result.put("success", "修改成功");
			writeStream(result.toString(), "utf-8");
		} catch (Exception e) {
			result.put("error", "修改失败");
			writeStream(result.toString(), "utf-8");
		}

	}

	@RequestMapping(value = "/addRole", method = RequestMethod.POST)
	@ResponseBody
	public void addRole() {
		JSONObject result = new JSONObject();
		String roleName = request.getParameter("roleName");
		String menIds = request.getParameter("menIds");

		try {
			Integer roleId = roleService.queryRoleId() + 1; // 获取角色表最大的角色id ，然后加一 ，用于新增
			roleService.addRole(roleId, roleName);

			if (StringUtils.isNotEmpty(menIds)) {
				for (String men_id : menIds.split(",")) {
					roleService.addMenRole(Integer.valueOf(men_id), roleId);
				}
			}

			result.put("success", "新增成功");
			writeStream(result.toString(), "utf-8");
		} catch (Exception e) {
			result.put("error", "新增失败");
			writeStream(result.toString(), "utf-8");
		}

	}
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
//
//	public void setCookie(String memberToken, HttpServletResponse response) {
//		CookieUtil.addCookie(response, Constants.COOKIE_MEMBER_TOKEN, memberToken, Constants.COOKIE_TOKEN_MEMBER_TIME);
//	}

}
