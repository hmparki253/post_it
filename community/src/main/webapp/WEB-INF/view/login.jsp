<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"%>

<!DOCTYPE>
<html>
<head>
<title>로그인 페이지</title>
<meta charset="UTF-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/custom.css">
</head>

<body>
	<nav class="navbar navbar-expand-lg navbar-dark bg-primary">
		<a class="navbar-brand" href="./index.html">관리자 페이지</a>
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbar" alt-controls="navbar" aria-expanded="false">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse justify-content-between"
			id="navbar">
			<div class="navbar-nav">
				<a href="./index.html" class="nav-item nav-link">대시보드</a> <a
					href="./event.html" class="nav-item nav-link">이벤트</a> <a
					href="./blog.html" class="nav-item nav-link">블로그</a> <a
					href="./user.html" class="nav-item nav-link">회원</a>
			</div>
			<div class="navbar-nav mr-sm-2">
				<a href="./userLogin.html" class="nav-item nav-link active">로그인</a>
				<a href="./userLogout.html" class="nav-item nav-link">로그아웃</a> <a
					href="./userEdit.html" class="nav-item nav-link">관리자 정보 수정</a>
			</div>
		</div>
	</nav>
	<header id="header">
		<div class="container p-3 bg-dark text-white">
			<div class="row">
				<div class="col-sm-9 info">
					<h4>
						로그인 <small>을 합시다.</small>
					</h4>
				</div>
			</div>
		</div>
	</header>
	<div class="container">
		<ol class="breadcrumb">
			<li class="active">로그인이 필요합니다.</li>
		</ol>
	</div>
	<section class="main">
		<div class="container" style="max-width: 560px;">
			<form:form
				action="${pageContext.request.contextPath }/userAuthentication"
				method="POST">
				<div class="from-group">
					<label for="">아이디</label> <input type="text" name="username"
						class="form-control">
				</div>
				<div class="from-group mt-3">
					<label for="">비밀번호</label> <input type="password" name="password"
						class="form-control">
				</div>
				<div class="form-group text-center">
					<button class="btn btn-success mt-3">회원가입</button>
					<button type="submit" class="btn btn-primary mt-3">로그인</button>
				</div>
				<c:if test="${param.error != null }">
					<div class="form-group text-center text-danger">입력하신 아이디 /
						비밀번호 정보가 일치하지 않습니다.</div>
				</c:if>
				<div class="form-group text-center">
					<a href="#"> <small>로그인 정보를 잊으셨나요?</small>
					</a>
				</div>
			</form:form>
		</div>
	</section>
	<footer class="bg-dark mt-4 p-5 text-center" style="color: #ffffff">
		Copyright &copy; 2018 박현민 All Rights Reserved </footer>
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