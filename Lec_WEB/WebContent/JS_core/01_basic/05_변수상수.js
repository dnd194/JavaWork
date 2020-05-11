//var ,let ,const

//var 를 사용한 변수 선언
var a = 100;
console.log('a= ', a)
a =200
console.log('a= ',a)

//var를 사용하면 '''''''중복선언가능''''''''''''
var a = 500;
console.log('a= ',a)

//es6 부터 let , const 로 변수 상수 지정
let value = 177;
console.log('value = ', value)
value = 555;
console.log('value = ', value)

//let value = 277;      '''중복선언 불가능'''   SyntaxError: Identifier 'value' has already been declared


//          상수 선언
const b = 1;
console.log('b= ',b )
// b = 2;    TypeError: Assignment to constant variable.  상수에는 값을 더 할당할 수 없음
console.log('b= ',b )

//-------------------------------
// var 는 오늘날 JS에서 권장하지 않음

// var 와 let
// IE9, IE10  와 같은 구형 브라우저에서는
//  let, const 를 사용 못함.

// 개발 단계에서는 '바벨' 등을 사용하여
// 우리가 개발한 코드가 구형 브라우저 에서동 동작케 함.

let c; //선언만 해줘도 가능
c = 100;  //선언 과 초기화 따로 해도 됨 

// ` : back tick   1옆에 있는거 홀 따옴표랑 헤깔리지마세염
console.log(`c = ${c}`);  //Template Literal (ES6 <= )

let value2 = 100;  //number 타입
console.log(value2, typeof value2); 
console.log(value2, typeof (value2)); 

//JS는 대입되는 값에 따라 ''''타입''''이 바뀜
value2 = 'hawi'
console.log(value2, typeof (value2)); 
