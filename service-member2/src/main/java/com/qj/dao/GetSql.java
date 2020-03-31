package com.qj.dao;


import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;

import com.qj.entity.MenEntity;
import com.qj.entity.TableUtils;
import com.qj.entity.UserEntity;
import com.qj.entity.ZuulEntity;


public class GetSql {
	
	public String updateZuul(ZuulEntity zuulEntity) {
		StringBuffer sb = new StringBuffer(" update `zuul_api`  set ");
		sb.append(" serviceId='"+zuulEntity.getServiceId().trim());
		sb.append("',path='"+zuulEntity.getPath().trim());
		sb.append("',url='"+zuulEntity.getUrl().trim());
//		sb.append(" ',customSensitiveHeaders="+zuulEntity.isCustomSensitiveHeaders());
		sb.append("',stripPrefix="+zuulEntity.isStripPrefix());
		sb.append(" ,enabled="+zuulEntity.isEnabled());
		sb.append(" where id='"+zuulEntity.getId()+"'");
		return sb.toString();
	}
	
	public String addZuul(ZuulEntity zuulEntity) {
		StringBuffer sb = new StringBuffer(" INSERT INTO `zuul_api`   (id,serviceId,path,url,stripPrefix,enabled) VALUES (");
		sb.append("'"+zuulEntity.getId().trim()+"',");
		sb.append("'"+zuulEntity.getServiceId().trim()+"',");
		sb.append("'"+zuulEntity.getPath().trim()+"',");
		sb.append("'"+zuulEntity.getUrl().trim()+"',");
		sb.append(zuulEntity.isStripPrefix()+",");
		sb.append(zuulEntity.isEnabled()+")");
		System.out.println(sb.toString());
		return sb.toString();
	}
	
	// -------------------UserDao-------------------------

	public String queryOrderByParam(@Param("start") int start, @Param("end") int end,
			@Param("userName") String userName, @Param("phone") String phone, @Param("date_s") String date_s,
			@Param("date_e") String date_e) {
		StringBuffer sb = new StringBuffer(
				"SELECT id,password,username,phone,email,created,updated,roleName,img_url  FROM  " + TableUtils.TABLE_USER
						+ " m WHERE 1=1");

		if (userName != null && StringUtils.isNotEmpty(userName)) {
			sb.append(" and username LIKE '%" + userName + "%'");
		}

		if (phone != null && StringUtils.isNotEmpty(phone)) {
			sb.append(" and phone LIKE '%" + phone + "%'");
		}

		if (date_s != null && StringUtils.isNotEmpty(date_s)) {
			sb.append(" and created > #{date_s}");
		}

		if (date_e != null && StringUtils.isNotEmpty(date_e)) {
			sb.append(" and created <= #{date_e}");
		}
		sb.append(" GROUP BY m.id");
		sb.append(" LIMIT #{start},#{end}");
	
		return sb.toString();
	}

	public String queryOrderByParamCount(@Param("userName") String userName, @Param("phone") String phone,
			@Param("date_s") String date_s, @Param("date_e") String date_e) {
		StringBuffer sb = new StringBuffer("select count(*) from " + TableUtils.TABLE_USER + " m where 1=1");

		if (userName != null && StringUtils.isNotEmpty(userName)) {
			sb.append(" and username LIKE '%" + userName + "%'");
		}

		if (phone != null && StringUtils.isNotEmpty(phone)) {
			sb.append(" and phone LIKE '%" + phone + "%'");
		}

		if (date_s != null && StringUtils.isNotEmpty(date_s)) {
			sb.append(" and created > #{date_s}");
		}

		if (date_e != null && StringUtils.isNotEmpty(date_e)) {
			sb.append(" and created <= #{date_e}");
		}

		return sb.toString();
	}

	public String updateUser(UserEntity userEntity) {
		if (userEntity.getId() != null) {
			StringBuffer sb = new StringBuffer("update mb_user set");
			sb.append("  username ='" + userEntity.getUsername());
			if (userEntity.getPassword() != null) {
				sb.append("' , password ='" + userEntity.getPassword());
			}
			sb.append("' , phone ='" + userEntity.getPhone());
			sb.append("' , email ='" + userEntity.getEmail());
			sb.append("' , updated ='" + userEntity.getUpdated());
			sb.append("' , roleName ='" + userEntity.getRoleName());
			sb.append("' , img_url ='" + userEntity.getImg_url());
			sb.append("' where id=" + userEntity.getId());
			return sb.toString();
		}
		return null;
	}

	// -------------------/UserDao-------------------------

	// --------------------pageDao---------------------------------

	public String queryMen(@Param("start") int start, @Param("end") int end, @Param("menName") String menName,
			@Param("pId") String pId) {
		StringBuffer sb = new StringBuffer("select m.id,m.men_name as menName,m.men_url as menUrl,m.men_id as menId,"
				+ "m.men_button_url as menButtonUrl,m.parent_id as parentId,m.men_button_style as menButtonStyle,"
				+ "m.men_type as menType,m.men_image as menImage,m.men_button_image as menButtonImage" + " from " + TableUtils.TABLE_MEN + " m where 1=1");

		if (menName != null && StringUtils.isNotEmpty(menName)) {
			sb.append(" and m.men_name LIKE '%" + menName + "%'");
		}

		if (pId != null && StringUtils.isNotEmpty(pId)) {
			sb.append(" and m.parent_id = #{pId}");
		}
		sb.append(" LIMIT #{start},#{end}");
		return sb.toString();
	}

