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
	<form action="incomingRequest.do" method="POST">
		<h4></h4>
		<table>
			<tr>
				<th>들어온 요청</th>
				<c:forEach items="${ReceivedRequestList}" var="matching_r">
					<td>${matching_r.senderName }</td>
					<td>거래내역</td>
					<c:if test="${matching_r.mservice ==1}">
						<td>-이사</td>
					</c:if>
					<c:if test="${matching_r.mservice ==2}">
						<td>-병원</td>
					</c:if>
					<c:if test="${matching_r.mservice ==3}">
						<td>-관공서</td>
					</c:if>
					<td>${matching_r.mplace }</td>
				</c:forEach>
			</tr>
			<tr>
				<th>보낸 요청</th>
				<c:forEach items="${SendedRequestList}" var="matching_s">

					<td>${matching_s.receiverName }</td>
					<td>거래내역</td>
					<c:if test="${matching_s.mservice ==1}">
						<td>-이사</td>
					</c:if>
					<c:if test="${matching_s.mservice ==2}">
						<td>-병원</td>
					</c:if>
					<c:if test="${matching_s.mservice ==3}">
						<td>-관공서</td>
					</c:if>
					<td>${matching_s.mplace }</td>

				</c:forEach>
			</tr>
		</table>
	</form>
</body>
</html>