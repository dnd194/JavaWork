<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.sql.*" import="java.text.*"
	import="old.*"%>

<%
	//controller 로 부터 결과 데이터를 받는다.
	WriteDTO[] arr = (WriteDTO[])request.getAttribute("list");
//페이징 관련 세팅 값들
	int writePages = 10;   // 한 [페이징] 에 몇개의 '페이지' 를 표현할 것인가?
	int pageRows = 8;    // 한 '페이지' 에 몇개의 글을 리스트업 할 것인가?
	int totalPage = 0;	 // 총 몇 '페이지' 분량인가?
			
	int curPage = 1;   // 현재 페이지 (디폴트 1 page)
	
	// 페이징 버튼 링크 url 주소에 넣을 문자열 준비
	String add = request.getParameter("add"); 
	if(add == null){ add = ""; }
		String url = request.getRequestURL().toString() + "?page=";
		
		String str = "";   // 최종적으로 페이징에 나타날 HTML 문자열 <li> 태그로 구성

		// 페이징에 보여질 숫자들 (시작숫자 start_page ~ 끝숫자 end_page)
	 int start_page = ( ( (int)( (curPage - 1 ) / writePages ) ) * writePages ) + 1;
	 int end_page = start_page + writePages - 1;

	 if (end_page >= totalPage){
	 	end_page = totalPage;
	 }
		
		//■ << 표시 여부
		if(curPage > 1){
			str += "<li><a href='" + url + "1" +  add + "' class='tooltip-top' title='처음'><i class='fa fa-angle-double-left'></i></a></li>\n";
		}
		
		//■  < 표시 여부
	 if (start_page > 1) 
	 	str += "<li><a href='" + url + (start_page - 1) + add + "' class='tooltip-top' title='이전'><i class='fa fa-angle-left'></i></a></li>\n";
	 
	 //■  페이징 안의 '숫자' 표시	
		if (totalPage > 1) {
		    for (int k = start_page; k <= end_page; k++) {
		        if (curPage != k)
		            str += "<li><a href='" + url + k + add + "'>" + k + "</a></li>\n";
		        else
		            str += "<li><a href='#' class='active tooltip-top' title='현재페이지'>" + k + "</a></li>\n";
		    }
		}
		
		//■ > 표시
	 if (totalPage > end_page){
	 	str += "<li><a href='" + url + (end_page + 1) + add + "' class='tooltip-top' title='다음'><i class='fa fa-angle-right'></i></a></li>\n";
	 }

		//■ >> 표시
	 if (curPage < totalPage) {
	     str += "<li><a href='" + url + totalPage + add + "' class='tooltip-top' title='맨끝'><i class='fa fa-angle-double-right'></i></a></li>\n";
	 }


	String pageParam = request.getParameter("page");
	if(pageParam != null && !pageParam.trim().equals("")){
		try{ 
			// 1이상의 자연수 이어야 한다
			int p = Integer.parseInt(pageParam);
			if(p > 0) curPage = p;
		} catch(NumberFormatException e){
			// page parameter 오류는 별도의 exception 처리 안함 
		}
	} // end if %>
	

<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>게시글 목록</title>
<link href="<%= request.getContextPath()%>/resources/table.css" rel="stylesheet" type="text/css">
</head>
<body>

	<hr>
	<h2>리스트</h2>
	<table>
		<tr>
			<th>UID</th>
			<th>제목</th>
			<th>작성자</th>
			<th>조회수</th>
			<th>등록일</th>
		</tr>
		<%
			if(arr != null){
				for (int i =0; i<arr.length; i++){
		%>
				<tr>
				<td><%= arr[i].getUid() %></td>
				<td><a href="view.do?uid=<%= arr[i].getUid()%>"><%=arr[i].getSubject() %></a></td>
				<td><%= arr[i].getName() %></td>
				<td><%= arr[i].getViewCnt() %></td>
				<td><%= arr[i].getRegDate() %></td>
				</tr>
		
		<% 
				}//end for
			}
		%>

	</table>
	<br>
	<button onclick="location.href('write.do')">신규 등록</button>
	
<
<div class="center">
	<ul class="pagination">
	<%= str %>
	</ul>
</div>
</body>
</html>