	public String queryMenCount(@Param("menName") String menName, @Param("pId") String pId) {
		StringBuffer sb = new StringBuffer("select count(*) from " + TableUtils.TABLE_MEN + " m where 1=1");

		if (menName != null && StringUtils.isNotEmpty(menName)) {
			sb.append(" and m.men_name LIKE '%" + menName + "%'");
		}

		if (pId != null && StringUtils.isNotEmpty(pId)) {
			sb.append(" and m.parent_id = #{pId}");
		}

		return sb.toString();
	}
	
	public String addMen(MenEntity men) {
		StringBuffer sb = new StringBuffer("INSERT INTO men (`men_name`, `men_url`, `men_id`, `men_button_url`,`parent_id`,`men_button_style`, `men_type`,`men_image`,`men_button_image`)");
		if (men.getMenType().equals("menu bar")) {
			sb.append(" values(\""+men.getMenName()+"\",NULL,"+men.getMenId()+",NULL,NULL,NULL,\""+men.getMenType()+"\",\""+men.getMenImage()+"\",NULL)");
		}else if(men.getMenType().equals("men")) {
			sb.append(" values(\""+men.getMenName()+"\",\""+men.getMenUrl()+"\","+men.getMenId()+",NULL,"+men.getParentId()+",NULL,\""+men.getMenType()+"\",\""+men.getMenImage()+"\",NULL)");
		}else if(men.getMenType().equals("button")){
			sb.append(" values(\""+men.getMenName()+"\",NULL,"+men.getMenId()+",\""+men.getMenButtonUrl()+"\","+men.getParentId()+",\""+men.getMenButtonStyle()+"\",\""+men.getMenType()+"\",NULL,\""+men.getMenButtonImage()+"\")");
		}
		return sb.toString();
	}
	
	public String updateMen(MenEntity men) {
		StringBuffer sb = new StringBuffer(" UPDATE  `men` set ");
		if (men.getMenType().equals("menu bar")) {
			sb.append(" men_name= \""+men.getMenName()+"\",men_url=NULL,men_button_url=NULL,parent_id=NULL,men_button_style=NULL,men_type=\""+men.getMenType()+"\",men_image=\""+men.getMenImage()+"\",men_button_image=NULL");
		}else if(men.getMenType().equals("men")) {
			sb.append("men_name=\""+men.getMenName()+"\",men_url=\""+men.getMenUrl()+"\",men_button_url=NULL,parent_id="+men.getParentId()+",men_button_style=NULL,men_type=\""+men.getMenType()+"\",men_image=\""+men.getMenImage()+"\",men_button_image=NULL");
		}else if(men.getMenType().equals("button")){
			sb.append("men_name=\""+men.getMenName()+"\",men_url=NULL,men_button_url=\""+men.getMenButtonUrl()+"\",parent_id="+men.getParentId()+",men_button_style=\""+men.getMenButtonStyle()+"\",men_type=\""+men.getMenType()+"\",men_image=NULL,men_button_image=\""+men.getMenButtonImage()+"\"");
		}
		
		sb.append(" where id="+men.getId());
		System.out.println(sb.toString());
		return sb.toString();
	}

	// --------------------end/pageDao---------------------------------

	// --------------------start/roleDao---------------------------------
	public String queryRoleByParam(@Param("start") int start,@Param("end") int end,@Param("roleID") String roleID,@Param("roleName") String roleName) {
		StringBuffer sb = new StringBuffer(
				"SELECT r.id as id ,r.role_id as roleId,r.role_name as roleName  FROM  " + TableUtils.TABLE_ROLE
						+ " r WHERE 1=1");

		if (roleID != null && StringUtils.isNotEmpty(roleID)) {
			sb.append(" and role_id LIKE '%" + roleID + "%'");
		}

		if (roleName != null && StringUtils.isNotEmpty(roleName)) {
			sb.append(" and role_name LIKE '%" + roleName + "%'");
		}
		sb.append(" GROUP BY r.id");
		sb.append(" LIMIT #{start},#{end}");
	
		return sb.toString();
	}

	public String queryRoleByParamCount(@Param("roleID") String roleID,@Param("roleName") String roleName) {
		StringBuffer sb = new StringBuffer("select count(*) from " + TableUtils.TABLE_ROLE + " m where 1=1");

		if (roleID != null && StringUtils.isNotEmpty(roleID)) {
			sb.append(" and role_id LIKE '%" + roleID + "%'");
		}

		if (roleName != null && StringUtils.isNotEmpty(roleName)) {
			sb.append(" and role_name LIKE '%" + roleName + "%'");
		}

		return sb.toString();
	}
	
	// --------------------end/roleDao---------------------------------
	
}                  