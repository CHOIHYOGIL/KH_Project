<%@page import="rsv.model.vo.Rsv"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	ArrayList<Rsv> list = (ArrayList<Rsv>) request.getAttribute("list");
	String pageNavi = (String) request.getAttribute("pageNavi");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%@include file="/WEB-INF/views/common/header.jsp"%>
	<section>
	<div class="table-wrapper"
		style="text-align: center; width: 80%; margin: 0 auto;">


		<table class="table table-striped">
			<tr>
				<th colspan="8" style="font-size: 20px; font-weight: bold">내 차의
					예약 리스트</th>
			</tr>


			<tr>
				<th>빌리는 회원</th>
				<th>렌트 시작일</th>
				<th>시간</th>
				<th>렌트 종료일</th>
				<th>시간</th>
				<th>가격</th>
				<th>진행상태</th>
			</tr>

			<%
				for (Rsv r : list) {
			%>

			<tr>
			
			
				<td><%=r.getUserId()%></td>
				<td><%=r.getRsvStart()%></td>
				<td><%=r.getRsvStime()%></td>
				<td><%=r.getRsvEnd()%></td>
				<td><%=r.getRsvEtime()%></td>
				<td><%=r.getRsvPrice()%></td>

				<td>
					<%
						if (r.getRsvStatus() == 1) {
					%> <span>렌트요청</span> <%
 	} else if (r.getRsvStatus() == 20) {
 %> <span>결제 대기 중</span> <%
 	} else if (r.getRsvStatus() == 21) {
 %> <span>렌트거절</span> <%
 	} else if (r.getRsvStatus() == 22) {
 %> <span>결제완료</span> <%
 	} else if (r.getRsvStatus() == 3) {
 %> <span>렌트중</span> <%
 	} else if (r.getRsvStatus() == 3) {
 %> <span>결제완료</span> <%
 	} else if (r.getRsvStatus() == 4) {
 %> <span>반납</span> <%
 	} else if (r.getRsvStatus() == 5) {
 %> <span>반납확인완료</span> <%
 	} else if (r.getRsvStatus() == 0 || r.getRsvStatus() == -1) {
 %> <span>렌트취소</span> <%
 	}
 %>
				</td>
				<td>
					<%
						if (r.getRsvStatus() == 1) {
					%><a href="/changeRsvStatus?status=20&rsvNo=<%=r.getRsvNo()%>"
					class="btn btn-primary btn-sm">수락</a> <a
					href="/changeRsvStatus?status=21&rsvNo=<%=r.getRsvNo()%>"
					class="btn btn-primary btn-sm">거절</a> <%
 	} else if (r.getRsvStatus() == 20) {
 %><a href="/changeRsvStatus?status=-1&rsvNo=<%=r.getRsvNo()%>"
					class="btn btn-primary btn-sm">예약취소</a> <%
 	} else if (r.getRsvStatus() == 4) {
 %><a href="/changeRsvStatus?status=5&rsvNo=<%=r.getRsvNo()%>"
					class="btn btn-primary btn-sm">반납확인</a> <a
					href="/report?userId=<%=r.getUserId()%>"
					class="btn btn-primary btn-sm">신고</a> <%
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