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
				<form:errors element="div" path="name" cssClass="alert alert-danger fade in" />
			</div>
			<div class="form-group">
				<form:label path="price">Prix</form:label>
				<form:input path="price" type="number" step="0.01" class="form-control" />
				<form:errors element="div" path="price" cssClass="alert alert-danger fade in" />
			</div>
			<div class="checkbox">
				<form:label path="withAlcohol" for="withAlcohol">Avec alcool</form:label>
				<form:checkbox path="withAlcohol" id="withAlcohol" />
			</div>
			<button>Valider</button>
		</form:form>
	</div>
	<div class="cocktail-ingredients container">
		<h2>Modifier la liste des ingrédients :</h2>
		<form action="<c:url value='/cocktail/saveIngredients.html' />" method="POST">
			<table id="cocktailIngredientsTable">
				<thead>
					<tr>
						<th>Ingrédient</th>
						<th>Quantité</th>
						<th />
					</tr>
				</thead>
				<tbody>
						<c:forEach items="${cocktailParts}" var="cocktailPart">
							<c:url value='/cocktail/removeIngredient.html' var="removeUrl">
								<c:param name="ingredientId" value="${cocktailPart.ingredient.id}" />
							</c:url>
							<tr>
								<td>${cocktailPart.ingredient.name}</td>
								<td><input type="number" min="0" name="quantity_${cocktailPart.ingredient.id}"
									value="${cocktailPart.quantity}" /></td>
								<td><a href="${removeUrl}">Supprimer</a></td>
							</tr>
						</c:forEach>
				</tbody>
			</table>
			<button style="float: right">Valider</button>
		</form>
		<form action="<c:url value='/cocktail/addIngredient.html' />">
			<select name="ingredientId">
				<c:forEach items="${ingredients}" var="ingredient">
					<option value="${ingredient.id}">${ingredient.name}</option>
				</c:forEach>
			</select>
			<button>Ajouter</button>
		</form>
	</div>
	<div class="back">
		<a href="<c:url value='/cocktails.html' />">Retour</a>
	</div>
	<script type="text/javascript">
		$('#cocktailIngredientsTable').DataTable();
	</script>
</body>
</html>