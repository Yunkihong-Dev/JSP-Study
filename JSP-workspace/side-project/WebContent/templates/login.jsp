<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
</head>
<body>
	<form action="loginOk.member" method="post">
		<input type="text" name="memberName" placeholder="이름"><br>
		<input type="password" name="memberAge" placeholder="나이"><br>
		<input type="submit" value="로그인">
		<a href="join.member">회원가입</a>
	</form>
</body>
</html>