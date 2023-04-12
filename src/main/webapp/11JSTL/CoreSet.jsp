<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ page import="common.Person" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSTL Core set</title>
</head>
<body>
	<!-- 변수 선언 -->
	<c:set var="aVar" value="200"/>
	<c:set var="elVar" value="${aVar mod 7 }"/>
	<c:set var="expVar" value="<%= new Date() %>"/>
	<c:set var="tagVar">태그 내 설정</c:set>
	
	<h3>변수 출력</h3>
	${pageScope.aVar}<br>
	${elVar }<br>
	${expVar }<br>
	${tagVar }<br>
	
	<h4>자바빈즈 생성자</h4>
	<c:set var="personVar1" value='<%=new Person("손흥민",100)%>' scope="request"/>
	<ul>
		<li>이름 : ${requestScope.personVar1.name}</li>
		<li>골 : ${personVar1.age}</li>
	</ul>
	
			
	<h4>자바빈즈 target, property 사용</h4>
	<c:set var="personVar2" value="<%=new Person() %>" scope="request"/>
	<c:set target="${personVar2}" property="name" value="지수"/>
	<c:set target="${personVar2}" property="age" value="22"/>
	<ul>
		<li>이름 : ${requestScope.personVar2.name}</li>
		<li>나이 : ${personVar2.age}</li>
	</ul>
	
	<h4>List</h4>
	<%
		ArrayList<Person> pList = new ArrayList<>();
		pList.add(new Person("제임스",55));
		pList.add(new Person("William",60));
	%>
	<c:set var="personList" value="<%=pList%>" scope="request"/>
	
	<ul>
		<li>이름 : ${requestScope.personList[0].name}</li>
		<li>나이 : ${personList[0].age}</li>
	</ul>
	
	<h4>forEach</h4>
	<c:forEach var="pList1" items="<%=pList%>">
		<ul>
			<li>이름 : ${pList1.name }
			<li>나이 : ${pList1.age }
		</ul>
	</c:forEach>
	<h4>Map</h4>
	<%
		Map<String,Person> pMap = new HashMap<>();
		pMap.put("personArgs1",new Person("제임스",55));
		pMap.put("personArgs2",new Person("William",60));
	%>
	<c:set var="personMap" value="<%=pMap %>" scope="request"/>
	<ul>
		<li>이름 : ${requestScope.personMap.personArgs2.name}</li>
		<li>나이 : ${personMap.personArgs2.age}</li>
	</ul>
	
	
</body>
</html>