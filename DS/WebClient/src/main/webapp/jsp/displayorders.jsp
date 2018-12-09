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
			<th>Order ID</th>
			<th>Customer ID</th>
			<th>Car ID</th>
			<th>Order Date</th>
		</tr>
		<!-- the names are methods without the capital orderID and not the variable names-->
		<c:forEach items="${orders}" var="order">
			<tr>
				<td>${order.orderID}</td>
				<td>${order.cust}</td>
				<td>${order.car}</td>
				<td>${order.date}</td>
			</tr>
		</c:forEach>
	</table>

	<br>
	<a href="/index.html">Home</a>
</body>
</html>