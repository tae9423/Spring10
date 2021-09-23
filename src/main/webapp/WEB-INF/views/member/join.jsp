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
	<h1 class="col-md-6 mx-auto my-5">Join Page</h1>

	<div class="container-fluid">
		<form id="frm" class="col-md-6 mx-auto my-5" action="./join" method="post" enctype="multipart/form-data">

			<div class="mb-3">
				<label for="text" class="form-label">ID</label> <input type="text"
					class="form-control put" name="id" id="id" placeholder="아이디를 입력하세요">
				<button type="button" id="idCheck">ID 중복확인</button>
				<div id="idResult"></div>
			</div>

			<div class="mb-3">
				<label for="Password" class="form-label">Password</label> <input
					type="text" class="form-control put pw" name="pw" id="pw"
					placeholder="비밀번호를 입력하세요">
			</div>

			<div class="mb-3">
				<label for="rePassword" class="form-label">Check the
					password</label> <input type="text" class="form-control put pw"
					id="rePassword" name="rePassword" placeholder="비밀번호를 한번 더 입력하세요">
				<div id="pwResult"></div>
			</div>

			<div class="mb-3">
				<label for="name" class="form-label">이름</label> <input type="text"
					class="form-control put" name="name" id="name" placeholder="홍길동">
			</div>

			<div class="mb-3">
				<label for="phone" class="form-label">전화번호</label> <input
					type="text" class="form-control put" name="phone" id="phone"
					placeholder="010-xxxx-xxxx">
			</div>

			<div class="mb-3">
				<label for="email" class="form-label">Email address</label> <input
					type="text" class="form-control put" name="email"
					id="exampleInputEmail1" aria-describedby="emailHelp">
				<div id="emailHelp" class="form-text">We'll never share your
					email with anyone else.</div>
			</div>

			<div class="mb-3" id="f">
				<label for="photo" class="form-label">Photo</label> <input
					type="file" class="form-control put" name="photo" id="photo">
			</div>

			<div class="mt-3 ml-0">
				<button type="submit" id="btn" class="btn btn-primary">Join</button>

			</div>
		</form>

	</div>
	

	<script type="text/javascript" src="../resources/js/join.js"></script>
	<script type="text/javascript" src="../resources/js/file.js"></script>
	
	
</body>
</html>