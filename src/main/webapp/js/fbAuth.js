
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
    if (!response || response.error) {
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

