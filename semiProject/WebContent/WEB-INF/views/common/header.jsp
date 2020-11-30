<%@page import="member.model.vo.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	User u = (User) session.getAttribute("user");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>selcar에 오신걸 환영합니다!</title>
<script type="text/javascript"
	src="http://code.jquery.com/jquery-3.3.1.js"></script>
<link
	href="https://fonts.googleapis.com/css2?family=Do+Hyeon&family=Gugi&family=Nanum+Pen+Script&display=swap"
	rel="stylesheet">
<link
	href="https://fonts.googleapis.com/css2?family=Archivo:ital,wght@1,600&display=swap"
	rel="stylesheet">
<link rel="preconnect" href="https://fonts.gstatic.com">
<link
	href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@300&family=Poor+Story&family=Sunflower:wght@300&display=swap"
	rel="stylesheet">

<style>
.header {
	width:100%;
	height: 10%;
	overflow:hidden;
}

.header>div {
	float: left;
}

.logo {
	text-align: center;
	width: 20%;
}

.navi {
	text-align: center;
	height: 100%;
	width: 60%;
}

.menu>li {
	line-height: 80px;
	text-align: center;
	margin: 0px;
	padding: 0px;
	width: calc(100%/4);
	display: inline-block;
	list-style: none;
}

.menu>li>a {
	font-weight: bold;
	color: black;
	font-family: 'Noto Sans KR', sans-serif;
	text-decoration: none;
	font-size: 20px;
}

.loginbox {
	text-align: center;
	width: 20%;
}

.sub-header {
	/* display: none; */
	opacity: 0; text-align : center;
	width: 100%;
	text-align: center;
}

.sub-header>div {
	margin: 0 auto;
	float: left;
}

.loginmenu>li {
	line-height: 80px;
	display: inline-block;
	list-style: none;
}

.loginmenu>li>a {
	font-weight: bold;
	color: black;
	text-decoration: none;
}

.sub-header {
	margin-top: -15px;
}

.sub-menu {

	margin-left: -35px;
	
	text-align: center;
}

.sub-menu>li {
padding-top:10%;
	line-height: 40px;
	width: 350px;
	list-style: none;
}

.sub-menu>li>a {
	font-family: 'Noto Sans KR', sans-serif;
	color: black;
	text-decoration: none;
}

.sub-menu1 {
	margin-left: 400px;
}

.sub-menu1>li {
	line-height: 40px;
	width: 350px;
	list-style: none;
}

.sub-menu1>li>a {
	font-family: 'Noto Sans KR', sans-serif;
	color: black;
	text-decoration: none;
}

.on {
	/* 메뉴내려오면서 content도 내려같이 내려가는거 수정 */
	/* display: block; */
	opacity: 100;
}
</style>
</head>
<body>

	<div class="header">
		<div class="logo">
			<img src="/img/main.png" onclick="location.href='/'"
				style="cursor: pointer;">
		</div>
		<div class="navi">
			<ul class="menu">
				<li><a href="#">서비스 소개</a></li>
				<li><a href="#">렌트 이용</a></li>
				<li><a href="#">고객센터</a></li>
			</ul>
		</div>
		<div class="loginbox">
			<ul class="loginmenu">
				<%
					if (u == null) {
				%>
				<li><a href="/views/user/login.jsp">로그인</a></li>
				<li><a href="/views/user/join.jsp">회원가입</a></li>
				<%
					} else {
				%>
				<li><a href="/mypage?userId=<%=u.getUserId()%>"><%=u.getUserId()%>
						님</a></li>
				<li><a href="/logout">로그아웃</a></li>
				<%
					}
				%>
			</ul>
		</div>
		<div class="sub-header">
			<div class="sub-navi">
				<ul class="sub-menu1">
					<li><a href="/views/selcar_introduce.jsp">서비스 소개</a></li>
					<li><a href="/views/selcar_manual.jsp">이용안내</a></li>
				</ul>
			</div>
			<div class="sub-navi">
				<ul class="sub-menu">
					<li><a href="#">차량등록</a></li>
					<li><a href="/carList?reqPage=1">차량 예약</a></li>
				</ul>
			</div>
			<div class="sub-navi">
				<ul class="sub-menu">
					<li><a href="/noticeList?reqPage=1">공지사항</a></li>
					<li><a href="#">1:1 문의</a></li>
					<li><a href="#">고객센터</a></li>
				</ul>
			</div>
		</div>
	</div>
	<script>
		$(".menu li").mouseover(function() {
			var subnavi = $(".sub-header");
			var navi = $(".header");
			var menuli = $(".menu li a");
			var loginmenuli = $(".loginmenu li a");
			menuli.css('color', 'black');
			loginmenuli.css('color', 'black');
			navi.css('background-color', 'white');
			subnavi.css("background-color", "white");
			subnavi.removeClass("on");
			subnavi.addClass("on");
		});
		$(".sub-header").mouseleave(function() {
			var subnavi = $(".sub-header");
			var navi = $(".header");
			navi.css('background-color', "transparent");
			subnavi.css('background-color', 'white');
			subnavi.removeClass("on");
		})
		$(".logo").click(function() {
			location.href("/");
		})
	</script>
</body>
</html>