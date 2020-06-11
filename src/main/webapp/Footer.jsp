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
                        <input name="email" id="signupEmail" type="email" class="form-control" autocomplete="username"
                            required>
                    </div>
                    <div class="form-group">
                        <label for="signupPassword">Password</label>
                        <input name="pw" id="signupPassword" type="password" class="form-control"
                            autocomplete="new-password" required>
                    </div>
                    <div class="form-group">
                        <label for="passwordConfirm">Password confirm</label>
                        <input name="pw-confirm" id="passwordConfirm" type="password" class="form-control"
                            autocomplete="new-password" required>
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


                <!-- 페이스북 처리부분 미완성입니다 -->
                <div class="sns-login">
                    <div class="fb-login-button" data-size="large" data-button-type="continue_with"
                        data-layout="rounded" data-auto-logout-link="false" data-use-continue-as="false" data-width=""
                        scope="public_profile,email" onlogin="checkLoginState();"></div>

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



<!--API JS-->
<script src="./js/fbAuth.js"></script>
<script src="./js/ppPayment.js"></script>
<!-- costum Js -->
<script src="./js/app.js"></script>

</body>


</html>