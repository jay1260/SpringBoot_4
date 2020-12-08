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
	<h3>Member Login</h3>
	<form action="./memberLogin" method="post" id="loginFrm">
		<div class="form-group">
			<label for="id">Id:</label>
			<input type="text" class="form-control" id="id" name="id" placeholder="Enter Id">
		</div>
		
		<div class="form-group">
			<label for="pw">Password:</label>
			<input type="password" class="form-control" id="pw" name="pw" placeholder="Enter Password">
		</div>
		
		<div class="checkbox">
			<label><input type="checkbox" name="remember"> Remember me</label>
		</div>
		
		<input type="button" class="btn btn-primary" value="Login" id="loginBtn">
	</form>	
</div>

</body>
<script type="text/javascript">
	$("#loginBtn").click(function(){
		$("#loginFrm").submit();
	});
</script>
</html>