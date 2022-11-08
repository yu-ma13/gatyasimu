<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
	<title>ガチャシミュ</title>
</head>
<body class="bg-light">
	<div class="p-3 mb-2 bg-success text-white">
		<h1>ガチャシミュ</h1>
	</div>
	<div class="container">
		 <div class="row justify-content-center">
			 <div class="col-auto">
				<p class="fs-3">〜登録完了〜</p>
			</div>
		</div>
		 <div class="row justify-content-center">
		 	 <div class="col-auto">
		 	 	<p><c:out value="${name }"/>さん登録完了です。</p>
				<p>もう一度ログインしてください。</p>
				<a class="link-primary" href="/gatyasimu/">ログイン画面へ</a>
		 	 </div>
		 </div>
	</div>
</body>
</html>