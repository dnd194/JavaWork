/**
 * external 방식
 */

function light(sw){
    var pic;
    if(sw == 0){
        pic = "https://www.w3schools.com/html/pic_bulboff.gif";
    }else{
        pic = "https://www.w3schools.com/html/pic_bulbon.gif";
    }
    document.getElementById('myImage').src = pic; //img태그의 src 속성값을 바꿔줌
}


