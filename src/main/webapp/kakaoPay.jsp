<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>kakaoPay api TEST</title>
</head>
<body>

	<h1>kakaoPay api 이용하기</h1>

	<form action="/KLPR/kakaoPay.do" method="post">
		<select name="pay">
			<option value="10000">10,000</option>
			<option value="20000">20,000</option>
			<option value="30000">30,000</option>
			<option value="50000">50,000</option>
		</select>
		<button type="submit">카카오페이로 결제하기</button>
	</form>


</body>
</html>