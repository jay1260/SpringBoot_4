<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<c:import url="../template/bootStrap.jsp"></c:import>
<link href="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote.min.js"></script>
</head>
<body>
<c:import url="../template/header.jsp"></c:import>

	<div class="container">
		<h3>Select 상세내용, 첨부파일 출력</h3>
		<div class="form-group">
			<label for="title">Title:</label>
			<input type="text" class="form-control" id="title" name="title" value="${select.title}" readonly="readonly" style="background-color: inherit;">
		</div>
		<div class="form-group">
			<label for="writer">Writer:</label>
			<input type="text" class="form-control" id="writer" name="writer" value="${select.writer}" readonly="readonly" style="background-color: inherit;">
		</div>
		
		<div class="form-group">
			<label for="contents">Contents:</label>
			<textarea class="form-control" rows="10" id="contents" name="contents">${select.contents}</textarea>
		</div>
		
		<div class="form-group">
			<h3>Files</h3>
			<c:forEach items="${select.files}" var="file">
				<p> <a href="noticeFileDown?fnum=${file.fnum}">${file.oriName}</a> </p>
				<p> <img alt="" src="../upload/notice/${file.fileName}">
			</c:forEach>
		</div>
	</div>
</body>
<script type="text/javascript">
	$("#contents").summernote({
		height:300,
	});
</script>
</html>