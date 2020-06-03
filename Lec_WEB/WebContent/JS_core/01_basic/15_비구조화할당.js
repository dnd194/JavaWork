const ironman = {        //key : valuse 로 이루어져있음
    name: '토니 스타크',
    actor : '로다쥬',
    alias : '아이언맨'
};

const captain = {        //key : valuse 로 이루어져있음
    name:'스팁ㅡ 뤄져스',
    actor :' 크릿',
    alias : ' cancer'
}

console.log(ironman);
console.log(captain);

function print(hero){     //홀 따옴표 아니라 백틱 써야해 까먹지 마세여~~
    let text = `${hero.alias}(${hero.name}) 배우 : ${hero.actor}`;
    console.log(text);
}
print(ironman);
print(captain);
// ES6 에 있는
// '비구조화할당 (destructuring assigment)문법'을 사용하면
// 객체변수.속성  <-- 좀더 편리하게 다룰수 있다.
// '비구조화할당 문법'
//   다른말로 ''''''객체 구조 분해'''''''   modern js

// 공식
// https://www.ecma-international.org/ecma-262/6.0/#sec-destructuring-assignment
// https://developer.mozilla.org/ko/docs/Web/JavaScript/Reference/Operators/Destructuring_assignment
// 추가 참조
// https://velog.io/@public_danuel/destructuring-assignment

// 비구조화 할당, 잘 사용하면 코드 깔끔해진다

function print(hero) {      //hero 란 오브젝트 매개변수가 다음과 같은 형식으로..
    
    //객체 구조 분해 
    // 오브젝트를 받은 다음에 다음과 같은 형식으로 분해를 한것
    const {alias, name, actor} = hero;   //const 오브젝트 
    //어떤 (key) 값 을 추출할지 명시
    let text = `${alias}(${name}) 배우 : ${actor}`;
    console.log(text);

}

console.log();
print(ironman);
print(captain);

// 함수 parameter(매개변수) 에도 비구조화 할당 가능 => 깔끔
function print2({alias,name,actor}){
    let text = `${alias}(${name}) 배우 : ${actor}`;
    console.log(text);
}

console.log();
print2(ironman);
print2(captain);


//꼭 함수안에서만 사용할 수 있는 것은 아님
console.log();
const {name}    = ironman;
console.log(name +" "+typeof name);








