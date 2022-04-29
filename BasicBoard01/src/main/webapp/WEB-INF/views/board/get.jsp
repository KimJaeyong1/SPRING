<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title><c:out value="${pageInfo.title}" /></title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<link rel="stylesheet" href="/resources/css/list.css">
<link rel="stylesheet" href="/resources/css/get.css">
<link rel="icon" href="data:;base64,iVBORw0KGgo=">
</head>
<body>
<h1>게시판 글 보기</h1>
	<div class="table_wrap">
		<a href="/" class="top_btn">홈</a> | <a href="/board/list" class="top_btn">게시판</a>
	</div>
	
	<div id="get_div">
	
		<div>
			<label>번호</label>
			<input name="bno" value='<c:out value="${pageInfo.bno}" />' readonly="readonly">
		</div>
		<div>
			<label>제목</label>
			<input name="title" value='<c:out value="${pageInfo.title}" />' readonly="readonly">
		</div>
		<div>
			<label>내용</label>
			<textarea name="content" readonly="readonly"><c:out value="${pageInfo.content}" /></textarea>
		</div>
		<div>
			<label>작성자</label>
			<input name="writer" value='<c:out value="${pageInfo.writer}" />' readonly="readonly">
		</div>
		<div>
			<label>등록일</label>
			<input name="regdate" value='<fmt:formatDate pattern="yyyy-MM-dd hh:mm:ss" value="${pageInfo.regdate}"/>' readonly="readonly">
		</div>
		<div>
			<label>수정일</label>
			<input name="updatedate" value='<fmt:formatDate pattern="yyyy-MM-dd hh:mm:ss" value="${pageInfo.updatedate}"/>' readonly="readonly">
		</div>
		
		<br>
		
		<div class="btn_wrap">
			<a class="btn" id="list_btn">목록 페이지</a>
			<a class="btn" id="modify_btn">수정 하기</a>
		</div>
		
		<form id="infoForm" action="/board/modify" method="get">
			<input type="hidden" id="bno" name="bno" value='<c:out value="${pageInfo.bno}"/>'>
			<input type="hidden" name="pageNum" value='<c:out value="${cri.pageNum}"/>'>
			<input type="hidden" name="amount" value='<c:out value="${cri.amount}"/>'>
			<input type="hidden" name="type" value="${cri.type}">
			<input type="hidden" name="keyword" value="${cri.keyword}">
		</form>
	
	</div>
	
<script>
	
	let form = $("#infoForm");
		
	$("#list_btn").on("click", function(e){
		form.find("#bno").remove();
		form.attr("action", "/board/list");
		form.submit();
	});
	
	$("#modify_btn").on("click", function(e){
		form.attr("action", "/board/modify");
		form.submit();
	});	
</script>
</body>
</html>