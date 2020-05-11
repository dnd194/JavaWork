
//방법 1 : [ ] 사용
var points=[40,100,1,5,25,10]

var fruit=['banana','apple','orange','mango']

console.log('points = ',points, typeof points) //배열의 타입을 object 로 나옴

//방법2 : new 사용
var cars = new Array("saab",'volvo','bmw'); //비추 복잡한 메커니즘
console.log('cars = ', cars, typeof cars)

console.log('fruit = ', fruit.toString())

for(i=0; i< cars.length; i++){
    console.log(cars[i])
}

console.log()

var length = cars.length;
for(i=0; i< length; i++){
    console.log(cars[i])
}

//for ~ in    객체(OBJECT)에 대해 사용, property       ''인덱스'' 가 나온다
for(x in cars){
    console.log('x = ',x )
}
console.log()
//for - of          ES6 부터 ITERABLE 한 객체에 대해 사용
for(x of cars){       //value 값이 나옴
    console.log('x = ',x )
}
console.log()
// 배열.forEach(함수)
//배열 원소 하나하나 뽑아내면서 함수호출
var myFunction = function(value){
    console.log(value);
}

cars.forEach(myFunction)  // sab , volvo , bmw 


//배열 원소 추가
console.log()
fruit[fruit.length]='Melon'
console.log('fruit = ', fruit)

fruit.push('Lemon')
console.log('fruit = ', fruit)
console.log()
console.log()
//주어진 변수가 배열인지 아닌지 판단
// typeof 만으로는 알 수 가없다

//1. isArray() : es5.1부터 지원
console.log(Array.isArray(fruit))

//2. 옛날버전의 브라우저에서 확인하려면 함수를 직접 만들어서 판단해야함
function isArray(x){
    return x.constructor.toString().indexOf('Array') > -1;
}
console.log(isArray(fruit));

//3. instanceof
console.log(fruit instanceof Array); 

////////////////////////////////////////////////////

// join()     ==> 하나의 문자열로 return 
console.log(cars.join("**"))
console.log([2020,5,7].join("/"))

// push() : 배열끝 원소 추가
// pop() : 배열 끝 원소 추출
// shift() : 배열 첫 원소 추출
// unshift() : 배열앞에 원소 추가, 새로운 length 리턴
console.log()
console.log(fruit.toString())
console.log(fruit.pop())
console.log(fruit.toString())
console.log(fruit.shift())
console.log(fruit.toString())
console.log(fruit.unshift('grape'))  //==> 새로추가된 원소를 포함한 length를 출력
console.log(fruit.toString())

// splicing
//  첫번째 매개변수 : 삽입될 데이터 위치
//  두번째 매개변수 : 삭제될 데이터 개수
//  세번째 이후 .. : 삽입될 데이터 들..

console.log()
fruit.splice(2,0,"kiwi", "jadu","ggul" )
console.log(fruit.toString())
fruit.splice(1,3,"hawii" )
console.log(fruit.toString())

fruit.concat(['라면','신라면'])   //concat은 원본을 변화시키지 않는다
console.log(fruit.toString())   //라면, 신라면은 추가되어있지 않음

//덮어씌우면 가능
fruit = fruit.concat(['라면','신라면'])
console.log(fruit.toString())

//배열 데이터 중간을 삭제하려면
fruit.splice(1,3)
console.log(fruit.toString())

//slice()
//배열의 일부분만 추출, 원본에는 영향 안줌
console.log(fruit.slice(1,3))  //1부터 3전까지
console.log(fruit.slice(1))     //1부터 끝가지

//배열의 원소는 어떠한 타입이어도 가능
var arr = [10,3.14,'hello',null,undefined,function(a,b){return a+b;}]

//배열의 원소가 배열일 수도 있다 ... >> 다차원배열
arr = [[10,20],[30,40],[50,60]]
//arr.length --> ?
//for 문 사용하여 출력
for(i = 0; i<arr.length; i++){
    console.log(arr[i].toString())
}





