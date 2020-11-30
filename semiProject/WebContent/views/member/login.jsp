<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>로그인</title>
<style>
	#login-box{
		width:800px;
		color:black;
		margin: 0 auto;
		border : 1px solid #eee;
		box-sizing:border-box;
		padding:30px;
	}
	#login-box>h1{
		margin-bottom:20px;
	}
	#login-box>ul>li{
		font-size:20px;
	}
	#btn-wrapper{
		text-align:right;
	}
	#btn-wrapper>a{
		font-size:15px; 
	}
</style>
</head>
<body>
<%@include file="/WEB-INF/views/common/header.jsp" %>
	<section>
		<form action="/login" method="post" id="login-box">
		<h1>로그인</h1>
			<ul>
				<li><label for="memberId">아이디</label></li>
				<li><input type="text" name="memberId" id="memberId" class="form-control"></li>
				<li><label for="memberPw">비밀번호</label></li>
				<li><input type="password" name="memberPw" id="memberPw" class="form-control"></li>
				<li id="btn-wrapper">
					<br>
					<button class="btn btn-outline-danger btn-lg" type="submit">로그인</button>
					<button class="btn btn-outline-danger btn-lg" type="reset">초기화</button>
					<br><br>
					<a href="#">아이디/비밀번호 찾기</a>
				</li>
			</ul>
		</form>
	</section>
</body>
</html>