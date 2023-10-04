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
<h2>각 기능별 링크</h2>
<a href="<c:url value='/FS'/>">[회원 목록 조회]</a><br>
<a href="<c:url value='/SS'/>">[회원 목록 조회]HashMap</a><br>
<a href="<c:url value='/MCS'/>">[회원 수 조회]</a><br>
<a href="<c:url value='/MES'/>">[이메일로 회원 조회]</a><br>
<hr>
<a href="<c:url value='/AMS'/>">[회원 등록]</a><br>
<a href="<c:url value='/UCMS'/>">[회원 수정]</a><br>
<a href="<c:url value='/DMS'/>">[회원 삭제]</a><br>

</body>
</html>