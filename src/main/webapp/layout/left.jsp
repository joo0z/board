<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<ul class="nav nav-sidebar">
	<li class="active"><a href="${pageContext.request.contextPath }/createBoard">게시판관리</a></li>
<%-- 	<li class="active"><a href="${pageContext.request.contextPath }/">자유게시판</a></li> --%>
<%-- 	<li class="active"><a href="${pageContext.request.contextPath }/">Q&A</a></li> --%>
	<c:forEach var="board" items="${boardList }">
		<c:if test="${board.board_status == 'Y' }">
			<li class="active">
				<a href="${pageContext.request.contextPath }/postList?board_no=${board.board_no }">${board.board_title }</a>
			</li>
		</c:if>
	</c:forEach>
	<%
		pageContext.getRequest();
	%>
	
</ul>