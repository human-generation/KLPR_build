<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="Header.jsp"%>


	<!-- 본문 -->
	<div class="container-fluid">

        <div class="jumbotron jumbotron-fluid">

            <div class="container text-center jt-text">
                <h1 class="display-4"><span class="logo-main">
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
                    </span></h1>
                <p class="lead">We are here When you need help!
                </p>
                <button type="button" class="helper-button-main btn-lg" onclick="location.href='getHelperList.do'">Searching for HELPER</button>
                <button type="button" class="helper-button-main btn-lg" onclick="location.href='getHelpeeList.do'">Searching for HELPEE</button>
            </div>
            


        </div>




        <div id="carouselCaptions" class="carousel slide" data-ride="carousel">
            <ol class="carousel-indicators">
                <li data-target="#carouselCaptions" data-slide-to="0" class="active"></li>
                <li data-target="#carouselCaptions" data-slide-to="1"></li>
            </ol>
            <div class="carousel-inner">
                <div class="carousel-item active">
                    <img src="https://images.unsplash.com/photo-1589828994425-cee7c6e8dbf8?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=1086&q=80"
                        class="d-block w-100" alt="...">
                    <div class="carousel-caption ">
                        <h5>Get help, When you need it</h5>
                        <p>Nulla vitae elit libero, a pharetra augue mollis interdum.</p>
                    </div>
                </div>
                <div class="carousel-item">
                    <img src="https://images.unsplash.com/photo-1586726972122-f20f59d4bbb2?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=1050&q=80"
                        class="d-block w-100" alt="...">
                    <div class="carousel-caption">
                        <h5>First time user? Here is the guide for YOU!</h5>
                        <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit.</p>
                    </div>
                </div>
            </div>
            <a class="carousel-control-prev" href="#carouselCaptions" role="button" data-slide="prev">
                <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                <span class="sr-only">Previous</span>
            </a>
            <a class="carousel-control-next" href="#carouselCaptions" role="button" data-slide="next">
                <span class="carousel-control-next-icon" aria-hidden="true"></span>
                <span class="sr-only">Next</span>
            </a>
        </div>
    </div>

	<!--DS JS-->
	<section class="container ds-data-container">
        <div class="row align-items-center ">
            <div class="col-lg-6 ds-data1">

            </div>
            <div class="col-lg-6 ds-data2">

            </div>
        </div>
    </section>

	<!--RANKING-->
	<section class="container ranking-box-container">
        <div class="row align-items-center">
            <div class="col-md-4 ">
                <div class="card border-light">
                    <div class=" card-header">See Best Helpers! </div>
                    <div class="card-body">
                        <p class="card-text">

							<ul>						
						<c:forEach var="list" items="${RScoreTop5}">
							<li>${list.ranking} . ${list.name}</li>
						</c:forEach>
						</ul>
						</p>
					</div>
				</div>
			</div>
			<div class="col-md-4">
				<div class="card border-light">
					<div class=" card-header">See Most participated Helpers!</div>
					<div class="card-body">
						<p class="card-text">
						
						<ul>
						<c:forEach var="list" items="${RTop5}">
							<li>${list.ranking} .  ${list.name}</li>
						</c:forEach>	
						</ul>
						</p>
					</div>
				</div>
			</div>
			<div class="col-md-4">
				<div class="card border-light">
					<div class=" card-header">Someone needs a lot of help!</div>
					<div class="card-body">
						<p class="card-text">
						
						<ul>
						<c:forEach var="list" items="${ETop5}">
							<li>${list.ranking} .  ${list.name}</li>							
						</c:forEach>	
						</ul>
						</p>
					</div>
				</div>
			</div>
		</div>

	</section>

	<%@ include file="Footer.jsp"%>