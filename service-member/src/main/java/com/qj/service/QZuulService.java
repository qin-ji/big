package com.qj.service;

import java.util.List;

import com.qj.entity.ZuulEntity;

public interface QZuulService {
	
	List<ZuulEntity> getZuulAll();
	
	Integer addZuul(ZuulEntity zuulEntity);
	
	Integer updateZuul(ZuulEntity zuulEntity);
	
	Integer deleteZuul(String id);
	
}
