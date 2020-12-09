<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<c:import url="../template/bootStrap.jsp"></c:import>
<style type="text/css">
	.form-css{
		color:red;
		font-weight: bold;
	}
</style>
</head>
<body>
<c:import url="../template/header.jsp"></c:import>

<div class="container">
	<h3>Member Join</h3>
	
	<form:form modelAttribute="memberVO">
		
		<div class="form-group">
			<label for="id">ID:</label>
			<form:input path="id" class="form-control"/>
			<form:errors path="id" cssClass="form-css"></form:errors>
		</div>
		
		<div class="form-group">
			<label for="pw">Password:</label>
			<form:password path="pw" class="form-control"/>
			<form:errors path="pw" cssClass="form-css"></form:errors>
		</div>
		
		<div class="form-group">
			<label for="name">Name:</label>
			<form:input path="name" class="form-control"/>
			<form:errors path="name" cssClass="form-css"></form:errors>
		</div>
		
		<div class="form-group">
			<label for="age">Age:</label>
			<form:input path="age" class="form-control"/>
			<form:errors path="age" cssClass="form-css"></form:errors>
		</div>
		
		<div class="form-group">
			<label for="email">Email:</label>
			<form:input path="email" class="form-control"/>
			<form:errors path="email" cssClass="form-css"></form:errors>
		</div>
		
		<input type="submit" class="btn btn-primary" value="JOIN">
		
	</form:form>
	
</div>

</body>
</html>