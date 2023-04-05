<%@page import="membership.MemberDAO"%>
<%@page import="membership.MemberDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
String userId=request.getParameter("user_id");
String userPw=request.getParameter("user_pw");


String driver = application.getInitParameter("OracleDriver");
String oraUrl = application.getInitParameter("OracleUrl");
String oraId = application.getInitParameter("OracleId");
String oraPw = application.getInitParameter("OraclePw");

MemberDAO dao = new MemberDAO(driver, oraUrl, oraId, oraPw);
MemberDTO dto = dao.getMember(userId, userPw);
dao.close();

if (dto.getId() != null) {
	session.setAttribute("UserId", dto.getId());
	session.setAttribute("UserName", dto.getName());
	response.sendRedirect("LoginForm.jsp");
} else {
	request.setAttribute("loginErrMsg", "로그인 오류입니다.");
	request.getRequestDispatcher("LoginForm.jsp").forward(request, response);
}
%>

