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

			<div class="row">



				<div class="col-lg-4">
					<div class="mypage-post">


						<h4 class="mypage-process-header">Payment waiting </h4>
						<c:forEach items="${WaitingList}" var="matching_w">
							<div class="mypage-process-body">


								<div class="mypage-process">
									<c:choose>
										<c:when test="${matching_w.rcno eq loginUser.uno }">
											<h6 class="h-name">${matching_w.senderName }</h6>
										</c:when>
										<c:when test="${matching_w.seno eq loginUser.uno }">
											<h6 class="h-name">${matching_w.receiverName }</h6>
										</c:when>
									</c:choose>
									<div class="h-body">
										<img class="profile-img-box"
											src="https://cdn.pixabay.com/photo/2013/10/28/19/23/cat-201969_960_720.jpg" alt="profileImage">

										<p class="mypage-process-text">
											<c:if test="${matching_w.mservice ==1}">
												<td><a href="#" class="helper-badge">Moving/a></td>
											</c:if>
											<c:if test="${matching_w.mservice ==2}">
												<td><a href="#" class="helper-badge">Hospital</a></td>
											</c:if>
											<c:if test="${matching_w.mservice ==3}">
												<td><a href="#" class="helper-badge">Immigration</a></td>
											</c:if>
										<div class="avDate">Available date<br> ${matching_w.mdate}</div>
										<div class="area">
											Placed in <i class="fas fa-map-marker-alt"></i>${matching_w.mplaceName }
										</div>
										</p>
										<!-- 이아래문장을 폼으로감싸서 submit하기 -->
										<form action="updateState.do" method="POST">
											<c:if test="${loginUser.uno eq matching_w.eno }">
												<input type="hidden" name="mstate" value="${matching_w.mstate}">
												<input type="hidden" name="mno" value="${matching_w.mno }">
												<button type="submit" class="btn service-helper-button">Checkout</button>
											</c:if>
										</form>
									</div>
								</div>
							</div>
						</c:forEach>
					</div>
				</div>





				<div class="col-lg-4">
					<div class="mypage-post">
						<h4 class="mypage-process-header">Completed payment</h4>
						<c:forEach items="${PaidList}" var="matching_p">
							<div class="mypage-process-body">
								<div class="mypage-process">
									<c:choose>
										<c:when test="${matching_p.rcno eq loginUser.uno }">
											<h6 class="h-name">${matching_p.senderName }</h6>
										</c:when>
										<c:when test="${matching_p.seno eq loginUser.uno }">
											<h6 class="h-name">${matching_p.receiverName }</h6>
										</c:when>
									</c:choose>
									<div class="h-body">

										<img class="profile-img-box"
											src="https://cdn.pixabay.com/photo/2013/10/28/19/23/cat-201969_960_720.jpg" alt="profileImage">
										<p class="mypage-process-text">
											<c:if test="${matching_p.mservice ==1}">
												<td><a href="#" class="helper-badge">이사</a></td>
											</c:if>
											<c:if test="${matching_p.mservice ==2}">
												<td><a href="#" class="helper-badge">병원</a></td>
											</c:if>
											<c:if test="${matching_p.mservice ==3}">
												<td><a href="#" class="helper-badge">관공서</a></td>
											</c:if>
										<div class="avDate">Available date<br> ${matching_p.mdate}</div>
										<div class="area">
											Placed in <i class="fas fa-map-marker-alt"></i>${matching_p.mplaceName }
										</div>
										</p>
										<c:choose>
										<c:when test="${matching_p.rno eq loginUser.uno}">
										<a href="helperMsg.do" class="btn service-helper-button">Send Message[여기]</a>
										</c:when>
										<c:when test="${matching_p.eno eq loginUser.uno}">
										<a href="helpeeMsg.do" class="btn service-helper-button">Send Message[저기]</a>
										</c:when>
										</c:choose>

									</div>
								</div>
							</div>
						</c:forEach>
					</div>
				</div>



				<div class="col-lg-4">
					<div class="mypage-post">
						<h4 class="mypage-process-header">Completed deal</h4>
						<c:forEach items="${EndedList}" var="matching_e">
							<div class="mypage-process-body">
								<div class="mypage-process">
									<c:choose>
										<c:when test="${matching_e.rcno eq loginUser.uno }">
											<h6 class="h-name">${matching_e.senderName }</h6>
										</c:when>
										<c:when test="${matching_e.seno eq loginUser.uno }">
											<h6 class="h-name">${matching_e.receiverName }</h6>
										</c:when>
									</c:choose>
									<div class="h-body">

										<img class="profile-img-box"
											src="https://cdn.pixabay.com/photo/2013/10/28/19/23/cat-201969_960_720.jpg" alt="profileImage">
										<p class="mypage-process-text">
											<c:if test="${matching_e.mservice ==1}">
												<td><a href="#" class="bhelper-badge">이사</a></td>
											</c:if>
											<c:if test="${matching_e.mservice ==2}">
												<td><a href="#" class="helper-badge">병원</a></td>
											</c:if>
											<c:if test="${matching_e.mservice ==3}">
												<td><a href="#" class="helper-badge">관공서</a></td>
											</c:if>

										<div class="avDate">Available date<br> ${matching_e.mdate}</div>
										<div class="area">
											Placed in <i class="fas fa-map-marker-alt"></i>${matching_e.mplaceName }
										</div>
										</p>
										<c:choose>
											<c:when test="${matching_e.eno == loginUser.uno }">
												<a href="updateState.do" class="btn service-helper-button" data-toggle="modal"
													data-target="#reviewModalr" href="r_review.do">리뷰작성후 거래완료</a>
											</c:when>
											<c:otherwise>
												<a href="updateState.do" class="btn service-helper-button" data-toggle="modal"
													data-target="#reviewModale" href="insertE_Review.do">리뷰작성후 거래완료</a>
											</c:otherwise>
										</c:choose>
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
</div>



