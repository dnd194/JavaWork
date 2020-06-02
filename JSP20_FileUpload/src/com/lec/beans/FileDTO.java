package com.lec.beans;

public class FileDTO {
	
	private int uid;			//bf_uid
	private String source;		//bf_source
	private String file;		//bf_file
	private boolean isImage; 	//이미지 여부
	
	
	//생성자 getter//setter
	public FileDTO() {
		super();
	}
	
	public FileDTO(int uid, String source, String file) {
		super();
		this.uid = uid;
		this.source = source;
		this.file = file;
	}

	public FileDTO(int uid, String source, String file, boolean isImage) {
		super();
		this.uid = uid;
		this.source = source;
		this.file = file;
		this.isImage = isImage;
	}
	
	
	public int getUid() {
		return uid;
	}
	
	public void setUid(int uid) {
		this.uid = uid;
	}
	
	public String getSource() {
		return source;
	}
	
	public void setSource(String source) {
		this.source = source;
	}
	
	public String getFile() {
		return file;
	}
	
	public void setFile(String file) {
		this.file = file;
	}
	
	public boolean isImage() {		//getIsImage 와 똑같음
		return isImage;
	}
	
	public void setImage(boolean isImage) {
		this.isImage = isImage;
	}
	
	
	
}
