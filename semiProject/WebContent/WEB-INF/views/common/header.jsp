<%@page import="member.model.vo.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  <% User u = (User)session.getAttribute("u"); %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<script type="text/javascript" src="/js/jquery-3.3.1.js"></script>
<link rel="stylesheet" href="/css/bootstrap.css">
<link rel="stylesheet" href="/css/header/style.css">
<link rel="stylesheet" href="/css/header/responsive.css">
<script type="text/javascript" src="/js/bootstrap.js"></script>
<head>
<title>Insert title here</title>
<style>
	
	header{
		width:100%;
		height:200px;
		background-color : #eee;
	}
</style>
</head>
<body>
	<header>
		<div class="right-button">
					<ul>
				<%if(u==null){ %>
						<li class="nav-item"><button class="btn btn-danger" onclick="location.href='/views/member/login.jsp'">로그인</button></li>
						<li class="nav-item"><button class="btn btn-danger" onclick="location.href='/views/member/join.jsp'">회원가입</button></li>	
				<%}else{%>		
						<li class="nav-item"><button class="btn btn-danger" onclick="location.href='/mypage?memberId=<%=u.getUserId()%>'"><%=u.getUserName() %></button></li>
						<li class="nav-item"><button class="btn btn-danger" onclick="location.href='/logout'">로그아웃</button></li>	
				<%} %>
					</ul>
				</div>
	</header>
</body>
</html>