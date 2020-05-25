<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인 페이지</title>
</head>
<body>
	<center>
		<br> 로그인페이지입니다. <br>
		<form action="login.do" method="post">
			<table border="1">
				<tr>
					<td>이메일 :</td>
					<td><input type="text" name="email" value="${user.email}"></td>
				</tr>
				<tr>
					<td>비밀번호 :</td>
					<td><input type="password" name="pw" value="${user.pw}"></td>
				</tr>
				<tr>
					<td colspan="2" align="center"><input type="submit" value="확인">
					</td>
				</tr>
			</table>
		</form>
	</center>
</body>
</html>