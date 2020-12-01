<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="java.util.ArrayList"%>
        <%@page import="rsv.model.vo.Report"%>
    <%
	ArrayList<Report> list=(ArrayList<Report>)request.getAttribute("list");
String pageNavi=(String)request.getAttribute("pageNavi");
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	  <script type="text/javascript" src="http://code.jquery.com/jquery-3.3.1.js"></script>
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
  <script src="https://t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<title>Insert title here</title>
</head>

<style>
	.first>th{
		text-align:center;
	}
</style>
<body>
	<%@ include file="/WEB-INF/views/common/header.jsp" %>
	<table class="table table-hover" style="width:90%; margin:0 auto; text-align:center;">
		
			<tr class="first">
				<th>선택</th><th>신고번호</th> <th>신고 한 유저아이디</th> <th>신고 당한 유저아이디</th> <th>신고 사유</th> <th>신고 당한 날짜</th><th>결정</th>	
				
			</tr>
			
			<%for( Report report : list){ %>
			<!-- admin만 들어올수 있고, m.getMemberNo()는 현재 접속해 있는 아이디의 세션이므로
			admin의 넘버만 아니면 뜨도록, 즉 admin뺴고 나머지 멤버들이 뜨도록!! -->
			
		
			
			<tr >
				<td><input type="checkbox" class="chk"></td>
				<td><%=report.getReport_No() %></td>
				<td><%=report.getReport_EE()%></td>
				<td><%=report.getReport_ER() %></td>
				<td><%=report.getReport_Comment()%></td>
				<td><%=report.getReport_Date() %></td>
	
				<td>
					<button class="btn btn-outline-info btn-sm" onclick="location.href='/reportDecision?userId=<%=report.getReport_EE()%>&num=<%=report.getReport_No()%>'">신고수락</button>
									<button class="btn btn-outline-info btn-sm" onclick="location.href='/reportDecision?userId=<%=false%>&num=<%=report.getReport_No()%>'">신고철회</button>
				</td>
			</tr>

			<% }%>
	
				
			<tr >
				<%if(list.size()!=0){ %>
				<th colspan="12">
					<button class="btn btn-info btn-lg changeAllBtn">신고수락</button>
			
					<button class="btn btn-info btn-lg negativeAllBtn">신고철회</button>
				</th>
				<%} %>
			</tr>
			<tr >
			<td colspan="12">
			  <div  id ="pageNavi" ><%=pageNavi %></div>
			</td>
				 
			</tr>
		</table>
</body>

<script>
		$(".changeBtn").click(function(){
			var memberLevel=$(this).parent().prev().children().val();
		
			//tr의 첫번쨰 자식으로 no찾아냄
			var memberNo=$(this).parent().parent().children().first().next().html();
			console.log("memberLevel : "+memberLevel);
			console.log("memberNo : "+memberNo);
			location.href="/changeLevel?memberNo="+memberNo+"&memberLevel="+memberLevel;
			
			
		})
		
		$(".negativeAllBtn").click(function(){
			console.log("hi");
			var inputs=$("[type=checkbox]:checked");
			var num=new Array();
			var level= new Array();
			var v='false';
			inputs.each(function(idx,item){
				num.push($(item).parent().next().html());
				level.push($(item).parent().next().next().html());
			})
			
			location.href="/reportAllDecision?num="+num.join("/")+"&userId="+v;
		})
		$(".changeAllBtn").click(function(){
			console.log("hi");
			var inputs=$("[type=checkbox]:checked");
			var num=new Array();
			var level= new Array();
			
			inputs.each(function(idx,item){
				num.push($(item).parent().next().html());
				level.push($(item).parent().next().next().html());
			})
			
			location.href="/reportAllDecision?num="+num.join("/")+"&userId="+level.join("/");
			
			
		})
	</script>
</html>