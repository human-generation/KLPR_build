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
                        <input id="inputEmail" name="email" type="email" class="form-control" autocomplete="username"
                            required>
                    </div>
                    <div class="form-group">
                        <label for="inputPassword">Password</label>
                        <input id="inputPassword" name="pw" type="password" class="form-control"
                            autocomplete="current-password" required>
                    </div>
                    <div class="form-check d-flex justify-content-between my-2">
                        <input type="checkbox" class="form-check-input"> <label class="form-check-label"
                            for="logInCheck">Keep me logged
                            in </label> <a class="help-password " href="#">forgot your password?</a>
                    </div>
                    <button type="submit" class="btn helper-button-main">Login</button>
                </form>
                <hr>
                <h5>OR</h5>
                <div class="sns-login">
                    <a class="btn helper-button-main " href="#"><i class="fab fa-facebook"></i> Continue with
                        Facebook</a>

                </div>
            </div>
        </div>
    </div>
</div>


<!-- Chat popup -->



<div class="overlay-chat">

  <div class="chat-popup" id="myForm">
    <div class="chat-form-container">





      <div class="card chat-card">
        <div class="chat-card-header col-12 d-flex ">
          <div class="mr-auto p-2">Incoming Chat</div>
          <button type="button" class="btn chat-button-round p-2"><i class="fas fa-redo"></i></button>
          <button type="button" class="btn chat-button-round p-2" onclick="toggleChat()"><i
              class=" fas fa-times"></i></button>
        </div>





        <!--챗룸예시시작-->

        <div class="chat-room-list">
          <div class="row m-2 chat-room-indi">
            <div class="col-3 align-self-center d-flex">
              <img class="chat-img-box" src="https://cdn.pixabay.com/photo/2013/10/28/19/23/cat-201969_960_720.jpg"
                alt="profileImage" />
            </div>
            <div class="col-9">
              <h5>{상대방 유저}</h5>
              <div> 마지막메세지 </div>
              <div class="d-flex flex-row-reverse">
                메세지날짜
              </div>
            </div>
          </div>



          <div class="row m-2 chat-room-indi">
            <div class="col-3 align-self-center d-flex">
              <img class="chat-img-box" src="https://cdn.pixabay.com/photo/2013/10/28/19/23/cat-201969_960_720.jpg"
                alt="profileImage" />
            </div>
            <div class="col-9">
              <h5>{상대방 유저}</h5>
              <div> 마지막메세지 </div>
              <div class="d-flex flex-row-reverse">
                메세지날짜
              </div>
            </div>
          </div>





        <!--챗룸예시끝-->



      </div>

    </div>
  </div>
</div>


<!-- chat popup end -->


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
                    Â© 2020 Kelper LLC <br>
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



<!--API JS-->
<script src="./js/fbAuth.js"></script>
<script src="./js/ppPayment.js"></script>
<!-- costum Js -->
<script src="./js/app.js"></script>
<script src="./js/chat.js"></script>

</body>


</html>