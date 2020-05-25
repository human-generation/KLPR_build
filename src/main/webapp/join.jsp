<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입 페이지</title>
</head>
<body>
	<center>
		<br> 회원가입 페이지입니다. <br>
		<form action="join.do" method="post">
			<table border="1">
				<tr>
					<td>이메일 :</td>
					<td><input type="text" name="email"></td>
				</tr>
				<tr>
					<td>비밀번호 :</td>
					<td><input type="password" name="pw"></td>
				</tr>
				<tr>
					<td>비밀번호 확인 :</td>
					<td><input type="password" name="pw2"></td>
				</tr>
				<tr>
					<td>이름 :</td>
					<td><input type="text" name="name"></td>
				</tr>
				<tr>
					<td>성별 (none 0/ female 1/ male 2) :</td>
					<td><input type="text" name="gender"></td>
				</tr>
				<tr>
					<td>전화번호(010-0000-0000) :</td>
					<td><input type="text" name="phone"></td>
				</tr>
				<tr>
					<td>소개 :</td>
					<td><input type="text" name="ucomment"></td>
				</tr>
				<tr>
					<td colspan="2" align="center"><input type="submit" value="확인"></a></td>
				</tr>
			</table>
		</form>
	</center>
</body>
</html>