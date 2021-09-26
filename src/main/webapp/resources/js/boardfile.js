/**
 * 	boardfile.js
 */
let files = '<div class="input-group mb-3">';
files = files + '<input type="file" name="files" class="form-control">';
files = files + '<button class="btn btn-outline-secondary del" type="button" id="button-addon2">x</button>';
files = files + '</div>';


let maxAppend = 0;
//let index = 0;

function setCount(c){
	maxAppend = c;
}

function updateMaxAppend(){
	maxAppend--;
}

$('#fileAdd').click(function() {
	/*index++;
let files = '<div class="input-group mb-3" id="del'+index+'">';
files = files + '<input type="file" class="form-control">';
files = files + '<button data-btn-id="' + index + '" class="btn btn-outline-secondary del" type="button" id="button-addon2">x</button>';
files = files + '</div>';*/
	if (maxAppend >= 5) {
		alert('최대 5개까지만 가능');
		return;
	}
	$('#fileAddResult').append(files);
	maxAppend++;

});

$("#fileAddResult").on('click', '.del', function() {
	/*let num = $(this).attr('data-btn-id');
	$('#del' + num).remove();*/
	
	$(this).parent().remove();
	
	maxAppend--;
})


/*$(".del").click(function(){
	alert('event');
})
*/

