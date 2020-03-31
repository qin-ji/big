package com.qj.face.constants;
import java.util.*;

import org.springframework.beans.factory.annotation.Value;

import com.qj.face.utils.Base64Util;
import com.qj.face.utils.FileUtil;
import com.qj.face.utils.GsonUtils;
import com.qj.face.utils.HttpUtil;
import com.qj.face.utils.URLUtils;

/**
* 人脸检测与属性分析
*/
public class FaceDetect {

	@Value("${face.token}")
	private static  String token="24.96b9c89af8f3180cec5b1d6cda6664e5.2592000.1565163899.282335-16299894";
    public static String detect() {
        // 请求url
        String url = URLUtils.DETECT_URL;
        try {
        	
        	   byte[] bytes1 = FileUtil.readFileByBytes("F:\\QJ\\Face\\src\\main\\webapp\\Uploads\\aha.jpg");
               String image1 = Base64Util.encode(bytes1);
            Map<String, Object> map = new HashMap<>();
            map.put("image", "cf5bdfb4ca893176d21fd1c459fb7191");
            map.put("face_field", "faceshape,facetype");
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

    public static void main(String[] args) {
        FaceDetect.detect();
    }
}