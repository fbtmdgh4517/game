<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<jsp:include page="/WEB-INF/views/common/head.jsp"></jsp:include>
</head>
<body>
	<h3>list</h3>
	<div class="container">
		<table class="table table-bordered shadow">
			<thead>
				<tr>
					<th scope="col">번호</th>
					<th scope="col">제목</th>
					<th scope="col">작성자</th>
					<th scope="col">작성일</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${boardInfoList}" var="board">
					<tr>
						<td class="bg-primary text-white">${board.biNum}</td>
						<td class="bg-danger text-white">
							<a href="/board-info/view?biNum=${board.biNum}">${board.biTitle}</a>
						</td>
						<td class="bg-secondary text-white">${board.uiNum}</td>
						<td class="bg-success text-white">${board.creDat}</td>
					</tr>
				</c:forEach>
				<tr>
					<td colspan="4" align="right">
						<button type="button" class="btn btn-primary" onclick="goPage('/board-info/insert')">등록</button>
					</td>
				</tr>
			</tbody>
		</table>
	</div>
	<script>
		function goPage(url) {
			location.href = url;
		}
	</script>
</body>
</html>