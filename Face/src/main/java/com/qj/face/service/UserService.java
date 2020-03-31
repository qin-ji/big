package com.qj.face.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.qj.face.base.ResponseBase;
import com.qj.face.entity.UserEntity;



public interface UserService {
	// 查找用户信息
	List<UserEntity> queryUser(int indexPage,int pageSize,String userName,String phone,String date_s,String date_e);
	
	Integer getMaxId();
	
	int queryOrderByParamCount( String userName, String phone, String date_s, String date_e);
	
	// 批量删除
	Integer deleteUserByIds(String ids); 
	
	//修改
	Integer updateUser(UserEntity userEntity);

	
	// 使用userId查找用户信息
	@RequestMapping("/findUserById")
	ResponseBase findUserById(Long userId);

	@RequestMapping("/regUser")
	ResponseBase regUser(@RequestBody UserEntity user);

	// 用户登录
	@RequestMapping("/login")
	ResponseBase login(@RequestBody UserEntity user);
    // 使用token进行登录
	@RequestMapping("/findByTokenUser")
	ResponseBase findByTokenUser(@RequestParam("token") String token);
    //使用openid查找用户信息
	@RequestMapping("/findByOpenIdUser")
	ResponseBase findByOpenIdUser(@RequestParam("openid") String openid);
	// 用户登录
	@RequestMapping("/qqLogin")
	ResponseBase qqLogin(@RequestBody UserEntity user);
}
