<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"%>

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
</head>
</head>
<body>
	<div class="container-fluid">
		<div class="row d-flex d-md-block flex-nowrap wrapper">
			<%@ include file="../partial/nav.jsp" %>
			<main id="main" class="col-md-9 float-left col pl-md-5 pt-3 main">
				<div class="page-header mt-3">
					<h2>자유게시판</h2>
					<p class="lead">
						다른 회원들과 자유롭게 소통하세요.
					</p>
					<hr>
					<table class="table table-striped" style="max-width: 1080px;">
						<thead>
							<tr>
								<th class="mobile" style="width: 55px; text-align: center;"> 번호 </th>
								<th style="text-align: center;"> 제목 </th>
								<th class="mobile" style="width: 80px; text-align: center;"> 작성자 </th>
								<th class="mobile" style="width: 120px; text-align: center;"> 날짜 </th>
							</tr>
						</thead>
						<tbody>
							<tr>
								<td class="mobile" style="text-align: center;">3</td>
								<td>
									<a href="./boardView.html" style="color: #000000;">신규 운영진을 모집합니다.</a>
								</td>
								<td class="mobile" style="text-align: center;">운영자</td>
								<td class="mobile" style="text-align: center;">2018-02-21</td>
							</tr>
							<tr>
								<td class="mobile" style="text-align: center;">3</td>
								<td>
									<a href="./boardView.html" style="color: #000000;">신규 운영진을 모집합니다.</a>
								</td>
								<td class="mobile" style="text-align: center;">운영자</td>
								<td class="mobile" style="text-align: center;">2018-02-21</td>
							</tr>
							<tr>
								<td class="mobile" style="text-align: center;">3</td>
								<td>
									<a href="./boardView.html" style="color: #000000;">신규 운영진을 모집합니다.</a>
								</td>
								<td class="mobile" style="text-align: center;">운영자</td>
								<td class="mobile" style="text-align: center;">2018-02-21</td>
							</tr>
						</tbody>
					</table>
					<div style="max-width: 1080px;">
						<a href="${pageContext.request.contextPath}/board/write" class="btn btn-primary float-right">작성하기</a>
					</div>
					<ul class="pagination">
						<li class="page-item">
							<span class="page-link">&laquo;</span>
						</li>
						<li class="page-item active">
							<a href="#" class="page-link mobile">1</a>
						</li>
						<li class="page-item">
							<a href="#" class="page-link mobile">2</a>
						</li>
						<li class="page-item">
							<a href="#" class="page-link mobile">3</a>
						</li>
						<li class="page-item">
							<a href="#" class="page-link mobile">4</a>
						</li>
						<li class="page-item">
							<a href="#" class="page-link mobile">5</a>
						</li>
						<li class="page-item">
							<a href="#" class="page-link mobile">6</a>
						</li>
						<li class="page-item">
							<a href="#" class="page-link mobile">7</a>
						</li>
						<li class="page-item">
							<a href="#" class="page-link mobile">8</a>
						</li>
						<li class="page-item">
							<span class="page-link">&raquo;</span>
						</li>
					</ul>
					<%@ include file="../partial/footer.jsp" %>
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
