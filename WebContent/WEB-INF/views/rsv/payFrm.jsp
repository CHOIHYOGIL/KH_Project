<%@page import="car.model.vo.Car"%>
<%@page import="member.model.vo.User"%>
<%@page import="rsv.model.vo.Rsv"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	Rsv rsv = (Rsv) request.getAttribute("rsv");
	User user = (User) request.getAttribute("user");
	Car car = (Car) request.getAttribute("car");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author"
	content="Mark Otto, Jacob Thornton, and Bootstrap contributors">
<meta name="generator" content="Jekyll v4.1.1">

   <script type="text/javascript" src="http://code.jquery.com/jquery-3.3.1.js"></script>
<!-- 결제 api  -->
<script type="text/javascript"
	src="https://cdn.iamport.kr/js/iamport.payment-1.1.5.js"></script>
<link rel="canonical"
	href="https://getbootstrap.com/docs/4.5/examples/checkout/">

<!-- Bootstrap core CSS -->
<!-- <link href="../assets/dist/css/bootstrap.min.css" rel="stylesheet"> -->
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css"
	integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2"
	crossorigin="anonymous">
	
	
	<!-- 폰트 -->
	 <link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR&display=swap" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css2?family=Noto+Serif+KR:wght@200;300;400;500;600;700;900&display=swap" rel="stylesheet">
	
	
	

<title>결제 | selcar</title>

<style>

* {
    font-family: 'Noto Sans KR', sans-serif;
}

.bd-placeholder-img {
	font-size: 1.125rem;
	text-anchor: middle;
	-webkit-user-select: none;
	-moz-user-select: none;
	-ms-user-select: none;
	user-select: none;
}

@media ( min-width : 768px) {
	.bd-placeholder-img-lg {
		font-size: 3.5rem;
	}
}
</style>
<!-- Custom styles for this template -->
<!-- <link href="form-validation.css" rel="stylesheet"> -->
</head>

