<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="container">
	<div class="row">
		<div class="col-sm-6 mt-5 bg-light p-4">
			<div class="main-block">
				<h4 class="main-header">
					<i class="fa fa-star"></i> 공지사항
				</h4>
				<div class="panel panel-default">
					<div class="list-group">
					<c:forEach var="board" items="${list }" begin="0" end="10">
						<a href="/board/page?bi_no=${board.bi_no }" class="list-group-item list-group-item-action" aria-current="true">
							<span class="d-flex w-100 justify-content-between">
								<span><c:out value="${board.bi_title }" /></span>>
								<small class="text-muted"><c:out value="${board.bi_writer }" /></small>
								<small>1일전</small>
							</span>
						</a>
					</c:forEach>
					</div>
				</div>
			</div>
		</div>
		<div class="col-sm-6 mt-5 bg-light p-4">
			<div class="main-block">
				<h4 class="main-header">
					<i class="fa fa-star"></i> 갤러리
				</h4>
				<div class="panel panel-default">
					<div class="list-group">
						<a href="#" class="list-group-item list-group-item-action" aria-current="true">
							<span class="d-flex w-100 justify-content-between">
								<span><strong>갤러리 글제목</strong></span>
								<small class="text-muted">갤러리 작성자</small>
								<small>1일전</small>
							</span>
						</a>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>