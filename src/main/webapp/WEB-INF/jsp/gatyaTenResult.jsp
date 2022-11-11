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
	<div class="container">
		<div class="row justify-content-center">
			<div class="col-auto">
				<p class="fs-4">〜　ガチャ結果　〜</p>
			</div>
		</div>
		<div class="row justify-content-center">
			<c:forEach var="i" begin="0" end="9" step="1">
				<c:if test="${(i + 1) % 10 != 9 && (i + 1) % 10 != 0 }">
					<div class="col-5 border border-white fs-4 bg-success text-white">
						<span>${i + 1 }. </span>
						<span><c:out value="${result.get(i) }"/></span>
					</div>
				</c:if>
				<c:if test="${(i + 1) % 10 == 9 }">
					<div class="col-5 border border-white mb-3 fs-4 bg-success text-white">
						<span>${i + 1 }. </span>
						<span><c:out value="${result.get(i) }"/></span>
					</div>
				</c:if>
				<c:if test="${(i + 1) % 10 == 0 }">
					<div class="col-5 border border-white mb-3 fs-4 bg-danger text-white">
						<span>${i + 1 }. </span>
						<span><c:out value="${result.get(i) }"/></span>
					</div>
				</c:if>
			</c:forEach>
		</div>
		<div class="row justify-content-center">
			<div class="col-auto">
				<p>使用金額: <c:out value="${money.money }"/>円</p>
			</div>
		</div>
		<div class="row justify-content-center">
			<div class="col-auto">
				<button class="m-2 btn btn-outline-success" onclick="window.location.reload()">
					同じ内容でもう一度回す
				</button>
			</div>
		</div>
	</div>
</body>
</html>