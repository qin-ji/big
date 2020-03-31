package com.qj.entity;

public class Men {
    private Integer id;

    private String menName;

    private String menUrl;

    private Integer menId;

    private String menButtonUrl;

    private Integer parentId;

    private String menButtonStyle;

    private String menType;

    private String menImage;

    private String menButtonImage;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMenName() {
        return menName;
    }

    public void setMenName(String menName) {
        this.menName = menName == null ? null : menName.trim();
    }

    public String getMenUrl() {
        return menUrl;
    }

    public void setMenUrl(String menUrl) {
        this.menUrl = menUrl == null ? null : menUrl.trim();
    }

    public Integer getMenId() {
        return menId;
    }

    public void setMenId(Integer menId) {
        this.menId = menId;
    }

    public String getMenButtonUrl() {
        return menButtonUrl;
    }

    public void setMenButtonUrl(String menButtonUrl) {
        this.menButtonUrl = menButtonUrl == null ? null : menButtonUrl.trim();
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public String getMenButtonStyle() {
        return menButtonStyle;
    }

    public void setMenButtonStyle(String menButtonStyle) {
        this.menButtonStyle = menButtonStyle == null ? null : menButtonStyle.trim();
    }

    public String getMenType() {
        return menType;
    }

    public void setMenType(String menType) {
        this.menType = menType == null ? null : menType.trim();
    }

    public String getMenImage() {
        return menImage;
    }

    public void setMenImage(String menImage) {
        this.menImage = menImage == null ? null : menImage.trim();
    }

    public String getMenButtonImage() {
        return menButtonImage;
    }

    public void setMenButtonImage(String menButtonImage) {
        this.menButtonImage = menButtonImage == null ? null : menButtonImage.trim();
    }
}