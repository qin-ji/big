package com.qj.face.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.qj.face.entity.MenEntity;
import com.qj.face.entity.RoleEntity;
import com.qj.face.entity.UserEntity;

public interface MenService {
	/**
	 * 根据用户名查询用户所拥有权限
	 * @param userName
	 * @return
	 */
	List<MenEntity> findMenByName(String userName);
	
	/**
	 * 根据角色ID查询用户所拥有权限
	 * @param userName
	 * @return
	 */
	List<MenEntity> findMenByroleId(@Param("roleID") int roleID);

	
	List<MenEntity> findAllMen();
	List<MenEntity> queryMen( int start,int end, String menName,String pId);
	
	int queryMenCount(String menName,String pId);
	
	int queryMaxMenId();
	
	Integer addMen(MenEntity men);
	
	Integer updateMen(MenEntity men);
	
	Integer deleteMenByIds( String ids);
}
