package com.command.write;

import java.io.IOException;
import java.util.Arrays;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;
import org.json.JSONArray;
import org.json.JSONObject;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.lec.beans.AjaxWriteListJson;
import com.lec.beans.AjaxWriteListXML;
import com.lec.beans.WriteDTO;

public class AjaxListCommand implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {

		//파라미터 받아오기
		//1. request 타입 받아오기  json 인지 xml 인지   
		// 우리는 json을 default 로 할거임
		
		
		String reqType = request.getParameter("reqType");
		if(reqType == null) reqType="json";
		
		//"xml" 혹은 "json" 으로 response 하기
		
		switch (reqType) {
		case "xml":
//			responseXml(request, response);		//jdom 사용
			responseXml2(request, response);		//jackson 사용
			break;
			
		default:
			// 위에서 디폴트는 json으로 하기로했음
//			responseJson(request, response);   //org.json
			responseJson2(request, response);	//jackson
			break;
		}//end switch 
		
		
	}//end execute
	
	private void responseJson(HttpServletRequest request, HttpServletResponse response) {
		
		WriteDTO[] dtoArr = (WriteDTO[]) request.getAttribute("list");
		JSONObject jsonOutput = new JSONObject();    //org.json에서 가져옴    최종결과는 object
		
		
		if(dtoArr == null) {
			jsonOutput.put("status", "FAIL");
		}else {
			jsonOutput.put("status", "OK");
			int count = dtoArr.length;
			jsonOutput.put("count", count);
			
			//글목록
			JSONArray dataArr = new JSONArray();
			for(int i = 0; i<count; i++) {
				JSONObject dataObj = new JSONObject();
				dataObj.put("uid", dtoArr[i].getUid());
				dataObj.put("name", dtoArr[i].getName());
				dataObj.put("subject", dtoArr[i].getSubject());
				dataObj.put("content", dtoArr[i].getContent());
				dataObj.put("viewcnt", dtoArr[i].getViewCnt());
				dataObj.put("regdate", dtoArr[i].getRegDate());
				
				//배열에  object 데이터 추가
				dataArr.put(dataObj);
			}
			jsonOutput.put("data", dataArr);
		}
		
		//json object --> 문자열 변환
		String jsonString = jsonOutput.toString();   //제공하는 메서드
		response.setContentType("application/json; charset=utf-8");   // mime 설정 이거는  서버에서 ajax할때 이러한 세팅을 해줘야함
		
		try {
			response.getWriter().write(jsonString);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}//end responseJson
	
	
	//자바를 json으로 변환 하는것
	private void responseJson2(HttpServletRequest request, HttpServletResponse response) {
		WriteDTO[] dtoArr = (WriteDTO[]) request.getAttribute("list");
		
		
		AjaxWriteListJson list = new AjaxWriteListJson();		//response 할 java 객체
		if(dtoArr == null ) {
			list.setStatus("실패");
		}else {
			list.setStatus("성공");
			list.setCount(dtoArr.length);
			list.setList(Arrays.asList(dtoArr));    // 배열을 arraylist로 바꿔주는 메서드 asList
		}
		
		ObjectMapper mapper = new ObjectMapper();//json 으로 매핑할 Mapper 객체
		try {
			
			String jsonString = mapper.writeValueAsString(list);		//writeValueAsString() => json 문자열로 바꿔주는 메서드
			
			// response 인코딩
			response.setContentType("application/json; charset=utf-8");
			response.getWriter().write(jsonString);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}   	
		
	}//end responseJson2
	
	
	private void responseXml(HttpServletRequest request, HttpServletResponse response) {

		WriteDTO[] dtoArr = (WriteDTO[]) request.getAttribute("list");
				
		Document dom = new Document() ;
		Element rootElement = new Element("WriteList");  //WriteList 라는 element  를 만듬
		dom.setRootElement(rootElement);
		
		Element statusElement = new Element("status");
		if(dtoArr == null) {
			statusElement.setText("실패했떠염");
		}else {
			statusElement.setText("오우케이~");
			
			//데이터 개수
			int count = dtoArr.length;
			Element countElement = new Element("Count")
							.setText(""+count)
							.setAttribute("id","ccc")
							.setAttribute("pw", "xxx");  //메소드 체인이 가능하다
			rootElement.addContent(countElement);
			for(int i = 0; i < count; i++) {
				Element dataElement = new Element("Data");    // Data 태그 이름을 만들어줌
				dataElement.addContent(new Element("uid").setText(dtoArr[i].getUid()+""));
				dataElement.addContent(new Element("name").setText(dtoArr[i].getName()+""));
				dataElement.addContent(new Element("subject").setText(dtoArr[i].getSubject()+""));
				dataElement.addContent(new Element("content").setText(dtoArr[i].getContent()+""));
				dataElement.addContent(new Element("viewcnt").setText(dtoArr[i].getViewCnt()+""));
				dataElement.addContent(new Element("regdate").setText(dtoArr[i].getRegDate()+""));
				
				
				rootElement.addContent(dataElement);
			}
			
		}
		
		rootElement.addContent(statusElement);       // 사실상 xml에 추가하는 것  addContent
		
		XMLOutputter xmlOutputter = new XMLOutputter(Format.getPrettyFormat());  //pretty는 console 확인용
		System.out.println(xmlOutputter.outputString(dom));  //console test용
		try {
			response.setContentType("application/xml; charset=utf-8");   //text/xml도 가능
			response.getWriter().write(xmlOutputter.outputString(dom)); //dom을 문자열로 만들어서 response에 return 함
		}catch (Exception e) {
			e.printStackTrace();
		}
		
	}// end responseXml
	
	
	private void responseXml2(HttpServletRequest request, HttpServletResponse response) {
		WriteDTO[] dtoArr = (WriteDTO[]) request.getAttribute("list");
		
		AjaxWriteListXML list = new AjaxWriteListXML();  //response 할 자바 객체
		
		if(dtoArr == null) {
			list.setStatus("fail");
		}else {
			list.setStatus("ok");
			list.setCount(dtoArr.length);
			list.setList(Arrays.asList(dtoArr));
		}//end if
		
		
		
		
		XmlMapper mapper = new XmlMapper();  // xml 매핑할 Mapper 객체   외부 라이브러리 임
		try {
			String xmlString = mapper.writeValueAsString(list);
			
			response.setContentType("application/xml; charset=utf-8");
			response.getWriter().write(xmlString);
		} catch (JsonProcessingException e) {   //exception 이름 오류 아님 
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}   
		
		
		
		
		
		
		
	}//end responseXml2
}
