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
      <div class="row mypage-post">
        <div class="col-md-3 order-1 order-md-1 d-flex justify-content-center">
          <img class="profile-img-box" src="https://cdn.pixabay.com/photo/2013/10/28/19/23/cat-201969_960_720.jpg"
            alt="profileImage">
        </div>
        <div class="col-md-9 order-2 order-md-2">
          <div class="media-body">
            <div class="d-flex justify-content-between">
              <div class="sevice-tag-badge">
                <c:if test="${helper.moving==1}">
                  <span class="helper-badge">Moving</span>
                </c:if>
                <c:if test="${helper.hospital==1}">
                  <span class="helper-badge">Hospital</span>
                </c:if>
                <c:if test="${helper.immigration==1}">
                  <span class="helper-badge">Immigration</span>
                </c:if>
              </div>

            </div>


            <div class="row profile-box-header d-flex justify-content-between">
              <div class="col-6 ">
                <h3 class="helper-name-box">${helper.userVO.name}</h3>
              </div>
              <div class="col-6 d-flex flex-row-reverse">


                <!--if문 처리해서 헬퍼거래면 헬버버튼 헬피로 거래면 헬피버튼-->
                <div class="btn helper-button-main">
                  Helper
                </div>
                <div class="btn helpee-button-main">
                  Helpee
                </div>



              </div>
            </div>
            <div class="row profile-box-body">
              <div class="col-sm-6 order-2 order-sm-1 p-0">
                <div class="lang">
                  ${helper.languageVO.language}
                </div>
              </div>
              <div class="col-sm-6 order-1 order-sm-2 p-0">
                <div class="avDate">
                  Date
                </div>
                <div class="area">
                  Placed in <i class="fas fa-map-marker-alt"></i>${helper.seoulVO.district}
                </div>
              </div>
            </div>

            <div class="boardReview">
              남긴리뷰 별점
            </div>

          </div>


        </div>

      </div>

    </div>

  </div>






  <%@ include file="Footer.jsp"%>