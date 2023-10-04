<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 정보 수정</title>
</head>
<body>
	<form action="UMS" method="post">
	         아이디 : <input type="text" name="id" value="${member.id }" readonly="readonly"><br>
		 이메일 : <input type="email" name="email" value="${member.email }" readonly="readonly"><br>
		 이름 : <input type="text" name="name" value="${member.name }" ><br>
		 비밀번호 : <input type="password" name="password" ><br>
		<button type="submit">수정</button>
	</form>
</body>
</html>