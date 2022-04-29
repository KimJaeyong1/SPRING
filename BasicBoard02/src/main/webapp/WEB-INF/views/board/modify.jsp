<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width" , initial-scale="1">
<link rel="stylesheet" href="/resources/css/bootstrap.css">
<link rel="stylesheet" href="/resources/css/custom.css">
<title>MODIFY</title>
</head> 
<body>

	<nav class="navbar navbar-default">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle collapsed"
				data-toggle="collapse" data-target="#bs-example-navbar-collapse-1"
				aria-expanded="false">
				<span class="icon-bar"></span>
				<span class="icon-bar"></span>
				<span class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="/">SHENWOO.COM</a>
		</div>
		<div class="collapse navbar-collapse" id="bs-example=bavbar=collapse-1">
			<ul class="nav navbar-nav">
				<li><a href="/">메인</a></li>
				<li class="active"><a href="/board/list">게시판</a></li>
			</ul>
			<ul class="nav navbar-nav navbar-right">
				<li class="dropdown">
					<a href="#" class="dropdown-toggle"
					data-toggle="dropdown" role="button" aria-haspopup="true"
					aria-expanded="false">회원관리<span class="caret"></span></a>
					<ul class="dropdown-menu">
						<li><a href="/login/login">로그인</a></li>
						<li><a href="/login/join">회원가입</a></li>
					</ul>
				</li>
			</ul>
		</div>
	</nav>
	<div class="container">
		<div class="row">
			<form id="modifyForm" action="/board/modify" method="post">
				<table class="table table-striped" style="text-align: center; border: 1px solid #dddddd">
					<thead>
						<tr>
							<th colspan="2" style="background-color: #eeeeee; text-align: center;">게시판 글 수정 양식</th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td>
							<input type="text" class="form-control" placeholder="글 번호" name="bno" maxlength="50" 
							value='<c:out value="${pageInfo.bno}" />' readonly="readonly">
							</td>
						</tr>
						<tr>
							<td>
							<input type="text" class="form-control" placeholder="글 제목" name="title" maxlength="50" 
							value='<c:out value="${pageInfo.title}" />'>
							</td>
						</tr>
						<tr>
							<td>
							<input type="text" class="form-control" placeholder="작성자" name="writer" maxlength="50" 
							value='<c:out value="${pageInfo.writer}" />' readonly="readonly">
							</td>
						</tr>
						<tr>
							<td>
							<input type="text" class="form-control" placeholder="작성일" name="regDate" maxlength="50" 
							value='<fmt:formatDate pattern="yyyy/MM/dd" value="${pageInfo.regDate}" />' readonly="readonly">
							</td>
						</tr>
						<tr>
							<td>
							<input type="text" class="form-control" placeholder="수정일" name="updateDate" maxlength="50" 
							value='<fmt:formatDate pattern="yyyy/MM/dd" value="${pageInfo.updateDate}" />' readonly="readonly">
							</td>
						</tr>
						<tr>
							<td>
							<textarea class="form-control" placeholder="글 내용" name="content" maxlength="2048" style="height: 350px;">
							<c:out value="${pageInfo.content}" /></textarea>
							</td>
						</tr>
					</tbody>
				</table>
				
				<div class="btn_wrap">
					<a class="btn btn-primary" id="list_btn">목록 페이지</a> 
					<a class="btn btn-primary" id="delete_btn">삭제</a> 
			        <a class="btn btn-primary pull-right" id="modify_btn">수정 완료</a>
			        <a class="btn btn-primary" id="cancel_btn">수정 취소</a>
				</div>
			</form>
		</div>
		
		<form id="infoForm" action="/board/modify" method="get">
			<input type="hidden" id="bno" name="bno" value='<c:out value="${pageInfo.bno}"/>'>
			<input type="hidden" name="pageNum" value='<c:out value="${cri.pageNum}"/>'>
			<input type="hidden" name="amount" value='<c:out value="${cri.amount}"/>'>
			<input type="hidden" name="type" value="${cri.type}">
			<input type="hidden" name="keyword" value="${cri.keyword}">  
		</form>
		
	</div>
	
<script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
<script src="/resources/js/bootstrap.js"></script>

<script>
	
	let form = $("#infoForm");        // 페이지 이동 form(리스트 페이지 이동, 조회 페이지 이동)
    let mForm = $("#modifyForm");    // 페이지 데이터 수정 from
    
    /* 목록 페이지 이동 버튼 */
    $("#list_btn").on("click", function(e){
        form.find("#bno").remove();
        form.attr("action", "/board/list");
        form.submit();
    });
    
    /* 수정 하기 버튼 */
    $("#modify_btn").on("click", function(){
        mForm.submit();
    });
    
    /* 취소 버튼 */
    $("#cancel_btn").on("click", function(e){
        form.attr("action", "/board/get");
        form.submit();
    });
    
    /* 삭제 버튼 */
    $("#delete_btn").on("click", function(e){
        form.attr("action", "/board/delete");
        form.attr("method", "post");
        form.submit();
    });
</script>

</body>
</html>