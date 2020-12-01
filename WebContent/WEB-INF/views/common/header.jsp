<%@page import="member.model.vo.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
       User u = (User)session.getAttribute("user");
    %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
    <script type="text/javascript" src="http://code.jquery.com/jquery-3.3.1.js"></script>
        <link href="https://fonts.googleapis.com/css2?family=Do+Hyeon&family=Gugi&family=Nanum+Pen+Script&display=swap"rel="stylesheet"><link href="https://fonts.googleapis.com/css2?family=Archivo:ital,wght@1,600&display=swap"rel="stylesheet">
        <link rel="preconnect" href="https://fonts.gstatic.com">
        <link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@300&family=Poor+Story&family=Sunflower:wght@300&display=swap" rel="stylesheet">
    <style>
        .header{
           background : #35477d;
           width : 100%;
           height : 10%;
        }
        .header>div{
           float : left;
        }
        .logo{
            text-align: center;
            width: 20%;
        }
        .loginbox{
            text-align: center;
            width: 20%;
        }
        .loginmenu>li{
            line-height: 50px;
            display: inline-block;
            list-style: none;
        }
        .loginmenu>li>a{
           font-weight : bold;
            color : rgba(255,255,255,0.85);
            text-decoration: none;
        }
        a{
           text-decoration : none;
           color : black;
        }
        li{
           list-style : none;
        }
        #navi{
            height: 100%;
            width: 60%;
        }
        #navi ul{
           margin : 0 auto;
        }
        #navi .main>li{
           float : left;
           width : 33.3%;
           height : 100%;
           line-height : 80px;
           text-align : center;
           background : #35477d;
           position : relative;
        }
        #navi .main>li:hover .sub{
           display : block;
        }
        #navi .main>li>a{
           font-weight : bold;
           font-size : 17px;
        }
        #navi .main>li a{
           color : rgba(255,255,255,0.85);
           display : block;
        }
        #navi .main .sub{
           position : absolute;
           top : 80px;
           width : 100%;
           background : #35477d;
           display : none;
        }
        .sub{
           magin : 0;
           padding : 0;
        }
        .on{
            display: block;
        }
    </style>
</head>
<body>
        <div class="header">
            <div class="logo"><img src="/imgs/main.png" onclick="location.href='/'" style="cursor: pointer;"></div>
            <div id="navi">
                <ul class="main">
                    <li><a href="#">서비스 소개</a>  
                       <ul class="sub">
                          <li><a href="#">서비스 소개</li>
                          <li><a href="/views/car/carView.jsp">차량 예약/등록</a></li>
                           <li><a href="#">고객센터</a></li>
                       </ul>
                    </li>
                    <li><a href="#">차량 예약/등록</a>
                       <ul class="sub">
                          <li><a href="#">차량등록</a></li>
                           <li><a href="#">차량 예약</a></li>
                       </ul>
                    </li>
                    <li><a href="#">고객센터</a>
                       <ul class="sub">
                          <li><a href="#">공지사항</a></li>
                           <li><a href="#">1:1 문의</a></li>
                           <li><a href="#">자주하는 질문</a></li>
                       </ul>
                    </li>
                </ul>
            </div>
            <div class="loginbox">
                <ul class="loginmenu">
                   <%if(u ==null) {%>
                    <li><a href="/views/user/login.jsp">로그인</a></li>
                    <li><a href="/views/user/join.jsp">회원가입</a></li>
                    <%}else{ %>
                    <li><a href="/mypage?userId=<%=u.getUserId()%>"><%=u.getUserId() %></a></li>
                    <li><a href="/logout">로그아웃</a></li>
                    <%} %>
                </ul>
            </div>
        </div>
    <script>
    $(".menu li").mouseover(function(){
        var subnavi = $(".sub-header");
        var navi = $(".header");
        var menuli = $(".menu li a");
        var loginmenuli = $(".loginmenu li a");
        menuli.css('color','black');
        loginmenuli.css('color','black');
        navi.css('background-color','white');
        subnavi.css("background-color","white");
        subnavi.removeClass("on");
        subnavi.addClass("on");
    });
    $(".sub-header").mouseleave(function(){
        var subnavi = $(".sub-header");
        var navi = $(".header");
        navi.css('background-color',"white");
        subnavi.css('background-color','white');
        subnavi.removeClass("on"); 
    })
    $(".logo").click(function(){
       location.href("/");
    })
    </script>
</body>
</html>