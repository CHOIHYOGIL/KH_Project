<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%
    //member가 아니라 변수명을 m으로 하면 에러가뜬다. why? header에서 m이라는 변수를 사용하고 있으므로!!
     	Member member=(Member)request.getAttribute("member");
    %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>

<body>
	<%@ include file="/WEB-INF/views/common/header.jsp" %>
	<section>
		<form action="/updateMember" method="post" style="width : 800px; margin:0 auto; color:black;">
		
			<h1>마이페이지</h1>
			<table class="table">
				<tr>
					<th>회원번호</th>
					<td><input type="text" name="memberNo" class="form-control" value="<%=member.getMemberNo() %>" readonly></td>
				</tr>
				<tr>
					<th>아이디</th>
					<td><input type="text" name="memberId" class="form-control" value="<%=member.getMemberId() %>" readonly></td>
				</tr>
				<tr>
					<th>비밀번호</th>
					<td><input type="text" name="memberPw" class="form-control" value="<%=member.getMemberPw() %>" ></td>
				</tr>
				<tr>
					<th>이름</th>
					<td><input type="text" name="memberName" class="form-control" value="<%=member.getMemberName() %>" readonly></td>
				</tr>
				<tr>
					<th>전화번호</th>
					<td><input type="text" name="phone" class="form-control" value="<%=member.getPhone()%>" ></td>
				</tr>
				<tr>
					<th>주소</th>
					<td><input type="text" name="address" class="form-control" value="<%=member.getAddress() %>" ></td>
				</tr>
				<tr>
					<th>이메일</th>
					<td><input type="text" name="email" class="form-control" value="<%=member.getEmail() %>"></td>
				</tr>
				<tr>
					<th>운전면허</th>
					<td><input type="text" name="license" class="form-control" value="<%=member.getLicense() %>"></td>
				</tr>
				<tr>
					<th>신고 횟수</th>
					<td><input type="text" name="report" class="form-control" value="<%=member.getReport() %>"></td>
				</tr>
				<tr>
				<th>회원등급</th>
					<td>
					 <%if(member.getMemberLevel()==0){%>
						<span>관리자</span> 
					<%  }else if(member.getMemberLevel()==1){%>
						<span>정회원</span>
					<% } %>	
					</td>
				</tr>
				<tr>
					<th>가입일</th>
					<td><input type="text" name="enroll" class="form-control" value="<%=member.getEnrollDate() %>" readonly></td>
				</tr>
				
				<tr>
					<th colspan="2" style="text-align:center">
				<button class="btn btn-outline-danger btn-lg" type="submit">수정하기</button>
					<%if(member.getMemberLevel()==0){%>
							<button class="btn btn-outline-danger btn-lg" type="button" onclick="location.href='/adminPage'">회원관리</button>
					<% }else{%>
						<button class="btn btn-outline-danger btn-lg" type="button" onclick="location.href='/deleteMember?memberId=<%= member.getMemberId()%>'">회원탈퇴</button>	
					<% } %>
					</th>
				</tr>
			</table>
		</form>
	</section>
	
</body>
</html>