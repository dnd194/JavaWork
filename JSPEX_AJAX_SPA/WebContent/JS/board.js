var page = 1;  // 현재 페이지 
var pageRows = 10;   // 한 페이지에 보여지는 게시글 개수
var viewItem = undefined; //가장 최근에 view 한 글 데이터


$(document).ready(function(){
	// 게시판 목록 1페이지 로딩
	loadPage(page);

	//글작성 버튼 누르면 팝업 
	$('#btnWrite').click(function(){
		setPopup("write");
		$('#dlg_write').show();
	});
	
	//모달 대화상자에서 close 버튼 누르면 닫기
	$('.modal .close').click(function(){
		$(this).parents('.modal').hide();
	});
	
	//글 작성 submit 되면
	$("#frmWrite").submit(function(){
		$(this).parents('.modal').hide();
		return chkWrite();
	});
	//글 삭제 
	$('#btnDel').click(function(){
		chkDelete();
	})
	
	
	//글 읽기 대화상자에서 삭제버튼 누르면 해당 글 삭제
	$('#viewDelete').click(function(){
		var uid = viewItem.uid;
		if(deleteUid(uid)){    //해당 글 삭제 
			$(this).parent(".modal").hide();   //삭제 성공하면 대화상자 닫기
		}
	});
	
	//글 읽기 대화상자에서 수정버튼 누르면 해당 글 수정하기
	$('#viewUpdate').click(function(){
		setPopup("update");  //이미 모달이 show 되어있기때문에 mode만 바꿔주면 됨
	});
	
	$('#updateOk').click(function(){
		chkUpdate();
	});
	
	
	
});

// page 번째 페이지 로딩
function loadPage(page){
	
	$.ajax({
		url : "list.ajax?page=" + page + "&pageRows=" + pageRows
		, type : "GET"
		, cache : false
		, success : function(data, status){
			if(status == "success"){
				//alert("AJAX 성공: 받아쮸~");
				
				if(updateList(data)){
					
					//업데이트 list에 필요한 이벤트 가동
					addViewEvent();
					//만약 위에 코드를 $(document.ready() 에 뒀으면 동작안할 것
				}
			}			
		}
	});
} // end loadPage()

// 
function updateList(jsonObj){
	result = ""; 
	
	if(jsonObj.status == "okeey"){
		
		var count = jsonObj.count;
		
		// 전역변수 업데이트!
		window.page = jsonObj.page;
		window.pageRows = jsonObj.pagerows;
		
		var i;
		var items = jsonObj.data;   // 배열
		for(i = 0; i < count; i++){
			result += "<tr>\n";
			result += "<td><input type='checkbox' name='uid' value='" + items[i].uid +"'></td>\n";
			result += "<td>" + items[i].uid + "</td>\n";
			result += "<td><span class='subject' data-uid='"+ items[i].uid +"' >" + items[i].subject + "</span></td>\n";
			result += "<td>" + items[i].name + "</td>\n";
			result += "<td><span data-viewcnt='"+items[i].uid+"'>" + items[i].viewcnt + "</span></td>\n";
			result += "<td>" + items[i].regdate + "</td>\n";			
			result += "</tr>\n";
		} // end for
		$("#list tbody").html(result);  // 테이블 업데이트!
		
		// 페이지 정보 업데이트
		$("#pageinfo").text(jsonObj.page + "/" + jsonObj.totalpage + "페이지, " + jsonObj.totalcnt + "개의 글");
		
		// pageRows
		var txt = "<select id='rows' onchange='changePageRows()'>\n";
		txt += "<option " + ((window.pageRows == 10)?"selected":"") + " value='10'>10개씩</option>\n";
		txt += "<option " + ((window.pageRows == 20)?"selected":"") + " value='20'>20개씩</option>\n";
		txt += "<option " + ((window.pageRows == 50)?"selected":"") + " value='50'>50개씩</option>\n";
		txt += "<option " + ((window.pageRows == 100)?"selected":"") + " value='100'>100개씩</option>\n";		
		txt += "</select>\n";
		$("#pageRows").html(txt);
		
		// 페이징 업데이트 
		var pagination = buildPagination(jsonObj.writepages, jsonObj.totalpage, jsonObj.page, jsonObj.pagerows);
		$(".pagination").html(pagination);
		return true;
	} else {
		alert(jsonObj.message);
		return false;
	}
	return false;
}
function buildPagination(writePages, totalPage, curPage, pageRows){
	
	var str = "";   // 최종적으로 페이징에 나타날 HTML 문자열 <li> 태그로 구성
	
	// 페이징에 보여질 숫자들 (시작숫자 start_page ~ 끝숫자 end_page)
    var start_page = ( (parseInt( (curPage - 1 ) / writePages ) ) * writePages ) + 1;
    var end_page = start_page + writePages - 1;

    if (end_page >= totalPage){
    	end_page = totalPage;
    }
    
  //■ << 표시 여부
	if(curPage > 1){
		str += "<li><a onclick='loadPage(1)' class='tooltip-top' title='처음'><i class='fas fa-angle-double-left'></i></a></li>\n";
	}
	
  	//■  < 표시 여부
    if (start_page > 1) 
    	str += "<li><a onclick='loadPage("+(start_page - 1)+")' class='tooltip-top' title='이전'><i class='fas fa-angle-left'></i></a></li>\n";
    
    //■  페이징 안의 '숫자' 표시	
	if (totalPage > 1) {
	    for (var k = start_page; k <= end_page; k++) {
	        if (curPage != k)
	        	str += "<li><a onclick='loadPage(" + k + ")'>" + k + "</a></li>\n";
	        else
	            str += "<li><a class='active tooltip-top' title='현재페이지'>" + k + "</a></li>\n";
	    }
	}
	
	//■ > 표시
    if (totalPage > end_page){
    	str += "<li><a onclick='loadPage("+(end_page + 1)+")' class='tooltip-top' title='다음'><i class='fas fa-angle-right'></i></a></li>\n";
    }

	//■ >> 표시
    if (curPage < totalPage) {
        str += "<li><a onclick='loadPage("+totalPage+")'class='tooltip-top' title='맨끝'><i class='fas fa-angle-double-right'></i></a></li>\n";
    }

    return str;

}

