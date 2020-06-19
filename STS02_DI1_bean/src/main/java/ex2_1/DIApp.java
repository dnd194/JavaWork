package ex2_1;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class DIApp {

	public static void main(String[] args) {
		System.out.println("main () 시작");
		
		AbstractApplicationContext ctx = 
				new GenericXmlApplicationContext("classpath:applicationContext.xml");
		System.out.println("컨테이너 생성");
		
		OperatorBean operator = null;
		operator = (PlusOp)ctx.getBean("PlusOp");
		int value = operator.doOperate();
		System.out.println("결과 : "+value);
		
		
		operator = (MinusOp)ctx.getBean("MinusOp");
		value = operator.doOperate();
		System.out.println("결과 : "+value);
		
		
		ctx.close();
		System.out.println("main () 종료");
	}

}
