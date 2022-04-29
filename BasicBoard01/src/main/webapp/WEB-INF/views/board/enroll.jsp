<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판 글쓰기!</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<link rel="stylesheet" href="/resources/css/list.css">
</head>
<body>

<h1>게시판 목록</h1>
	<div class="table_wrap">
		<a href="/" class="top_btn">홈</a> | <a href="/board/list" class="top_btn">게시판</a>
	</div>
	
	<br>
	
	<div>
		<form action="/board/enroll" method="post">
		
		    <div>
		        <label>Title</label>
		        <input name="title">
		    </div>
		    
		    <div>
		        <label>Content</label>
		        <textarea rows="3" name="content"></textarea>
		    </div>
		    
		    <div>
		        <label>Writer</label>
		        <input name="writer">
	    	</div>
	    	
	    	<button class="btn">등록</button>
	    	
		</form>
	</div>

</body>
</html>