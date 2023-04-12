<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="utils.AlertFunc"%>
<%@page import="board.BoardDTO"%>
<%@page import="board.BoardDAO"%>
<%
	String num=request.getParameter("num");

	BoardDAO dao = new BoardDAO(application);
	int res=dao.deletePost(num);
	dao.close();
	
	if(res==1){
		AlertFunc.alertLocation("삭제 완료", "List.jsp", out);
	}else{
		AlertFunc.alertBack("삭제 실패", out);
	}
%>