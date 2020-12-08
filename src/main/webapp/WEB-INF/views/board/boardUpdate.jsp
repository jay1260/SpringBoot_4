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
	
	<form action="./${board}Update?num=${update.num}" method="post">
		<div class="form-group">
			<label for="title">Title:</label>
			<input type="text" class="form-control" id="title" value="${update.title}" name="title">
		</div>
		
		<div class="form-group">
			<label for="writer">Writer:</label>
			<input type="text" class="form-control" id="writer" value="${update.writer}" readonly="readonly" name="writer">
		</div>
		
		<div class="form-group">
			<label for="contents">Contents:</label>
			<textarea class="form-control" rows="10" id="contents" name="contents">${update.contents}</textarea>
		</div>
		
		<input type="submit" value="UPDATE"> 
		
	</form>
	
</div>

</body>
</html>