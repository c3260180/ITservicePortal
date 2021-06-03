<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="pkg.UserBean" %>
<!DOCTYPE html>
<html>
<head>
	<title>IT Services App</title>
	<link href='ITServicesStyleSheet.css' rel='stylesheet' type='text/css'>
</head>
<body>


<h1> IT Services App </h1>

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
	<form  method="POST" action="LoginRegisterServlet">
		UserName: <input type="text" name="UserName" id="UserName" required='required' value="">
		Password: <input type="password" name="Password" id="Password" required='required' value=""> <br>
		<input type="submit" name="Login" id="Login" value="Login">
	
		<input type='reset' value='Clear' />
		
	</form>

	<form method="GET" id="Login/Register" action="LoginRegisterServlet">
	<input type="submit" name="Login/Register" value="Register">
	</form>
	<% if(session.getAttribute("LoginError") != null && session.getAttribute("LoginError").equals("True")) { %>
	<p>Login Error</p>
	<%	} %>

<% } %>

<% if(session.getAttribute("displayRequestMainPage").equals("Register")) { %>
<h2> Register </h2>
<table>
	<form  method="POST" id="Register" action="LoginRegisterServlet">
	<input type="hidden" name="Registration" id="Registration" required='required' value="Registration">
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
		<td> <input type="text" name="FirstName" id="FirstName" required='required' value=""> </td>
	</tr>
	<tr>
		<td> Last Name: </td>
		<td> <input type="text" name="LastName" id="LastName" required='required' value=""> </td>
	</tr>
	<tr>
		<td> Email: </td>
		<td> <input type="text" name="Email" id="Email" required='required' value=""> </td>
	</tr>
	<tr>
		<td> Contact Number: </td>
		<td> <input type="text" name="ContactNumber" id="ContactNumber" required='required' value=""> </td>
	</tr>
	<tr>
		<td> Role: </td>
		<td> Admin: <input type="radio" name="Role" required='required' value="Admin"> User: <input type="radio" name="Role" required='required' value="User"> </td>
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

<% if(session.getAttribute("userNameTakenError") != null && session.getAttribute("userNameTakenError").equals("True")){ %>
<p>User Name already in use!</p>
<% } 
} 
} %>



</body>
</html>