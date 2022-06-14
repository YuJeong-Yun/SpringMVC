package com.itwillbs.service;

import com.itwillbs.domain.MemberVO;

public interface MemberService {

	// 회원가입
	public void memberInsert(MemberVO vo);
	
	// 로그인
	public MemberVO loginCheck(MemberVO vo);
}
