package com.itwillbs.persistence;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.itwillbs.domain.MemberVO;


// @Repository : 해당 클래스를 DAO로 스프링에서 인식하도록 하는 표시
@Repository
public class MemberDAOImpl implements MemberDAO {

	private static final Logger logger = LoggerFactory.getLogger(MemberDAOImpl.class);
	
	// 디비 연결정보가 필요하다. => 의존 주입
	@Inject
	private SqlSession sqlSession;
	// DB연결, 자원해제, SQL 실행
	
	// mapper의 위치값(주소) 이름
	private static final String NAMESPACE="com.itwillbs.mapper.MemberMapper";
	
	
	@Override
	public String getTime() { // 시간정보 가져오기
		// selectOne(SQL 구문:mapper네임스페이스.sql구문아이디) : SQL 실행 결과를 하나 가져오는 동작
		// selectOne(SQL 구문, 전달값)
		String time = sqlSession.selectOne(NAMESPACE+".getTime");
		
		return time;
	} // getTime()


	@Override
	public Integer getMemberCnt() { // 회원수 가져오기
		// selectOne(SQL 구문:mapper네임스페이스.sql구문아이디) : SQL 실행 결과를 하나 가져오는 동작
		Integer cnt = sqlSession.selectOne(NAMESPACE+".getMemberCnt");
		
		return cnt;
	} // getMemberCnt()


	@Override
	public void insertMember(MemberVO vo) { // 회원 가입하기
		
		System.out.println(" DAO : 회원가입 실행 ");
		logger.info(" 회원가입 실행! ");
		
		// insert SQL 구문 호출
		sqlSession.insert(NAMESPACE+".insertMember", vo);
		
		System.out.println(" DAO : 회원가입 완료 ");
		logger.info("회원가입 완료!!! ");
		
	} // insertMember()


	@Override
	public MemberVO loginMember(MemberVO vo) { // 로그인
		
		logger.info("loginMember() 동작 호출");
		
		MemberVO resultVO =  sqlSession.selectOne(NAMESPACE+".login", vo);
		
		logger.info("로그인 체크완료, "+resultVO);
		logger.info("테스트 파일로 이동");
		
		return resultVO;
	} // loginMember()


	@Override
	public MemberVO loginMember(String userid, String userpw) { // 로그인
		
		// userid, userpw는 vo에 저장 불가능한 상황(가정)
		// sqlSession.selectOne(NAMESPACE+".", userid, userpw);
		// Map을 사용하여 key, value 쌍으로 저장
		
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("userid", userid);
		paramMap.put("userpw", userpw);
		
		logger.info(paramMap.toString());
		
		return sqlSession.selectOne(NAMESPACE+".login", paramMap);
	} // loginMember()


	@Override
	public Integer updateMember(MemberVO vo) { // 회원 정보 수정
		
		logger.info("회원 정보 수정 동착 호출");

		int resultCnt = sqlSession.update(NAMESPACE+".update", vo);
		
		return resultCnt;
	} // updateMember()


	@Override
	public void deleteMember(MemberVO vo) { // 회원 정보 삭제
		
		logger.info("회원 정보 삭제 동작 호출");
		
		sqlSession.delete(NAMESPACE+".delete", vo);
		
	} // deleteMember()


	@Override
	public MemberVO getMember(String userid) { // 회원 정보 조회
		logger.info("회원 정보 조회 동작 호출");
		 
		MemberVO memberVO = sqlSession.selectOne(NAMESPACE+".getMember", userid);
		
		return memberVO;
	} // getMember()

	

	@Override
	public List<MemberVO> getMemberList(String adminID) {
		
		logger.info(" getMemberList(String adminID) 호출 ");
		
		// mapper에 해당 sql구문 호출
		// => mapper결과를 List형태로 리턴하겠다
		//List memberList = sqlSession.selectList(adminID, adminID);
		//return memberList;
		
		return sqlSession.selectList(NAMESPACE+".memberList", adminID);
	}

}
