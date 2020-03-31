package com.qj.dao;

import java.util.List;


import javax.persistence.Column;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.qj.entity.ButtonEntity;
import com.qj.entity.TableUtils;

@Mapper
public interface ButtonDao {

	@Select("select id,but_pId as butPId,but_class as butClass,but_context as butContext,but_title as butTitle from "+TableUtils.TABLE_BUTTON)
	List<ButtonEntity> queryAllButton();
	
//	@SelectProvider(method="queryImage",type=GetSql.class)
//	List<ImageEntity> queryMen(@Param("start") int start,@Param("end") int end,@Param("menName") String menName,@Param("pId") String pId);
//	
//	
//	@SelectProvider(method="queryImageCount",type=GetSql.class)
//	int queryMenCount(@Param("menName") String menName,@Param("pId") String pId);
	
}
