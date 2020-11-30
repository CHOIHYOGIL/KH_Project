<%@page import="car.model.vo.Review"%>
<%@page import="java.util.ArrayList"%>
<%@page import="car.model.vo.Car"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    	Car c = (Car)request.getAttribute("car");
    	ArrayList<Review> rList = (ArrayList<Review>)request.getAttribute("rlist");
    %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="/js/jquery-3.3.1.js"></script>
<link rel="stylesheet" href="/css/bootstrap.css">
<link rel="stylesheet" href="/css/header/style.css">
<link rel="stylesheet" href="/css/header/responsive.css">
<script type="text/javascript" src="/js/bootstrap.js"></script>
<script src="https://use.fontawesome.com/releases/v5.2.0/js/all.js"></script>
<script type="text/javascript" src="https://openapi.map.naver.com/openapi/v3/maps.js?ncpClientId=hdnph5ozc8&submodules=geocoder"></script>

<style>
	section{
		width:100%;
	}
	section>div{
		width:80%;
		margin: 0 auto;
		overflow:auto;
		margin-bottom:20px;
	}
	section>div>div{
		width:80%;
		margin:0 auto;
		float:left;
	}
	#review-wrapper{
		width:100%;
	}
	.img-wrapper{
		overflow:hidden;
		display:inline-block;
		width:100%;
		height:auto;
	}
	.img-wrapper>div{
		width:100%;
	}
	.img-wrapper>img{
		transition-duration: 0.3s;
		width:700px;
	}
	.img-wrapper>img:hover{
		transform:scale(1.1);
		
	}
	.div-left{
		width:70%;
		display:inline-block;
	}
	.div-left>div{
		margin-bottom:20px;
		width:100%;
	}
	.div-right{
		width:30%;
		height:1277px;
		position:relative;
	}
	.info-wrapper{
		width:100%;
	}
	.info-wrapper>table{
		border:1px solid #eee;
		width:100%;
	}
	.info-wrapper>table td{
		height:50px;
		padding-left:10px;
	}
	.info-wrapper>table th{
	padding-left:10px;
	}
	.info-wrapper>table img{
		width:100%;
	}
	#map-wrapper{
		width :100%;
	}
	.iw_inner{
		padding:10px;
		color : #333;
	}
	.review-ul{
		box-sizing: border-box;
		overflow: hidden;
		box-sizing: border-box;
		}
	.review-ul>li{
		width:50%;
		float:left;
		box-sizing: border-box;
		padding:5px;
		margin:0 auto;
	}
	.review-li>div{
		width:99%;
		padding:10px;
		height:120px;
		border:1px solid #eee;
		margin:0 auto;
		box-sizing: border-box;
	}
	.rotate{
		transform: rotate(180deg);
	}
	.reserve-box{
		background-color:#008891;
		width:25vw;
		right:5vw;
		bottom:10vh;
		position:fixed;
		z-index:1;
		overflow: hidden;
	}
	.reserve-box>div{
		width:100%;
		text-align: center;
		color:white;
		font-size:20px;
		height:50px;
		line-height: 50px;
		border-color:#0f3057;
	}
	.reserve-box>form{
		width:100%;
		margin:0 auto;
		padding:20px;
	}
	.reserve-box form input{
		margin:auto;
		margin-bottom:10px;
		width:100%;
		outline: none;
		font-size:15px;
		font-weight: bold;
		border : none;
		border-radius: 2px;
	}
	.reserve-box form span{
		display: flex;
        align-items: center;
        font-size : 15px;
        color:white;
        width:100%;
	}
	.reserve-box>form [type=submit]{
		color:white;
		font-size : 15px;
		border:2px solid white;
		border-radius:5px;
		background-color:#0f3057;
	}
	
	.img-list{
		margin:10px auto;
		overflow:hidden;
		height:70px;
	}
	.img-list>div{
		display:inline-block;
		width:100px;
		height:60px;
		overflow: hidden;
	}
	.img-list img{
		width:130%;
	}
	.index{
		margin-top:10px;
		width:70%;
	}
	@media(min-width:1201px){
		.reserve-box>form{
			display:block;
		}
	}
	@media(max-width:1200px){
		.reserve-box{
			width:250px;
		}
	}
	@media(max-width:1000px){
	.reserve-box{
		right:0;
		width:100%;
		bottom:0;
		z-index:1000;
	}
	.reserve-box>div{
		bottom:0;
	}
	.div-right{
		width:0;
	}
	.div-left{
		width:100%;
		margin:0 auto;
	}
	.index {
		width:100%;
	}
	}
	
	@media(max-width:600px){
	section{
		width:600px;
	}
	section>div>div{
		width:100%;
	}
	.img-wrapper{
		height:auto;
	}
	.review-ul>li{
		width:100%;
		float:left;
		padding:5px;
		margin:0 auto;
	}
	}
	
