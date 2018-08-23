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
            <h2 class="h2_underline pb-2">${board.title }</h2>
          </div>
          <div class="text-center">
            <img src="${pageContext.request.contextPath}/resources/img/calendarTiny.svg"> ${board.regDt } |
            <img src="${pageContext.request.contextPath}/resources/img/userTiny.svg"> ${board.writer } |
            <img src="${pageContext.request.contextPath}/resources/img/checkTiny.svg"> ${board.hit }
          </div>
        </div>
        <div class="row mb-3">
          <div class="container mt-5" style="min-height:460px;">
          	<input type="hidden" value="${board.idx }" />
            <div>
              ${board.content }
            </div>
            <div class="text-right">
            	  <c:url var="modifyLink" value="/board/modifyBoard">
            	  	<c:param name="idx" value="${board.idx }" />
            	  </c:url>
              <a href="${modifyLink }" class="btn btn-primary">수정</a>
              <c:url var="deleteLink" value="/board/deleteBoard">
              	<c:param name="idx" value="${board.idx }" />
              </c:url>
              <a href="${deleteLink }" class="btn btn-primary">삭제</a>
              <a href="${pageContext.request.contextPath }/board/list" class="btn btn-primary">목록</a>
            </div>
            
            <!-- 작성된 리플 보기 -->
            <c:forEach var="tempReply" items="${replies }">
	            	<div id="${tempReply.idx }" class="row mt-3 reply-box" style="margin-left:${tempReply.indent}%; margin-right:0px;">
	            		<input type="hidden" value="${tempReply.family }">
	            		<input type="hidden" value="${tempReply.parent }">
	            		<input type="hidden" value="${tempReply.depth }">
	            		<div class="col-md-7 nopadding font-weight-bold">${tempReply.writer }</div>
	            		<div class="col-md-5 nopadding text-right">${tempReply.regDt }</div>
	            		<div class="col-md-10 nopadding">${tempReply.content }</div>
	            		<div class="col-md-2 nopadding text-right">
		            		<a class="dummy" 
		            			onclick="replyClick(${board.idx}, ${tempReply.family}, ${tempReply.idx}, ${tempReply.depth}, ${tempReply.indent }, ${board.idx })"
		            			style="cursor:pointer;">
		            		<img src="${pageContext.request.contextPath}/resources/img/message-circle.svg">댓글</a>
	            		</div>
	            </div>
            </c:forEach>
            
            <!-- 단순 리플 작성 블록 -->
            <form:form action="../addReply" modelAttribute="reply" method="POST">
            		<form:hidden path="writer" value="<%= request.getUserPrincipal().getName() %>"/>
            		<form:hidden path="boardIdx" value="${board.idx }"/>
	           	<div class="row mt-3">
	           		<div class="col md-10">
	           			<form:textarea path="content" style="min-width:100%"/>
	           		</div>
	           		<div class="col md-2">
	           			<button type="submit" class="btn btn-success">등록</button>
	           		</div>
	           	</div>
           	</form:form>
           	
           	<!-- 리리플 틀 -->
            <div id="pre_set" class="row mt-3 reply-box" style="display:none; margin-right:0px;">
            		<div class="col md-10">
            			<textarea id="pre_content"  style="min-width:100%"></textarea>
            			<input type="hidden"  id="pre_idx">
            			<input type="hidden"  id="pre_family">
            			<input type="hidden"  id="pre_parent">
            			<input type="hidden"  id="pre_depth">
            			<input type="hidden"  id="pre_indent">
            		</div>
            		<div class="col md-2">
            			<input type="button" class="btn btn-success" value="등록" onClick="sendRereply(this)">
            			<input type="button" class="btn btn-success" value="닫기" onClick="cancel(this)">
            		</div>
            </div>
            
          </div>
        </div>
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
		
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" 
		crossorigin="anonymous"></script>	
		
	<script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
		
	<script>
		// 리리플 작성 화면 binding function(부모 idx, family, parent, depth, indent * 2)
		// 리리플 idx : 자동증가, family : 부모글의 family, parent : 부모글의 idx
		// depth : 부모글의 depth + 1, indent : 부모글의 indent + 1
		function replyClick(idx, family, parent, depth, indent, boardIdx) {
			// div상 세팅되어야 할 값
			// 부모글의 famliy, idx, depth, indent
			
			// idx 자동 생성 값 
			// board_idx 해당 게시글의 idx 값
			// 부모의 family값
			// parent 부모 idx 값 
			// depth 부모 + 1 값 
			// indent 부모 + 1 값 
			
			if(document.getElementById('reply_' + parent)) {
				var div = document.getElementById('reply_' + parent);
				div.remove();
			} else {
				var pre_set = document.getElementById('pre_set');
				var div = document.createElement('div');
				div.innerHTML = pre_set.innerHTML;
				div.id = 'reply_' + parent;
				
				var children = div.firstElementChild.children;
				children[0].id = 'reply_' + parent + '_content'; // content
				children[1].id = 'reply_' + parent + '_idx'; // idx
				children[1].value = parent;
				children[2].id = 'reply_' + parent + '_family'; // family
				children[2].value = family;
				children[3].id = 'reply_' + parent + '_parent'; // parent
				children[3].value = parent;
				children[4].id = 'reply_' + parent + '_depth'; // depth
				children[4].value = depth;
				children[5].value = 'reply_' + parent + '_indent'; // indent
				children[5].id = indent; 
				
				var secondDiv = div.lastElementChild.children;
				var funcString = parse('ajaxReplyClick(%s, %s, %s, %s, %s, %s)', 
						idx, family, parent, depth, indent, boardIdx);
				secondDiv[0].setAttribute('onclick', funcString);
				
				document.getElementById(parent).appendChild(div);
			}
		}
		
		// 리리플 데이터 서버로 전송
		function ajaxReplyClick(idx, family, parent, depth, indent, boardIdx) {
			var content = document.getElementById('reply_' + parent + '_content').value;
			var writer = document.getElementById('writer').value;
			var reply = {
					"idx": null, // 리플 시퀀스 -> 자동 생성될 값 
					"boardIdx": idx, // 게시글 인덱스 값 
					"family": family, // 부모 그룹 값 
					"parent": parent, // 부모 값 
					"depth": depth, // 부모 그룹 값 내에서의 depth 
					"indent": indent, // 보여지는 indent 값 
					"writer": writer, // 작성자 값 
					"content": content, // 리플 내용
					"regDt": null, // 컨트롤러 단 세팅 후 insert 
					"enabled": null // 컨트롤러 단 세팅 후 insert
			}
			
			$.ajax({
				type: "POST",
				contentType: 'application/json; charset=utf-8',
				dataType: 'json',
				url: '../addRereply',
				data: JSON.stringify(reply),
				success: function(data) {
					console.log("\n 여기가 바로 success ")
					console.log(data);
					/* window.location.href = '../view/idx=' + idx; */
				},
				complete: function(data) {
					console.log(data.statusText);
					if(data.statusText == 'OK') {
						location.href = '../view/' + idx;
					}
				}
			});
		}
		
		// 취소버튼
		function cancel(delBtn) {
			((delBtn.parentNode).parentNode).remove();
		}
		
		// 리리플 데이터 전송버튼 클릭
		function sendRereply(sendBtn) {
			// 작성자 id값
			var writer = '<%= request.getUserPrincipal().getName() %>';
			console.log(writer);
			// family : 부모글 family, parent : 부모글의 idx, depth : 부모글의 depth + 1, indent : 부모글의 indent + 1 
		}

		// parse function
		function parse(str) {
		    var args = [].slice.call(arguments, 1),
		        i = 0;

		    return str.replace(/%s/g, function() {
		        return args[i++];
		    });
		}

	</script>
</body>
</html>
