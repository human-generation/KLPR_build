<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
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
  <link href="https://fonts.googleapis.com/css2?family=Jost:wght@300;400,600&display=swap" rel="stylesheet">

  <!--Date picker js-->
  <link rel="stylesheet" href="./css/lightpick.css">

  <!-- custom css-->
  <link rel="stylesheet" href="./css/index.css">

  <title>K:LPER | Get help in Korea</title>
</head>

<body>


  <!-- 페이스북 로그인기능 미완성입니다 -->
  <div id="fb-root"></div>
  <script async defer crossorigin="anonymous"
    src="https://connect.facebook.net/en_US/sdk.js#xfbml=1&version=v7.0&appId=467025024116470&autoLogAppEvents=1"></script>
  <script>
    window.fbAsyncInit = function () {
      FB.init({
        appId: '467025024116470',
        cookie: true,
        xfbml: true,
        version: 'v7.0'
      });

      FB.getLoginStatus(function (response) {
        statusChangeCallback(response);
      });

    };

    (function (d, s, id) {
      var js, fjs = d.getElementsByTagName(s)[0];
      if (d.getElementById(id)) { return; }
      js = d.createElement(s); js.id = id;
      js.src = "https://connect.facebook.net/en_US/sdk.js";
      fjs.parentNode.insertBefore(js, fjs);
    }(document, 'script', 'facebook-jssdk'));


    function statusChangeCallback(response) {
      if (response.status === 'connected') {
        console.log('logged in');
        setFBButton(true);
        testAPI();
      } else {
        console.log('not auth');
        setFBButton(false);
      }
    }

    function checkLoginState() {
      FB.getLoginStatus(function (response) {
        statusChangeCallback(response);
      });
    }


    function testAPI() {
      FB.api('me?fields=id,name,email', function (response) {
    	  
    	  //페북회원리스트에 없으면 에러 메인으로 돌아감 & 알러트
    	  if(!response || response.error){
    		  alert('We can not find your Facebook login data');
    		  window.location.href = 'main.jsp';
    		  
    	  }
    		  
    	  // 페북회원리스트에 있음
    	  else if (response && !response.error) {
        	
        	//여기서 우리 디비에 가입된 정보인지 이메일 체크필요 
        	//코드
        	
        	// 우리 회원일지 로그인 처리후 메인
        	//코드
        	
        	//우리 회원목록에 없으면 회원 가입 페이지
          window.location.href = 'fbSignin.jsp';
          buildProfile(response);
          
        }
      });
    }

    //인풋 플레이스 홀더랑 발류로 넣는거 고려
    function buildProfile(user) {
      let profile = `
            <form class="signup-form" action="join.do" method="post">
            <div
			class="col-md-3 order-1 order-md-1 d-flex justify-content-center">

			<img class="profile-img-box"
				src="https://graph.facebook.com/${user.id}/picture?type=large"
				alt="profileImage">
		</div>
        <div class="form-group">
          <label for="signupEmail">Email address</label>
          <input name="email" id="signupEmail" type="email" class="form-control" autocomplete="username" value="${user.email}" required>
                        </div>
              <div class="form-group">
                <label for="signupName">Name</label>
                <input name="name" id="signupName" type="text" class="form-control" value="${user.name}" required>
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
      `;





      document.getElementById('profile').innerHTML = profile;
    }

    function setFBButton(isLoggedin) {
      if (isLoggedin) {
        document.getElementById('profile').style.display = 'block';
        document.getElementById('heading').style.display = 'none';
      } else {
        document.getElementById('profile').style.display = 'none';
        document.getElementById('heading').style.display = 'block';
      }
    }


  </script>







  <div class="main-body">
    <nav id="mainNavbar" class="navbar navbar-expand-md navbar-dark py-1 fixed-top">
      <div class="container">
        <a href="main" class="navbar-brand">
          <span class="logo">
            <svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 273.32 56.7">

              <g class="cls-1">
                <path class="cls-2" d="M.34.5h14V22.58L33.38.5H49.3L26.58,26.74,50.5,56.5H34.1L14.34,32V56.5H.34Z"
                  transform="translate(-0.34 -0.5)" />
              </g>
              <polygon class="cls-2" points="85.07 0 98.76 0 98.76 44.87 121.52 44.87 121.52 56.7 85.07 56.7 85.07 0" />
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


        <button class="navbar-toggler" data-toggle="collapse" data-target="#navLinks" aria-label="Toggle navigation">
          <i class="fas fa-align-right"></i>
        </button>
        <div class="collapse navbar-collapse" id="navLinks">
          <ul class="navbar-nav mr-auto">
            <li class="nav-item"><a href="getHelperList.do" class="nav-link">HELPER</a></li>
            <li class="nav-item"><a href="getHelpeeList.do" class="nav-link">HELPEE</a></li>
          </ul>

          <ul class="navbar-nav ml-auto">
            <c:if test="${empty sessionScope.userName}">
              <li class="nav-item"><a class="nav-link" data-toggle="modal" data-target="#loginModal">Login</a></li>
              <li class="nav-item"><a class="nav-link " data-toggle="modal" data-target="#signupModal">Signup</a></li>
            </c:if>
            <c:if test="${!empty sessionScope.userName}">
              <li class="nav-item"><a class="nav-link" href="myPage.do"><i class="fas fa-grin-hearts"></i> ${sessionScope.userName}</a></li>
              <li class="nav-item"><a class="nav-link" href="###"> <i class="fas fa-comments"></i></a></li>
              <li class="nav-item"><a class="nav-link" href="logout"> Logout</a></li>
            </c:if>
          </ul>
        </div>
    </nav>

    <!-- HEADER END -->