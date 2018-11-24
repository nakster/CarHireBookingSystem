<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<!-- This is where the model-attribute is used from the controller -->
	<form:form modelAttribute="order">
		<h1>Add Ship</h1>
		<table>
			<tr>
				<td>Order Id:</td>
				<!-- the path has to be the same name as in the model -->
				<td><form:input path="OrderID"></form:input></td>
				<td><form:errors path="OrderID"></form:errors></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="Delete" /></td>
			</tr>
		</table>
	</form:form>
	<br>
	<a href="/index.html">Home</a>
</body>
</html>