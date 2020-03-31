package com.itmayidu.controller;

import java.util.HashMap;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class Error_Intercept {

	@ExceptionHandler(RuntimeException.class) // 拦截所有运行时的全局异常
	@ResponseBody // 返回 JOSN
	public HashMap<String, Object> ErrorTest() {
		HashMap<String, Object> map = new HashMap<>();
		map.put("500", "空指针异常");
		map.put("404", "地址错误");
		return map;
	}

}
