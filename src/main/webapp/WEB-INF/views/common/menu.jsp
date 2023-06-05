<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="${ pageContext.request.contextPath }/resources/css/style.css" rel="stylesheet" type="text/css">
<style>
@import url('https://fonts.googleapis.com/css2?family=Inter:wght@300;400;500;600&display=swap');
	#menu-container {
		background: #f7f7f7;
		width: 100%;
		height: 60px;
	}
</style>
</head>
<body>
	<c:set var="path" value="${ pageContext.request.contextPath }" scope="application"/>
	<div id="menu-container">
		
	</div>
</body>
</html>