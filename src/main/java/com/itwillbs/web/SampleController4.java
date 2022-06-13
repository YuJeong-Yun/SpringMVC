package com.itwillbs.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class SampleController4 {

	private static final Logger log = LoggerFactory.getLogger(SampleController4.class);
	
//	// http://localhost:8088/web/doD
//	@RequestMapping(value="/doD")
//	public String doD(Model model) {
//		log.info("doD() 호출!!! ");
//		
//		model.addAttribute("msg", "itwill");
//		
//		return "redirect:/doE";
//	}
//	
//	@RequestMapping(value="/doE")
//	public void doE(@ModelAttribute("msg") String msg) {
//		log.info("doE() 호출!!!");
//		
//	}
	
	
	
	// http://localhost:8088/web/doD
	@RequestMapping(value="/doD")
	public String doD(RedirectAttributes rttr) {
		log.info("doD() 호출!!! ");
		
		rttr.addFlashAttribute("msg", "itwill");
		
		return "redirect:/doE";
	}
	
	// model.addAttribute()
	// => Model 객체 사용, URI에 표시됨. F5-데이터 유지(새로고침)
	// rttr.addFlashAttribute()
	// => RedirectAttribute 객체 사용, URI에 표시 안 됨. F5-데이터 사라짐(1회성)
	
	@RequestMapping(value="/doE")
	public void doE(@ModelAttribute("msg") String msg) {
		log.info("doE() 호출!!!");
		
	}
	
}
