<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<div class="container">
	<div class="row justify-content-center my-3">
		<div class="col-lg-4">
			<div class="card shadow-lg border-0 rounded-lg my-5">
				<div class="card-body">
					<div class="row mb-3">
						<div class="col-md-12">
							<div class="form-floating mb-3 mb-md-0">
								<input class="form-control" name="mi_id" id="inputId" type="text" value='<c:out value="${member.mi_id }" />' readonly/>
							</div>
						</div>
					</div>
					<div class="row mb-3">
						<div class="col-md-12">
							<div class="form-floating mb-3 mb-md-0">
								<input class="form-control" name="mi_name" id="inputName" type="text" value='<c:out value="${member.mi_name }" />' readonly />
							</div>
						</div>
					</div>
					<div class="row mb-3">
						<div class="col-md-12">
							<div class="form-floating mb-3 mb-md-0">
								<input class="form-control" name="mi_mobile" id="inputNumber" type="text" value='<c:out value="${member.mi_mobile }" />' readonly />
							</div>
						</div>
					</div>
					<div class="row mb-3">
						<div class="col-md-12">
							<div class="form-floating mb-3 mb-md-0">
								<input class="form-control" name="mi_email" id="inputEmail" type="email" value='<c:out value="${member.mi_email }" />' readonly />
							</div>
						</div>
					</div>
					<div class="row mb-3">
						<div class="col-md-6 mb-2">
							<input class="form-control" type="text" name="mi_postcode" id="postcode" value='<c:out value="${member.mi_postcode }" />' readonly >
						</div>
						<div class="col-md-12">
							<div class="form-floating mb-3 mb-md-0">
								<input type="text" class="form-control mb-2" name="mi_roadaddress" id="roadAddress" value='<c:out value="${member.mi_roadaddress }" />' readonly >
							</div> 
							<div class="form-floating mb-3 mb-md-0">
								<input type="text" class="form-control" name="mi_detailaddress" id="detailAddress" value='<c:out value="${member.mi_detailaddress }" />' readonly >
							</div>
						</div>
					</div>
					<div class="col-md-12 text-center">
						<a class="btn btn-primary btn-lg btn-block" href="/member/update">정보수정</a>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
