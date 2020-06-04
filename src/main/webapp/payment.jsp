<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>충전 페이지</title>

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
	<form action="payment.do" method="POST">
		충전할 금액을 선택하세요 <select name="pay">
			<option value="10000">10,000</option>
			<option value="20000">20,000</option>
			<option value="30000">30,000</option>
			<option value="50000">50,000</option>
			<option value="100000">100,000</option>
		</select> <input type="submit" value="충전하기">
	</form>
	<a href="myPage.do">뒤로가기</a>
</body>
</html>