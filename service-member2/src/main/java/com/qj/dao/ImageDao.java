package com.qj.dao;

import java.util.List;


import javax.persistence.Column;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.qj.entity.ImageEntity;
import com.qj.entity.TableUtils;

@Mapper
public interface ImageDao {

	@Select("select id,img_name as imgName,img_url as imgUrl,img_context as imgContext from "+TableUtils.TABLE_IMAGE)
	List<ImageEntity> queryAllImage();
	
//	@SelectProvider(method="queryImage",type=GetSql.class)
//	List<ImageEntity> queryMen(@Param("start") int start,@Param("end") int end,@Param("menName") String menName,@Param("pId") String pId);
//	
//	
//	@SelectProvider(method="queryImageCount",type=GetSql.class)
//	int queryMenCount(@Param("menName") String menName,@Param("pId") String pId);
	
}
