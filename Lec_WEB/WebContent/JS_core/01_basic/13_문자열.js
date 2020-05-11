var str1, str2, str3 ;

str1 = "JOHN"
str2 = new String('JOHN') //비추

console.log(str1 == str2)
console.log(str1 === str2)

console.log(str1.length); // 문자의 개수

str2 = "Hello Java Web FrameWork";
console.log(str2);
// 문자열 리터럴 중간을 끊어서 작성할 경우..
str2 = "Hello Java W\
eb FrameWork";
console.log(str2);

// indexOf(), lastIndexOf(), search() : 문자열 안에서 문자열 찾기
// 찾은 위치 인덱스 리턴, 못찾으면 -1 리턴
console.log("문자열 검색 \nindexOf(), lastIndexOf(), search()");
str1 = "Please locate where 'locate' occurs!";
console.log(str1.indexOf("locate"))  //7번째에서 발견
console.log(str1.lastIndexOf("locate")) //21번째 에서 발견

console.log(str1.indexOf("john"))  //없으면 -1 을 return
console.log(str1.indexOf("locate",10))  //10번째 index부터 검색시작
console.log(str1.indexOf("locate",25))  //25번째 index부터 검색시작

//search() : 문자열 안에서 문자열 찾기
console.log(str1.search("locate"))


// search() vs indexOf() : 둘은 다르다!
// 	search() : 두번째 매개변수 없다
// 	indexOf() : regexp 사용 불가

//문자열 추출
//slice(start, end)
//substring(start, end)
//substr(start, length)
console.log("문자열 추출\n slice(), substring(), substr()");
str1 = "Apple, Banana, Kiwi";
console.log(str1.slice(7,13))
console.log(str1.slice(-12,-6))  //음수일때는 오른쪽부터
console.log(str1.slice(7));   // 7부터 끝가지
console.log(str1.slice(-12)); // -12부터 끝까지

console.log(str1.substring(7, 13));  // slice()와 유사하나 음수인덱싱 지원안함.
console.log(str1.substring(7));   // 7부터 끝까지

console.log(str1.substr(7,6)); //7부터 6글자.. 2번째 매개변수를 빼면 끝까지임

// 문자열 치환
// replace() : 치환한 결과 문자열 리턴, 정규표현식 사용 가능
// 기본적으로 첫번째 '매칭된 문자열 만 치환
console.log("문자열 치환 replace()");
str1 = "Please visit Japan!";
console.log(str1.replace("Japan","Korea"))  //원본을 변화시키지 않음 그래서 덮어씌우기
console.log(str1.replace(/JapAn/,"Korea"))  //정규표현식 사용 가능
console.log(str1.replace(/JAPAN/i,"Korea"))  //i 를 붙이면 대소문자구별하지 않음

str2 = "Please visit Japan! go Japan";
console.log(str2.replace("Japan","Korea"))
console.log(str2.replace(/Japan/g,"Korea"))

str3 = "Hello World!";
console.log(str3.toUpperCase());
console.log(str3.toLowerCase());

str1 = "Hello"; str2 = "World";
console.log(str1 + " " + str2);
console.log(str1.concat(" ", str2));

// trim() : 좌우 공백 제거
str1 = "       Hello World!        ";
console.log(`str1 = [${str1}]`)
str2 = str1.trim();
console.log(`str2 = [${str2}]`);

// split() : string -> array
str3 = '2020-05-07';
console.log(str3.split('-'))





