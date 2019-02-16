<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<fmt:parseDate value="${e.dataEntrega}"pattern="yyyy-MM-dd" var="parsedDateTime" type="both"/>
	<fmt:formatDate pattern="dd-MM-yyyy" value="${parsedDateTime}" />

</body>
</html>