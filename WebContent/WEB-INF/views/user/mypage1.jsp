<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="member.model.vo.User"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%
    //member가 아니라 변수명을 m으로 하면 에러가뜬다. why? header에서 m이라는 변수를 사용하고 있으므로!!
     	User member=(User)request.getAttribute("member");
    %>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>index에있는 타이틀 사용중</title>
	<!-- --------------------------------------------------
	   				스크립트 추가
	--------------------------------------------------- -->
  <script type="text/javascript" src="http://code.jquery.com/jquery-3.3.1.js"></script>
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
  <script src="https://t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<style>	
	/* --------------------------------------------------
	   				헤더,푸터	
	-------------------------------------------------- */
	.header{
		width:100%;
		height : 100px;
	}
	.fotter{
		width:100%;
		height : 100px;
	}
	/* --------------------------------------------------
	   				마이페이지 화면
	-------------------------------------------------- */
	.middleWrap{
		border:2px solid red;
		width:1660px;
		height:800px;
	}
	.middleContent{
		/* border:1px solid blue; */
		width : 80%;
		height:100%;	
		margin : 0 auto;	
	}
	/* --------------------------------------------------
	   		  마이페이지 화면 상단에 로고 넣고 보여주기 화면	
	-------------------------------------------------- */
	.top{
		width : 100%;
		height : 200px;
		background-color:#46b4b4;
	}
	.topLR{
		width:50%;
		height : 200px;
		float:left;
		box-sizing: border-box;
	}
	.topLR p{
		color : #fff;
		margin-left:130px;
		font-weight:bolder;
		font-size:20px;
	}
	.topImg1{
		width:200px;
		height:100px;
		margin-top:35px;
		margin-left:70px;
	}
	.topImg2{
		width:150px;
		height:150px;
		float:right;
		margin-top:22px;
		margin-right:80px;
	}
	.bottom{
		width:100%;
		height:650px;
	}
	/* --------------------------------------------------
	   		  마이페이지 화면 탭
	-------------------------------------------------- */
	.menu{
		width:150px;
		border:1px solid #787878;
		margin-top:20px;
		float:left;
	}
	.menu a{
		font-size: 14px;
        height: 30px;
        line-height: 30px;
        display: block;
        text-decoration: none;
        color: #000000;
        padding-left: 20px;
        font-weight : bold;
	}
	.menu ul {
        position: relative;
        list-style: none;
        padding: 0;
        margin:0;
    }
    .choice{
    	background-color:#dcdcdc; 
    	border-bottom: 1px solid #787878;
    }
    
    .main-menu>li>a:hover {
        color:#46b4b4;
    }	
    .sub-menu>li>a:hover {
        color:#46b4b4;
    }	
    .more {
        font-size: 20px;
        position: absolute;
        right: 20px;
        transition-duration: 0.5s;
    }
	.active {
        transform: rotate(180deg);
    }	
    /* --------------------------------------------------
	   		  마이페이지 탭으로 인한 메뉴	
	-------------------------------------------------- */
	/* .content div{
		border:1px solid black;
	} */
    .content{
    	/* border:1px solid black; */
    	width : 80%;
    	height : 92%;
    	float:right;
    }	
    .contentTop{
    	width:100%;
    	height:50px;
    	border-bottom:1px solid black;
    }	
    .contentTRL{
    	width:50%;
    	height:100%;	
    	box-sizing: border-box;
    	float:left;
    	vertical-align:bottom;
    }
    .contentBottom{
    	/* border:1px solid black; */
    	width:100%;
    	height : 550px;
    	display:none;
    }
    .show{
    	display:block;
    }
    .homeTbl{
      	border-top: 2px solid #bcbcbc;
      	float:left;
      	margin-top:20px;
    }
    table th{
      	width: 150px;
      	text-align: left;
     	 height: 50px;
      	border-bottom: 1px solid #bcbcbc;
    }
    table td{
      	width: 300px;
     	text-align: left;
      	height: 50px;
    	border-bottom: 1px solid #bcbcbc;
    }
    .carloc{
    	list-style:none;
    	padding: 0;
    	
    }
    #carDate11{
    	display:inline-block;
    }
    #carDate1{
    	display : none;
    }
    #carDate22{
    	display:inline-block;
    }
    #carDate2{
    	display : none;
    }
    .carView{
    	width:55%;
    	height:100%;
    	float:right;
    	box-sizing: border-box;
    }
    .carViewIn{
    	border:2px dashed #bcbcbc;
    	width:48%;
    	height:48%;
    	float:left;  
    	margin : 5px;	
    }
