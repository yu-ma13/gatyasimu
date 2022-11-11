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
	<div class="p-3 mb-2 bg-light text-dark">
		<div class="container">
			<div class="row justify-content-center">
				<div class="col-auto">
					<p class="fs-3">〜　確認画面　〜</p>
				</div>
			</div>
			<div class="row justify-content-center">
				<div class="col-auto mb-3">
					<c:forEach var="i" begin="0" end="${contents.rarity.size() - 1 }" step="1">
						<ul class="mb-1 list-group list-group-horizontal">
							<li class="col-1 list-group-item bg-success text-white">${i + 1 }</li>
							<li class="col-8 list-group-item"><c:out value="${contents.rarity.get(i) }"/></li>
							<li class="col-6 list-group-item"><c:out value="${contents.probability.get(i) }"/>(%)</li>
						</ul>
					</c:forEach>
				</div>
			</div>
			<div class="row justify-content-center">
				<div class="col-auto">
					<p>回数を指定して実行する場合はこちら↓</p>
					<form action="Gatya" method="post">
						<div class="input-group mb-2">
							<label class="input-group-text bg-success text-white">ガチャ1回当たりの金額</label>
							<input class="form-control" type="text" pattern="^[1-9][0-9]*$" maxlength="4" name="money" placeholder="0〜9999円(任意)">
						</div>
						<div class="input-group mb-2">
							<input class="form-control" type="text" pattern="^[1-9][0-9]*$" maxlength="3" name="gatya" placeholder="1〜100(回)">
							<input class="btn btn-outline-success" type="submit" value="回数を指定して実行">
						</div>
						<c:if test="${not empty error }">
							<div class="text-danger mb-3">
								<p>${error }</p>
							</div>
						</c:if>
					</form>
				</div>
			</div>
			<br>
			<div class="row justify-content-center">
				<div class="col-auto">
					<p class="fs-3">〜　10連確定枠を設定して実行　〜</p>
				</div>
			</div>
			<div class="row justify-content-center">
				<div class="col-auto">
					<p>上から順に各レアリティとその排出率を入力してください</p>
					<p>※排出率は合計100%になるようにしてください</p>
				</div>
			</div>
			<form action="GatyaTen" method="post">
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
						<c:if test="${not empty errorTen }">
							<div class="text-danger mb-3">
								<p>${errorTen }</p>
							</div>
						</c:if>
					</div>
				</div>
				<div class="row justify-content-center">
					<div class="col-auto">
						<div class="input-group mb-2">
							<label class="input-group-text bg-success text-white">ガチャ1回当たりの金額</label>
							<input class="form-control" type="text" pattern="^[1-9][0-9]*$" maxlength="4" name="money" placeholder="0〜9999円(任意)">
						</div>
					</div>
				</div>
				<div class="row justify-content-center">
					<div class="col-auto">
						<input class="btn btn-outline-success" type="submit" value="10連実行">
					</div>
				</div>
			</form>
		</div>
	</div>
</body>
</html>