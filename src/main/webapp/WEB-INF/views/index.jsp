<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<c:import url="./template/bootStrap.jsp"></c:import>
<!-- css 파일 static/css/index.css 경로 statice의 경로는 제외 
<link href="./css/index.css" rel="stylesheet">
-->
</head>
<body>
<c:import url="./template/header.jsp"></c:import>

<div class="container">
	<h3>Index Page</h3>
	<p>The .navbar-right class is used to right-align navigation bar buttons.</p>

	<!-- src/main/resources/static/images/~~ static의 경로는 제외 -->
	<img alt="" src="./images/flower_2.jpg">

</div>

</body>
</html>