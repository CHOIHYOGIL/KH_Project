<%@page import="notice.model.vo.Notice"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	ArrayList<Notice> list = (ArrayList<Notice>) request.getAttribute("list");
	String pageNavi = (String) request.getAttribute("pageNavi");
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>selcar | 공지사항</title>
<style>
#pageNavi>* {
	margin: 10px;
}

.selectPage {
	font-size: 18px;
	color: blue;
}
</style>
</head>
<body>
	<%@include file="/WEB-INF/views/common/header.jsp"%>
	<section>
	<div class="table-wrapper"
		style="text-align: center; width: 80%; margin: 0 auto;">
		<%
			if (u != null && u.getUserGrade() == 0) {
		%>
		<div style="text-align: right;">
			<a href="/noticeWriterFrm" class="btn btn-primary btn-sm">글쓰기</a>
		</div>
		<%
			}
		%>

		<table class="table table-striped">
			<tr>
				<th colspan="4" style="font-size: 20px; font-weight: bold">
					공지사항</th>
			</tr>

			<tr>
				<th>번호</th>
				<th>제목</th>
				<th>작성일</th>
			</tr>

			<%
				for (Notice n : list) {
			%>
			<tr>
				<th><%=n.getrNum()%></th>
				<th><a href="/noticeView?noticeNo=<%=n.getNoticeNo()%>"><%=n.getNoticeTitle()%></a></th>
				<th><%=n.getNoticeDate()%></th>
			</tr>
			<%
				}
			%>
		</table>
		<div id="pageNavi"><%=pageNavi%></div>
	</div>

	</section>
	<%@include file="/WEB-INF/views/common/footer.jsp"%>
</body>
</html>