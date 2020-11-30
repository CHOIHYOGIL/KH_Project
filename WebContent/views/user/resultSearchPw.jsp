<%@page import="member.model.vo.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    boolean result = (Boolean)request.getAttribute("result");
    User u = (User)request.getAttribute("userPw");
    %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>결과</title>
<style>
	.wrapper{
		margin-top : 80px;
	}
	.searchId{
		width : 300px;
		height : 300px;
		border-top : 2px solid black;
		border-left : 1px solid #e7e7e7;
		border-right : 1px solid #e7e7e7;
		border-bottom : 1px solid #e7e7e7;
		text-align : center;
		margin : 0 auto;
	}
	button{
		width : 150px;
		height : 30px;
		font-size : 15px;
	}
</style>
</head>
<body>
<div class="wrapper">
	<div class="searchId">
		<br><br><br><br>
		<%if(result==true){ %>
			[<span>당신의 비밀번호는 <%=u.getUserPw()%></span>] 입니다.
		<%}else{ %>
			[<span>찾으시는 정보가 존재 하지 않습니다.</span>]
		<%} %>
		<br><br><br><br>
		<button onclick="window.close();">닫기</button>
	</div>
</div>
</body>
</html>