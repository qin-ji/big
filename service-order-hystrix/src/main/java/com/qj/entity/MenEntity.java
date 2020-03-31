package com.qj.entity;

import javax.persistence.Column;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Table(name = TableUtils.TABLE_MEN)
public class MenEntity {
	@Id
	@GeneratedValue  
	private int id;
	
	@Column(name = "men_name")
	private String menName;
	
	@Column(name = "men_url")
	private String menUrl;
	
	@Column(name = "men_id")
	private int menId;
	
	@Column(name = "men_button_url")
	private String menButtonUrl;

	@Column(name = "parent_id")
	private int parentId;
	
	@Column(name = "men_button_style")
	private String menButtonStyle;
	
	@Column(name = "men_type")
	private String menType;
	
	@Column(name = "men_image")
	private String menImage;
	
	@Column(name = "men_button_image")
	private String menButtonImage;
	
}
