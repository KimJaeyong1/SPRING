<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="container px-5 py-5">
	<form action="/modify" method="post" enctype="multipart/form-data">
		<div class="row gx-5 align-items-center justify-content-center">
			<div class="col-3">
				<label class="form-label">번호</label>
				<input type="text" class="form-control" id="bi_no" name="bi_no" value="<c:out value='${dto.boardDto.bi_no }' />" readonly>
			</div>
			<div class="col-4">
				<label class="form-label">작성자</label>
				<input type="text" class="form-control" id="bi_writer" name="bi_writer" value="<c:out value='${dto.boardDto.bi_writer }' />" readonly>
			</div>
			<div class="col-7 mt-3">
				<label class="form-label">제목</label>
				<input type="text" class="form-control" id="bi_title" name="bi_title" value="<c:out value='${dto.boardDto.bi_title }' />">
			</div>
			<div class="col-7 mt-3">
				<label class="form-label">내용</label>
				<textarea class="form-control" id="bi_content" name="bi_content" rows="10" style="resize:none"><c:out value='${dto.boardDto.bi_content }' /></textarea>
			</div>
			<!-- 첨부파일 -->
			<div class="col-7 mt-3" id="upload">
				<label class="form-label">첨부파일</label>
					<c:choose>
						<c:when test="${dto.attachDto == null}">
							<div class="form-control mb-2">
								<input type="file" name="file">
							</div>
						</c:when>
						<c:otherwise>
							<div class="form-control mb-2">
								<input type="file" name="file">
							</div>
							<div class="form-control">
								${dto.attachDto.file_name }
								<input type="button" id="fileDelete" name="fileDelete" class="btn btn-outline-danger btn-sm float-end" value="삭제">
							</div>
						</c:otherwise>
					</c:choose>
			</div>
			<!-- /첨부파일 -->
			<input type="hidden" id="bi_status" name="bi_status" value="<c:out value='${dto.boardDto.bi_status }' />">
			<div class="col-7 mt-3">
				<a class="btn btn-primary" href="javascript:dataPost('${dto.boardDto.bi_no}', '/remove')">삭제하기</a>
				<input class="btn btn-primary float-end" type="submit" value="수정하기">
				<a class="btn btn-primary float-end mx-3" href="/board/notice">목록으로</a>
			</div>
		</div>
	</form>
</div>
<script>
	$("#fileDelete").on("click", function() {
		fileData();
	});
	
	function fileData() {
		let data = {};
		data.bi_no = $("#bi_no").val();
		
		$.ajax({
			type: 'GET', //데이터 전송 타입
			url : "/fileDelete", //데이터를 주고받을 파일 주소 입력
			data: data, //보내는 데이터
			error:function(){  
				console.log(error);
				alert("Error!");
			},
			success: function(value){
				//작업이 성공적으로 발생했을 경우
				console.log(value);
				if(value == 1) {
					$("#upload").children().remove();
					
					let html = '';
					html += '<label class="form-label">첨부파일</label>';
					html += '<div class="form-control mb-2">';
					html += '<input type="file">';
					html += '<input type="button" id="fileModify" name="fileModify" class="btn btn-outline-danger btn-sm float-end" value="수정">';
					html += '</div>';
					
					$("#upload").append(html);
				}
			}
		})
	}
	
	function dataPost(bi_no, address, type) {
		if (confirm("정말 삭제 하시겠습니까??") == true) {
			let hiddenform = document.createElement('form');

			let obj;
			obj = document.createElement('input');
			obj.setAttribute('type', 'hidden');
			obj.setAttribute('name', 'bi_no');
			obj.setAttribute('value', bi_no);

			hiddenform.appendChild(obj);
			hiddenform.setAttribute('method', type);
			hiddenform.setAttribute('action', address);
			document.body.appendChild(hiddenform);
			hiddenform.submit();
		} else {
			return false;
		}
	};
</script>