<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<jsp:include page="/WEB-INF/views/common/head.jsp"></jsp:include>
</head>
<body>
	<h3>게시물 상세</h3>
	<div class="container">
		<form method="POST" action="/board-info/delete">
		<input type="hidden" name="biNum" value="${boardInfo.biNum}">
		<table class="table table-bordered">
			<thead>
					<tr>
						<th scope="row">번호</th>
						<td>${boardInfo.biNum}</td>
					</tr>
					<tr>
						<th scope="row">제목</th>
						<td>${boardInfo.biTitle}</td>
					</tr>
					<tr>
						<th scope="row">내용</th>
						<td>${boardInfo.biContent}</td>
					</tr>
					<tr>
						<th scope="row">작성자</th>
						<td>${boardInfo.uiNum}</td>
					</tr>
					<tr>
						<th scope="row">작성일</th>
						<td>${boardInfo.creDat}</td>
					</tr>
					<c:if test="${user.uiNum == boardInfo.uiNum}">
					<tr>
						<th colspan="2">
							<button type="button" class="btn btn-primary" onclick="goPage('/board-info/update?biNum=${boardInfo.biNum}')">수정</button>
							<button class="btn btn-danger">삭제</button>
						</th>
					</tr>
					</c:if>
			</thead>
		</table>
		</form>
		<script>
			function goPage(url) {
				location.href=url;
			}
		</script>
	</div>
</body>
</html>