package com.qj.face.dao;

import java.util.List;


import javax.persistence.Column;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.Update;

import com.qj.face.base.GetSql;
import com.qj.face.entity.MenEntity;
import com.qj.face.entity.RoleEntity;
import com.qj.face.entity.UserEntity;
@Mapper
public interface RoleDao {
	
	
	
	@SelectProvider(method="queryRoleByParam",type=GetSql.class)
	List<RoleEntity> queryRole(@Param("start") int start,@Param("end") int end,@Param("roleID") String roleID,@Param("roleName") String roleName);
	
	@SelectProvider(method="queryRoleByParamCount",type=GetSql.class)
	int queryRoleByParamCount(@Param("roleID") String roleID,@Param("roleName") String roleName);
	
	
	
	
	/**
	 * 根据角色名修改用户角色
	 * @param userName
	 * @return
	 */
	@Update("UPDATE  `user_role` u SET u.role_id = #{roleid}  WHERE u.id = #{id}")
	Integer updateRole(@Param("roleid") Integer roleid,@Param("id") Integer id);
	
	/**
	 * 给用户添加角色
	 * @param userName
	 * @return
	 */
	@Insert("INSERT INTO user_role (role_id,user_id) VALUES(#{roleid},#{id})")
	Integer userAddRole(@Param("roleid") Integer roleid,@Param("id") Integer id);
	
	
	
	/**
	 * 修改角色
	 * @param userName
	 * @return
	 */
	@Update("UPDATE  `role` r SET r.role_name = #{role_name}  WHERE r.role_id = #{role_id}")
	Integer updateRoleName( @Param("role_id") Integer role_id,@Param("role_name") String role_name);
	/**
	 * 给删除角色
	 * @param userName
	 * @return
	 */
	@Delete("delete from role where id=#{id}")
	Integer deleteRole( @Param("id") Integer id);
	
	/**
	 * 给删除角色的权限
	 * @param userName
	 * @return
	 */
	@Delete("delete from men_role where role_id=#{roleId}")
	Integer deleteRoleMen( @Param("roleId") Integer roleId);
	
	/**
	 * 给用户Id查询该用户是否拥有角色
	 * @param userName
	 * @return
	 */
	@Select("SELECT COUNT(*) FROM user_role WHERE user_id = #{id}")
	int selectRole(@Param("id") Integer id);
	
	
	/**
	 * 给角色名称查询角色ID
	 * @param userName
	 * @return
	 */
	@Select("SELECT id as id , role_id as roleId , role_name as roleName  FROM role ")
	List<RoleEntity> selectRoleByRoleName();
	

	/**
	 * 获取角色表的最大的角色 ID
	 * @param userName
	 * @return
	 */
	@Select("select max(role_id) as roleId from role")
	int queryRoleId();
	
	
	/**
	 * 给角色表添加一个角色
	 * @param userName
	 * @return
	 */
	@Insert("INSERT INTO role (role_id,role_name) VALUES(#{roleId},#{roleName})")
	Integer addRole(@Param("roleId") Integer roleId,@Param("roleName") String roleName);
	
	
	/**
	 * 给角色菜单关联表添加一条信息
	 * @param userName
	 * @return
	 */
	@Insert("INSERT INTO men_role (men_id,role_id) VALUES(#{men_id},#{role_id})")
	Integer addMenRole(@Param("men_id") Integer men_id,@Param("role_id") Integer role_id);
	
	

}
