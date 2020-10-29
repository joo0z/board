<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
<%@include file="/layout/commonlib.jsp"%>
<script>
$(document).ready(function(){
	})
});
</script>
</head>
<body>
<%@include file="/layout/header.jsp" %>
	<div class="container-fluid">
		<div class="row">
			<div class="col-sm-3 col-md-2 sidebar">
				<%@include file="/layout/left.jsp" %>
			</div>
			<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
				<form class="form-horizontal" role="form" action="${cp }/postUpdate" method="">
					<div class="form-group">
					<hr>
						<label class="col-sm-2 control-label">제목</label>
						<div class="col-sm-10">
							<label class="control-label"><input type="hidden" value="${postVo.post_title }" name="post_title">${postVo.post_title }</label>
						</div>
					</div>
					<hr>

					<div class="form-group">
						<label for="userNm" class="col-sm-2 control-label">글내용</label>
						<div class="col-sm-10">
							<input type="hidden" value="${postVo.post_content }" name="post_content">${postVo.post_content }</label>
						</div>
					</div>
					<hr>
					<div class="form-group">
						<label for="userNm" class="col-sm-2 control-label">첨부파일</label>
						<div class="col-sm-10">
							<c:forEach var="files" items="${fileList }">
							<label class="control-label"><a href="${files.file_name }">${files.file_realnm }</a></label>
							</c:forEach>
						</div>
					</div>
					<hr>
					<div class="form-group">
						<div class="col-sm-offset-2 col-sm-10">
							<c:if test="${S_MEMBER.user_id == postVo.user_id }">
								<button type="submit" class="btn btn-default">수정</button>
								<button type="submit" class="btn btn-default">삭제</button>
							</c:if>
							<button type="submit" class="btn btn-default">답글</button>
						</div>
					</div>
					<hr>
					<br><br>
					<%@include file="/include/reply.jsp" %>
				</form>
			</div>
		</div>
	</div>
</body>
</html>