<!-- Additional Review Modal HELPEEE-->
<div class="modal fade" id="reviewModale" tabindex="-1" role="dialog" aria-labelledby="reviewModalLabel"
	aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<h5 class="modal-title" id="modalLabel">Reivew</h5>
				<button type="button" class="close" data-dismiss="modal" aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
			</div>

			<div class="modal-body">
				<form class="review-form" action="insertE_Review.do" method="POST">
					<div class="row">
						<div class="col-5">
							<img class="profile-img-box" src="https://cdn.pixabay.com/photo/2013/10/28/19/23/cat-201969_960_720.jpg"
								alt="profileImage">
						</div>
						<div class="col-7">
							<div class="media-body">
								<a href="#" class="helpee-badge">이사</a>
								<a href="#" class="helpee-badge">병원</a>
								<a href="#" class="helpee-badge">출입국</a>
								<h4>${sessionScope.userName }</h4>
								<div class="btn">{mdate}</div>
							</div>

						</div>
					</div>
					<input type="hidden" name="rno" class="form-control" value="${sessionScope.userNumber}" />
					<div class="form-group">
						<label for="reviewScore">평점남기기</label> <select name="escore" class="form-control" required>
							<option value="5">5</option>
							<option value="4">4</option>
							<option value="3">3</option>
							<option value="2">2</option>
							<option value="1">1</option>
						</select>
					</div>
					<div class="form-group">
						<label for="detailReview">Review your match</label>
						<textarea name="ecomment" class="form-control" rows="3"></textarea>
					</div>

					<button type="submit" class="btn service-helpee-button">Submit
						your review!</button>
				</form>
			</div>
		</div>
	</div>
</div>


<!-- Additional Review Modal HELPER-->
<div class="modal fade" id="reviewModalr" tabindex="-1" role="dialog" aria-labelledby="reviewModalLabel"
	aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<h5 class="modal-title" id="modalLabel">Reivew</h5>
				<button type="button" class="close" data-dismiss="modal" aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
			</div>

			<div class="modal-body">
				<form class="review-form" action="r_review.do" method="POST">
					<div class="row">
						<div class="col-5">
							<img class="profile-img-box" src="https://cdn.pixabay.com/photo/2013/10/28/19/23/cat-201969_960_720.jpg"
								alt="profileImage">
						</div>
						<div class="col-7">
							<div class="media-body">
								<a href="#" class="helper-badge">이사</a>
								<a href="#" class="helper-badge">병원</a>
								<a href="#" class="helper-badge">출입국</a>
								<h4>${sessionScope.userName }</h4>
								<div class="btn">{mdate}</div>
							</div>
						</div>
					</div>
					<div class="form-group">
						<label for="reviewScore">평점남기기</label> <select name="rscore" class="form-control" required>
							<option value="5">5</option>
							<option value="4">4</option>
							<option value="3">3</option>
							<option value="2">2</option>
							<option value="1">1</option>
						</select>
					</div>
					<input type="hidden" name="uno" value="${sessionScope.userNumber}" />
					<div class="form-group">
						<label for="detailReview">Review your match</label>
						<textarea name="rcomment" class="form-control" rows="3"></textarea>
					</div>

					<button type="submit" class="btn service-helper-button">Submit
						your review!</button>
				</form>

			</div>
		</div>
	</div>
</div>

<%@ include file="Footer.jsp"%>