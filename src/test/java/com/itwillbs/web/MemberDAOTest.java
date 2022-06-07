package com.itwillbs.web;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.itwillbs.persistence.MemberDAO;
import com.itwillbs.persistence.MemberDAOImpl;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/spring/root-context.xml" })
public class MemberDAOTest {

	// MVC에서 Action페이지 역할

	// DAO 생성 -> 객체 주입
	@Inject
	private MemberDAO dao;
	// => MemberDAO dao = new MemberDAOImpl(); (약한결합)

	//	@Inject
	//	private MemberDAOImpl daoIm;
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
	
}
