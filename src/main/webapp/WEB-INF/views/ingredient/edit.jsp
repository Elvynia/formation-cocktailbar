<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<jsp:include page="../header.jsp" />
<body>
	<c:url value="/images" var="imgUrlPrefix" />
	<c:url value="/ingredient/edit" var="urlPrefix" />
	<div class="container">
		<h1>Configurer les ingrédients :</h1>
		<table id="ingredientTable">
			<thead>
				<tr>
					<th>Nom</th>
					<th>Quantité</th>
					<th>Actions</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${ingredientList}" var="ingredient">
					<tr>
						<td>${ingredient.product.name}</td>
						<td>${ingredient.quantity}</td>
						<td><a href="${urlPrefix}/remove.html?productId=${ingredient.product.id}"> <img
								src="${imgUrlPrefix}/delete.png">
						</a></td>
					</tr>
				</c:forEach>
			</tbody>
			<tfoot>
				<tr>
					<td colspan="3">
						<form action="${urlPrefix}/add.html" method="get" class="form-inline">
							<div class="form-group">
								<label for="ingredientSelect">Ingrédient :</label> <select
									name="productId" id="ingredientSelect">
									<c:forEach items="${productList}" var="product">
										<option value="${product.id}">${product.name}</option>
									</c:forEach>
								</select>
							</div>
							<div class="form-group">
								<label for="quantity">Quantité : </label> <input type="number"
									id="quantity" name="quantity" value="0">
							</div>
							<button>Ajouter</button>
						</form>
					</td>
				</tr>
			</tfoot>
		</table>
		<button onclick="window.location='${urlPrefix}/validate.html'">Valider</button>
	</div>
	<jsp:include page="../footer.jsp" />
	<script type="text/javascript">
		$("#ingredientTable").DataTable();
		$("#ingredientSelect").selectmenu();
	</script>
</body>
</html>