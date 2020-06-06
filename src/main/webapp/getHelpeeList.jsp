<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css"
	integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk"
	crossorigin="anonymous">

<!-- fontawsome css-->
<script src="https://kit.fontawesome.com/8b4a01720d.js"
	crossorigin="anonymous"></script>

<!-- google font -->
<link
	href="https://fonts.googleapis.com/css2?family=Jost:wght@300;400&display=swap"
	rel="stylesheet">

<!--Date picker js-->
<link rel="stylesheet" href="lightpick.css">


<!-- custom css-->
<link rel="stylesheet" href="index.css">
<title>K:LPER | Get help in Korea</title>
</head>
<body>

	<nav id="mainNavbar"
		class="navbar navbar-expand-md navbar-dark py-1 fixed-top">
		<div class="container">
			<a href="main.do" class="navbar-brand"> <span class="logo">
					<svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 273.32 56.7">

                        <g class="cls-1">
                            <path class="cls-2"
							d="M.34.5h14V22.58L33.38.5H49.3L26.58,26.74,50.5,56.5H34.1L14.34,32V56.5H.34Z"
							transform="translate(-0.34 -0.5)" />
                        </g>
                        <polygon class="cls-2"
							points="85.07 0 98.76 0 98.76 44.87 121.52 44.87 121.52 56.7 85.07 56.7 85.07 0" />
                        <path class="cls-2"
							d="M128.18.5h19.69q10.84,0,16.44,4.94t5.59,13.61q0,8.58-5.59,13.57t-16.44,5h-6V57.2H128.18Zm19.69,11.26h-6v14.5h6a10.2,10.2,0,0,0,6.48-1.86,6.46,6.46,0,0,0,2.35-5.35,6.54,6.54,0,0,0-2.35-5.43A10.2,10.2,0,0,0,147.87,11.76Z"
							transform="translate(-0.34 -0.5)" />
                        <polygon class="cls-2"
							points="178.3 0 215.97 0 215.97 11.26 191.51 11.26 191.51 21.38 214.35 21.38 214.35 32.48 191.51 32.48 191.51 45.44 215.97 45.44 215.97 56.7 178.3 56.7 178.3 0" />
                        <path class="cls-2"
							d="M227.49.5h20.65Q259,.5,264.63,5.68a17.38,17.38,0,0,1,5.63,13.37,18.35,18.35,0,0,1-2.88,10.25,16.87,16.87,0,0,1-8.46,6.52L273.66,57.2H257.54L245.39,37.6h-4.21V57.2H227.49Zm19.68,11.66h-6V26.91h6A9.85,9.85,0,0,0,253.65,25,6.63,6.63,0,0,0,256,19.54a6.62,6.62,0,0,0-2.35-5.47A10,10,0,0,0,247.17,12.16Z"
							transform="translate(-0.34 -0.5)" />
                        <rect class="cls-2" x="60.08" y="35.45"
							width="13" height="13.55" />
                        <rect class="cls-2" x="60.08" y="7" width="13"
							height="13.55" />
                    </svg>
			</span>
			</a>


			<button class="navbar-toggler" data-toggle="collapse"
				data-target="#navLinks" aria-label="Toggle navigation">
				<i class="fas fa-align-right"></i>
			</button>
			<div class="collapse navbar-collapse" id="navLinks">
				<ul class="navbar-nav mr-auto">
					<li class="nav-item"><a href="getHelperList.do"
						class="nav-link">HELPER</a></li>
					<li class="nav-item"><a href="getHelpeeList.do"
						class="nav-link">HELPEE</a></li>
				</ul>

				<ul class="navbar-nav ml-auto">
					<c:if test="${empty sessionScope.userName}">
						<li class="nav-item"><a class="nav-link" data-toggle="modal"
							data-target="#loginModal">Login</a></li>
						<li class="nav-item"><a class="nav-link " data-toggle="modal"
							data-target="#signupModal">Signup</a></li>
					</c:if>
					<c:if test="${!empty sessionScope.userName}">
					${sessionScope.userName}님&nbsp;
					<li class="nav-item"><a class="nav-link" href="myPage.do">MyPage</a></li>
						<li class="nav-item"><a class="nav-link" href="logout.do">Logout</a></li>
					</c:if>
				</ul>
			</div>
	</nav>

	<!-- HEADER END -->
	<!-- 본문 -->


	<div class="jumbotron jumbotron-fluid">
		<div class="container jt-text">
			<h1 class="display-4 ">I need help!</h1>
			<p class="lead">Lorem ipsum dolor sit, amet consectetur
				adipisicing elit. Qui perferendis dignissimos aliquam. Eaque,
				inventore.</p>
			<div class="row float-right jt-btn m-1">
				<div class="dropdown">
					<button class="btn helper-button dropdown-toggle" type="button"
						id="dropdownAddr" data-toggle="dropdown" aria-haspopup="true"
						aria-expanded="false">I'm near..</button>
					<div class="dropdown-menu" aria-labelledby="dropdownAddr">
						<c:forEach items="${seoulList}" var="seoul">
							<button class="dropdown-item"
								onclick='location.href="seoulHelpeeList.do?eplace=${seoul.dno}";'
								type="button">${seoul.district}</button>
						</c:forEach>
					</div>
				</div>
				<div class="btn-group" role="group" aria-label="SortBtn">
					<button type="button" class="btn  helper-button btn-sm"
						onclick="location.href='recentHelpeeList.do'">최신순</button>
					<button type="button" class="btn  helper-button btn-sm" onclick="location.href='scoreHelpeeList.do'">평점순</button>
				</div>
			</div>
		</div>
	</div>

	<div class="container helperBoard">
		<div class="row">
			<div class="col-md-2 order-1 order-md-1 p-0 ">
				<div class="d-flex flex-column">
					<div class="btn-group-vertical d-none d-md-block service-tag-box">
						<button type="button" onclick="location.href='getHelpeeList.do'"
							class="btn btn-secondary helpee-button">All</button>
						<button type="button" onclick="location.href='moveHelpee.do'"
							class="btn btn-secondary helpee-button">이사</button>
						<button type="button" onclick="location.href='hospitalHelpee.do'"
							class="btn btn-secondary helpee-button">병원</button>
						<button type="button"
							onclick="location.href='immigrationHelpee.do'"
							class="btn btn-secondary helpee-button">출입국</button>
					</div>
					<div class="btn-group d-md-none mobile-service-tag-box">
						<button type="button" class="btn  helper-button">All</button>
						<button type="button" class="btn  helper-button">이사</button>
						<button type="button" class="btn  helper-button">병원</button>
						<button type="button" class="btn  helper-button">출입국</button>
					</div>

					<button type="button"
						class="btn  helper-button-main d-none d-md-block"
						onclick="location.href='helpeeWriteForm.do'">Pleas help
						me!</button>


				</div>

				<button type="button"
					class="btn  helper-button-main mobile-write-btn d-md-none"
					onclick="location.href='helpeeWriteForm.do'">
					<i class="fas fa-plus"></i>
				</button>
			</div>



			<div class="col-md-10 order-2 order-md-2">
				<input type="checkbox" class="read-more-state" id="post-1" />
				<c:forEach items="${helpeeList}" var="helpee">
					<div
						class="row media helperPost profile-box-container ml-md-1 read-more-wrap">
						<div
							class="col-md-3 order-1 order-md-1 d-flex justify-content-center">

							<img class="profile-img-box"
								src="https://cdn.pixabay.com/photo/2013/10/28/19/23/cat-201969_960_720.jpg"
								alt="profileImage">
						</div>
						<div class="col-md-9 order-2 order-md-2 d-flex">
							<div class="media-body float-left">
								<c:if test="${helpee.moving==1}">
									<a href="#" class="badge helper-button">이사</a>
								</c:if>
								<c:if test="${helpee.hospital==1}">
									<a href="#" class="badge helper-button">병원</a>
								</c:if>
								<c:if test="${helpee.immigration==1}">
									<a href="#" class="badge helper-button">출입국</a>
								</c:if>

								<c:if test="${helpee.userVO.uno == sessionScope.userNumber}">
									<form action="helpeeDelete.do" method="POST">
										<input name="eno" type="hidden" value="${helpee.eno}" />
										<button type="submit" class="read-more-trigger">Delete</button>
									</form>
									<form action="helpeeUpdate.do" method="GET">
										<input name="eno" type="hidden" value="${helpee.eno}" />
										<button type="submit" class="read-more-trigger">Update</button>
									</form>

								</c:if>

								<div
									class="row profile-box-header d-flex justify-content-between">
									<div class="col-6 ">
										<h3 class="name-box">${helpee.userVO.name}</h3>
									</div>
									<div class="col-6 d-flex flex-row-reverse">
										<h6 class=" star-rating">
											<c:forEach items="${avgList}" var="avgList">
												<c:choose>
													<c:when test="${avgList.eno == helpee.userVO.uno }">
												${avgList.e_avg } 																			
											</c:when>
												</c:choose>
											</c:forEach>
											⭐️⭐️⭐️⭐️⭐️
										</h6>

									</div>
								</div>
								<div class="row profile-box-body">
									<div class="col-sm-6 order-2 order-sm-1 p-0">
										<div class="lang">${helpee.languageVO.language}</div>
										<div class="reviewNum">
											리뷰갯수 :
											<c:forEach items="${countList }" var="countList">
												<c:choose>
													<c:when test="${countList.eno == helpee.userVO.uno }">
														${countList.count }
													</c:when>
												</c:choose>
											</c:forEach>
										</div>

									</div>
									<div class="col-sm-6 order-1 order-sm-2 p-0">
										<div class="avDate">Available date ${helpee.edate}</div>
										<div class="area">
											Placed in <i class="fas fa-map-marker-alt"></i>${helpee.seoulVO.district}
										</div>
									</div>
								</div>
								<div class="self-desc">
									${helpee.e_intro}
									<div class="d-flex justify-content-center">
										<label for="post-1" class="read-more-trigger">Read
											more</label>
									</div>
									<div class="read-more-target">
										<div class="boardReview">
											<div class="list-header">리뷰가 들어갈 예정?</div>
											<ul class="list-group">

												<li class="list-group-item">시간을 잘안지켜요</li>
												<li class="list-group-item">예의가 없어요</li>
												<li class="list-group-item">말을 못해요</li>
												<li class="list-group-item">잠만 자요</li>
											</ul>
										</div>
										<div class="d-flex justify-content-center">
											<form action="sendRequest.do" method="POST">
												<input name="seno" type="hidden"
													value="${sessionScope.userNumber}" /> <input name="rcno"
													type="hidden" value="${helpee.userVO.uno}" /> <input
													name="rno" type="hidden" value="${sessionScope.userNumber}" />
												<input name="eno" type="hidden" value="${helpee.userVO.uno}" />
												<input name="mdate" type="hidden" value="${helpee.edate}" />
												<input name="mplace" type="hidden"
													value="${helpee.seoulVO.dno}" />
												<c:if test="${helpee.moving==1}">
													<input name="mservice" type="hidden" value="1" />
												</c:if>
												<c:if test="${helpee.hospital==1}">
													<input name="mservice" type="hidden" value="2" />
												</c:if>
												<c:if test="${helpee.immigration==1}">
													<input name="mservice" type="hidden" value="3" />
												</c:if>
												<button type="submit" class="btn  helper-button-main">Send
													request</button>
											</form>
										</div>
									</div>
								</div>

							</div>

						</div>

					</div>
				</c:forEach>

				<!--PAGING -->
				<div class="row justify-content-center ">
					<nav aria-label="Page navigation">
						<div class="page">

							<button class="btn helper-button-page" href="#"
								aria-label="Previous">
								<i class="fas fa-chevron-left"></i>
							</button>

							<button class="btn helper-button-page" href="#" aria-label="Next">
								<i class="fas fa-chevron-right"></i>
							</button>

						</div>
					</nav>
				</div>
			</div>
		</div>
	</div>

	<!--AUTH MODAL-->
	<!--LOGIN-->
	<div class="modal fade" id="loginModal" tabindex="-1" role="dialog"
		aria-labelledby="loginModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="modalLabel">Login</h5>
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>

				<div class="modal-body">
					<form class="login-form" action="login.do" method="POST">
						<div class="form-group">
							<label for="inputEmail">Email address</label> <input name="email"
								type="email" class="form-control" required>
						</div>
						<div class="form-group">
							<label for="inputPassword">Password</label> <input name="pw"
								type="password" class="form-control" required>
						</div>
						<div class="form-check">
							<input type="checkbox" class="form-check-input"> <label
								class="form-check-label" for="logInCheck">Keep me logged
								in </label> <a class="help-password" href="#">forgot your password?</a>
						</div>
						<button type="submit" class="btn btn-primary helpee-button-main">Login</button>
					</form>
					<hr>
					<h5>OR</h5>
					<div class="sns-login">
						<a class="btn btn-primary helpee-button-main " href="#"><i
							class="fab fa-google"></i> Continue with Google </a>

					</div>
				</div>
			</div>
		</div>
	</div>




	<!--SIGNUP-->
	<div class="modal fade" id="signupModal" tabindex="-1" role="dialog"
		aria-labelledby="signupModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="modalLabel">Sign up</h5>
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>

				<div class="modal-body">
					<form class="signup-form" action="join.do" method="POST">
						<div class="form-group">
							<label for="signupEmail">Email address</label> <input
								name="email" type="email" class="form-control" required>
						</div>
						<div class="form-group">
							<label for="signupPassword">Password</label> <input name="pw"
								id="password" type="password" class="form-control" required>
						</div>
						<div class="form-group">
							<label for="PasswordConfirm">Password confirm</label> <input
								name="pw-confirm" id="password-confirm" type="password"
								class="form-control" required>
						</div>
						<div class="form-group">
							<label for="signupName">Name</label> <input name="name"
								type="text" class="form-control" required>
						</div>
						<div class="form-group">
							<label for="contactNumber">Contact number</label> <input
								name="phone" type="text" class="form-control" required>
						</div>
						<div class="form-group">
							<label for="gender">Are you..</label> <select name="gender"
								class="form-control" required>
								<option value="0">None of both</option>
								<option value="1">Female</option>
								<option value="2">Male</option>
							</select>
						</div>
						<button type="submit" class="btn btn-primary helpee-button-main">Signup</button>
					</form>
					<hr>
					<h5>OR</h5>
					<div class="sns-login">
						<a class="btn btn-primary helpee-button-main " href="#"><i
							class="fab fa-google"></i> Continue with Google</a>

					</div>

				</div>
			</div>
		</div>
	</div>

	<!--본문끝-->
	<!--FOOTER START-->

	<div class="container-fluid footer">
		<div class="container">
			<div class="row">
				<div class="col-sm">
					<h5>Account</h5>
					<ul>
						<li><a class="footer-link" data-toggle="modal"
							data-target="#loginModal">Login</a></li>
						<li><a class="footer-link" data-toggle="modal"
							data-target="#signupModal">Signup</a></li>
					</ul>
				</div>
				<div class="col-sm">
					<h5>Our service</h5>
					<ul>
						<li><a class="footer-link" href="#">What is K:lper?</a></li>
						<li><a class="footer-link" href="#">FAQ</a></li>
						<li><a class="footer-link" href="#">Customer Service</a></li>
					</ul>
				</div>
				<div class="col-sm">
					<div>
						© 2020 Kelper LLC <br> <a class="footer-link" href="#">Terms
							of Service</a> | <a class="footer-link" href="#">Privacy Policy</a>
					</div>

				</div>
			</div>

		</div>
	</div>


	<!-- Optional JavaScript -->
	<!-- jQuery first, then Popper.js, then Bootstrap JS -->
	<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"
		integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"
		integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo"
		crossorigin="anonymous"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"
		integrity="sha384-OgVRvuATP1z7JjHLkuOU7Xw704+h835Lr+6QL9UvYjZE3Ipu6Tp75j7Bh/kR0JKI"
		crossorigin="anonymous"></script>

	<!-- Moment Js -->
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.22.2/moment.min.js"></script>
	<script src="https://unpkg.com/lightpick@latest/lightpick.js"></script>

	<!-- custom js 추후 분리할것임-->
	<script>
		// navbar
		$(function() {
			$(document).scroll(
					function() {
						var $nav = $("#mainNavbar");
						$nav.toggleClass("scrolled", $(this).scrollTop() > $nav
								.height());
					});
		});

		const readBtn = document.querySelector(".read-more-trigger");
		readBtn.addEventListener('click', function(e) {
			if (readBtn.textContent === 'Read more') {

				readBtn.innerText = "Read less";
			} else if (readBtn.textContent === 'Read less') {
				readBtn.innerText = "Read more";

			}
		});

		var picker = new Lightpick({
			field : document.getElementById('datepicker'),
			singleDate : false,
			selectForward : true,
			onSelect : function(start, end) {
				var str = '';
				var str2 = '';
				str += start ? start.format('DD-MM-YYYY') + '' : '';
				str2 += end ? end.format('DD-MM-YYYY') : '...';
				document.getElementById('date-result-start').innerHTML = str;
				document.getElementById('date-result-start').value = str;
				document.getElementById('date-result-end').innerHTML = str2;
				document.getElementById('date-result-end').value = str2;
			}
		});
	</script>

</body>
</html>