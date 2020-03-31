package com.qj.entity;


import javax.persistence.Table;



import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Table(name = TableUtils.TABLE_USER_ROLE)
public class UserRoleEntity {
	private int id;
	private int roleId;
	private int userId;
	
}
