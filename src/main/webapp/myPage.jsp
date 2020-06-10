<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<<<<<<< HEAD
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="true" %>
<!doctype html>
<html lang="en">

<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css"
        integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">

    <!-- fontawsome css-->
    <script src="https://kit.fontawesome.com/8b4a01720d.js" crossorigin="anonymous"></script>

    <!-- custom css-->
    <link rel="stylesheet" href="index.css">

    <title>K:LPER | Get help in Korea</title>
    <a href="summary.do">서비스개요</a> &nbsp;
<a href="faq.do">FAQ</a> &nbsp;
<a href="main.do">로고</a> &nbsp;
<c:if test="${empty sessionScope.userName}">
	<a href="login.do">로그인</a>&nbsp;
	<a href="join.do">회원가입</a>&nbsp;
</c:if>
<c:if test="${!empty sessionScope.userName}">
            ${sessionScope.userName}님&nbsp;
            <a href="myPage.do">마이페이지</a>&nbsp;
	<a href="alert.do">알람</a>&nbsp;
	<a href="logout.do">로그아웃</a>&nbsp;
</c:if>
</head>

<body>

    <nav id="mainNavbar" class="navbar navbar-expand-md navbar-dark py-1 fixed-top">
        <a href="#" class="navbar-brand">K:LPER</a>
        <button class="navbar-toggler" data-toggle="collapse" data-target="#navLinks" aria-label="Toggle navigation">
            <i class="fas fa-align-right"></i>
        </button>
        <div class="collapse navbar-collapse" id="navLinks">
            <ul class="navbar-nav mr-auto">
                <li class="nav-item">
                    <a href="" class="nav-link">HELPER</a>
                </li>
                <li class="nav-item">
                    <a href="" class="nav-link">HELPEE</a>
                </li>
            </ul>
            <ul class="navbar-nav ml-auto">
                <li class="nav-item">
                    <a class="nav-link" data-toggle="modal" data-target="#loginModal">Login</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link " data-toggle="modal" data-target="#signupModal">Signup</a>
                </li>
            </ul>
        </div>
    </nav>

    <!-- HEADER END -->
    <!-- 본문 -->





    <div class="container myPageBoard">
        <div class="row">
            <div class="col-md-2 order-1 order-md-1">
                <div class="btn-group-vertical d-none d-md-block">
                    <button type="button" class="btn btn-secondary helper-button" onclick="location.href='myPage.do'">My page</button>
                    <button type="button" class="btn btn-secondary helper-button" onclick="location.href='incomingRequest.do'">요청내역</button>
                    <button type="button" class="btn btn-secondary helper-button" onclick="location.href='ongoing.do'">진행중내역</button>
                    <button type="button" class="btn btn-secondary helper-button">이전내역</button>
                    <button type="button" class="btn btn-secondary helper-button">나의정보수정</button>
                </div>
                <div class="btn-group d-md-none">
                    <button type="button" class="btn btn-secondary helper-button" onclick="location.href='myPage.do'">My page</button>
                    <button type="button" class="btn btn-secondary helper-button" onclick="location.href='incomingRequest.do'">요청내역</button>
                    <button type="button" class="btn btn-secondary helper-button" onclick="location.href='ongoing.do'">진행중내역</button>
                    <button type="button" class="btn btn-secondary helper-button">이전내역</button>
                    <button type="button" class="btn btn-secondary helper-button">나의정보수정</button>
                </div>
            </div>

            <div class="col-md-10 order-2 order-md-2">
                <div class="jumbotron myPageJt">
                    <div class="container">
                        <h1 class="display-4">My Wallet</h1>
                        <p class="lead">Lorem ipsum dolor sit, amet consectetur adipisicing elit. Qui perferendis
                            dignissimos
                            aliquam. Eaque, inventore.
                        </p>

                        <div class="row float-right">
                            <button type="button" class="btn btn-secondary helper-button btn-lg" onclick="location.href='payment.do'">마일리지 충전</button>

                            <button type="button" class="btn btn-secondary helper-button btn-lg">${sessionScope.userMoney }$</button>
                        </div>

                    </div>
                </div>
                <div class="row">
                    <div class="col-md-6 col-lg-3">
                        <div class="card">
                            <div class="card-body">
                                <h5 class="card-title">신청중</h5>
                                <p class="card-text">승인을 기다리고 있는 거래</p>
                                <a href="incomingRequest.do" class="btn btn-primary btn-sm helper-button-main">${mstate0}</a><a href="#"
                                    class="btn btn-primary btn-sm helpee-button-main">${mstate1}</a>
                            </div>
                        </div>
                    </div>
                    <div class="col-md-6 col-lg-3">
                        <div class="card">
                            <div class="card-body">
                                <h5 class="card-title">결제대기</h5>
                                <p class="card-text">결제를 기다리고 있는 거래</p>
                                <a href="#" class="btn btn-primary btn-sm helpee-button-main">${mstate2}</a>
                            </div>
                        </div>
                    </div>
                    <div class="col-md-6 col-lg-3">
                        <div class="card">
                            <div class="card-body">
                                <h5 class="card-title">결제완료</h5>
                                <p class="card-text">결제완료 서비스대기중</p>
                                <a href="#" class="btn btn-primary btn-sm helpee-button-main">${mstate3}</a>
                            </div>
                        </div>
                    </div>
                    <div class="col-md-6 col-lg-3">
                        <div class="card">
                            <div class="card-body">
                                <h5 class="card-title">거래완료</h5>
                                <p class="card-text">리뷰작성대기중</p>
                                <a href="#" class="btn btn-primary btn-sm helpee-button-main">${mstate4}</a>
                            </div>
                        </div>
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
                    <form class="login-form" action="login.do">
                        <div class="form-group">
                            <label for="inputEmail">Email address</label>
                            <input name="email" type="email" class="form-control" required>
                        </div>
                        <div class="form-group">
                            <label for="inputPassword">Password</label>
                            <input name="pw" type="password" class="form-control" required>
                        </div>
                        <div class="form-check">
                            <input type="checkbox" class="form-check-input">
                            <label class="form-check-label" for="logInCheck">Keep me logged in </label>
                            <a class="help-password" href="#">forgot your password?</a>
                        </div>
                        <button type="submit" class="btn btn-primary helper-button-main">Login</button>
                    </form>
                    <hr>
                    <h5>OR</h5>
                    <div class="sns-login">
                        <a class="btn btn-primary helper-button-main " href="#"><i class="fab fa-google"></i>
                            Continue with
                            Google
                        </a>

                    </div>
                </div>
            </div>
        </div>
    </div>
