<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>마이페이지</title>
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



	<center>마이 페이지 화면 입니다.</center>
</body>
</html>