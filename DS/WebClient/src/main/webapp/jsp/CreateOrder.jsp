<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Create</title>
</head>
<body>
	<h1>Create Here</h1>
	<form:form modelAttribute="order">
		<table>
<!-- the path has to be the same name as in the model -->
	
			<tr>
				<td>Select One of the customers:</td>
				<td><form:select path="customer.custID" items="${custList}" /></td>
				<td><form:errors path="customer.custID" items="${custList}" /></td>
			</tr>
			<tr>
				<td>Select a Car Brand and Model:</td>
				<td><form:select path="car.carID" items="${carList}" /></td>
				<td><form:errors path="car.carID" items="${carList}" /></td>
			</tr>
			<tr>
				<td>Current Date:</td>
				<td><form:select path="d" items="${date}" /></td>
				<td><form:errors path="d" items="${date}" /></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="Create Order" /></td>
			</tr>
		</table>
	
	</form:form>

</body>
</html>