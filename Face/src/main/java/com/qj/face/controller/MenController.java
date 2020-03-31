package com.qj.face.controller;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.qj.face.base.BaseAction;
import com.qj.face.base.BaseRedisService;
import com.qj.face.constants.Constants;
import com.qj.face.entity.MenEntity;
import com.qj.face.entity.RoleEntity;
import com.qj.face.entity.UserEntity;
import com.qj.face.service.MenService;
import com.qj.face.service.RoleService;
import com.qj.face.service.UserService;
import com.qj.face.utils.DateUtils;
import com.qj.face.utils.MD5Util;
import com.smart.utils.StringUtils;

@Controller
@RequestMapping("/men")
public class MenController extends BaseAction {

	@Autowired
	private MenService MenService;

	@Autowired
	protected BaseRedisService baseRedisService;

	// ************************************************************************

	/**
	 * 获取用户管理页面按钮
	 */
	@RequestMapping(value = "/getMenButton", method = RequestMethod.POST)
	@ResponseBody
	public void getUserButton() {
		JSONObject result = new JSONObject();
		String jsonMenListStr = (String) baseRedisService.getString("menList");
		List<MenEntity> menList = JSONObject.parseArray(jsonMenListStr, MenEntity.class);
		List<MenEntity> newList = new ArrayList<MenEntity>();

		for (MenEntity m : menList) {
			if (m.getMenId() == 7) {

				for (MenEntity mm : menList) {
					if (mm.getParentId() == m.getId() && mm.getMenType().equals("button")) {
						newList.add(mm);
					}
				}
			}
		}
		result.put("msg", "查询成功");
		result.put("menButtonList", newList);
		writeStream(result.toString(), "utf-8");

	}

	/**
	 * 获取men页面新增 修改，弹窗下拉框信息 根据传递进来的类型判断是按钮还是 页面，然后查询出不同的下拉框信息
	 */
	@RequestMapping(value = "/getMenOrButton", method = RequestMethod.POST)
	@ResponseBody
	public void getMenOrButton() {
		JSONObject result = new JSONObject();
		String type = request.getParameter("type");

		List<MenEntity> newList = MenService.findAllMen();
//		for (MenEntity menEntity : menList) {
//			if(menEntity.getMenType().equals(type))
//			{
//				newList.add(menEntity);
//			}
//		}

		result.put("msg", "查询成功");
		result.put("menOrButtonList", newList);
		writeStream(result.toString(), "utf-8");

	}

	@RequestMapping(value = "/addMen", method = RequestMethod.POST)
	@ResponseBody
	public void deleteUser() {
		JSONObject result = new JSONObject();

		String menName = request.getParameter("menName");
		String menImage = request.getParameter("menImage");
		String buttonStyle = request.getParameter("buttonStyle");
		String pageURL = request.getParameter("pageURL");
		String buttonURL = request.getParameter("buttonURL");
		String pranetId = request.getParameter("pranetId");
		String type = request.getParameter("type");
		String menButtonImage = request.getParameter("menButtonImage");

		MenEntity men = new MenEntity();
		men.setMenName(menName);
		men.setMenType(type);
		men.setMenId(MenService.queryMaxMenId() + 1);
		if (StringUtils.isEmpty(pranetId)) {
			men.setMenType("menu bar");
		} else {
			men.setParentId(Integer.valueOf(pranetId));
		}

		if ("men".equals(type)) {
			men.setMenImage(menImage);
			men.setMenUrl(pageURL);
		} else {
			men.setMenButtonStyle(buttonStyle);
			men.setMenButtonUrl(buttonURL);
			men.setMenButtonImage(menButtonImage);
		}

		try {
			MenService.addMen(men);
			result.put("success", "新增成功");
		} catch (Exception e) {
			result.put("error", "新增失败");
		}
		writeStream(result.toString(), "utf-8");
	}

	@RequestMapping(value = "/queryMen", method = RequestMethod.GET)
	@ResponseBody
	public void queryMen() {
		JSONObject result = new JSONObject();

		Integer indexPage = Integer.valueOf(request.getParameter("indexPage"));
		Integer pageSize = Integer.valueOf(request.getParameter("pageSize"));

		String menName = request.getParameter("menName");
		String pId = request.getParameter("pId");
		List<MenEntity> mensList = (List<MenEntity>) MenService.queryMen(indexPage, pageSize, menName, pId);

		for (MenEntity menEntity : mensList) {
			menEntity.setMenImage("<i class='layui-icon " + menEntity.getMenImage() + "'></i>");
		}
		result.put("status", 200);
		result.put("msg", "查询成功");
		result.put("total", MenService.queryMenCount(menName, pId));
		result.put("data", mensList);
		writeStream(result.toString(), "utf-8");

	}

	@RequestMapping(value = "/deleteMen", method = RequestMethod.POST)
	@ResponseBody
	public void deleteMen() {
		JSONObject result = new JSONObject();

		String ids = request.getParameter("ids");

		if (MenService.deleteMenByIds(ids) > 0) {
			result.put("msg", "删除成功");
		} else {
			result.put("msg", "删除失败");
		}
		writeStream(result.toString(), "utf-8");
	}

	@RequestMapping(value = "/updateMen", method = RequestMethod.POST)
	@ResponseBody
	public void updateMen() {
		JSONObject result = new JSONObject();
		String id = request.getParameter("id");
		String menName = request.getParameter("menName");
		String menImage = request.getParameter("menImage");
		String buttonStyle = request.getParameter("buttonStyle");
		String pageURL = request.getParameter("pageURL");
		String buttonURL = request.getParameter("buttonURL");
		String pranetId = request.getParameter("pranetId");
		String type = request.getParameter("type");
		String menId = request.getParameter("menId");
		String menButtonImage = request.getParameter("menButtonImage");

		// start: 处理按钮样式 layui-btn
		int index = 0;
		String style = "";
		if (StringUtils.isNotEmpty(buttonStyle)) {
			for (String bs : buttonStyle.split(" ")) {
				if (bs.equals("layui-btn")) {
					index++;
					if (index == 1) {
						if (style.equals("")) {
							style = bs;
						} else {
							style += " " + bs;
						}
					}
				} else {
					if (style.equals("")) {
						style = bs;
					} else {
						style += " " + bs;
					}
				}

			}
		}
		// end: 处理按钮样式 layui-btn
		MenEntity men = new MenEntity();
		men.setId(StringUtils.isNotEmpty(id) ? Integer.valueOf(id) : 0);
		men.setMenName(menName);
		men.setMenType(type);

		if (StringUtils.isEmpty(pranetId)) {
			men.setMenType("menu bar");
		} else {
			men.setParentId(Integer.valueOf(pranetId));
		}

		if ("men".equals(type)) {
			men.setMenImage(menImage);
			men.setMenUrl(pageURL);
		} else {
			men.setMenButtonStyle(style);
			men.setMenButtonUrl(buttonURL);
			men.setMenButtonImage(menButtonImage);
		}

		try {
			System.out.println("11");
			MenService.updateMen(men);
			baseRedisService.delKey("menList");
			String userName = (String) baseRedisService.getString("userInfo");
			List<MenEntity> menList = MenService.findMenByName(userName);
			baseRedisService.setString("menList", JSONObject.toJSONString(menList), Constants.USER_MEN_TIME);
			result.put("success", "修改成功");
		} catch (Exception e) {
			result.put("error", "修改失败");
		}
		writeStream(result.toString(), "utf-8");

	}

}
