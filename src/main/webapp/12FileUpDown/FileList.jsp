<%@page import="fileUpDown.MyFileDto"%>
<%@page import="java.util.List"%>
<%@page import="fileUpDown.MyFileDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>	
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>FileList</title>
</head>
<body>
	<h2>파일 목록 보기</h2>
	<a href="FileUploadMain.jsp">파일 등록</a>
	<%
	MyFileDao dao = new MyFileDao();
	List<MyFileDto> fileList = dao.myFileList();
	dao.close();
	%>
	<table style="width:90%; text-align:center;" border="1">
		<tr>
			<th>번호</th>
			<th>작성자</th>
			<th>제목</th>
			<th>카테고리</th>
			<th>원본 파일명</th>
			<th>저장된 파일명</th>
			<th>등록일</th>
			<th>다운로드</th>
		</tr>
		<c:forEach var="fileList" items="<%=fileList%>">
			<tr>
				<td>${fileList.idx}</td>
				<td>${fileList.name}</td>
				<td>${fileList.title}</td>
				<td>${fileList.cate}</td>
				<td>${fileList.ofile}</td>
				<td>${fileList.nfile}</td>
				<td>${fileList.regdate}</td>
				<td><a href="Download.jsp?oName=${fileList.ofile}&nName=${fileList.nfile}">[다운로드]</a></td>
			</tr>
		</c:forEach>
	</table>
	
</body>
</html>