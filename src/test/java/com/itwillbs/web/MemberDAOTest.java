package com.itwillbs.web;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.itwillbs.domain.MemberVO;
import com.itwillbs.persistence.MemberDAO;
import com.itwillbs.persistence.MemberDAOImpl;

import jdk.internal.org.jline.utils.Log;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/spring/root-context.xml" })
public class MemberDAOTest {

	// 로그 객체
	private static final Logger log = LoggerFactory.getLogger(MemberDAOTest.class);

	// MVC에서 Action페이지 역할

	// DAO 생성 -> 객체 주입
	@Inject
	private MemberDAO dao;
	// => MemberDAO dao = new MemberDAOImpl(); (약한결합)

	// @Inject
	// private MemberDAOImpl daoIm;
	// => MemberDAOImpl daoIm = new MemberDAOImpl(); (강한결합)

	@Test
	public void DAO생성확인() {
		System.out.println(dao);
	}

	@Test
	public void 시간정보가져오기() {
		System.out.println(dao.getTime());
	}

	@Test
	public void 회원수가져오기() {
		System.out.println(dao.getMemberCnt());
	}

	@Test
	public void 회원가입() {
		MemberVO vo = new MemberVO();
		vo.setUserid("itwill01");
		vo.setUserpw("1234");
		vo.setUsername("학생01");
		vo.setUseremail("itwill@naver.com");

		log.info("회원가입 정보 : " + vo);

		dao.insertMember(vo);
		
		log.info("회원가입 완료@@@@");
	}

}
