<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
<c:import url="./temp/boot_head.jsp"></c:import>

	<title>Home</title>
	
</head>

<c:import url="./temp/boot_nav.jsp"></c:import>	 
<body>
	<h1>Hello</h1>
	
	<c:if test="${not empty member}">
	<h3>Login이 성공 했을 때 보이는 문장</h3>
	</c:if> 
	
	<c:if test="${empty member}">
	<h3>Login을 하기전 보이는 문장</h3>
	</c:if>
	
	 
	<h1 id="ar"></h1>
	<button id="btn">CLICK</button>
   
   <script type="text/javascript">
      /* const btn = document.getElementById("btn");
      btn.addEventList */
      // 위에가 아래로 바뀜
   
      $("#btn").click(function(){
         $.get("./ajax/t1?num=1", function(result){
        	 console.log(result.trim());
        	 $('#ar').html(result.trim());
         });
      });
   </script>
	

</body>
</html>
