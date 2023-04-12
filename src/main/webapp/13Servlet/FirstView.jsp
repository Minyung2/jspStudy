<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Controller를 통한 Mapping 처리</title>
</head>
<body>
	<h2>Controller-View</h2>
	${result}
	<p>URI:${uri}</p>
	<p>요청명:${comStr}</p>
	<ul>
		<li><a href="../Servlet/regist.set">가입</a></li>
		<li><a href="../Servlet/login.set">로그인</a></li>
		<li><a href="../Servlet/board.set">게시판</a></li>
		
	</ul>
</body>
</html>