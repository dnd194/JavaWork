const dog = {
    name: '멍멍이',
    sound: '왈왈',

    //객체 안에 함수를 정의하는 다양한 방법들

    //1.
    say1: function aaa() {
        console.log(this.sound);
        //this는 함수가 위치한(소유한) 객체
    },
    //2. 이름없는 함수
    say2: function () {
        console.log(this.sound);
    },

    //3. 가장 최신 방식 
    // ==> 근데 웹에서는 못읽어들여서 쓰면 안돼
    say3() {
        console.log(this.sound);
    },

    //4. 화살표 함수 방식 일 경우에는 undefined 가 나온다.
    say4: () => {
        console.log(this.sound);
    }

    // 이유
    // function 키워드로 만든 함수에서의 this는
    // 자기가 속해있는, 객체를 가리키는데..
    // 화살표 함수의 경우
    // this를 자기가 속해 있는 곳으로
    // 연결하지 않습니다.
    // 화살표 함수는 this 가 뭔지 모릅니다!
    // ====>>> 즉 화살표 함수에서는 '''this''' 쓰지 않는다.
};

dog.say1();
// dog.aaa(); ==> 에러 남 
dog.say2();
console.log();
dog.say3();
console.log();
// dog.say4();  

const cat = {
    name : '냐옹이',
    sound : ' 미야옹',
    say1: function aaa() {
        console.log(this.sound);
        //this는 함수가 위치한(소유한) 객체
    }
};

dog.say1();
cat.say1();    //이때 this 는 cat 이 된다.

const sayCat = cat.say1;    //이때 say1 뒤에 () 넣으면 안된다.
console.log(typeof sayCat);  // 함수 형태
sayCat();  //undefined 가 나옴  ===> this에 아무것도 연결되지 않는다
//this 가 undefined 상태



















