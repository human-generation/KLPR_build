<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css"
        integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">

    <!-- fontawsome css-->
    <script src="https://kit.fontawesome.com/8b4a01720d.js" crossorigin="anonymous"></script>

    <!-- google font -->
    <link href="https://fonts.googleapis.com/css2?family=Jost:wght@300;400&display=swap" rel="stylesheet">

    <!--Date picker js-->
    <link rel="stylesheet" href="lightpick.css">


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
	<div class="container-fluid">

        <div class="jumbotron jumbotron-fluid">

            <div class="container text-center jt-text">
                <h1 class="display-4"><span class="logo-main">
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
                    </span></h1>
                <p class="lead">We are here When you need help!
                </p>
                <button type="button" class="btn helper-button-main btn-lg" onclick="location.href='getHelperList.do'">Searching for HELPER</button>
                <button type="button" class="btn helper-button-main btn-lg" onclick="location.href='getHelpeeList.do'">Searching for HELPEE</button>
            </div>
            <div class="waveWrapper waveAnimation">
                <div class="waveWrapperInner bgTop">
                    <div class="wave waveTop"
                        style="background-image: url('http://front-end-noobs.com/jecko/img/wave-top.png')">
                    </div>
                </div>
                <div class="waveWrapperInner bgMiddle">
                    <div class="wave waveMiddle"
                        style="background-image: url('http://front-end-noobs.com/jecko/img/wave-mid.png')">
                    </div>
                </div>
                <div class="waveWrapperInner bgBottom">
                    <div class="wave waveBottom"
                        style="background-image: url('http://front-end-noobs.com/jecko/img/wave-bot.png')">
                    </div>
                </div>
            </div>


        </div>




        <div id="carouselCaptions" class="carousel slide" data-ride="carousel">
            <ol class="carousel-indicators">
                <li data-target="#carouselCaptions" data-slide-to="0" class="active"></li>
                <li data-target="#carouselCaptions" data-slide-to="1"></li>
            </ol>
            <div class="carousel-inner">
                <div class="carousel-item active">
                    <img src="https://images.unsplash.com/photo-1589828994425-cee7c6e8dbf8?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=1086&q=80"
                        class="d-block w-100" alt="...">
                    <div class="carousel-caption ">
                        <h5>Get help, When you need it</h5>
                        <p>Nulla vitae elit libero, a pharetra augue mollis interdum.</p>
                    </div>
                </div>
                <div class="carousel-item">
                    <img src="https://images.unsplash.com/photo-1586726972122-f20f59d4bbb2?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=1050&q=80"
                        class="d-block w-100" alt="...">
                    <div class="carousel-caption">
                        <h5>First time user? Here is the guide for YOU!</h5>
                        <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit.</p>
                    </div>
                </div>
            </div>
            <a class="carousel-control-prev" href="#carouselCaptions" role="button" data-slide="prev">
                <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                <span class="sr-only">Previous</span>
            </a>
            <a class="carousel-control-next" href="#carouselCaptions" role="button" data-slide="next">
                <span class="carousel-control-next-icon" aria-hidden="true"></span>
                <span class="sr-only">Next</span>
            </a>
        </div>
    </div>

	<!--DS JS-->
	<section class="container ds-data-container">
        <div class="row align-items-center ">
            <div class="col-lg-6 ds-data1">

            </div>
            <div class="col-lg-6 ds-data2">

            </div>
        </div>
    </section>

	<!--RANKING-->
	<section class="container ranking-box-container">
        <div class="row align-items-center">
            <div class="col-md-4 ">
                <div class="card border-light">
                    <div class=" card-header">See Best Helpers! </div>
                    <div class="card-body">
                        <p class="card-text">

							<ul>						
						<c:forEach var="list" items="${RScoreTop5}">
							<li>${list.ranking} . ${list.name}</li>
						</c:forEach>
						</ul>
						</p>
					</div>
				</div>
			</div>
			<div class="col-md-4">
				<div class="card border-light">
					<div class=" card-header">See Most participated Helpers!</div>
					<div class="card-body">
						<p class="card-text">
						
						<ul>
						<c:forEach var="list" items="${RTop5}">
							<li>${list.ranking} .  ${list.name}</li>
						</c:forEach>	
						</ul>
						</p>
					</div>
				</div>
			</div>
			<div class="col-md-4">
				<div class="card border-light">
					<div class=" card-header">Someone needs a lot of help!</div>
					<div class="card-body">
						<p class="card-text">
						
						<ul>
						<c:forEach var="list" items="${ETop5}">
							<li>${list.ranking} .  ${list.name}</li>							
						</c:forEach>	
						</ul>
						</p>
					</div>
				</div>
			</div>
		</div>

	</section>
	<!--AUTH MODAL-->
	<!--LOGIN-->
	 <div class="modal fade" id="loginModal" tabindex="-1" role="dialog" aria-labelledby="loginModalLabel"
        aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="modalLabel">Login</h5>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
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
						<button type="submit" class="btn btn-primary">Login</button>
					</form>
					<hr>
					<h5>OR</h5>
					<div class="sns-login">
						<a class="btn btn-primary " href="#"><i class="fab fa-google"></i>
							Continue with Google</a>

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
						<button type="submit" class="btn btn-primary">Signup</button>
					</form>
					<hr>
					<h5>OR</h5>
					<div class="sns-login">
						<a class="btn btn-primary " href="#"><i class="fab fa-google"></i>
							Continue with Google</a>

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


        function check() {
            if (document.getElementById('signupPassword').value !==
                document.getElementById('passwordConfirm').value) {
                document.getElementById('message').innerHTML = "<div class='alert alert-danger mt-1' role='alert'>Password not matched</div>";
            }
        }

    </script>

</body>
</html>