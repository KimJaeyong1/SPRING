<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="container px-5 py-5">
	<div class="row align-items-center justify-content-center">
		<div class="col-3">
			<label class="form-label">번호</label>
			<input type="text" class="form-control" id="bi_no" name="bi_no" value="<c:out value='${dto.boardDto.bi_no }' />" readonly>
		</div>
		<div class="col-4">
			<label class="form-label">작성자</label> <input type="text" class="form-control" id="bi_writer" name="bi_writer" value="<c:out value='${dto.boardDto.bi_writer }' />" readonly>
		</div>
		<div class="col-7 mt-3">
			<label class="form-label">제목</label> <input type="text" class="form-control" id="bi_title" name="bi_title" value="<c:out value='${dto.boardDto.bi_title }' />" readonly>
		</div>
		<div class="col-7 mt-3">
			<label class="form-label">내용</label>
			<textarea class="form-control" id="bi_content" name="bi_content" rows="10" readonly style="resize:none"><c:out value='${dto.boardDto.bi_content }' /></textarea>
		</div>
		<!-- 첨부파일 -->
		<div class="col-7 mt-3">
			<label class="form-label">첨부파일</label>
			<c:choose>
				<c:when test="${dto.attachDto != null }">
					<a href="<c:url value='/board/fileDownload?board_id=${dto.boardDto.bi_no }' />" class="form-control" id="file_name"><c:out value="${dto.attachDto.file_name }" /><span class="mx-3 float-end"><c:out value="${dto.attachDto.insert_dt }" /></span></a>
				</c:when>
				<c:otherwise>
					<div class="form-control">없음</div>
				</c:otherwise>
			</c:choose>
		</div>
		<!-- /첨부파일 -->
		<input type="hidden" class="form-control" id="bi_status" name="bi_status" value="<c:out value='${dto.boardDto.bi_status }' />"
			readonly>
		<div class="col-7 mt-3">
			<form action="/board/modify?bi_no="${dto.boardDto.bi_no } method="get">
				<input type="hidden" name="bi_no" value="${dto.boardDto.bi_no }">
				<a class="btn btn-primary" href="/board/notice">목록으로</a>
				<input class="btn btn-primary float-end" type="submit" value="수정하기">
			</form>
		</div>
	</div>
</div>

<script>
	let dto = "${dto.attachDto.file_num }";
	console.log(dto);
</script>