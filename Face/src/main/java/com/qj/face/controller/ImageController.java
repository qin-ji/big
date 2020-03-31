package com.qj.face.controller;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.hyperic.sigar.CpuInfo;
import org.hyperic.sigar.CpuPerc;
import org.hyperic.sigar.FileSystem;
import org.hyperic.sigar.FileSystemUsage;
import org.hyperic.sigar.Sigar;
import org.hyperic.sigar.SigarException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.qj.face.base.BaseAction;
import com.qj.face.base.BaseRedisService;
import com.qj.face.base.ResponseBase;
import com.qj.face.constants.Constants;
import com.qj.face.entity.ImageEntity;
import com.qj.face.entity.MenEntity;
import com.qj.face.service.ImageService;
import com.qj.face.service.MenService;
import com.qj.face.service.RoleService;
import com.qj.face.service.UserService;
import com.qj.face.utils.CookieUtil;
import com.qj.face.utils.DateUtils;

@Controller
@RequestMapping("/image")
public class ImageController extends BaseAction {

	
	@Autowired
	private ImageService imageService;
	@Autowired
	protected BaseRedisService baseRedisService;



	@RequestMapping(value = "/getAllImage", method = RequestMethod.POST)
	@ResponseBody
	public void getIndexJDTInfo()  {
		JSONObject result = new JSONObject();
		List<ImageEntity> imageList = imageService.queryAllImage();

		result.put("imageList",imageList);
		result.put("msg","获取图标成功");
		writeStream(result.toString(), "utf-8");
	}
	
	

}
