package com.qj.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qj.servie.MemberFeign;

@RestController
public class FeignMemberController {
	@Autowired
	private MemberFeign memberFeign;
	

	@RequestMapping("/getMemberAll")
	public List<String> getFeignOrderByUserList() {
		return memberFeign.getOrderByUserList();
	}



}
