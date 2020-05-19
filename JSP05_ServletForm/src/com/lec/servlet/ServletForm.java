package com.lec.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServletForm
 */
@WebServlet("/FormOk")
public class ServletForm extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public ServletForm() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
//    request 객체에 form에 담겨져있는 data들이 모두 있음 
//    그래서 그 data들을 꺼내야 함     getParameter(name) 함수 사용 -> String return
//    name 의 대소문자를 구분 해줘야한다.
    
    //동일한name의 values 들을 받을때는 getParameterValues(name) 을 사용  --> String [] (배열) return
//    url에 직접 쿼리문을 넣어주는 것은 get으로 받음
    //FormOk?name=aaa&id=222  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		////////////////////////////////////////////////////////////////////////////
		System.out.println("getParameterNames() 사용");
		Enumeration<String> names = request.getParameterNames();
		while(names.hasMoreElements()) {
			//파라미터의 이름들을 계속 뽑아서 paramName에 담음
			String paramName = names.nextElement(); //token과 비슷
			
			//담은 paramName 의 값을 뽑아서 value에 담음 (매칭)
			String paramValue = request.getParameter(paramName);
			System.out.println(paramName + " : "+ paramValue);
		}
		
		System.out.println();
		//2번째 방법  
		//request.getParameterMap() 사용        Map => key, value 값으로 이루어져있음
		System.out.println("getParameterMap() 사용");
		Map<String, String[]> paramMap = request.getParameterMap();
		for(String key : paramMap.keySet()) {
			System.out.println(key + " : "+Arrays.toString(paramMap.get(key)));
//			이거는 배열 형식으로 나옴 [value] 이런 형식
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//post에 대해서는 인코딩 셋팅 제일 먼저 해줄 것
		request.setCharacterEncoding("utf-8");
		
		//form의 method는 post 형식임
		
		//form의 name들을 각각 매칭
		String data1 = request.getParameter("data1");  //==> string type을 리턴하므로 담아줘야함
		String data2 = request.getParameter("data2");
		
		String id = request.getParameter("id");
		String name = request.getParameter("name");   
		String pw = request.getParameter("pw");
		// 이름이 hobby 인 checkbox들의 value 값이 []hobbys에 담김
		String[] hobbys = request.getParameterValues("hobby");
		//라디오 버튼은 한개만 넘어와서
		String gender = request.getParameter("gender");  
		String local = request.getParameter("local");
		String memo = request.getParameter("memo");
		
		
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<head></head>");
		out.println("<body>");
		
		out.println("hidden :"+data1+", "+data2+"<br>");
		out.println("이름 : "+name +"<br>");
		out.println("아이디 : "+id + "<br>");
		out.println("비밀번호 : "+pw + "<br>");
		out.println("취미 : "+Arrays.toString(hobbys) + "<br>");
		out.println("성별 : "+gender + "<br>");
		out.println("지역 : "+local + "<br>");
		out.println("메모 : "+memo + "<br>");
		
		
		out.println("</body>");
		out.println("</html>");
		
		out.close();
		
		//1번째 방법
		//request.getParameterNames()
		// request 안에 담겨있는 모든 parameter들의 name 들을 추출할 수 있음
		System.out.println("getParameterNames() 사용");
		Enumeration<String> names = request.getParameterNames();
		while(names.hasMoreElements()) {
			//파라미터의 이름들을 계속 뽑아서 paramName에 담음
			String paramName = names.nextElement(); //token과 비슷
			
			//담은 paramName 의 값을 뽑아서 value에 담음 (매칭)
			String paramValue = request.getParameter(paramName);
			System.out.println(paramName + " : "+ paramValue);
		}
		
		System.out.println();
		//2번째 방법  
		//request.getParameterMap() 사용        Map => key, value 값으로 이루어져있음
		System.out.println("getParameterMap() 사용");
		Map<String, String[]> paramMap = request.getParameterMap();
		for(String key : paramMap.keySet()) {
			System.out.println(key + " : "+Arrays.toString(paramMap.get(key)));
//			이거는 배열 형식으로 나옴 [value] 이런 형식
		}
		
	}

}
