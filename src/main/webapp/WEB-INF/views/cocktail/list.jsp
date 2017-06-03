<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<jsp:include page="../header.jsp" />
<body>
	<div class="container">
		<h1>Liste des cocktails :</h1>
		<table id="cocktailTable" class="stripe selectable">
			<thead>
				<tr>
					<th>Id</th>
					<th>Nom</th>
					<th>Avec alcool</th>
					<th>Prix</th>
					<th>Actions</th>
				</tr>
			</thead>
			<tbody>
				<c:url value="/images" var="imgUrlPrefix" />
				<c:url value="/cocktail/edit" var="editUrlPrefix" />
				<c:url value="/cocktail/delete.html" var="deleteUrlPrefix" />
				<c:url value="/ingredient/" var="ingredientUrl" />
				<c:forEach items="${cocktailList}" var="cocktail">
					<tr id="cocktail_${cocktail.id}">
						<td>${cocktail.id}</td>
						<td>${cocktail.name}</td>
						<td>${cocktail.withAlcohol}</td>
						<td>${cocktail.price}€</td>
						<td>
							<a href="${editUrlPrefix}/${cocktail.id}.html">
								<img src="${imgUrlPrefix}/edit.png">
							</a>
							<sec:authorize access="hasRole('ROLE_ADMIN')">
								<a href="${ingredientUrl}/edit.html?cocktailId=${cocktail.id}">
									<img src="${imgUrlPrefix}/configure.png">
								</a>
							</sec:authorize>
							<a href="${deleteUrlPrefix}?id=${cocktail.id}">
								<img src="${imgUrlPrefix}/delete.png">
							</a>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<div id="ingredientDialog"></div>
	</div>
	<jsp:include page="../footer.jsp" />
	<script type="text/javascript">
		$("#cocktailTable").DataTable();
		$('#cocktailTable tbody tr').each(
			(index, line) => $(line).click(
				(event) => {
					var cocktailId = event.currentTarget.id.split('_')[1];
					$("#ingredientDialog").load('${ingredientUrl}?cocktailId=' + cocktailId);
					$("#ingredientDialog").dialog({
						width: '60%',
						maxWidth: 800
					});
				}));
	</script>
</body>
</html>