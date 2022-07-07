<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="container px-5 py-5">
	<form action="/write" method="post" enctype="multipart/form-data">
		<div class="row gx-5 align-items-center justify-content-center">
			<div class="col-7">
				<label class="form-label">작성자</label>
				<c:if test="${member != null }">
				<input type="text" class="form-control" id="bi_writer" name="bi_writer" value="${member.mi_id }" readonly>
				</c:if>
				<c:if test="${member == null }">
				<input type="text" class="form-control" id="bi_writer" name="bi_writer">
				</c:if>
			</div>
			<div class="col-7 mt-3">
				<label class="form-label">제목</label>
				<input type="text" class="form-control" id="bi_title" name="bi_title">
			</div>
			<div class="col-7 mt-3">
				<label class="form-label">내용</label>
				<textarea class="form-control" id="bi_content" name="bi_content" rows="10"></textarea>
			</div>
			<div class="col-7 mt-3">
				<label class="form-label">파일</label>
				<input type="file" name="file">
			</div>
			<input type="hidden" class="form-control" id="bi_status" name="bi_status" value="0">
			<div class="col-7 mt-3">
				<a class="btn btn-primary" href="/board/notice">목록으로</a>
				<input class="btn btn-primary float-end" type="submit" value="등록">
			</div>
		</div>
	</form>
</div>
	
