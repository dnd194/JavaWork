var depth = 1;


$(document).ready(function(){
	loadPage(depth);
})
function loadPage(depth){
	
	$.ajax({
		url : "cate_list.ajax?depth=" + depth
		, type : "post"
		, cache : false
		, success : function(data, status){
			if(status == "success"){
				
				updateList(data);
			}			
		}
	});
} // end loadPage()
function updateList(jsonObj){
	result = ""; 
	$("#mycate select:first").removeAttr("disabled");
	if(jsonObj.status == "okeey"){
		
		var count = jsonObj.count;
		
		var i;
		var items = jsonObj.list;   // 배열
		result += '<option value="">- 선택 -</option>'
		for(i = 0; i < count; i++){
			result += "<option value='"+items[i].uid+"'>"+items[i].name +"</option>\n";
		} // end for
		$("#mycate select:first").html(result);  
		$("#mycate select:first").change(function(){
//			alert($("#mycate select:first").val());
			if($("#mycate select:first").val() == ""){
				$("#mycate select:odd").attr("disabled",true);
				$("#mycate select:odd").html("");
				$('#mycate select:last').attr("disabled",true);
				$('#mycate select:last').html("");
			}else{
				
				$.ajax({
					url : "cate_list.ajax?depth=2&parent="+$("#mycate select:first").val(),
					type : "post",
					cache : false,
					success : function(data, status){
						if(status == "success"){
//						$('#mycate select:odd').removeAttr("disabled");
							updateList2(data);
						}	
					}
				})
			}
		})
		return true;
	} else {
		alert(jsonObj.message);
		return false;
	}
	return false;
}
function updateList2(jsonObj){
	result = ""; 
	$('#mycate select:odd').removeAttr("disabled");
	if(jsonObj.status == "okeey"){
		
		var count = jsonObj.count;
		
		var i;
		var items = jsonObj.list;   // 배열
		result += '<option value="">- 선택 -</option>'
			for(i = 0; i < count; i++){
				result += "<option value='"+items[i].uid+"'>"+items[i].name +"</option>\n";
			} // end for
		$("#mycate select:odd").html(result);  
		$("#mycate select:odd").change(function(){
//			alert($("#mycate select:first").val());
			if($("#mycate select:odd").val() == ""){
				$("#mycate select:last").attr("disabled",true);
				$("#mycate select:last").html("");
			}else{
				
				$.ajax({
					url : "cate_list.ajax?depth=3&parent="+$("#mycate select:odd").val(),
					type : "post",
					cache : false,
					success : function(data, status){
						if(status == "success"){
							
//						$('#mycate select:odd').removeAttr("disabled");
							updateList3(data);
						}	
					}
				})
			}
		})
		return true;
	} else {
		alert(jsonObj.message);
		return false;
	}
	return false;
}

function updateList3(jsonObj){
	result = ""; 
	$('#mycate select:last').removeAttr("disabled");
	if(jsonObj.status == "okeey"){
		
		var count = jsonObj.count;
		
		var i;
		var items = jsonObj.list;   // 배열
		result += '<option value="">- 선택 -</option>'
			for(i = 0; i < count; i++){
				result += "<option value='"+items[i].uid+"'>"+items[i].name +"</option>\n";
			} // end for
		$("#mycate select:last").html(result);  
	}
}
