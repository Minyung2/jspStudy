<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>exception 내장객체</title>
</head>
<body>
	<%
	int status = response.getStatus();
	if (status == 404) { // not found
		out.println("404에러 발생");
		out.println("<br>파일경로를 확인하세요.");
	} else if (status == 405) { // method not allowed
		out.println("405에러 발생");
		out.println("<br>요청 방식(method)을 확인하세요.");
	} else if (status == 500) { // Internal server error
		out.println("500 에러 발생");
		out.println("<br>소스 코드의 에러를 확인하세요.");
	}
	%>
</body>
</html>