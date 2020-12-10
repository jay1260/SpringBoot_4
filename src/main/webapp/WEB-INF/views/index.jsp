<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
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
	
	<c:if test="${not empty member}">
		<h3> <spring:message code="member.login.message" arguments="${member.id}"></spring:message> </h3>
		<h3> <spring:message code="member.login.message2" arguments="${member.id}, ${member.name}" argumentSeparator=","></spring:message> </h3>
	</c:if>
	
	<h3>Index Page</h3>
	<p>The .navbar-right class is used to right-align navigation bar buttons.</p>
	
	<spring:message code="name" var="n"></spring:message>
	<h1>Message : <spring:message code="hello"></spring:message> </h1>
	<h1>Name : ${n} </h1>
	<h1>Age : <spring:message code="user.age"></spring:message> </h1>
	<h1>Default : <spring:message code="use" text="Default Message"></spring:message> </h1>

	<!-- src/main/resources/static/images/~~ static의 경로는 제외 -->
	<img alt="" src="./images/flower_2.jpg">
	<h3>var : ${n}</h3>
	
	<a href="./rest/member/iu/1"></a>

</div>

</body>
</html>