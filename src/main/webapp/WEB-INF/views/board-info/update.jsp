<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<jsp:include page="/WEB-INF/views/common/head.jsp"></jsp:include>
</head>
<body>
<h3>update</h3>
<div class="container">
<form method="POST" action="/board-info/update">
<input type="hidden" name="biNum" value="${boardInfo.biNum}">
  <div class="form-group">
    <label for="biTitle">제목</label>
    <input type="text" class="form-control" id="biTitle" name="biTitle" placeholder="제목" value="${boardInfo.biTitle}">
  </div>
  <div class="form-group">
    <label for="biContent">내용</label>
    <textarea class="form-control" id="biContent" name="biContent" placeholder="내용">${boardInfo.biContent}</textarea>
  </div>
  <button type="submit" class="btn btn-primary">수정</button>
</form>
</div>
</body>
</html>