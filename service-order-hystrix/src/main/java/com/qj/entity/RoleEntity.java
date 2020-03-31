package com.qj.entity;

import javax.persistence.Column;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Table(name = TableUtils.TABLE_ROLE)
public class RoleEntity {
	@Id
	@GeneratedValue  
	private int id;
	
	@Column(name = "role_id")
	private int roleId;
	
	@Column(name = "role_name")
	private String roleName;
	
	//所拥有的权限
	private String roleMen;
	
}
