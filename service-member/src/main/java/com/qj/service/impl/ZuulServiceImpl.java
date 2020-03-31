package com.qj.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSONObject;
import com.qj.dao.ZuulDao;
import com.qj.entity.ZuulEntity;
import com.qj.service.QZuulService;

@Service
@Transactional
public class ZuulServiceImpl implements QZuulService {
	@Autowired
	private ZuulDao zuulDao;
	
	
	@Override
	public List<ZuulEntity> getZuulAll() {
		return zuulDao.getZuulAll();
	}


	@Override
	public Integer addZuul(ZuulEntity zuulEntity) {
		return zuulDao.addZuul(zuulEntity);
	}


	@Override
	public Integer updateZuul(ZuulEntity zuulEntity) {
		return zuulDao.updateZuul(zuulEntity);
	}


	@Override
	public Integer deleteZuul(String ids) {
		if(ids.contains(",")) {
			String []idss = ids.split(",");
			for (int i = 0; i < idss.length; i++) {
				zuulDao.deleteZuul(idss[i]);
			}
			return 1;
		}else {
			return zuulDao.deleteZuul(ids);
		}
		
	}

}
