package com.qj.entity;

import java.util.Date;


import javax.persistence.Table;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Table(name = TableUtils.TABLE_MEN_ROLE)
public class MenRoleEntity {
	private int id ; 
	private int men_id;
	private int role_id;
	
}
