package com.lec.java.oop02;

/* 다형성의 유용성
	다형성에 의해서, 자식타입 객체가 부모타입으로 자동 형변환 가능!
	부모타입 만으로도 상속된 모~든 자손 타입들을 담을수 있다.
*/

public class Polymorphism02Main {

	public static void main(String[] args) {
		System.out.println("다형성의 사용 (유용성)");

		Vehicle v1 = new Vehicle();
		Vehicle v2 = new Car();
		Vehicle v3 = new HybridCar();

		// 다형성의 유용함1
		// 조상타입으로 모든 자손타이블 담을 수 있다.
		Vehicle[] car = new Vehicle[3];
		car[0] = new Vehicle();
		car[1] = new Car();
		car[2] = new HybridCar();

		// car 라는 하나의 이름의 변수로 여러가지 타입의
		// 오버라이딩 된 메소드를 각 각 동작시킬 수 있다.

		for (int i = 0; i < car.length; i++) {
			car[i].displayInfo();
		}
		// 다형성이 없었다면? 각 타입별로 변수들을 만들고 따로따로 사용해야 하는 왕불편.
		// Vehicle car1 = new Vehicle();
		// Car car2 = new Car();
		// HybridCar car3 = new HybridCar();
		// car1.displayInfo();
		// car2.displayInfo();
		// car3.displayInfo();
		// 이렇게 손 아프게 해야함

		// 다형성의 유용함 2
		// 다형성의 유용함은 매개변수, 혹은 리턴 타입에도 적용된다
		// println의 매개변수로 Object의 참조변수가 넘겨지면,
		// 내부적으로 해당 클래스의 toString() 메소드가 불리게 됨

		System.out.println(v1);
		System.out.println(v2);
		System.out.println(v3);
		System.out.println();
		for (int i = 0; i < car.length; i++) {
			System.out.println(car[i]);
		}

		System.out.println();
		driveCar(new Vehicle(), 100); 	// 받는 매개변수가 조상타입이라 자손타입으로 표현되는 것 가능
		driveCar(new Car(), 200); 		// 받는 매개변수가 조상타입이라 자손타입으로 표현되는 것 가능
		driveCar(new HybridCar(), 300); // 받는 매개변수가 조상타입이라 자손타입으로 표현되는 것 가능
		
		//instanceof 연산자
		//용법 : 변수  / 값      instanceof    클래스
		//결과 : boolean 타입  true or false
		System.out.println();
		System.out.println(v1 instanceof Vehicle);
		System.out.println(v1 instanceof Car);
		System.out.println(v2 instanceof Vehicle);
		System.out.println(v2 instanceof Car);
		
		
		
		
		
		
		
		System.out.println("\n 프로그램 종료");
	} // end main()

	public static void driveCar(Vehicle v, int speed) { // 받는 매개변수가 조상타입이므로 가능
		v.setSpeed(speed);
		v.displayInfo();
	}

} // end class
