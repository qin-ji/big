package com.qj.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.qj.dao.ButtonDao;
import com.qj.entity.ButtonEntity;
import com.qj.service.ButtonService;
import com.qj.utils.BaseApiService;

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
