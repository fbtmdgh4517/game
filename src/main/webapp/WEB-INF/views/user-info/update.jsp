<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>유저 수정</h3>
<form method="POST" action="/user-info/update">
<input type="hidden" name="uiNum" value="${userInfo.uiNum}">
<table border="1">
	<tr>
		<th>이름</th>
		<td>
			<input type="text" name="uiName" value="${userInfo.uiName}">
		</td>
	</tr>
	<tr>
		<th>생년월일</th>
		<td>
			<input type="date" name="uiBirth" value="${userInfo.uiBirth}">
		</td>
	</tr>
	<tr>
		<th>소개</th>
		<td>
			<textarea name="uiDesc">${userInfo.uiDesc}</textarea>
		</td>
	</tr>
	<tr>
		<th>아이디</th>
		<td>
			<input type="text" name="uiId" value="${userInfo.uiId}">
		</td>
	</tr>
	<tr>
		<th>비밀번호</th>
		<td>
			<input type="password" name="uiPwd" value="${userInfo.uiPwd}">
		</td>
	</tr>

	<tr>
		<td>
			<button>수정</button>
		</td>
		<td>
			<button type="button" onclick="location.href='/user-info/view?uiNum=${userInfo.uiNum}'">취소</button>
		</td>
	</tr>
</table>
</form>
</body>
</html>