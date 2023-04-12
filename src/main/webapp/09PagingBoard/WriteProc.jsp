<%@page import="utils.AlertFunc"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="board.BoardDAO"%>
<%@ page import="board.BoardDTO"%>
<%
	String title = request.getParameter("title");
	String content = request.getParameter("content");
	
	BoardDTO dto = new BoardDTO();
	dto.setTitle(title);
	dto.setContent(content);
	dto.setId(session.getAttribute("UserId").toString());
	
	BoardDAO dao= new BoardDAO(application);
	int res=dao.insertWrite(dto);
	dao.close();
	
	if(res==1){
		response.sendRedirect("List.jsp");
	}else{
		AlertFunc.alertBack("제대로해라", out);
	}
%>