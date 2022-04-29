<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>	
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>	
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width" , initial-scale="1">
<link rel="stylesheet" href="/resources/css/bootstrap.css">
<link rel="stylesheet" href="/resources/css/custom.css">
<title>LIST</title>
<style type="text/css">
	a, a:hover {
		color: #000000;
		text-decoration: none;
	}
</style>
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
					aria-expanded="false">접속하기<span class="caret"></span></a>
					<ul class="dropdown-menu">
						<li><a href="/login/login">로그인</a></li>
						<li><a href="/login/join">회원가입</a></li>
					</ul>
				</li>
			</ul>
			<!-- <ul class="nav navbar-nav navbar-right">
				<li class="dropdown">
					<a href="#" class="dropdown-toggle"
					data-toggle="dropdown" role="button" aria-haspopup="true"
					aria-expanded="false">회원관리<span class="caret"></span></a>
					<ul class="dropdown-menu">
						<li><a href="logoutAction.jsp">로그아웃</a></li>
					</ul>
				</li>
			</ul>  -->
		</div>
	</nav>
	<div class="container">
		<div class="row">
			<table class="table table-striped" style="text-align: center; border: 1px solid #dddddd">
				<thead>
					<tr>
						<th style="background-color: #eeeeee; text-align: center;">번호</th>
						<th style="background-color: #eeeeee; text-align: center;">제목</th>
						<th style="background-color: #eeeeee; text-align: center;">작성자</th>
						<th style="background-color: #eeeeee; text-align: center;">작성일</th>
						<th style="background-color: #eeeeee; text-align: center;">수정일</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${list}" var="board">
					<tr>
						<td><c:out value="${board.bno}" /></td>
						<td>
						<a class="move" href='<c:out value="${board.bno}"/>'><c:out value="${board.title}"/></a>
						</td>
						<td><c:out value="${board.writer}" /></td>
						<td><fmt:formatDate pattern="yyyy/MM/dd" value="${board.regDate }" /></td>
						<td><fmt:formatDate pattern="yyyy/MM/dd" value="${board.updateDate }" /></td>
					</tr>
					</c:forEach>
				</tbody>
			</table>
			
			<a href="/board/register" class="btn btn-primary pull-right">글쓰기</a>
		    
		    <div class="search_wrap">
		        <div class="search_area">
		        	<select name="type">
		                <option value="" <c:out value="${pageMaker.cri.type == null?'selected':'' }"/>>--</option>
		                <option value="T" <c:out value="${pageMaker.cri.type eq 'T'?'selected':'' }"/>>제목</option>
		                <option value="C" <c:out value="${pageMaker.cri.type eq 'C'?'selected':'' }"/>>내용</option>
		                <option value="W" <c:out value="${pageMaker.cri.type eq 'W'?'selected':'' }"/>>작성자</option>
		                <option value="TC" <c:out value="${pageMaker.cri.type eq 'TC'?'selected':'' }"/>>제목 + 내용</option>
		                <option value="TW" <c:out value="${pageMaker.cri.type eq 'TW'?'selected':'' }"/>>제목 + 작성자</option>
		                <option value="TCW" <c:out value="${pageMaker.cri.type eq 'TCW'?'selected':'' }"/>>제목 + 내용 + 작성자</option>
	            	</select>
		            <input type="text" name="keyword" value="${pageMaker.cri.keyword }">
		            <button>검색</button>
		        </div>
	    	</div> 
		    
		    <div class="pageInfo_wrap" >
	        	<div class="pageInfo_area">
					<ul id="pageInfo" class="pagination justify-content-center">
					
						<c:if test="${pageMaker.prev}">
							<li class="page-item"><a class="page-link" href="${pageMaker.startPage-1}">Previous</a></li>
						</c:if>
						
						<c:forEach var="num" begin="${pageMaker.startPage}" end="${pageMaker.endPage}">
							<li class="page-item ${pageMaker.cri.pageNum == num ? "active":"" }">
								<a href="${num}">${num}</a>
							</li>
						</c:forEach>
						
						<c:if test="${pageMaker.next}">
						<li class="page-item"><a class="page-link" href="${pageMaker.endPage + 1 }">Next</a></li>
						</c:if>
					</ul>
				</div>
			</div>
			
			<form id="moveForm" method="get">
				<input type="hidden" name="pageNum" value="${pageMaker.cri.pageNum}">
	        	<input type="hidden" name="amount" value="${pageMaker.cri.amount}">  
	        	<input type="hidden" name="keyword" value="${pageMaker.cri.keyword}">
	        	<input type="hidden" name="type" value="${pageMaker.cri.type}">
    		</form>
			
		</div>
	</div>
	<script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
	<script src="/resources/js/bootstrap.js"></script>
	
<!-- jQuery -->
<script type="text/javascript">

	$(document).ready(function() {
		
		let result = '<c:out value="${result}" />';
		
		checkAlert(result);
		console.log(result);
		
		function checkAlert(result) {
			if(result === '') {
				return;
			}
			
			if(result === "enroll success") {
				alert("글 등록이 완료 되었습니다.");
			}
			
			if(result === "modify success"){
	            alert("글 수정이 완료되었습니다.");
	        }
			
			if(result === "delete success"){
	            alert("삭제가 완료되었습니다.");
	        }
		}
	});
		
	let moveForm = $("#moveForm");
	 
    $(".move").on("click", function(e){
        e.preventDefault();
        
        moveForm.append("<input type='hidden' name='bno' value='"+ $(this).attr("href")+ "'>");
        moveForm.attr("action", "/board/get");
        moveForm.submit();
    });
    
    $(".page-item a").on("click", function(e){
    	 e.preventDefault();
    	 
    	 moveForm.find("input[name='pageNum']").val($(this).attr("href"));
         moveForm.attr("action", "/board/list");
         moveForm.submit();
        
    });
    
    $(".search_area button").on("click", function(e){
        e.preventDefault();
        
        let type = $(".search_area select").val();
        let keyword = $(".search_area input[name='keyword']").val();
        
        if(!type){
            alert("검색 종류를 선택하세요.");
            return false;
        }
        
        if(!keyword){
            alert("키워드를 입력하세요.");
            return false;
        }        
        
        moveForm.find("input[name='type']").val(type);
        moveForm.find("input[name='keyword']").val(keyword);
        moveForm.find("input[name='pageNum']").val(1);
        moveForm.submit();
    });
		
</script>
</body>
</html>