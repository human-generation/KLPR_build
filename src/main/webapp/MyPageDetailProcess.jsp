<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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

<!-- custom css-->
<link rel="stylesheet" href="index.css">

<title>K:LPER | Get help in Korea</title>
</head>
<body>
	<nav id="mainNavbar"
		class="navbar navbar-expand-md navbar-dark py-1 fixed-top">
		<a href="#" class="navbar-brand">K:LPER</a>
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





	<div class="container myPageBoard">
		<div class="row">
			<div class="col-md-2 order-1 order-md-1">
				<div class="btn-group-vertical d-none d-md-block">
					<button type="button" class="btn btn-secondary helper-button">My
						page</button>
					<button type="button" class="btn btn-secondary helper-button">요청내역</button>
					<button type="button" class="btn btn-secondary helper-button"
						onclick="location.href='myPageDetailProcess.do'">진행중내역</button>
					<button type="button" class="btn btn-secondary helper-button">이전내역</button>
					<button type="button" class="btn btn-secondary helper-button">나의정보수정</button>
				</div>
				<div class="btn-group d-md-none">
					<button type="button" class="btn btn-secondary helper-button">My
						page</button>
					<button type="button" class="btn btn-secondary helper-button">요청내역</button>
					<button type="button" class="btn btn-secondary helper-button">진행중내역</button>
					<button type="button" class="btn btn-secondary helper-button">이전내역</button>
					<button type="button" class="btn btn-secondary helper-button">나의정보수정</button>
				</div>
			</div>

			<div class="col-md-10 order-2 order-md-2">
				<div class="row">
					<div class="col-lg-4">
						<div class="card">
							<h4 class="card-header">결제대기</h4>
							<div class="card-body">
								<div class="card">
									<h6 class="card-header">거래자명</h6>
									<div class="card-body">

										<img class="mr-3"
											src="https://cdn.pixabay.com/photo/2013/10/28/19/23/cat-201969_960_720.jpg"
											alt="profileImage">
										<p class="card-text">
											<a href="#" class="badge badge-primary helpee-button-main">이사</a>
											<a href="#" class="badge badge-primary helpee-button-main">병원</a>
										<div class="lang">Language {language}</div>
										<div class="reviewNum">Total usage {rv_no}</div>
										<div class="avDate">Available date {sta - end}</div>
										<div class="area">
											Placed in <i class="fas fa-map-marker-alt"></i>{rplace}
										</div>
										</p>
										<a href="#" class="btn btn-primary">결제하기</a>
									</div>
								</div>
							</div>
						</div>
					</div>
					<div class="col-lg-4">
						<div class="card">
							<h4 class="card-header">결제완료</h4>
							<div class="card-body">
								<div class="card">
									<h6 class="card-header">거래자명</h6>
									<div class="card-body">

										<img class="mr-3"
											src="https://cdn.pixabay.com/photo/2013/10/28/19/23/cat-201969_960_720.jpg"
											alt="profileImage">
										<p class="card-text">
											<a href="#" class="badge badge-primary helpee-button-main">이사</a>
											<a href="#" class="badge badge-primary helpee-button-main">병원</a>
										<div class="lang">Language {language}</div>
										<div class="reviewNum">Total usage {rv_no}</div>
										<div class="avDate">Available date {sta - end}</div>
										<div class="area">
											Placed in <i class="fas fa-map-marker-alt"></i>{rplace}
										</div>
										</p>
										<a href="#" class="btn btn-primary">대화하기</a>
									</div>
								</div>
							</div>
						</div>
					</div>
					<div class="col-lg-4">
						<div class="card">
							<h4 class="card-header">거래완료</h4>
							<div class="card-body">
								<div class="card">
									<h6 class="card-header">거래자명</h6>
									<div class="card-body">

										<img class="mr-3"
											src="https://cdn.pixabay.com/photo/2013/10/28/19/23/cat-201969_960_720.jpg"
											alt="profileImage">
										<p class="card-text">
											<a href="#" class="badge badge-primary helpee-button-main">이사</a>
											<a href="#" class="badge badge-primary helpee-button-main">병원</a>
										<div class="lang">Language {language}</div>
										<div class="reviewNum">Total usage {rv_no}</div>
										<div class="avDate">Available date {sta - end}</div>
										<div class="area">
											Placed in <i class="fas fa-map-marker-alt"></i>{rplace}
										</div>
										</p>
										<a href="#" class="btn btn-primary" data-toggle="modal"
											data-target="#reviewModal">리뷰작성후 거래완료</a>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>





	<!-- Additional Review Modal-->
	<div class="modal fade" id="reviewModal" tabindex="-1" role="dialog"
		aria-labelledby="reviewModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="modalLabel">Reivew</h5>
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>

				<div class="modal-body">
					<form class="review-form" action="insertE_Review.do" method="POST">
						<div class="row">
							<div class="col-5">
								<img class="mr-3"
									src="https://cdn.pixabay.com/photo/2013/10/28/19/23/cat-201969_960_720.jpg"
									alt="profileImage">
							</div>
							<div class="col-7">
								<div class="media-body">
									<a href="#" class="badge badge-primary helpee-button-main">이사</a>
									<a href="#" class="badge badge-primary helpee-button-main">병원</a>
									<h4>Doja Cat</h4>
									<div class="btn">{mdate}</div>
								</div>

							</div>
						</div>
						<input type="hidden" name="rno" class="form-control"
							value="${sessionScope.userNumber}" />
						<div class="form-group">
							<label for="reviewScore">평점남기기</label> <select name="escore"
								class="form-control" required>
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

						<button type="submit" class="btn btn-primary helper-button-main">Submit
							your review!</button>
					</form>

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