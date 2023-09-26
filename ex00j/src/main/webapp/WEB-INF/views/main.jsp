<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>메인페이지</title>
</head>
<body>
	<h2>안녕하세요</h2>
	<c:if test="${empty authInfo }">
	
	<p><a href="<c:url value='/login'/>">[로그인]</a></p>
	<p><a href="<c:url value='/register/step1'/>">[회원가입하기]</a></p>
	</c:if>
	<c:if test="${!empty authInfo }">
	<p>${authInfo.name }님 환영합니다.</p>	
	<p><a href="<c:url value='/logout'/>">[로그아웃]</a></p> 
	<p><a href="<c:url value='/edit/changePassword'/>">[비밀번호변경]</a></p> 
	</c:if>
	<p><a href="<c:url value='/survey'/>">[설문조사]</a></p>
	<p><a href="<c:url value='/member/list'/>">[회원조회]</a></p>
		
</body>
</html>