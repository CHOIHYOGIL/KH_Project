<%@page import="car.model.vo.Car"%>
<%@page import="rsv.model.vo.Rsv"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	Rsv rsv = (Rsv) request.getAttribute("rsv");
	String userId = (String) request.getAttribute("userId");
	Car car = (Car) request.getAttribute("car");
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
<title>신고 | selcar</title>
</head>
<body>
	<%@include file="/WEB-INF/views/common/header.jsp"%>
	<section>
	<div class="table-wrapper" style="width: 80%; margin: 0 auto">
		<form action="/insertReport" method="post">
			<table class="table table-bordered">
				<tr>
					<th colspan="2">회원 신고!!!</th>
				</tr>
				<tr>
				<input type="hidden" name="who" value="user">
					<input type="hidden" name="rsvNo" value="<%=rsv.getRsvNo()%>">
					<input type="hidden" name="reporter" value="<%=userId%>">
					<input type="hidden" name="reportee" value="<%=rsv.getUserId()%>">

					<th>예약일</th>
					<td><%=rsv.getRsvDate()%></td>
				</tr>

				<tr>
					<th>사용기간</th>
					<td><%=rsv.getRsvStart()%> ~ <%=rsv.getRsvEnd()%></td>
				</tr>

				<tr>
					<th>내 차량</th>
					<td><%=car.getCarNopan()%></td>
				</tr>

				<tr>
					<th>신고할 회원</th>
					<td><%=rsv.getUserId()%></td>
				</tr>

				<tr>
					<th>내용</th>
					<td><textarea name="reportContent" class="form-control"
							row="50" col="40"></textarea></td>
				</tr>

				<tr style="text-align: center;">
					<th colspan="2"><button type="submit" class="btn btn-primary">신고하기</button>
					</th>
				</tr>

			</table>
		</form>
	</div>
	</section>
	<%@include file="/WEB-INF/views/common/footer.jsp"%>
</body>
</html>