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
					<c:if test="${matching_w.mservice ==1}">
						<td>-이사</td>
					</c:if>
					<c:if test="${matching_w.mservice ==2}">
						<td>-병원</td>
					</c:if>
					<c:if test="${matching_w.mservice ==3}">
						<td>-관공서</td>
					</c:if>
					<td>${matching_w.mplace }</td>
				</c:forEach>
			</tr>
			<tr>
				<th>결제완료</th>
				<c:forEach items="${PaidList}" var="matching_p">
					<td>${matching_p.receiverName }</td>
					<td>거래내역</td>
					<c:if test="${matching_p.mservice ==1}">
						<td>-이사</td>
					</c:if>
					<c:if test="${matching_p.mservice ==2}">
						<td>-병원</td>
					</c:if>
					<c:if test="${matching_p.mservice ==3}">
						<td>-관공서</td>
					</c:if>
					<td>${matching_p.mplace }</td>
				</c:forEach>
			</tr>
			<tr>
				<th>거래완료</th>
				<c:forEach items="${EndedList}" var="matching_e">
					<td>${matching_e.receiverName }</td>
					<td>거래내역</td>
					<c:if test="${matching_e.mservice ==1}">
						<td>-이사</td>
					</c:if>
					<c:if test="${matching_e.mservice ==2}">
						<td>-병원</td>
					</c:if>
					<c:if test="${matching_e.mservice ==3}">
						<td>-관공서</td>
					</c:if>
					<td>${matching_e.mplace }</td>
				</c:forEach>
			</tr>
		</table>
	</form>
</body>
</html>