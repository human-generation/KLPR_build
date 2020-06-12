<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="Header.jsp"%>
<!-- 본문 -->


<div class="jumbotron jumbotron-fluid">
    <div class="container jt-text">
        <h1 class="display-4 ">I can help you!</h1>
        <p class="lead">Lorem ipsum dolor sit, amet consectetur adipisicing elit. Qui perferendis dignissimos
            aliquam. Eaque, inventore.</p>
        <div class="row float-right jt-btn m-1">


            <div class="dropdown">
                <button class="btn helper-button dropdown-toggle" type="button" id="dropdownAddr" data-toggle="dropdown"
                    aria-haspopup="true" aria-expanded="false">
                    I'm near..
                </button>

                <div class="dropdown-menu" aria-labelledby="dropdownAddr">
                    <c:forEach items="${seoulList}" var="seoul">
                        <button class="dropdown-item" onclick='location.href="seoulHelperList.do?rplace=${seoul.dno}";'
                            type="button">${seoul.district}</button>
                    </c:forEach>
                </div>
            </div>
            <div class="btn-group" role="group" aria-label="SortBtn">
                <button type="button" class="btn  helper-button btn-sm"
                    onclick="location.href='recentHelperList.do'">Newest</button>
                <button type="button" class="btn  helper-button btn-sm"
                    onclick="location.href='scoreHelperList.do'">Review Rating</button>
            </div>
        </div>
    </div>
</div>

