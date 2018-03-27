<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"%>

<!DOCTYPE>
<html>
<head>
<title>회원가입성공</title>
<meta charset="UTF-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/custom.css">
</head>

<body>
	<%@include file="./partial/menu.jsp"%>
	<main>
		<div class="jumbotron jumbo_bg">
			<div class="container">
				<div class="row">
					<div class="col-md-12">
						<h1 class="font_clr_ff">글을 쓰고, 자유롭게 소통하는 공간 Post It</h1>
						<h3 class="font_clr_ee">다양한 분야, 다양한 사람들과 글을 공유하고</h3>
						<h3 class="font_clr_ee">자유롭게 소통하세요.</h3>
					</div>
				</div>
			</div>
		</div>
		<section>
			<div class="container">
				<div class="col-md-12 mb-4">
					<div class="heading text-center">
						<h2 class="h2_underline pb-2">회원가입에 성공하셨습니다.</h2>
					</div>
				</div>
				<div class="row">
					
				</div>
			</div>
		</section>
	</main>
	<%@include file="./partial/footer.jsp"%>
	
	<!-- 제이쿼리 자바스크립트 추가하기 -->
	<%-- <script src="${pageContext.request.contextPath}/resources/js/jquery.min.js"></script>
	<script src="${pageContext.request.contextPath}/resources/js/popper.min.js"></script>
	<script src="${pageContext.request.contextPath}/resources/js/bootstrap.min.js"></script> --%>
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
</body>
</html>