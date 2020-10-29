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

<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
 <script src="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
 <link href="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote.min.css" rel="stylesheet">
 <script src="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote.min.js"></script>
 
 <style>
 	.note-editable{
 		height: 350px;
 	}
 </style>
 <script>
    $(document).ready(function() {
        $('#summernote').summernote();
    });
  </script>
</head>

<body>
<%@ include file="/layout/header.jsp" %>
<div class="row">
<div class="col-sm-3 col-md-2 sidebar">
	<%@ include file="/layout/left.jsp" %>
</div>
<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
	<div class="row">
		<div class="col-sm-8 blog-main"> <br>
			<h2 class="sub-header">새글등록</h2>
			
			<div class="table-responsive">
				<form action="${cp }/createPost" method="post" enctype="multipart/form-data">
					<select name="board_no">
						<c:forEach var="board" items="${boardList }">
							<c:if test="${board.board_status == 'Y' }">
								<option data-board_no="${board.board_no }" value="${board.board_no }">${board.board_title }</option>
							</c:if>
						</c:forEach>
					</select>
					<br><br>
					<input type="text" name="post_title" 
							autofocus placeholder="제목을 입력해주세요." maxlength="30" minlength="1">
				 	<textarea id="summernote" name="post_content" placeholder="내용=>"></textarea>
				 	<input type="hidden" name="post_status" value="Y">
				 	<input type="hidden" name="user_id" value="${S_MEMBER.user_id }">
				 	<div class="form-group">
						<div class="col-sm-10">
							<input type="file" name="realfilename1">
							<input type="file" name="realfilename2">
							<input type="file" name="realfilename3">
							<input type="file" name="realfilename4">
							<input type="file" name="realfilename5">
						</div>
					</div>
					<button id="crtBtn" type="submit" class="btn btn-default">등록</button>
				</form>
			</div>
	
		</div>
	</div>
</div>
</div>
</body>
</html>
