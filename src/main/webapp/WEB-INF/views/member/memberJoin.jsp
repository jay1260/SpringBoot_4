<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<c:import url="../template/bootStrap.jsp"></c:import>
</head>
<body>
<c:import url="../template/header.jsp"></c:import>

<div class="container">
	<h3>Member Join</h3>
	
	<form action="./memberJoin" method="post">
		<div class="form-group">
			<label for="id">Id:</label>
			<input type="text" class="form-control" id="id" name="id" placeholder="Enter Id">
		</div>
		
		<div class="form-group">
			<label for="pw">Password:</label>
			<input type="password" class="form-control" id="pw" name="pw" placeholder="Enter Password">
		</div>
		
		<div class="form-group">
			<label for="name">Name:</label>
			<input type="text" class="form-control" id="name" name="name" placeholder="Enter Name">
		</div>
		
		<div class="form-group">
			<label for="age">Age:</label>
			<input type="number" class="form-control" id="age" name="age" placeholder="Enter Age">
			<div>숫자 형태로만 입력하세요. ex) 22살 - > 22</div>
		</div>
		
		<div class="form-group">
			<label for="email">Email:</label>
			<input type="email" class="form-control" id="email" name="email" placeholder="Enter Email">
		</div>
		
		<input type="submit" class="btn btn-primary" value="JOIN">
	</form>
	
</div>

</body>
</html>