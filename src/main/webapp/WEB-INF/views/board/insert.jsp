<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>

<title>Insert title here</title>
<c:import url="../temp/boot_head.jsp"></c:import>
<link href="./resources/css/home.css" rel="stylesheet">
</head>
<c:import url="../temp/boot_nav.jsp"></c:import>
<style type = "text/css">
	.er {
	color : red;
	}

</style>
<body>
	<h1>${board}Insert Page</h1>

	<div class="container-fluid">
		<form id="frm" class="col-md-5 mx-auto" action="./insert" method="post">
			<div  class="mb-3">
				<label for="title" class="form-label">Title</label> <input
					type="text" class="form-control" name="title" id="title"
					placeholder="Enter Title">
				<div id="t_1" class="er"></div>
			</div>
			<div class="mb-3">
				<label for="contents" class="form-label">Contents</label> <input
					type="text" class="form-control" name="contents" id="contents"
					placeholder="Enter Contents">
			</div>
			<div class="mb-3">
				<label for="writer" class="form-label">Writer</label> <input
					type="text" class="form-control" name="writer" id="writer" 
					placeholder="Enter Writer">
					<div id="w_1" class="er"></div>
			</div>
			<div class="mt-3 ml-0">
				<button type="button" onclick="fn1()" class="btn btn-success">ADD</button>
			</div>
		</form>
	</div>

	<script type="text/javascript" src="../resources/js/boardCheck.js"></script>
</body>
</html>