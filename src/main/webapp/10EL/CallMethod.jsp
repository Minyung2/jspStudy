<%@page import="utils.ELUtils"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="/WEB-INF/TagLib.tld"  prefix="mytag"%>
<% 
	ELUtils util = new ELUtils();
	pageContext.setAttribute("util", util);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>EL 메서드 호출</title>
</head>
<body>
	<h3>영역에 저장한 객체의 메서드 호출하기</h3>
	001125-3000000 => ${util.getGender("001125-3000000")}<br>
	001125-2000000 => ${util.getGender("001125-2000000")}<br>
	001125-123456 => ${util.getGender("001125-123456")}<br>
	<h3>클래스 명을 통한 정적 메서드 호출</h3>
	${ELUtils.showGugudan(7)}
	
	<h3>TLD 파일 등록 후 정적 메서드 호출하기</h3>
	<ul>
		<li>mytag(EL) : isNumber("100") => ${mytag:isNumber("100") }</li>
		<li>mytag(EL) : isNumber("이백") => ${mytag:isNumber("이백") }</li>
	</ul>
</body>
</html>