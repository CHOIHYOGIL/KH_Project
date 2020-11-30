<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author"
	content="Mark Otto, Jacob Thornton, and Bootstrap contributors">
<meta name="generator" content="Jekyll v4.1.1">

<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css"
	integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2"
	crossorigin="anonymous">

<link
	href="https://fonts.googleapis.com/css2?family=Do+Hyeon&family=Gugi&family=Nanum+Pen+Script&display=swap"
	rel="stylesheet">
<link
	href="https://fonts.googleapis.com/css2?family=Archivo:ital,wght@1,600&display=swap"
	rel="stylesheet">
<link rel="preconnect" href="https://fonts.gstatic.com">
<link
	href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@300&family=Poor+Story&family=Sunflower:wght@300&display=swap"
	rel="stylesheet">

<!-- Bootstrap core CSS -->
<link href="../assets/dist/css/bootstrap.min.css" rel="stylesheet">

<title>selcar | 서비스소개</title>

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
</head>

<body>
	<%@include file="/WEB-INF/views/common/header.jsp"%>

	<main role="main">

	<div class="jumbotron">
		<div class="container">
			<h1 class="display-4">selcar 소개</h1>
			<!-- <p>셀카의 회원이 되어보세요</p>
      <p><a class="btn btn-primary btn-lg" href="#" role="button">회원가입 &raquo;</a></p> -->
		</div>
	</div>

	<div class="container marketing">

		<hr class="featurette-divider">

		<div class="row featurette">
			<div class="col-md-7">
				<h2 class="featurette-heading">차가 필요하긴 한데,</h2>
				<h2 class="featurette-heading">
					사기엔 망설여질땐, <span class="text-info">셀카!</span>
				</h2>
				<p class="lead">대충 차가 필요하긴 한데 평일엔 대중교통타고 출근해서 탈 일은 별로 없고 유지비는 많이
					들어서 살까말까 고민하는 사람들에게 고민하지 말고 셀카 서비스 이용하라는 내용</p>
			</div>
			<div class="col-md-5">
				<img width="500" height="500" src="/img/sohyeon/sh_img1.jpg">
			</div>
		</div>

		<hr class="featurette-divider">

		<div class="row featurette">
			<div class="col-md-7 order-md-2">
				<h2 class="featurette-heading">안쓰는 차,</h2>
				<h2 class="featurette-heading">
					주차장에 세워두지말고 <span class="text-info">셀카!</span>
				</h2>
				<p class="lead">차 샀는데 잘 안써서 주차장에만 세워둬서 아까운 사람들에게 차를 빌려주고 용돈 벌으라는
					그런 내용~~~~</p>
			</div>
			<div class="col-md-5 order-md-1">
				<img width="400" height="400" src="/img/sohyeon/sh_img2.jpg">
			</div>
		</div>

		<hr class="featurette-divider">

		<div class="row featurette">
			<div class="col-md-7">
				<h2 class="featurette-heading">멀리 가지 않고,</h2>
				<h2 class="featurette-heading">
					우리 동네에서 <span class="text-info">셀카!</span>
				</h2>

				<p class="lead">다른 렌트카 서비스와 달리 필요할때 바로바로 멀리가지 않고 우리 동네 주민들의 차를
					빌릴수있다~~~~~~</p>
			</div>
			<div class="col-md-5">
				<img width="500" height="500" src="/img/sohyeon/sh_img3.jpg">
			</div>
		</div>

		<hr class="featurette-divider">


	</div>
	</main>
	<%@include file="/WEB-INF/views/common/footer.jsp"%>
</body>

</html>