<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title><spring:message code="member.info" /></title>
</head>
<body>
	<h2>
		<spring:message code="member.info" />
	</h2>


	<!-- 
<form action="step3" method="post">
<p>
	<label>
		이메일 : <br>
		<input type = "email" name="email" id="email" value="${formData.email }">
	</label>
</p>

<p>
	<label>
		이름 : <br>
		<input type = "text" name="name" id="name"  value="${formData.name }">
	</label>
</p>

<p>
	<label>
		비밀번호 : <br>
		<input type = "password" name="password" id="password">
	</label>
</p>

<p>
	<label>
		비밀번호 확인 : <br>
		<input type = "password" name="confirmPassword" id="confirmPassword">
	</label>
</p>

<button type="submit">가입 완료</button>




</form>
 -->
	<!-- 커맨드객체 이름 -->
	<form:form action="step3" modelAttribute="formData">
		<p>
			<label><spring:message code="email" /> : <br> <form:input
					path="email" /> 
					<form:errors path="email" element="div" delimiter="br"/> </label>
		</p>

		<p>
			<label> <spring:message code="name" /> : <br> <form:input
					path="name" />
				<form:errors path="name" />
			</label>
		</p>

		<p>
			<label> <spring:message code="password" /> : <br> <form:password
					path="password" />
				<form:errors path="password" />
			</label>
		</p>

		<p>
			<label> <spring:message code="password.confirm" /> : <br>
				<form:password path="confirmPassword" />
				<form:errors path="confirmPassword" />
			</label>
		</p>

		<button type="submit">
			<spring:message code="register.btn" />
		</button>

	</form:form>


</body>
</html>