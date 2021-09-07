<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<c:import url="../temp/boot_head.jsp"></c:import>
<meta charset="UTF-8">
<title>Insert title here</title>

</head>
<body>
<c:import url="../temp/boot_nav.jsp"></c:import>
	<h1>${board}BoardList Page</h1>

	<div class="col-md-7 my-2 mx-auto">
		<table class="table">
			<!-- search Form Start-->

			<form action="./list" method="get">

				<div class="input-group mb-3">
					<select name="kind" class="form-select form-select-sm"
						aria-label=".form-select-sm example">
						<option value="title">title</option>
						<option value="contents">contents</option>
						<option value="writer">writer</option>
					</select> <input type="text" name="search" class="form-control"
						aria-label="Text input with dropdown button">
					<button type="submit" class="btn btn-outline-secondary">Search</button>
				</div>

			</form>


			<!-- search Form Finish -->

			<thead>
				<tr>
					<th scope="col">NUM</th>
					<th scope="col">TITLE</th>
					<th scope="col">CONTENTS</th>
					<th scope="col">WRITER</th>
					<th scope="col">HITS</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${list}" var="dto">
					<tr>
						<th scope="row">${dto.num}</th>
						<td><a href="./select?num=${dto.num}">
						
						<c:catch>
							<c:forEach begin="1" end="${dto.depth}">
								--
							</c:forEach>
						</c:catch>						
						
						${dto.title}</a></td>
						<td>${dto.contents}</td>
						<td>${dto.writer}</td>
						<td>${dto.hits}</td>
					</tr>
				</c:forEach>


			</tbody>
		</table>
		<nav aria-label="Page navigation example">
			<ul class="pagination">
				<li class="page-item"><a class="page-link"
					href="./list?kind=${pager.kind}&search=${pager.search}"
					aria-label="Previous"> <span aria-hidden="true">&laquo;</span>
				</a></li>

				<li class="page-item"><a class="page-link"
					href="./list?pn=${pager.startNum-1}&kind=${pager.kind}&search=${pager.search}"
					aria-label="Previous"> <span aria-hidden="true">&lt;</span>
				</a></li>

				<c:forEach begin="${pager.startNum}" end="${pager.lastNum}" var="n">
					<li class="page-item"><a class="page-link"
						href="./list?pn=${n}&kind=${pager.kind}&search=${pager.search}">${n}
					</a></li>
				</c:forEach>

				<li class="page-item"><a class="page-link"
					href="./list?pn=${pager.lastNum+1}&kind=${pager.kind}&search=${pager.search}"
					aria-label="Next"> <span aria-hidden="true">&gt;</span>
				</a></li>

				<li class="page-item"><a class="page-link"
					href="./list?pn=${pager.totalPage}&kind=${pager.kind}&search=${pager.search}"
					aria-label="Next"> <span aria-hidden="true">&raquo;</span>
				</a></li>
			</ul>
		</nav>
		
		<a href="./insert" class="btn btn-danger">ADD</a>
</body>
</html>