<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

</head>

<body>
	<h1>Id Check Page</h1>

	<div id="checkResult">
		${param.id}는
		<c:if test="${empty dto}">
			사용 가능한 ID 입니다.
		</c:if>

		<c:if test="${not empty dto}">
			사용 불가능한 ID 입니다.
		</c:if>

	</div>

	<div class="mb-3">
		<form id="frm" class="col-md-6 mx-auto" action="idCheck" method="get">
			<label for="text" class="form-label">ID</label> <input type="text"
				class="form-control put" name="id" value="${param.id}" id="id"
				placeholder="아이디를 입력하세요">
			<button type="submit" id="idCheck">ID 중복확인</button>
			<c:if test="${empty dto}">
				<button type="button" id="useId">ID사용</button>
			</c:if>
	</div>
	</form>

	<script type="text/javascript">
		const useId = document.getElementById('useId');
		useId.addEventListener('click', function() {
			let id = window.document.getElementById('id').value;
			opener.window.document.getElementById('id').value=id;
			close();
		});
	</script>

</body>
</html>