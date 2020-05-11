// function 함수란

function add(a,b){
    return a+b;
}
var sum = add(1,2)
console.log("sum =", sum);

// JS 에선 '함수(function)' 도 데이터 다!
console.log(typeof add);
console.log(add);

// 따라서,
// 함수를 변수에 대입할수도 있고
// 함수를 매개변수로 넘겨줄수도 있고
// 함수를 리턴할수도 있다.

var add = function (a,b){
    return a+b;
} 
// 변수 add에 함수를 넣어주면 그때부터 함수임

var sub = function (a,b){
    return a-b;
}
console.log(sub(10,3))

let mul = function(a,b){return a * b;}
console.log(mul(4,5))

let bbb=mul;  // bbb도 함수가 됨  
console.log(bbb(10,10))

var arr =[add, sub, mul]  //3개의 함수를 담고있는 배열
console.log(arr[0](10,20))
console.log(arr[1](10,20))
console.log(arr[2](10,20))