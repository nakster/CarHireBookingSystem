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
				<td>Car Colour:</td>
				<td><form:input path="car.carColour" items="${orders}" /></td>
			</tr>
			<tr>
				<td>Car Brand:</td>
				<td><form:input path="car.carBrand" items="${orders}" /></td>
			</tr>
			<tr>
				<td>Car Model:</td>
				<td><form:input path="car.carModel" items="${orders}" /></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="Create Car" /></td>
			</tr>
		</table>
	
	</form:form>

</body>
</html>