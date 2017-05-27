<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!-- Configuration des URL avec Webjars -->
<c:url value="/webjars/bootstrap/3.1.0" var="bootstrapUrl" />
<c:url value="/webjars/jquery/3.1.1-1" var="jqueryUrl" />
<c:url value="/webjars/jquery-ui/1.12.1" var="jqueryuiUrl" />
<c:url value="/webjars/datatables/1.10.12" var="datatablesUrl" />
<c:url value="/webjars/datatables-colreorder/1.2.0" var="datatablesColreorderUrl" />
<c:url value="/css" var="appCssUrl" />
<!-- Bootstrap -->
<link rel="stylesheet" href="${bootstrapUrl}/css/bootstrap.min.css">
<script src="${bootstrapUrl}/js/bootstrap.min.js"></script>
<!-- JQuery -->
<script src="${jqueryUrl}/jquery.min.js"></script>
<!-- JQuery UI -->
<link rel="stylesheet" href="${jqueryuiUrl}/jquery-ui.min.css">
<script src="${jqueryuiUrl}/jquery-ui.min.js"></script>
<!-- Plugin DataTables -->
<link rel="stylesheet" href="${datatablesUrl}/css/jquery.dataTables.min.css">
<script src="${datatablesUrl}/js/jquery.dataTables.min.js"></script>
<!-- Plugin DataTables pour réorganiser les colonnes -->
<link rel="stylesheet" href="${datatablesColreorderUrl}/js/dataTables.colReorder.js">
<script type="text/javascript" src=""></script>
<!-- Application (interne) -->
<link rel="stylesheet" href="${appCssUrl}/application.css">
<title>Application CocktailBar</title>
</head>
<body>
	<div id="header" class="navbar-default navbar-fixed-top">
		<h1>Application CocktailBar !</h1>
	</div>
</body>
</html>