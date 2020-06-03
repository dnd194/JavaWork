/*
객체 생성자 상속받기
예를 들어서 우리가 Cat 과 Dog 라는 새로운 객체 생성자를 만든다고 가정해봅시다. 그리고, 해당 객체 생성자들에서 Animal 의 기능을 재사용한다고 가정해봅시다. 그렇다면, 이렇게 구현 할 수 있습니다.

*/

//------------------------------------------
// 상속을 사용하지 않는 경우
{
    console.log("상속을 사용하지 않는 경우");
    function Dog(name, sound) {
      this.type = "개";
      this.name = name;
      this.sound = sound;
    }
  
    function Cat(name, sound) {
      this.type = "개";
      this.name = name;
      this.sound = sound;
    }
  
    Dog.prototype.say = function() {
      console.log(this.sound);
    };
    Cat.prototype.say = function() {
      console.log(this.sound);
    };
    let dog = new Dog("멍멍이", "멍멍");
    let cat = new Cat("야옹이", "야옹");
  
    dog.say();
    cat.say();
  
    // 위 코드를 보면 Dog, Cat 에 동일한 코드가
    // 계속해서 중복으로 사용되고 있다..
    // 이러한 경우, 상속이 필요하다
  }
  //////////////////////////////////////////////////////////////////
  //상속을 사용하는 경우
  console.log("상속 사용시");
  function Animal(type, name, sound){
    console.log('Animal() 생성');

      this.type = type;
      this.name=name;
      this.sound=sound;
  }
  Animal.prototype.say=function () {
      console.log(this.sound);
}
Animal.prototype.sharedValue = 1;
// 생성자 상속
// Animal.call 을 호출!
//여기서 ''''''첫번째 인자에는 this '''''''''를 넣어주어야 하고,
// 그 이후에는 Animal 객체 생성자 함수에서 필요로 하는 파라미터를 넣어주어야 합니다.

// 추가적으로 prototype 을 공유해야 하기 때문에
// 상속받은 객체 생성자 함수를 만들고 나서 
// '''''prototype 값을 Animal.prototype 으로 설정''''''해주었습니다.

// Dog() 와 Cat() 을 Animal() 이
// 가지고 있던것을 재사용함
function Dog(name, sound){
    console.log('Dog() 생성');
    Animal.call(this,"개",name,sound);
    //call(this, 상속하는 객체(부모) 생성자 매개변수들.........)
    this.weight = 34.5;
}
// 프로토타입을 연결시켜줘야함
Dog.prototype = Animal.prototype;  //이 작업이 상속

function Cat(name, sound){
    console.log('Cat() 생성');
    Animal.call(this,"양이",name,sound);
}
Cat.prototype = Animal.prototype;

let dog = new Dog('개','멍멍머어멍멍');
let cat = new Cat("ㄴㄴㅁㄴㅇ",'ㄴㅇㅁㄴㅇㅁㄴㅇ');
dog.say();
cat.say();
