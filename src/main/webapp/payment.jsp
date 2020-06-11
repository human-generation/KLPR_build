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
            <div class="row mypage-post mx-1 col-12 align-item-center">
                <div class="col-12 align-item-center">
                    <div class="form-group">
                        <label for="price">price</label>
                        <select id="price" name="price" class="form-control">
                            <option value="10">10</option>
                            <option value="20">20</option>
                            <option value="30">30</option>
                        </select>
                    </div>
                    <div id="paypal-button-container">
                        <!--페이팔 버튼-->
                    </div>
                    <div id="success">
                        <!-- 거래 완료후 정보내역-->
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>



<%@ include file="Footer.jsp"%>