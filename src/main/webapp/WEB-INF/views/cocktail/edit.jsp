<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<jsp:include page="header.jsp" />
<body>
	<h1>Créer un nouveau cocktail :</h1>
	<div class="container">
		 <form:form action="#" method="post" modelAttribute="newCocktail">
		 	<div class="form-group">
		 		<label for="name">Nom :</label>
		 		<form:input path="name" id="name" class="form-control" />
		 	</div>
		 	<div class="form-group">
		 		<label for="withAlcohol">Avec alcool :</label>
		 		<form:checkbox path="withAlcohol" id="withAlcohol" />
		 	</div>
		 	<div class="form-group">
		 		<label for="price">Prix :</label>
		 		<form:input type="number" step="0.05" path="price" id="price" class="form-control" />
		 	</div>
		 	<button>Valider</button>
		 </form:form>
	</div>
	<jsp:include page="footer.jsp" />
</body>
</html>