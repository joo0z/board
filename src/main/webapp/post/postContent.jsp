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
	$('#profileDownBtn').on('click', function(){
		document.location="/profileDownload?userid=${memberVo.userid}";
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
				<form class="form-horizontal" role="form" action="${cp }/memberUpdate" method="get">
					<div class="form-group">
						<label for="userid" class="col-sm-2 control-label">제목</label>
						<div class="col-sm-10">
							<label class="control-label"><input type="hidden" value="${postVo.post_title }" name="userid">${postVo.post_title }</label>
						</div>
					</div>

					<div class="form-group">
						<label for="userNm" class="col-sm-2 control-label">글내용</label>
						<div class="col-sm-10">
							<input type="hidden" value="${postVo.post_content }" name="usernm">${postVo.post_content }</label>
						</div>
					</div>
					<div class="form-group">
						<label for="userNm" class="col-sm-2 control-label">첨부파일</label>
						<div class="col-sm-10">
							<label class="control-label"><input type="hidden" value="" name=""></label>
						</div>
					</div>
					<div class="form-group">
						<div class="col-sm-offset-2 col-sm-10">
							<button type="submit" class="btn btn-default">수정</button>
							<button type="submit" class="btn btn-default">삭제</button>
							<button type="submit" class="btn btn-default">답글</button>
						</div>
					</div>
					<br><br>
					<%@include file="/include/reply.jsp" %>
				</form>
			</div>
		</div>
	</div>
</body>
</html>
