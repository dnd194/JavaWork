<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	int menu = 1;  // menu parameter 없으면 1 page 디폴트
	String menu_param = request.getParameter("menu");
	if(menu_param != null){
		try{			
			menu = Integer.parseInt(menu_param);
		} catch(NumberFormatException e){
			
		}
	}
	
	// 1 <= menu <= 4
	if(menu > 4) menu = 4;
	if(menu < 1) menu = 1;
%>    
    
	<!-- left 사이트 메뉴 시작 -->
    <div class="col-sm-4">
      <h3>Side menu</h3>
      <p>Lorem ipsum dolor sit ame.</p>
      <ul class="nav nav-pills flex-column">
        <li class="nav-item">
        <!-- 3항 연산자를 이용하여 class를 넣어줄 수 도 있다. 마찬가지로 href 속성도 줄 수 있다.  -->
          <a class="nav-link <%=(menu == 1)?"active":"" %>" <%=(menu != 1)?"href='page.jsp?menu=1'":""%>>page1</a>
        </li>
        <li class="nav-item">
          <a class="nav-link <%=(menu == 2)?"active":"" %>" <%=(menu != 2)?"href='page.jsp?menu=2'":""%>>page2</a>
        </li>
        <li class="nav-item">
          <a class="nav-link <%=(menu == 3)?"active":"" %>" <%=(menu != 3)?"href='page.jsp?menu=3'":""%>>page3</a>
        </li>
        <li class="nav-item">
          <a class="nav-link <%=(menu == 4)?"active":"" %>" <%=(menu != 4)?"href='page.jsp?menu=4'":""%>>page4</a>
        </li>
        <li class="nav-item">
          <a class="nav-link disabled" href="#">Disabled</a>
        </li>
      </ul>
      <hr class="d-sm-none">
    </div>
    <!-- left 사이트 메뉴 끝 -->













