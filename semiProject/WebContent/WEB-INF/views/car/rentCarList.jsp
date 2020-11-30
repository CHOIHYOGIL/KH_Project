<%@page import="java.util.ArrayList"%>
<%@page import="car.model.vo.Car"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%
   	ArrayList<Car> list = (ArrayList<Car>)request.getAttribute("list");
   %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script src="https://use.fontawesome.com/releases/v5.2.0/js/all.js"></script>
<title>Insert title here</title>
<style>
	input{
		border:1px solid #bbb;
		border-radius: 2px;
		outline: none;
		border:none;
		height:28px;
	}
	select{
		border:none;
	}
	section{
		margin-top:80px;
		margin-bottom:120px;
		width:100%;
	}
	section>div{
		width:80%;
		margin:0 auto;
	}
	#option-box{
		height:40vh;
		background-color:rgb(238,238,238);
		display: flex;
        align-items: center;
	}
	#option-box table{
		width:100%;
		margin:10px auto;
		border: none;
	}
	#option-box table tr{
		margin:0;
		
	}
	#option-box table td{
		height:100%;
		width:calc(100%/4);
		text-align: center;
	}
	
	#option-box table label{
		display:inline-block;
		margin-left : 10px;
	}
	select{
		border:1px solid #bbb;
		height: 28px;
		border-radius: 2px;
	}
	#rent-car-list table{
		width:100%;
	}
	#rent-car-list table *{
		
	}
	#rent-car-list table tr:hover{
		background-color:#eee;
		
	}
	#sort-box{
		box-sizing:border-box;
		padding-top:20px;
	}
	#sort-box>select{
		float:right;
	}
	.carlist{
		overflow:hidden;
		margin-bottom:10px;
		line-height:40px;
		text-align: center;
	}
	.carlist li{
		display: block;
		width:calc(100%/3);
		float :left;
		padding:10px;
	}
	.carlist li>div{
		border:1px solid #eee;
	}
	.search{
		background-color:#008891;
		color: white;
		width:100px;
		height:100px;
		border:none;
		borde-radius:3px;
	}
	.car-img-wrap{
		width:100%;
		height:30vh;
		overflow:hidden;
		display:flex;
		justify-content:center;
        align-items:center;
	}
	.car-img-wrap img{
		object-fit: cover;
		width:250px;
		height:250px;
	}
	@media(max-width:800px){
	section>div{
		width:100%;
	}
	}
	@media(max-width:600px){
	section{
		width:600px;
	}
	
	}
</style>
</head>
<body>
	<%@include file="/WEB-INF/views/common/header.jsp" %>
	 <section>
	 	<div style="margin-top : 20px;">
	        <h2>차량 검색</h2>
	        <hr>
        </div>
        <!-- -------------------------검색 조건 박스------------------------ -->
        <p></p>
        <div id="option-box">
                <table>
                    <tr>
                        <td colspan="3">
                        <div>지역</div>
                       
                            <select style="width : 50px;">
                            	<option>지역선택</option>
                                <option value="서울">서울</option>
                                <option value="강원">강원</option>
                                <option value="경기">경기</option>
                                <option value="대전">대전</option>
                                <option value="대구">대구</option>
                                <option value="울산">울산</option>
                                <option value="부산">부산</option>
                            </select>
                            
                            <input type="text" name="addr" style="width : 100px;" required>
                        </td>
                        <td colspan="3">
                        	<div>기간<i class="far fa-calendar-minus"></i></div>
                            <input type="date" name="rsvStartDate" id="rsvStartDate" value=""><br>
                            <input type="date" name="rsvEndDate" id="rsvEndDate">
                        </td>
                         <th>차종</th>
                        <td colspan="3">
                            <label><input type="checkbox" name="car-type" value="소형">소형</label>
                            <label><input type="checkbox" name="car-type" value="중형">중형</label>
                            <label><input type="checkbox" name="car-type" value="대형">대형</label>
                        </td>
                        <td>
                            <input type="text" name="carName">
                        </td>
                </table>
        </div>
        <br>
        <br>
        <div id="sort-box" style="height:70px;">
            <h3 style="display:inline-block;">검색 결과</h3>

            <select>
                <option value="priceAsce">가격순(오름차순)</option>
                <option value="priceDesc">가격순(내림차순)</option>
                <option value="priceAsce">평점순</option>
            </select>

        </div>
        <div id="rent-car-list">
            <ul class="carlist">
                <%for(Car c : list){ %>
                <a href="/rentCarView?carNo=<%=c.getCarNo() %>">
                <li class="carList-li">
                    <div>
		            	<div class="car-img-wrap">
		                    <img src="/img/car/<%=c.getCarImage()%>" style="width:100%;">
		                </div>
	                    
	                    <div>
	                    	<span><h4 style="display:inline-block;"><%=c.getCarName() %></h4></span>
	                    	<span>
		                    	<i class="fas fa-star" style="color:orange;"></i> 
		                    	<%=c.getCarRate() %> / 5
	                    	</span>
	                    </div>
	                    <div><%=c.getCarType() %></div>
	                    <div><%=String.format("%,d", Integer.parseInt(c.getCarPrice())) %></div>
	                    <div><%=c.getCarSdate() %> ~ <%=c.getCarEdate() %></div>
	                    <div><%=c.getCarLocation() %></div>
                	</div>
                </li>
                </a>
                <%} %>
            </ul>
        </div>
        <div id="carListPage">
        	<div>
        		<ul>
        			<span></span>
        		</ul>
        	</div>
        </div>
    </section>
    <%@include file="/WEB-INF/views/common/footer.jsp" %>
    <script>
    	//$(".carlist img").click(function(){
    		//var user = <%=u%>
    		//if(user==null){
    		//	alert("로그인 후 이용해 주세요");
    		//	return false;
    		//}
    	//});
    	
    	$(function(){
    		var today = new Date();
    		$("#rsvStartDate").val(today.getFullYear()+"-"+(today.getMonth()+1)+"-"+today.getDate())
    		$("#rsvStartDate").attr("min",today);
    	});
    	$("[type=checkbox]").change();
    	
    	$("#rsvStartDate").click(function(){
    		$(this).attr("type","date");
    	})
    </script>
</body>
</html>