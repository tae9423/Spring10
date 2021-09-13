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
	<h1>${board}SelectPage</h1>

	<div class="container-fluid">

		<h1>Num : ${dto.num}</h1>
		<h1>Title : ${dto.title}</h1>
		<h1>Contents : ${dto.contents}</h1>
		<h1>Writer : ${dto.writer}</h1>
		<h1>Date: ${dto.regDate}</h1>
		<h1>Hits : ${dto.hits}</h1>
		<h1>member : ${member.id}</h1>

		


		<c:if test="${board eq 'qna'}">
			<a href="./reply?num=${dto.num}">Reply</a>
		</c:if>
		
		<c:if test="${member.id eq dto.writer}">
			<a href="./delete?num=${dto.num}">Delete</a>
			<a href="./update?num=${dto.num}">Update</a>
		</c:if>
	</div>
</body>
</html>