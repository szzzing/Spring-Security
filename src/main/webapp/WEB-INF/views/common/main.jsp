<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page session="false" %>
<html>
<head>
<script src="https://code.jquery.com/jquery-3.7.0.js" integrity="sha256-JlqSTELeR4TLqP0OG9dxM7yDPqX1ox/HfgiSLBj8+kM=" crossorigin="anonymous"></script>
<title>ReminiScene</title>
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
	<jsp:include page="menu.jsp"/>
	
	<div class="wrap">
		<div class="container">
		
			<!-- 비로그인 -->
			<sec:authorize access="isAnonymous()">
				<form action="${path }/login" method="GET"> 
					<input type="submit" value="로그인" />
				</form>
			</sec:authorize>
			<!-- 비로그인 -->
		
		
			<!-- 로그인 -->
			<sec:authorize access="isAuthenticated()">
				<div class="profile">
					<span class="h2 bold">
						<sec:authentication property="principal.nickname"/>
					</span>
					<span class="h4 bold">님</span><br>
					
					<form action="${path }/logout" method="POST"> 
						<input type="submit" value="로그아웃" />
						<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
					</form>
				</div>
			</sec:authorize>
			<!-- 로그인 -->
		</div>
	</div>
</body>
</html>
