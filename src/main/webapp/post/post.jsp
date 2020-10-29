<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
<meta name="description" content="">
<meta name="author" content="">
<link rel="icon" href="../../favicon.ico">

<title>Jsp</title>
<%@ include file="/layout/commonlib.jsp" %>
<script>

</script>

</head>

<body>
<%@ include file="/layout/header.jsp" %>
<div class="row">
<div class="col-sm-3 col-md-2 sidebar">
	<%@ include file="/layout/left.jsp" %>
</div><div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
		<div class="row">
			<div class="col-sm-8 blog-main"> <br>
				<h2 class="sub-header">${board_title } </h2>
				<div class="table-responsive">
					<table class="table table-striped">
							<tr>
								<th>게시글 번호</th>
								<th>제목</th>
								<th>작성자 아이디</th>
								<th>작성 일시</th>
							</tr>
						<tbody id="postList">
				            <c:forEach items="${postList }" var="post">
				               <tr data-userid="${post.post_no}">
					               <td>${post.post_no }</td>
						            <c:choose>
						            	<c:when test="${post.post_status == 'Y' }">
								               <td><a href="/postContent?post_no=${post.post_no }">${post.post_title }</a></td>
							             </c:when>
							             <c:otherwise><td>[삭제된 게시물입니다.]</td></c:otherwise>
						             </c:choose>
					               <td>${post.user_id }</td>
					               <td>
					               	<fmt:formatDate value="${post.post_regdate }" pattern="yyyy-MM-dd"/>
					               </td>
				               </tr>
				            </c:forEach>
						</tbody>
					</table>
				</div>
		
				<a href="${cp }/createPost" class="btn btn-default pull-right">새글 등록</a>
				pages : ${pages}
				page : ${page }
				<div class="text-center">
					<ul class="pagination">
						<c:forEach var="i" begin="1" end="${pages }">
							<c:choose>
								<c:when test="${i == page}">
									<li class="active"><span>${i }</span></li>
								</c:when>
								<c:otherwise>
									<li ><a href="${pageContext.request.contextPath }/postList?page=${i}&board_no=${board_no}">${i }</a></li>
								</c:otherwise>
							</c:choose>
						</c:forEach>
					</ul>
				</div>
			</div>
		</div>
	</div>
</div>
</body>
</html>
