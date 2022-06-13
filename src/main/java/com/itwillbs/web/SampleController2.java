package com.itwillbs.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class SampleController2 {

	private static final Logger log = LoggerFactory.getLogger(SampleController2.class);
	
	// http://localhost:8088/web/doB
	@RequestMapping(value = "/doB", method = RequestMethod.GET)
	public String doB() {
		log.info("doB()호출, 주소: /doB");

		return "itwill";
	}

	// '/web/doB1' 주소 호출 시 -> itwillbs.jsp 출력
	// http://localhost:8088/web/doB1
	@RequestMapping("/doB1")
	public String doB1() {
		log.info(" /doB1 주소 호출, doB1() 호출");
		log.info("주소 호출과 메서드명은 상관 없음. (메서드는 동작의 의미를 표현)");
		log.info("리턴시 찾고자하는 뷰페이지 이름만 리턴 ");
		log.info("리턴한 문자열.jsp 페이지로 자동 연결");

		return "itwillbs";
	}

	// 'doB2' -> itwillbs.jsp
	// http://localhost:8088/web/doB2
	// http://localhost:8088/web/doB2?id=itwillbs
	@RequestMapping(value = "/doB2", method = RequestMethod.GET)
	public String doB2(@ModelAttribute("id") String id) {
		
		log.info("doB2() 호출, 주소: /doB2");
		log.info("itwillbs.jsp 페이지 이동");

		log.info(" id : " + id );
		
		return "itwillbs";
	}
	
	
	// http://localhost:8088/web/doB3
	// "doB3" => itwillbs.jsp "이름 : 김학생, 전화번호 : 010-1234-1234"
	// http://localhost:8088/web/doB3?name=김학생&tel=010-1234-1234
	@RequestMapping(value = "/doB3", method = RequestMethod.GET)
	public String doB3(@ModelAttribute("name") String name, @ModelAttribute("tel") String tel) {
		log.info("doB3() 호출");
		
		return "itwillbs";
	}
	
	
}
