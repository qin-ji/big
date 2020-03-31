package com.qj.face.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.qj.face.base.BaseAction;
import com.qj.face.base.BaseRedisService;
import com.qj.face.base.ResponseBase;
import com.qj.face.constants.Constants;
import com.qj.face.entity.MenEntity;
import com.qj.face.service.MenService;
import com.qj.face.service.RoleService;
import com.qj.face.service.UserService;
import com.qj.face.utils.CookieUtil;
import com.qj.face.utils.DateUtils;
import org.hyperic.sigar.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

@Controller
public class IndexController extends BaseAction {

	@Autowired
	private UserService memberService;
	@Autowired
	private RoleService roleService;
	@Autowired
	private MenService menService;
	@Autowired
	protected BaseRedisService baseRedisService;

	private static final String LOGIN = "/login";
	private static final String INDEX = "/index";

	// 主页
	@RequestMapping(value = "/", method = RequestMethod.GET) 
	public String index(HttpServletRequest reqest) {
		try {
			// 1.从cookie中获取 token信息
			String token = CookieUtil.getUid(reqest, Constants.COOKIE_MEMBER_TOKEN);
			// 2.如果cookie 存在 token，调用会员服务接口，使用token查询用户信息
			if (null != token) {
				ResponseBase responseBase = memberService.findByTokenUser(token);
				if (responseBase.getRtnCode().equals(Constants.HTTP_RES_CODE_200)) {
					LinkedHashMap userData = JSON.parseObject(JSON.toJSONString(responseBase.getData()),
							LinkedHashMap.class);
					String username = (String) userData.get("username");
					String userimage = (String) userData.get("img_url");
					List<MenEntity> menList = menService.findMenByName(username);

					baseRedisService.setString("menList", JSONObject.toJSONString(menList), Constants.USER_MEN_TIME);
					baseRedisService.setString("userInfo", username, Constants.USER_MEN_TIME);
					baseRedisService.setString("color", "#0A0A0A", Constants.COLOR_TIME);
					reqest.setAttribute("username", username);
					reqest.setAttribute("userimage", userimage);
				}
				return INDEX;
			} else {
				return LOGIN;
			}
		} catch (Exception e) {
			return LOGIN;
		}
	}


	// get Men
	@RequestMapping(value = "/getMen", method = RequestMethod.POST)
	@ResponseBody
	public void getMen(HttpServletRequest reqest) {
		JSONObject result = new JSONObject();
		String jsonMenListStr = (String) baseRedisService.getString("menList");
		List<MenEntity> menList = JSONObject.parseArray(jsonMenListStr, MenEntity.class);

		result.put("success", "获取菜单成功！");
		result.put("menList", menList);
		writeStream(result.toString(), "utf-8");
	}

	@RequestMapping(value = "/SColor", method = RequestMethod.POST)
	@ResponseBody
	public void SColor() {
		JSONObject result = new JSONObject();
		String color = request.getParameter("color");
		baseRedisService.setString("color", color, Constants.COLOR_TIME);

		result.put("msg", "保存颜色成功！");
		writeStream(result.toString(), "utf-8");
	}

