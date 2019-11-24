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
<script src="js/register-vehicle.js"></script>


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
	width: 300px;
	padding: 5px
}
</style>
</head>
<body>
<h3><%-- OwnerId is : ${vehicleOwnerId} --%></h3> 
<h2 align="center">Please provide your vehicle details</h2>
		<form:form action="saveVehicle" method="post" modelAttribute="vehicle" name="register-owner-form">
			<table>
			<form:hidden path="vehicleId"/>
			<form:hidden path="createdDate"/>
			<form:hidden path="updatedDate"/>
				<tr>
					<td>Vehicle Type </td>
					<td><form:select path="vehicleType" items="${vechicleTypes}"/></td>
				</tr> 
				<tr>
					<td>Manufactured Year </td>
					<td><form:input path="mfgYear"/></td>
				</tr>
				<tr>
					<td>Vehicle Brand </td>
					<td><form:input path="vehicleBrand" /></td>
				</tr>
				<tr>
				    <td><a href="showRegisterOwnerPage?vehicleOwnerId=${vehicleOwnerId}">Previous</a></td>
					<td><input type="submit" value="Next"></td>
				</tr>
			</table>
			<input type="hidden" name="vehicleOwnerId" value="${vehicleOwnerId}"/>
		</form:form>
</body>
</html>