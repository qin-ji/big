package com.qj.service.impl;

import java.util.List;

import com.qj.utils.*;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.alibaba.fastjson.JSONObject;
import com.qj.dao.UserDao;
import com.qj.entity.UserEntity;
import com.qj.service.QUserService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@Transactional
public class UserServiceImpl  extends BaseApiService    implements QUserService {
	@Autowired
	private UserDao memberDao;
	

	@Override
	public ResponseBase findUserById(Long userId) {
		UserEntity user = memberDao.findByID(userId);
		if (user == null) {
			return setResultError("未查找到用户信息.");
		}
		return setResultSuccess(user);
	}
	
	@Override
	public Integer getMaxId() {
		return memberDao.getMaxId();
	}

	@Override
	public ResponseBase regUser(@RequestBody UserEntity user) {
		// 参数验证
		String password = user.getPassword();
		if (StringUtils.isEmpty(password)) {
			return setResultError("密码不能为空.");
		}
		String newPassword = MD5Util.MD5(password);
		user.setPassword(newPassword);
		user.setCreated(DateUtils.currentFormatDate(DateUtils.DATE_TO_STRING_DETAIAL_PATTERN));
		user.setUpdated(DateUtils.currentFormatDate(DateUtils.DATE_TO_STRING_DETAIAL_PATTERN));
		Integer result = memberDao.insertUser(user);
		if (result <= 0) {
			return setResultError("注册用户信息失败.");
		}else {
			return setResultSuccess("用户注册成功.");
		}
	}

	

	@Override
	public ResponseBase login(@RequestBody UserEntity user) {
		// 1.验证参数
		String username = user.getUsername();
		if (StringUtils.isEmpty(username)) {
			return setResultError("用戶名称不能为空!");
		}
		String password = user.getPassword();
		if (StringUtils.isEmpty(password)) {
			return setResultError("密码不能为空!");
		}
		// 2.数据库查找账号密码是否正确
		String newPassWrod = MD5Util.MD5(password);
		UserEntity userEntity = memberDao.login(username, newPassWrod);
		return setLogin(userEntity);

	}

	private ResponseBase setLogin(UserEntity userEntity) {
		
		if (userEntity == null) {
			return setResultError("账号或者密码不能正确");
		}
		// 3.如果账号密码正确，对应生成token
		String memberToken = TokenUtils.getMemberToken();
		// 4.存放在redis中，key为token value 为 userid
		Integer userId = userEntity.getId();
		log.info("####用户信息token存放在redis中... key为:{},value", memberToken, userId);
		baseRedisService.setString(memberToken, userId + "", Constants.TOKEN_MEMBER_TIME);
		// 5.直接返回token
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("memberToken", memberToken);
		return setResultSuccess(jsonObject);
	}

	@Override
	public ResponseBase findByTokenUser(@RequestParam("token") String token) {
		// 1.验证参数
		if (StringUtils.isEmpty(token)) {
			return setResultError("token不能为空!");
		}
		// 2.从redis中 使用token 查找对应 userid
		String strUserId = (String) baseRedisService.getString(token);
		if (StringUtils.isEmpty(strUserId)) {
			return setResultError("token无效或者已经过期!");
		}
		// 3.使用userid数据库查询用户信息返回给客户端
		Long userId = Long.parseLong(strUserId);
		UserEntity userEntity = memberDao.findByID(userId);
		if (userEntity == null) {
			return setResultError("为查找到该用户信息");
		}
		userEntity.setPassword(null);
		return setResultSuccess(userEntity);
	}

	@Override
	public ResponseBase findByOpenIdUser(@RequestParam("openid") String openid) {
		// 1.验证参数
		if (StringUtils.isEmpty(openid)) {
			return setResultError("openid不能为空1");
		}
		// 2.使用openid 查询数据库 user表对应数据信息
		UserEntity userEntity = memberDao.findByOpenIdUser(openid);
		if (userEntity == null) {
			return setResultError(Constants.HTTP_RES_CODE_201, "该openid没有关联");
		}
		// 3.自动登录
		return setLogin(userEntity);
	}

	@Override
	public ResponseBase qqLogin(@RequestBody UserEntity user) {
		// 1.验证参数
		String openid = user.getOpenid();
		if (StringUtils.isEmpty(openid)) {
			return setResultError("openid不能为空!");
		}
		// 2.先进行账号登录
		ResponseBase setLogin = login(user);
		if (!setLogin.getRtnCode().equals(Constants.HTTP_RES_CODE_200)) {
			return setLogin;
		}
		// 3.自动登录
		JSONObject jsonObjcet = (JSONObject) setLogin.getData();
		// 4. 获取token信息
		String memberToken = jsonObjcet.getString("memberToken");
		ResponseBase userToken = findByTokenUser(memberToken);
		if (!userToken.getRtnCode().equals(Constants.HTTP_RES_CODE_200)) {
			return userToken;
		}
		UserEntity userEntity =(UserEntity) userToken.getData();
		// 5.修改用户openid
		Integer userId = userEntity.getId();
		Integer updateByOpenIdUser = memberDao.updateByOpenIdUser(openid, userId);
		if (updateByOpenIdUser <= 0) {
			return setResultError("QQ账号管理失败!");
		}
		return setLogin;
	}

	@Override
	public List<UserEntity> queryUser(String requestText) {
		JSONObject jsonobject = JsonUtils.getJsonInfo("requestText",requestText);
		int indexPage =1;
		if( null != jsonobject.getInteger("indexPage")) {
			indexPage = jsonobject.getInteger("indexPage") ;
		}
		int pageSize = 10;
		if( null != jsonobject.getInteger("pageSize")) {
			pageSize = jsonobject.getInteger("pageSize") ;
		}
		String userName = jsonobject.getString("userName");
		String phone = jsonobject.getString("phone");
		String date_c = jsonobject.getString("date_c");
		String date_e = jsonobject.getString("date_e");
		int start = indexPage == 1 ? 0 :  (indexPage-1)* pageSize; 
		return memberDao.queryUser(start,pageSize,userName,phone,date_c,date_e);
	}

	@Override
	public Integer deleteUserByIds(String ids) { 
		Integer num = 0;
		if(StringUtils.isNotEmpty(ids)) {
			for (int i = 0; i < ids.split(",").length; i++) {
				 num+= memberDao.deleteUserByIds(ids);
			}
		}
		return num;
		
	}

	@Override
	public Integer updateUser(UserEntity userEntity) {
		return memberDao.updateUser(userEntity);
	}

	@Override
	public int queryOrderByParamCount(String userName, String phone, String date_s, String date_e) {
		return memberDao.queryOrderByParamCount(userName, phone, date_s, date_e);
	}
}
