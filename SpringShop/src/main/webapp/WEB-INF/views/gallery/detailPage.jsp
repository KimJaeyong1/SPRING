<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="container px-5 py-5">
	<div class="row align-items-center justify-content-center">
		<div class="col-3">
			<label class="form-label">번호</label>
			<input type="text" class="form-control" id="gi_no" name="gi_no" value="<c:out value='${galleryInfo.gi_no }' />" readonly>
		</div>
		<div class="col-4">
			<label class="form-label">작성자</label> <input type="text" class="form-control" id="gi_writer" name="gi_writer" value="<c:out value='${galleryInfo.gi_writer }' />" readonly>
		</div>
		<div class="col-7 mt-3">
			<label class="form-label">제목</label> <input type="text" class="form-control" id="gi_title" name="gi_title" value="<c:out value='${galleryInfo.gi_title }' />" readonly>
		</div>
		<div class="col-7 mt-3">
			<label class="form-label">내용</label>
			<textarea class="form-control" id="gi_content" name="gi_content" rows="10" readonly style="resize:none"><c:out value='${galleryInfo.gi_content }' /></textarea>
		</div>
		<!-- 첨부파일 -->
		<div class="col-7 mt-3">
			<label class="form-label">첨부파일</label>
			<c:if test="${dto.attachDto != null }">
			<a href="<c:url value='/board/fileDownload?board_id=${dto.boardDto.bi_no }' />" class="form-control" id="file_name"><c:out value="${gallery.file_name }" /><span class="mx-3 float-end"><c:out value="${dto.attachDto.insert_dt }" /></span></a>
			</c:if>
			<c:if test="${dto.attachDto == null }">
			<div class="form-control">없음</div>
			</c:if>
		</div>
		<!-- /첨부파일 -->
		<div class="col-7 mt-3">
			<form action="/gallery/modifyPage?gi_no="${galleryInfo.gi_no } method="get">
				<input type="hidden" name="gi_no" value="${galleryInfo.gi_no }">
				<a class="btn btn-primary" href="/gallery/gallery">목록으로</a>
				<input class="btn btn-primary float-end" type="submit" value="수정하기">
			</form>
		</div>
	</div>
</div>