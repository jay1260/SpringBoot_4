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
<!-- include summernote css/js -->
<link href="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote.min.js"></script>
<style type="text/css">
	.error{
		color: red;
	}
</style>
</head>
<body>
<c:import url="../template/header.jsp"></c:import>
<div class="container">
	<h3>Notice Write Page</h3>
	
	<form:form modelAttribute="boardVO" enctype="multipart/form-data">
		<div class="form-group">
			<label for="title">Title:</label>
			<!-- path : parameter Name -->
			<form:input path="title" class="form-control"/>
			<form:errors path="title" cssClass="error"></form:errors>
		</div>
		
	<div class="form-group">
		<label for="writer">Writer:</label>
		<form:input path="writer" class="form-control"/>
		<form:errors path="writer" cssClass="error"></form:errors>
	</div>
	
	<div class="form-group">
		<label for="contents">Contents:</label>
		<form:textarea path="contents" id="contents"/>
	</div>
	
	<div class="form-group">
		<label for="files">File:</label>
		<input type="file" class="form-control" name="files">
		<input type="file" class="form-control" name="files">
	</div>
	
	<button type="submit" class="btn btn-default">Write</button>
		
	</form:form>
	
	
</div>	
</body>
<script type="text/javascript">
	$("#contents").summernote({
		height:300
	});
</script>
</html>