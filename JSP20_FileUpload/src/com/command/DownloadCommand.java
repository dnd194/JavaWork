package com.command;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lec.beans.FileDAO;
import com.lec.beans.FileDTO;

public class DownloadCommand implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {

		FileDAO fileDao = new FileDAO();
		FileDTO[] fileArr = null;

		int uid = Integer.parseInt(request.getParameter("uid"));

		FileInputStream in = null;
		ServletOutputStream sout = null;

		try {
			fileArr = fileDao.selectByUid(uid); // 특정파일 하나
			String fileSystemName = fileArr[0].getFile(); //저장된 파일명
			String originalFileName = fileArr[0].getSource(); //원본 파일명
			
			String realPath = request.getServletContext().getRealPath("upload");
			String downloadFilePath = realPath+File.separator+fileSystemName;
			System.out.println("downloadFilePath : "+ downloadFilePath);
			
			// MIME 타입을 얻어옴
			String fileType = request.getServletContext().getMimeType(downloadFilePath);
			
			//파일 유형이 지정되지 않은 경우
			if(fileType == null) {
				fileType = "application/octet-stream";
			}
			response.setContentType(fileType); //얻어온 마임 타입으로 request를 셋해줌
			
			String enc = "utf-8";
			// 인코딩된 파일 이름을 얻는 과정
			String encFileName = URLEncoder.encode(originalFileName, enc);
			response.setHeader("Content-Disposition", "attachment; filename="+encFileName);
			
			File srcFile = new File(downloadFilePath);
			in = new FileInputStream(srcFile);
			sout = response.getOutputStream();
			
			byte[] buff = new byte[(int)srcFile.length()];  //파일크기만큼 버퍼준비
			int numRead = 0;
			int totalRead = 0;
			
			//파일로부터 읽기
			while( (numRead = in.read(buff,0,buff.length))  != -1) {
				//읽어 들인만큼 내보냄
				totalRead += numRead;
				sout.write(buff,0,numRead);
			}//end while
			System.out.println("전송 byte: "+totalRead+"bytes");
			
			

		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(sout!=null) {
					sout.flush();
					sout.close();
				}
				if(in != null) in.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}// end execute

}// end command
