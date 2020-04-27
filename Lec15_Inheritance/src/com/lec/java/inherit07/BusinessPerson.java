package com.lec.java.inherit07;

public class BusinessPerson extends Person{

	private String company;

	
	//getter / setter
	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}
	
	
	//method overriding
	@Override    //annotation 지금은 있어도 그만 없어도 그만이지만 후반에는 필요함
	public void showInfo() {
		super.showInfo();
		System.out.println("회사는 : "+company);
	}
	
	//METHOD OVERLOADING
	public void showInfo(int id) {
		System.out.println("id 는 "+id);
	}

	
	/*
	 * //단축키 alt+shift + s + v
	 * 
	 * @Override public void whoAreyou() { // TODO Auto-generated method stub
	 * super.whoAreyou(); }
	 */
	@Override
	public String toString() {     //객체를 문자열로 표현할 때 주로 사용
		// TODO Auto-generated method stub
		return "BusinessPerson : "+getName()+" "+company;
		
		//getName() 대신 name 으로쓰면 안됌 주의 어짜피 오류나지만 name 은 super의 private 멤버 임 
	}
	
	
}
