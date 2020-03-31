package com.qj.face.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;

import com.qj.face.base.GetSql;
import com.qj.face.entity.UserEntity;

@Mapper
public interface UserDao {

	@Select("select  id,username,password,phone,email,created,updated ,openid,img_url from mb_user where id =#{userId}")
	UserEntity findByID(@Param("userId") Long userId);
	
	@Select("select  max(id) from mb_user")
	Integer getMaxId();
	
	@SelectProvider(method="queryOrderByParam",type=GetSql.class)
	List<UserEntity> queryUser(@Param("start") int start,@Param("end") int end,@Param("userName") String userName,@Param("phone") String phone,@Param("date_s") String date_s,@Param("date_e") String date_e);
	
	@SelectProvider(method="queryOrderByParamCount",type=GetSql.class)
	int queryOrderByParamCount(@Param("userName") String userName,@Param("phone") String phone,@Param("date_s") String date_s,@Param("date_e") String date_e);
	
	
	@UpdateProvider(method="updateUser",type=GetSql.class)
	Integer updateUser(UserEntity userEntity);
	
	@Insert("INSERT  INTO `mb_user`  (username,password,phone,email,created,updated,roleName,img_url) VALUES (#{username}, #{password},#{phone},#{email},#{created},#{updated},#{roleName},#{img_url});")
	Integer insertUser(UserEntity userEntity);

	@Select("select  id,username,password,phone,email,created,updated ,openid from mb_user where username=#{username} and password=#{password}")
	UserEntity login(@Param("username") String username, @Param("password") String password);

	@Select("select  id,username,password,phone,email,created,updated ,openid from mb_user where openid =#{openid}")
	UserEntity findByOpenIdUser(@Param("openid") String openid);

	@Update("update mb_user set openid=#{openid} where id=#{userId}")
	Integer updateByOpenIdUser(@Param("openid") String openid, @Param("userId") Integer userId);
	
	@Delete("DELETE FROM mb_user WHERE id IN (#{ids})")
	Integer deleteUserByIds(@Param("ids") String ids);
}
