package com.lec.java.printf;
/* 서식화된 문자열 (formatted string)
 *  ● 화면에 출력할때는 -> printf()
 *    
 *    printf("서식문자열", 값1, 값2....)
 *    
 *  ● 문자열(String)으로 만들때는 -> String.format()
 *       	
 *    String.format("서식문자열", 값1, 값2....)
 *    
 *  ● format specifier (서식 지정자)
 *  	%d  :  십진수 정수로 출력
 *  	%f  :  실수 출력
 *  	%s  :  문자열 출력
 *  	%c  :  '문자하나' 출력
 *  	%x  :  16진수 정수로 출력
 *  	%%  :  % 출력
*/

public class PrintFormatMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("서식화된 출력: printf(), String.format()");

		double pi = Math.PI; // 원주율 값
		System.out.println(pi);
		
		//printf : print with format 서식문자를 출력
		//printf("서식 문자열", 값1, 값2, ...)
		//서식문자열 안에는 '%' 로 시작하는 서식지정자들
		
		System.out.printf("원주율 %f \n", pi); //줄바꿈안해줌 줄바꿈하고싶으면 '\n' 
		System.out.printf("원주율 %.2f \n", pi);  
								// '.2' 소수점 2자까지만 출력
		
		int age = 10;
		short grade =3;
		System.out.printf("나이는 %d살입니다 \n학년은 %d학년입니다",age,grade);
//		차례대로 값에 대입된다. 갯수는 일치시켜줘야함
		
		//소수점 이하 제안
		double height = 182.3;
		System.out.printf("저는 %d살입니다 키는 %.1fcm 입니다\n",age,height);
//		그냥 '%f' 할시 소수점 여섯자리 까지출력
		
		//출력폭 지정, 좌우 정렬
		System.out.printf("|%d|%d|%d|\n",100,200,300);
		System.out.printf("|%6d|%6d|%6d|\n",100,200,300);
		//6칸에 맞춰서 출력 '%6' 오른쪽 정렬
		System.out.printf("|%-6d|%-6d|%-6d|\n",100,200,300);
		//6칸에 맞춰서 출력 '%6' 왼쪽 정렬
		
		System.out.printf("제 이름은 [%10s] 입니다.\n혈액형은 %c형 입니다.\n","임상빈",'A');
		
		// '%' 자체를 출력하려면 %% 를하면됨
		double rate = 134423.0 / 345678.0;
		System.out.printf("합격률은 %.1f%%입니다\n",rate);
		
		//숫자에 패딩
		System.out.printf("|%05d|%05d|%05d|\n",100,200,300); 
						// %05d 는 공백이 0으로 채워짐
//		format 문자열을 따로 설정해서 운영
		String fmt = "주소 : %s, 우편번호[%05d]";
		System.out.printf(fmt +"\n","서울",12345);
		System.out.printf(fmt +"\n","광주",670);
		System.out.printf(fmt +"\n","대구",44);
		System.out.println(); //줄바꿈
		
		//String.format()
		String.format("합격률은 %.1f%%입니다\n", rate); //화면 출력용이 아님, 그냥 문자열
		String result = String.format("합격률은 %.1f%%입니다\n", rate);
//		result 라는 변수에 담아서 출력
		System.out.println(result);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
