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

//	@Test
//	public void 회원가입() {
//		MemberVO vo = new MemberVO();
//		vo.setUserid("itwill01");
//		vo.setUserpw("1234");
//		vo.setUsername("학생01");
//		vo.setUseremail("itwill@naver.com");
//
//		log.info("회원가입 정보 : " + vo);
//
//		dao.insertMember(vo);
//		
//		log.info("회원가입 완료@@@@");
//	} // 회원가입()
	
	@Test
	public void 로그인() {
		String userid = "itwill01";
		String userpw = "1234";
		
		MemberVO loginVO = new MemberVO();
		loginVO.setUserid(userid);
		loginVO.setUserpw(userpw);
		
		log.info("로그인 정보 저장완료");
		log.info("DAO 메서드 호출 ");
		
		MemberVO resultVO =  dao.loginMember(loginVO);
		
		log.info("로그인 체크완료! ");
		
		if(resultVO != null) { 
			log.info("로그인 성공");
		} else {
			log.info("로그인 실패!");
		}
	} // 로그인()

	@Test
	public void 로그인2() {
		String userid = "admin";
		String userpw = "1234";
		
		// VO 객체 X => 2개의 정보가 하나의 vo안에 저장이 불가능한 경우
		// => 하나의 vo안에 저장되는 정보가 있다면 vo에 담아서 처리
		MemberVO resultVO = dao.loginMember(userid, userpw);
		
		if(resultVO != null) { 
			log.info("로그인 성공");
		} else {
			log.info("로그인 실패!");
		}
	} // 로그인2()
	
	@Test
	public void 회원정보_수정하기() {
		
		// 수정할 정보 저장
		MemberVO vo = new MemberVO();
		vo.setUserid("itwill01");
		vo.setUserpw("1234");

		// 수정데이터
		vo.setUsername("학생01(수정)");
		vo.setUseremail("itwill01@naver.com(수정)");
		
		// dao 객체
		dao.updateMember(vo);
		
	} // 회원정보_수정하기()
	
	
	@Test
	public void 회원관리_삭제() {
		
		// 삭제할 정보
		MemberVO dvo = new MemberVO();
		dvo.setUserid("itwill01");
		dvo.setUserpw("1234");
		
		// dao 객체
		dao.deleteMember(dvo);
		
	} // 회원관리_삭제()
	
}
