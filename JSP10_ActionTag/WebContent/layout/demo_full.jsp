<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
  <title>Bootstrap 레이아웃예제</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>
  <link rel="stylesheet" href="CSS/demostyle.css">
</head>
<body>

<!-- header 시작    <-- 각 세션별로 해서 주석을 맞춰주는게 눈에 보기도 편하고 이쁨-->
<div class="jumbotron text-center" style="margin-bottom:0">
  <h1>Bootstrap 4 사용 레이아웃 예제</h1>
  <p>화면크기를 변경해가며 확인해보기</p> 
</div>
<!-- header 끝 -->

<!-- nav 시작 -->
<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
  <a class="navbar-brand" href="#">Navbar</a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#collapsibleNavbar">
    <span class="navbar-toggler-icon"></span>
  </button>
  <div class="collapse navbar-collapse" id="collapsibleNavbar">
    <ul class="navbar-nav">
      <li class="nav-item">
        <a class="nav-link" href="#">Link</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="#">Link</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="#">Link</a>
      </li>    
    </ul>
  </div>  
</nav>
<!-- nav 끝 -->

<!-- 반응형 본문 시작 -->
<div class="container" style="margin-top:30px">
  <div class="row">
  
  	<!-- left 사이트 메뉴 시작 -->
    <div class="col-sm-4">
      <h3>Side menu</h3>
      <p>Lorem ipsum dolor sit ame.</p>
      <ul class="nav nav-pills flex-column">
        <li class="nav-item">
          <a class="nav-link active" href="#">page1</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="#">page2</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="#">page3</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="#">page4</a>
        </li>
        <li class="nav-item">
          <a class="nav-link disabled" href="#">Disabled</a>
        </li>
      </ul>
      <hr class="d-sm-none">
    </div>
    <!-- left 사이트 메뉴 끝 -->
    
    <!-- 본문 시작 -->
    <div class="col-sm-8">
      <h2>TITLE : Page1</h2>
      <h5>Title description, Dec 7, 2017</h5>
      <div class="fakeimg">Fake Image</div>
      <p>Some text..</p>
      <p>Sunt in culpa qui officia deserunt mollit anim id est laborum consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco.</p>
    </div>
    <!-- 본문 끝 -->
    
  </div>
</div>
<!-- 반응형 본문 끝 -->

<!-- footer 시작 -->
<div class="jumbotron text-center" style="margin-bottom:0">
  <p>Footer</p>
</div>
<!-- footer 끝 -->

</body>
</html>


