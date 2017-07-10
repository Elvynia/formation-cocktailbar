<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<c:url value="/account/edit" var="postUrl" />
<form:form modelAttribute="account" action="${postUrl}" method="post">
	<form:hidden path="id" />
	<div class="form-group">
		<label for="username">Nom d'utilisateur :</label>
		<form:input id="username" path="username" />
	</div>
	<div class="form-group">
		<label for="price">Mot de passe :</label>
		<form:input type="password" id="password" path="password" />
	</div>
	<div>
		<label for="enabled">Actif :</label>
		<form:checkbox id="enabled" path="enabled" />
	</div>
	<button class="btn btn-info">Valider</button>
</form:form>
