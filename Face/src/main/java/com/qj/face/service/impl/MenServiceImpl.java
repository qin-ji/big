package com.qj.face.service.impl;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.qj.face.base.BaseApiService;
import com.qj.face.dao.MenDao;
import com.qj.face.dao.RoleDao;
import com.qj.face.entity.MenEntity;
import com.qj.face.entity.RoleEntity;
import com.qj.face.entity.UserEntity;
import com.qj.face.service.MenService;
import com.qj.face.service.RoleService;
import com.smart.utils.StringUtils;

import lombok.extern.slf4j.Slf4j;

@Service
@Transactional
public class MenServiceImpl extends BaseApiService implements MenService {
	@Autowired
	private MenDao menDao;
 
	@Override
	public List<MenEntity> findMenByName(String userName) {
		return menDao.findMenByName(userName);
	}
	
	@Override
	public List<MenEntity> queryMen( int start, int end,String menName, String pId){
		int start_new = start == 1 ? 0 :  (start-1)* end; 
		return menDao.queryMen(start_new, end, menName, pId);
	}

	@Override
	public int queryMenCount(String menName, String pId) {
		return menDao.queryMenCount(menName, pId);
	}
 
	@Override
	public int queryMaxMenId() {
		return menDao.queryMaxMenId();
	}

	@Override
	public Integer addMen(MenEntity men) {
		return menDao.addMen(men);
	}

	@Override
	public Integer updateMen(MenEntity men) {
		return menDao.updateMen(men);
	}

	@Override
	public Integer deleteMenByIds(String ids) {
		Integer num = 0;
		if(StringUtils.isNotEmpty(ids)) {
			for (int i = 0; i < ids.split(",").length; i++) {
				 num+=menDao.deleteMenByIds(ids.split(",")[i]);
			}
		}
		return num;
		
	}

	@Override
	public List<MenEntity> findMenByroleId(int roleID) {
		return menDao.findMenByroleId(roleID);
	}

	@Override
	public List<MenEntity> findAllMen() {
		return menDao.findAllMen();
	}

	
}
