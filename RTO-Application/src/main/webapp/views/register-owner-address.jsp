<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Insert title here</title>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<!-- <link rel="stylesheet" href="/resources/demos/style.css"> -->
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<script src="https://cdn.jsdelivr.net/jquery.validation/1.15.1/jquery.validate.min.js"></script>
<script src="js/register-owner-address.js"></script>
<style type="text/css">
body {
	background-color: teal;
	Color: aqua;
	margin: 0;
	padding: 0;
}

h1 {
	color: #000000;
	text-align: center;
	font-family: "SIMPSON";
}

form {
	width: 300px;
	margin: 0 auto;
}

td {
	width: 150px;
	padding: 5px
}
</style>
</head>
<body>
<%-- <h3>vehicleId is :  ${vehicleId}</h3>
<h3>owner id is : ${vehicleOwnerId}</h3> --%>
<h2 align="center">Please provide your address details</h2>
		<form:form action="saveOwnerAddress" method="post" modelAttribute="address" name="register-owner-address-form">
			<table>
				<tr>
					<td>Home Number </td>
					<td>
						<form:input path="homeNo" />
					</td>
				</tr>
				<tr>
					<td>Street </td>
					<td><form:input path="street" /></td>
				</tr>
				<tr>
					<td>City </td>
					<td><form:input path="city" /></td>
				</tr>
				<tr>
					<td>ZipCode </td>
					<td><form:input path="zipCode" /></td>
				</tr>
				<tr>
				    <td><a href="showRegisterVehiclePage?vehicleId=${vehicleId}&vehicleOwnerId=${vehicleOwnerId}">Previous</a></td>
					<td><input type="submit" value="Next"></td>
				</tr>
			</table>
			<input type="hidden" name="ownerId" value="${vehicleOwnerId}"/>
		</form:form>
</body>
</html>