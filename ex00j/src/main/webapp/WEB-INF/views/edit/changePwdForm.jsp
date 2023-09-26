<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title><spring:message code="change.pwd.title"/></title>
</head>
<body>
	<form:form modelAttribute="ChangePwdCommand">	
	<p>
		<label>
			<spring:message code="currentPassword" />
			<form:password path="currentPassword" />
			<form:errors path="currentPassword" />				
		</label>	
	</p>
	
	<p>
		<label>
			<spring:message code="newPassword" />
			<form:password path="newPassword" />
			<form:errors path="newPassword" />				
		</label>	
	</p>
	
	
	<button type="submit"><spring:message code="change.pwd.btn"/></button>
	</form:form>
</body>
</html>