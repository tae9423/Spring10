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
		
		<div>
			${dto.contents}
		</div>
		<h1>Writer : ${dto.writer}</h1>
		<h1>Date: ${dto.regDate}</h1>
		<h1>Hits : ${dto.hits}</h1>
		
		<c:forEach items="${dto.files}" var="f">
			<div>
			<a href="./down?fileName=${f.fileName}">${f.oriName}</a>
			</div>
		</c:forEach>
		
		<hr>
		<div>
			<div class="mb-3">
				<label for="writer" class="form-label">Writer</label> <input
					type="text" class="form-control" name="writer" readonly id="writer"
					value="${member.id}">
			</div>
			
			<div class="mb-3">
				<label for="contents" class="form-label">Contents</label>
				<textarea class="form-control" cols="" name="contents"
					id="contents" rows="6"></textarea>
			</div>
			
			<!-- button 추가 -->
			<a href="./select/?num=${dto.num}" class="btn btn-success" id="comment">WRITE</a>
		</div>
		
		
		
		<hr>
		
		<div class="input-group mb-3">
		<table class="table">
				<tr>
					<th scope="col">COMMENTNUM</th>
					<th scope="col">NUM</th>
					<th scope="col">WRITER</th>
					<th scope="col">CONTENTS</th>
					<th scope="col">REGDATE</th>
					<th scope="col">BOARD</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${comments}" var="comments">
					<tr>
						<td>${comments.commentNum}</td>
						<td>${comments.num} </td>
						<td>${comments.writer}</td>
						<td>${comments.contents}</td>
						<td>${comments.regDate}</td>
						<td>${comments.board}</td>
					</tr>
				</c:forEach>


			</tbody>
		</table>
		</div>
		


		<c:if test="${board eq 'qna'}">
			<a href="./reply?num=${dto.num}">Reply</a>
		</c:if>
		
		<c:if test="${member.id eq dto.writer}">
			<a href="./delete?num=${dto.num}">Delete</a>
			<a href="./update?num=${dto.num}">Update</a>
		</c:if>
	</div>

	<script type="text/javascript">
		$('#comment').click(function(){
			//작성자, 내용
			let writer = $("#writer").val();
			let contents = $("#contents").val();
			$.post('./comment',{num:'${dto.num}', writer:writer, contents:contents}, function(result){
				console.log(result.trim());
			});
			
			console.log(writer, contents);
		});
	</script>
	
</body>
</html>