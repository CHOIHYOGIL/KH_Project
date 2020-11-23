<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%
    	ArrayList<Member> list=(ArrayList<Member>)request.getAttribute("list");

	String key=(String)request.getAttribute("key");
	
	if(key==null){
		key="";
	}
	
	String type=(String)request.getAttribute("type");
	if(type==null){
		type="memberId";
	}
    %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

	<style>
		select.form-control, input.form-control{
			display:inline-block;
			width:200px;
			height:30px;
			font-size:0.8em;
		}
	</style>
</head>
<body>
	<%@ include file="/WEB-INF/views/common/header.jsp" %>
	
	<section>
	
		<div  style="margin: 0 auto; width:90%; margin-top:100px;">
			<form action="/searchKeyword">
				<select name="type" class="form-control">
				
				<!-- select에서 선택된 옵션이 select 값으로 들어가므로 select의 이름값을 가져오면 option value값을 가질 수 있다. -->
				<%if(type.equals("memberId")){ %>
					<option value="memberId" selected>아이디</option>
					<option value="memberName">이름</option>
					<%}else if(type.equals("memberName")){ %>
					<option value="memberId">아이디</option>
					<option value="memberName" selected>이름</option>
					<%} %>
				</select>
			
				
				<input type="text" class="form-control" name="keyword" value='<%=key %>'>
				
				
				<button type="submit" class="btn btn-outline-secondary btn-sm">검색</button>
			</form>
		</div>
		
		
		<table class="table table-hover" style="width:90%; margin:0 auto; text-align:center;">
		
			<tr>
				<th>선택</th><th>회원번호</th> <th>아이디</th> <th>이름</th> <th>전화번호</th> <th>주소</th><th>면허증</th><th>이메일</th><th>신고횟수</th> <th>가입일</th><th>등급</th><th>변경</th>	
				
			</tr>
			
			<%for(Member member : list){ %>
			<!-- admin만 들어올수 있고, m.getMemberNo()는 현재 접속해 있는 아이디의 세션이므로
			admin의 넘버만 아니면 뜨도록, 즉 admin뺴고 나머지 멤버들이 뜨도록!! -->
			
			<%if(member.getMemberNo()!=m.getMemberNo()) {%>
			
			<tr>
				<td><input type="checkbox" class="chk"></td>
				<td><%=member.getMemberNo() %></td>
				<td><%=member.getMemberId() %></td>
				<td><%=member.getMemberName() %></td>
				<td><%=member.getPhone() %></td>
				<td><%=member.getAddress() %></td>
				<td><%=member.getLicense() %></td>
				<td><%=member.getEmail() %>
				<td><%=member.getReport() %>
					<td><%=member.getEnrollDate() %></td>
				<td>
					<select>
						<%if(member.getMemberLevel()==0){ %>
							<option value="0" selected>관리자</option>
						<option value="1">정회원</option>
						<option value="2">준회원</option>
						<%}else if(member.getMemberLevel()==1) {%>
							<option value="0">관리자</option>
						<option value="1" selected>정회원</option>
						<option value="2">준회원</option>
						<%}else if(member.getMemberLevel()==2) {%>
							<option value="0">관리자</option>
						<option value="1">정회원</option>
						<option value="2"selected>준회원</option>
						<%} %>
					
					</select>
				</td>
			
				<td>
					<button class="btn btn-outline-info btn-sm changeBtn">변경</button>
				</td>
			</tr>
			<% }%>
			<%} %>
			
			<tr>
				<th colspan="12">
					<button class="btn btn-info btn-lg changeAllBtn">변경하기</button>
				</th>
			</tr>
		</table>
	
	</section>
	
	<script>
		$(".changeBtn").click(function(){
			var memberLevel=$(this).parent().prev().children().val();
		
			//tr의 첫번쨰 자식으로 no찾아냄
			var memberNo=$(this).parent().parent().children().first().next().html();
			console.log("memberLevel : "+memberLevel);
			console.log("memberNo : "+memberNo);
			location.href="/changeLevel?memberNo="+memberNo+"&memberLevel="+memberLevel;
			
			
		})
		
		$(".changeAllBtn").click(function(){
			var inputs=$("[type=checkbox]:checked");
			var num=new Array();
			var level= new Array();
			
			inputs.each(function(idx,item){
				num.push($(item).parent().next().html());
				level.push($(item).parent().parent().find("select").val());
			})
			
			location.href="/changeAllLevel?num="+num.join("/")+"&level="+level.join("/");
			
			
		})
	</script>
</body>
</html>