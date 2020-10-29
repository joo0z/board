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
	// 게시판 자동선택
    $('#sel option').each(function(){
        if($(this).val()=="${boardVo.board_no}"){
          $(this).prop("selected","selected"); 
        }
     });

    // 파일 삭제
    $('.delBtn').on('click', function(){

    })
	
	var delBtn = document.getElementsByClassName('delBtn');
    if(delBtn.length >= 1){
    	for (var i=0; i< delBtn.length; i++) {
    		delBtn[i].addEventListener('click', function(){
 				console.log('event동작');
				 res = 5-delBtn.length+1;
    			 $(this).parent().remove();
     			 $('.result').append("<input type='file' name='realfilename"+res+"'>");
     			 $('.result').append("<input type='hidden' name='del_nos' value='${files.file_no}'>");
     			 
			})
		}
 	}
	
 	
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
			<h2 class="sub-header">게시글 수정</h2>
			
			<div class="table-responsive">
				<form action="${cp }/postUpdate" method="post" enctype="multipart/form-data">
					<select name="board_no" id="sel">
						<c:forEach var="board" items="${boardList }">
							<c:if test="${board.board_status == 'Y' }">
								<option data-board_no="${board.board_no }" value="${board.board_no }">${board.board_title }</option>
							</c:if>
						</c:forEach>
					</select>
					<br><br>
					<input type="text" name="post_title" autofocus maxlength="30" minlength="1" value="${param.post_title }">
				 	<textarea id="summernote" name="post_content">${param.post_content }</textarea>
				 	<input type="hidden" name="post_no" value="${param.post_no }">
				 	<input type="hidden" name="user_id" value="${S_MEMBER.user_id }">
				 	<div class="form-group">
						<div class="col-sm-10">
							<c:if test="${fileList != null}">
								<c:forEach var="files" items="${fileList}" varStatus="status">
									<label class="control-label">
										<a id="filBtn${status.count}" href="/fileDownload?file_no=${files.file_no}">${files.file_realnm }</a>
										<button type="button" class="btn btn-default delBtn">X</button>
									</label> 
										<br>
								</c:forEach>
							</c:if>
						<c:forEach var="i" begin="1" end="${5-fileList.size()}">
							<input type="file" name="realfilename${i }" >
							<p>${i }</p>
						</c:forEach>
							<div class="result">
								<input id="del_nos" type="hidden" name="del_nos" value="">
							</div>
						</div>
					</div>
					<button id="crtBtn" type="submit" class="btn btn-default">수정완료</button>
				</form>
			</div>
	
		</div>
	</div>
</div>
</div>
</body>
</html>
