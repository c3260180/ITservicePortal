<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
	<title>IT Services App</title>
	<link href='ITServicesStyleSheet.css' rel='stylesheet' type='text/css'>
</head>
<body>


<h1> IT Services App </h1>
<a href="UserPage.jsp"> testing: entry point to UserPage</a>

<% if(session.getAttribute("displayRequestMainPage") == null) { %>
<h2> Login/Registration </h2>
<h3> Create New Account or Login </h3>

<form method="GET" id="Login/Register" action="LoginRegisterServlet">
	<input type="submit" name="Login/Register" value="Login">
	<input type="submit" name="Login/Register" value="Register">
</form>

<% } %>

<% if(session.getAttribute("displayRequestMainPage") != null)
{
if(session.getAttribute("displayRequestMainPage").equals("Login")) { %>
<h2> Login </h2>
	<form  method="POST" id="Login" action="LoginRegisterServlet">
		UserName: <input type="text" name="UserName" id="UserName" required='required' value="">
		Password: <input type="password" name="Password" id="Password" required='required' value=""> <br>
		<input type="submit" name="Login" id="Login" value="Login">
	
		<input type='reset' value='Clear' />
		
	</form>

	<form method="GET" id="Login/Register" action="LoginRegisterServlet">
	<input type="submit" name="Login/Register" value="Register">
	</form>

<% } %>

<% if(session.getAttribute("displayRequestMainPage").equals("Register")) { %>
<h2> Register </h2>
<table>
	<form  method="POST" id="Register" action="LoginRegisterServlet">
	<tr>
		<td> Username:</td>
		<td> <input type="text" name="UserName" id="UserName" required='required' value=""> </td>
	</tr>
	<tr>
		<td> Password:</td>
		<td> <input type="password" name="Password" id="Password" required='required' value=""> </td>
	</tr>
	<tr>
		<td> First Name: </td>
		<td> <input type="text" name="First Name" id="First Name" required='required' value=""> </td>
	</tr>
	<tr>
		<td> Last Name: </td>
		<td> <input type="text" name="Last Name" id="Last Name" required='required' value=""> </td>
	</tr>
	<tr>
		<td> Email: </td>
		<td> <input type="text" name="Email" id="Email" required='required' value=""> </td>
	</tr>
	<tr>
		<td> Contact Number: </td>
		<td> <input type="text" name="Contact Number" id="Contact Number" required='required' value=""> </td>
	</tr>
	<tr>
		<td> Role: </td>
		<td> Admin: <input type="radio" name="Role" id="Role" required='required' value="Admin"> User: <input type="radio" name="Role" id="Role" required='required' value="User"> </td>
	</tr>
	<tr>
		<td> <input type="submit" name="Create Account" id="Create Account" value="Create Account"></td>
		<td> <input type='reset' value='Clear' /> </td>
	</tr>
	</form>

</table>

<br><br>
	<form method="GET" id="Login/Register" action="LoginRegisterServlet">
	<input type="submit" name="Login/Register" value="Login">
	</form>
<% } 
}%>



</body>
</html>