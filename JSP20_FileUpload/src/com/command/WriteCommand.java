package com.command;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lec.beans.WriteDAO;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.oreilly.servlet.multipart.FileRenamePolicy;

public class WriteCommand implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		
		int cnt = 0;
		WriteDAO dao = new WriteDAO();
		
		//업로드된 파일
		ServletContext context = request.getServletContext();
		String saveDirectory = context.getRealPath("upload");
		int maxPostSize = 5 * 1024 * 1024 ; //POST 받을 최대 이미지의 크기는 5메가로 설정
		String encoding = "utf-8";
		FileRenamePolicy policy = new DefaultFileRenamePolicy(); 
		
		MultipartRequest multi = null;
		
		try {
			multi = new MultipartRequest(request, saveDirectory, 
					maxPostSize, encoding, policy);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		List<String> originalFileNames = new ArrayList<String>();
		List<String> fileSystemNames = new ArrayList<String>();
		Enumeration names = null;
		names = multi.getFileNames();
		while(names.hasMoreElements()) {
			String name = (String)names.nextElement();
			String originalFileName = multi.getOriginalFileName(name);
			String fileSystemName = multi.getFilesystemName(name);

			if(originalFileName != null && fileSystemName !=null) {
				originalFileNames.add(originalFileName);
				fileSystemNames.add(fileSystemName);
				//리스트에 담는 과정 add를 이용
			}//end if
		}//end while
		
		//매개변수 받아오기  .   매개변수들은 이제 전부다 multi에 있다
		String name = multi.getParameter("name");
		String subject = multi.getParameter("subject");
		String content = multi.getParameter("content");
		
		if(name != null && subject !=null 
				&& name.trim().length()>0 && subject.trim().length()>0) {
			
			try {
				//첨부파일 정보도 같이 insert 해준다.
				cnt = dao.insert(subject, content, name, originalFileNames, fileSystemNames);
			}catch (Exception e) {
				e.printStackTrace();
			}
			
			
		}//end if
		
		request.setAttribute("result", cnt);
		//result 로 담았으니 꺼낼때도 result
		
	}//end execute

}//end command