=======
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
                    <button type="button" class="btn mypage-button"
                        onclick="location.href='myPageDetailProcess.do'">Pending
                        requests</button>
                    <button type="button" class="btn mypage-button">History</button>
                    <button type="button" class="btn mypage-button">Edit my info</button>
                </div>


                <div class="btn-group mypage-menu d-md-none">
                    <button type="button" class="btn mypage-button" onclick="location.href='myPage.do'">My
                        page</button>
                    <button type="button" class="btn mypage-button"
                        onclick="location.href='incomingRequest.do'">Requests</button>
                    <button type="button" class="btn mypage-button"
                        onclick="location.href='myPageDetailProcess.do'">Pending</button>
                    <button type="button" class="btn mypage-button">History</button>
                    <button type="button" class="btn mypage-button">Edit Info</button>
                </div>

            </div>
        </div>





        <div class="col-md-9 order-2 order-md-2">

            <div class="row mypage-post mx-1">


                <div class="col-md-3 order-1 order-md-1 d-flex justify-content-center">
                    <img class="profile-img-box"
                        src="https://cdn.pixabay.com/photo/2013/10/28/19/23/cat-201969_960_720.jpg" alt="profileImage">
                </div>


                <div class="col-md-9 order-2 order-md-2">
                    <div class="row">

                        <div class="col-md-6">
                            <div class="helper-name-box mt-2">
                                <c:forEach items="${helperCountList}" var="helperCount">
                                    <c:if test="${helperCount.rno == sessionScope.userNumber }">
                                        <c:if test="${helperCount.count > 0}">
                                            <span class="helper-badge">HELPER</span>
                                        </c:if>
                                    </c:if>
                                </c:forEach>
                                <c:forEach items="${helpeeCountList }" var="helpeeCount">
                                    <c:if test="${helpeeCount.eno == sessionScope.userNumber }">
                                        <c:if test="${helpeeCount.count > 0}">
                                            <span class="helpee-badge">HELPEE</span>
                                        </c:if>
                                    </c:if>
                                </c:forEach>
                                <h3>${sessionScope.userName}</h3>
                            </div>
                        </div>

                        <div class="col-md-6">
                            <div class="float-right">Review 5.0</div>
                        </div>
                    </div>

                    <div class="row">
                        <div class="col-md-4">
                            My Wallet
                        </div>
                        <div class="col-md-8 wallet-box">
                            ${sessionScope.userMoney} WON

                            <button type="button" class="btn charge" onclick="location.href='payment.do'">CHARGE
                            </button>
                            <button type="button" class="btn charge" onclick="location.href='#'">See all charge history
                            </button>
                        </div>

                    </div>

                </div>
            </div>
