<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<jsp:include page="header.jsp" />
<body>
	<h1>Bienvenue dans l'application CocktailBar</h1>
	<div>
		<h2>Menu :</h2>
		<ul>
			<c:forEach items="${menus}" var="menu">
				<c:url value="${menu.url}.html" var="menuUrl" />
				<li><a href="${menuUrl}">${menu.title}</a></li>
			</c:forEach>
		</ul>
	</div>
</body>
</html>