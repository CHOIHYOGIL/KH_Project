<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<style>
.footer{
		height : 200px;
	background-color:black;
      
    }
    .footer>div{
        float: left;
    }
    .footer-box{
    background-color:black;
        width: 100%;
        height: 40%;
    }
    .footer-content{
     
        font-size: 20px;
    }
    .footer-content>li{
        text-align: center;
        margin: 0;
        padding: 0;
        width: 19%;
        display: inline-block;
        list-style: none;
    }
    .footer-content>li>a{
        color: white;
        text-decoration: none;
    }
    .footer-box2,.footer-box3{
    	margin-left : 200px;

        color: #686d76;
        width: 30%;
        line-height: 10px;
    }
</style>
<body>
		<div class="footer">
            <div class="footer-box">
                <ul class="footer-content">
                    <li><a href="#">회사소개</a></li>
                    <li><a href="#">이용약관</a></li>
                    <li><a href="#">개인정보처리방침</a></li>
                    <li><a href="#">제휴문의</a></li>
                    <li><a href="#">공지사항</a></li>
                </ul>
            </div>
            <div class="footer-box2">
                <p>주소 : 서울 영등포구 선유동2로 57 이레빌딩 19층</p>
                <p>전화 : 02-1544-9970</p>
                <p>© 2020 SELCAR All rights reserved.</p>
            </div>
            <div class="footer-box3">
                <p>(주)셀카 통신판매업 사업자정보 확인</p>
                <p>신고: 제 2019-제주오라-3호, 정보보호최고책임자: 홍길동</p>
                <p>사업자등록번호: 123-45-6789</p>
            </div>
        </div>
</body>
</html>