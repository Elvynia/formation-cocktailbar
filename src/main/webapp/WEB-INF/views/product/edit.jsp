<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<jsp:include page="../header.jsp" />
<body>
	<div class="container">
		<h1>Créer un nouveau produit :</h1>
		<form action="#" method="post">
			<div class="form-group">
				<label for="name">Nom :</label>
				<input class="form-control" id="name" name="name">
			</div>
			<div class="form-group">
				<label for="stock">Stock :</label>
				<input type="number" class="form-control" id="stock" name="stock">
			</div>
			<button>Valider</button>
		</form>
		<jsp:include page="../footer.jsp" />
	</div>
</body>
</html>