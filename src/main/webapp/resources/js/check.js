/**
 * 
 */
  
 const all = document.getElementById('all');
 const checks = document.getElementsByClassName('checks');
 const btn = document.getElementById('btn');
 const ch = document.getElementsByClassName('ch');
 
 
 
 btn.addEventListener('click', function(){
	
	let result = true;
	
	for(let c of ch){
		if(!c.checked){
			result = false;
			break;
		}
	}
	
	if(result){
		location.href="./join";
	}else {
		alert('필수 약관에 동의 해야 함');
	}
	
	/*if(all.checked){
		location.href="./join";
	}else {
		alert('필수 약관에 동의 해야 함');
	}*/
});
  //---------------------------------------
 all.addEventListener('click', function(){
	
	for(let ch of checks){
		ch.checked =all.checked
	}
});
//-------------------------------------------
 for(let ch of checks){
	ch.addEventListener('click', function(){
		let result = true;
		
		for(c of checks){
			if(!c.checked){
				result = false;
				break;
			}
		}
		all.checked=result;
		
		
	});
	
}


 
 