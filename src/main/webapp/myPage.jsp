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
    <link rel="stylesheet" href="./css/sgintro.css">
    <link rel="stylesheet" href="./css/sgbasic.css">
    <link rel="stylesheet" href="https://indestructibletype.com/fonts/Jost.css" type="text/css" charset="utf-8" />
    <link href="https://fonts.googleapis.com/css2?family=Roboto:wght@300;400;500&display=swap" rel="stylesheet">
    <title>K:LPER | Get help in Korea</title>
</head>
<body>
	<nav id="mainNavbar" class="navbar navbar-expand-md navbar-dark py-1 fixed-top">
        <div class="container">
            <a href="main.do" class="navbar-brand"></a>
		
		
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
		</div>
	</nav>
	

	<!-- HEADER END -->
	<!-- 본문 -->




 <div class="post_sg">
        <div class="container myPageBoard">
            <div class="row">
                <div class="menubar col-md-2 order-1 order-md-1">
                    <div class="btn-group-vertical d-none d-md-block">
                        <button type="button" class="btn  helper-button" onclick="location.href='myPage.do'">My page</button>
                        <button type="button" class="btn  helper-button" onclick="location.href='incomingRequest.do'">View all requests</button>
                        <button type="button" class="btn  helper-button" onclick="location.href='myPageDetailProcess.do'">Pending requests</button>
                        <button type="button" class="btn  helper-button">History</button>
                        <button type="button" class="btn  helper-button">Edit my info</button>
                    </div>
                    <div class="btn-group d-md-none">
                        <button type="button" class="btn  helper-button" onclick="location.href='myPage.do'">My page</button>
                        <button type="button" class="btn  helper-button" onclick="location.href='incomingRequest.do'">View all requests</button>
                        <button type="button" class="btn  helper-button" onclick="location.href='myPageDetailProcess.do'">Pending requests</button>
                        <button type="button" class="btn  helper-button">History</button>
                        <button type="button" class="btn  helper-button">Edit my info</button>
                    </div>
                </div>
                
                
                <div class="post col-md-10 order-2 order-md-2">
                    <div class="jumbotron myPageJt">
                        <div class="container">
                            <div class="col pic">
                                <div class="propic">
                                </div>
                            </div>
                            <div class="col info">
                                <div class="row">
                                    <span class="glyphicon glyphicon-edit" aria-hidden="true"></span>
                                    <em>My information</em>
                                    <strong>${sessionScope.userName }</strong>
                                    <button type="button" class="btn helper-button btn-lg tag">HELPER</button>
                                    <b>${sessionScope.userGender } | Review 5.0 | 정보끌어오기</b>
                                    <em>My Wallet</em>
                                    <s>${sessionScope.userMoney }<em>won</em></s>
                                    <button type="button" class="btn  helper-button btn-lg charge" onclick="location.href='payment.do'">CHARGE</button>
                                </div>
                            </div>    
                        </div>
                    </div>
                    
                    
                    
                     <div class="cardsg row">
                        <div class="col-md-6 col-lg-3">
                            <div class="card">
                                <div class="card-body">
                                    <h5 class="card-title">Applying</h5>
                                    <p class="card-text">Transactions<br>spending approval</p>
                                    <a href="incomingRequest.do" class="btn btn-sm helpee-button-main"><!--{mstate 0}-->${mstate0}</a><a href="incomingRequest.do"
                                        class="btn btn-sm helper-button-main"><!--{mstate 1}-->${mstate1}</a>
                                </div>
                            </div>
                        </div>
                        <div class="col-md-6 col-lg-3">
                            <div class="card">
                                <div class="card-body">
                                    <h5 class="card-title">Waiting<br>payment</h5>
                                    <p class="card-text">Waiting payment</p>
                                    <a href="myPageDetailProcess.do" class="btn btn-sm helpee-button-main"><!--거래{mstate 2}-->${mstate2}</a>
                                </div>
                            </div>
                        </div>
                        <div class="col-md-6 col-lg-3">
                            <div class="card">
                                <div class="card-body">
                                    <h5 class="card-title">Completed<br>payment</h5>
                                    <p class="card-text">Waiting for service</p>
                                    <a href="myPageDetailProcess.do" class="btn btn-sm helpee-button-main"><!--거래 {mstate3}-->${mstate3}</a>
                                </div>
                            </div>
                        </div>
                        <div class="col-md-6 col-lg-3">
                            <div class="card">
                                <div class="card-body lastcard">
                                    <h5 class="card-title">Completed<br>deal</h5>
                                    <p class="card-text">waiting for review</p>
                                    <a href="myPageDetailProcess.do" class="btn btn-sm helpee-button-main"><!--<!--리뷰작성후 거래완료{mstate4, 5}-->${mstate4}</a>
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
					<form class="login-form" action="login.do" method="post">
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
					<form class="signup-form" action="join.do" method="post">
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
	</div>

	<!--본문끝-->
	<!--FOOTER START-->

	<div class="container-fluid footer">
        <div class="container">
            <div class="row">
                <div class="col-sm">
                    <h5>Account</h5>
                    <ul>
                        <li><a class="footer-link" data-toggle="modal" data-target="#loginModal">Login</a>
                        </li>
                        <li><a class="footer-link" data-toggle="modal" data-target="#signupModal">Signup</a>
                        </li>
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
                        © 2020 Kelper LLC <br>
                        <a class="footer-link" href="#">Terms of Service</a> | <a class="footer-link" href="#">Privacy
                            Policy</a>
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
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"
        integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo"
        crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"
        integrity="sha384-OgVRvuATP1z7JjHLkuOU7Xw704+h835Lr+6QL9UvYjZE3Ipu6Tp75j7Bh/kR0JKI"
        crossorigin="anonymous"></script>

    <!-- Moment Js -->
    <script src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.22.2/moment.min.js"></script>
    <script src="https://unpkg.com/lightpick@latest/lightpick.js"></script>

    <!-- custom js 추후 분리할것임-->
    <script>

        // navbar
        $(function () {
            $(document).scroll(function () {
                var $nav = $("#mainNavbar");
                $nav.toggleClass("scrolled", $(this).scrollTop() > $nav.height());
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
     
        function check() {
            if (document.getElementById('signupPassword').value !==
                document.getElementById('passwordConfirm').value) {
                document.getElementById('message').innerHTML = "<div class='alert alert-danger mt-1' role='alert'>Password not matched</div>";
            }
        }

    </script>
</body>
</html>