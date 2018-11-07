<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>SQL Processor!</title>
</head>
<body>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	<c:if test="${sqlStatement == null}">
		<c:set var="sqlStatement" value="" />
	</c:if>
	<h1>The SQL Processor</h1>
	<p>
		Enter an SQL statement and click the Execute button. Then, information about the 
		<br> statement will appear at the bottom of this page.
	</p>
	<p>
		<b>SQL statement:</b><br>
	</p>
	<form action="SqlProcessingServlet" method="post">
		<textarea name="sqlStatement" cols="60" rows="8">${sqlStatement}</textarea>
		<br> <br> <input type="submit" value="Execute">
	</form>
	<p>
		<b>SQL result:</b><br> ${sqlResult}
	</p>
</body>
</html>