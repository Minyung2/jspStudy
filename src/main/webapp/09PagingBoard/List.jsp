<%@page import="java.util.Optional"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="board.BoardDTO"%>
<%@page import="board.BoardDAO"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
<%-- <%@include file="./LoginCheck.jsp"%> --%>
<%@page import="utils.PagingUtil"%>
<%
BoardDAO dao = new BoardDAO(application);

String findCol = request.getParameter("findCol");
String findWord = request.getParameter("findWord");
Map<String, Object> param = new HashMap<>();
if (findWord != null) {
	param.put("findCol", findCol);
	param.put("findWord", findWord);
}
// 페이징 처리
int totalCount = dao.getTotalCount(param);
int pageSize = Integer.parseInt(application.getInitParameter("PAGE_SIZE"));
int blockSize = Integer.parseInt(application.getInitParameter("PAGING_BLOCK"));
int totalPage = (int) Math.ceil((double) totalCount / pageSize);


// 페이지 초기값 및 현재 페이지 값
int pageNum = 1;
String pageTemp = request.getParameter("pageNum");
if (pageTemp != null && !pageTemp.equals("")) {
	pageNum = Integer.parseInt(request.getParameter("pageNum"));
}
int start = (pageNum - 1) * pageSize + 1;
int end = pageNum * pageSize;
param.put("start", start);
param.put("end", end);

List<BoardDTO> boardList = dao.getList(param);
dao.close();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>목록</title>
</head>
<body>
	<jsp:include page="../common/Top.jsp"></jsp:include>
	<h2>목록 보기</h2>
	<!-- 검색 -->
	<form method="get">
		<table border="1" width="90%">
			<tr>
				<td align="center"><select name="findCol">
						<option value="title">제목</option>
						<option value="content">내용</option>
				</select> <input type="text" name="findWord" /> <input type="submit"
					value="검색" /></td>
			</tr>
		</table>
	</form>
	<!-- 목록 -->
	<table border="1" width="90%">
		<tr>
			<th>번호</th>
			<th>제목</th>
			<th>작성자</th>
			<th>조회수</th>
			<th>작성일</th>
		</tr>
		<%
		if (boardList.isEmpty()) {
		%>
		<tr>
			<td colspan="5" align="center">등록된 게시물이 없습니다.</td>
		</tr>
		<%
		} else {
		for (BoardDTO dto : boardList) {
		%>
		<tr align="center">
			<td align="center"><%=dto.getNum()%></td>
			<td align="left"><a href="View.jsp?num=<%=dto.getNum()%>&pageNum=<%=pageNum%>"><%=dto.getTitle()%></a></td>
			<td><%=dto.getId()%></td>
			<td><%=dto.getVisitcount()%></td>
			<td><%=dto.getPosdate()%></td>
		</tr>

		<%
		}
		}
		%>
	</table>
	<br>
	<div align="center">
		<table border="1" width="90%">
			<tr align="center">
				<td>
				<%= PagingUtil.pagingCenter(totalCount, pageSize, blockSize, pageNum, request.getRequestURI()) %>
				
				</td>
			</tr>
		</table>
		<div align="center">
			<%
			String userId = (String) session.getAttribute("UserId");
			if (userId != null) {
				if (!userId.equals("SIBAL")) {
			%> 
			<button type="button" onclick="location.href='Write.jsp';">글쓰기</button>
			<%
			} else {
			%>
			<span>인법 똥싸기</span>
			<%
			}
			}
			%>
		</div>
	</div>

</body>
</html>