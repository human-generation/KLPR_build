<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="Header.jsp"%>
<!-- 본문 -->

<div class="mypage-board container">
	<div class="row">

		<div class="col-md-3 order-1 order-md-1">

			<div class="d-flex flex-column">
				<div class="btn-group-vertical mypage-menu d-none d-md-block">
					<button type="button" class="btn mypage-button" onclick="location.href='myPage.do'">My
						page</button>
					<button type="button" class="btn mypage-button" onclick="location.href='incomingRequest.do'">View
						all requests</button>
					<button type="button" class="btn mypage-button" onclick="location.href='myPageDetailProcess.do'">Pending
						requests</button>
					<button type="button" class="btn mypage-button">History</button>
					<button type="button" class="btn mypage-button">Edit my info</button>
				</div>


				<div class="btn-group mypage-menu d-md-none">
					<button type="button" class="btn mypage-button" onclick="location.href='myPage.do'">My
						page</button>
					<button type="button" class="btn mypage-button" onclick="location.href='incomingRequest.do'">Requests</button>
					<button type="button" class="btn mypage-button"
						onclick="location.href='myPageDetailProcess.do'">Pending</button>
					<button type="button" class="btn mypage-button">History</button>
					<button type="button" class="btn mypage-button">Edit Info</button>
				</div>

			</div>
		</div>



		<div class="col-md-9 order-2 order-md-2">

			<div class="row ml-md-1">
				<div class="col-md-6">
					<div class="mypage-post">
						<h4 class="mypage-process-header">신청한 요청</h4>
						<c:forEach items="${SendedRequestList}" var="matching_s">
							<div class="mypage-process-body">





								<div class="mypage-process">
									<h6 class="helpee-name-box">
										<c:if test="${loginUser.name eq matching_s.senderName }">
											<h5 class="helpee-name-box">${matching_s.receiverName}</h5>
										</c:if>
										<c:if test="${loginUser.name eq matching_s.receiverName }">
											<h5 class="helpee-name-box">${matching_s.senderName}</h5>
										</c:if>
									</h6>
									<div class="h-body">
										<img class="profile-img-box"
											src="https://cdn.pixabay.com/photo/2013/10/28/19/23/cat-201969_960_720.jpg" alt="profileImage">
										<p class="mypage-process-text">
											<c:if test="${matching_s.mservice ==1}">
												<td><a href="#" class="helpee-badge">Moving</a></td>
											</c:if>
											<c:if test="${matching_s.mservice ==2}">
												<td><a href="#" class="helpee-badge">Hospital</a></td>
											</c:if>
											<c:if test="${matching_s.mservice ==3}">
												<td><a href="#" class="helpee-badge">Immigration</a></td>
											</c:if>
										<div class="avDate">Available date <br> ${matching_s.mdate}</div>
										<div class="area">
											Placed in <i class="fas fa-map-marker-alt"></i>${matching_s.mplaceName }
										</div>
										</p>
										<div class="mypage-button-box">
											<a href="#" class="btn service-helpee-button">
												Awaiting confirm

											</a>
											<a href="#" class="btn service-helpee-button mt-1">
												View detail
											</a>
										</div>
									</div>
								</div>
							</div>
						</c:forEach>
					</div>
				</div>


				<div class="col-md-6">
					<div class="mypage-post">
						<h4 class="mypage-process-header">들어온 요청</h4>
						<c:forEach items="${ReceivedRequestList}" var="matching_r">
							<div class="mypage-process-body">
								<div class="mypage-process">
									<h6 class="helper-name-box">
										<c:if test="${loginUser.name eq matching_r.senderName }">
											<h5 class="helper-name-box">
												${matching_r.receiverName }
											</h5>
										</c:if>
										<c:if test="${loginUser.name eq matching_r.receiverName }">
											<h5 class="helper-name-box">
												${matching_r.senderName }
											</h5>
										</c:if>
									</h6>
									<div class="h-body">

										<img class="profile-img-box"
											src="https://cdn.pixabay.com/photo/2013/10/28/19/23/cat-201969_960_720.jpg" alt="profileImage">
										<p class="mypage-process-text">
											<c:if test="${matching_r.mservice ==1}">
												<td><a href="#" class="helper-badge">이사</a></td>
											</c:if>
											<c:if test="${matching_r.mservice ==2}">
												<td><a href="#" class="helper-badge">병원</a></td>
											</c:if>
											<c:if test="${matching_r.mservice ==3}">
												<td><a href="#" class="helper-badge">관공서</a></td>
											</c:if>
										<div class="avDate">Available date<br> ${matching_r.mdate}</div>
										<div class="area">
											Placed in <i class="fas fa-map-marker-alt"></i>${matching_r.mplaceName }
										</div>
										</p>

										<div class="mypage-button-box">
											<form action="updateState.do" method="POST">
												<input type="hidden" name="mstate" value="${matching_r.mstate}">
												<input type="hidden" name="mno" value="${matching_r.mno }">
												<button type="submit" class="btn service-helper-button ">Confirm offer</button>
											</form>
											<a href="#" class="btn service-helper-button mt-1">View Detail</a>
										</div>


									</div>
								</div>
							</div>
						</c:forEach>
					</div>
				</div>
			</div>

		</div>
	</div>
</div>



<%@ include file="Footer.jsp"%>