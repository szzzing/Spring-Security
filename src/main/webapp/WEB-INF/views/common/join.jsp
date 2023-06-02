<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page session="false"%>
<html>
<head>
<title>Join</title>
<link href="${path }/resources/css/style.css" rel="stylesheet" type="text/css">
<script src="https://code.jquery.com/jquery-3.7.0.js" integrity="sha256-JlqSTELeR4TLqP0OG9dxM7yDPqX1ox/HfgiSLBj8+kM=" crossorigin="anonymous"></script>
<style>
</style>
</head>
<body>
	<c:set var="path" value="${ pageContext.request.contextPath }" scope="application"/>
	<div class="wrap">
		<div class="container">
			<div class="h2 bold">
				JOIN
			</div>
			<form id="login-form" action="${path }/join.do" method="POST" accept-charset="UTF-8">
				<div class="title">아이디</div>
				<div class="info">영문, 숫자, 특수문자를 포함해 4-16자 사이로 만들어주세요</div>
				<input type="text" name="id" required>
				<div class="title">아이디</div>
				<div class="info">당신을 표현할 닉네임 정해보세요</div>
				<input type="text" name="nickname" required>
				<div class="title">비밀번호</div>
				<div class="info">영문, 숫자, 특수문자를 포함해 8-16자 사이로 만들어주세요</div>
				<input type="password" name="pw" required>
				<div class="title">비밀번호 확인</div>
				<div class="info">비밀번호를 다시 입력해주세요</div>
				<input type="password" id="pw2" required>
				<div class="title">이메일</div>
				<div class="info">업데이트 소식을 받을 이메일을 입력해주세요</div>
				<input type="hidden" name="email" required>
				<input class="border" type="text" id="email1" required>
				<span class="mute2" style="margin:0px 8px">@</span>
				<select id="email2" required>
					<option value="gmail.com">gmail.com</option>
					<option value="naver.com">naver.com</option>
					<option value="kakao.com">kakao.com</option>
					<option value="N">직접 입력</option>
				</select>
				<input id="register" type="button" value="가입하기" style="margin-top:40px;" onclick="submitForm();">
				<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
			</form>
		</div> 
	</div>
	<script>
		$("select#email2").on("change", function(){
			if($(this).val()=="N") {
				var div = $("<input id='email2' class='new-input'>");
				$(this).parent().append(div);
				$(this).remove();
			}
			console.log($("input[name=nickname]").val());
		});
		
		function submitForm() {
			var id = $("input[name=id]").val().trim();
			var pw = $("input[name=pw]").val();
			var pw2 = $("#pw2").val();
			
			var email1 = $("#email1").val();
			var email2 = $("#email2").val().trim();
			$("input[name=email]").val(email1 + "@" + email2);
			
			// 비밀번호
			if(pw==pw2) {
				$("#login-form").submit();
			} else {
				alert("비밀번호를 확인하세요.");
			}
		}
	</script>
</body>
</html>
