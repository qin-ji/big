package com.qj.face.utils;

import java.util.UUID;



import com.qj.face.constants.Constants;

public class TokenUtils {

	 public static String getMemberToken(){
		 return Constants.TOKEN_MEMBER+"-"+UUID.randomUUID();
	 }
	
}
