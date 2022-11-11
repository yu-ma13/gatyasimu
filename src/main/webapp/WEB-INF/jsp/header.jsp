<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
	<title>header</title>
</head>
<body class="bg-light">
	<div class="d-flex bd-highlight bg-success  text-white">
		<h1 class="me-auto pt-2 ps-2 bd-highlight">ガチャシミュ</h1>
		<p class="pt-3 pe-2 bd-highlight">ユーザー名:<c:out value="${loginUser.name }"/></p>
	</div>
	<div class="d-flex justify-content-end mt-2">
		<nav aria-label="breadcrumb">
  			<ol class="breadcrumb">
  				<li class="breadcrumb-item"><a class="link-primary" href="/gatyasimu/Top">入力画面</a></li>
  				<li class="breadcrumb-item"><a class="link-danger" href="/gatyasimu/Logout">ログアウトして終了</a></li>
  			 </ol>
		</nav>
	</div>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" 
		integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" 
		crossorigin="anonymous">
	</script>
</body>
</html>