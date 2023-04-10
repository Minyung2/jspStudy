<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- 변수 선언 -->
<c:set var="scopeVar" value="Page Value"/>
<c:set var="scopeVar" value="Request Value" scope="request"/>
<c:set var="scopeVar" value="Session value" scope="session"/>
<c:set var="scopeVar" value="Application Value" scope="application"/>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSTL Core Remove</title>
</head>
<body>
	<ul>
		<li>scopeVar : ${scopeVar}</li> <!-- 디폴트 : pageScope -->
		<li>requestScope scopeVar : ${requestScope.scopeVar}</li>
		<li>sessionScope scopeVar : ${sessionScope.scopeVar }</li>
		<li>applicationScope scopeVar : ${applicationScope.scopeVar }</li>
	</ul>
	<c:remove var="scopeVar" scope="session"/>
	<ul>
		<li>scopeVar : ${scopeVar}</li>
		<li>requestScope scopeVar : ${requestScope.scopeVar}</li>
		<li>sessionScope scopeVar : ${sessionScope.scopeVar }</li>
		<li>applicationScope scopeVar : ${applicationScope.scopeVar }</li>
	</ul>
	<c:remove var="scopeVar"/> <!-- scope 없을시 전체 삭제 (모든 scope)-->
	<ul>
		<li>scopeVar : ${scopeVar}</li> 
		<li>requestScope scopeVar : ${requestScope.scopeVar}</li>
		<li>sessionScope scopeVar : ${sessionScope.scopeVar }</li>
		<li>applicationScope scopeVar : ${applicationScope.scopeVar }</li>
	</ul>
</body>
</html>