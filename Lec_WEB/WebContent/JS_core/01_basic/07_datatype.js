// 자료형 : data type

//  https://developer.mozilla.org/ko/docs/Web/JavaSCript/Data_structures

// 동적타이핑 (dynamic type)
// 변수는 고정타입이 없다

// ''''''''''runtime 에 개발자가 모르는 어떤 타입의 값이
//                                  들어올수 있다  주의!'''''''''''''''''

// 데이터 타입
// 1.기본타입 (primitive)
//  -- boolean
//  -- null
//  -- undefined    값자체가 대입된 적이 없을 때 나옴
//  -- number
//  -- string
//  -- symbol (ES6 에 추가)
//
// 2. 객체 (object)                 
//   ..

//-------------------------------------------------------------------------------------
//boolean 타입
// true / false 
{
    const isTrue = true;
    const isFalse = false;
    console.log(`isTrue = ${isTrue}`, typeof isTrue)
    console.log(`isFalse = ${isFalse}`, typeof isFalse)
    if(isTrue){
        console.log(isTrue, '참참참')
    }else{
        console.log(isTrue,'거짓거짓거짓')
    }
    //객체로 생성가능
    // 그러나 가능은 하지만 비추비추비추비추비추비추비추
    const a = new Boolean(false);           //비추비추비추비추비추비추비추
    console.log('a = ', a, typeof a)

    if(a){               // new 를 사용하여 생성하면 조건식에서 이게 거짓이 아니라 참으로 나옴
        console.log(a, '참입니다')
    }else{
        console.log(a, '거짓입니다')           
    }

    const b = Boolean(false);    //=> boolean()함수임  근데 new 를 붙이면 객체가됨 이상함
    console.log('b = ', b, typeof b);
    if(b){               // new 를 사용하여 생성하면 조건식에서 이게 거짓이 아니라 참으로 나옴
        console.log(b, '참입니다')
    }else{
        console.log(b, '거짓입니다')           
    }

}

//-----------------------------------------------------------
// null    ==>      값이 없는 object
console.log('\n<null>');
{
    const a = null;
    console.log('a = ', a, typeof a);  // null 은 object 타입
}

//----------------------------------------------
// undefined
// 아무 값도 대입 안된 상태
{
    let b;   // 아무값도 대입 안된 상태, undefined
    console.log('b =', b, typeof b);

    let a = 10;
    a = undefined  //다시 undefined로 대입 가능
    console.log('a= ',a, typeof a );

    a = null; b = undefined;
    if(a == b){  // == : ''''값''''이 같은지만 비교
        console.log('== 같습니다');  // == 같습니다.
    } else {
        console.log('== 다릅니다');
    }

    if(a === b){        //           === : 값 뿐만 아니라 ''''type'''' 까지 비교
        console.log('=== 같습니다');
    } else {
        console.log('=== 다릅니다');
    }

    //가급적으로 JS프로그래밍에 작성시 == 보다는 '''' === ''''추천
    // 마찬가지로 != 보단'''' !== ''''추천
}
//-----------------------------------------------
// number
console.log('\n<number>')
{
    // '''''''''실수이든 정수이든 모두 number 타입''''''''''
    const a = 37;     //정수
    console.log('a =', a, typeof a);
    const b = 3.14;  //실수
    console.log('b =', b, typeof b);
 
    const c = NaN;  // Not a Number    number 타입인데 number가 아님 그냥 받아들여
    console.log('c = ',c , typeof c )

    let d= Number(123);
    console.log(' d = ',d , typeof d)

    d = Number('123');          //number로 '''형변환'''이 됨
    console.log(' d = ',d , typeof d)

    d= Number('MARK');      //NAN 뜨면 잘못되어가고있는중이니까 다시 돌아가
    console.log(' d = ',d , typeof d)

    d = parseInt('123')         //number로 '''형변환'''이 됨
    console.log(' d = ',d , typeof d)

    d = parseInt('alice')       //NAN    exception이 나지않고 nan이 나옴============================
    console.log(' d = ',d , typeof d)

    d = parseFloat('3.14')
    d *= 2;
    console.log(' d = ',d , typeof d)
    
    d = parseInt('3.14')    //소수점 이하가 날라감
    console.log(' d = ',d , typeof d)

    num1 = 100; num2 = '100';
    if(num1 == num2){  // == <-- 값 을 비교 
        console.log(`${num1} == ${num2} 같다`);
    } else {
        console.log(`${num1} == ${num2} 다르다`);
    }

    num1 = 100; num2 = '100';
    if(num1 === num2){  // === <-- 값 + 타입 을 비교 
        console.log(`${num1} === ${num2} 같다`);
    } else {
        console.log(`${num1} === ${num2} 다르다`);
    }
}
/////////////////////////////////////////////////////////////////////////
//          String (문자열)
//   ' ~ '  ,  " ~ "
console.log('\n<String>')
{
    let a = 'Mark'
    console.log('a = ',a,typeof a)
    a="mark"
    console.log('a = ',a,typeof a)

     // She's gone
     a = "She's gone";
     console.log('a =', a, typeof a)
 
     // He says "Hello"
     a = 'He says "Hello"';
     console.log('a =', a, typeof a);
 
     // He says "I'm fine"
     a = "He says \"I'm fine\"";    //이스케이프 문자 사용
     console.log('a =', a, typeof a);

     // + 문자열 연산
    a = "Mark"
    let b = a + " Hamill";
    console.log('b =', b, typeof b);

    console.log(a * 2)  // NaN 

    // 문자열 비교연산 가능!  코드순 비교
    console.log("a" > "b")
    console.log("a" < "b")
    console.log("abc" < "abd")
    console.log("AAaa" > "AaAa")  // false  :   대문자 < 소문자
}
//-------------------------------------------------
// symbol  약간 깊이 있게 할 사람한테는 도움되는데 웹은...
// ES6 부터 출현
// https://developer.mozilla.org/ko/docs/Glossary/Symbol

// '고유'한 값을 만들어낼때 사용
console.log('\n<symbol>');
{
    const a = Symbol();   // new 사용하면 안됨. Symbol is not a constructor
    const b = Symbol(37);   // Symbol(매개변수)
    const c = Symbol('Mark');
    const d = Symbol('Mark');  // c, d 는 같은 것이 아니다!
                            // '고유' 한 Symbol 객체로 만들어진다.

    console.log('a =', a, typeof a);
    console.log('b =', b, typeof b);
    console.log('c =', c, typeof c);
    console.log('d =', d, typeof d);

    console.log(c == d)
    console.log(c === d)
    // 일반 문자열
    let e = 'Mark', f = 'Mark';
    console.log(f == e)
    console.log(f === e)
}


