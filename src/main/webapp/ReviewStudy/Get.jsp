<%@page import="java.util.Optional"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
request.setCharacterEncoding("utf-8");


String name = request.getParameter("name");
String age = request.getParameter("age");
String job = request.getParameter("job");
String[] hobby = request.getParameterValues("hobby");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>결과다</title>
</head>
<body>
	<ul>
		<li>이름:<%=name%></li>
		<li>나이:<%=age%></li>
		<li>직업:<%=job%></li>
		<li>취미: <%
		Optional<String[]> optHobby = Optional.ofNullable(hobby);
		if (optHobby.isPresent()) {
			for (String s : hobby) {
				out.println(String.format("%s", s, "<br>"));
			}
		}
		%>
		</li>
	</ul>
</body>
</html>