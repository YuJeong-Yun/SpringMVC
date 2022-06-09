package com.itwillbs.persistence;

import com.itwillbs.domain.MemberVO;

public interface MemberDAO {

	// 시간정보 가져오기
	public String getTime();
	
	// 회원수 가져오기
	public Integer getMemberCnt();
	
	// 회원가입
	public void insertMember(MemberVO vo);
	
	// 로그인
	public MemberVO loginMember(MemberVO vo);
	
	// 로그인2
	public MemberVO loginMember(String userid, String userpw);
	
	// 회원 정보 수정(이름, 이메일, 수정일)
	public Integer updateMember(MemberVO vo);
	
	// 회원 정보 삭제
	public void deleteMember(MemberVO vo);
}
