<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="utils.AlertFunc"%>
<%@page import="board.BoardDTO"%>
<%@page import="board.BoardDAO"%>
<%	
	String num=request.getParameter("num");
	String title = request.getParameter("title");
	String content = request.getParameter("content");
	
	BoardDTO dto = new BoardDTO();
	dto.setNum(num);
	dto.setTitle(title);
	dto.setContent(content);
	
	BoardDAO dao= new BoardDAO(application);
	int res=dao.updateEdit(dto);
	dao.close();
	
	if(res==1){
		response.sendRedirect("View.jsp?num="+dto.getNum());
	}else{
		AlertFunc.alertBack("수정 제대로해라", out);
	}
%>