<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<c:import url="../temp/boot_head.jsp"></c:import>
<style type="text/css">
	.more {
		cursor: pointer;
	}
</style>

<title>Insert title here</title>
</head>
<body>
	<c:import url="../temp/boot_nav.jsp"></c:import>
	<h1>${board}SelectPage</h1>

	<div class="container-fluid col-md-8">

		<h1>Num : ${dto.num}</h1>
		<h1>Title : ${dto.title}</h1>
		
		<div>
			${dto.contents}
		</div>
		<h1>Writer : ${dto.writer}</h1>
		<h1>Date: ${dto.regDate}</h1>
		<h1>Hits : ${dto.hits}</h1>
		
		<c:forEach items="${dto.files}" var="f">
			<div>
			<a href="./down?fileName=${f.fileName}">${f.oriName}</a>
			</div>
		</c:forEach>
		
		<hr>
		<!-- comment list -->
		<div id="commentList" data-board-num="${dto.num}">
         	
        </div>
		
		
		<div>
			<div class="mb-3">
				<label for="writer" class="form-label">Writer</label> <input
					type="text" class="form-control" name="writer" readonly id="writer"
					value="${member.id}">
			</div>
			
			<div class="mb-3">
				<label for="contents" class="form-label">Contents</label>
				<textarea class="form-control" cols="" name="contents"
					id="contents" rows="6"></textarea>
			</div>
			
			<!-- button 추가 -->
			<div class="mt-3 ml-0">
				<button type="submit" class="btn btn-success" id="comment">WRITE</button>
			</div>
			
		</div>
		
		
		
		<hr>

		<c:if test="${board eq 'qna'}">
			<a href="./reply?num=${dto.num}">Reply</a>
		</c:if>
		
		<c:if test="${member.id eq dto.writer}">
			<a href="./delete?num=${dto.num}">Delete</a>
			<a href="./update?num=${dto.num}">Update</a>
		</c:if>
	</div>

	<script type="text/javascript">
		getCommentList(1);
		
		$("#commentList").on("click", ".commentUpdate", function(){
			console.log('update');
			let num = $(this).attr("data-comment-update");
			let content= $("#content"+num).text().trim();
			$("#content"+num).children().css('display', 'none');
			let ta = '<textarea class="form-control" cols=""  name="contents" id="contents" rows="6">';
			ta = ta+content.trim() +'</textarea>';
			ta = ta +'<button type="submit" class="btn btn-success up" id="">UPDATE</button>';
			ta = ta +'<button type="submit" class="btn btn-danger can" id="">CANCEL</button>';	
			$("#content"+num).append(ta);
					
		});
		
		//update
		$("#commentList").on('click', ".up", function(){
			let contents = $(this).prev().val();
			let commentNum = $(this).parent().prev().text().trim();
			let selector = $(this);
			$.ajax({
				type:"POST",
				url: "./commentUpdate",
				data:{
					commentNum:commentNum,
					contents:contents
				},
				success:function(result){
					if(result.trim()>0){
						alert('수정 성공');
						//getCommentList(1);
						selector.parent().children('div').text(contents);
						selector.parent().children('div').css('display', 'block');
						selector.parent().children('textarea').remove();
						selector.parent().children('button').remove();
					}else{
						alert('수정 실패');
					}
				},
				error:function(){
					alert('수정 실패');
				}
			})
			
		});
		
		//cancel
		$("#commentList").on('click', ".can", function(){
			
			$(this).parent().children('div').css('display', 'block');
			$(this).parent().children('textarea').remove();
			$(this).parent().children('button').remove();
		});
		
		$("#commentList").on("click", ".commentDel", function(){
			let cn = $(this).attr("data-comment-del");
			console.log(cn);
			 $.ajax({
				type:"POST",
				url:"./commentDel",
				data:{
					commentNum:cn
				},
				success: function(result){
					result=result.trim();
					if(result>0){
						alert('삭제 성공');
						getCommentList(1);
					}else {
						alert('삭제 실패');
					}
				}, 
				error: function(xhr, status, error){
					alert('삭세 실패');
				}
				
			
			}); 
		});
		
		$("#commentList").on("click", ".more", function(){
			//data-comment-pn 값을 출력
			let pn = $(this).attr("data-comment-pn");
			getCommentList(pn);
		});
		
		function getCommentList(pageNumber) {
			let num = $("#commentList").attr("data-board-num");
			$.ajax({
				type:"GET",
				url:"./getCommentList",
				data:{
					num:num,
					pn : pageNumber	
				},
				success: function(result){
					result=result.trim();
					$("#commentList").html(result);
				}, 
				error: function(xhr, status, error){
					console.log(error);
				}
				
			
			});
			
		}
	
	
		$('#comment').click(function(){
			//작성자, 내용
			let writer = $("#writer").val();
			let contents = $("#contents").val();
			$.post('./comment',{num:'${dto.num}', writer:writer, contents:contents}, function(result){
				console.log(result.trim());
				
				$("#contents").val('');
				getCommentList();
			});
			
			console.log(writer, contents);
		});
	</script>
	
</body>
</html>