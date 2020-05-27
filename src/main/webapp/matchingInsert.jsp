<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<center>
		<hr>
		<form action="matchInsert.do" method="post">
			<table border="1" cellpadding="0" cellspacing="0">
				<tr>
					<td bgcolor="orange">seno</td>
					<td><input type="text" name="seno" value="${matching.seno }"></td>
				</tr>
				<tr>
					<td bgcolor="orange">rcno</td>
					<td><input type="text" name="rcno" value="${matching.rcno }"></td>
				</tr>
				<tr>
					<td bgcolor="orange">rno</td>
					<td><input type="text" name="rno" value="${matching.rno }"></td>
				</tr>
				<tr>
					<td bgcolor="orange">eno</td>
					<td><input type="text" name="eno" value="${matching.eno }"></td>
				</tr>
				<tr>
					<td bgcolor="orange">mdate</td>
					<td><input type="text" name="mdate" value="${matching.mdate }"></td>
				</tr>
				<tr>
					<td bgcolor="orange">mplace</td>
					<td><input type="text" name="mplace"
						value="${matching.mplace }"></td>
				</tr>
				<tr>
					<td bgcolor="orange">mservice</td>
					<td><input type="text" name="mservice"
						value="${matching.mservice }"></td>
				</tr>
				<tr>
					<td bgcolor="orange">mstate</td>
					<td><input type="text" name="mstate"
						value="${matching.mstate }"></td>
				</tr>
				<td colspan="2" align="center"><input type="submit" value="확인">
				</td>
				</tr>
			</table>
		</form>
		<hr>
	</center>
</body>
</html>