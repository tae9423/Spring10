/**
 * 
 */
 
let file='<div class="mb-3" id="f">';
file = file + '<label for="photo" class="form-label">Photo</label>';
file = file + '<input type="file" class="form-control put" name="photo" id="photo">';
file = file + '</div>';
 
 
 $('#add').click(function(){
	$("#files").after(file);
});