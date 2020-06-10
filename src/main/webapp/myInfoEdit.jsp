<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
          <button type="button" class="btn mypage-button" onclick="location.href='myPageDetailProcess.do'">Pending
            requests</button>
          <button type="button" class="btn mypage-button">History</button>
          <button type="button" class="btn mypage-button">Edit my info</button>
        </div>


        <div class="btn-group mypage-menu d-md-none">
          <button type="button" class="btn mypage-button" onclick="location.href='myPage.do'">My
            page</button>
          <button type="button" class="btn mypage-button" onclick="location.href='incomingRequest.do'">Requests</button>
          <button type="button" class="btn mypage-button"
            onclick="location.href='myPageDetailProcess.do'">Pending</button>
          <button type="button" class="btn mypage-button">History</button>
          <button type="button" class="btn mypage-button">Edit Info</button>
        </div>

      </div>
    </div>



    <div class="col-md-9 order-2 order-md-2">
      <div class="row mypage-post mx-1">
        <div class="col-12">
          <form class="signup-form" action="join.do" method="post"></form>
          <div class="input-group d-flex justify-content-center">
            <div id="image_container"></div>
            <div class="col-12 my-3">
              <div class="custom-file">
                <input type="file" class="custom-file-input" id="inputGroupFile01 image" accept="image/*"
                  onchange="setThumbnail(event);" aria-describedby="inputGroupFileAddon01" />
                <label class="custom-file-label" for="inputGroupFile01">Add your picture</label>
              </div>
            </div>
          </div>

          <h3 class="name-box">{user email}</h3>


          <div class="form-group">
            <label for="signupPassword">Password</label>
            <input name="pw" id="signupPassword" type="password" class="form-control" autocomplete="new-password"
              required>
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
          <div class="form-group">
            <label for="FormDesc">디비 자기소개 불러오세요</label>
            <textarea name="ucomment" class="form-control form-desc" id="FormDesc" rows="4"></textarea>
          </div>
          <button type="submit" class="btn helper-button-main">Save update</button>
          </form>

        </div>
      </div>
    </div>
  </div>





  <%@ include file="Footer.jsp"%>