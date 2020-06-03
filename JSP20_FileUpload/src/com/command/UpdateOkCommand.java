package com.command;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lec.beans.FileDAO;
import com.lec.beans.WriteDAO;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.oreilly.servlet.multipart.FileRenamePolicy;

public class UpdateOkCommand implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		int cnt = 0;
		WriteDAO dao = new WriteDAO();
		FileDAO fileDao = new FileDAO();  //첨부파일
		
		//----------------------------------------------------------
		//1. 업로드 파일 처리
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
		
		
		
		
		//----------------------------------------------------------
		//2. 삭제될 첨부파일들
		String[] delFiles = multi.getParameterValues("delfile");
		if(delFiles != null && delFiles.length > 0) {
			int[] delFileUids = new int[delFiles.length];
			
			for(int i = 0 ; i<delFileUids.length; i++) {
				delFileUids[i] = Integer.parseInt(delFiles[i]);
			}
			
			try {
				fileDao.deleteByUid(delFileUids, request);
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
		
		
		//----------------------------------------------------------
		//3. 입력한 값 받아오기   --> 글수정
		//매개변수 받아오기  .   매개변수들은 이제 전부다 request에 있다
		String subject = multi.getParameter("subject");
		String content = multi.getParameter("content");
		int uid = Integer.parseInt(multi.getParameter("uid"));
		
		if(subject != null && subject.trim().length() > 0){  
			try {
				cnt = dao.update(uid, subject, content);
			}catch (Exception e) {
				e.printStackTrace();
			}
		}//end if
		//-------------------------------------------------
				// 추가된 첨부파일(들)
				fileDao = new FileDAO();
				try {
					fileDao.insert(uid, originalFileNames, fileSystemNames);
				} catch(SQLException e) {
					e.printStackTrace();
				}
		request.setAttribute("uid", uid); 
		request.setAttribute("updateOk", cnt);
	}

}
