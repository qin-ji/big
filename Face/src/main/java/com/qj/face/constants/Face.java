package com.qj.face.constants;

import java.util.*;

import org.springframework.beans.factory.annotation.Value;

import com.qj.face.utils.Base64Util;
import com.qj.face.utils.FileUtil;
import com.qj.face.utils.GsonUtils;
import com.qj.face.utils.HttpUtil;
import com.qj.face.utils.URLUtils;

/**
 * 人脸库管理类
 */
public class Face {

	@Value("${face.token}")
	private static String token = "24.96b9c89af8f3180cec5b1d6cda6664e5.2592000.1565163899.282335-16299894";

	// 新增人脸
	public static String add() {
		// 请求url
		String url = URLUtils.FACE_ADD_URL;
		try {
			byte[] bytes1 = FileUtil.readFileByBytes("F:\\QJ\\Face\\src\\main\\webapp\\Uploads\\aha.jpg");
			String image1 = Base64Util.encode(bytes1);

			Map<String, Object> map = new HashMap<>();
			map.put("image", "cf5bdfb4ca893176d21fd1c459fb7191");
			map.put("group_id", "QJ");
			map.put("user_id", "QJ_01");
			map.put("user_info", "QJ_01");
			map.put("liveness_control", "NORMAL");
			map.put("image_type", "FACE_TOKEN");
			map.put("quality_control", "LOW");

			String param = GsonUtils.toJson(map);

			// 注意这里仅为了简化编码每一次请求都去获取access_token，线上环境access_token有过期时间， 客户端可自行缓存，过期后重新获取。
			String accessToken = token;

			String result = HttpUtil.post(url, accessToken, "application/json", param);
			System.out.println(result);
			return result;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	// 修改人脸
	public static String update() {
		// 请求url
		String url = URLUtils.FACE_UPDATE_URL;
		try {
			byte[] bytes1 = FileUtil.readFileByBytes("F:\\QJ\\Face\\src\\main\\webapp\\Uploads\\aha.jpg");
			String image1 = Base64Util.encode(bytes1);
			Map<String, Object> map = new HashMap<>();
			map.put("image", image1);
			map.put("group_id", "QJ");
			map.put("user_id", "QJ_01");
			map.put("user_info", "QJ_01");
			map.put("liveness_control", "NORMAL");
			map.put("image_type", "BASE64");
			map.put("quality_control", "LOW");

			String param = GsonUtils.toJson(map);

			// 注意这里仅为了简化编码每一次请求都去获取access_token，线上环境access_token有过期时间， 客户端可自行缓存，过期后重新获取。
			String accessToken = token;

			String result = HttpUtil.post(url, accessToken, "application/json", param);
			System.out.println(result);
			return result;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	// 删除人脸
	public static String delete() {
		// 请求url
		String url = URLUtils.FACE_DELETE_URL;
		try {

			Map<String, Object> map = new HashMap<>();
			map.put("face_token", "cf5bdfb4ca893176d21fd1c459fb7191");
			map.put("group_id", "QJ");
			map.put("user_id", "QJ_01");
			map.put("image_type", "FACE_TOKEN");
			String param = GsonUtils.toJson(map);

			// 注意这里仅为了简化编码每一次请求都去获取access_token，线上环境access_token有过期时间， 客户端可自行缓存，过期后重新获取。
			String accessToken = token;

			String result = HttpUtil.post(url, accessToken, "application/json", param);
			System.out.println(result);
			return result;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	// 获取用户信息
	public static String getUserInfo() {
		// 请求url
		String url = URLUtils.FACE_GET_USER_INFO_URL;
		try {
			Map<String, Object> map = new HashMap<>();
			map.put("user_id", "QJ_01");
			map.put("group_id", "QJ");

			String param = GsonUtils.toJson(map);

			// 注意这里仅为了简化编码每一次请求都去获取access_token，线上环境access_token有过期时间， 客户端可自行缓存，过期后重新获取。
			String accessToken = token;

			String result = HttpUtil.post(url, accessToken, "application/json", param);
			System.out.println(result);
			return result;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	// 获取用户人脸列表
	public static String getUserFaceList() {
		// 请求url
		String url = URLUtils.FACE_GET_USER_FACE_LIST_URL;
		try {
			Map<String, Object> map = new HashMap<>();
			map.put("user_id", "QJ_01");
			map.put("group_id", "QJ");

			String param = GsonUtils.toJson(map);

			// 注意这里仅为了简化编码每一次请求都去获取access_token，线上环境access_token有过期时间， 客户端可自行缓存，过期后重新获取。
			String accessToken = token;

			String result = HttpUtil.post(url, accessToken, "application/json", param);
			System.out.println(result);
			return result;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 获取用户列表
	 */
	public static String getUserInfoList() {
		// 请求url
		String url = URLUtils.FACE_GET_USER_INFO_LIST_URL;
		try {
			Map<String, Object> map = new HashMap<>();
			map.put("group_id", "QJ");

			String param = GsonUtils.toJson(map);

			// 注意这里仅为了简化编码每一次请求都去获取access_token，线上环境access_token有过期时间， 客户端可自行缓存，过期后重新获取。
			String accessToken = token;

			String result = HttpUtil.post(url, accessToken, "application/json", param);
			System.out.println(result);
			return result;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 复制用户
	 */
	public static String getUserCopy() {
		// 请求url
		String url = URLUtils.FACE_USER_COPY_URL;
		try {
			Map<String, Object> map = new HashMap<>();
			map.put("user_id", "QJ_01"); // 用户id
			map.put("src_group_id", "QJ"); // 从指定组里复制信息
			map.put("dst_group_id", "QJJ"); // 需要添加用户的组id
			String param = GsonUtils.toJson(map);

			// 注意这里仅为了简化编码每一次请求都去获取access_token，线上环境access_token有过期时间， 客户端可自行缓存，过期后重新获取。
			String accessToken = token;

			String result = HttpUtil.post(url, accessToken, "application/json", param);
			System.out.println(result);
			return result;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 删除用户
	 */
	public static String getUserDelete() {
		// 请求url
		String url = URLUtils.FACE_USER_DELETE_URL;
		try {
			Map<String, Object> map = new HashMap<>();
			map.put("user_id", "QJ_01"); // 用户id
			map.put("group_id", "QJJ"); // 从指定组里复制信息
			String param = GsonUtils.toJson(map);

			// 注意这里仅为了简化编码每一次请求都去获取access_token，线上环境access_token有过期时间， 客户端可自行缓存，过期后重新获取。
			String accessToken = token;

			String result = HttpUtil.post(url, accessToken, "application/json", param);
			System.out.println(result);
			return result;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 创建用户组
	 * 
	 * @return
	 */
	public static String groupAdd() {
		// 请求url
		String url = URLUtils.FACE_GROUP_ADD_URL;
		try {
			Map<String, Object> map = new HashMap<>();
			map.put("group_id", "QJJJ");

			String param = GsonUtils.toJson(map);

			// 注意这里仅为了简化编码每一次请求都去获取access_token，线上环境access_token有过期时间， 客户端可自行缓存，过期后重新获取。
			String accessToken = token;

			String result = HttpUtil.post(url, accessToken, "application/json", param);
			System.out.println(result);
			return result;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 删除用户组
	 * 
	 * @return
	 */
	public static String groupDelete() {
		// 请求url
		String url = URLUtils.FACE_GROUP_DELETE_URL;
		try {
			Map<String, Object> map = new HashMap<>();
			map.put("group_id", "QJJ");

			String param = GsonUtils.toJson(map);

			// 注意这里仅为了简化编码每一次请求都去获取access_token，线上环境access_token有过期时间， 客户端可自行缓存，过期后重新获取。
			String accessToken = token;

			String result = HttpUtil.post(url, accessToken, "application/json", param);
			System.out.println(result);
			return result;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 用户组列表查询
	 */
	public static String GroupGetlist() {
		// 请求url
		String url = URLUtils.FACE_GROUP_LIST_URL;
		try {
			Map<String, Object> map = new HashMap<>();
			map.put("start", 0);
			map.put("length", 100);

			String param = GsonUtils.toJson(map);

			// 注意这里仅为了简化编码每一次请求都去获取access_token，线上环境access_token有过期时间， 客户端可自行缓存，过期后重新获取。
			String accessToken = token;

			String result = HttpUtil.post(url, accessToken, "application/json", param);
			System.out.println(result);
			return result;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public static void main(String[] args) {
		Face.getUserFaceList();
	}
}