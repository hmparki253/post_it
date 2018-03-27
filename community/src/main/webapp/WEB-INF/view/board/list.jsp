<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

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
					<h2 class="h2_underline pb-2">글 목록</h2>
				</div>
			</div>
			<div class="row">
				<div class="container mt-5" style="min-height: 460px;">
					<table class="table table-striped" style="max-width: 1080px;">
						<thead>
							<tr>
								<th class="mobile" style="width: 55px; text-align: center;">
									번호</th>
								<th style="text-align: center;">제목</th>
								<th class="mobile" style="width: 80px; text-align: center;">
									작성자</th>
								<th class="mobile" style="width: 120px; text-align: center;">
									날짜</th>
								<th class="mobile" style="width: 80px; text-align: center">
									조회수</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="tempBoard" items="${boards }">
								<tr>
									<td class="mobile" style="text-align: center;">${tempBoard.idx}</td>
									<td>
										<a href="${pageContext.request.contextPath }/board/view/${tempBoard.idx}" style="color: #000000;">
											${tempBoard.title }
										</a>
									</td>
									<td class="mobile" style="text-align: center;">
										${tempBoard.writer }
									</td>
									<td class="mobile" style="text-align: center">
										${tempBoard.regDt }
									</td>
									<td class="mobile" style="text-align: center">
										${tempBoard.hit }
									</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
					<div style="max-width: 1080px;">
						<sec:authorize access="hasRole('ROLE_USER')">
							<a href="${pageContext.request.contextPath }/board/write" class="btn btn-primary float-right">작성하기</a>
						</sec:authorize>
					</div>
					<div class="text-center" style="max-width: 1080px;">
						<ul class="pagination">
							<li class="page-item"><span class="page-link">&laquo;</span>
							</li>
							<li class="page-item active"><a href="#"
								class="page-link mobile">1</a></li>
							<li class="page-item"><a href="#" class="page-link mobile">2</a>
							</li>
							<li class="page-item"><span class="page-link">&raquo;</span>
							</li>
						</ul>
					</div>
					<div class="text-center" style="max-width: 1080px;">
						<select name="" id="">
							<option value="">제목</option>
							<option value="">내용</option>
							<option value="">제목+내용</option>
							<option value="">작성자</option>
						</select> <input type="text" name="" id="" placeholder="검색어를 입력해주세요.">
						<a href="./boardWrite.html" class="btn btn-primary">검색하기</a>
					</div>
				</div>
			</div>
		</div>
	</section>
	</main>
	<%@include file="../partial/footer.jsp" %>
	
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
