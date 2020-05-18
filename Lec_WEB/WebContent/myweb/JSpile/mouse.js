$(document).ready(function () {
	//클릭시 좌표 알아내기  document 의 좌표를 알아야 하는것임
	$(document).click(function (e) { 
		//화면에 클릭한 좌표는 e 안에 담겨져있음
		// alert(e.pageX + " "+ e.pageY) 확인용

		var txt = e.pageX + " " + e.pageY;
		$('#div1').css({
			"left" : e.pageX ,
			"top" : e.pageY,
		});
		// $('#div1').text(txt);	확인용	

		//클릭한 곳에 동그라미 나타났다 사라지게 하기
		$('#circle').css({

			//원의 반지름 길이 만큼 해줘야 마우스의 포인터 위치에 원이 생김
			"left" : e.pageX - ($('#circle').outerWidth(true)/2),
			"top" : e.pageY - ($('#circle').outerHeight(true)/2),
		});

		// $('#circle').fadeIn(500).fadeOut(500); //확인용
		
		// 바로 효과를 중지하도록 해야함
		$('#circle').stop(true).fadeIn(100, function(){
			$('#circle').fadeOut(200);

			//aniamte 는 1개만 들어옴 fadein(안에 fadeout이 있기때문)
		})

	});
});