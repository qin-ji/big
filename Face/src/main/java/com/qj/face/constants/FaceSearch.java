package com.qj.face.constants;


import java.util.*;

import org.springframework.beans.factory.annotation.Value;

import com.qj.face.utils.GsonUtils;
import com.qj.face.utils.HttpUtil;
import com.qj.face.utils.URLUtils;

/**
* 人脸搜索
*/
public class FaceSearch {

	
	@Value("${face.token}")
	private static  String token="24.96b9c89af8f3180cec5b1d6cda6664e5.2592000.1565163899.282335-16299894";
  
    public static String search() {
        // 请求url
        String url = URLUtils.SEARCH_URL;
        try {
            Map<String, Object> map = new HashMap<>();
            map.put("image", "cf5bdfb4ca893176d21fd1c459fb7191");
            map.put("liveness_control", "NORMAL");
            map.put("group_id_list", "QJ,QJJ");
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

    public static void main(String[] args) {
        FaceSearch.search();
    }
}