>>>>>>> 515d5c339444b02052b07005f33f665bb56e3aac




<<<<<<< HEAD
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
                    <form class="signup-form" action="singup.do">
                        <div class="form-group">
                            <label for="signupEmail">Email address</label>
                            <input name="email" type="email" class="form-control" required>
                        </div>
                        <div class="form-group">
                            <label for="signupPassword">Password</label>
                            <input name="pw" id="password" type="password" class="form-control" required>
                        </div>
                        <div class="form-group">
                            <label for="PasswordConfirm">Password confirm</label>
                            <input name="pw-confirm" id="password-confirm" type="password" class="form-control"
                                required>
                        </div>
                        <div class="form-group">
                            <label for="signupName">Name</label>
                            <input name="name" type="text" class="form-control" required>
                        </div>
                        <div class="form-group">
                            <label for="contactNumber">Contact number</label>
                            <input name="phone" type="text" class="form-control" required>
                        </div>
                        <div class="form-group">
                            <label for="gender">Are you..</label>
                            <select name="gender" class="form-control" required>
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
                        <a class="btn btn-primary helper-button-main " href="#"><i class="fab fa-google"></i> Continue
                            with
                            Google</a>

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
                        <li><a class="footer-link" data-toggle="modal" data-target="#loginModal">로그인</a>
                        </li>
                        <li><a class="footer-link" data-toggle="modal" data-target="#signupModal">회원가입</a>
                        </li>
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
                        © 2020 Kelper LLC <br>
                        <a class="footer-link" href="#">이용약관</a> | <a class="footer-link" href="#">개인정보처리방침</a>
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
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"
        integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo"
        crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"
        integrity="sha384-OgVRvuATP1z7JjHLkuOU7Xw704+h835Lr+6QL9UvYjZE3Ipu6Tp75j7Bh/kR0JKI"
        crossorigin="anonymous"></script>

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


    </script>


</body>

</html>


<!-- 
	<a href="myPage.do">마이페이지</a>
	<br>
	<a href="payment.do">결제</a>
	<a>나의 잔액 </a>${sessionScope.userMoney }원
 -->
=======


            <div class="row">
                <div class="col-md-6 col-lg-3">
                    <div class="mypage-process">
                        <div class="mypage-process-body">
                            <h5 class="mypage-process-title">Applying</h5>
                            <p class="mypage-process-text">Transactions<br>spending approval</p>
                            <a href="incomingRequest.do" class="btn  mypage-button-helpee-round">
                                <!--{mstate 0}-->${mstate0}</a><a href="incomingRequest.do"
                                class="btn mypage-button-round">
                                <!--{mstate 1}-->${mstate1}</a>
                        </div>
                    </div>
                </div>
                <div class="col-md-6 col-lg-3">
                    <div class="mypage-process">
                        <div class="mypage-process-body">
                            <h5 class="mypage-process-title">Waiting<br>payment</h5>
                            <p class="mypage-process-text">Waiting payment</p>
                            <a href="myPageDetailProcess.do" class="btn  mypage-button-round">
                                <!--거래{mstate 2}-->${mstate2}</a>
                        </div>
                    </div>
                </div>
                <div class="col-md-6 col-lg-3">
                    <div class="mypage-process">
                        <div class="mypage-process-body">
                            <h5 class="mypage-process-title">Completed<br>payment</h5>
                            <p class="mypage-process-text">Waiting for service</p>
                            <a href="myPageDetailProcess.do" class="btn  mypage-button-round">
                                <!--거래 {mstate3}-->${mstate3}</a>
                        </div>
                    </div>
                </div>
                <div class="col-md-6 col-lg-3">
                    <div class="mypage-process">
                        <div class="mypage-process-body lastmypage-process">
                            <h5 class="mypage-process-title">Completed<br>deal</h5>
                            <p class="mypage-process-text">waiting for review</p>
                            <a href="myPageDetailProcess.do" class="btn mypage-button-round">
                                <!--<!--리뷰작성후 거래완료{mstate4, 5}-->${mstate4}</a>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>




<%@ include file="Footer.jsp"%>
>>>>>>> 515d5c339444b02052b07005f33f665bb56e3aac
