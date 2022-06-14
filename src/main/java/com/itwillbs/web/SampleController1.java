package com.itwillbs.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

//@Controller : 해당클래스를 컨트롤러로 동작하게 설정 (servlet-context.xml 에 빈으로 등록)
@Controller
public class SampleController1 {

	private static final Logger log = LoggerFactory.getLogger(SampleController1.class);
	
	// 메서드의 리턴타입이 void일 때 해당주소.jsp 페이지 호출
	
	// http://localhost:8088/web/doA
	// http://localhost:8088/web/doA1
	// http://localhost:8088/web/doA2
	
	// @RequestMapping : 특정 URI의 특정 메서드를 연결
//	@RequestMapping(value="주소", method=RequestMethod.POST)
	
	@RequestMapping("/doA")
	public void doA() {
		log.info(" /doA 주소 호출, doA() 호출");
		log.info("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
	}

	@RequestMapping("/doA1")
	public void doA1() {
		log.info(" /doA1 주소 호출, doA1() 호출");
	}
	
	
	@RequestMapping("/doA2")
	public void doA2() {
		log.info(" /doA2 주소 호출, doA2() 호출");
	}
}
