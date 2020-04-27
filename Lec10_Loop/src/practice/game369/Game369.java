package practice.game369;

public class Game369 {
	public static void main(String[] args) {
		

		for (int count = 1; count <= 100; count++) {
		    String convert = Integer.toString(count);   // int -> string
		    boolean check = false;                      //3,6,9 검사 초기값 세팅  
		    for (int i = 0; i < convert.length(); i++) {
		        char chk = convert.charAt(i);           //3,6,9 체크
//		        													**1 의자리와 10의 자리를 따로 검사하는프로그램이 필요
		        if (chk == '3' || chk == '6' || chk == '9') {
		            
		            System.out.print("*");    //3 , 6 , 9 가 포함되면 *     
		            
		            check = true;
		            break;						// 3,6,9 가 검출되면 break를 해서 탈출
		        }
		    }
		    if (!check) {
		        
		        System.out.print(convert);
		    }
		    if (count % 10 == 0) {
		    	System.out.println();
		    } else {
		        // 중간수면 한 칸 띄우기
		        System.out.print('\t');
		    }


		


		
		}
		
		
	}
}
