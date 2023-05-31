<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page session="false"%>
<html>
<head>
<title>ReminiScene</title>
</head>
<body>
	<script>
		if("${msg }"!="") {
			alert("${msg }");
		}
	</script>
	<c:set var="path" value="${ pageContext.request.contextPath }" scope="application"/>
	<div class="container">
		<div class="inner">
			<form id="login-form" action="${path }/login" method="post">
				<input type="text" name="id" placeholder="ID" required>
				<input type="password" name="pw" placeholder="Password" required>
				<input type="submit" value="로그인">
				<input name="${_csrf.parameterName}" type="hidden" value="${_csrf.token}"/>
			</form>
		</div>
	</div>
</body>
</html>
