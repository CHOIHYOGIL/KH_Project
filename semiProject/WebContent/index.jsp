<%@page import="member.model.vo.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>selcar에 오신걸 환영합니다!</title>
<script type="text/javascript"
	src="http://code.jquery.com/jquery-3.3.1.js"></script>
<script src="/js/video.js"></script>
<script src="/js/bigvideo.js"></script>
<script src="/js/imagesloaded.pkgd.min.js"></script>
<script src="/js/modernizr-custom.js"></script>
<style>
.wrapper {
	height: 100vh;
}

body {
	margin: 0;
	padding: 0;
}

video {
	position: fixed;
	top: 0;
	left: 0;
	min-width: 100%;
	min-height: 100%;
	width: auto;
	height: 100%;
	z-index: -1;
}
</style>

<script type="text/javascript"
	src="http://code.jquery.com/jquery-3.3.1.js"></script>
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

</head>
<body>
	<div class="wrapper">
		<%@include file="/WEB-INF/views/common/header.jsp"%>

		<video autoplay loop muted poster="/imgs/logo.png" preload="metadata">
		<source src="/video/main2.mp4" type="video/mp4"></video>
	</div>

</body>
</html>