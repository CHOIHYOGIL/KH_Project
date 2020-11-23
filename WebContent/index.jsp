<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- 요청 ->Controller(Servlet) -> Service ->Dao ->Servlet ->결과처리 -->
	<!-- Controller : 사용자 요청받음, view에서 넘어온 값 변수에 저장 
	작업이 필요한경우 서비스 호출, 서비스 호출결과에 따른 결과처리-->
	<!-- 컨트롤러에 요청을받음 , Connection을 생성해서 DAO 호출 
	Database 여러번 왔다갔다 하려면 Service가 수행,
	Commit, Rollback, Connection 관리,
	Data편집  -->
	<%@ include file="/WEB-INF/views/common/header.jsp" %>
	
</body>
</html>