<div class="container helperBoard">
    <div class="row">
        <div class="col-md-2 order-1 order-md-1 p-0 ">
            <div class="d-flex flex-column">
                <div class="btn-group-vertical d-none d-md-block service-tag-box">
                    <button type="button" onclick="location.href='getHelperList.do'"
                        class="btn service-helper-button">All</button>
                    <button type="button" onclick="location.href='moveHelper.do'"
                        class="btn service-helper-button">Moving</button>
                    <button type="button" onclick="location.href='hospitalHelper.do'"
                        class="btn service-helper-button">Hospital</button>
                    <button type="button" onclick="location.href='immigrationHelper.do'"
                        class="btn service-helper-button">Immigration</button>
                </div>
                <div class="btn-group d-md-none mobile-service-tag-box">
                    <button type="button" onclick="location.href='getHelperList.do'"
                        class="btn helper-button">All</button>
                    <button type="button" onclick="location.href='moveHelper.do'"
                        class="btn helper-button">Moving</button>
                    <button type="button" onclick="location.href='hospitalHelper.do'"
                        class="btn helper-button">Hospital</button>
                    <button type="button" class="btn  helper-button">Immigration</button>
                </div>

                <button type="button" class="btn  helper-button-main d-none d-md-block"
                    onclick="location.href='helperWriteForm.do'">Let me help someone!
                </button>


            </div>

            <button type="button" class="btn  helper-button-main mobile-write-btn d-md-none"
                onclick="location.href='helperWriteForm.do'">
                <i class="fas fa-plus"></i>
            </button>




        </div>

        <div class="col-md-10 order-2 order-md-2">

            <c:forEach items="${helperList}" var="helper">

                <div class="row media helperPost profile-box-container ml-md-1 read-more-wrap">
                    <div class="col-md-3 order-1 order-md-1 d-flex justify-content-center">

                        <img class="profile-img-box"
                            src="https://cdn.pixabay.com/photo/2013/10/28/19/23/cat-201969_960_720.jpg"
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

                                <div class="edit-button float-right">
                                    <c:if test="${helper.userVO.uno == sessionScope.userNumber}">
                                        <form class="d-inline" action="helperDelete.do" method="POST">
                                            <input name="rno" type="hidden" value="${helper.rno}" />
                                            <button type="submit" class="d-inline btn helper-badge">Delete</button>
                                        </form>
                                        <form class="d-inline" action="helperUpdate.do" method="GET">
                                            <input name="rno" type="hidden" value="${helper.rno}" />
                                            <button type="submit" class="d-inline btn helper-badge">Update</button>
                                        </form>

                                    </c:if>
                                </div>


                            </div>


                            <div class="row profile-box-header d-flex justify-content-between">
                                <div class="col-6 ">
                                    <h3 class="helper-name-box">${helper.userVO.name}</h3>
                                </div>
                                <div class="col-6 d-flex flex-row-reverse">
                                    <h6 class=" star-rating">
                                        <c:forEach items="${avgList}" var="avgList">
                                            <c:choose>
                                                <c:when test="${avgList.rno == helper.userVO.uno }">
                                                    ${avgList.r_avg }
                                                </c:when>
                                            </c:choose>
                                        </c:forEach>
                                    </h6>

                                </div>
                            </div>
                            <div class="row profile-box-body">
                                <div class="col-sm-6 order-2 order-sm-1 p-0">
                                    <div class="lang">
                                        ${helper.languageVO.language}
                                    </div>
                                    <div class="reviewNum">
                                        리뷰갯수 :
                                        <c:forEach items="${countList }" var="countList">
                                            <c:choose>
                                                <c:when test="${countList.rno == helper.userVO.uno }">
                                                    ${countList.count }
                                                </c:when>
                                            </c:choose>
                                        </c:forEach>
                                    </div>

                                </div>
                                <div class="col-sm-6 order-1 order-sm-2 p-0">
                                    <div class="avDate">
                                        Available date ${helper.sta} - ${helper.end}
                                    </div>
                                    <div class="area">
                                        Placed in <i class="fas fa-map-marker-alt"></i>${helper.seoulVO.district}
                                    </div>
                                </div>
                            </div>
                            <div class="self-desc">${helper.r_intro}
                                <div class="d-flex justify-content-center">


                                    <label class="read-more-trigger">Read more</label>
                                </div>

                                <div class="read-more-target">
                                    <div class="boardReview">
                                        <ul class="list-group">

                                            <li class="list-group-item">Review</li>
                                            <li class="list-group-item">예의가 없어요</li>
                                            <li class="list-group-item">말을 못해요</li>
                                            <li class="list-group-item">잠만 자요</li>
                                        </ul>
                                    </div>
                                    <div class="d-flex justify-content-center">
                                        <form action="sendRequest.do" method="POST">
                                            <input name="srno" type="hidden" value="${sessionScope.userNumber}" />
                                            <input name="rcno" type="hidden" value="${helper.userVO.uno}" />
                                            <input name="rno" type="hidden" value="${helper.userVO.uno}" />
                                            <input name="rno" type="hidden" value="${sessionScope.userNumber}" />
                                            <input name="mdate" type="hidden" value="${helper.sta}" />
                                            <input name="mplace" type="hidden" value="${helper.seoulVO.dno}" />
                                            <c:if test="${helper.moving==1}"><input name="mservice" type="hidden"
                                                    value="1" /></c:if>
                                            <c:if test="${helper.hospital==1}"><input name="mservice" type="hidden"
                                                    value="2" /></c:if>
                                            <c:if test="${helper.immigration==1}"><input name="mservice" type="hidden"
                                                    value="3" /></c:if>
                                            <button type="submit" class="btn  helper-button-main">Send
                                                request</button>
                                        </form>
                                    </div>
                                </div>
                            </div>

                        </div>

                    </div>

                </div>
            </c:forEach>

            <!--PAGING -->
            <div class="row justify-content-center ">
                <nav aria-label="Page navigation">
                    <div class="page">

                        <button class="btn helper-button-page" href="#" aria-label="Previous">
                            <i class="fas fa-chevron-left"></i>
                        </button>

                        <button class="btn helper-button-page" href="#" aria-label="Next">
                            <i class="fas fa-chevron-right"></i>
                        </button>

                    </div>
                </nav>
            </div>



        </div>
    </div>
</div>

<%@ include file="Footer.jsp"%>