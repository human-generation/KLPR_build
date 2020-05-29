<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="ongoing.do" method="POST">
		<table>
			<tr>
				<th>결제대기</th>
				<c:forEach items="${WaitingList}" var="matching_w">
					<td>${matching_w.senderName }</td>
					<td>거래내역</td>
					<td>${matching_w.mservice }</td>
					<td>${matching_w.mplace }</td>
				</c:forEach>
			</tr>
			<tr>
				<th>결제완료</th>
				<c:forEach items="${PaidList}" var="matching_p">
					<td>${matching_p.receiverName }</td>
					<td>거래내역</td>
					<td>${matching_p.mservice }</td>
					<td>${matching_p.mplace }</td>
				</c:forEach>
			</tr>
			<tr>
				<th>거래완료</th>
				<c:forEach items="${EndedList}" var="matching_e">
					<td>${matching_e.receiverName }</td>
					<td>거래내역</td>
					<td>${matching_e.mservice }</td>
					<td>${matching_e.mplace }</td>
				</c:forEach>
			</tr>
		</table>
	</form>
</body>
</html>