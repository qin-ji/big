package com.qj.entity;

import javax.persistence.Column;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import com.qj.entity.TableUtils;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Table(name = TableUtils.TABLE_ZUUL)
public class ZuulEntity {
	
	@Id
	@GeneratedValue  
	private String id;
	
	@Column(name = "serviceId")
	private String serviceId;
	
	@Column(name = "url")
	private String url;
	
	@Column(name = "path")
	private String path;
	
	
	@Column(name = "location")
	private String location;
	
	@Column(name = "customSensitiveHeaders")
	private boolean customSensitiveHeaders;
	
	@Column(name = "stripPrefix")
	private boolean stripPrefix;
	
	@Column(name = "enabled")
	private boolean enabled;
	
}
