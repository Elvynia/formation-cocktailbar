<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
	<jsp:include page="../header.jsp" />
</head>
<body>
	<div class="container">
		<h2>Liste des produits :</h2>
		<table id="productTable" class="table table-striped">
			<thead>
				<tr>
					<th>Id</th>
					<th>Nom</th>
					<th>Stock</th>
					<th>Actions</th>
				</tr>
			</thead>
			<tbody>
				<c:url value="/images" var="imgUrl" />
				<c:forEach items="${productList}" var="product">
					<tr>
						<td>${product.id}</td>
						<td>${product.name}</td>
						<td>${product.stock}</td>
						<td>
							<a href="<c:url value="/product/delete?id=${product.id}" />">
								<img src="${imgUrl}/delete.png">
							</a>
							<a href="<c:url value="/product/edit?id=${product.id}" />">
								<img src="${imgUrl}/edit.png">
							</a>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<c:if test="${not empty message}">
			<div class="alert alert-dismissible fade ${ error ? 'alert-danger' : 'alert-success'}" role="alert">
				<button type="button" class="close" data-dismiss="alert" aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
				${message}
			</div>
		</c:if>
	</div>
	<jsp:include page="../footer.jsp" />
	<script type="text/javascript">
		$('.fade').addClass('in');
	</script>
</body>
</html>