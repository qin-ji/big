package com.qj.face.controller;

import java.util.ArrayList;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;
import java.util.Map;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import com.alibaba.fastjson.JSONObject;
import com.qj.face.base.BaseAction;
import com.qj.face.base.BaseRedisService;
import com.qj.face.base.RequestZuulBase;
import com.qj.face.base.RequestZuulURLEnum;
import com.qj.face.entity.MenEntity;
import com.qj.face.entity.ZuulEntity;
import com.qj.face.service.MenService;
import com.qj.face.service.RoleService;
@SuppressWarnings({"serial","unused"})
@Controller
@RequestMapping("/zuul")
public class ZuulController extends BaseAction<ZuulEntity>  {




	@RequestMapping(value = "/queryZuul", method = RequestMethod.GET)
	@ResponseBody
	public void queryZuul() {
		JSONObject result = new JSONObject();
		List<ZuulEntity> zuulList;
		try {
			zuulList = this.requestZuulListT(RequestZuulURLEnum.QUERY_ZUUL_LIST.getValue());
			result.put("status", 200);
			result.put("msg", "查询成功");
			result.put("total", zuulList.size());
			result.put("data", zuulList);
		} catch (Exception e) {
			result.put("status", -1);
			result.put("msg", e.getMessage());
		}
		writeStream(result.toString(), "utf-8");
	}

	@RequestMapping(value = "/updateZuul", method = RequestMethod.POST)
	@ResponseBody
	public void updateZuul() {
		JSONObject result = new JSONObject();
		String id = request.getParameter("id");
		String serviceId = request.getParameter("ServiceId");
		String path = request.getParameter("Path");
		String url = request.getParameter("URL");
		ZuulEntity zuul = new ZuulEntity();
		zuul.setId(id);
		zuul.setServiceId(serviceId);
		zuul.setPath(path);
		zuul.setUrl(url);
		zuul.setCustomSensitiveHeaders(false);
		zuul.setStripPrefix(true);
		zuul.setEnabled(true);
		ResponseEntity<Integer> res;
		try {
			res = this.requestZuulT(RequestZuulURLEnum.UPDATE_ZUUL.getValue(), zuul);
			result.put("success", "修改成功");
		} catch (Exception e) {
			result.put("error", e.getMessage());
		}
		writeStream(result.toString(), "utf-8");
	}

	@RequestMapping(value = "/addZuul", method = RequestMethod.POST)
	@ResponseBody
	public void addZuul() {
		JSONObject result = new JSONObject();
		String id = request.getParameter("id");
		String serviceId = request.getParameter("ServiceId");
		String path = request.getParameter("Path");
		String url = request.getParameter("URL");
		ZuulEntity zuul = new ZuulEntity();
		zuul.setId(id);
		zuul.setServiceId(serviceId);
		zuul.setPath(path);
		zuul.setUrl(url);
		zuul.setCustomSensitiveHeaders(false);
		zuul.setStripPrefix(true);
		zuul.setEnabled(true);
		
		ResponseEntity<Integer> res;
		try {
			 res = this.requestZuulT(RequestZuulURLEnum.ADD_ZUUL.getValue(), zuul);
			result.put("success", "新增成功");
		} catch (Exception e) {
			result.put("error", e.getMessage());
			
		}
		writeStream(result.toString(), "utf-8");
	}

	
	@RequestMapping(value = "/deleteZuul", method = RequestMethod.POST)
	@ResponseBody
	public void deleteZuul() {
		JSONObject result = new JSONObject();
		String ids = request.getParameter("ids");
		this.putMapInfo("id", ids);
		ResponseEntity<Integer> res;
		try {
			res = this.requestZuulMap(RequestZuulURLEnum.DELETE_ZUUL.getValue());
			System.out.println(res.getStatusCode());
			result.put("success", "删除成功");
		} catch (Exception e) {
			e.printStackTrace();
			result.put("error", e.getMessage());
			
		}
		writeStream(result.toString(), "utf-8");
	}

	
	

}