function changePageRows(){
	window.pageRows = $("#rows").val();
	loadPage(window.page);
}

function chkWrite(){
	
	var data = $('#frmWrite').serialize();   //form 내의 모든 name들을 끌고들어옴 String타입 return
	//name = aaa & subject = bbb & content = ccc
	
//	alert(data); //확인용
	//ajax 
	$.ajax({
		url : "writeOk.ajax",
		type : "post",
		cache : false,
		data : data,
		success : function(data, status){
			if ( status =="success"){
				if(data.status == "Ok"){
					alert("insert 성공 "+data.count +"개 : "+data.status);
					loadPage(1);  //가장 최근에 작성했기 때문에 첫페이지 에 있음
				}else{
					alert("insert 실패 "+data.status+ " : "+data.message);
				}
			}
		}
		
	})
	
//	request 후 form에 입력된 값 reset()
	$('#frmWrite')[0].reset(); //reset은 자바스크립트 함수임  
	
	
	return false; 
}

function chkDelete(){
	var uids= []; // 빈 배열 준비
	$('#list tbody input[name=uid]').each(function(){   //각 각 에 대해서 아래와 같은 함수를 적용
		if($(this).is(" :checked")){
			uids.push($(this).val()); //배열에 uid 값들을 추가
		}
	})
	
//	alert(uids);
	if(uids.length == 0){
		alert('삭제할 글을 체크해주세요');
	}else{
		if(!confirm(uids.length + "개의 글을 삭제하시겠습니까>")) return false;
		var data = $("#frmList").serialize();
		
		$.ajax({
			url : "deleteOk.ajax",
			type : "post",
			data : data,
			cache : false,
			success : function(data, status){
				if(status == "success"){
					if(data.status =="Ok"){
						alert("delete 성공" + data.count +"개");
						//현재페이지 리로딩 
						loadPage(window.page);
					}else{
						alert("delete 실패" + data.message);
					}
				}
			}
		});
		
	}	
}//end chkDelete


//현재 글 목록 list 에 대해 이벤트 등록
//-제목(subject) 클릭하면 view 팝업화면 뜰 수 있게 하기
function addViewEvent(){
	$('#list .subject').click(function(){
//		alert($(this).text()+" : "+ $(this).attr('data-uid'));  확인용
		
		//읽어오기
		$.ajax({
			url : "view.ajax?uid="+$(this).attr('data-uid'),
			type : "get",
			cache : false,
			success : function(data, status){
				if(status == "success"){
					if(data.status == "OK"){
						
						//읽어온 view 데이터를 전역변수에 셋팅
						viewItem = data.data[0];
						
						//팝업에 보여주기
						setPopup("view");
						$('#dlg_write').show();
						
						//리스트상의 조회수 증가시키기
						$("#list [data-viewcnt='" + viewItem.uid + "']").text(viewItem.viewcnt);
						
					}else{
						alert("view 실패"+data.message);
					}
				}
			}
		})
	});
}// addViewEvent

