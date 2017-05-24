<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Application CocktailBar</title>
</head>
<body>
	<h1>Liste des produits :</h1>
	<table>
		<thead>
			<tr>
				<th>Id</th>
				<th>Nom</th>
				<th>Stock</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${productList}" var="product">
				<tr>
					<td>${product.id}</td>
					<td>${product.name}</td>
					<td>${product.stock}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>