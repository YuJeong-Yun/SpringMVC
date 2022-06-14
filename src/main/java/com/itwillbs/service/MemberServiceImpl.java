package com.itwillbs.service;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.itwillbs.domain.MemberVO;
import com.itwillbs.persistence.MemberDAO;

// @Service : 해당 객체가 서비스 동작을 수행하는 객체다 라는 의미 
@Service
public class MemberServiceImpl implements MemberService {

	private static final Logger log = LoggerFactory.getLogger(MemberServiceImpl.class);
	// DAO 객체 필요
	@Inject
	private MemberDAO dao;

	@Override
	public void memberInsert(MemberVO vo) {
		log.info(" 컨트롤러 호출 ");
		log.info("memberInsert(vo) 호출 ");

		dao.insertMember(vo);
		
		log.info(" DAO 처리 완료 -> 컨트롤러 이동");
		
	}

	@Override
	public MemberVO loginCheck(MemberVO vo) {
		log.info("loginCheck(vo) 호출");
		
		// DAO 객체 메서드 호출
		MemberVO loginResultVO =  dao.loginMember(vo);
		
		log.info(loginResultVO+"");
		
		return loginResultVO;
	}

	
	@Override
	public MemberVO getMemberInfo(String userid) {
		log.info("getMemberInfo(id) 호출");
		
		// DAO 객체 메서드 호출
		MemberVO memberVO = dao.getMember(userid);
		
		log.info(memberVO+"");
		
		return memberVO;
	}

}
