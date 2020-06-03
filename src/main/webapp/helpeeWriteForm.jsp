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

            <a href="#" class="navbar-brand">
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



    <div class="container">
        <div class="row writeForm ">
            <div class="col-md-3 order-1 order-md-1 d-flex justify-content-center">
                <img class="profile-img-box" src="https://cdn.pixabay.com/photo/2013/10/28/19/23/cat-201969_960_720.jpg"
                    alt="profileImage">
            </div>
            <div class="col-md-9 order-2 order-md-2">
                <div class="media-body">
                    <div class="row">
                        <div class="col-md-6">
                            <h3 class="name-box">${sessionScope.userName}&nbsp;</h3>
                        </div>
                        <div class="col-md-6 d-flex flex-row-reverse">
                             ${sessionScope.userGender}&nbsp;
                        </div>
                    </div>
                    <div class="writeFormContainer">
                        <div>
                           ${sessionScope.userPhone}&nbsp;
                        </div>
                        <div>
                            {ucomment}
                        </div>
                    </div>
                    <form autocomplete="off" class="helper-write-form"  action="helpeeWriteForm.do" method="post">
                        <div class="row">
                            <div class="col-md-6 my-1">
                            <input name="uno" type="hidden" value="${sessionScope.userNumber}"/>
                                <input name="edate" id="date-result" type="hidden"></input>
                                <input type="text" id="datepicker2" class="form-control"
                                    placeholder="Select available date">
                            </div>
                            <div class="col-md-6 my-1">
                                <select class="custom-select" name="lno">
                                    <option selected>Choose your language</option>
                               		<c:forEach items="${languageList}" var="language">
                                    <option value="${language.lno}">${language.language}</option>
                                    </c:forEach>
                                </select>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-md-6 my-1">
                                <select class="custom-select" name="rplace">
                                    <option selected>Choose your area</option>
                                   <c:forEach items="${seoulList}" var="seoul">
										<option value="${seoul.dno}">${seoul.district}</option>
									</c:forEach>
                                </select>
                            </div>
                            <div class="col-md-6 d-flex flex-column my-1">

                                <div class="btn-group btn-group-toggle" data-toggle="buttons">
                                    <label class="btn btn-secondary checkbox-btn">
                                        <input name="moving" type="checkbox" class="service" value="1" autocomplete="off"> moving
                                    </label>
                                    <label class="btn btn-secondary checkbox-btn">
                                        <input name="hospital" type="checkbox" class="service" value="1" autocomplete="off"> hospital
                                    </label>
                                    <label class="btn btn-secondary checkbox-btn">
                                        <input name="immigration" type="checkbox" class="service" value="1" autocomplete="off"> immigration
                                    </label>
                                </div>
                            </div>
                        </div>
                        <div class="form-group my-3">
                            <label for="detailReview">Additional Infomation</label>
                            <textarea id="detailReview" name="e_intro" class="form-control form-control-write"
                                rows="5"></textarea>
                        </div>
                        <button type="submit" class="btn btn-primary helper-button-main">Submit!</button>
                    </form>
                </div>

            </div>

        </div>
    </div>


    </div>

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
                            <label for="inputEmail">Email address</label>
                            <input id="inputEmail" name="email" type="email" class="form-control" required>
                        </div>
                        <div class="form-group">
                            <label for="inputPassword">Password</label>
                            <input id="inputPassword" name="pw" type="password" class="form-control" required>
                        </div>
                        <div class="form-check">
                            <input type="checkbox" id="logInCheck" class="form-check-input">
                            <label class="form-check-label" for="logInCheck">Keep me logged in </label>
                            <a class="help-password" href="#">forgot your password?</a>
                        </div>
                        <button type="submit" class="btn helper-button-main">Login</button>
                    </form>
                    <hr>
                    <h5>OR</h5>
                    <div class="sns-login">
                        <a class="btn helper-button-main " href="#"><i class="fab fa-google"></i> Continue with
                            Google</a>

                    </div>
                </div>
            </div>
        </div>
    </div>

    <!--SIGNUP-->
    <div class="modal fade" id="signupModal" tabindex="-1" role="dialog" aria-labelledby="signupModalLabel"
        aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="modalLabel">Sign up</h5>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>

                <div class="modal-body">
                    <form class="signup-form" action="join.do" method="post">
                        <div class="form-group">
                            <label for="signupEmail">Email address</label>
                            <input name="email" id="signupEmail" type="email" class="form-control" required>
                        </div>
                        <div class="form-group">
                            <label for="signupPassword">Password</label>
                            <input name="pw" id="signupPassword" type="password" class="form-control" required>
                        </div>
                        <div class="form-group">
                            <label for="passwordConfirm">Password confirm</label>
                            <input name="pw-confirm" id="passwordConfirm" type="password" class="form-control" required>
                        </div>
                        <div class="form-group">
                            <label for="signupName">Name</label>
                            <input name="name" id="signupName" type="text" class="form-control" required>
                        </div>
                        <div class="form-group">
                            <label for="contactNumber">Contact number</label>
                            <input name="phone" id="contactNumber" type="text" class="form-control" required>
                        </div>
                        <div class="form-group">
                            <label for="gender">Are you..</label>
                            <select id="gender" name="gender" class="form-control" required>
                                <option value="0">None of both</option>
                                <option value="1">Female</option>
                                <option value="2">Male</option>
                            </select>
                        </div>
                        <button type="submit" class="btn helper-button-main">Signup</button>
                    </form>
                    <hr>
                    <h5>OR</h5>
                    <div class="sns-login">
                        <a class="btn helper-button-main " href="#"><i class="fab fa-google"></i> Continue with
                            Google</a>

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


        // const readBtn = document.querySelector(".read-more-trigger");
        // readBtn.addEventListener('click', function (e) {
        //     if (readBtn.textContent === 'Read more') {

        //         readBtn.innerText = "Read less";
        //     }
        //     else if (readBtn.textContent === 'Read less') {
        //         readBtn.innerText = "Read more";

        //     }
        // });


        // var staEndPicker = new Lightpick({
        //     field: document.getElementById('datepicker1'),
        //     singleDate: false,
        //     selectForward: true,
        //     onSelect: function (start, end) {
        //         var str = '';
        //         var str2 = '';
        //         str += start ? start.format('DD-MM-YYYY') + '' : '';
        //         str2 += end ? end.format('DD-MM-YYYY') : '...';
        //         document.getElementById('date-result-start').innerHTML = str;
        //         document.getElementById('date-result-start').value = str;
        //         document.getElementById('date-result-end').innerHTML = str2;
        //         document.getElementById('date-result-end').value = str2;
        //     }
        // });

        var datePicker = new Lightpick({
            field: document.getElementById('datepicker2'),
            singleDate: true,
            selectForward: true,
            onSelect: function (start, end) {
                var str = '';
                str += start ? start.format('DD-MM-YYYY') + '' : '';
                document.getElementById('date-result').innerHTML = str;
                document.getElementById('date-result').value = str;

            }
        });
        
     // service 선택(이사, 병원, 출입국사무소)
		$('button').click(function(){
			inputs = $('.service');
			inputs.each(function(){
				var value;
				if($(this).attr('type') === 'checkbox'){
					value = $(this).is(':checked')? 1:0;
				}
			});
		});

    </script>

</body>
</html>