<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
	<jsp:include page="../header.jsp" />
</head>
<body>
	<div class="container">
		<h2>Créer un nouveau cocktail :</h2>
		<c:url value="/cocktail/add" var="postUrl" />
		<form:form modelAttribute="cocktail" action="${postUrl}" method="post">
			<form:hidden path="id" />
			<div class="form-group">
				<label for="name">Nom :</label>
				<form:input id="name" path="name" />
			</div>
			<div class="form-group">
				<label for="price">Prix :</label>
				 <form:input type="number" step="0.05" id="price" path="price" />
			</div>
			<div>
				<label for="withAlcohol">Avec alcool :</label>
				<form:checkbox id="withAlcohol" path="withAlcohol" />
			</div>
			<button class="btn btn-info">Valider</button>
		</form:form>
	</div>
	<jsp:include page="../footer.jsp" />
</body>
</html>