<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>표현언어 EL 내장 객체</title>
</head>
<body>
	<h2>내장객체 속성 값 출력</h2>
	<ul>
		<li>${pageScope.scopeVal }</li>
		<li>${requestScope.scopeVal }</li>
		<li>${sessionScope.scopeVal }</li>
		<li>${applicationScope.scopeVal }</li>
		<h2>스코프 지정 없이 출력</h2>
		<li>${scopeVal }</li>

	</ul>
</body>
</html>