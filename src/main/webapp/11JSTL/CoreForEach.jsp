<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSTL Core forEach</title>
</head>
<body>

	<h4>일반 for문</h4>
	<c:forEach var="i" begin="1" end="3" step="1">
		<p>반복 ${i}<br></p>		
	</c:forEach>
	
	<h4>반복문 속성</h4>
	<table border="1">
		<c:forEach begin="3" end="7" var="i" varStatus="loop">
			<tr>
				<td>count:${loop.count}</td>	<!-- 반복 순서 -->
				<td>index:${loop.index }</td>	<!-- ? -->
				<td>current:${loop.current }</td>	<!-- 현재 값 -->
				<td>first:${loop.first}</td>	<!-- 처음인지 여부 -->
				<td>last:${loop.last }</td>		<!-- 마지막인지 여부 -->
				<td>i:${i }</td>
			</tr>
		</c:forEach>
	</table>
	
	<h4>enhahnced for문</h4>
	<%
		String[] rainbow={"빨","주","노","초","파","남","보"};
	%>
	<c:forEach items="<%=rainbow%>" var="list">
		<span>${list}</span>
	</c:forEach>
	<%
		String[] rainbow2={"red","orange","yellow","green","blue","navy","purple"};
	%>	
	
	<h4>반복문 속성</h4>
	<table border="1">
		<c:forEach items="<%=rainbow2%>" var="color" varStatus="loop">
			<tr>
				<td>count:${loop.count}</td>	<!-- 반복 순서 -->
				<td>index:${loop.index }</td>	<!-- 인덱스 -->
				<td>current:${loop.current }</td>	<!-- 인덱스의 실제 요소 값 -->
				<td>first:${loop.first}</td>	<!-- 처음인지 여부 -->
				<td>last:${loop.last }</td>		<!-- 마지막인지 여부 -->
				<td style="color:${color}">color:${color}</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>