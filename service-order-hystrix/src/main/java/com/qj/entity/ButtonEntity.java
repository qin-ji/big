package com.qj.entity;

import javax.persistence.Column;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Table(name = TableUtils.TABLE_BUTTON)
public class ButtonEntity {
	@Id
	@GeneratedValue  
	private int id;
	
	@Column(name = "but_pId")
	private String butPId;
	
	@Column(name = "but_class")
	private String butClass;
	
	
	@Column(name = "but_context")
	private String butContext;
	
	
	@Column(name = "but_title")
	private String butTitle;
	
}
