package com.qj.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.Update;

import com.qj.entity.ZuulEntity;

@Mapper
public interface ZuulDao {
	
	@Select("select  *  from zuul_api")
	public List<ZuulEntity> getZuulAll();
	

	@SelectProvider(method="addZuul",type=GetSql.class)
	Integer addZuul(ZuulEntity zuulEntity);
	
	
	@SelectProvider(method="updateZuul",type=GetSql.class)
	Integer updateZuul(ZuulEntity zuulEntity);
	
	@Delete("delete FROM `zuul_api` where `id`= #{id}")
	Integer deleteZuul(@Param(value = "id") String id);
}
