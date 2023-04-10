<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:set var="reqVar" value="park" scope="request"/>
	<c:redirect url="./include/OtherPage.jsp">
		<c:param name="param1" value="red"/>
		<c:param name="param2" value="Orange" />
	</c:redirect>
	
</body>
</html>