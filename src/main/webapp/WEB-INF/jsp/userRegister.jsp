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
			 	<p class="fs-3">〜　新規登録　〜</p>
			 </div>
		</div>
		<div class="row justify-content-center">
			<div class="col-auto">
				<form action="/gatyasimu/UserRegister" method="post">
					<div class="mb-3">
						<label class="form-label">ユーザー名</label>
						<input class="form-control" type="text" maxlength="10" name="name" 
							<c:if test="${not empty name }">value="${name }"</c:if> placeholder="ユーザー名(1〜10文字)">
					</div>
					<div class="mb-3 text-danger">
						<c:if test="${not empty nameNull }">
							<p>${nameNull }</p>
						</c:if>
						<c:if test="${not empty errorName }">
							<p>${errorName }</p>
						</c:if>
					</div>
					<div class="mb-3">
						<label class="form-label">パスワード</label>
						<input class="form-control" type="password" maxlength="10" name="pass" placeholder="パスワード(1〜10文字)">
					</div>
					<div class="mb-3 text-danger">
						<c:if test="${not empty passNull }">
							<p>${passNull }</p>
						</c:if>
					</div>
					<div class="mb-3">
						<label class="form-label">パスワード確認用</label>
						<input class="form-control" type="password" maxlength="10" name="checkPass" placeholder="パスワード(1〜10文字)">
					</div>
					<div class="mb-3 text-danger">
						<c:if test="${not empty errorPass }">
							<p>${errorPass }</p>
						</c:if>
					</div>
					<div class="mb-3">
						<input class="btn btn-outline-success" type="submit" value="登録する">
					</div>
				</form>
				<a class="link-primary" href="/gatyasimu/index.jsp">←戻る</a>
			</div>
		</div>
	</div>
</body>
</html>