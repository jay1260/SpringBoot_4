<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<c:import url="../template/bootStrap.jsp"></c:import>
<!-- 위에 JS를 사용하기 위한 준비 2가지 -->
<!-- 
<script type="text/javascript">
	//$(document).ready(function(){		// HTML 문서가 로딩이 끝났을 때
		코드작성
	});									
		
	//$(function(){						// document.ready의 축약형
		코드작성
	});									
</script>
 -->
</head>

<body>
<c:import url="../template/header.jsp"></c:import>

<div class="container">
	<h3>Board List Page</h3>
	<p>The .navbar-right class is used to right-align navigation bar buttons.</p>

	<c:if test="${not empty member}">
		<h1> <spring:message code="member.login.message" arguments="${member.id}"></spring:message> </h1>
	</c:if>
	
	<img alt="" src="../images/flower_2.jpg">
	<!-- Seach -->
	<form action="./${board}List" id=searchFrm>
		<input type="hidden" name="curPage" id="curPage" value="1">
		
		<div class="form-group" style="margin-bottom: 4px;">
			<label for="sel1">Select list:</label>
			<select class="form-control" id="kind" name="kind">
				<option>title</option>
				<option>writer</option>
				<option>contents</option>
			</select>
		</div>
		
		<div class="input-group" style="margin-bottom: 15px;">
			<input type="text" class="form-control" id="search" placeholder="Search" name="search">
			<div class="input-group-btn">
				<button class="btn btn-default" type="submit">
				<i class="glyphicon glyphicon-search"></i>
				</button>
			</div>
		</div>			  			  
	</form>

	<table class="table table-hover">
		<tr>
			<th>Num</th><th>Title</th><th>Writer</th><th>Date</th><th>Hit</th>
		</tr>
		<c:forEach items="${list}" var="vo">
			<tr>
				<td>${vo.num}</td>
				<td><a href="${board}Select?num=${vo.num}">${vo.title}</a></td>
				<td>${vo.writer}</td>
				<td>${vo.regDate}</td>
				<td>${vo.hit}</td>
			</tr>
		</c:forEach>
	</table>
	
	<!-- Page 처리 -->
	<ul class="pagination">
		<c:if test="${pager.before}">
			<li><a href="#" class="list" title="${pager.startNum-1}">Previous</a></li>
		</c:if>
		
		<c:forEach begin="${pager.startNum}" end="${pager.lastNum}" var="i">
			<c:if test="${not empty list }">	
				<li><a href="#" class="list" title="${i}">${i}</a></li>
			</c:if>
		</c:forEach>
		
		<c:if test="${pager.after}">
			<li><a href="#" class="list" title="${pager.lastNum+1}">Next</a></li>
		</c:if>
	</ul>
	<c:if test="${empty list }">
		<h3>게시글이 없습니다.</h3>
	</c:if>

	<!-- Write 버튼 생성 클릭 -->
	<input type="button" class="btn btn-danger" value="Write" id="writeBtn">

	<script type="text/javascript">
		$("#search").val('${param.search}');

		var kind = '${param.kind}';
		if(kind != ''){
			$("#kind").val(kind);
		}
		$(".list").click(function(){
			var curPage = ($(this).attr("title"));
			$("#curPage").val(curPage);

			
			$("#searchFrm").submit();
		});
	
		$("#writeBtn").click(function(){
			location.href="./${board}Write";
		});
	</script>
</div>
</body>
</html>