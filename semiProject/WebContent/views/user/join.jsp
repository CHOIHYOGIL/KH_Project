<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>회원가입</title>
</head>
<style>
	.wrapper{
		height : 100vh;
	}
	body{
		margin : 0px;
		padding : 0px;
	}
	.content{
		margin : 0 auto;
		width : 80%;
	}
    .title{
        border-bottom: 1px solid black;
        text-align: left;
        width: 100%;
        font-size: 30px;
        font-weight: bold;
    }
    .join{
        height: 100%;
        width: 80%;
        margin: 0 auto;
        background-color: #e7e7e7;
    }
    .jointable{
        font-size: 18px;
        width: 60%;
        margin: 0 auto;
    }
    #userid,#userpw,#userpwre,#username,#userphone,#useraddr,#useraddrchk,#userlicense,#useremail,#agreement,#addrsearch{
        height: 30px;
        width: 300px;
    }
    #addrsearch{
        background-color: #686d76;
    }
    #agreement{
        height: 80px;
    }
    #idchk,#addrchk{
        height: 35px;
        width: 100px;
    }
    .button{
        text-align: center;
    }
    .button button{
        color: white;
        background-color: #2E64FE;
        font-size: 15px;
        border-radius: 10px;
        width: 200px;
        height: 30px;
    }
    .test{
    	margin : 0 auto;
    	border : 1px solid black;
    	width : 80%;
    	height : 75%;
    }
</style>
<body>
<div class="wrapper">
<%@include file="/WEB-INF/views/common/header.jsp" %>
<div class="content">
            <div class="title">회원가입 selcar에 오신걸 환영합니다 !<br><br></div>
            <div class="join">
                <div class="join-1">
                   <br><br>
                    <form action="/join" method="post" class="jointable">
                        <table>
                            <tr>
                                <td><label for="userid">아이디 *&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</label></td>
                                <td><input type="text" id="userid" name="userId" placeholder="영/숫자 6자 이상" required></td>
                                <!--  <td><button type="button" id="idchk" onclick="checkId();">중복확인</button></td>-->
                                <td style="width:150px;"><span id="idChkMsg"></span></td>
                            </tr>
                            <tr>
                                <td><label for="userpw">비밀번호 *&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</label></td>
                                <td><input type="password" id="userpw" name="userPw" placeholder="영/숫자  8자 이상" required></td>
                            </tr>
                            <tr>
                                <td><label for="userpwre">비밀번호확인 *&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</label></td>
                                <td><input type="password" id="userpwre" name="userPwre" required></td>
                            </tr>
                            <tr>
                                <td><label for="username">이름 *&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</label></td>
                                <td><input type="text" id="username" name="userName" required></td>
                            </tr>
                            <tr>
                                <td><label for="userphone">전화번호 *&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</label></td>
                                <td><input type="text" id="userphone" name="userPhone" placeholder="예시)000-0000-0000" required></td>
                            </tr> 
                            <tr>
                                <td><label for="useraddr">주소 *&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</label></td>
                                <td><input type="text" id="addrsearch" name="addrsearch" readonly></td>
                                <td><button type="button" id="addrchk">주소검색</button></td>
                            </tr>
                            <tr>
                                <td><label for="useraddr"></label></td>
                                <td><input type="text" id="useraddrchk" name="userAddr" placeholder="상세 주소 입력"></td>
                            </tr>
                            <tr>
                                <td><label for="userlicense">면허번호 *&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</label></td>
                                <td><input type="text" id="userlicense" name="userLicense" placeholder="예시)00-00-000000-00" required></td>
                            </tr>
                            <tr>
                                <td><label for="useremail">이메일 *&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</label></td>
                                <td><input type="text" id="useremail" name="userEmail"></td>
                            </tr>
                            <tr>
                                <td><label for="agreement">이용약관 및 개인정보처리*&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</label></td>
                                <td><textarea id="agreement">개인정보 보유 및 이용기간
