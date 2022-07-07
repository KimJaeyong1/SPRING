<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="container">
	<div class="row justify-content-center my-3">
		<div class="col-lg-4">
			<div class="card shadow-lg border-0 rounded-lg my-5">
				<div class="card-body">
					<form id="registerForm" action="/join" method="post">
						<div class="row mb-3">
							<div class="col-md-12">
								<div class="form-floating mb-3 mb-md-0">
									<input class="form-control" name="mi_id" id="inputId" type="text" placeholder="Enter your ID" />
									<label for="inputId">아이디</label>
								</div>
							</div>
						</div>
						<div class="row mb-3">
							<div class="col-md-6">
								<div class="form-floating mb-3 mb-md-0">
									<input class="form-control" name="mi_pw" id="inputPassword" type="password" placeholder="Create a Password" />
									<label for="inputPassword">비밀번호</label>
								</div>
							</div>
							<div class="col-md-6">
								<div class="form-floating mb-3 mb-md-0">
									<input class="form-control" name="pwc" id="inputPasswordConfirm" type="password" placeholder="Confirm Password" />
									<label for="inputPasswordConfirm">비밀번호 확인</label>
								</div>
							</div>
						</div>
						<div class="row mb-3">
							<div class="col-md-12">
								<div class="form-floating mb-3 mb-md-0">
									<input class="form-control" name="mi_name" id="inputName" type="text" placeholder="Enter your Name" />
									<label for="inputName">이름</label>
								</div>
							</div>
						</div>
						<div class="row mb-3">
							<div class="col-md-12">
								<div class="form-floating mb-3 mb-md-0">
									<input class="form-control" name="mi_mobile" id="inputNumber" type="text" placeholder="Enter your Phone Number" />
									<label for="inputNumber">연락처</label>
								</div>
							</div>
						</div>
						<div class="row mb-3">
							<div class="col-md-12">
								<div class="form-floating mb-3 mb-md-0">
									<input class="form-control" name="mi_email" id="inputEmail" type="email" placeholder="name@example.com" />
									<label for="inputEmail">이메일</label>
								</div>
							</div>
						</div>
						<div class="row mb-3">
							<div class="col-md-6 mb-2">
								<input class="form-control" type="text" name="mi_postcode" id="postcode" placeholder="우편번호">
							</div>
							<div class="col-md-6">
								<input class="btn btn-primary" type="button" onclick="daumPostcode()" value="우편번호찾기"><br>
							</div>
							<div class="col-md-12">
								<div class="form-floating mb-3 mb-md-0">
									<input type="text" class="form-control mb-2" name="mi_roadaddress" id="roadAddress" placeholder="도로명주소">
									<label for="inputRoadAddress">도로명주소</label>
								</div> 
								<div class="form-floating mb-3 mb-md-0">
									<input type="text" class="form-control" name="mi_detailaddress" id="detailAddress" placeholder="상세주소">
									<label for="inputDetailAddress">상세주소</label> 
								</div>
							</div>
						</div>
						<div class="mt-4 mb-0">
							<input class="form-control btn btn-primary btn-block" type="submit" value="회원가입" onclick="idCheck()">
						</div>
					</form>
				</div>
				<div class="card-footer text-center py-3">
					<div class="small">
						<a href="/member/login">계정이 있으신가요? 로그인 페이지로</a>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>

<script>
	document.querySelector("registerForm").addEventListener("submit", function(e) {
			e.preventDefault();
		var inputId = document.getElementById("inputId").value;
		if(inputId == "") {
			alert("아이디를 입력해주세요.");
		}
	});
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