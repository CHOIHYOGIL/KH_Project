<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>로그인</title>
<script type="text/javascript" src="http://code.jquery.com/jquery-3.3.1.js"></script>
<link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@300&family=Poor+Story&family=Sunflower:wght@300&display=swap" rel="stylesheet">
<link href="https://fonts.googleapis.com/css2?family=Do+Hyeon&family=Gugi&family=Nanum+Pen+Script&display=swap"rel="stylesheet">
<link href="https://fonts.googleapis.com/css2?family=Archivo:ital,wght@1,600&display=swap"rel="stylesheet">
<link rel="preconnect" href="https://fonts.gstatic.com">
<link href="https://fonts.googleapis.com/css2?family=Jua&display=swap" rel="stylesheet">
</head>
<style>
	.logo{
		margin-top : 100px;
		height : 150px;
		width : 100%;
		text-align : center;
	}
	#login-box{
		border-top : 2px solid black;
		border-left : 1px solid #e7e7e7;
		border-right : 1px solid #e7e7e7;
		border-bottom : 1px solid #e7e7e7;
		text-align : center;
		margin : 0 auto;
		width : 500px;
		height : 500px;
	}
	#logintbl{
		width : 80%;
		text-align : center;
		margin : 50px;
	}
	input{
		width : 100%;
		height : 30px;
	}
	button{
		font-family: 'Noto Sans KR', sans-serif;
		font-size : 25px;
		text-align : center;
		width : 80%;
		height : 50px;
	}
	.menu>li{
		width : 100px;
		display : inline-block;
		list-style : none;
	}
	.menu>li>a{
		color : black;
		text-align : center;
		text-decoration : none;
	}
	.menu{
		padding : 0px;
	}
	.list{
		margin : 0 auto;
		text-align : center;
	}
	h2{
		font-family : NanumBarunGothic;
	}
</style>
<body>
<div class="wrapper">
	<div class="logo"><img src="/img/main.png" onclick="location.href='/'" style="cursor: pointer;"></div>
	<form action="/login" method="post" id="login-box">
		<table id="logintbl">
			<br><br><br>
			<h2>셀카에 오신걸 환영합니다 ! </h2>
			<tr>
				<td><input type="text" id="userId" name="userId" placeholder="아이디를 입력하세요">
			</tr>
			<tr>
				<td><input type="password" id="userPw" name="userPw" placeholder="비밀번호를 입력하세요">
			</tr>
		</table>
		<button type="submit">로그인</button><br><br>
		<div class="list">
		<ul class="menu">
			<li><a href="#" onclick="window.open('/views/user/searchId.jsp','아이디찾기','width=500px,height=500px');return false">아이디 찾기</a></li>
			<li><a href="#" onclick="window.open('/views/user/searchPw.jsp','비밀번호찾기','width=500px,height=500px');return false">비밀번호찾기</a></li>
			<li><a href="/views/user/join.jsp">회원가입</a></li>
		</ul>
	</div>
	</form>
</div>
<script>
	$("input[name=userId]"),$("input[name=userPw]").keyup(function(){
		var button = $("button[type=submit]");
		var userId = $("input[name=userId]").val;
		var userPw = $("input[name=userPw]").val;
		button.css('background-color','#00FF40');
	});
</script>
</body>
</html>