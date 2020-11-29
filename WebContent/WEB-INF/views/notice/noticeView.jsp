<%@page import="java.util.ArrayList"%>
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
<title>공지사항 | <%=n.getNoticeTitle()%></title>
</head>
<style>
.content {
	height: 70vh;
}
</style>
<body>
	<%@include file="/WEB-INF/views/common/header.jsp"%>

	<section>

	<div class="table-wrapper" style="width: 80%; margin: 0 auto;">
		<table class="table table-bordered">
			<tr>
				<th>제목</th>
				<th><%=n.getNoticeTitle()%></th>
			</tr>

			<tr>
				<th colspan="2">내용</th>
			</tr>
			<tr>
				<td class="content" colspan="2"><%=n.getNoticeContentBr()%></td>
			</tr>
			<tr style="text-align: center">
				<th colspan="2">
					<%
						if (u != null && u.getUserGrade() == 0) {
					%> <a href="/noticeUpdateFrm?noticeNo=<%=n.getNoticeNo()%>"
					class="btn btn-primary btn-sm">수정하기</a> <a
					href="/noticeDelete?noticeNo=<%=n.getNoticeNo()%>"
					class="btn btn-primary btn-sm">삭제하기</a> <%
 	}
 %> <a href="javascript:history.go(-1)" class="btn btn-primary btn-sm">목록으로</a>
				</th>
			</tr>
		</table>


	</div>
	</section>


</body>
</html>