/*     #carDate2{
    	display:in-block;
    } */
     /* --------------------------------------------------
	   		 반응형 조건주기	
	-------------------------------------------------- */
	@media all and (max-width:800px) {
		/* 일정크기 줄어들면 막아주는 코드 만들기 */
	}
	
</style>
</head>

<body>
<section>
	<div class="header">
		<h3>임시 header</h3>
	</div>
	
	<!-- 미들 -->
	<div class="middleWrap">
		<div class="middleContent">
			<div class="top">
				<div class="topLR">
					<img src="/img/SelCar.png" class="topImg1">	
					<p>회원 안내/임시간판</p>			
				</div>
				<div class="topLR">
					<img src="/img/img01.png" class="topImg2">					
				</div>					
			</div>
			<div class="bottom">
				<div class="menu">
					<ul class="main-menu">
						<li><a href="#" class="choice choiceMenu">Reservation</a></li>
						<li>
							<a href="#" class="choice choiceMenu">My Car</a>
							<ul class="sub-menu">
								<li><a href="#" class="choiceMenu">차량 등록</a></li>
								<li><a href="#" class="choiceMenu">예약 내역 보기</a></li>
							</ul>
						</li>
						<li>
							<a href="#" class="choice choiceMenu" style="border:none;">My Info</a>
							<ul class="sub-menu">
								<li><a href="#" class="choiceMenu">회원 정보 수정</a></li>
							</ul>
						</li>								
					</ul>
				</div>
				<div class="content">
					<div class="contentTop">
						<div class="contentTRL">
							<h4><span id="contentSpan">예약정보</span></h4>
						</div>
						<div class="contentTRL">
							<h6 style="text-align:right;">홈>회원안내><span id="contentSpan2">예약정보</span></h6>
						</div>
					</div>
					<div class="contentBottom">
						<p>Reservation내용 만들기</p> <!-- 만들 내용1(11/25) -->						
					</div>
					<div class="contentBottom">
						<p>My Car내용 만들기</p>      <!-- 만들 내용2(11/26) -->
					</div>
					<div class="contentBottom">		
						<table class="homeTbl">
         					<tr>
            					<th>차량번호</th>
            					<td id="carinfo1">정보없음.</td>
         					</tr>
          					<tr>
            					<th>연식</th>
            					<td id="carinfo2">정보없음.</td>
          					</tr>
          					<tr>
            					<th>크기</th>
            					<td id="carinfo3">정보없음.</td>
          					</tr>
          					<tr>
            					<th>차종</th>
            					<td id="carinfo4">정보없음.</td>
          					</tr>
          					<tr>
            					<th rowspan="4">렌트 옵션</th>
            					<td id="carinfo5">정보없음.</td>
          					</tr>
          					<tr>
            					<td id="carinfo6">정보없음.</td>
          					</tr>
          					<tr>
            					<td id="carinfo7">정보없음.</td>
          					</tr>
          					<tr>
            					<td>혹시모를여유분</td>
          					</tr>
       					</table>
       					<div class="carView">
       						<div class="carViewIn">      							
								<img id="img-view1" width="100%" height="100%">
       						</div>
       						<div class="carViewIn">
       							<img id="img-view2" width="100%" height="100%">
       						</div>
       						<div class="carViewIn">
       							<img id="img-view3" width="100%" height="100%">
       						</div>
       						<div class="carViewIn">
       							<img id="img-view4" width="100%" height="100%">
       						</div>
       					</div>
						<!-- Modal -->	
						<br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>									
						<button type="button" class="btn btn-info btn-lg" data-toggle="modal" data-target="#myModal">차량 등록</button>			
						
  						<div class="modal fade" id="myModal" role="dialog">
   							 <div class="modal-dialog">
   							 
   							 	<form action="/car" method="post" enctype="multipart/form-data">
      							<!-- Modal content--> 
      							<div class="modal-content">
        							<div class="modal-header">
         								<button type="button" class="close" data-dismiss="modal">&times;</button>
          								<h4 class="modal-title">차량 등록하기</h4>
       							 	</div>
        							<div class="modal-body">
        							
          								<table>
          									<tr>
          										<th>차량 번호</th>
          										<td><input type="text" name="carNopan" id="carNopan"></td>
          									</tr>
          									<tr>
          										<th>연식</th>
          										<td><input type="text" name="carYear" id="carYear"></td>
          									</tr>
          									<tr>
          										<th>크기</th>
          										<td><input type="text" name="carType" id="carType"></td>
          									</tr>
          									<tr>
          										<th>차종</th>
          										<td><input type="text" name="carName" id="carName"></td>
          									</tr>
          									<tr>
          										<th rowspan="2">대여 가능 기간</th>
          										<td>
          											<input type="date" name="carSdate" id="carSdate">
          										</td>
          									</tr>
          									<tr>
          										<td>
          											<input type="date" name="carEdate" id="carEdate">
          										</td>
          									</tr>
          									<tr>
          										<th>가격<p></p></th>
          										<td><input type="text" name="carPrice" id="carPrice"></td>
          									</tr>
          									<tr>
          										<th>등록할 위치</th>
          										<td>
          											<ul class="carloc">
													<li>
														<input id="postCode" style="width:200px; display:inline-block" type="text" placeholder="우편번호" class="form-control" readonly>
														<button id="addrSearchBtn" type="button" onclick="addrSearch();" class="btn btn-primary">주소검색</button>
													</li>
													<li>
														<input type="text" id="roadAddr" name="rastyle="width:400px; display:inline-block;" placeholder="도로명주소"class="form-control" readonly>
														<input type="text" name="jibunAddr" id="jibunAddr" style="width:400px; display:inline-block;" placeholder="지번주소"class="form-control" readonly>
 													</li>
 													<li>
 														<input type="text" name="detailAddr" id="detailAddr" style="width:400px; display:inline-block;" placeholder="상세주소"class="form-control">
 													</li>
													</ul>         										
          										</td>
          									</tr>
          									<tr>
          										<th>차량 사진</th>
          										<td>
          											<table>
          												<tr>
          													<th>정면</th>
          													<td><input type="file" name="filename1" onchange="loadImg1(this)"></td>
          												</tr>
          												<tr>
          													<th>측면</th>
          													<td><input type="file" name="filename2" onchange="loadImg2(this)"></td>
          												</tr>
          												<tr>
          													<th>후면</th>
          													<td><input type="file" name="filename3" onchange="loadImg3(this)"></td>
          												</tr>
          												<tr>
          													<th>내부</th>
          													<td><input type="file" name="filename4" onchange="loadImg4(this)"></td>
          												</tr>
          											</table>        											
          										</td>
          									</tr>
          									
          								</table>
        							</div>
        							<div class="modal-footer">
        								 <button type="submit">넘어가기</button>
        								 <!-- <button type="button" class="btn btn-default" data-dismiss="modal" id="carButton">등록하기</button>
         								 <button type="button" class="btn btn-default" data-dismiss="modal">취소</button> -->
        							</div>
     							 </div>
								</form>
    						</div>
  						</div> 						
  						<!-- End Modal -->
  						
 						
					</div>
					<div class="contentBottom">
						<p>예약 내역 보기내용 만들기</p>   <!-- 만들 내용4(11/30) -->
					</div>
					<div class="contentBottom">
						<p>My Info내용 만들기</p>     <!-- 만들 내용5(11/30) -->
					</div>
				
						        <div class="contentBottom">
               <form action="/updateMember" method="post" style="width : 800px; margin:0 auto; color:black;">
		
			
                  	<table class="table">
                  	<tr>
					<th>회원번호</th>
					<td><input type="text" name="memberNo" class="form-control" value="<%=member.getUserNo() %>" readonly></td>
				</tr>
				<tr>
					<th>아이디</th>
					<td><input type="text" name="memberId" class="form-control" value="<%=member.getUserId() %>" readonly></td>
				</tr>
				<tr>
					<th>비밀번호</th>
					<td><input type="text" name="memberPw" class="form-control" value="<%=member.getUserPw() %>" ></td>
				</tr>
				<tr>
					<th>이름</th>
					<td><input type="text" name="memberName" class="form-control" value="<%=member.getUserName()%>" readonly></td>
				</tr>
				<tr>
					<th>전화번호</th>
					<td><input type="text" name="phone" class="form-control" value="<%=member.getUserPhone()%>" ></td>
				</tr>
				<tr>
					<th>주소</th>
					<td><input type="text" name="address" class="form-control" value="<%=member.getUserAddr() %>" ></td>
				</tr>
				<tr>
					<th>이메일</th>
					<td><input type="text" name="email" class="form-control" value="<%=member.getUserEmail() %>"></td>
				</tr>
				<tr>
					<th>운전면허</th>
					<td><input type="text" name="license" class="form-control" value="<%=member.getUserLicense() %>"></td>
				</tr>
				<tr>
					<th>신고 횟수</th>
					<td><input type="text" name="report" class="form-control" value="<%=member.getUserReport() %>"readonly></td>
				</tr>
				<tr>
                  	<th>회원등급</th>
					<td>
					 <%if(member.getUserGrade()==0){%>
						<span>관리자</span> 
					<%  }else if(member.getUserGrade()==1){%>
						<span>정회원</span>
					<% } %>	
					</td>
				</tr>
				<tr>
					<th>가입일</th>
					<td><input type="text" name="enroll" class="form-control" value="<%=member.getUserDate() %>" readonly></td>
				</tr>
				
				<tr>
					<th colspan="2" style="text-align:center">
				<button class="btn btn-outline-danger btn-lg" type="submit">수정하기</button>
				
					</th>
				</tr>
                  	</table>
                  </form>
               </div>
				
					
				</div>
				
								
			</div>		
		</div>	<!-- 미들콘텐츠 -->			
	</div> <!-- 미들전체 -->
	
	<div class="fotter">
		<h3>임시 fotter</h3>
	</div>
