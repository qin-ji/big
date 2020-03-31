package com.qj.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.qj.dao.ImageDao;
import com.qj.entity.ImageEntity;
import com.qj.service.ImageService;

@Service
@Transactional
public class ImageServiceImpl  implements ImageService {
	@Autowired
	private ImageDao imageDao;

	@Override
	public List<ImageEntity> queryAllImage() {
		
		return imageDao.queryAllImage();
	}
 


}
