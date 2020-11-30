<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>아이디 찾기</title>
<style>
	h2{
		text-align : center;
	}
	.searchId{
		border-top : 2px solid black;
		border-left : 1px solid #e7e7e7;
		border-right : 1px solid #e7e7e7;
		border-bottom : 1px solid #e7e7e7;
		text-align : center;
	}
	input{
		width : 100%;
		height : 30px;
	}
	.searchId-tbl{
		width : 70%;
		margin : 0 auto;
		text-align : center;
	}
	button{
		font-size : 15px;
		width : 70%;
		height : 30px;
	}
</style>
</head>
<body>
<div class="wrapper">
	<h2>아이디 찾기</h2>
	<br><br>
	<form action="/searchId" method="post" class="searchId"><br><br>
		<table class="searchId-tbl">
			<tr>
				<td><input type="text" id="userName" name="userName" placeholder="이름을 입력하세요"></td>
			</tr>
			<tr>
				<td><input type="text" id="userPhone" name="userPhone" placeholder="전화번호를 입력하세요"></td>
			</tr>
		</table><br><br>
		<button type="submit">아이디 찾기</button><br><br><br><br>
	</form>
</div>
</body>
</html>