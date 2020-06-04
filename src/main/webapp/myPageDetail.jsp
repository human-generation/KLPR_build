<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">

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

<!-- custom css-->
<link rel="stylesheet" href="index.css">

<title>K:LPER | Get help in Korea</title>
</head>

<body>
	<nav id="mainNavbar" class="navbar navbar-expand-md navbar-dark py-1 fixed-top">
        <div class="container">
            <a href="main.do" class="navbar-brand">
                <span class="logo">
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
                        <rect class="cls-2" x="60.08" y="35.45" width="13" height="13.55" />
                        <rect class="cls-2" x="60.08" y="7" width="13" height="13.55" />
                    </svg>
                </span>
            </a>
		
		
		 <button class="navbar-toggler" data-toggle="collapse" data-target="#navLinks"
                aria-label="Toggle navigation">
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





	<div class="container myPageBoard">
		<div class="row">
			<div class="col-md-2 order-1 order-md-1">
				<div class="btn-group-vertical d-none d-md-block">
					<button type="button" class="btn btn-secondary helper-button"
						onclick="location.href='myPage.do'">My page</button>
					<button type="button" class="btn btn-secondary helper-button"
						onclick="location.href='incomingRequest.do'">요청내역</button>
					<button type="button" class="btn btn-secondary helper-button"
						onclick="location.href='myPageDetailProcess.do'">진행중내역</button>
					<button type="button" class="btn btn-secondary helper-button">이전내역</button>
					<button type="button" class="btn btn-secondary helper-button">나의정보수정</button>
				</div>
				<div class="btn-group d-md-none">
					<button type="button" class="btn btn-secondary helper-button"
						onclick="location.href='myPage.do'">My page</button>
					<button type="button" class="btn btn-secondary helper-button"
						onclick="location.href='incomingRequest.do'">요청내역</button>
					<button type="button" class="btn btn-secondary helper-button"
						onclick="location.href='myPageDetailProcess.do'">진행중내역</button>
					<button type="button" class="btn btn-secondary helper-button">이전내역</button>
					<button type="button" class="btn btn-secondary helper-button">나의정보수정</button>
				</div>
			</div>

			<div class="col-md-10 order-2 order-md-2">
				<div class="alert alert-primary" role="alert">{matching mno
					seno rcno mdate mplace 어떠한 요청글에 대답하였는가}</div>
				<div class="row media helperPost">
					<div class="col-md-3 order-1 order-md-1 align-items-center">
						<img class="mr-3"
							src="https://cdn.pixabay.com/photo/2013/10/28/19/23/cat-201969_960_720.jpg"
							alt="profileImage">
					</div>
					<div class="col-md-9 order-2 order-md-2">
						<div class="media-body">
							<a href="#" class="badge badge-primary helper-button-main">{mservice}
								이사</a> <a href="#" class="badge badge-primary helper-button-main">{mservice}
								병원</a>
							<div class="row">
								<div class="col-md-6 order-2 order-md-1">
									<h4>Doja Cat</h4>
								</div>
								<div class="col-md-6 order-1 order-md-2">
									<h5>{⭐️⭐️⭐️⭐️⭐️}</h5>
								</div>
							</div>
							<div class="row">
								<div class="col-sm-6 order-2 order-sm-1">
									<div class="lang">
										Language
										<c:forEach items="${matching_w.language}" var="language">${language} </c:forEach>
									</div>
									<div class="reviewNum">Total usage {rv_no}</div>

								</div>
								<div class="col-sm-6 order-1 order-sm-2">
									<div class="avDate">Available date {sta - end}</div>
									<div class="area">
										Placed in <i class="fas fa-map-marker-alt"></i>{rplace}
									</div>
								</div>
							</div>
							<div>
								{자기소개} hi I'm a cute cat. I'm useless other than being cute.

								<div class="boardReview">
									<ul class="list-group">
										<li class="list-group-item">리뷰가 들어갈 예정?</li>
										<li class="list-group-item">시간을 잘안지켜요</li>
										<li class="list-group-item">예의가 없어요</li>
										<li class="list-group-item">말을 못해요</li>
										<li class="list-group-item">잠만 자요</li>
									</ul>
								</div>
								<button type="button" class="btn btn-primary helper-button-main">수락하기</button>
								<button type="button" class="btn btn-primary helper-button-main">거절하기</button>
							</div>
						</div>
					</div>
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
					<form class="login-form" action="login.do">
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
						<button type="submit" class="btn btn-primary helper-button-main">Login</button>
					</form>
					<hr>
					<h5>OR</h5>
					<div class="sns-login">
						<a class="btn btn-primary helper-button-main " href="#"><i
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
					<form class="signup-form" action="singup.do">
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
						<button type="submit" class="btn btn-primary helper-button-main">Signup</button>
					</form>
					<hr>
					<h5>OR</h5>
					<div class="sns-login">
						<a class="btn btn-primary helper-button-main " href="#"><i
							class="fab fa-google"></i> Continue with Google</a>

					</div>

				</div>
			</div>
		</div>
	</div>

	<!--본문끝-->
	<!--FOOTER START-->

	<div class="container">
		<section class="footer">
			<div class="row">
				<div class="col-sm">
					<h5>내 계정</h5>
					<ul>
						<li><a class="footer-link" data-toggle="modal"
							data-target="#loginModal">로그인</a></li>
						<li><a class="footer-link" data-toggle="modal"
							data-target="#signupModal">회원가입</a></li>
					</ul>
				</div>
				<div class="col-sm">
					<h5>서비스</h5>
					<ul>
						<li><a class="footer-link" href="#">서비스 개요</a></li>
						<li><a class="footer-link" href="#">FAQ</a></li>
						<li><a class="footer-link" href="#">고객센터</a></li>
					</ul>
				</div>
				<div class="col-sm">
					<div>
						© 2020 Kelper LLC <br> <a class="footer-link" href="#">이용약관</a>
						| <a class="footer-link" href="#">개인정보처리방침</a>
					</div>

				</div>
			</div>

		</section>
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

		// dropdown
		function readMoreFunction() {
			var dots = document.getElementById("dots");
			var moreText = document.getElementById("more");
			var btnText = document.getElementById("myBtn");

			if (dots.style.display === "none") {
				dots.style.display = "inline";
				btnText.innerHTML = '<i class="fas fa-angle-down"></i>';
				moreText.style.display = "none";
			} else {
				dots.style.display = "none";
				btnText.innerHTML = '<i class="fas fa-angle-up"></i>';
				moreText.style.display = "inline";
			}
		}
	</script>


</body>

</html>