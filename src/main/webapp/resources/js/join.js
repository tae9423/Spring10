/**
 * 
 */

const put = document.getElementsByClassName('put');
const btn = document.getElementById('btn');
const pws = document.getElementsByClassName('pw');
const frm = document.getElementById('frm');
const id = document.getElementById('id');
const idResult= document.getElementById('idResult');
const rePassword = document.getElementById('rePassword');
const pwResult= document.getElementById('pwResult');
const idCheck = document.getElementById('idCheck');

const btn2 = document.getElementById('btn2');


idCheck.addEventListener('click', function(){
	open("./idCheck?id="+id.value, "", "width=400, height=200, top=200, left=300");
});

id.addEventListener('change', function(){
	alert('change');
	
});

rePassword.addEventListener('blur', function(){
	
	let ce2 = checkEqual(pws[0], pws[1]);
	if(!ce2){
		pwResult.innerHTML="비밀번호가 같지 않습니다.";
		rePassword.focus();
	} else {
		pwResult.innerHTML="비밀번호가 같습니다.";
	}
});

id.addEventListener('blur', function(){
	if(id.value.trim().length>=6){
		idResult.innerHTML="올바른 ID입니다.";
	} else{
		idResult.innerHTML="ID는 6글자 이상이어야 합니다.";
		id.focus();
	}
});

btn.addEventListener('click', function() {
	//비어있는 것들 검사
	let ce = checkEmppty(put);
	//두개 값이 같은지 검사
	let ce2 = checkEqual(pws[0], pws[1]);
	//6글자 이상인지 검사
	let cl = checkLength();
	
	if(ce&&ce2&&cl){
		frm.submit();
	}else {
		alert("필수 입력");
	}
});

function checkLength(){
	
	let l = pws[0].value.trim().length;
	if(l>=6){
		return true;
	}else {
		return false;
	}
	
}

function checkEqual(check1, check2){
	return check1.value == check2.value;
}


function checkEmppty(puts){
	let result = true;
	
	for (let r of puts) {

		if (r.value.trim() == "") {
			result = false;
			break;
		}
	}
	return result;
}

