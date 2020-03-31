package com.qj.face.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.qj.face.base.BaseApiService;
import com.qj.face.dao.ImageDao;
import com.qj.face.dao.RoleDao;
import com.qj.face.entity.ImageEntity;
import com.qj.face.entity.MenEntity;
import com.qj.face.entity.RoleEntity;
import com.qj.face.service.ImageService;
import com.qj.face.service.RoleService;

import lombok.extern.slf4j.Slf4j;

@Service
@Transactional
public class ImageServiceImpl extends BaseApiService implements ImageService {
	@Autowired
	private ImageDao imageDao;

	@Override
	public List<ImageEntity> queryAllImage() {
		
		return imageDao.queryAllImage();
	}
 


}
