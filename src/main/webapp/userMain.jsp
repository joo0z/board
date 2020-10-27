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
<script type="text/javascript">
$(document).ready(function(){
	$("#boardList tr").on('click', function(){
		// 실행 확인
		console.log("noticeList tr click");
		// data-userid
		var user_id = $(this).data("user_id");
		console.log("userid : " +  user_id);

// 		document.location="/member?userid=" + userid;
		// form테그 이용할 때
// 		$("#frm").sumbit();
	});
});

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
		<h2 class="sub-header">Main</h2>
		<div class="table-responsive">
			<table class="table table-striped">
					<tr>
						<th>글번호</th>
						<th>글제목</th>
						<th>작성자</th>
						<th>작성일자</th>
					</tr>
				<tbody id="boardList">
<%-- 		            <c:forEach items="${memberList}" var="member"> --%>
<%-- 		               <tr data-userid="${member.userid}"> --%>
<%-- 			               <td>${member.userid }</td> --%>
<%-- 			               <td>${member.usernm }</td> --%>
<%-- 			               <td>${member.alias }</td> --%>
<!-- 			               format : yyyy-MM-dd -->
<!-- 			               <td> -->
<%-- 			               	<fmt:formatDate value="${member.reg_dt }" pattern="yyyy-MM-dd"/> --%>
<!-- 			               </td> -->
<!-- 		               </tr> -->
<%-- 		            </c:forEach> --%>
				</tbody>
			</table>
		</div>

		<a href="${cp }/regist" class="btn btn-default pull-right">공지글 등록</a>
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
<%-- 							<li ><a href="${pageContext.request.contextPath }/memberList?page=${i}">${i }</a></li> --%>
						</c:otherwise>
					</c:choose>
				</c:forEach>
			</ul>
		</div>
	</div>
</div>
	</div>
		</div>
	</div>
</body>
</html>
