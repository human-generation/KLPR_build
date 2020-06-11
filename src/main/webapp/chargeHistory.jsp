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

        <!--차징내역-->
        결제일자
        결제비용
        결제방식



      </div>

    </div>

  </div>



  <%@ include file="Footer.jsp"%>