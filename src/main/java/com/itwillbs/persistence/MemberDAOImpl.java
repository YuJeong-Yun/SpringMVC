package com.itwillbs.persistence;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.itwillbs.domain.MemberVO;
import com.itwillbs.web.HomeController;

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

}
