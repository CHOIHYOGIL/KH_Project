<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>공지사항 작성</title>
</head>
<body>
	<%@include file="/WEB-INF/views/common/header.jsp"%>
	<section>
	<div class="table-wrapper" style="width: 80%; margin: 0 auto">
		<form action="/insertNotice" method="post">
			<table class="table table-bordered">
				<tr>
					<th colspan="2">공지사항 작성</th>
				</tr>
				<tr>
					<th>제목</th>
					<td><input type="text" class="form-contol" name="noticeTitle"></td>
				</tr>

				<tr>
					<th>작성자</th>
					<td>관리자</td>
				</tr>
				<tr>
					<th>내용</th>
					<td><textarea name="noticeContent" class="form-control"
							row="3" col="40"></textarea></td>
				</tr>

				<tr style="text-align: center;">
					<th colspan="2"><button type="submit" class="btn btn-primary">등록하기</button>
					</th>
				</tr>

			</table>
		</form>
	</div>
	</section>
</body>
</html>