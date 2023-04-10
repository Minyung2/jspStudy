<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSTL Core Choose/when/otherwise</title>
</head>
<body>
	<c:set var="num" value="99" />

	<h4>choose</h4>
	<c:choose>
		<c:when test="${num mod 2 eq 0 }">
		 	${num}은 짝수입니다 <br>
		</c:when>
		<c:otherwise>
			${num}은 홀수입니다.<br>
		</c:otherwise>
	</c:choose>

	<h4>영어,수학,과학 점수 입력 받아 평균을 구하고 학점 출력</h4>
	<div>
		<form>
			영어 : <input type="number" name="eng" min="0" max="100" value="${param.eng}"/><br> 
			수학 : <input	type="number" name="math" min="0" max="100" value="${param.math}"/><br>
			과학 : <input type="number" name="science" min="0" max="100" value="${param.science}"/><br> 
			 <input type="submit" value="학점은?" />
		</form>
	</div>
	<!-- 90 이상 수, 80 우, 70 미, 60 양, 가 -->
	<!-- 평균 점수 : ?? / 학점 : ?? -->
	<c:if
		test="${not(empty param.eng or empty param.math or empty param.science)}">
		<c:set var="avg" value="${(param.eng+param.math+param.science)/3}" />
		
		
		<c:choose>
			<c:when test="${avg ge 90}">
				<c:set var="grade" value="수" />
			</c:when>
			<c:when test="${avg ge 80}">
				<c:set var="grade" value="우" />
			</c:when>
			<c:when test="${avg ge 70}">
				<c:set var="grade" value="미" />
			</c:when>
			<c:when test="${avg ge 60}">
				<c:set var="grade" value="양" />
			</c:when>
			<c:otherwise>
				<c:set var="grade" value="가" />
			</c:otherwise>
		</c:choose>
		<h4>평균 : ${avg} 학점 : ${grade}</h4>
	</c:if>

</body>
</html>