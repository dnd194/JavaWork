<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta name = "viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/CSS/common.css"/>
<link rel="stylesheet"
	href="https://pro.fontawesome.com/releases/v5.10.0/css/all.css"
	integrity="sha384-AYmEC3Yw5cVb3ZcuHtOA93w35dYTsvhLPVnYs9eStHfGJvOvKxVfELGroGkvsg+p"
	crossorigin="anonymous" />
<script src="https://code.jquery.com/jquery-3.5.1.js"
	integrity="sha256-QWo7LDvxbWT2tbbQ97B53yJnYU3WhH/C8ycbRAkjPDc="
	crossorigin="anonymous"></script>
<script src="${pageContext.request.contextPath }/JS/board.js"></script>
<title>SPA 게시판</title>
</head>
<body>
<h2> 게시판 - SPA</h2>
<%-- 글 목록 --%>
<div id = "list">
	<div class="d01">
		<div class="left" id = "pageinfo"></div>
		<div class="right" id = "pageRows"></div>
	</div>
	<div class="clear"></div>  <!-- 끊어주는 역할 -->
	<form id = "frmList" name="frmList">
		<table>
			<thead>
				<th>#</th>
				<th>UID</th>
				<th>제목</th>
				<th>작성자</th>
				<th>조회수</th>
				<th>작성일</th>
			</thead>
			<tbody>
			</tbody>
		</table>
	</form>
		<%--버튼 --%>
	<div class="d01">
		<div class="left">
			<button type="button" id="btnDel" class="btn danger">글삭제</button>
		</div>
		<div class="right">
			<button type="button" id="btnWrite" class="btn success">글작성</button>
		</div>	
	</div>


	
</div>


<br>
<%-- 페이징 --%>
<div class = "center" >
	<ul class = "pagination"></ul>
</div>

<%--글작성 ,보기, 수정--%>
<div id="dlg_write" class="modal">
  
  <form class="modal-content animate" id="frmWrite" name="frmWrite" method="post">

    <div class="container">      
      <h3 class="title">새글 작성</h3> 
      
      <span class="close" title="Close Modal">&times;</span>
      <input type="hidden" name="uid">   <%-- 삭제나 수정을 위해 필요 --%>
      
      <div class="d01 btn_group_header">
      	<div class="left">
      		<p id="viewcnt"></p>
      	</div>
      	<div class="right">
      		<P id="regdate"></P>
      	</div>
      	<div class="clear"></div>
      </div>
      
      <label for="subject"><b>글제목</b></label>
      <input type="text" placeholder="글제목(필수)" name="subject" required>

      <label for="name"><b>작성자</b></label>
      <input type="text" placeholder="작성자(필수)" name="name" required>
      
      <label for="content"><b>내용</b></label>
      <textarea placeholder="글내용" name="content"></textarea>
      
      
      <div class="d01 btn_group_write">
	      <button type="submit" class="btn success fullbtn">작성</button>
      </div>  
      
      <div class="d01 btn_group_view">
      	<div class="left">
      		<button type='button' class="btn danger" id="viewDelete">삭제</button>
      	</div>
      	<div class="right">
      		<button type='button' class="btn info" id="viewUpdate">수정</button>
      	</div>
      	<div class="clear"></div>
      </div>
      
      <div class="d01 btn_group_update">
      	<div>
      		<button type="button" class="btn info fullbtn" id="updateOk">수정완료</button>
      	</div>
      </div>
      
      
    </div>
  </form>
</div>
</body>
</html>