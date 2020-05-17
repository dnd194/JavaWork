(function(){
    //이름없는 함수 호출
    //바다
    var $waterFront = $('#water-front');
    var $waterBack = $('#water-back');

    (function loopSea(){
        $waterFront.animate({'bottom':'-65px', 'left': '-30px'},500)
        .animate({'bottom':'-60px', 'left ': '-25px'},500);

        $waterBack.animate({'bottom':'15px', 'left': '-45px'},500)
        .animate({'bottom':'10px', 'left ': '-25px'},500);

        $.when($waterFront, $waterBack).done(loopSea);

    })();

    // 구름 움직이게 만들기
    var $cloud1 = $('#cloud-group-1');
    var $cloud2 = $('#cloud-group-2');

    (function loopCloud(){
        $cloud1.animate({'left' : '-720px'},7000)
                .animate({'left' : '0px'},0,loopCloud);
        $cloud2.animate({'left' : '-720px'},8000)
                .animate({'left' : '0px'},0,loopCloud);
    })();
    
    // 보트 효과주기
     //페이지 로딩될때 단한번
    var $boat =$('#boat');
    var $questionMark = $('#question-mark');
    var $title1 = $('#title1');
    var $title2 = $('#title2');
    var $form = $('#form');

    $boat.css({'left' : '-220px'});  //보트의 최초 화면 설정 (왼쪽으로 조금만보이게)
    $questionMark.css({'opacity':0});  //초기에 물음표 안보이게 설정
    $title1.css({'opacity': 0});    //초기 설정
    $title2.css({'opacity': 0});    //초기 설정
    $form.css({'left': '370px'});   //초기 설정
    

    //첫번 째 방법
    // $boat.animate({'left':'20px'},2000 ,function () {
    //     loopBoat();
    //     $questionMark.delay(500).animate({'opacity':1},1000,function() {
    //         $title1.animate({'opacity':1},800,function(){
    //             $title2.animate({'opacity':1},900,function(){
    //                 $form.animate({'left':0},650);
    //             });//end title2
    //         }); //end title1
    //     });//end questionmark
    // });  //end boat

    //2번째 방법  when
    
    // $.when($boat.animate({'left':'20px'},2000))
    //     .then(function(){
    //         loopBoat();
    //     })
    //     .then(function(){
    //          return $.when($questionMark.delay(500).animate({'opacity':1},1000))
    //     })
    //     .then(function(){
    //         return $.when($title1.animate({'opacity':1},800))
    //     })
    //     .then(function(){
    //         return $.when($title2.animate({'opacity':1},800))
    //     })
    //     .then(function(){
    //         return $.when($form.animate({'left':0},650,reload))
    //     });

    //3번째 방법 단일 애니메이션의 연속인경우 promise() 만으로 가능
    //promise() 도 thenable 객체를 return
    $boat.animate({'left':'20px'},2000).promise()
        .then(function(){
            loopBoat(); 
            return $questionMark.delay(500).animate({'opacity':1},1000).promise();
        })
        .then(function(){
            return $title1.animate({'opacity':1},800).promise();
        })
        .then(function(){
            return $title2.animate({'opacity':1},800).promise();
        })
        .then(function(){
            $form.animate({'left':0},650,reload);
        })
    ;


    

    //보트 떠다니는 효과 를 정의하고 위에서 실행 
    function loopBoat(){
        $boat.animate({'bottom':'15px'},500)
        .animate({'bottom':'25px'},500,loopBoat);
    }

    function reload(){
        setTimeout(function(){
            location.reload();
        },5000);
    }







})()



    