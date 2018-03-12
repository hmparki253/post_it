<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE HTML>
<html>
<head>
<title>게시글 작성</title>
<meta charset="UTF-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/custom.css">
<script type="text/javascript" src="${pageContext.request.contextPath }/resources/ckeditor/ckeditor.js"></script>
</head>
</head>
<body>
	<%@include file="../partial/menu.jsp"%>
	<main>
	<div class="jumbotron jumbo_board_bg">
		<div class="container">
			<div class="row">
				<div class="col-md-12">
					<h1 class="font_clr_ff">자유게시판</h1>
					<h3 class="font_clr_ee">다른 회원들과</h3>
					<h3 class="font_clr_ee">자유롭게 소통하세요.</h3>
				</div>
			</div>
		</div>
	</div>
	<section>
		<div class="container">
			<div class="col-md-12 mb-4">
				<div class="heading text-center">
					<h2 class="h2_underline pb-2">글 작성</h2>
				</div>
			</div>
			<form:form action="saveBoard" modelAttribute="board" method="POST">
				<div class="row mb-3">
					<div class="container mt-5" style="min-height: 460px;">
						<div class="form-group">
							<label for="">제목</label>
							<form:input path="title" cssClass="form-control" placeholder="제목을 입력하세요."></form:input> 
						</div>
						<div class="form-group">
							<label for="">내용</label>
							<form:textarea path="content" cssClass="form-control"></form:textarea>
							<!-- <textarea class="form-control" placeholder="내용을 입력하세요." style="height: 320px" id="ckeditor">
							</textarea> -->
						</div>
						<div class="form-group text-center">
							<button type="submit" class="btn btn-primary">글쓰기</button>
						</div>
					</div>
				</div>
			</form:form>
		</div>
	</section>
	</main>
	<%@include file="../partial/footer.jsp"%>

	<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
		integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
		crossorigin="anonymous"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"
		integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
		crossorigin="anonymous"></script>
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
		integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
		crossorigin="anonymous"></script>
	<script>
		$(function() {
			CKEDITOR.replace('content', { // 해당 id를 가진 textarea 필요 
				width: '100%',
				height: '400px',
				filebrowserUploadUrl: '${pageContext.request.contextPath }/board/fileUpload'
				// 파일 업로드 처리 할 경로. 
			});
			
			CKEDITOR.on('dialogDefinition', function( ev ){
	            var dialogName = ev.data.name;
	            var dialogDefinition = ev.data.definition;
	          
	            switch (dialogName) {
	                case 'image': //Image Properties dialog
	                    //dialogDefinition.removeContents('info');
	                    dialogDefinition.removeContents('Link');
	                    dialogDefinition.removeContents('advanced');
	                    break;
	            }
	        });
		});
		
		/* function save_check(form) {
			
		} */
	</script>
</body>
</html>
