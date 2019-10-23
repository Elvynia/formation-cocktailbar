<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<table id="ingredientTable">
	<thead>
		<tr>
			<th>Nom</th>
			<th>Quantité</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${ingredientList}" var="ingredient">
			<tr>
				<td>${ingredient.product.name}</td>
				<td>${ingredient.quantity}</td>
			</tr>
		</c:forEach>
	</tbody>
</table>
<script type="text/javascript">
	$("#ingredientTable").DataTable();
</script>
</html>