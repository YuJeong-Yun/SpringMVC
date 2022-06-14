<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>main.jsp</h1>
	
	${id }님 안녕하세요. <br>
	${sessionScope.id }님 안녕하세요. <br>
	

	<c:if test="${id == null}">
		<c:redirect url="${pageContext.request.contextPath }/member/login" />
	</c:if>
	
	
	<input type="button" value="로그아웃" onclick="location.href='/member/logout';" >	
	
	
	<h3><a href="/member/info">회원정보 조회</a></h3>
	<h3>회원정보 수정</h3>
	<h3>회원정보 삭제</h3>
	<h3>회원정보 목록 조회</h3>
	
	
</body>
</html>