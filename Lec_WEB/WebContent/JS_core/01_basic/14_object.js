console.log('object');

x={firstName:"June", lastName:"Kei"};
console.log(x, typeof x);
console.log(x.firstName, typeof x.firstName);
// console.log(x['firstName']);

//object는 length 가 없다 
console.log(x.length);  //  ==> undefined

for(key in x){  //==> property ( key 값) 이 추출됨  (String 형태로 return)
    console.log(`x[${key}] = ${x[key]}`);
}

// value 는 어떠한 타입이라도 가능

x={
    name:"kelvin"
    , age : 34
    , height : 1123
    , score:[20,50,155]
    , hawi:function(){
        console.log("하위하위");
    }
    , getScore : function(n){
        return this.score[n];   //같은 식구를 사용할 때에는 반드시 this 사용
    }
    , getTotal : function(){
        var sum = 0;
        for(i = 0 ; i< this.score.length; i++){
            sum += this.score[i];
        }
        return sum;
    }
    , getAvg : function(){
        var sum = 0;
        for(i = 0 ; i< this.score.length; i++){
            sum += this.score[i];
        }
        return sum / this.score.length;
    }
};
console.log(x.name, typeof x.name);
console.log(x.age ,typeof x.age);
console.log(x.height ,typeof x.height);
console.log(x.score, typeof x.score , x.score.length);
x.hawi();
console.log(x.getScore(2));
console.log(x.getTotal());  //score 점수합계
console.log(x.getAvg());  //score 점수합계

console.log()
x={firstName:"June", lastName:"Kei"};
console.log(x);
x.firstName="kelvin";
x.lastName="Im";
console.log(x);

//추가할때는 그냥 없던 key , value 값 추가해주면됨
x.age = 25;
console.log(x);

//삭제시에는 delete 키워드 를 사용
delete x.age;
console.log(x);
console.log(x.age); //undefined  없는 property에 접근할시에 undefined 가 뜸

//함수가 object 생성자 로 사용 가능
function Person(firstName, lastName, age){
    //함수 안에서 this!
    this.firstName = firstName;
    this.lastName = lastName;
    this.age= age;
    // console.log(this);

}
Person('alm','kmaa',20);

var p1 = new Person('aaa', 'bbb', 2020);
console.log(p1);

var p2 = new Person('cline', 'ck',290);
console.log(p2);
























