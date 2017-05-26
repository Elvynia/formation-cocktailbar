<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<jsp:include page="../header.jsp" />
<body>
	<div class="container">
		<h1>Liste des cocktails :</h1>
		<table id="cocktailTable">
			<thead>
				<tr>
					<th>Id</th>
					<th>Nom</th>
					<th>Avec alcool</th>
					<th>Prix</th>
				</tr>
			</thead>
			<tbody>
				<c:url value="/images" var="imgUrlPrefix" />
				<c:url value="/cocktail/edit" var="editUrlPrefix" />
				<c:url value="/cocktail/delete.html" var="deleteUrlPrefix" />
				<c:forEach items="${cocktailList}" var="cocktail">
					<tr>
						<td>${cocktail.id}</td>
						<td>${cocktail.name}</td>
						<td>${cocktail.withAlcohol}</td>
						<td>${cocktail.price}€</td>
						<td>
							<a href="${editUrlPrefix}/${cocktail.id}.html">
								<img src="${imgUrlPrefix}/edit.png">
							</a>
							<a href="${deleteUrlPrefix}?id=${cocktail.id}">
								<img src="${imgUrlPrefix}/delete.png">
							</a>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<jsp:include page="../footer.jsp" />
	</div>
	<script type="text/javascript">
		$("#cocktailTable").DataTable();
	</script>
</body>
</html>