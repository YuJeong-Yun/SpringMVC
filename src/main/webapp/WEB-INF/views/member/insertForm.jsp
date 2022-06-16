<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function check() {
		const fr = document.fr;
		if(fr.userid.value == "") {
			alert("아이디를 입력하세요");
			return false;
		}else if(fr.userpw.value == "") {
			alert("비밀번호를 입력하세요.");
			return false;
		}else if(fr.username.value == "") {
			alert("이름을 입력하세요.");
			return false;
		}else if(fr.useremail.value == "") {
			alert("이메일을 입력하세요.");
			return false;
		}
	}
</script>
</head>
<body>
	<h1>member/insertForm.jsp</h1>
	
	<h2>회원가입</h2>
	
	<fieldset>
		<form action="/member/insert" method="post" name="fr" onsubmit="return check();">
			아이디 : <input type="text" name="userid"><br> 
			비밀번호 : <input type="password" name="userpw"><br> 
			이름 : <input type="text" name="username"><br>
			이메일 : <input type="text" name="useremail"><br>
			
			<input type="submit" value="회원가입하기">
		</form>
	</fieldset>
</body>
</html>