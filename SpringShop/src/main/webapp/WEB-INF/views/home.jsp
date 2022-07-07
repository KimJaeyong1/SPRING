<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
<meta name="description" content="" />
<meta name="author" content="" />
<title>스프링샵</title>
<link rel="icon" type="image/x-icon" href="/resources/images/favicon.ico" />
<!-- Bootstrap icons-->
<link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css" rel="stylesheet" />
<!-- Core theme CSS (includes Bootstrap)-->
<link href="/resources/css/styles.css" rel="stylesheet" />
<link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet">
<link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css" rel="stylesheet">
<script src="http://t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
 <script src="/resources/js/jquery-1.12.4.min.js"></script>
 <script src="/resources/js/jquery.ui.paging.js"></script>
</head>
<body class="d-flex flex-column h-100">
	<main class="flex-shrink-0">
		<!-- Navigation-->
		<nav class="navbar navbar-expand-lg navbar-dark bg-primary">
			<div class="container px-5">
				<a class="navbar-brand" href="/">스프링샵</a>
				<button class="navbar-toggler" type="button"
					data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent"
					aria-controls="navbarSupportedContent" aria-expanded="false"
					aria-label="Toggle navigation">
					<span class="navbar-toggler-icon"></span>
				</button>
				<div class="collapse navbar-collapse" id="navbarSupportedContent">
					<ul class="navbar-nav ms-auto mb-2 mb-lg-0">
						<li class="nav-item"><a class="nav-link" href="/">홈</a></li>
						<li class="nav-item"><a class="nav-link" href="/board/notice">공지사항</a></li>
						<li class="nav-item"><a class="nav-link" href="/gallery/gallery">갤러리</a></li>
						<c:if test="${member == null }">
						<li class="nav-item"><a class="nav-link" href="/member/login">로그인</a></li>
						<li class="nav-item"><a class="nav-link" href="/member/register">회원가입</a></li>
						</c:if>
						<c:if test="${member != null }">
						<li class="nav-item"><a class="nav-link" href="/member/info"><c:out value="${member.mi_id }" /></a></li>
						<li class="nav-item"><a class="nav-link" href="/logout">로그아웃</a></li>
						</c:if>
					</ul>
				</div>
			</div>
		</nav>
		<jsp:include page="${content }" />
	</main>
	<script type="text/javascript">
		let msg = "${MSG }";
		if(msg != ''){
			alert(msg);
		}
	</script>
	<!-- Footer-->
	<footer class="bg-dark py-4 mt-auto">
		<div class="container px-5">
			<div class="row align-items-center justify-content-between flex-column flex-sm-row">
				<div class="col-auto">
					<div class="small m-0 text-white">Copyright &copy; Your Website 2022</div>
				</div>
				<div class="col-auto">
					<a class="link-light small" href="#!">Privacy</a>
					<span class="text-white mx-1">&middot;</span>
					<a class="link-light small" href="#!">Terms</a>
					<span class="text-white mx-1">&middot;</span>
					<a class="link-light small" href="#!">Contact</a>
				</div>
			</div>
		</div>
	</footer>
	<!-- Bootstrap core JS-->
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
	<!-- Core theme JS-->
	<script src="/resources/js/scripts.js"></script>
</body>
</html>
