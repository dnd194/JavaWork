/* object 의 getter, setter

getter 함수: 특정 값을 조회할때마다
setter 함수: 특정 값을 설정할때마다

https://developer.mozilla.org/ko/docs/Web/JavaScript/Reference/Functions/get

ES 5.1 에 최초 정의
https://www.ecma-international.org/ecma-262/5.1/#sec-11.1.5

ES 6 에서 계산된 프로퍼티 이름이 추가
https://www.ecma-international.org/ecma-262/6.0/#sec-method-definitions


JS 에서 매우 유용

*/

const numbers={
    a:1,
    b:2,

    //getter 함수
    get sum(){
        //get 이라는 keyword 로 시작
        console.log("sum function start");
        //반드시 무엇인가를 return 해줘야한다.
        return this.a + this.b;
        // return 이 빠지면 undefined를 return 해준다
    }
}

// console.log(numbers.sum());  ==> sum은 함수가 아니라 getter 임 
// ==> 에러가 난다 그래서 다음과 같이 사용
console.log(numbers.sum);

//setter 함수
const dog = {
    _name : "멍멍ㅁ엄어멍머엄ㅇ",

    //setter 함수 
    //set 이라는 keyword 로 시작
    set name(value){
        // set 함수는 반드시 매개변수가 설정되어야한다.
        console.log("이름이 바뀝니다.."+value);
        this._name=value;

    }
}
console.log();
console.log(dog._name);
// dog.name('뽀삐')== > 에러 (직접적으로 호출할수 없다.)
dog.name="뽀쁴";
console.log(dog._name);
console.log();

console.log();
const numbers2 = {
    _a : 1,
    _b : 2,
    sum : function(){
        return this._a + this._b;
    }
}

console.log(numbers2.sum());
numbers2._a = 10;
numbers2._b = 20;
console.log(numbers2.sum());
console.log(numbers2.sum());
console.log(numbers2.sum());
console.log(numbers2.sum());
console.log(numbers2.sum());
console.log(numbers2.sum());
console.log(numbers2.sum());
console.log(numbers2.sum());
console.log(numbers2.sum());


const numbers3 = {
    _a : 1,
    _b : 2,
    sum : 3,
    get a(){
        return this._a;
    },
    get b(){
        return this._b;
    },

    set a(value){
        this._a = value;
        this.sum = this._a + this._b;
    },

    set b(value){
        this._b = value;
        this.sum = this._a + this._b;
    }
}
console.log('------------------------------');
console.log(numbers3.sum);
numbers3.a =10;    //setter 동작 + 연산이 발생
numbers3.b = 20;
console.log(numbers3.sum);  //여러번 조회해도 이미 연산된 결과값만보여줌, 재 계산하지않음
console.log(numbers3.sum);
console.log(numbers3.sum);
console.log(numbers3.sum);
console.log(numbers3.sum);
console.log(numbers3.sum);













