</style>
</head>
<body>
<%@include file="/WEB-INF/views/common/header.jsp" %>
	
	<section>
		
		
		<div>
			<div class="index">
				<hr>
				<a href="/rentCarList">목록으로</a>
				<hr>
			</div>
			<div class="div-left">
				<div  class="info-wrapper">
					
						<div><h1><%=c.getCarName() %></h1></div>
						
						<div style="font-size:20px">
						<%for(int i=0;i<(int)c.getCarRate();i++){%>
						<i class="fas fa-star" style="color:orange;"></i>
						<%}%>
						<%if(c.getCarRate()-(int)c.getCarRate()!=0){ %>
							<i class="fas fa-star-half-alt" style="color:orange;"></i>
							<%for(int i=0;i<4-(int)c.getCarRate();i++){%>
							<i class="far fa-star" style="color:orange;"></i>
							<%}%>
						<%}else{ %>
							<%for(int i=0;i<5-(int)c.getCarRate();i++){%>
							<i class="far fa-star" style="color:orange;"></i>
							<%}%>
						<%} %>
						<%if(c.getCarRate()%1!=0){ %>
							<%=c.getCarRate()%>
						<%}else{ %>
							<%=(int)c.getCarRate()%>
						<%} %>
						/ 5
						 </div>
						
						<div style="width:100%;text-align:center;padding:10px;margin-top:30px;">
							<div class="img-wrapper">
								<img src="/img/car/<%=c.getCarImage()%>">
							</div>
							<div class="img-list">
								<div><img src="/img/car/<%=c.getCarImage()%>"></div>
								<div><img src="/img/car/<%=c.getCarImage2()%>"></div>
								<div><img src="/img/car/<%=c.getCarImage3()%>"></div>
								<div><img src="/img/car/<%=c.getCarImage4()%>"></div>
							</div>
						</div>
						<table border="1">
						<tr>
							<th>타입</th>
							<td><%=c.getCarType() %></td>
						</tr>
						<tr>
							<th>가격(시간)</th>
							<td><%=String.format("%,d", Integer.parseInt(c.getCarPrice())) %>원
								<span name="carPrice" style="display:none"><%=c.getCarPrice() %></span>
								</td>
						</tr>
						<tr>
							<th>기간</th>
							<td><%=c.getCarSdate() %> ~ <%=c.getCarEdate() %></td>
						</tr>
						<tr>
							<th>연식</th>
							<td><%=c.getCarYear()%></td>
						</tr>
						<tr>
							<th>위치</th>
							<td><%=c.getCarLocation()%></td>
						</tr>
					</table>
				</div>
			<div id="map-wrapper">	<!---------------------------- 지도 --------------------------------->
				<input type="hidden" value="<%=c.getCarLocation()%>" name="carAddr">
				<div id="map" style="width:100%;height:400px;"></div>
			</div>
			<div id="review-wrapper"> <!---------------------------- 리뷰 --------------------------------->
			<hr>
			<h4 style="margin-left : 20px;">리뷰
			<%if(!rList.isEmpty()){ %>
			<span class="toggle-review"><img src="/img/car/arrow-down.png" width="20" style="transition-duration:0.2s;"></span>
			<%} %>
			</h4>
			<hr>
				<ul class="review-ul">
					<%if(rList.isEmpty()){ %>
						<li style="width:100%;">
							<div style="text-align:center;height:200px;margin:0 auto;">
							<br><br>
								<h4>아직 작성된 리뷰가 없습니다</h4>
							</div>
						</li>
					<%}else{ %>
						<%for(Review r : rList){ %>
						<li class="review-li">
							<div>
								<div style="margin-bottom:10px"><span style="font-size:15px"><%=r.getRevWriter() %>님</span> <span style="font-size:12px; maring-left:10px; float:right;"><%=r.getRevEnrollDate() %></span></div>
								<div style="">
								<%for(int i=0;i<(int)r.getRevRate();i++){%>
								<i class="fas fa-star" style="color:orange;"></i>
								<%}%>
								<%for(int i=0;i<5-(int)r.getRevRate();i++){%>
								<i class="far fa-star" style="color:orange;"></i>
								<%}%>
								<%=r.getRevRate() %> / 5
								</div>
								<div><%=r.getRevContent() %></div>
							</div>
						</li>
						<% }%>
					<%} %>
				</ul>
			</div>
			</div>
			
	<!---------------------------- 예약 --------------------------------->
			<div class="div-right">
				<div class="reserve-box">
					<div>예약정보</div>
					<form>
							<input type="hidden" value="<%=c.getCarNo()%>">
							<%if(u!=null){ %>
	                       	 <input type="hidden" value="<%=u.getUserId() %>">
	                       	 <%} %>
	                        <div>
	                           <span id="inputGroup-sizing-default" >시작일</span>
	                        </div>
	                           <input type="date" class="form-control" id="rsvStartDate" name="rsvStartDate" onclick="datePick()">             
	                           
	                        <div class="input-group-prepend">
	                           <span id="inputGroup-sizing-default" >시작 시간</span>
	                        </div>
	                           <input type="time" class="form-control" name="rsvStartTime" id="rsvStartTime" value="10:00:00"  >
              
	                        <div class="input-group-prepend">
	                           <span  id="inputGroup-sizing-default" >종료일</span>
	                        </div>
	                           <input type="date" class="form-control" name="rsvEndDate" id="rsvEndDate" onclick="datePick()" >
     
	                        <div class="input-group-prepend">
	                           <span id="inputGroup-sizing-default" >종료시간</span>
	                        </div>
	                           <input type="time" class="form-control" name="rsvEndTime" id="rsvEndTime" value="19:00:00"  >

	                           
	                        <div class="input-group-prepend">
	                           <span id="inputGroup-sizing-default" >가격</span>
	                        </div>
	                            <input type="text" class="form-control" name="price" id="price" readonly >
	                  			<input type="hidden" id="price_val"> <!-- 가격 정수형 -->
							<div class="input-group-prepend">
								<%if(u!=null){ %>
	                           <input type="submit" value="예약하기">
	                           <%} %>
	                        </div>
					</form>
				</div>
			</div>
		</div>
	</section>
	
	<%@include file="/WEB-INF/views/common/footer.jsp" %>
	
	
	<script>
	var carLoc =  document.getElementsByName("carAddr");
	console.log(carLoc[0].value);
	window.onload=function(){

		var width = window.innerWidth;
		if(parseInt(width)<=1000){
			$(".reserve-box>form").hide();
		}
		
		naver.maps.Service.geocode({//주소->위경도 변환하는 객체
        	address: carLoc[0].value
	    }, function(status, response) {
		     if (status !== naver.maps.Service.Status.OK) {
		            return alert('오류발생!');
	        }
	
	        var result = response.result, // 검색 결과의 컨테이너
	            items = result.items; // 검색 결과의 배열
	            
			var lat = items[0].point.x; //결과 배열에서 위도 경도 가져와 저장
			var lng = items[0].point.y;
			//var map = new naver.maps.Map("map");
			var map= new naver.maps.Map("map",{
				center : new naver.maps.LatLng(lng,lat),//로드했을때 가운데
				zoom : 17 //확대 
			});
			//마커 추가
			var marker = new naver.maps.Marker({
				position : new naver.maps.LatLng(lng,lat),
				map : map  //화면에 여러 지도가 있을 수 있으니 어느 지도에 표시할지 설정
			});
	        
			var contentString = [//정보창 내용 작성
				'<div class="iw_inner">',
				'	<p>'+carLoc[0].value+'</p>',
				'</div>'
			].join('');
	        //지도 이벤트 추가
			var infoWindow = new naver.maps.InfoWindow();
			naver.maps.Event.addListener(marker,"click",function(e){
				if(infoWindow.getMap()){
					infoWindow.close();
				}else{
					infoWindow = new naver.maps.InfoWindow({
						content: contentString
					});
					infoWindow.open(map,marker);
				}
			});
    	});
		
	};
	
	$(".toggle-review").click(function(){ //리뷰 div 토글
		$(".review-ul").slideToggle('600');
		$(".toggle-review").children().toggleClass('rotate');
	});
	$(".img-list img").click(function(){//클릭한 작은 이미지로 큰 이미지 src변경
		$(".img-list img").parent().css("border","none");
		var src = $(this).attr("src");
		$(this).parent().parent().prev().children().attr("src",src);
		$(this).parent().css({border:'4px solid #0f3057',borderRadius:'2px'});
	})
	$(".reserve-box>div").click(function(){ //모바일 화면시 예약내역창 토글
		var width = window.innerWidth;
		if(parseInt(width)<=1000){
			$(".reserve-box>form").toggle();
		}
	});
	$( window ).resize(function() {	//화면 크기 변화 감지->창 커지면 숨겼던 예약내역 보이게 (기능 미추가 시 작은창에서 숨긴후에 창을 키우면 예약 내역이 보이지 않게 됨)
		var width = window.innerWidth;
		if(parseInt(width)<=1000){
			$(".reserve-box>form").hide();
		}
		if(parseInt(width)>1000){
			$(".reserve-box>form").show();
		}
	});
	 $(function(){
	       
	       $("#rsv").click(function(){
	           console.log("hihi");
	          $(".modal-wrap").css('display','flex'); 
	       });
	     
	       $("input[type=button]").click(function(){
	           $(".modal-wrap").css('display','none');
	       })
	   })
	    
	   function datePick(){
	      
	      var [today] = new Date().toISOString().split("T");
	      document.getElementById("rsvStartDate").setAttribute("min", today);
	      document.getElementById("rsvEndDate").setAttribute("min", today);
	   }
	  
	  
	  
	   $(function(){
		  
	         var Sdate;
	         var Edate;
	         var Stime;
	         var Etime;
	         
	         var today=new Date().toISOString().split('T')[0];
	         var _today=new Date();
	         var time=new Date().toISOString().slice(11,16);
	        
	         $("#rsvStartDate").val(_today.getFullYear()+"-"+(_today.getMonth()+1)+"-"+_today.getDate())
	         
	         _today.setDate(_today.getDate()+3);
	                    $("#rsvEndDate").val(_today.getFullYear()+"-"+(_today.getMonth()+1)+"-"+_today.getDate());
	               
	         $("#rsvStartDate").change(function(){
	           
	       
	            console.log("today : "+today);
	          Sdate=$("#rsvStartDate").val();
	            if(Sdate<today || Edate<Sdate){
	               alert('이전날짜와 종료일보다 더 늦게 예약불가능합니다.');
	               $("#rsvStartDate").val(today);
	            }
	            
	            console.log(Sdate);
	            hour();
	         })
	           $("#rsvEndDate").change(function(){
	            Edate=$("#rsvEndDate").val();
	            if(Edate<Sdate ){
	          
	               alert('시작일보다 이전날짜 선택불가');
	                 _today.setDate(_today.getDate()+3);
	               console.log(_today.getFullYear()+"-"+(_today.getMonth()+1)+"-"+_today.getDate());
	               $("#rsvEndDate").val(_today.getFullYear()+"-"+(_today.getMonth()+1)+"-"+_today.getDate());
	             
	            }
	            console.log("Eitme:"+Etime);
	            
	          
	            console.log(Edate);
	            hourPrice();
	         })
	           $("#rsvStartTime").change(function(){
	           Stime=$("#rsvStartTime").val();
	            console.log("realStime:"+Stime);
	            hour();
	         })
	         
	           $("#rsvEndTime").change(function(){
	            Etime=$("#rsvEndTime").val();
	            
	            if(($("#rsvEndDate").val()<=$("#rsvStartDate").val()) && (Etime<=$("#rsvStartTime").val())){
	               alert('출발일보다 더 이른날짜를 선택불가');
	             
	                $("#rsvEndTime").val('');
	            }
	            console.log("realEdate : "+$("#rsvEndDate").val());
	            console.log("realSdate:"+$("#rsvStartDate").val());
	            console.log("realEtime:"+$("#rsvEndTime").val());
	            console.log("realStime : "+$("#rsvStartTime").val());
	            hour();
	         });
	         hourPrice()
	      });
	function hourPrice(){
		var start = new Date($("#rsvStartDate").val()+" "+$("#rsvStartTime").val());
		var end = new Date($("#rsvEndDate").val()+" "+$("#rsvEndTime").val());
		console.log("end"+end);
		console.log("start"+start);
        var h = Math.floor((end-start)/(1000 * 60 * 60));
        console.log(h);
        var price = h*parseInt($("[name=carPrice]").html());
        console.log(price);
        if(price/1!=price){
        	 $("#price").val(0);
        }else{
        	 $("#price").val(price.toLocaleString());
             $("price_val").val(price);
        }
       
	}
	</script>
</body>
</html>