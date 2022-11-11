<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>ガチャシミュ</title>
</head>
<body>
	<jsp:include page="/WEB-INF/jsp/header.jsp"/>
	<div class="d-flex justify-content-end">
		<div class="btn-group">
			<button type="button" class="btn btn-success dropdown-toggle" 
				data-bs-toggle="dropdown" aria-expanded="false">
				マイセット一覧
			</button>
			<ul class="dropdown-menu">
				<c:if test="${not empty mysetNames }">
					<c:forEach var="i" begin="0" end="${mysetNames.size() - 1 }" step="1">
						<form action="/gatyasimu/Myset" method="post">
							<input class="btn btn-outline-success" name="name" type="submit" value="${mysetNames.get(i) }">
						</form>
					</c:forEach>
					<a class="link-danger" href="/gatyasimu/MysetDelete">マイセットの削除</a>
				</c:if>
				<c:if test="${empty mysetNames }">
					<p>マイセットは登録されていません</p>
				</c:if>
			</ul>
		</div>
	</div>
	<div class="container">
		<div class="row justify-content-center">
			<div class="col-auto">
				<p class="fs-3">〜　入力画面　〜</p>
			</div>
		</div>
		<div class="row justify-content-center">
			<div class="col-auto">
				<p>上から順に各レアリティとその排出率を入力してください</p>
				<p>※排出率は合計100%になるようにしてください</p>
			</div>
		</div>
		<div class="row justify-content-center">
			<div class="col-auto">
				<c:if test="${not empty mysetName }">
					<p>マイセット：<c:out value="${mysetName }"/></p>
				</c:if>
			</div>
		</div>
		<form action="#" method="post">
			<div class="row justify-content-center">
				<div class="col-auto">
					<div class="input-group mb-2">
						<span class="input-group-text bg-success text-white">1</span>
						<input class="form-control" type="text" maxlength="10" name="ra1" 
							<c:if test="${not empty ra }">value="${ra.get(0) }"</c:if> placeholder="レアリティ(1〜10文字)">
						<input class="form-control" type="text" pattern="^([1-9]\d*|0)(\.\d+)?$" maxlength="10" name="pr1" 
							<c:if test="${not empty pr }">value="${pr.get(0) }"</c:if> placeholder="排出率(%)">
					</div>
					<div class="input-group mb-2">
						<span class="input-group-text bg-success text-white">2</span>
						<input class="form-control" type="text" maxlength="10" name="ra2" 
							<c:if test="${not empty ra }">value="${ra.get(1) }"</c:if> placeholder="レアリティ(0〜10文字)">
						<input class="form-control" type="text" pattern="^([1-9]\d*|0)(\.\d+)?$" maxlength="10" name="pr2" 
							<c:if test="${not empty pr }">value="${pr.get(1) }"</c:if> placeholder="排出率(%)">
					</div>
					<div class="input-group mb-2">
						<span class="input-group-text bg-success text-white">3</span>
						<input class="form-control" type="text" maxlength="10" name="ra3" 
							<c:if test="${not empty ra }">value="${ra.get(2) }"</c:if> placeholder="レアリティ(0〜10文字)">
						<input class="form-control" type="text" pattern="^([1-9]\d*|0)(\.\d+)?$" maxlength="10" name="pr3" 
							<c:if test="${not empty pr }">value="${pr.get(2) }"</c:if> placeholder="排出率(%)">
					</div>
					<div class="input-group mb-2">
						<span class="input-group-text bg-success text-white">4</span>
						<input class="form-control" type="text" maxlength="10" name="ra4" 
							<c:if test="${not empty ra }">value="${ra.get(3) }"</c:if> placeholder="レアリティ(0〜10文字)">
						<input class="form-control" type="text" pattern="^([1-9]\d*|0)(\.\d+)?$" maxlength="10" name="pr4" 
							<c:if test="${not empty pr }">value="${pr.get(3) }"</c:if> placeholder="排出率(%)">
					</div>
					<div class="input-group mb-2">
						<span class="input-group-text bg-success text-white">5</span>
						<input class="form-control" type="text" maxlength="10" name="ra5" 
							<c:if test="${not empty ra }">value="${ra.get(4) }"</c:if> placeholder="レアリティ(0〜10文字)">
						<input class="form-control" type="text" pattern="^([1-9]\d*|0)(\.\d+)?$" maxlength="10" name="pr5" 
							<c:if test="${not empty pr }">value="${pr.get(4) }"</c:if> placeholder="排出率(%)">
					</div>
					<c:if test="${not empty error }">
						<div class="text-danger mb-3">
							<p>${error }</p>
						</div>
					</c:if>
					<div class="input-group mb-2">
						<label class="input-group-text bg-success text-white">ガチャ1回当たりの金額</label>
						<input class="form-control" type="text" pattern="^[1-9][0-9]*$" maxlength="4" name="money" placeholder="0〜9999(円)">
					</div>
				</div>
			</div>
			<div class="row justify-content-center">
				<div class="col-auto">
					<div class="input-group mb-2">
						<input class="btn btn-outline-success" type="submit" formaction="/gatyasimu/Main" value="入力内容を確定">
					</div>
				</div>
			</div>
			<div class="row justify-content-center">
				<div class="col-auto">
					<p class="mt-3">入力内容をマイセットに登録する場合はこちら↓</p>
					<div class="input-group mb-3">
						<input class="form-control" type="text" maxlength="10" name="name" 
							<c:if test="${not empty name }"> value="${name }" </c:if> placeholder="マイセット名(1〜10文字)">
						<input class="btn btn-outline-success" type="submit" formaction="/gatyasimu/MysetRegister" value="マイセット登録">
					</div>
				</div>
			</div>
		</form>
	</div>
</body>
</html>