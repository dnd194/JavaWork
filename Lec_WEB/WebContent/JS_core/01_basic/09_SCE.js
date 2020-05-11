//논리연산자
// && and 연산자
// || or 연산자
// ! not 연산자


// 논리연산자를 이용한 조건문 실행
// Short Circuit Evaluation

// 표현식1 && 표현식2
//  표현식1 이 Falsy 이면 && 의 결과값은 표현식1
//  표현식1 이 Truthy 이면 && 의 결과값은 표현식2

// 표현식1 || 표현식2
//  표현식1 이 Falsy 이면 && 의 결과값은 표현식2
//  표현식1 이 Truthy 이면 && 의 결과값은 표현식1



console.log(true && true)
console.log(true && false)

let a = 100
console.log(a > 10 || a + 10 < 10)
console.log(a < 10 || a + 10 < 10)

console.log(a > 10 && a + 10 < 10)
console.log(a < 10 && a + 10 < 10)

// || or 연산자
console.log("Hello" || "world")  // 표현식 1이''참''이면 ''왼쪽 결과 값'''이 나옴 
console.log(0 || "world")   //표현식 1이 ''거짓''이면 '''오른쪽''' 결과 값이 나옴

//&& and 연산자    
console.log(5 && 100) //100  // 표현식 1이''참''이면 ''오른쪽 결과 값'''이 나옴 

console.log(5 && 0) 

console.log(null && 'hello')  // null   표현식1이 거짓이면 왼쪽 값이 나옴
// ===> 왼쪽이 거짓이니 오른쪽까지 갈 필요가 없기 때문임
console.log(100-100 && [10,20,30])  // 0 이 나옴 
//0 은 falsy 값임 


let n = 15;
(n % 5 === 0) && console.log('5의 배수입니다')

n = 7;
(n % 5 === 0) || console.log('5의 배수가 아닙니다')