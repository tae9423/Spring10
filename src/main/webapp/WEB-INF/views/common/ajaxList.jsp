<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<table class="table table-dark table-striped">
	<thead>
		<tr>
			<th scope="col">COMMENTNUM</th>
			<th scope="col">CONTENTS</th>
			<th scope="col">WRITER</th>
			<th scope="col">REGDATE</th>
			
		</tr>
	</thead>
	<tbody>
	<c:forEach items="${comments}" var="comments">
		<tr>
			<td>${comments.commentNum}</td>
			<td>${comments.contents}</td>
			<td>${comments.writer}</td>
			<td>${comments.regDate}</td>
		</tr>
	</c:forEach>
	</tbody>
</table>
<nav aria-label="Page navigation example">
			<ul class="pagination">
				<li class="page-item"><span class="page-link more" data-comment-pn="1"
					aria-label="Previous"> <span aria-hidden="true">&laquo;</span>
				</span></li>

				<li class="page-item"><span class="page-link more" data-comment-pn="${pager.startNum-1}"
					aria-label="Previous"> <span aria-hidden="true">&lt;</span>
				</span></li>

				<c:forEach begin="${pager.startNum}" end="${pager.lastNum}" var="n">
					<li class="page-item"><span class="page-link more" data-comment-pn="${n}">${n}</span>
					</li>
				</c:forEach>

				<li class="page-item"><span class="page-link more" data-comment-pn="${pager.lastNum+1}"
					aria-label="Next"> <span aria-hidden="true">&gt;</span>
				</span></li>

				<li class="page-item"><span class="page-link more" data-comment-pn="${pager.totalPage}"
					aria-label="Next"> <span aria-hidden="true">&raquo;</span>
				</span></li>
			</ul>
		</nav>
