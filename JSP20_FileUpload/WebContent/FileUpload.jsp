<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <!-- cos 라이브러리 import -->
    <%@ page import="com.oreilly.servlet.MultipartRequest" %>
    <%@ page import="com.oreilly.servlet.multipart.FileRenamePolicy" %>
    <%@ page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy" %>
    
    <%-- parameter 값들, file 값들 추출 --%>
    <%@ page import="java.util.Enumeration" %>
    	<%@ page import = "java.io.File" %>
    			
<%-- 이미지 파일 다루기--%>
<%@ page import ="java.awt.image.BufferedImage" 
			import ="javax.imageio.ImageIO"%>

    
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta name = "viewport" content="width=device-width, initial-scale=1.0">
<title>파일 업로드 결과</title>
</head>
<body>
<form action="FileCheck.jsp" method="post" name="fileCheck">
	

<%
	//MultipartRequest 객체 생성 준비
	
// 	String saveDirectory = "C:\\tomcat\\upload";
	//파일 저장 경로
	//서버에서 (서블릿) 어디에 어느폴더에서 서블릿으로 변환되는지 알아내기
	ServletContext context = this.getServletContext();
	//서블릿안의 upload폴더의 물리적인 경로 얻어오기
	String saveDirectory = context.getRealPath("upload");
	

	System.out.println("업로드 경로 : "+saveDirectory);
	
	int maxPostSize = 5 * 1024 * 1024 ;    // 최대 크기 사이즈 POST 받기, 최대 크기 = 5M byte
	String encoding = "utf-8";  //인코딩
	FileRenamePolicy policy = new DefaultFileRenamePolicy();  //업로딩 파일 이름 중복에 대한 rename정책  ,  cos 에서 준비되어있는 객체
	
	MultipartRequest multi = null;  
	
	try{		//jsp 파일에서 예외를 반드시 catch 할 필요는 없지만...  이번에는 그냥 처리하겠다
		
		//생성단계에서 이미 파을은 저장됨
		multi = new MultipartRequest(request, //jsp 내부객체 request
							saveDirectory,  //저장경로
									maxPostSize,   
											encoding,
													policy  //중복이름의 파일 rename 객체 
				);
		
	
		Enumeration names = null;
		
		names = multi.getParameterNames();
		while(names.hasMoreElements()){
			String name = (String)names.nextElement();
			String value = multi.getParameter(name);
			out.println(name+" : "+value+"<br>");
		}//end while
			
		out.println("<hr>");
		
		//2. file들 추출
		names = multi.getFileNames();  //type이 file인 요소들 name들을 추출
		while(names.hasMoreElements()){
			String name = (String)names.nextElement();
			out.println("input name: "+name +"<br>");
			
			//위 name 의 '업로드 원본 파일명' 을 가져온다.
			String originalFileName = multi.getOriginalFileName(name);  //getOriginalFileName()
			out.println("원본파일 이름 : "+ originalFileName+"<br>");
			out.println("<input type='hidden' name = 'originalFileName' value='"+originalFileName+"'");
			
			//서버 시스템에 '저장된 파일명'을 가져온다
			String fileSystemName = multi.getFilesystemName(name);
			out.println("서버에 저장된 파일 이름 : "+ fileSystemName+"<br>");
			out.println("<input type='hidden' name = 'fileSystemName' value='"+fileSystemName+"'");
			//업로딩된 파일의 타입  : MIME 타입 (ex: image/png);
			
			String fileType = multi.getContentType(name);
			out.println("파일 타입	: "+fileType+"<br>");
			
			//문자열 '파일이름' 이 name 에 들어온 상태
			//문자열 파일이름을 통해 실제파일 정보를 -> File 객체로 가져오기
			File file = multi.getFile(name);
			if(file != null){
				long fileSize = file.length();
				out.println("파일 크기는 : "+fileSize+"<br>");
				
				//이미지 파일 다루기
				BufferedImage bi = ImageIO.read(file);
				if(bi != null){   //이미지 파일판정여부
					int width = bi.getWidth();
					int height = bi.getHeight();
					out.println("이미지 파일 넓이와 높이는: " +width+", "+height+"<br>");
				}else{
					out.println("이미지가 아니입니다<br>");
				}
			}
			out.println("<hr>");
			
		}//end while
	}catch(Exception e){
		e.printStackTrace();
		out.println("파일 처리 예외발생<br>");
	}
%>
<input type="submit" value="업로드 파일 확인">
</form>
</body>
</html>