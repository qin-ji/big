package com.qj.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.qj.entity.RoleEntity;


public interface RoleService {

	
	List<RoleEntity> queryRole(@Param("start") int start,@Param("end") int end,@Param("roleID") String roleID,@Param("roleName") String roleName);
	
	int queryRoleByParamCount(@Param("roleID") String roleID,@Param("roleName") String roleName);
	/**
	 * 根据角色名修改角色
	 * @param userName
	 * @return
	 */
	Integer updateRole (Integer roleName, Integer id);
	
	/**
	 * 给用户添加角色
	 * @param userName
	 * @return
	 */
	Integer userAddRole(Integer roleName,Integer id);
	
	
	/**
	 * 修改角色
	 * @param userName
	 * @return
	 */
	Integer updateRoleName(Integer role_id,String role_name);
	/**
	 * 给用户删除角色
	 * @param userName
	 * @return
	 */
	Integer deleteRole( Integer id);

	/**
	 * 给删除角色的权限
	 * @param userName
	 * @return
	 */
	Integer deleteRoleMen(Integer roleId);
	/**
	 * 给用户Id查询该用户是否拥有角色
	 * @param userName
	 * @return
	 */
	int selectRole( Integer id);
	
	/**
	 * 给角色名称查询角色ID
	 * @param userName
	 * @return
	 */
	List<RoleEntity>  selectRoleByRoleName();
	
	
	/**
	 * 获取角色表最大的ID
	 * @param userName
	 * @return
	 */
	int queryRoleId();
	/**
	 * 给角色表添加一个角色
	 * @param userName
	 * @return
	 */
	Integer addRole( Integer roleId, String roleName);
	
	/**
	 * 给角色菜单关联表添加一条信息
	 * @param userName
	 * @return
	 */
	Integer addMenRole(Integer men_id,Integer role_id);
	
}
