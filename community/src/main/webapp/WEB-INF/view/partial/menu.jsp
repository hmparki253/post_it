<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<nav class="navbar fixed-top navbar-expand-lg navbar-dark bg-dark">
  <div class="container">
    <a href="${pageContext.request.contextPath}/" class="navbar-brand font_0">Post It</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarsExample07" aria-controls="navbarsExample07"
      aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarsExample07">
      <ul class="navbar-nav mr-auto">
        <li class="nav-item active">
          <a href="${pageContext.request.contextPath}/" class="nav-link">Main</a>
        </li>
        <li class="nav-item">
          <a href="${pageContext.request.contextPath}/board/list" class="nav-link">Board</a>
        </li>
        <li class="nav-item">
          <a href="" class="nav-link">User</a>
        </li>
        <li class="nav-item">
          <a href="" class="nav-link">Info</a>
        </li>
        <li class="nav-item">
          <a href="" class="nav-link">Contact</a>
        </li>
      </ul>
      <sec:authorize access="!hasRole('ROLE_USER')">
      	<a href="${pageContext.request.contextPath }/join">
      		<button class="btn btn-outline-primary mr-2">회원가입</button>
      	</a>
		<a href="${pageContext.request.contextPath }/login">
		 <button class="btn btn-outline-success mr-2">
		 	로그인
		 </button>
		</a>
      </sec:authorize>
      <sec:authorize access="hasRole('ROLE_USER')">
      	<a href="${pageContext.request.contextPath }/logout">
    			<button class="btn btn-outline-success mr-2">
    				<%= request.getUserPrincipal().getName() %>님 환영합니다.
    			</button>
      	</a>
     	<a href="${pageContext.request.contextPath }/logout">
    			<button class="btn btn-outline-danger mr-2">로그아웃</button>
      	</a>
      </sec:authorize>
    </div>
  </div>
</nav>