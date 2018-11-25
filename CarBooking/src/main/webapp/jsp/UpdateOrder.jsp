<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update Order</title>
</head>
<body>
	<h1>Update Here</h1>
	<form:form modelAttribute="order">
		<table>
			<!-- the path has to be the same name as in the model -->
			<tr>
				<td>Select One of the Orders:</td>
				<td><form:select path="OrderID" items="${orderList}" /></td>
				<td><form:errors path="OrderID" items="${orderList}" /></td>
			</tr>
			<tr>
				<td>Update Their Customer:</td>
				<td><form:select path="cust" items="${custList}" /></td>
				<td><form:errors path="cust" items="${custList}" /></td>
			</tr>
			<tr>
				<td>Update Their Car:</td>
				<td><form:select path="car" items="${carList}" /></td>
				<td><form:errors path="car" items="${carList}" /></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="Update" /></td>
			</tr>
		</table>
	</form:form>
</body>
</html>