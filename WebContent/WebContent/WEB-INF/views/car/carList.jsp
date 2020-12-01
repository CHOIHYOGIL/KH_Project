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
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
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
	<form action="/searchCarKeyword" >
		<table class="table" style="background-color: rgb(238, 238, 238); text-align:center; margin:0 auto;">
			<tr>
				<th>지역</th>
				<td >
				<select style="width: 50px;" id="zone" name="zone" >
						<option value="서울시" selected>서울</option>
						<option value="강원도">강원</option>
						<option value="경기도">경기</option>
						<option value="대전시">대전</option>
						<option value="대구시">대구</option>
						<option value="울산시">울산</option>
						<option value="부산시">부산</option>
				</select> <input type="text" name="addr" id="addr" style="width: 180px;" >
				</td>
				<td ><input type="date" name="date-range1" id="date-range1" value="날짜입력해주세요" onclick="datePick();">
					<span style="margin-left: 5px; margin-right: 5px"> ~ </span> 
					<input type="date" name="date-range2"  id="date-range2" onclick="datePick();"></td>
				<th>차종</th>
				<td><label><input type="checkbox" class="carType"
						name="car-type" value="소형"  onclick="doOpenCheck(this);">소형</label> <label><input
						type="checkbox" name="car-type" class="carType" value="중형" onclick="doOpenCheck(this);">중형</label> <label><input
						type="checkbox" name="car-type" class="carType" value="대형" onclick="doOpenCheck(this);">대형</label></td>
						<th>차 이름</th>
				<td><input type="text" name="carName" id="carName"></td>
				<td><button type="submit" class="btn btn-danger btn-sm">검색</button></td>
		</table>
		</form>
	</div>
	<br>
	<br>
	<div id="sort-box" style="height: 70px;">
		<h3 style="display: inline-block;">검색 결과</h3><br>

		<select name="searchOpt">
			<option value="priceAsce">가격순(오름차순)</option>
			<option value="priceDesc">가격순(내림차순)</option>
			<option value="priceAsce">평점순</option>
		</select>

	</div>
	<div id="rent-car-list">
		<table class="table table-bordered">
			<tr style="background-color: #eee; ">
			
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
				<td>
				<button  class="btn btn-info btn-sm"  onClick="location.href='/carDetailView?carNo=<%=c.getCarNo() %>'">상세보기</button>
				
				
			</tr>
			<%
				}
			%>
		</table>
		<div id="pageNavi" style="text-align:center;" ><%=pageNavi%></div>
	</div>
	</section>

	<%@include file="/WEB-INF/views/common/footer.jsp"%>
	<script>
	var addr;
	var Sdate;
	var Edate;
	var carType;
	var optVal;
	var carName;
	$(document).ready(function(){
		 optVal=$("#zone").val();
			Sdate=$("#date-range1").val();
			Edate=$("#date-range2").val();
			console.log("처음 sdate: "+Sdate);
			console.log("처음 edate: "+Edate);
		 console.log("지역1 :"+optVal);
		$("#zone").on('change',function(){
	
			if(this.value!==""){
				 optVal=$(this).find(":selected").val();
				// start();
				 console.log("지역12 :"+optVal);
				
			}
		
		})
			
		$("#carName").on('change',function(){
			
			if(this.value!==""){
				carName=$(this).val();
				//start();
				console.log("carName :"+carName);
			}
		})	
		$("#addr").on('change',function(){
			if(this.value!==""){
				 addr=$(this).val();
				// start();
				console.log("addr:"+addr);
			}
		})
		
		$("#date-range1").on('change',function(){
	
			if(this.value!==""){
				 Sdate=$(this).val();
				// start();
				console.log("Sdate:"+Sdate);
			}
		})
		$("#date-range2").on('change',function(){
			if(this.value!==""){
				 Edate=$(this).val();
				// start();
				console.log("Edate:"+Edate);
			}
		})
		
	
		$(".carType").on('change',function(){
			console.log("hihihihiihihcheckvox");
			
			$("input[name=car-type]:checked").each(function(index){
				 carType=$(this).val();
				 //start();
				console.log("carType: "+carType);
			})
		})
		
		function start(){
			console.log("123");
			if(carType!= null && Sdate!=null && Edate!=null && addr!=null && carName!=null){
				console.log("start");
				doAjax();
			}
		}
		
	
	
	})
		
	function doAjax(){
		$.ajax({
			
			url:"/searchCarKeyword",
			type:"post",
			data:{optVal:optVal, carType:carType, Sdate:Sdate, Edate:Edate, addr:addr, carName:carName},
			success:function(data){
				console.log("서블릿전송")
			console.log("전송된 list "+data);
				console.log(data);
			}
		})
	}
			
	function doOpenCheck(chk){
    var obj = document.getElementsByName("car-type");
    for(var i=0; i<obj.length; i++){
        if(obj[i] != chk){
            obj[i].checked = false;
        }
    }
}

	function datePick() {

		var today = getTimeStamp() ;
			console.log("hihi")
			console.log("today : "+today);
			document.getElementById("date-range1").setAttribute("min", today);
			document.getElementById("date-range2").setAttribute("min", today);
		}
	function getTimeStamp() {

	    var d = new Date();
	    var s =
	        leadingZeros(d.getFullYear(), 4) + '-' +
	        leadingZeros(d.getMonth() + 1, 2) + '-' +
	        leadingZeros(d.getDate(), 2);

	    return s;
	}
	function leadingZeros(n, digits) {

	    var zero = '';
	    n = n.toString();

	    if (n.length < digits) {
	        for (i = 0; i < digits - n.length; i++)
	            zero += '0';
	    }
	    return zero + n;
	}
	$(function() {
		
		var Sdate;
		var Edate;
		var Stime;
		var Etime;

		var today = new Date().toISOString().split('T')[0];
		var _today = new Date();
		var time = new Date().toISOString().slice(11, 16);
	
		day=_today.getDate();
		month=_today.getMonth()+1;
		console.log("month : "+month);
		console.log("day : "+day);
		if(day<10){
			day='0'+day;
		}
		
		if(month<10){
			month='0'+month;
		}
		$("#date-range1").val(
				_today.getFullYear() + "-" + month + "-"
						+ day)

		_today.setDate(_today.getDate() + 3);
		day2=_today.getDate();
	
		console.log("day2:"+day2);
		if(day2<10){
			console.log("day2입장")
			day2='0'+day2;
			console.log("day2 2:"+day2)
		}
		$("#date-range2").val(
				_today.getFullYear() + "-" + (_today.getMonth() + 1) + "-"
						+day2);

		$("#date-range1").change(function() {

		
			Sdate = $("#date-range1").val();
			if (Sdate < today || Edate < Sdate) {
				alert('이전날짜와 종료일보다 더 늦게 예약불가능합니다.');
				$("#date-range1").val(today);
			}


		
		})
		$("#date-range2").change(
				function() {
					Edate = $("#date-range2").val();
					if (Edate < Sdate) {

						alert('시작일보다 이전날짜 선택불가');
						_today.setDate(_today.getDate() + 10);
				
						$("#date-range2").val(
								_today.getFullYear() + "-"
										+ (_today.getMonth() + 1) + "-"
										+ _today.getDate());

					}
			
			
				})
	});
	
	
	</script>

</body>
</html>