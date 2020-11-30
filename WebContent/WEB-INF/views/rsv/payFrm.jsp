<%@page import="rsv.model.vo.Rsv"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	Rsv rsv = (Rsv) request.getAttribute("rsv");
	User user = (User) request.getAttribute("user");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>예약상세내역</title>
<script type="text/javascript"
	src="https://cdn.iamport.kr/js/iamport.payment-1.1.5.js"></script>
</head>
<style>
#pay, #result {
	float: left;
}
</style>
<body>
	<%@include file="/WEB-INF/views/common/header.jsp"%>

	<section>

	<div class="table-wrapper" style="width: 80%; margin: 0 auto;">
		<table class="table table-bordered">
			<tr>
				<th colspan="2">예약내역확인</th>
			</tr>

			<tr>
				<th>내이름</th>
				<td><%=user.getUserName()%></td>
			</tr>

			<tr>
				<th>차번호</th>
				<td><%=rsv.getCarNo()%></td>
			</tr>

			<tr>
				<th>렌트시작</th>
				<td><%=rsv.getRsvStart()%></td>
			</tr>
			<tr>
				<th>시간</th>
				<td><%=rsv.getRsvStime()%></td>
			</tr>

			<tr>
				<th>렌트종료</th>
				<td><%=rsv.getRsvEnd()%></td>
			</tr>

			<tr>
				<th>시간</th>
				<td><%=rsv.getRsvEtime()%></td>
			</tr>

			<tr>
				<th>가격</th>
				<td><%=rsv.getRsvPrice()%></td>
			</tr>

			<tr>
				<th colspan="2">
					<div id="pay">
						<button class="btn btn-primary">결제하기</button>
					</div>
					<div id="result">
						<a href="javascript:history.go(-1)" class="btn btn-danger">취소하기</a>
					</div>
				</th>
			</tr>
			<tr>
				<th colspan="2">결제 진행 상태
					<p id="paymentResult"></p>
				</th>
			</tr>

		</table>


	</div>
	</section>
	<script>
		$(function() {

			$("#pay button").click(
					function() {
						var price =<%=rsv.getRsvPrice()%>;
						var email ="<%=user.getUserEmail()%>"
		;
						var buyerName =
	"<%=user.getUserName()%>"
		;
						var tel =
	"<%=user.getUserPhone()%>"
		;
						var addr =
	"<%=user.getUserAddr()%>";
						var d = new Date();
						var date = d.getFullYear() + '' + (d.getMonth() + 1)
								+ '' + d.getDate() + '' + d.getHours() + ''
								+ d.getMinutes() + '' + d.getSeconds();
						IMP.init("imp97285928");

						IMP.request_pay({//결제를 위해 전달해주는 정보
							merchant_uid : '상품명_' + date,//상점거래ID
							name : "차량대여", //결제이름
							amount : price, //결제금액
							buyer_email : email,
							buyer_name : buyerName,
							buyer_tel : tel,
							buyer_addr : addr,
							buyer_postcode : "000-000" //우편번호

						}, function(rsp) {//위의 값을 가지고 결제모듈을 진행
							if (rsp.success) { //결제가 성공한 경우
								$("#paymentResult").html("결제 성공!");
							location.href="/changeRsvStatus?status=22&rsvNo=<%=rsv.getRsvNo()%>";
							} else { //결제 실패한 경우
							$("#paymentResult").html(
								"결제 실패 사유 : "+ rsp.error_msg);
							}
							})
							});
		});
	</script>

</body>
</html>