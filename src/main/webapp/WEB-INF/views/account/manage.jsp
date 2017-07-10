<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<jsp:include page="../header.jsp" />
</head>
<body>
	<div class="container">
		<h2>Liste des comptes utilisateurs :</h2>
		<jsp:include page="list.jsp" />	
	</div>
	<hr />
	<div class="container">
		<h2>Ajouter ou modifier un compte utilisateur :</h2>
		<jsp:include page="edit.jsp" />
	</div>
	<jsp:include page="../footer.jsp" />	
</body>
</html>