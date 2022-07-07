<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<div class="container">
	<div class="row justify-content-center my-3">
		<div class="col-lg-4">
			<div class="card shadow-lg border-0 rounded-lg my-5">
				<div class="card-body">
					<form action="/update" method="post">
						<div class="row mb-3">
							<div class="col-md-12">
								<div class="form-floating mb-3 mb-md-0">
									<input class="form-control" name="mi_id" id="inputId" type="text" value='<c:out value="${member.mi_id }" />' readonly/>
								</div>
							</div>
						</div>
						<div class="row mb-3">
							<div class="col-md-6">
								<div class="form-floating mb-3 mb-md-0">
									<input class="form-control" name="mi_pw" id="inputPassword" type="password" value='<c:out value="${member.mi_pw }" />'  />
								</div>
							</div>
							<div class="col-md-6">
								<div class="form-floating mb-3 mb-md-0">
									<input class="form-control" name="pwc" id="inputPasswordConfirm" type="password" value='<c:out value="${member.mi_pw }" />'  />
								</div>
							</div>
						</div>
						<div class="row mb-3">
							<div class="col-md-12">
								<div class="form-floating mb-3 mb-md-0">
									<input class="form-control" name="mi_name" id="inputName" type="text" value='<c:out value="${member.mi_name }" />' readonly/>
								</div>
							</div>
						</div>
						<div class="row mb-3">
							<div class="col-md-12">
								<div class="form-floating mb-3 mb-md-0">
									<input class="form-control" name="mi_mobile" id="inputNumber" type="text" value='<c:out value="${member.mi_mobile }" />' />
								</div>
							</div>
						</div>
						<div class="row mb-3">
							<div class="col-md-12">
								<div class="form-floating mb-3 mb-md-0">
									<input class="form-control" name="mi_email" id="inputEmail" type="email" value='<c:out value="${member.mi_email }" />' />
								</div>
							</div>
						</div>
						<div class="row mb-3">
							<div class="col-md-6 mb-2">
								<input class="form-control" type="text" name="mi_postcode" id="postcode" value='<c:out value="${member.mi_postcode }" />' >
							</div>
							<div class="col-md-6 mb-2">
								<input class="btn btn-primary" type="button" onclick="daumPostcode()" value="우편번호찾기"><br>
							</div>
							<div class="col-md-12">
								<div class="form-floating mb-3 mb-md-0">
									<input type="text" class="form-control mb-2" name="mi_roadaddress" id="roadAddress" value='<c:out value="${member.mi_roadaddress }" />' >
								</div> 
								<div class="form-floating mb-3 mb-md-0">
									<input type="text" class="form-control" name="mi_detailaddress" id="detailAddress" value='<c:out value="${member.mi_detailaddress }" />' >
								</div>
							</div>
						</div>
						<div class="col-md-12 text-center">
							<a class="btn btn-primary btn-lg" href="javascript:idPost('${member.mi_id}')">탈퇴하기</a>
							<input class="btn btn-primary btn-lg ms-2" type="submit" value="수정하기">
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>
</div>

<script>
	function idPost(mi_id) {
		if(confirm("정말 탈퇴 하시겠습니까??") == true) {
			let hiddenform = document.createElement('form');
			    
		    let obj;
		    obj = document.createElement('input');
		    obj.setAttribute('type', 'hidden');
		    obj.setAttribute('name', 'mi_id');
		    obj.setAttribute('value', mi_id);
		    
		    hiddenform.appendChild(obj);
		    hiddenform.setAttribute('method', 'post');
		    hiddenform.setAttribute('action', '/delete');
		    document.body.appendChild(hiddenform);
		    hiddenform.submit();
		} else {
			return false;
		}
	}
	//본 예제에서는 도로명 주소 표기 방식에 대한 법령에 따라, 내려오는 데이터를 조합하여 올바른 주소를 구성하는 방법을 설명합니다.
	function daumPostcode() {
		new daum.Postcode(
			{
				oncomplete : function(data) {
				var roadAddr = data.roadAddress; // 도로명 주소 변수
						
				document.getElementById('postcode').value = data.zonecode;
				document.getElementById("roadAddress").value = roadAddr;
				}
			}).open();
	}
</script>