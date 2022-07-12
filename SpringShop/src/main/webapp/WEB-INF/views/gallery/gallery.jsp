<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="container px-5">
	<div class="row" id="list">
		<!-- 갤러리 게시판 리스트 내용 -->
	</div>
	<nav aria-label="...">
		<ul class="pagination pagination justify-content-center mt-5" id="pageNav">
		</ul>
	</nav>
	<div class="row justify-content-md-center">
		<div class="col col-lg-2">
			<select class="form-select" name="searchType">
				<option value="all">전체</option>
				<option value="gi_title">제목</option>
				<option value="gi_writer">작성자</option>
			</select>
		</div>
		<div class="col-md-auto">
			<input class="form-control" type="text" id="searchValue" name="searchValue" placeholder="검색어">
		</div>
		<div class="col col-lg-1">
			<input class="btn btn-primary" type="button" id="searchBtn" name="searchBtn" value="검색">
		</div>
		<span><a href="/gallery/writePage" class="btn btn-primary float-end my-4">글쓰기</a></span>
	</div>
</div>

<script>
$(document).ready(function() {
	getList(1);
	
	$("#searchBtn").on("click", function() {
		getList(1);
	});
});

function getList(selPage) {
	let data = {};
	let curPage = selPage;
	let pagePerCnt = 4;
	
	data.keyword = $("#searchValue").val();
	data.searchType = $("select[name=searchType]").val();
	data.curPage = curPage;
	data.pagePerCnt = pagePerCnt;
	
	$.ajax({
	    type: 'get',
	    url: '/gallery/getGalleryList',
	    data: data,
        error : function(error) {
			console.log(error);
			alert("Error!");
		},
	    success: function (value) {
	    	console.log(value);
	    	$("#list").empty();
	    	
	    	let html = '';
	    	let list = '';
	    	for(let i = 0; i < value.list.length; i++) {
	    		list = value.list[i];
	    		html += '<div class="col-md-3" >';
	    		html += '<div class="card-group mt-5 mx-2">';
	    		html += '<div class="card">';
	    		html += '<a href="/gallery/detailPage?gi_no='+ list.gi_no +'">';
	    		// html += '<img src="https://mdbcdn.b-cdn.net/img/new/standard/city/041.webp" class="card-img-top"/>';
	    		html += '<img src="/resources/file/F_16576000738983740448134289685204.png" class="card-img-top"/>';
	    		html += '</a>';
	    		html += '<div class="card-body">';
	    		html += '<h5 class="card-title">' + list.gi_title + '</h5>';
	    		html += '<p class="card-text">' + list.gi_writer + '</p>';
	    		html += '</div>'
	    		html += '</div>'
	    		html += '</div>'
	    		html += '</div>'
	    	}
	    	$("#list").append(html);
	    	$("#pageNav").paging({
	    		currentPage : curPage,
	    		pageTotal : value.searchDto.totalCnt,
	    		pageSize : pagePerCnt
	    	});
        }
	});
}

function goPage(selPage){
	console.log(selPage);
	getList(selPage);
}
</script>
