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
			<th>Name</th>
			<th>Country</th>
			<th>Car ID</th>
			<th>Car Type</th>
			<th>Car Brand</th>
			<th>Car Colour</th>
			<th>Order Date</th>
		</tr>
		<!-- the names are methods without the capital orderID and not the variable names-->
		<c:forEach items="${orders}" var="order">
			<tr>
				<td>${order.orderID}</td>
				<td>${order.customer.custID}</td>
				<td>${order.customer.firstName} ${order.customer.lastName}</td>
				<td>${order.customer.country}</td>
				<td>${order.car.carID}</td>
				<td>${order.car.carBrand}</td>
				<td>${order.car.carModel}</td>
				<td>${order.car.carColour}</td>
				<td>${order.date}</td>
			</tr>
		</c:forEach>
	</table>
	<br>
	<a href="/index.html">Home</a>
</body>
</html>