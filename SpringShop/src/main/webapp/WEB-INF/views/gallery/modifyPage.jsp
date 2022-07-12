<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="container px-5 py-5">
	<form action="/galleryModifyAction" method="post" enctype="multipart/form-data">
		<div class="row gx-5 align-items-center justify-content-center">
			<div class="col-3">
				<label class="form-label">번호</label>
				<input type="text" class="form-control" id="gi_no" name="gi_no" value="${dto.galleryDto.gi_no }" readonly>
			</div>
			<div class="col-4">
				<label class="form-label">작성자</label>
				<input type="text" class="form-control" id="gi_writer" name="gi_writer" value="${dto.galleryDto.gi_writer }" readonly>
			</div>
			<div class="col-7 mt-3">
				<label class="form-label">제목</label>
				<input type="text" class="form-control" id="gi_title" name="gi_title" value="${dto.galleryDto.gi_title }">
			</div>
			<div class="col-7 mt-3">
				<label class="form-label">내용</label>
				<textarea class="form-control" id="gi_content" name="gi_content" rows="10" style="resize:none">${dto.galleryDto.gi_content }</textarea>
			</div>
			<!-- 첨부파일 -->
			<div class="col-7 mt-3" id="upload">
				<label class="form-label">첨부파일</label>
				<c:choose>
					<c:when test="${dto.attachDto != null}">
						<div class="form-control mb-2">
							<input type="file" name="file">
						</div>
						<div class="form-control py-2">
							${dto.attachDto.file_name }
							<input type="button" id="galleryFileDelete" name="galleryFileDelete" class="btn btn-outline-danger btn-sm float-end" value="삭제">
						</div>
					</c:when>
					<c:otherwise>
						<div class="form-control mb-2">
							<input type="file" name="file">
						</div>
					</c:otherwise>
				</c:choose>
			</div>
			<!-- /첨부파일 -->
			<div class="col-7 mt-3">
				<a class="btn btn-primary" href="javascript:dataPost('${dto.galleryDto.gi_no}', '/galleryDeleteAction')">삭제하기</a>
				<input class="btn btn-primary float-end" type="submit" value="수정하기">
				<a class="btn btn-primary float-end mx-3" href="/gallery/gallery">목록으로</a>
			</div>
		</div>
	</form>
</div>
<script>
	$("#galleryFileDelete").on("click", function() {
		if (confirm("정말 삭제 하시겠습니까??") == true) {
			fileData();
		}
	});
	
	function fileData() {
		let data = {};
		data.gi_no = $("#gi_no").val();
		
		$.ajax({
			type: 'GET', //데이터 전송 타입
			url : "/galleryFileDeleteAction", //데이터를 주고받을 파일 주소 입력
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
					html += '<input type="file" name="file">';
					html += '</div>';
					html += '<div class="form-control py-2">';
					html += '첨부파일 삭제됨';
					html += '</div>';
					
					$("#upload").append(html);
				}
			}
		})
	}
	
	function dataPost(gi_no, address) {
		if (confirm("정말 삭제 하시겠습니까??") == true) {
			let hiddenform = document.createElement('form');

			let obj;
			obj = document.createElement('input');
			obj.setAttribute('type', 'hidden');
			obj.setAttribute('name', 'gi_no');
			obj.setAttribute('value', gi_no);

			hiddenform.appendChild(obj);
			hiddenform.setAttribute('method', 'get');
			hiddenform.setAttribute('action', address);
			document.body.appendChild(hiddenform);
			hiddenform.submit();
		} else {
			return false;
		}
	};
</script>