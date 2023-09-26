<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>응답내용</title>
</head>
<body>
	<h2>응답 내용</h2>
	<ul>
		<c:forEach var="response" items="${answeredData.responses }" varStatus="s">
			<li>${s.index+1}번 문항의 답변 : ${response }</li>
		</c:forEach>		
	</ul>
	<p>응답자 사는 지역 : ${answeredData.respondent.location }</p>
	<p>응답자 나이 : ${answeredData.respondent.age }</p>
</body>
</html>