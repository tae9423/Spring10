/**
 * 
 */
 
 $('#id').blur(function(){
	let id= $('#id').val();
	$.get('./idCheckAjax?id='+id, function(data){
		data = data.trim()
		if(data=='1'){
			$('#idResult').html('사용 가능한 아이디입니다.');
		}else{
			$('#idResult').html('사용 불가능한 아이디입니다.');
		}
	});
});

 $("#btn").click(function(){
	 
	let result=true;
	let t;
	 $(".put").each(function(s1, s2){
		if($(s2).val() == ""){
			result=false;
			t=s2;
		}
	});
	
	if(result){
			alert('submit');
			//$("#frm").submit();
		}else {
			alert('필수 입력');	
			$(t).focus();
		}

});



