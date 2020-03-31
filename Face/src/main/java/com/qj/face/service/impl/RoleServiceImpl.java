package com.qj.face.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.qj.face.base.BaseApiService;
import com.qj.face.dao.RoleDao;
import com.qj.face.entity.MenEntity;
import com.qj.face.entity.RoleEntity;
import com.qj.face.entity.UserEntity;
import com.qj.face.service.RoleService;

import lombok.extern.slf4j.Slf4j;

@Service
@Transactional
public class RoleServiceImpl extends BaseApiService implements RoleService {
	@Autowired
	private RoleDao roleDao;
 

	@Override
	public Integer updateRole(Integer roleName, Integer id) {
		return roleDao.updateRole(roleName, id);
	}
	
	@Override
	public Integer userAddRole(Integer roleName,Integer id) {
		return roleDao.userAddRole(roleName, id); 
	}
	

	public int selectRole( Integer id) {
		return roleDao.selectRole(id);
	}

	@Override
	public List<RoleEntity>  selectRoleByRoleName() {
		return roleDao.selectRoleByRoleName();
	}


	@Override
	public Integer deleteRole(Integer id) {
		return roleDao.deleteRole(id);
	}


	@Override
	public List<RoleEntity> queryRole(int start, int end, String roleID, String roleName) {
		int start_new = start == 1 ? 0 :  (start-1)* end; 
		return roleDao.queryRole(start_new, end, roleID, roleName);
	}


	@Override
	public int queryRoleByParamCount(String roleID, String roleName) {
		return roleDao.queryRoleByParamCount(roleID, roleName);
	}


	@Override
	public int queryRoleId() {
		return roleDao.queryRoleId();
	}


	@Override
	public Integer addRole(Integer roleId, String roleName) {
		return roleDao.addRole(roleId, roleName);
	}

	@Override 
	public Integer addMenRole(Integer men_id, Integer role_id) {
		return roleDao.addMenRole(men_id, role_id);
	}

	@Override
	public Integer deleteRoleMen(Integer roleId) {
		return roleDao.deleteRoleMen(roleId);
	}

	@Override
	public Integer updateRoleName(Integer role_id, String role_name) {
		return roleDao.updateRoleName(role_id, role_name);
	}

}
