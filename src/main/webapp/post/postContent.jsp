<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
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
	$(document).ready(function() {
		$('#profileDownBtn').on('click', function(){
// 			document.location="/fileDownload?file_no=${files.file_no}";
		})
	});
</script>
</head>
<body>
	<%@include file="/layout/header.jsp"%>
	<div class="container-fluid">
		<div class="row">
			<div class="col-sm-3 col-md-2 sidebar">
				<%@include file="/layout/left.jsp"%>
			</div>
			<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
				<form class="form-horizontal" role="form" action="${cp }/postUpdate"
					method="">
					<div class="form-group">
						<hr>
						<label class="col-sm-2 control-label">제목</label>
						<div class="col-sm-10">
							<label class="control-label"><input type="hidden"
								value="${postVo.post_title }" name="post_title">${postVo.post_title }</label>
						</div>
					</div>
					<hr>

					<div class="form-group">
						<label for="userNm" class="col-sm-2 control-label">글내용</label>
						<div class="col-sm-10">
							<input type="hidden" value="${postVo.post_content }"
								name="post_content">${postVo.post_content }</label>
						</div>
					</div>
					<hr>
					<div class="form-group">
						<label for="userNm" class="col-sm-2 control-label">첨부파일</label>
						<div class="col-sm-10">
							<c:forEach var="files" items="${fileList }">
								<label class="control-label">
									<a href="/fileDownload?file_no=${files.file_no}" id="profileDownBtn" >${files.file_realnm }</a>
								</label>
									<br>
							</c:forEach>
						</div>
					</div>
				</form>
					<hr>
					<%@include file="/include/reply.jsp"%>
				<hr>
					<div class="col-sm-offset-2 col-sm-10">
						<c:if test="${S_MEMBER.user_id == postVo.user_id }">
							<button type="submit" id="update" class="btn btn-default">수정</button>
						</c:if>
					</div>
				<div class="form-group">
					<div class="col-sm-offset-2 col-sm-10">
						<form action="${cp }/postDelete" method="post">
							<input type="hidden" value="${postVo.post_no }" name="post_no">
							<input type="hidden" value="${postVo.board_no }" name="board_no">
							<c:if test="${S_MEMBER.user_id == postVo.user_id }">
								<button type="submit" id="delete" class="btn btn-default">삭제</button>
							</c:if>
						</form>
					</div>
				</div>
				<div class="form-group">
					<div class="col-sm-offset-2 col-sm-10">
						<form action="${cp }/reply" method="post">
							<input type="hidden" value="${postVo.post_no }" name="post_no">
							<input type="hidden" value="${postVo.board_no }" name="board_no">
							<button type="submit" class="btn btn-default">답글쓰기</button>
						</form>
					</div>
				</div>
				
			</div>
		</div>
	</div>
</body>
</html>
