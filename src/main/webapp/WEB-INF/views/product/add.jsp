<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>
	<h2>Créer un nouveau produit :</h2>
	<form action="<c:url value="/product/add" />" method="post">
		<div>
			<label for="name">Nom :</label>
			<input id="name" name="name">
		</div>
		<div>
			<label for="stock">Stock :</label>
			<input type="number" min="0" id="stock" name="stock">
		</div>
		<button>Valider</button>
	</form>
</body>
</html>