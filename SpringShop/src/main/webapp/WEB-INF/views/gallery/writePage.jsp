<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="container px-5 py-5">
	<form action="/galleryWriteAction" method="post" enctype="multipart/form-data">
		<div class="row gx-5 align-items-center justify-content-center">
			<div class="col-7">
				<label class="form-label">작성자</label>
				<c:if test="${member != null }">
				<input type="text" class="form-control" id="gi_writer" name="gi_writer" value="${member.mi_id }" readonly>
				</c:if>
				<c:if test="${member == null }">
				<input type="text" class="form-control" id="gi_writer" name="gi_writer">
				</c:if>
			</div>
			<div class="col-7 mt-3">
				<label class="form-label">제목</label>
				<input type="text" class="form-control" id="gi_title" name="gi_title">
			</div>
			<div class="col-7 mt-3">
				<label class="form-label">내용</label>
				<textarea class="form-control" id="gi_content" name="gi_content" rows="10"></textarea>
			</div>
			<div class="col-7 mt-3">
				<label class="form-label">파일</label>
				<input type="file" name="file">
			</div>
			<div class="col-7 mt-3">
				<a class="btn btn-primary" href="/gallery/gallery">목록으로</a>
				<input class="btn btn-primary float-end" type="submit" value="등록">
			</div>
		</div>
	</form>
</div>
	
