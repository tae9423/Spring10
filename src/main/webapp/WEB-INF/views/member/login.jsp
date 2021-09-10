<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<c:import url="../temp/boot_head.jsp"></c:import>
</head>
<c:import url="../temp/boot_nav.jsp"></c:import>
<body>
	<h1>Login Page</h1>
	<div class="container-fluid">
		<form id="frm" class="col-md-5 mx-auto" action="./login" method="post">
			<div class="mb-3">
				<label for="text" class="form-label">ID</label> <input type="text"
					class="form-control put" name="id" id="id" placeholder="아이디를 입력하세요">

			</div>
			<div class="mb-3">
				<label for="Password" class="form-label">Password</label> <input
					type="text" class="form-control put pw" name="pw"
					id="pw" placeholder="비밀번호를 입력하세요">
			</div>
			<div class="mt-3 ml-0">
				<button type="submit" id="btn" class="btn btn-success">Login</button>
			</div>
		</form>
	</div>

</body>
</html>