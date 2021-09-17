<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>

<title>Insert title here</title>


<!-- include libraries(jQuery, bootstrap) -->
<link href="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css" rel="stylesheet">
<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>

<!-- include summernote css/js -->
<link href="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote.min.js"></script>

<style type="text/css">
#d1 {
	width: 300px;
	height: 300px;
	background-color: yellow;
}

</style>

</head>
<c:import url="../temp/boot_nav.jsp"></c:import>
<body>
	<h1>${board}InsertPage</h1>

	<div class="container-fluid">
		<form class="col-md-5 mx-auto" action="./insert" method="post"
			enctype="multipart/form-data">
			<div class="mb-3">
				<label for="title" class="form-label">Title</label> <input
					type="text" class="form-control" name="title" id="title"
					placeholder="Enter Title">
			</div>
			<div class="mb-3">
				<label for="contents" class="form-label">Contents</label>
				<textarea class="form-control" cols="" name="contents"
					id="contents" rows="6"></textarea>
			</div>

			<div class="mb-3">
				<label for="writer" class="form-label">Writer</label> <input
					type="text" class="form-control" name="writer" readonly id="writer"
					value="${member.id}">
			</div>



			<!-- button 추가 -->


			<button type="button" id="fileAdd" class="btn btn-primary">File
				Add</button>
			<button type="button" class="del">Delete</button>
			<div id="fileAddResult"></div>


			<div class="mt-3 ml-0">
				<button type="submit" class="btn btn-success">ADD</button>
			</div>
		</form>
		
		</div>

		<div id="d1">
			<button id="click">click</button>
		</div>



	<script type="text/javascript" src="../resources/js/boardfile.js"></script>
	<script type="text/javascript">
		
		$("#contents").summernote();
	
		$("#d1").click(function() {
			alert('yellow');
		})
		$("#click").click(function() {
			alert('click');
		})
	</script>
</body>
</html>