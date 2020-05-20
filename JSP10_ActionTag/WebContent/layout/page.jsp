<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%
    	/* 여기 자바 코드야~~ */
    	/* menu parameter가 없으면  default = 1page */
    	int menu = 1;
    	String menu_param = request.getParameter("menu");
    	if(menu_param != null){
    		try{
    			
    			menu = Integer.parseInt(menu_param);
    			
    		}catch(NumberFormatException e){
    			e.printStackTrace();
    		}
    	}
    	if(menu > 4 ) menu = 4;  /* 한줄처리 */
    	if(menu < 1 ) menu = 1;  /* 한줄처리 */
    %>
<jsp:include page ="top.jsp"/>
<jsp:include page ="header.jsp"/>
<jsp:include page ="nav.jsp"/>

<!-- 반응형 본문 시작 -->
<div class="container" style="margin-top:30px">
	<div class="row">
		<jsp:include page="left.jsp">
			<jsp:param value="<%= menu %>" name="menu"/>
		</jsp:include>
		<% String article_page = "article" + menu + ".jsp"; %>
		<jsp:include page='<%= article_page %>'/>
	</div>
</div>

<!-- 반응형 본문 끝 -->
<jsp:include page="footer.jsp"/>
<jsp:include page="bottom.jsp"/>