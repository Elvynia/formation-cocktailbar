<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="../header.jsp" />
</head>
<body>
	<div class="container">
		<c:choose>
			<c:when test="${not empty product}">
				<h2>Modifier un produit existant :</h2>
			</c:when>
			<c:otherwise>
				<h2>Créer un nouveau produit :</h2>
			</c:otherwise>
		</c:choose>
		<form action="<c:url value="/product/add" />" method="post">
			<c:if test="${not empty product}">
				<input type="hidden" name="id" value="${product.id}">
			</c:if>
			<div class="form-group">
				<label for="name">Nom :</label>
				<input id="name" name="name" class="form-control"
					value="${not empty product ? product.name : ''}">
			</div>
			<div class="form-group">
				<label for="stock">Stock :</label>
				<input type="number" min="0"
					id="stock" name="stock" class="form-control"
					value="${not empty product ? product.stock : ''}">
			</div>
			<button class="btn btn-info">Valider</button>
		</form>
	</div>
	<jsp:include page="../footer.jsp" />
</body>
</html>