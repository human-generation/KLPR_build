<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link href="css/reset.css" rel="stylesheet" type="text/css">
<link href="css/intro.css" rel="stylesheet" type="text/css">
<link href="https://fonts.googleapis.com/icon?family=Material+Icons"
	rel="stylesheet">
<style>
@font-face {
	font-family: 'Material Icons';
	font-style: normal;
	font-weight: 400;
	src: url(https://example.com/MaterialIcons-Regular.eot);
	/* For IE6-8 */
	src: local('Material Icons'), local('MaterialIcons-Regular'),
		url(https://example.com/MaterialIcons-Regular.woff2) format('woff2'),
		url(https://example.com/MaterialIcons-Regular.woff) format('woff'),
		url(https://example.com/MaterialIcons-Regular.ttf) format('truetype');
}

.material-icons {
	font-family: 'Material Icons';
	font-weight: normal;
	font-style: normal;
	font-size: 30px;
	display: inline-block;
	line-height: 1;
	text-transform: none;
	letter-spacing: normal;
	word-wrap: normal;
	white-space: nowrap;
	direction: ltr;
	-webkit-font-smoothing: antialiased;
	text-rendering: optimizeLegibility;
	-moz-osx-font-smoothing: grayscale;
	font-feature-settings: 'liga';
}
</style>
<title>FAQ</title>
<!--
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">

    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
    <script src="http://code.jquery.com/jquery-1.11.1.min.js"></script>
    <script></script>
    -->

</head>
<body>
	<header>
		<div class="wrap">
			<h1>K:LPER</h1>
			<nav>
				<ul class="headmenu">
					<li><a href="">서비스개요</a></li>
					<li><a href="">FAQ</a></li>
					<li><a href="">H:LPIE</a></li>
					<li><a href="">H:LPER</a></li>
				</ul>
				<ul class="headicon">
					<li><span class="material-icons">account_circle</span></li>
					<li><span class="material-icons">notifications</span></li>
					<li><span class="material-icons">menu</span></li>
				</ul>
			</nav>
		</div>
	</header>
	<div class="wrap main">
		<nav>
			<ul>
				<li>전체보기</li>
				<li>이사</li>
				<li>병원</li>
				<li>관공서</li>
			</ul>
			<input type="button" value="헬피 등록" onclick="">
		</nav>
		<div class="post">
			<h2>도와주세요!</h2>
			<ul class="align">
				<li>지역 <select>
						<option value="" selected>서울 전체</option>
						<option value="">마포구</option>
				</select>
				</li>
				<li>최신순</li>
				<li>평점순</li>
			</ul>
			<div class="card">

				<div class="propic">
					<span class="material-icons"></span> <input type="button"
						value="자세히 보기" onclick="">
				</div>
				<div class="protxt">
					<b>병원</b>
					<h3>배 아파요.</h3>
					<p>닉네임 | 언어레벨 | 10회 도움받음</p>
					<em>자기소개 내용 줄글. 나 여기저기 아픔 그니까 병원데려다주세영ㅎㅇㅇㅎㄹㅇㅎㅇㄹ</em>
				</div>

			</div>

			<div class="card">

				<div class="propic">
					<span class="material-icons"></span> <input type="button"
						value="자세히 보기" onclick="">
				</div>
				<div class="protxt">
					<b>병원</b>
					<h3>배 아파요.</h3>
					<p>닉네임 | 언어레벨 | 10회 도움받음</p>
					<em>자기소개 내용 줄글. 나 여기저기 아픔 그니까 병원데려다주세영ㅎㅇㅇㅎㄹㅇㅎㅇㄹ</em>
				</div>

			</div>
			<ul class="number">
				<li><input type="button" value="<" onclick=""></li>
				<li><input type="button" value="1" onclick=""></li>
				<li><input type="button" value="2" onclick=""></li>
				<li><input type="button" value="3" onclick=""></li>
				<li><input type="button" value="4" onclick=""></li>
				<li><input type="button" value="5" onclick=""></li>
				<li><input type="button" value=">" onclick=""></li>
			</ul>
		</div>
	</div>
</body>
</body>
</html>