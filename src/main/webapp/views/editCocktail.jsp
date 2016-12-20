<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<jsp:include page="header.jsp"></jsp:include>
<c:url value="/cocktail/save.html" var="saveUrl" />
<body>
	<div class="cocktail-details container">
		<h2>Modifier le cocktail :</h2>
		<form:form modelAttribute="cocktail" action="${saveUrl}">
			<form:hidden path="id" />
			<div class="form-group">
				<form:label path="name">Nom</form:label>
				<form:input path="name" class="form-control" />
			</div>
			<div class="form-group">
				<form:label path="price">Prix</form:label>
				<form:input path="price" type="number" min="0" step="0.01" class="form-control" />
			</div>
			<div class="checkbox">
				<form:label path="withAlcohol" for="withAlcohol">Avec alcool</form:label>
				<form:checkbox path="withAlcohol" id="withAlcohol" />
			</div>
			<button>Valider</button>
		</form:form>
	</div>
	<div class="cocktail-ingredients">
	
	</div>
	<div class="back">
		<a href="<c:url value='/cocktails.html' />">Retour</a>
	</div>
</body>
</html>