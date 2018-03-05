<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<nav class="col-md-3 float-left col-1 pl-0 pr-0 collapse width show"
	id="sidebar">
	<div class="list-group border-0 card text-center text-md-left">
		<a href="${pageContext.request.contextPath}/" class="list-group-item d-inline-block collapsed" data-parent="#sidebar">
			<img src="${pageContext.request.contextPath}/resources/img/home.svg" style="width:20px">
			<span class="d-none d-md-inline">메인</span>
		</a> 
		<a href="${pageContext.request.contextPath}/about" class="list-group-item d-inline-block collapsed" data-parent="#sidebar">
			<img src="${pageContext.request.contextPath}/resources/img/info.svg" style="width:20px">
			<span class="d-none d-md-inline">소개</span>
		</a>
		
		<a href="#usermenu" class="list-group-item d-inline-block collapsed" data-parent="#sidebar" data-toggle="collapse" aria-expanded="false">
			<img src="${pageContext.request.contextPath}/resources/img/user.svg" style="width:20px">
			<span class="d-none d-md-inline">회원관리</span>
		</a>
		<div class="collapse" id="usermenu">
			<a href="/user/join" class="list-group-item" data-parent="#sidebar">회원가입</a>
			<a href="/user/login" class="list-group-item" data-parent="#sidebar">로그인</a>
			<a href="/user/edit" class="list-group-item" data-parent="#sidebar">회원정보수정</a>
			<a href="/user/logout" class="list-group-item" data-parent="#sidebar">로그아웃</a>
		</div>
		<a href="${pageContext.request.contextPath}/board/list" class="list-group-item d-inline-block collapsed" data-parent="#sidebar">
			<img src="${pageContext.request.contextPath}/resources/img/board.svg" style="width:20px"> 
			<span class="d-none d-md-inline">자유게시판</span>
		</a> 
		<a href="${pageContext.request.contextPath}/qna/list" class="list-group-item d-inline-block collapsed" data-parent="#sidebar">
			<img src="${pageContext.request.contextPath}/resources/img/qna.svg" style="width:20px"> 
			<span class="d-none d-md-inline"> Q & A</span>
		</a>
	</div>
</nav>
