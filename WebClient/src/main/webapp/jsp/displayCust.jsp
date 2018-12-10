<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<link href="/css/styles.css" rel="stylesheet" />
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Orders Made</h1>
	<table>
		<tr>
			<th>Customer ID</th>
			<th>FirstName</th>
			<th>LastName</th>
			<th>Mobile</th>
			<th>Country</th>
			<th>Email</th>
		</tr>
		<!-- the names are methods without the capital orderID and not the variable names-->
	<!--CustID | FirstName | LastName | Mobile     | Country | Email  -->
		<c:forEach items="${orders}" var="order">
			<tr>
				<td>${order.customer.custID}</td>
				<td>${order.customer.firstName}</td>
				<td>${order.customer.lastName}</td>
				<td>${order.customer.mobile}</td>
				<td>${order.customer.country}</td>
				<td>${order.customer.email}</td>
			</tr>
		</c:forEach>
	</table>
	<br>
	<a href="/index.html">Home</a>
</body>
</html>