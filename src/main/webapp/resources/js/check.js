/**
 * 
 */

  


$("#all").click(function(){
	$(".checks").prop("checked", $(this).prop("checked"));
});

//-----------------------------
 
$(".checks").click(function(){
	let result=true;
	$(".checks").each(function(v1, v2){
		if(!$(v2).prop("checked")){
			result=false;
			console.log(v1, $(v2).prop("checked"));
			//break; each문 내에서 사용불가
			
		}
	});
	
	$("#all").prop("checked", result);
});

$("#btn").click(function(){
	if($("#all").prop("checked")){
		location.href="join";
	}else {
		alert("약관 동의 필수");
	}
});

 
 