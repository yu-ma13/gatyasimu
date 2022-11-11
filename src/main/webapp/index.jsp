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
			 	<p class="fs-3">〜　ログイン画面　〜</p>
			 </div>
		</div>
		<form action="/gatyasimu/Top" method="post">
			<div class="row justify-content-center">
				 <div class="col-auto">
			 		<div class="mb-3">
			 			<label class="form-label">ユーザー名</label>
			 			<input class="form-control" type="text" maxlength="10" name="name" 
							<c:if test="${not empty name }"> value="${name }" </c:if> placeholder="ユーザー名(1〜10文字)">
			 		</div>
					<div class="mb-3">
						<label class="form-label">パスワード</label>
						<input class="form-control" type="password" maxlength="10" name="pass" 
							placeholder="パスワード(1〜10文字)">
					</div>
					<div class="mb-3 text-danger">
						<c:if test = "${not empty error }">
							<p>${error[0] }</p>
							<p>${error[1] }</p>
						</c:if>
					</div>
				</div>
			</div>
			<div class="row justify-content-center">
				 <div class="col-auto">
					<div class="mb-3">
						<input class="btn btn-outline-success" type="submit" Value="ログイン">
					</div>
				</div>
			</div>
		</form>
		<div class="row justify-content-center">
			<div class="col-auto">
				<a class="link-primary" href="/gatyasimu/UserRegister">新規登録はこちらから</a>
			</div>
		</div>
	</div>
</body>
</html>