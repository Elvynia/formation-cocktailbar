<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<jsp:include page="header.jsp" />
<body>
	<div class="container">
		<h1>Liste des ingrédients :</h1>
		<table id="ingredientsTable" class="table table-hover table-striped">
			<thead>
				<tr>
					<th>Nom</th>
					<th>Etat</th>
					<th />
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${ingredients}" var="ingredient">
					<tr>
						<td>${ingredient.name}</td>
						<td>${ingredient.etat}</td>
						<td><a href="<c:url value='/ingredients/delete/${ingredient.id}.html' />">Supprimer</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	<div class="back">
		<a href="<c:url value='/' />">Retour</a>
	</div>
	<script type="text/javascript">
		$('#ingredientsTable').DataTable({
			pageLength: 5,
			lengthMenu: [5, 10, 15],
			colReorder: true
		});
	</script>
</body>
</html>