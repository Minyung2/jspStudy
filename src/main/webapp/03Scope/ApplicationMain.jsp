<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="common.Person" %>
<%@ page import="java.util.HashMap"%>
<%@ page import="java.util.Map"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Application 영역</title>
</head>
<body>
	<h2>Application area</h2>
	<%
		Map<String, Person> maps = new HashMap<>();
		maps.put("student1", new Person("손흥민",30));
		maps.put("student2", new Person("고길동",40));
		application.setAttribute("maps", maps);
	%>
	
	<a href="ApplicationMove.jsp"><p>application 속성 저장</p></a>
</body>
</html>