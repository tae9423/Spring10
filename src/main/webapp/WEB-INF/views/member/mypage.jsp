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


	<h1>My Page</h1>
	<h1>ID : ${member.id}</h1>
	<h1>NAME : ${member.name}</h1>
	<h1>PHONE : ${member.phone}</h1>
	<h1>E-mail : ${member.email}</h1>


	<a href="#" id="del">회원 탈퇴</a>
	<script type="text/javascript">
		//const del = document.getElementById("del");
		const del = document.querySelector("#del");
		del.addEventListener('click', function(){
			let result = confirm('정말 탈퇴하시겠습니까?');
			if (result){
				location.href="./delete";
			}
		})
	</script>
	<a href="./update">회원 수정</a>

	<script type="text/javascript" src="../resources/js/join.js"></script>
</body>
</html>