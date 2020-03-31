package com.qj.face.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.alibaba.fastjson.JSONObject;
import com.qj.face.base.BaseAction;
import com.qj.face.base.BaseRedisService;
import com.qj.face.entity.ButtonEntity;
import com.qj.face.service.ButtonService;

@Controller
@RequestMapping("/button")
public class ButtonController extends BaseAction<ButtonEntity> {

	




	@Autowired
	private ButtonService buttonervice;
	@Autowired
	protected BaseRedisService baseRedisService;



	@RequestMapping(value = "/getAllButton", method = RequestMethod.POST)
	@ResponseBody
	public void getIndexJDTInfo()  {
		JSONObject result = new JSONObject();
		List<ButtonEntity> buttonList = buttonervice.queryAllButton();

		result.put("buttonList",buttonList);
		result.put("msg","获取按钮成功");
		writeStream(result.toString(), "utf-8");
	}
	
	

}
