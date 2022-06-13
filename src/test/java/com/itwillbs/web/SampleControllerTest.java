package com.itwillbs.web;

import javax.inject.Inject;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

// @WebAppConfiguration : 스프링MVC 테스트 하겠다. (WAS/tomcat 역할해줌)

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(
		locations = {"file:src/main/webapp/WEB-INF/spring/**/*.xml"}
		)
public class SampleControllerTest {

	private static final Logger log = LoggerFactory.getLogger(SampleControllerTest.class);
	
	// 웹 애플리케이션 객체
	@Inject
	private WebApplicationContext wac;

	
	// 테스트를 위해 사용되는 객체
	// 웹 브라우저에서 사용되는 요청(request), 응답(response)를 의미하는 객체
	private MockMvc mockMvc;

	// @Before : @Test 동작을 수행하기 전에 자동으로 실행
	@Before
	public void setup() {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
		
		log.info("webapp를 실행할 준비 완료!");
	}
	
	@Test
	public void 컨트롤러_테스트() throws Exception {
		setup();
		
		log.info("컨트롤러 테스트 시작 ");
		
		// 컨트롤러에서 /doA 주소 호출
		mockMvc.perform(MockMvcRequestBuilders.get("/doA"));
		mockMvc.perform(MockMvcRequestBuilders.post("/doA"));
	}
}
