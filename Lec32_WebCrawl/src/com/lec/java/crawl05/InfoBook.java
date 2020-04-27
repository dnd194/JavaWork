package com.lec.java.crawl05;

public class InfoBook {
	private String bookTitle;  //책 제목
	private double price;      //책 가격
	private String url;        //상세페이지 url
	private String imgUrl;     //썸네일 url
	
	//기본생성자
	public InfoBook() {
		
	}
	// 매개변수 생성자
	public InfoBook(String bookTitle, double price, String url, String imgUrl) {
		
		this.bookTitle = bookTitle;
		this.price = price;
		this.url = url;
		this.imgUrl = imgUrl;
	}
	//GETTER  &  SETTER 
	public String getBookTitle() {
		return bookTitle;
	}

	public void setBookTitle(String bookTitle) {
		this.bookTitle = bookTitle;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getImgUrl() {
		return imgUrl;
	}

	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}
	@Override
	public String toString() {
		return "[bookTitle=" + bookTitle + ", price=" + price + ", url=" + url + ", imgUrl=" + imgUrl + "]";
	}
	
	
}
