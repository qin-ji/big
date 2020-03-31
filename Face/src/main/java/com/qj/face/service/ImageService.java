package com.qj.face.service;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;

import com.qj.face.entity.ImageEntity;
import com.qj.face.entity.MenEntity;
import com.qj.face.entity.RoleEntity;

public interface ImageService {

	List<ImageEntity> queryAllImage();

}
