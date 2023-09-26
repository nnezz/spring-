<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title><spring:message code="memberDetail"/></title>
</head>
<body>
	<h2><spring:message code="memberDetail"/></h2>
	<p><spring:message code="memberID"/> : ${member.id }</p>
	<p><spring:message code="email"/> : ${member.email }</p>
	<p><spring:message code="name"/> : ${member.name }</p>
	<p><spring:message code="regDate"/> :
	<fmt:formatDate value="${member.registerDate }" pattern="yyyy-MM-dd HH:mm"/></p>
	<hr>
	<p><a href="<c:url value='/member/list'/>"><spring:message code="viewMemberList"/></a></p>
	
</body>
</html>