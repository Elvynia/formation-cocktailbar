<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<jsp:include page="header.jsp" />
<body>
	<h1>Recherche de cocktails ou ingrédients par nom :</h1>
	<div class="container">
		<form action="<c:url value='/search/name.html'/>">
			<label for="search">Nom contenant :</label> <input id="search"
				name="search">
			<button>Rechercher</button>
		</form>
	</div>
	<hr />
	<div class="container">
		<table id="resultsTable" class="table table-hover table-striped">
			<thead>
				<tr>
					<th>Id</th>
					<th>Nom</th>
					<th>Categorie</th>
					<th />
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${results}" var="result">
					<tr>
						<td>${result.id}</td>
						<td>${result.name}</td>
						<td>${result.getCategory()}</td>
						<td><c:choose>
								<c:when test="${result.getCategory() == 'Cocktail'}">
									<a href="<c:url value='/cocktail/edit/${result.id}.html' />">Modifier</a>
								</c:when>
								<c:otherwise>
									<a href="<c:url value='/ingredient/edit/${result.id}.html' />">Modifier</a>
								</c:otherwise>
							</c:choose></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	<div class="back">
		<a href="<c:url value='/' />">Retour</a>
	</div>
	<script type="text/javascript">
		$('#resultsTable').DataTable({
			pageLength : 5,
			lengthMenu : [ 5, 10, 15 ],
			colReorder : true
		});
	</script>
</body>
</html>