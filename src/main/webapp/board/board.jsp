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
<meta name="description" content="">
<meta name="author" content="">
<link rel="icon" href="../../favicon.ico">

<title>Jsp</title>
<%@ include file="/layout/commonlib.jsp" %>
<script type="text/javascript">
$(document).ready(function(){
	value = $('.status').val();
	
	$('.sel').on('change', function(){
		console.log(value)
// 		alert(this.value);
		if(this.value == 'N')
			$('.status').prop('value', 'N');
		else
			$('.status').prop('value', 'Y');
	})
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
		<h2 class="sub-header">게시판관리</h2>
		<div class="table-responsive">
			<form id="frm" action="${cp }/createBoard" method="post" >
				생성 게시판 이름 : <input name="board_title" type="text" value="테이블">
				<input id="crtBtn" type="submit" class="btn btn-default pull-right" value="생성"> 
			</form>
				<table class="table table-striped">
					<tr>
						<th>게시판 이름</th>
						<th>사용 여부</th>
						<th></th>
					</tr>
		            <c:forEach items="${boardList }" var="board">
						<form action="${cp }/updateBoard" method="post" >	
				            <tr>
					            <td>
					            	<input type="hidden" value="${board.board_no }" name="board_no">
									<input type="text" value="${board.board_title }" name="board_title">
					            </td>
					            <td>
					            	<input type="hidden" value="${board.board_status }" class="status" name="board_status">
									<select class="sel"> 
										<c:if test="${board.board_status == 'Y' }">
											<option class="y" value="Y" >사용</option>
											<option class="n" value="N">미사용</option>
										</c:if>
										<c:if test="${board.board_status == 'N' }">
											<option class="n" value="N">미사용</option>
											<option class="y" value="Y" >사용</option>
										</c:if>
									</select>
								</td>	
				            	<td>
									<input class="updBtn" type="submit" class="btn btn-default pull-right" value="수정">
				            	</td>
			            	</tr>
						</form>
		            </c:forEach>
				</table>
		</div>

		
	</div>
</div>
	</div>
		</div>
	</div>
</body>
</html>
