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
			<h2 class="sub-header">Main</h2>
			<div class="table-responsive">
				<h3>🙇🏻‍♂️게시판 로그인 완료🙇🏻‍♀️</h3>
			</div>
		</div>
	</div>
</div>
</div>
</body>
</html>
