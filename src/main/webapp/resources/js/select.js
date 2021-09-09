/**
 * select.js
 */
 
 const c1 = document.getElementsByClassName('c1');
 const btn = document.getElementById('btn');
 
 
 btn.addEventListener('click', function(){
	for(let ch of c1){
	
	ch.checked= true;
		
	
	}

})
 
 
 

 
/* for(let ch of c1){
	
	ch.addEventListener('click', function(){
		alert(ch.checked);
		
	
	})
}*/
