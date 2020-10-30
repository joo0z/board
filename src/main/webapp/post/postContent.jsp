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
				<form class="form-horizontal" role="form" action="${cp }/postUpdate" method="get">
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
							<input type="hidden" value="${postVo.post_content }" name="post_content">${postVo.post_content }
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
					<hr>
					<div class="col-sm-offset-2 col-sm-10">
						<c:if test="${S_MEMBER.user_id == postVo.user_id }">
								<input type="hidden" value="${postVo.post_no }" name="post_no">
								<input type="hidden" value="${postVo.board_no }" name="board_no">
								<button type="submit" class="btn btn-default">수정</button>
						</c:if>
						
					</div>
				</form>
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
				<hr>
				<br>
				<div class="form-group">
					<div class="col-sm-10">
						<table class="table table-striped">
				            <c:forEach items="${replyList }" var="replys">
								<form action="${cp }/deleteReply?post_no=${postVo.post_no}" method="post">
				               <tr>
						            <c:choose>
						            	<c:when test="${replys.reply_status == 'Y' }">
								               <td>${replys.reply_content }</td>
								               <input type="hidden" value="${replys.reply_no }" name="reply_no">
							             </c:when>
							             <c:otherwise><td>[삭제된 댓글입니다.]</td></c:otherwise>
						             </c:choose>
					               <td>
					               [${replys.user_id }/<fmt:formatDate value="${replys.reply_regdate }" pattern="yyyy-MM-dd"/>]
					               </td>
					               <c:if test="${replys.user_id == postVo.user_id }">
					               <td><button type="submit" >댓글삭제</button></td>
					               </c:if>
				               </tr>
								</form>
				            </c:forEach>
						</table>
					</div>
				</div>
				<hr>
				<br>
				<div class="form-group">
					<div class="col-sm-10">
						<form action="${cp }/createReply" method="post">
						<table>
							<tr>
								<th><label class="col-sm-2 control-label">댓글</label></th>
								<th><textarea name="reply_content" rows="3" cols="80"></textarea></th>
								<th><button type="submit" class="btn btn-default">댓글저장</button></th>
							</tr>
						</table>
						<input type="hidden" value="Y" name="reply_status">
						<input type="hidden" value="${S_MEMBER.user_id}" name="user_id">
						<input type="hidden" value="${postVo.post_no}" name="post_no">
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>
