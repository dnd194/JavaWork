package com.command;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;

import javax.imageio.ImageIO;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lec.beans.FileDAO;
import com.lec.beans.FileDTO;
import com.lec.beans.WriteDAO;
import com.lec.beans.WriteDTO;

public class ViewCommand implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
//		view는 uid로 봄
		
		WriteDTO[] arr = null;  //초기값
		WriteDAO dao = new WriteDAO();
		
		//첨부파일
		FileDAO fileDao = new FileDAO();
		FileDTO[] fileArr =null;
		
		int uid = Integer.parseInt(request.getParameter("uid"));
		
		if(uid < 0 ) uid = 1;
		try {
			arr = dao.readByUid(uid);
			request.setAttribute("view", arr);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		//첨부파일 읽어들이기
		try {
			if(arr != null && arr.length == 1) {
				fileArr = fileDao.selectFilesByWrUid(uid);
				
				//이미지 파일 여부 세팅
				String realPath = "";
				String saveFolder ="upload";
				ServletContext context = request.getServletContext();
				realPath = context.getRealPath(saveFolder);
				
				for(FileDTO fileDto : fileArr) {
					String downloadedFilePath = realPath + File.separator +
							fileDto.getFile();
					BufferedImage imgData = ImageIO.read(new File(downloadedFilePath));
					if(imgData != null){
						fileDto.setImage(true);
					}
					
					
				}
				
				
				
				request.setAttribute("file", fileArr);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}//end execute()

}
