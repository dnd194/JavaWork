package com.jar.validator;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLDecoder;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.jar.JarFile;
import java.util.stream.Collectors;

/*
 *	Maven 빌드시 : 손상된 jar 파일 확인(corrupted jar check)
 *	
 *	손상된 jar 파일의 경우 다운로드 시도. 
 * 
 *	다운로드 받은 후 해당 Maven 프로젝트들은 update 하기
 */

public class JarValidator {
	private static final String URL_MAVEN2 = "https://repo1.maven.org/maven2";
	private static Path repositoryPath = null;
	
	public static void main(String[] args) throws IOException {
		//사용자 폴더 밑의 repository 경로
		
		repositoryPath = Paths.get(System.getProperty("user.home"),".m2","repository");
//		System.out.println(repositoryPath);  //확인용
		
		//repository 경로 존재 여부 확인
		if(Files.exists(repositoryPath)) {
			
			JarValidator jv = new JarValidator();
			List<Path> jarFiles = jv.getFiles(repositoryPath, ".jar");
			System.out.println("발견된 전체 jar 파일들 : "+jarFiles.size()+ " 개");
			
			jv.openJars(jarFiles);
			
//			// 확인용
//			for(Path p : jarFiles) {
//				System.out.println(p);
//			}
			
			
		}else {
			//repository 경로가 없으면
			System.out.println("Repository path" + repositoryPath +" 경로 가 없습니다");
		}
		
	}//end main
	
	private List<Path> getFiles(Path filePath, String fileExtension) throws IOException{
		/*
		 *  주어진 경로에서부터 시작하여 모든 이하 디렉토리들을 검색하여, 주어진 확장자에 일치하느 파일들의 목록 만들기
		 * 	@param filePath			: File의 절대경로
		 * 	@param fileExtension	: 검색할 파일의 확장자    (jar)
		 * 	@return			디렉토리 내에 있는 모든 파일들의 List
		 */
		
		
		//Files.walk(filePath).filter ==> exception 잡아줘야함
		return Files.walk(filePath).filter( p -> p.toString().endsWith(fileExtension)).collect(Collectors.toList());
	}//end getFiles
	
	private List<String> openJars(List<Path> jarFiles){
		
		int []badJars = {0};  //손상된 jar 파일
		
		//각각의 jar 파일에 대해 아래를 수행함
		jarFiles.forEach(path -> {
			String absPath = path.toString();
			
			//JarFile 이라는 객체가 있음
			try (JarFile File = new JarFile(path.toFile());){
					// jar 파일을 open 했으면 반드시 close 해줘야합니다.
				  // jar 파일 open 시도  ==> 성공했으면 그냥 넘어감
				
			} catch (IOException e) {	//jar open 실패하면 ioexception 이 떠버림
				String errMsg = "손상 jar 발견 : "+ absPath +" --exception : "+ e.toString();
				System.out.println(errMsg);
				badJars[0]++; //!  편법 try 캐치문의 지역변수 관련되서 배열을 쓰면 가능해진다.
				
				String downloardUrl = URL_MAVEN2 + absPath.substring(repositoryPath.toString().length()).replaceAll("\\\\", "/");
//				System.out.println(downloardUrl);  //확인용
				
				try {
					download(downloardUrl, absPath);
				} catch (Exception e2) {
					System.out.println("다운로드 실패");
				}
				
				
			}
			
		});
		System.out.println("손상된 jar 파일 개수 = " +badJars[0]);
		return null;
		
	} //end openJars()

	
	/**
	 *  특정 URL 의 파일 다운로드
	 * @param srcUrl
	 * @param dstFile
	 * @throws IOException
	 */
	public void download(String srcUrl, String dstFile) throws IOException{
		
		URL url = null;
		HttpURLConnection conn = null;
		InputStream in = null;
		BufferedInputStream bin = null;
		FileOutputStream out = null;
		BufferedOutputStream bout = null;
		
		try {
			System.out.println("다운로드 시도 : "+srcUrl + "\n\t -> "+dstFile);
			
			url = new URL(srcUrl);
			conn = (HttpURLConnection) url.openConnection(); // HttpURLConnection 를 쓰면 파일의 크기를 알수있다.
			int contentLength = conn.getContentLength(); // 파일 크기
			String contentType = conn.getContentType();  // 파일 종류 MIME-TYPE
			
			//다운로드 받는 파일이름 확인가능
			String raw = conn.getHeaderField("Content-Disposition");  // attachment;    filename = abc.jpg 이런식
			if(raw != null && raw.indexOf("=")!= -1 ) {
				String fileName = raw.split("=")[1].trim();
//				dstFile = URLDecoder.decode(fileName, "utf-8");
			}
			
			in = conn.getInputStream();
			bin = new BufferedInputStream(in);
			out = new FileOutputStream(dstFile);
			bout = new BufferedOutputStream(out);
			
			int bytes; //읽어들인 파일의 크기
			byte[] buf = new byte[contentLength];
			while((bytes = bin.read(buf)) != -1 ){
				bout.write(buf, 0, bytes);
			}
			// 다운로드 성공
			System.out.println("다운로드 성공\t "+ contentLength + " bytes "+contentType);
			
		} finally {
			if(bout!=null) bout.close();
			if(bin!=null) bin.close();
		}
		
		
		
		
		
		
		
	}
	
}


















