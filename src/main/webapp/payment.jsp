<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>충전 페이지</title>
<a href="summary.do">서비스개요</a> &nbsp;
<a href="faq.do">FAQ</a> &nbsp;
<a href="main.do">로고</a> &nbsp;
<c:if test="${empty sessionScope.userName}">
	<a href="login.do">로그인</a>&nbsp;
	<a href="join.do">회원가입</a>&nbsp;
</c:if>
<c:if test="${!empty sessionScope.userName}">
            ${sessionScope.userName}님&nbsp;
            <a href="myPage.do">마이페이지</a>&nbsp;
	<a href="alert.do">알람</a>&nbsp;
	<a href="logout.do">로그아웃</a>&nbsp;
</c:if>
</head>
<body>
	<form action="payment.do" method="POST">
	 충전할 금액을 선택하세요
	<select name="pay">
		<option value="10000">10,000</option>
		<option value="20000">20,000</option>
		<option value="30000">30,000</option>
		<option value="50000">50,000</option>
		<option value="100000">100,000</option>
	</select>
	<input type="submit" value="충전하기">
	</form>
	<a href="myPage.do">뒤로가기</a>
</body>
</html>