<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<c:import url="../temp/boot_head.jsp"></c:import>

<title>Insert title here</title>
</head>
<body>
	<c:import url="../temp/boot_nav.jsp"></c:import>
	<h1>${board}Select Page</h1>

	<div class="container-fluid">

		<h1>Num : ${dto.num}</h1>
		<h1>Title : ${dto.title}</h1>
		<h1>Contents : ${dto.contents}</h1>
		<h1>Writer : ${dto.writer}</h1>
		<h1>Date: ${dto.regDate}</h1>
		<h1>Hits : ${dto.hits}</h1>
		
		<a href="./delete?num=${dto.num}">Delete</a>
		<a href="./update?num=${dto.num}">Update</a>
		<c:if test="${board eq 'qna'}">
			<a href="./reply?num=${dto.num}">Reply</a>
		</c:if>
	</div>
	
	<div>
		<input type="checkbox" id="id1" class="c1" value="1" checked="checked">
		<input type="checkbox" id="id2" class="c1" value="2">
		<input type="checkbox" id="id3" class="c1" value="3" checked="checked">
		<input type="checkbox" id="id4" class="c1" value="4">
	</div>
	<button id="btn">CHECK</button>
	
	<script type="text/javascript" src="../resources/js/select.js"></script>
</body>
</html>