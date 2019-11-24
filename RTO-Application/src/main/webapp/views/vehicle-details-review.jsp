<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
body {
	background-color: teal;
	Color: aqua;
	margin: 0;
	padding: 0;
}
h2 {
	color: orange;
	text-align: center;
	font-family: "SIMPSON";
}
h3 {
	color: aqua;
	text-align: center;
	font-family: "SIMPSON";
}
a {
        width: 150px;
        display: block;    
        margin-left: auto;
        margin-right: auto;
        color: orange;
        font-size: 30px
    }
th{
	padding: 10px;
	padding-right: 10px;
}

</style>
</head>
<body>
	<%-- <h3>Address Id is : ${addressId}</h3>
	<h3>owner id is : ${vehicleOwnerId}</h3> --%>
	<table align="center">
		<tr>
			<th><h2><u>Owner Details</u></h2></th><th><h2><u>Owner Address Details</u></h2></th><th><h2><u>Owner Vehicles details</u></h2></th>
		</tr>
		<tr>
			<td>
				<h3>${owner.vehicleOwnerId}</h3>
				<h3>${owner.firstName}</h3>
				<h3>${owner.lastName}</h3>
				<h3>${owner.gender}</h3>
				<h3>${owner.email}</h3>
				<h3>${owner.dob}</h3>
				<h3>${owner.phoneNumber}</h3>
				<h3>${owner.ssn}</h3>
			</td>
			<td>
				<h3>${owner.ownerAddress.homeNumber}</h3>
				<h3>${owner.ownerAddress.streetName}</h3>
				<h3>${owner.ownerAddress.city}</h3>
				<h3>${owner.ownerAddress.zipCode}</h3>
			</td>
			<td>
				<c:forEach items="${owner.vehiclesList}" var="vehicle">
					<h3>${vehicle.vehicleDetailsId}</h3>
					<h3>${vehicle.vehicleType}</h3>
					<h3>${vehicle.mfgYear}</h3>
					<h3>${vehicle.vehicleBrand}</h3>
				</c:forEach>
			</td>
		</tr>
	</table>
	<br><br><br>
	<a href="confirmRegistration/${owner.vehicleOwnerId}">Register</a>
</body>
</html>