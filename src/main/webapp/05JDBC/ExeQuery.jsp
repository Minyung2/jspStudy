<%@page import="common.JDBConnPool"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@page import="java.sql.Statement" %>
<%@page import="java.sql.Connection" %>
<%@page import="common.JDBConnect" %>
<%@page import="java.sql.ResultSet" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>조회</title>
</head>
<body>
	<h2>회원 목록 조회</h2>
	
	<%
	//JDBConnect jdbc = new JDBConnect();
	JDBConnPool jdbc = new JDBConnPool();
	
	String sql= "select * from member";
	// Statement stmt = jdbc.con.createStatement();
	PreparedStatement stmt = jdbc.con.prepareStatement(sql);
	ResultSet rs = stmt.executeQuery(sql);
	while(rs.next()){
		String id = rs.getString(1);
		String pw = rs.getString(2);
		String name = rs.getString("name");
		Date regDate = rs.getDate("regdate");
		out.println(String.format("%s %s %s %s", id,pw,name,regDate)+"<br>");
	}
	jdbc.close();
	%>
</body>
</html>