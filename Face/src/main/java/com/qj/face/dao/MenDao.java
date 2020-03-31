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
import com.qj.face.entity.MenEntity;
import com.qj.face.entity.UserEntity;

@Mapper
public interface MenDao {

	
	/**
	 * 根据角色ID查询用户所拥有权限
	 * @param userName
	 * @return
	 */
	@Select("SELECT men_name as menName,men_id as menId FROM `men` WHERE men_id IN (SELECT men_id FROM `men_role` WHERE role_id = #{roleID} )")
	List<MenEntity> findMenByroleId(@Param("roleID") int roleID);
	

	/**
	 * 查询所有men
	 * @param userName
	 * @return
	 */
	@Select("SELECT id,men_name as menName,men_url as menUrl,men_id as menId, men_button_url as menButtonUrl,parent_id as parentId,men_button_style as menButtonStyle ,men_type as menType ,men_image as menImage,men_button_image as menButtonImage  FROM `men`")
	List<MenEntity> findAllMen();
	
	/**
	 * 根据用户名查询用户所拥有权限
	 * @param userName
	 * @return
	 */
	@Select("SELECT id,men_name as menName,men_url as menUrl,men_id as menId, men_button_url as menButtonUrl,parent_id as parentId,men_button_style as menButtonStyle ,men_type as menType ,men_image as menImage,men_button_image as menButtonImage FROM `men` WHERE men_id IN (SELECT men_id FROM `men_role` WHERE role_id IN (SELECT role_id FROM `user_role` WHERE user_id = (SELECT id FROM `mb_user` WHERE username = #{userName})))")
	List<MenEntity> findMenByName(@Param("userName") String userName);
	
	@SelectProvider(method="queryMen",type=GetSql.class)
	List<MenEntity> queryMen(@Param("start") int start,@Param("end") int end,@Param("menName") String menName,@Param("pId") String pId);
	
	
	@SelectProvider(method="queryMenCount",type=GetSql.class)
	int queryMenCount(@Param("menName") String menName,@Param("pId") String pId);
	
	@Select("select max(men_id) as menId from men")
	int queryMaxMenId();
	
	@SelectProvider(method="addMen",type=GetSql.class)
	Integer addMen(MenEntity men);
	
	
	@SelectProvider(method="updateMen",type=GetSql.class)
	Integer updateMen(MenEntity men);
	
	
	@Delete("DELETE FROM men WHERE id IN (#{ids})")
	Integer deleteMenByIds(@Param("ids") String ids);
}
