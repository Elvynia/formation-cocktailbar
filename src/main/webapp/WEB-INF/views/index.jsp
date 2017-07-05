<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>${title}</title>
</head>
<body>
	<ul>
		<c:url value="/" var="prefixUrl" />
		<c:forEach items="${menu}" var="menuItem">
			<li>
				<a href="${prefixUrl}${menuItem.url}">${menuItem.title}</a>
			</li>
		</c:forEach>
	</ul>
</body>
</html>