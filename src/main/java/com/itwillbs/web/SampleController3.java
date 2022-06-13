package com.itwillbs.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.itwillbs.domain.MemberVO;

@Controller
public class SampleController3 {

	private static final Logger log = LoggerFactory.getLogger(SampleController3.class);
	
	// http://localhost:8088/web/doC
	@RequestMapping(value="/doC", method = RequestMethod.GET)
	public String doC(Model model) {
		
		MemberVO member 
				= new MemberVO("admin","1234","관리자","admin@admin.com",null,null);
		// 전달할 정보를 저장
		model.addAttribute(member); 
		
		return "memberInfo";
	}
}