</section>
	
	<script>
	 /* --------------------------------------------------
		 					탭	
	 -------------------------------------------------- */
        $(function() {
            $(".main-menu ul").hide();
            $(".sub-menu").prev().append('<span class="more">∨</span>');
            $(".more").click(function(event) {
                $(this).parent().next().slideToggle();
                if ($(this).attr("class") == "more") {
                    $(this).addClass("active");
                } else {
                    $(this).removeClass("active");
                }
                event.stopPropagation();
            });
            $(".more").parent().click(function() {
                $(this).children().last().click();
            });
        });
     /* --------------------------------------------------
						탭메뉴 클릭시 이벤트	
	 -------------------------------------------------- */
	 //시작화면
	 $('.contentBottom').eq(2).css("display","block");
     //
        $('.choiceMenu').click(function() {
        	var idx = $(".choiceMenu").index(this);
        	console.log(idx);
			for(var i=0; i<6; i++ ){
				$('.contentBottom').eq(i).css("display","none");
			} 
			$('.contentBottom').eq(idx).css("display","block");
			if(idx==1){
				$('#contentSpan').html("My Car");
				$('#contentSpan2').html("My Car");
			}else if(idx==4){
				$('#contentSpan').html("My Info");
				$('#contentSpan2').html("My Info");
			}else{
				$('#contentSpan').html($('.choiceMenu').eq(idx).text());
				$('#contentSpan2').html($('.choiceMenu').eq(idx).text());
			}			
		});
        /* --------------------------------------------------
						자동차 등록	
		-------------------------------------------------- */	
        //등록 주소
        function addrSearch() {
			new daum.Postcode({
				oncomplete : function(data) {
					//검색해서 선택한 결과가 data라는 매개변수를 통해서 들어옴
					//다양값이 들어오지만 그중 3개값만 사용
					//우편번호,도로명주소,지번주소
					$("#postCode").val(data.zonecode);//우편번호값
		            $("#roadAddr").val(data.roadAddress);//도로명주소
		            $("#jibunAddr").val(data.jibunAddress);//지번주소
		            $("#detailAddr").focus();
				}
			}).open();
		}
        
      	//차량등록하기 클릭시
      	/* $('#carButton').click(function() { 
      		$('#carinfo1').html($('#carNoPan').val()); //td값
      		$('#carinfo2').html($('#carYear').val()); //td값
      		$('#carinfo3').html($('#carType').val()); //td값
      		$('#carinfo4').html($('#carName').val()); //td값
      		$('#carinfo5').html($('#carSdate').val()+" - "+$('#carEdate').val()); //td값
      		$('#carinfo6').html($('#carPrice').val()+"원"); //td값
      		$('#carinfo7').html($('#roadAddr').val()+" "+$('#detailAddr').val()); //td값
      	}); */
			/* console.log($('#carNoPan').val()); //차량번호
			console.log($('#carYear').val()); //연식
			console.log($('#carType').val()); //차종
			console.log($('#carName').val()); //차이름
			console.log($('#carSdate').val()); //차시작
			console.log($('#carEdate').val()); //차종료
			console.log($('#carPrice').val()); //차가격
			console.log($('#roadAddr').val()); //차위치
			console.log($('#detailAddr').val()); //차세부위치 */				
		
      	
     	 //차사진넣기
      	function loadImg1(f) {
			//배열의 길이가 0인지 확인(첨부파일 갯수가 0인지확인)
			//배열에 담겨있는 파일의 크기가 0인지 확인 -> 파일업로드를 1개만하기 때문에 0인덱스만 검사
			if(f.files.length != 0 && f.files[0]!=0){
				var reader = new FileReader(); //JS파일리더객체-> 파일정보를 확인가능
				//현재 사용자가 선택한 파일의 경로를 읽어옴
				reader.readAsDataURL(f.files[0]);
				//파일의 경로를 읽어오는 작업이 완료되면
				reader.onload=function(e){
					$('#img-view1').attr('src',e.target.result); //파일경로를 src속성에 설정
				}
			}else{
				$('#img-view1').attr("src","");
			}
		}
      	function loadImg2(f) {
			//배열의 길이가 0인지 확인(첨부파일 갯수가 0인지확인)
			//배열에 담겨있는 파일의 크기가 0인지 확인 -> 파일업로드를 1개만하기 때문에 0인덱스만 검사
			if(f.files.length != 0 && f.files[0]!=0){
				var reader = new FileReader(); //JS파일리더객체-> 파일정보를 확인가능
				//현재 사용자가 선택한 파일의 경로를 읽어옴
				reader.readAsDataURL(f.files[0]);
				//파일의 경로를 읽어오는 작업이 완료되면
				reader.onload=function(e){
					$('#img-view2').attr('src',e.target.result); //파일경로를 src속성에 설정
				}
			}else{
				$('#img-view2').attr("src","");
			}
		}
      	function loadImg3(f) {
			//배열의 길이가 0인지 확인(첨부파일 갯수가 0인지확인)
			//배열에 담겨있는 파일의 크기가 0인지 확인 -> 파일업로드를 1개만하기 때문에 0인덱스만 검사
			if(f.files.length != 0 && f.files[0]!=0){
				var reader = new FileReader(); //JS파일리더객체-> 파일정보를 확인가능
				//현재 사용자가 선택한 파일의 경로를 읽어옴
				reader.readAsDataURL(f.files[0]);
				//파일의 경로를 읽어오는 작업이 완료되면
				reader.onload=function(e){
					$('#img-view3').attr('src',e.target.result); //파일경로를 src속성에 설정
				}
			}else{
				$('#img-view3').attr("src","");
			}
		}
      	function loadImg4(f) {
			//배열의 길이가 0인지 확인(첨부파일 갯수가 0인지확인)
			//배열에 담겨있는 파일의 크기가 0인지 확인 -> 파일업로드를 1개만하기 때문에 0인덱스만 검사
			if(f.files.length != 0 && f.files[0]!=0){
				var reader = new FileReader(); //JS파일리더객체-> 파일정보를 확인가능
				//현재 사용자가 선택한 파일의 경로를 읽어옴
				reader.readAsDataURL(f.files[0]);
				//파일의 경로를 읽어오는 작업이 완료되면
				reader.onload=function(e){
					$('#img-view4').attr('src',e.target.result); //파일경로를 src속성에 설정
				}
			}else{
				$('#img-view4').attr("src","");
			}
		}
        
       
        
        
        
    </script>
	
	
	
	
	
</body>
</html>