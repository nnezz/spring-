<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title><spring:message code="selectMemberList"/></title>
</head>
<body>
	<h2><spring:message code="selectMemberList"/></h2>
	<form:form modelAttribute="listCommand">
		<p>
			<label> from : <form:input path="from"/></label><form:errors path="from"/>
			 ~ 
			<label> to : <form:input path="to"/></label><form:errors path="to"/>
			<button type="submit"><spring:message code="selectMemberList.check"/></button>
		</p>
	</form:form>
	
	<c:if test="${!empty members }">
	<hr>
	<table border="1">
	<tr>
		<th>아이디</th>
		<th>이름</th>
		<th>이메일</th>
	</tr>
	<c:forEach var="member" items="${members }">
		<tr>
			<td>${member.id }</td>
			<td><a href="<c:url value='/member/detail/${member.id }'/>">${member.name }</a></td>
			<td>${member.email }</td>
		</tr>	
	</c:forEach>	
	</table>	
	</c:if>
</body>
</html>