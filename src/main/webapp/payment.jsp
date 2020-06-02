<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>충전 페이지</title>

</head>
<body>
	<form action="payment.do" method="POST">
		충전할 금액을 선택하세요 <select name="pay">
			<option value="10000">10,000</option>
			<option value="20000">20,000</option>
			<option value="30000">30,000</option>
			<option value="50000">50,000</option>
			<option value="100000">100,000</option>
		</select> <input type="submit" value="충전하기">
	</form>
	<a href="myPage.do">뒤로가기</a>
</body>
</html>