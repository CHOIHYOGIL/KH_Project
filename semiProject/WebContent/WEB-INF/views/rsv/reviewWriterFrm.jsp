<%@page import="rsv.model.vo.Rsv"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	Rsv rsv = (Rsv) request.getAttribute("rsv");
	String userId = (String) request.getAttribute("userId");
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
<title>후기작성 | selcar</title>
</head>
<body>
	<%@include file="/WEB-INF/views/common/header.jsp"%>
	<section>
	<div class="table-wrapper" style="width: 80%; margin: 0 auto">
		<form action="/insertReview" method="post">
			<table class="table table-bordered">
				<tr>
					<th colspan="2">후기 작성</th>
				</tr>
				<tr>
					<input type="hidden" name="rsvNo" value="<%=rsv.getRsvNo()%>">
					<input type="hidden" name="userId" value="<%=userId%>">
					<input type="hidden" name="carNo" value="<%=rsv.getCarNo()%>">

					<th>예약일</th>
					<td><%=rsv.getRsvDate()%></td>
				</tr>

				<tr>
					<th>사용기간</th>
					<td><%=rsv.getRsvStart()%> ~ <%=rsv.getRsvEnd()%></td>
				</tr>

				<tr>
					<th>사용한 차</th>
					<td><%=rsv.getCarNo()%></td>
				</tr>

				<tr>
					<th>예약번호</th>
					<td><%=rsv.getRsvNo()%></td>
				</tr>






				<tr>
					<th>평점</th>
					<td><select style="width: 50px;" name="rate">
							<option value="5" selected>5</option>
							<option value="4">4</option>
							<option value="3">3</option>
							<option value="2">2</option>
							<option value="1">1</option>
							<option value="0">0</option>
					</select></td>
				</tr>
				<tr>
					<th>내용</th>
					<td><textarea name="reviewContent" class="form-control"
							row="50" col="40"></textarea></td>
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