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
					<p class="fs-3">〜　マイセットの削除　〜</p>
					<p class="text-danger">※マイセット名を押すと削除されます。</p>
				</div>
			</div>
			<div class="row justify-content-center">
				<c:forEach var="i" begin="0" end="${mysetNames.size() - 1 }" step="1">
					<div class="col-auto">
						<form class="m-3" action="MysetDelete" method="post">
							<input class="btn btn-outline-danger" role="button" 
								name="name" type="submit" value="${mysetNames.get(i) }">
						</form>
					</div>
				</c:forEach>
			</div>
		</div>
	</div>
</body>
</html>