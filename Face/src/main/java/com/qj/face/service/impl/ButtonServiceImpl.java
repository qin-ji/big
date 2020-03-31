package com.qj.face.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.qj.face.base.BaseApiService;
import com.qj.face.dao.ButtonDao;
import com.qj.face.dao.ImageDao;
import com.qj.face.dao.RoleDao;
import com.qj.face.entity.ButtonEntity;
import com.qj.face.entity.ImageEntity;
import com.qj.face.entity.MenEntity;
import com.qj.face.entity.RoleEntity;
import com.qj.face.service.ButtonService;
import com.qj.face.service.ImageService;
import com.qj.face.service.RoleService;

import lombok.extern.slf4j.Slf4j;

@Service
@Transactional
public class ButtonServiceImpl extends BaseApiService implements ButtonService {
	@Autowired
	private ButtonDao buttonDao;

	@Override
	public List<ButtonEntity> queryAllButton() {
		return buttonDao.queryAllButton();
	}

	
 


}
