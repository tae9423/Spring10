<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>

<title>Home</title>
<script type="text/javascript">
	alert('Hello world');
</script>
<link href="./resources/css/home.css" rel="stylesheet">

</head>


<body>
	<h1 class="c1">Hello world</h1>

	<h1 id ="d1">Other</h1>
	
	<div id="d2">
		<h3>In DIV</h3>
	</div>

	<img class="c1" id="d3" alt="" src="./resources/images/test3.jpg">
	
	<div>
		<button onclick="fn1()">CLICK</button>
	</div>


	<script type="text/javascript">
		console.log('body Script');
	</script>
	<script type="text/javascript" src="./resources/js/function_1.js"></script>
	<!-- <script type="text/javascript" src="./resources/js/home.js"></script> -->
	
</body>
</html>