<body class="bg-light">
<%@include file="/WEB-INF/views/common/header.jsp"%>
	<div class="container">

		<div class="row">
			<div class="col-md-4 order-md-2 mb-4">
				<h4 class="d-flex justify-content-between align-items-center mb-3">
					<h4 class="mb-3">예약 내역</h4>
				</h4>
				<ul class="list-group mb-3">
					<li
						class="list-group-item d-flex justify-content-between lh-condensed">
						<div>
							<small class="text-muted">렌트 차량</small>
							<h5 class="my-0"><%=car.getCarNopan()%></h5>
						</div>
					</li>
					<li
						class="list-group-item d-flex justify-content-between lh-condensed">
						<div>
							<small class="text-muted">렌트 시작</small>
							<h6 class="my-0"><%=rsv.getRsvStart()%>
								<%=rsv.getRsvStime()%></h6>

						</div>
					</li>
					<li
						class="list-group-item d-flex justify-content-between lh-condensed">
						<div>
							<small class="text-muted">렌트 종료</small>
							<h6 class="my-0"><%=rsv.getRsvEnd()%>
								<%=rsv.getRsvEtime()%></h6>

						</div>
					</li>
			<li
						class="list-group-item d-flex justify-content-between lh-condensed">
						<div>
							<small class="text-muted">렌트 가격</small>
							<h6 class="my-0">날짜(일) * 
								<%=car.getCarPrice()%>(원) = 곱해서 가격알려주기</h6>

						</div>
					</li>
					<li class="list-group-item d-flex justify-content-between"><span>Total</span>
						<strong><%=rsv.getRsvPrice()%> 원</strong></li>
				</ul>
				<a href="/myRsvList?userId=<%=user.getUserId()%>&reqPage=1">내 예약 리스트로 가기</a>
			</div>

			<div class="col-md-8 order-md-1">
				<h4 class="mb-3">결제 정보</h4>

				<div class="row">
					<div class="col-md-6 mb-3">
						<label for="username">ID</label> <input type="text"
							class="form-control" id="userId" value="<%=user.getUserId()%>"
							required disabled>
					</div>
					<div class="col-md-6 mb-3">
						<label for="lastName">이름</label> <input type="text"
							class="form-control" id="userName" placeholder="이름을 입력하세요"
							value="<%=user.getUserName()%>" required>
					</div>

				</div>

				<div class="mb-3">
					<label for="email">Email <span class="text-muted"></span></label> <input
						type="email" class="form-control" id="email"
						value="<%=user.getUserEmail()%>" placeholder="이메일을 입력하세요">
				</div>

				<div class="mb-3">
					<label for="address">주소</label> <input type="text"
						class="form-control" id="address" placeholder="주소를 입력하세요"
						value="<%=user.getUserAddr()%>" required>
				</div>

				<div class="mb-3">
					<label for="address2">상세주소 <span class="text-muted">(선택)</span></label>
					<input type="text" class="form-control" id="address2"
						placeholder="상세주소를 입력하세요">
				</div>

				<div class="mb-3">
					<label for="address2">연락처 <span class="text-muted"></span></label>
					<input type="text" class="form-control" id="phone"
						placeholder="연락처를 입력하세요" value="<%=user.getUserPhone()%>">
				</div>

				<div class="custom-control custom-checkbox">
					<input type="checkbox" class="custom-control-input" id="check-rsvpay" name="check-rsvpay"> <label
						class="custom-control-label" for="check-rsvpay">예약,
						결제정보를 모두 확인했습니다</label> <br>
					<p id="paymentResult"></p>
				</div>
				<hr class="mb-4">
				<div id="pay">
					<button class="btn btn-primary btn-lg btn-block">결제하기</button>
				</div>

			</div>
		</div>

		<footer class="my-5 pt-5 text-muted text-center text-small">
		<p class="mb-1">&copy; 2020 SELCAR</p>
		<ul class="list-inline">
			<li class="list-inline-item"><a href="#">Privacy</a></li>
			<li class="list-inline-item"><a href="#">Terms</a></li>
			<li class="list-inline-item"><a href="#">Support</a></li>
		</ul>
		</footer>
	</div>

	<script>
		$(function() {
		
			
			$("#pay button").click(function(){
				
				if($("input:checkbox[name=check-rsvpay]").is(":checked")){
					
				
						var price =<%=rsv.getRsvPrice()%>;
						var email =$("#email").val();
						var buyerName =$("#userName").val();
						var tel =$("#phone").val();
						var addr =$("#address").val()+$("#address2").val();
						var d = new Date();
						var date = d.getFullYear() + '' + (d.getMonth() + 1)
								+ '' + d.getDate() + '' + d.getHours() + ''
								+ d.getMinutes() + '' + d.getSeconds();
						IMP.init("imp97285928");

						IMP.request_pay({//결제를 위해 전달해주는 정보
							merchant_uid : 'selcar_' + date,//상점거래ID
							name : buyerName+"_"+"<%=car.getCarNopan()%>", //결제이름
							amount : price, //결제금액
							buyer_email : email,
							buyer_name : buyerName,
							buyer_tel : tel,
							buyer_addr : addr,
							buyer_postcode : "000-000" //우편번호

						}, function(rsp) {//위의 값을 가지고 결제모듈을 진행
							if (rsp.success) { //결제가 성공한 경우
								$("#paymentResult").addClass("text-success");
								$("#paymentResult").html("결제 성공!");
							location.href="/changeRsvStatus?status=22&rsvNo=<%=rsv.getRsvNo()%>";
							} else { //결제 실패한 경우
								$("#paymentResult").addClass("text-danger");
								$("#paymentResult").html("결제 실패 사유 : "+ rsp.error_msg);
							}
						})

					
				}else{
					alert("체크박스에 체크해주세요!");
				}
	
			});
					
				
		});
	</script>

</body>
</html>