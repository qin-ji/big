package com.qj.utils;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

public class JsonUtils {

    /**
     * //解析请求参数
     * 格式 ：{"requestText":["{\"date_c\":\"\",\"date_e\":\"\",\"pageSize\":10,\"indexPage\":1}"]}
     * 第一步根据key 获取 ["{\"date_c\":\"\",\"date_e\":\"\",\"pageSize\":10,\"indexPage\":1}"]
     * 此时他的内容是一个数组 ：使用JSONObject.parseArray （） 取得数组格式内容，他的下标只有一个 故： getString(0)
     * 获取到他的{\"date_c\":\"\",\"date_e\":\"\",\"pageSize\":10,\"indexPage\":1}后
     * 在将他放入 JSONObject.parseObject（）该方法，然后返回出去
     * 在上级方法中就可以使用 (返回过去的JSONObject对象) JsonInfo.get("Key") 逐个获取传递过来的参数了
     * @param String ...key_value
     * @return JSONObject JsonInfo
     */
    public static JSONObject getJsonInfo(String ... key_value){
        JSONObject json = JSONObject.parseObject(key_value[1]);
        String key = key_value[0];
        String value = json.getString(key);
        JSONArray value_value = JSONObject.parseArray (value);
        String value_Value_Info = value_value.getString(0);
        JSONObject JsonInfo = JSONObject.parseObject(value_Value_Info);
        return  JsonInfo;
    }

}