//대화상자 셋업
function setPopup(mode){
	
	//글작성
	if(mode=='write'){
		$('#frmWrite')[0].reset(); //reset 은 javascript 함수
		$('#dlg_write .title').text("새글 작성");
		$('#dlg_write .btn_group_header').hide();
		$('#dlg_write .btn_group_write').show();
		$('#dlg_write .btn_group_view').hide();
		$('#dlg_write .btn_group_update').hide();
		
		$("#dlg_write input[name='subject']").attr("readonly", false);
		$("#dlg_write input[name='subject']").css("border", "1px solid #ccc");

		$("#dlg_write input[name='name']").attr("readonly", false);
		$("#dlg_write input[name='name']").css("border", "1px solid #ccc");

		$("#dlg_write textarea[name='content']").attr("readonly", false);
		$("#dlg_write textarea[name='content']").css("border", "1px solid #ccc");
	}
	
	//글보기
	if(mode=='view'){
		$('#dlg_write .title').text("글 읽기");
		$('#dlg_write .btn_group_header').show();
		$('#dlg_write .btn_group_write').hide();
		$('#dlg_write .btn_group_view').show();
		$('#dlg_write .btn_group_update').hide();
		
		$('#dlg_write #viewcnt').text("#" + viewItem.uid + " -조회수: "+viewItem.viewcnt);
		$('#dlg_write #regdate').text(viewItem.regdate);
		
		$('#dlg_write input[name="uid"]').val(viewItem.uid); //삭제 수정을 위해 필ㅛ
		
		$('#dlg_write input[name="subject"]').val(viewItem.subject);
		$('#dlg_write input[name="subject"]').attr("readonly", true);
		$('#dlg_write input[name="subject"]').css("border", "none");
		
		$('#dlg_write input[name="name"]').val(viewItem.name);
		$('#dlg_write input[name="name"]').attr("readonly", true);
		$('#dlg_write input[name="name"]').css("border", "none");
		
		$('#dlg_write textarea[name="content"]').val(viewItem.content);
		$('#dlg_write textarea[name="content"]').attr("readonly", true);
		$('#dlg_write textarea[name="content"]').css("border", "none");
		
	}
	
	//글수정
	if(mode =='update'){
		$('#dlg_write .title').text("글 수정");
		$('#dlg_write .btn_group_header').show();
		$('#dlg_write .btn_group_write').hide();
		$('#dlg_write .btn_group_view').hide();
		$('#dlg_write .btn_group_update').show();
		
		$("#dlg_write input[name='subject']").attr("readonly", false);
		$("#dlg_write input[name='subject']").css("border", "1px solid #ccc");

		$("#dlg_write input[name='name']").attr("readonly", true);

		$("#dlg_write textarea[name='content']").attr("readonly", false);
		$("#dlg_write textarea[name='content']").css("border", "1px solid #ccc");
		
		
		
		
		
	}
	
}  //end setPopup()

//특정 uid 의 글 삭제하기
function deleteUid(uid){
	
	if(!confirm(uid + "글을 삭제 할꺼니??")) return false;
	
	//post방식
	$.ajax({
		url:"deleteOk.ajax",
		type:"post",
		data: "uid="+uid,
		cache : false,
		success : function(data, status){
			if(status == "success"){
				if(data.status =="Ok"){   //data.status 는 command에서 지정
					alert("삭제 성공" + data.count +"개");
					loadPage(page);  //삭제되면 현재 페이지 로딩
				}else{
					alert("삭제 실패"+data.message);
					return false;
				}
			}
		}
	});
	return true;
	
}//end deleteUid


//글 수정
function chkUpdate(){
	
	var data = $('#frmWrite').serialize();
	$.ajax({
		url:"updateOk.ajax",
		type:"post",
		cache: false,
		data : data,
		success : function(data , status){
			if(status == "success"){
				if(data.status == "Ok"){
					alert("수정 성공"+data.count +"개 :"+data.status);
					loadPage(window.page);  //현재 페이지 리로딩
				}else{
					alert("수정 실패  "+data.status+" : "+data.message);
				}
				$('#dlg_write').hide();   //현재 팝업 닫기
			}
		}
	})
	
	
} //end chkUpdate()











