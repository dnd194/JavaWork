package com.command;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.oreilly.servlet.multipart.FileRenamePolicy;

public class FileUploadCommand implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {

		//1. 업로드 된 파일 저장
		final String SAVE_URL="ckupload";
		
		//실제저장되는 물리적인 경로 확인
		ServletContext context = request.getServletContext();
		String saveDirectory = context.getRealPath(SAVE_URL);
		System.out.println("업로드경로 : "+saveDirectory);  //check 용
		
		Enumeration names = null;
		String name = null;  				//parameter로 넘어오는 name 값
		String originalFileName = null;  	//원본파일 이름
		String fileSystemName = null;		//실제저장되는 파일이름
		String fileType = null; 			//파일 MIME 타입
		String fileUrl = null;				//업로드 된 파일의 url
		
		int maxPostSize = 5 * 1024 * 1024 ; //POST 받을 최대 이미지의 크기는 5메가로 설정
		String encoding = "utf-8";
		FileRenamePolicy policy = new DefaultFileRenamePolicy();  
		//업로딩 파일 이름 중복에 대한 정책
		
		MultipartRequest multi = null;
		try {
			multi = new MultipartRequest(request, saveDirectory, 
					maxPostSize, encoding, policy);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		//1-2 
		names = multi.getFileNames(); //type = "file" 요쇼의 name을 추출
		while(names.hasMoreElements()) {
			name = (String)names.nextElement();
			System.out.println("input name : "+name);  //ckeditor에선 name 이 upload
			// upload 라는 이름으로 전송이 된다.
			
			//전부다 parameter 는 name 
			originalFileName = multi.getOriginalFileName(name);
			fileSystemName = multi.getFilesystemName(name);
			fileType = multi.getContentType(name);
			
			fileUrl = request.getContextPath() + "/"+SAVE_URL+"/"+fileSystemName;
			System.out.println("fileUrl :"+fileUrl);
		}
		
		
		//2. response (CKEditor 에서 정한 포맷 , json) 
		
		
//		{
//		    "uploaded": 1,
//		    "fileName": "foo.jpg",
//		    "url": "/files/foo.jpg"
//		}
		
		String jsonString = "{\"filename\" : \"" + fileSystemName 
				+ "\", \"uploaded\" : 1, \"url\":\"" + fileUrl + "\"}";

		try {
			response.setContentType("application/json; charset=utf-8 ");
			response.getWriter().write(jsonString);
		}catch (IOException e) {
			e.printStackTrace();
		}

		
	}

}
