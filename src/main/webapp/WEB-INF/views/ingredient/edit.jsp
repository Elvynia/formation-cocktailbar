<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<jsp:include page="../header.jsp" />
</head>
<body>
	<div class="container">
		<h2>Recette du cocktail ${cocktail.name}</h2>
		<table id="ingredientTable" class="table table-striped">
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
			<tfoot>
				<tr>
					<td colspan="3">
						<form action="<c:url value="/ingredient/add" />" method="post" class="form-inline">
							<div class="form-group">
								<label for="product">Produit :</label>
								<select id="product" name="productId" class="form-control">
									<c:forEach items="${productList}" var="product">
										<option value="${product.id}">${product.name}</option>
									</c:forEach>
								</select>
							</div>
							<div class="form-group">
								<label for="quantity">Quantité :</label>
								<input type="number" min="0" id="quantity" name="quantity" class="form-control">
							</div>
							<button>Ajouter</button>
						</form>
					</td>
				</tr>
			</tfoot>
		</table>
	</div>
	<jsp:include page="../footer.jsp" />
</body>
</html>