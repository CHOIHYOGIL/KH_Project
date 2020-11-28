<%@page import="rsv.model.vo.Rsv"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	Rsv rsv=(Rsv) request.getAttribute("rsv");
	String userId = (String) request.getAttribute("userId");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>후기작성 | selcar</title>
</head>
<body>
	<%@include file="/WEB-INF/views/common/header.jsp"%>
	<section>
	<div class="table-wrapper" style="width: 80%; margin: 0 auto">
		<form action="/insertReview?carNo=<%=rsv.getCarNo() %>&userId=<%=userId %>" method="post">
			<table class="table table-bordered">
				<tr>
					<th colspan="2">후기 작성</th>
				</tr>
				<tr>
					<th>예약일</th>
					<td><%=rsv.getRsvDate() %></td>
				</tr>

				<tr>
					<th>사용기간</th>
					<td><%=rsv.getRsvStart() %> ~ <%=rsv.getRsvEnd() %></td>
				</tr>
				<tr>
					<th>내용</th>
					<td><textarea name="reviewContent" class="form-control"
							row="20" col="40"></textarea></td>
				</tr>

				<tr style="text-align: center;">
					<th colspan="2"><button type="submit" class="btn btn-primary">등록하기</button>
					</th>
				</tr>

			</table>
		</form>
	</div>
	</section>
	<%@include file="/WEB-INF/views/common/footer.jsp"%>
</body>
</html>