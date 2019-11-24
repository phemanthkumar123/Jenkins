<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Owner Registration Page</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<!-- <link rel="stylesheet" href="/resources/demos/style.css"> -->
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<script src="https://cdn.jsdelivr.net/jquery.validation/1.15.1/jquery.validate.min.js"></script>
<!-- <script src="/WEB-INF/views/js/register-owner.js"></script> -->
<script src="js/register-owner.js"></script>

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
.error {
  color: orange;
}
</style>
<script type="text/javascript">
$(function(){
	$('#ssn1,#ssn2,#ssn3').keyup(function(e){
		if($(this).val().length==$(this).attr('maxlength'))
			$(this).next(':input').focus()
	})
})
</script>
</head>
<body>
	<h2 align="center">
		Please provide your details
	</h2>
		<form:form action="saveOwner" method="post" modelAttribute="owner" name="register-owner-form">
			<table>
			    <form:hidden path="id"/>
			    <form:hidden path="createdDate"/>
			    <form:hidden path="updatedDate"/>
				<tr>
					<td>SSN </td>
					<td>
						<form:input path="ssn_1" id="ssn1" size="3" maxlength="3"/>
						<form:input path="ssn_2" id="ssn2" size="2" maxlength="2"/>
						<form:input path="ssn_3" id="ssn3" size="4" maxlength="4"/>
					</td>
				</tr>
				<tr>
					<td>First Name </td>
					<td><form:input path="firstName" /></td>
				</tr>
				<tr>
					<td>Last Name </td>
					<td><form:input path="lastName" /></td>
				</tr>
				<tr>
					<td>Gender </td>
					<td>
						Male <form:radiobutton path="gender" value="male"></form:radiobutton>
						Female <form:radiobutton path="gender" value="female" checked="checked"></form:radiobutton>
					</td>
				</tr>
				<tr>
					<td>Email </td>
					<td><form:input path="email" /></td>
				</tr>
				<tr>
					<td>DOB </td>
					<td><form:input path="dob" id="datepicker" autocomplete="off"/></td>
				</tr>
				<tr>
					<td>Phone Number </td>
					<td><form:input path="phoneNumber" /></td>
				</tr>
				<tr>
				<td></td>
					<td colspan="1" align="right"><input type="submit" value="Next"></td>
				</tr>
			</table>
		</form:form>
</body>
</html>