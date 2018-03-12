<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<script type="text/javascript" src="${pageContext.request.contextPath }/resources/ckeditor/ckeditor.js"></script>
<script type='text/javascript'>
	console.log('${filePath}');
	window.parent.CKEDITOR.tools.callFunction('${CKEditorFuncNum}', '${filePath}', '파일 전송 완료.');
</script>