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
	<h1>Create Here</h1>
	<form:form modelAttribute="order">
		<table>
			<!--  	<tr>
				<td>Enter Order Id:</td>
				
				<td><form:input path="OrderID"></form:input></td>
				<td><form:errors path="OrderID"></form:errors></td>
			</tr> 
		-->
			<!-- the path has to be the same name as in the model -->
			<tr>
				<td>Select One of the customers:</td>
				<td><form:select path="cust" items="${custList}" /></td>
				<td><form:errors path="cust" items="${custList}" /></td>
			</tr>
			<tr>
				<td>Select a Car Brand and Model:</td>
				<td><form:select path="car" items="${carList}" /></td>
				<td><form:errors path="car" items="${carList}" /></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="Delete" /></td>
			</tr>
		</table>
	
	</form:form>

</body>
</html>