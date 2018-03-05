<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"%>

<!DOCTYPE HTML>
<html>
<head>
<title>사이트에 대하여</title>
<meta charset="UTF-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/custom.css">
</head>
</head>
<body>
	<div class="container-fluid">
		<div class="row d-flex d-md-block flex-nowrap wrapper">
			<%@ include file="partial/nav.jsp" %>
			<main id="main" class="col-md-9 float-left col pl-md-5 pt-3 main">
				<div class="page-header mt-3">
					<h2>사이트 소개</h2>
					<p class="lead">
						
					</p>
					<hr>
					<h2>박 현 민</h2>
					<div class="width collapse show mt-3" aria-expanded="true">
						<p>본 사이트에서는 회원관리 페이지, 자유게시판 페이지, Q&A 페이지를 제공합니다. </p>
					</div>
					<%@ include file="partial/footer.jsp" %>
				</div>
			</main>
		</div>
	</div>
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
