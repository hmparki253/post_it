<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"%>

<!DOCTYPE HTML>
<html>
<head>
<title>커뮤니티 웹 사이트</title>
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
	<%@include file="./partial/menu.jsp" %>
	<main>
		<%@include file="./partial/main_jumbo.jsp" %>
		<section>
	      <div class="container">
	        <div class="col-md-12 mb-4">
	          <div class="heading text-center">
	            <h2 class="h2_underline pb-2">이 주의 인기글</h2>
	          </div>
	        </div>
	        <div class="row mb-2">
	          <div class="col-md-4">
	            <div class="card flex-md-row mb-4 box-shadow h-md-250">
	              <div class="card-body d-flex flex-column align-items-start">
	                <h3 class="mb-0">
	                  <a class="text-dark" href="#">스프링에서 어쩌구 저쩌...</a>
	                </h3>
	                <div class="mb-1 text-muted">
	                  <img src="${pageContext.request.contextPath}/resources/img/calendarTiny.svg"> Nov 12 |
	                  <img src="${pageContext.request.contextPath}/resources/img/userTiny.svg"> 박현민 |
	                  <img src="${pageContext.request.contextPath}/resources/img/checkTiny.svg"> 5234
	                </div>
	                <p class="card-text mb-auto">
	                  Lorem ipsum dolor sit amet, consectetur adipisicing elit. Esse minus ut sunt illum praesentium ducimus, consectetur quidem ullam similique non culpa dicta laborum harum animi, reprehenderit iure eligendi! Eaque, expedita.
	                </p>
	                <a href="#">계속 읽어보기</a>
	              </div>
	            </div>
	          </div>
	          <div class="col-md-4">
	            <div class="card flex-md-row mb-4 box-shadow h-md-250">
	              <div class="card-body d-flex flex-column align-items-start">
	                <h3 class="mb-0">
	                  <a class="text-dark" href="#">Featured post</a>
	                </h3>
	                <div class="mb-1 text-muted">
	                  Nov 12 |
	                  <img src="./img/userTiny.svg">박현민
	                </div>
	                <p class="card-text mb-auto">This is a wider card with supporting text below as a natural lead-in to additional content.</p>
	                <a href="#">Continue reading</a>
	              </div>
	            </div>
	          </div>
	          <div class="col-md-4">
	            <div class="card flex-md-row mb-4 box-shadow h-md-250">
	              <div class="card-body d-flex flex-column align-items-start">
	                <h3 class="mb-0">
	                  <a class="text-dark" href="#">Featured post</a>
	                </h3>
	                <div class="mb-1 text-muted">
	                  Nov 12 |
	                  <img src="./img/userTiny.svg">박현민
	                </div>
	                <p class="card-text mb-auto">This is a wider card with supporting text below as a natural lead-in to additional content.</p>
	                <a href="#">Continue reading</a>
	              </div>
	            </div>
	          </div>
	          <div class="col-md-4">
	              <div class="card flex-md-row mb-4 box-shadow h-md-250">
	                <div class="card-body d-flex flex-column align-items-start">
	                  <h3 class="mb-0">
	                    <a class="text-dark" href="#">Featured post</a>
	                  </h3>
	                  <div class="mb-1 text-muted">
	                    Nov 12 |
	                    <img src="./img/userTiny.svg">박현민
	                  </div>
	                  <p class="card-text mb-auto">This is a wider card with supporting text below as a natural lead-in to additional content.</p>
	                  <a href="#">Continue reading</a>
	                </div>
	              </div>
	            </div>
	            <div class="col-md-4">
	                <div class="card flex-md-row mb-4 box-shadow h-md-250">
	                  <div class="card-body d-flex flex-column align-items-start">
	                    <h3 class="mb-0">
	                      <a class="text-dark" href="#">Featured post</a>
	                    </h3>
	                    <div class="mb-1 text-muted">
	                      Nov 12 |
	                      <img src="./img/userTiny.svg">박현민
	                    </div>
	                    <p class="card-text mb-auto">This is a wider card with supporting text below as a natural lead-in to additional content.</p>
	                    <a href="#">Continue reading</a>
	                  </div>
	                </div>
	              </div>
	          <div class="col-md-12">
	            <div class="text-right">
	              <a href="">
	                <span>더 보기...</span>
	              </a>
	            </div>
	          </div>
	        </div>
	      </div>
	    </section>
	</main>
	<%@include file="./partial/footer.jsp" %>
	
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
