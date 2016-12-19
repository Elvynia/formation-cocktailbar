<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<jsp:include page="header.jsp" />
<body>
	<c:url value="/ingredients/add.html" var="addUrl" />
	<div class="container">
		<h1>Ajouter un ingrédient :</h1>
		<form action="${addUrl}" method="POST">
			<div class="form-group">
				<label for="name">Nom :</label>
				<input id="name" name="name" class="form-control" />
			</div>
			<div class="form-group">
				<label for="state">Etat :</label>
				<input type="number" min="0" max="2" id="state" name="state" class="form-control" />
			</div>
			<button class="btn btn-default">Valider</button>
		</form>
	</div>
	<div class="back">
		<a href="<c:url value='/' />">Retour</a>
	</div>
</body>
</html>