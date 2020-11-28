<%@page import="rsv.model.vo.Rsv"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	ArrayList<Rsv> list = (ArrayList<Rsv>) request.getAttribute("list");
	String pageNavi = (String) request.getAttribute("pageNavi");
	String userId = (String) request.getAttribute("userId");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>나의 예약</title>
</head>
<body>
	<%@include file="/WEB-INF/views/common/header.jsp"%>
	<section>
	<div class="table-wrapper"
		style="text-align: center; width: 80%; margin: 0 auto;">


		<table class="table table-striped">
			<tr>
				<th colspan="7" style="font-size: 20px; font-weight: bold">나의
					예약 리스트</th>
			</tr>


			<tr>
				<th>내 아이디</th>
				<th>차량</th>
				<th>가격</th>
				<th>렌트 시작일</th>
				<th>랜트 종료일</th>
				<th>진행상태</th>
			</tr>

			<%
				for (Rsv r : list) {
			%>

			<tr>
				<td><%=userId%></td>
				<td><%=r.getCarNo()%></td>
				<td><%=r.getRsvPrice()%></td>
				<td><%=r.getRsvStart()%></td>
				<td><%=r.getRsvEnd()%></td>

				<td>
					<%
						if (r.getRsvStatus() == 1) {
					%> <span>예약요청</span> <%
 	} else if (r.getRsvStatus() == 20) {
 %> <span>렌트수락</span> <%
 	} else if (r.getRsvStatus() == 21) {
 %> <span>렌트거절</span> <%
 	} else if (r.getRsvStatus() == 22) {
 %> <span>결제완료</span> <%
 	} else if (r.getRsvStatus() == 3) {
 %> <span>렌트중</span> <%
 	} else if (r.getRsvStatus() == 4) {
 %> <span>반납확인요청</span> <%
 	} else if (r.getRsvStatus() == 5) {
 %> <span>반납완료</span> <%
 	} else if (r.getRsvStatus() == 0 || r.getRsvStatus() == -1) {
 %> <span>예약취소</span> <%
 	}
 %>
				</td>
						<td>
					<%
						if (r.getRsvStatus() == 1) {
					%><a href="/changeRsvStatus?status=0&rsvNo=<%=r.getRsvNo()%>"
					class="btn btn-primary btn-sm">예약취소</a> <%
 	} else if (r.getRsvStatus() == 20) {
 %> <a href="/payFrm?rsvNo=<%=r.getRsvNo()%>&userId=<%=userId%>"
					class="btn btn-primary btn-sm">결제하기</a><a
					href="/changeRsvStatus?status=0&rsvNo=<%=r.getRsvNo()%>"
					class="btn btn-primary btn-sm">예약취소</a> <%
 	} else if (r.getRsvStatus() == 22) {
 %> <a href="/changeRsvStatus?status=3&rsvNo=<%=r.getRsvNo()%>"
					class="btn btn-primary btn-sm">렌트시작</a> <%
 	} else if (r.getRsvStatus() == 3) {
 %> <a href="/changeRsvStatus?status=4&rsvNo=<%=r.getRsvNo()%>"
					class="btn btn-primary btn-sm">반납하기</a> <%
 	} else if (r.getRsvStatus() == 5) {
 %><a href="/report?carNo=<%=r.getCarNo()%>"
					class="btn btn-primary btn-sm">신고</a> <a
					href="/reviewWriterFrm?rsvNo=<%=r.getRsvNo()%>&userId=<%=userId%>"
					class="btn btn-primary btn-sm">후기작성</a> <%
 	}
 %>


				</td>
			</tr>
			<%
				}
			%>
		</table>
		<div id="pageNavi"><%=pageNavi%></div>
	</div>

	</section>
</body>
</html>