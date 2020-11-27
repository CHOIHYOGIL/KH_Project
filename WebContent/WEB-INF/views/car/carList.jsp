<%@page import="car.model.vo.Car"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	ArrayList<Car> list = (ArrayList<Car>) request.getAttribute("list");
	String pageNavi = (String) request.getAttribute("pageNavi");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="https://use.fontawesome.com/releases/v5.2.0/js/all.js"></script>
<title>selcar | 차량 목록</title>
<style>

/* 소현 */
#pageNavi>* {
	margin: 10px;
}

.selectPage {
	font-size: 18px;
	color: blue;
}

/* 가영 */
input {
	border: 1px solid #bbb;
	border-radius: 2px;
}

section {
	margin-top: 80px;
	margin-bottom: 120px;
	width: 100%;
}

section>div {
	width: 80%;
	margin: 0 auto;
}

#option-box>form {
	
}

#option-box table {
	margin: 0 auto;
	border-top: none;
}

#option-box table label {
	display: inline-block;
	margin-left: 10px;
}

select {
	border: 1px solid #bbb;
	height: 28px;
	border-radius: 2px;
}

#rent-car-list table {
	width: 100%;
}

#rent-car-list table tr:hover {
	background-color: #eee;
}

#sort-box {
	box-sizing: border-box;
	padding-top: 20px;
}

#sort-box>select {
	float: right;
}

.carlist {
	margin-bottom: 10px;
	line-height: 80px;
	text-align: center;
}

.carlist>td:first-child>div {
	overflow: hidden;
	width: 100px;
	height: 80px;
	border-radius: 2px;
	margin: 0 auto;
}

.search {
	background-color: #008891;
	color: white;
	width: 100px;
	height: 100px;
	border: none;
	borde-radius: 3px;
}
</style>
</head>
<body>
	<%@include file="/WEB-INF/views/common/header.jsp"%>

	<section>
	<div style="margin-top: 20px;">
		<h2>차량 검색</h2>
		<hr>
	</div>
	<div id="option-box">
		<table class="table" style="background-color: rgb(238, 238, 238)">
			<tr>
				<th>지역</th>
				<td colspan="3"><select style="width: 50px;">
						<option value="서울" selected>서울</option>
						<option value="강원">강원</option>
						<option value="경기">경기</option>
						<option value="대전">대전</option>
						<option value="대구">대구</option>
						<option value="울산">울산</option>
						<option value="부산">부산</option>
				</select> <input type="text" name="addr" style="width: 265px;" required>
				</td>
				<td colspan="3"><input type="date" name="date-range1">
					<span style="margin-left: 10px; margin-right: 10px"> ~ </span> <input
					type="date" name="date-range2"></td>
				<th>차종</th>
				<td colspan="3"><label><input type="checkbox"
						name="car-type" value="small">소형</label> <label><input
						type="checkbox" name="car-type" value="midium">중형</label> <label><input
						type="checkbox" name="car-type" value="large">대형</label></td>
				<td><input type="text" name="carName"></td>
		</table>
	</div>
	<br>
	<br>
	<div id="sort-box" style="height: 70px;">
		<h3 style="display: inline-block;">검색 결과</h3>

		<select>
			<option value="priceAsce">가격순(오름차순)</option>
			<option value="priceDesc">가격순(내림차순)</option>
			<option value="priceAsce">평점순</option>
		</select>

	</div>
	<div id="rent-car-list">
		<table class="table">
			<tr style="background-color: #eee; text-align: center;">
				<th></th>
				<th>제품</th>
				<th>차종</th>
				<th>가격(시간)</th>
				<th>지역</th>
				<th>렌트 기간</th>
				<th>평점</th>
				<th>상세보기</th>
			</tr>
			<%
				for (Car c : list) {
			%>
			<tr class="carlist">
				
				<td><%=c.getCarName()%></td>
				<td><%=c.getCarType()%></td>
				<td><%=String.format("%,d", Integer.parseInt(c.getCarPrice()))%></td>
				<td><%=c.getCarLocation()%></td>
				<td><%=c.getCarSdate()%> ~ <%=c.getCarEdate()%></td>
				<td><i class="fas fa-star" style="color: orange;"></i> <%=c.getCarRate() %>
					/ 5</td>
				<td><a href="/carDetailView?carNo=<%=c.getCarNo() %>"
					class="btn btn-primary btn-sm">상세보기</a></td>
			</tr>
			<%
				}
			%>
		</table>
		<div id="pageNavi"><%=pageNavi%></div>
	</div>
	</section>

	<%@include file="/WEB-INF/views/common/footer.jsp"%>
	<script>
		//$(".carlist img").click(function(){
		//var user =
	<%=u%>
		//if(user==null){
		//	alert("로그인 후 이용해 주세요");
		//	return false;
		//}
		//});
	</script>

</body>
</html>