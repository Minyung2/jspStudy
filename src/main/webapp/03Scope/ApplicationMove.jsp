<%@page import="java.util.Set"%>
<%@page import="java.util.Optional"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.security.KeyStore.Entry"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="common.Person" %>
<%@ page import="java.util.HashMap"%>
<%@ page import="java.util.Map"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Application 영역 속성 값</title>
</head>
<body>
	<h2>application 속성</h2>
<%
	

	Map<String,Person> maps = (Map<String,Person>)application.getAttribute("maps");
	for(Map.Entry<String,Person> e :maps.entrySet()){
		String key = e.getKey();
		out.println("이름:"+e.getValue().getName()+" 나이:"+e.getValue().getAge()+"<br>");
	}
%>
</body>
</html>