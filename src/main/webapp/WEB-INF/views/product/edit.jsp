<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<jsp:include page="../header.jsp" />
<body>
	<div class="container">
		<!-- Test de la présence d'un produit dans le Model pour savoir si c'est de la création ou modification -->
			<c:choose>
				<c:when test="${not empty product}">
					<h1>Modifier un produit existant :</h1>
				</c:when>
				<c:otherwise>
					<h1>Créer un nouveau produit :</h1>
				</c:otherwise>
			</c:choose>
		<form action="<c:url value="/product/edit.html" />" method="post">
			<c:if test="${not empty product}">
				<input type="hidden" name="id" value="${product.id}">			
			</c:if>
			<div class="form-group">
				<label for="name">Nom :</label>
				<input class="form-control" id="name" name="name"
					value="${not empty product ? product.name : '' }">
			</div>
			<div class="form-group">
				<label for="stock">Stock :</label>
				<input type="number" class="form-control" id="stock" name="stock"
					value="${not empty product ? product.stock : '' }">
			</div>
			<button>Valider</button>
		</form>
	</div>
	<jsp:include page="../footer.jsp" />
</body>
</html>