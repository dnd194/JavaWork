// 변수의 유효범위
// scope

// const, let 의 유효범위
//  ==> Block Scope
//    { ... }


//블럭
{
    const name = 'kelvin'           //블럭 안에서만 사용가능
    console.log(`name = ${name}`);
}

//console.log(`name = ${name}`);  //블럭밖에서 사용할 경우 에러남 ReferenceError: name is not defined
// 지역변수 느낌인듯 

{
    // console.log('name = ',name)    
    //에러 name 이 초기화되어있지 않음 ReferenceError: Cannot access 'name' before initialization
    const name = 'mark'
}
{
    console.log('value1 = ',value1)  //출력값이 undefined 라고 나옴  이미 선언이 됬다고 판단하는 것
    var value1 = 200

    // console.log('value2 = ',value2)  //ReferenceError: value2 is not defined
}
// Hoisting
// https://developer.mozilla.org/ko/docs/Glossary/Hoisting

// 이러한 현상을 hoisting 이라 하는데
// hoisting 현상은 함수에서만 발생하는게 아니다.

// hoisting 
// ''''''''''''''아래에 있는 선언을(만) 끌어올린다.'''''''''''''

// hoisting 때문에 동작의 오류처럼 보이는 증상 겪게 됨

// hoisting 현상은 처음부터 있었으나
// 용어 자체는 ES2015 및 그 이전에는 사용되지 않음
{
        // console.log(`nick=${nick}`);

        console.log(`nick=${nick}`);  //2
        nick = 'mighty'   //1              //위에 nick이랑 아래 nick이 다름 (변수 타입이 다른듯)
        console.log(`nick=${nick}`);//1
        var nick = '이거는 나와요'  //2    var을 붙이지 않고 그냥 할 시에 그 상위단계로 정의가 됨
                                
}

age =6 ;
age++;
console.log(' 1 age =',age) //7
{
    console.log(`2 age = ${age}`) //7
    age = 30 
    console.log(`3 age = ${age}`) //30
    // var age;    //이거만 쓰였을경우 에러가 나지 않음
    // let age;    //let 은 hoisting 이 발생하지 않는다. 그래서 에러가 남 

}
console.log(`4 age = ${age}`)  //30