회사는 회원으로서 제공되는 서비스를 받는 동안 회원님의 개인정보를 보유 및 이용할 수 있으며, 회원탈퇴를 요청하거나 위에서 설명한 개인정보를 수집한 목적이 완료된 경우에는 수집된 개인정보가 열람 또는 이용될 수 없도록 처리됩니다.단, 관계법령의 규정에 의해 보존할 필요가 있는 경우 관계법령에서 정한 일정한 기간 동안 최소한의 회원정보를 보유합니다.
 • 계약 또는 청약철회 등에 관한 기록 : 5년
 • 대금결제 및 재화 등의 공급에 관한 기록 : 5년
• 회원의 불만 또는 분쟁처리에 관한 기록 : 3년
• 기타 회원의 동의를 득한 경우 : 동의를 득한 기간까지
단, 온라인 홈페이지의 경우, 관련법령에 따라 유효기간(최종 로그인 후 12개월) 내 재로그인 하지 않은 회원의 개인정보는 유효기간 경과 후 즉시 파기하거나, 분리하여 보관합니다.
개인정보 주체에게는 30일 전에 해당 사실을 통지하고, 명시한 기한 내에 로그인 하지 않을 경우에는 회원자격을 상실시킬 수 있습니다.
이 경우, 회원 아이디를 포함한 회원의 개인정보 및 서비스 이용 정보는 파기, 삭제됩니다.
                                    </textarea></td>
                                    <td><input type="checkbox" name="check">동의<br></td>
                            </tr>
                        </table>
                        <br><br>
                        <div class="button">
                            <button type="submit">회원가입</button>
                            <button type="reset">취소</button>
                        </div><br><br><br>
                    </form>
                </div>
            </div>
        </div><br>
<%@include file="/WEB-INF/views/common/footer.jsp" %>
</div>
<script>
	$("#userid").focusout(function(){
	    var userid = ("#userid").val;
	    var regExp = /^\w{6,12}/g;
	    if(!regExp.test($("#userid").val())){
	        alert("아이디 형식이 올바르지 않습니다.");
	    }
	});
	$("#userpw").focusout(function(){
	    var regExp = /^\w{8,12}/g;
	    if(!regExp.test($("#userpw").val())){
	        alert("비밀번호 형식이 올바르지 않습니다.");
	    }
	});
	$("#userpwre").focusout(function(){
	    if($("#userpw").val() != $("#userpwre").val()){
	        alert("두 비밀번호가 일치하지 않습니다.");
	    }
	})
	$("#userphone").focusout(function(){
	    var regExp = /^[0-9]{3}-[0-9]{4}-[0-9]{4}$/;
	    if(!regExp.test($("#userphone").val())){
	        alert("전화번호 형식이 일치하지 않습니다.");
	    }
	});
	$("#userlicense").focusout(function(){
	    var regExp = /^\d{2}-\d{2}-\d{6}-\d{2}$/;
	    if(!regExp.test($("#userlicense").val())){
	        alert("면허번호 형식이 맞지 않습니다.");
	    }
	});
	$("#useremail").focusout(function(){
	    var regExp = /^[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*\.[a-zA-Z]{2,3}$/i;
	    if(!regExp.test($("#useremail").val())){
	        alert("이메일 형식이 맞지 않습니다.");
	    }
	});
	$(function(){
		if($("input[type=checkbox]:checked").length>0){
			$("button[type=submit]").attr('disabled',false);
		}else{
			$("button[type=submit]").attr('disabled',true);
		}
	})
	$("button[type=reset]").click(function(){
		$(location).attr('href','/');
	})
	$("#userid").keyup(function(){
		var userId = $(this).val();
		$.ajax({
			url : "/ajaxCheckId",
			type : "get",
			data : {userId : userId},
			success : function(data){
				var msg = $("#idChkMsg");
				if(data == 1) {
					msg.html('사용가능한 아이디 입니다.');
					msg.css('color','green');
					msg.css('font-size','10px');
				}else{
					msg.html('이미 사용중인 아이디 입니다.');
					msg.css('color','red');
					msg.css('font-size','10px');
				}
			}
		});
	});
	
</script>
</body>
</html>