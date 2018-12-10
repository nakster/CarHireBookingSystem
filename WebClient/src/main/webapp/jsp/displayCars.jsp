<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<link href="/css/styles.css" rel="stylesheet" />
<meta charset="ISO-8859-1">
<title>Display Cars</title>
</head>
<body>
	<h1>Orders Made</h1>
	<table>
		<tr>
			<th>Car ID</th>
			<th>carColour</th>
			<th>carBrand</th>
			<th>carModel</th>
			<th>purchaseDate</th>
		</tr>
		<!-- the names are methods without the capital orderID and not the variable names-->
		<!-- CarID | CarColour | CarBrand       | CarModel | PurchaseDate -->
		<c:forEach items="${orders}" var="order">
			<tr>
				<td>${order.carID}</td>
				<td>${order.carColour}</td>
				<td>${order.carBrand}</td>
				<td>${order.carModel}</td>
				<td>${order.purchaseDate}</td>
			</tr>
		</c:forEach>
	</table>
	<br>
	<a href="/index.html">Home</a>
</body>
</html>