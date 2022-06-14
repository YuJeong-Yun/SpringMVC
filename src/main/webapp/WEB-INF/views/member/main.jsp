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
		<c:redirect url="/member/login" />
	</c:if>
	
	
	<input type="button" value="로그아웃" onclick="location.href='/member/logout';" >	
	
</body>
</html>