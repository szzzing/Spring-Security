<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page session="false" %>
<html>
<head>
	<title>ReminiScene :: 관리자</title>
	<style>
		.nickname {
			font-size: 20px;
			font-weight: 600;
		}
	</style>
	<link href="${ pageContext.request.contextPath }/resources/css/style.css" rel="stylesheet" type="text/css">
</head>
<body>
	<c:set var="path" value="${ pageContext.request.contextPath }" scope="application"/>
	<jsp:include page="../common/menu.jsp"/>
	
	<div class="wrap">
		<div class="container">
		
			<sec:authorize access="isAuthenticated()">
				<div class="profile">
					<span class="h2 bold">
						관리자!!!!!!!!!!!!!!!!!!!!
					</span>
					
					<form action="${path }/logout" method="POST"> 
						<input type="submit" value="로그아웃" />
						<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
					</form>
				</div>
			</sec:authorize>
		</div>
	</div>
	
</body>
</html>
