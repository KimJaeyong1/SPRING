<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="container">
	<div class="row justify-content-center mt-5">
		<div class="col-lg-4">
			<div class="card shadow-lg border-0 rounded-lg mt-5">
				<div class="card-body">
					<form action="/login" method="post">
						<div class="form-floating mb-3">
							<input class="form-control" name="mi_id" id="inputId" type="text" placeholder="Enter your ID" />
							<label for="inputId">아이디</label>
						</div>
						<div class="form-floating mb-3">
							<input class="form-control" name="mi_pw" id="inputPw" type="password" placeholder="Password" />
							<label for="inputPassword">비밀번호</label>
						</div>
						<div class="form-check mb-3">
							<input class="form-check-input" id="inputRememberPassword" type="checkbox" value="" />
							<label class="form-check-label" for="inputRememberPassword">아이디 저장하기</label>
						</div>
						<div
							class="d-flex align-items-center justify-content-between mt-4 mb-0">
							<a class="small" href="/member/password">비밀번호를 잊으셨나요?</a>
							<input class="btn btn-primary" type="submit" value="로그인">
						</div>
					</form>
				</div>
				<div class="card-footer text-center py-3">
					<div class="small">
						<a href="/member/register">계정이 필요하신가요? 회원가입!</a>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>