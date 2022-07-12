<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<div class="container px-5">
	<div class="row gx-5 align-items-center justify-content-center">
		<div class="table-responsive mt-5">
			<table class="table table-hover caption-top">
				<caption>공지사항</caption>
				<thead>
					<tr>
						<th>번호</th>
						<th colspan="7">제목</th>
						<th>작성자</th>
						<th>등록일</th>
						<th>조회수</th>
					</tr>
				</thead>
				<tbody class="list">
					
				</tbody>
			</table>
			<nav aria-label="Page navigation example">
				<ul id="pageNav" class="pagination justify-content-center">
				</ul>
			</nav>
			<div class="row justify-content-md-center">
				<div class="col col-lg-2">
					<select class="form-select" name="searchType">
						<option value="all">전체</option>
						<option value="bi_title">제목</option>
						<option value="bi_writer">작성자</option>
					</select>
				</div>
				<div class="col-md-auto">
					<input class="form-control" type="text" id="inputSearch" name="inputSearch" placeholder="검색어">
				</div>
				<div class="col col-lg-1">
					<input class="btn btn-primary" id="search" name="search" type="button" value="검색">
				</div>
			</div>
			<span><a href="/board/write" class="btn btn-primary float-end">글쓰기</a></span>
		</div>
	</div>
</div>
<script>

$(document).ready(function(){
	getList(1);
	
	$("#search").on("click", function() {
		getList(1);
	});
});

	
function getList(selPage){
	let data = {};
	let curPage = selPage; // 현재 페이지
	let pagePerCnt = 4; // 보여줄 게시물 갯수
	
	data.keyword = $("#inputSearch").val();
	data.searchType = $("select[name=searchType]").val();
	data.curPage = curPage;
	data.pagePerCnt = pagePerCnt;
	
	$.ajax({
		type : 'GET', //HTTP METHOD
		url : "/board/getNoticeList", // 요청보낼 URL
		data : data, // 클라이언트 > 서버에 요청할 때 정보넣는 곳 (객체)
		error : function(error) {
			console.log(error);
			alert("Error!");
		},
		success : function(value) {
			console.log(value);
			$(".list").children().remove();
			
			let html = '';
			let list = '';
			for (let i = 0; i < value.list.length; i++) {
				list = value.list[i];
				html += '<tr>';
				html += '<td>'+ list.bi_no +'</td>';
				html += '<td colspan="7"><a href="/board/page?bi_no='+ list.bi_no +'">'+ list.bi_title+ '</a></td>';
				html += '<td>'+ list.bi_writer +'</td>';
				html += '<td>'+ list.bi_insertdt +'</td>';
				html += '<td>'+ list.bi_hit +'</td>';
				html += '</tr>';
			}
			$(".list").append(html);
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