	@RequestMapping(value = "/GColor", method = RequestMethod.POST)
	@ResponseBody
	public void GColor() {
		JSONObject result = new JSONObject();
		String color = (String) baseRedisService.getString("color");
		result.put("msg", "获取颜色成功！");
		result.put("color", color);
		writeStream(result.toString(), "utf-8");
	}

	
	@RequestMapping(value = "/GButton", method = RequestMethod.POST)
	@ResponseBody
	public void GButton() {
		JSONObject result = new JSONObject();
		String jsonMenListStr = (String) baseRedisService.getString("menList");
		Integer menId = Integer.valueOf(request.getParameter("menId"));
		List<MenEntity> menList = JSONObject.parseArray(jsonMenListStr, MenEntity.class);
		List<MenEntity> newList = new ArrayList<MenEntity>();
		
		for (MenEntity m : menList) {
			if (m.getMenId() == menId) {
				for (MenEntity mm : menList) {
					if (mm.getParentId() == m.getMenId() && mm.getMenType().equals("button")) {
						newList.add(mm);
					}
				}
			}
		}
		System.out.println(JSONObject.toJSONString(newList));
		result.put("success", "查询成功");
		result.put("ButtonList", newList);
		writeStream(result.toString(), "utf-8");
	}
	

	
	
	
	@RequestMapping(value = "/getIndexInfo", method = RequestMethod.POST)
	@ResponseBody
	public void getIndexInfo() throws UnknownHostException, SigarException {
		JSONObject result = new JSONObject();
		String computerName = System.getenv().get("COMPUTERNAME");// 获取计算机名
		String ip = InetAddress.getLocalHost().getHostAddress();
		String s = DateUtils.currentFormatDate(DateUtils.DATE_TO_STRING_DETAIAL_PATTERN);

		String[] oneCPU = (String[]) request.getSession().getAttribute("oneCPU");
		String[] towCPU = (String[]) request.getSession().getAttribute("towCPU");
		String[] theeCPU = (String[]) request.getSession().getAttribute("theeCPU");
		String[] foCPU = (String[]) request.getSession().getAttribute("foCPU");
		String[] time = (String[]) request.getSession().getAttribute("time");
		String[] title = new String[4];
		title[0] = ("第一块CPU");
		title[1] = ("第二块CPU");
		title[2] = ("第三块CPU");
		title[3] = ("第四块CPU");
		if (oneCPU == null) {
			oneCPU = new String[7];
			towCPU = new String[7];
			theeCPU = new String[7];
			foCPU = new String[7];
			time = new String[7];
		}

		for (int i = 6; i >0; i--) {
				oneCPU[i] = oneCPU[i-1];
				towCPU[i] = towCPU[i-1];
				theeCPU[i] = theeCPU[i-1];
				foCPU[i] = foCPU[i-1];
				time[i] = time[i-1];
		}

		Sigar sigar = new Sigar();
		CpuPerc cpuList[] = null;
		cpuList = sigar.getCpuPercList();
		oneCPU[0] = (CpuPerc.format(cpuList[0].getCombined()).substring(0,CpuPerc.format(cpuList[0].getCombined()).indexOf("%")));
		towCPU[0] = (CpuPerc.format(cpuList[1].getCombined()).substring(0,CpuPerc.format(cpuList[1].getCombined()).indexOf("%")));
		theeCPU[0] = (CpuPerc.format(cpuList[2].getCombined()).substring(0,CpuPerc.format(cpuList[2].getCombined()).indexOf("%")));
		foCPU[0] = (CpuPerc.format(cpuList[3].getCombined()).substring(0,CpuPerc.format(cpuList[3].getCombined()).indexOf("%")));
		time[0] = (s.substring(s.indexOf(" ")));

		request.getSession().setAttribute("oneCPU", oneCPU);
		request.getSession().setAttribute("towCPU", towCPU);
		request.getSession().setAttribute("theeCPU", theeCPU);
		request.getSession().setAttribute("foCPU", foCPU);
		request.getSession().setAttribute("time", time);

		result.put("msg", "获取计算机信息成功！");
		result.put("computerName", computerName);
		result.put("ip", ip);
		result.put("oneCPU", oneCPU);
		result.put("towCPU", towCPU);
		result.put("theeCPU", theeCPU);
		result.put("foCPU", foCPU);
		result.put("time", time);
		result.put("title", title);
//		System.out.println(result.toString());
		writeStream(result.toString(), "utf-8");
	}

	@RequestMapping(value = "/getIndexJDTInfo", method = RequestMethod.POST)
	@ResponseBody
	public void getIndexJDTInfo() throws UnknownHostException, SigarException {
		JSONObject result = new JSONObject();
		Sigar sigar = new Sigar();
		CpuPerc cpuList[] = null;
		cpuList = sigar.getCpuPercList();

		result.put("CPU",CpuPerc.format(cpuList[0].getCombined()));
		 
	        FileSystem fslist[] = sigar.getFileSystemList();
	        for (int i = 0; i < fslist.length; i++) {
	          
	            FileSystem fs = fslist[i];
	            FileSystemUsage usage = null;
	            usage = sigar.getFileSystemUsage(fs.getDirName());
	            switch (fs.getType()) {
	            case 0: // TYPE_UNKNOWN ：未知
	                break;
	            case 1: // TYPE_NONE
	                break;
	            case 2: // TYPE_LOCAL_DISK : 本地硬盘
	                double usePercent = usage.getUsePercent() * 100D;
	                // 文件系统资源的利用率
	                if(fs.getDevName().contains("C")) {
	                	
	                	String C = String.valueOf(usePercent);
	                	if(C.contains(".")) {
	                		C=C.substring(0,C.indexOf("."));
	                	}
	                	result.put("C",C + "%");
	                }
	                break;
	            case 3:// TYPE_NETWORK ：网络
	                break;
	            case 4:// TYPE_RAM_DISK ：闪存
	                break;
	            case 5:// TYPE_CDROM ：光驱
	                break;
	            case 6:// TYPE_SWAP ：页面交换
	                break;
	            }
	        }
		writeStream(result.toString(), "utf-8");
	}
	
	

}
