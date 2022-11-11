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
					<p class="fs-3">〜　マイセット登録完了　〜</p>
				</div>
			</div>
			<div class="row justify-content-center">
				<div class="col-auto mb-2">
					<p>以下の内容で登録しました。</p>
					<span>マイセット名:</span>
					<span class="fs-4"><c:out value="${name }"/></span>
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
		</div>
	</div>
</body>
</html>