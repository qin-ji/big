package com.qj.entity;

import javax.persistence.Column;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Table(name = TableUtils.TABLE_IMAGE)
public class ImageEntity {
	@Id
	@GeneratedValue  
	private int id;
	
	@Column(name = "img_name")
	private String imgName;
	
	@Column(name = "img_url")
	private String imgUrl;
	
	
	@Column(name = "img_context")
	private String imgContext;
	
	
}
