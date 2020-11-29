<%@page import="notice.model.vo.Notice"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	Notice n = (Notice) request.getAttribute("n");
%>
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
<title><%=n.getNoticeTitle()%> | 수정</title>
</head>
<body>
	<%@include file="/WEB-INF/views/common/header.jsp"%>


	<section>


	<div class="table-wrapper" style="width: 80%; margin: 0 auto;">
		<form action="/noticeUpdate" method="post">
			<input type="hidden" name="noticeNo" value="<%=n.getNoticeNo()%>">
			<table class="table table-bordered">
				<tr>
					<th colspan="2"><input type="text" name="noticeTitle"
						class="form-control" value="<%=n.getNoticeTitle()%>"></th>
				</tr>

				<tr>
					<th>내용</th>
					<td><textarea name="noticeContent" class="form-control"
							rows="3" cols="40"><%=n.getNoticeContent()%></textarea></td>
				</tr>
				<tr style="text-align: center">
					<th colspan="2">
						<button type="submit" class="btn btn-primary">수정완료</button> <a
						href="javascript:history.go(-2)" class="btn btn-primary btn-sm">목록으로</a>
					</th>
				</tr>
			</table>
		</form>
	</section>





</body>
</html>