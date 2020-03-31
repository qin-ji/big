package com.qj.face.constants;
import com.qj.face.utils.Base64Util;
import com.qj.face.utils.FileUtil;
import com.qj.face.utils.GsonUtils;
import com.qj.face.utils.HttpUtil;
import com.qj.face.utils.URLUtils;

import java.io.IOException;
import java.util.*;

import org.springframework.beans.factory.annotation.Value;

/**
* 人脸对比
*/
public class FaceMatch {


	@Value("${face.token}")
	private static  String token="24.96b9c89af8f3180cec5b1d6cda6664e5.2592000.1565163899.282335-16299894";
    public static String match() {
        // 请求url
        String url =URLUtils.MATCH_URL;
        	
        
        try {

            byte[] bytes1 = FileUtil.readFileByBytes("F:\\QJ\\Face\\src\\main\\webapp\\Uploads\\派大星.png");
            byte[] bytes2 = FileUtil.readFileByBytes("F:\\QJ\\Face\\src\\main\\webapp\\Uploads\\aha.jpg");
            String image1 = Base64Util.encode(bytes1);
            String image2 = Base64Util.encode(bytes2);

            List<Map<String, Object>> images = new ArrayList<>();

            Map<String, Object> map1 = new HashMap<>();
            map1.put("image", "cf5bdfb4ca893176d21fd1c459fb7191");
            map1.put("image_type", "FACE_TOKEN");
            map1.put("face_type", "LIVE");
            map1.put("quality_control", "LOW");
            map1.put("liveness_control", "NORMAL");

            Map<String, Object> map2 = new HashMap<>();
            map2.put("image", image2);
            map2.put("image_type", "BASE64");
            map2.put("face_type", "LIVE");
            map2.put("quality_control", "LOW");
            map2.put("liveness_control", "NORMAL");

            images.add(map1);
            images.add(map2);

            String param = GsonUtils.toJson(images);
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

    public static void main(String[] args) throws IOException {
    	
        FaceMatch.match();
    }
}