<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div>
	<h2>Recette du cocktail :</h2>
	<table id="ingredientTable" class="table">
		<thead>
			<tr>
				<th>Produit</th>
				<th>Quantité</th>
				<th />
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${ingredientList}" var="ingredient">
				<tr>
					<td>${ingredient.product.name}</td>
					<td>${ingredient.quantity}</td>
					<td>
						<a href="<c:url value="/ingredient/delete/${ingredient.product.id}" />">
							<img src="<c:url value="/images/delete.png" />">
						</a>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</div>
