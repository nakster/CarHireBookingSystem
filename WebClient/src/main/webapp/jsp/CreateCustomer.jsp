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
				<td>customer FirstName:</td>
				<td><form:input path="customer.firstName" items="${orders}" /></td>
			</tr>
			<tr>
				<td>customer Lastname:</td>
				<td><form:input path="customer.lastName" items="${orders}" /></td>
			</tr>
				<td>customer Mobile:</td>
				<td><form:input path="customer.mobile" items="${orders}" /></td>
			</tr>
				<td>customer Country:</td>
				<td><form:input path="customer.country" items="${orders}" /></td>
			</tr>
				<td>customer Email:</td>
				<td><form:input path="customer.email" items="${orders}" /></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="Create Customer" /></td>
			</tr>
		</table>
	
	</form:form>

</body>
</html>