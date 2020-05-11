// if else  else if 
a=100

if(a+1>100){
    let a = 10;
    console.log('if 안의 a 값은',a); //10  let a 값이 들어감
}

//조건식에서 참 거짓 판정시 아래와 같음 
// Falsy 로 평가될때!  오타 아님  falsy
// false, 0, '공백', null, undefined, NaN   <-- 'Falsy 한 값'이라 한다

// Truthy 로 평가될때
// true, 37, 'Mark', {}, []   <-- 'Truthy 한 값' 이라 한다

function print(data){  //함수에 타입필요없고 그냥 데이터이름만 넣으면됨
    if(data){   //참 거짓 판정 참=>truthy  거짓 => falsy
        console.log(data, typeof data, '--Truthy')
    }else{
        console.log(data, typeof data, '--falsy')
    }
}
print(true)
print(false)
print(100)  // T
print(0)  // F
print(-1)  // T 
print('hello') // T
print("") // F
print([10, 20, 30])  // T
print([])  // T  , ★ 파이썬 과는 다르다!
print({'name' : 'John', 'age': 32})  // T
print({})
print(null)
print(undefined)
print(NaN)
console.log(100/0)  //infinity
print(100/0)  // t

print()   //호출시 매개변수가 없으면 undefined 값으로 동작함  

console.log()  //줄바꿈됨 println 이랑 동작똑같음

//falsy 값에 ! 을 더하면 true 가 나옴
console.log(!undefined)
console.log(!null)
console.log(!0)

//마찬가지로 truthy 값에 ! 을 더하면 false 가 나옴
console.log(!3)
console.log(!"Hello")
console.log(!" ")
console.log(![10, 20, 30])
console.log(![])
console.log(!{})

//truthy, falsy 판정결과 ---> boolean
//1. 3항 연산자 사용
let value={'a':100}
let isTrue= value ? true : false
console.log('isTrue = ',isTrue,typeof isTrue)

//2. !!사용하면 가능
isTrue =!!value;
console.log('isTrue = ',isTrue,typeof isTrue)

console.log()

function printName(person){
    console.log('이름은',person.name)
}

let myBrother ={name : "John"}
printName(myBrother)
// printName()  //Cannot read property 'name' of undefined'

function printName(person){
    //매개변수 null check
    // if(person === undefined || person===null) return;
    if(!person) return;  //==> 이렇게 ! 갖다박아도 됨 
    console.log('이름은',person.name)
}

printName(myBrother)
printName()
