<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>scope</h3>
<%
	Map<String, String> map = new HashMap<>();
	map.put("name", "홍길동");
	map.put("age", "33");
	map.put("address", "seoul");
//	session.setAttribute("user", map);	// ${user}울 쓰려면 스코프 4개(page, request,session, application)중에 한개를 설정해야되고 키값이 같아야됨
%>
${user.name}
${user.age}
</body>
</html>