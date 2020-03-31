package com.qj.face.entity;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import com.qj.face.base.TableUtils;

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


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMenName() {
		return menName;
	}

	public void setMenName(String menName) {
		this.menName = menName;
	}

	public String getMenUrl() {
		return menUrl;
	}

	public void setMenUrl(String menUrl) {
		this.menUrl = menUrl;
	}

	public int getMenId() {
		return menId;
	}

	public void setMenId(int menId) {
		this.menId = menId;
	}

	public String getMenButtonUrl() {
		return menButtonUrl;
	}

	public void setMenButtonUrl(String menButtonUrl) {
		this.menButtonUrl = menButtonUrl;
	}

	public int getParentId() {
		return parentId;
	}

	public void setParentId(int parentId) {
		this.parentId = parentId;
	}

	public String getMenButtonStyle() {
		return menButtonStyle;
	}

	public void setMenButtonStyle(String menButtonStyle) {
		this.menButtonStyle = menButtonStyle;
	}

	public String getMenType() {
		return menType;
	}

	public void setMenType(String menType) {
		this.menType = menType;
	}

	public String getMenImage() {
		return menImage;
	}

	public void setMenImage(String menImage) {
		this.menImage = menImage;
	}

	public String getMenButtonImage() {
		return menButtonImage;
	}

	public void setMenButtonImage(String menButtonImage) {
		this.menButtonImage = menButtonImage;
	}
}
