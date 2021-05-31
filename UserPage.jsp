<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
	<title>IT Services App</title>
	<link href='ITServicesStyleSheet.css' rel='stylesheet' type='text/css'>
</head>
<body>


<h1> IT Services App </h1>


<div id="fixedDisplay">

<p>Username displayed here     <button>logout here</button> </p>


<table name="NavBar">
	<tr>
		<th>Create Ticket</th>
		<th>View Tickets</th>
		<th>Knowledge Base</th>
		<th>Account Settings</th>
	</tr>
	<tr>
		<td>
			<form method="GET" id="NavBar" action="UserPageServlet">
			<input type="submit" name="NavBar" value="CreateTicket">
			</form>
		</td>
		<td>
			<form method="GET" id="NavBar" action="UserPageServlet">
			<input type="submit" name="NavBar" value="ViewTickets">
			</form>
		</td>
		<td>
			<form method="GET" id="NavBar" action="UserPageServlet">
			<input type="submit" name="NavBar" value="KnowledgeBase">
			</form>
		</td>
		<td>
			<form method="GET" id="NavBar" action="UserPageServlet">
			<input type="submit" name="NavBar" value="AccountSettings">
			</form>
		</td>
	</tr>
</table>

</div>

<% if(session.getAttribute("displayRequestUserPage") != null) {  %>
<%if(session.getAttribute("displayRequestUserPage").equals("CreateTicket")) { %>
<div id="CreateTicketView">
	<h2>Create Ticket</h2>
	<table>
		<form  method="POST" id="CreateTicketForm" action="UserPageServlet">
		<tr> <td>Title</td> <td> <input type="text" name="Title" id="Title" required='required' value=""> </td> </tr>

		<tr> <td>Category</td> <td> 
		Network:<input type="checkbox" name="Category" id="Category" required='required' value="Network"> 
		Software:<input type="checkbox" name="Category" id="Category" required='required' value="Software"> 
		Hardware:<input type="checkbox" name="Category" id="Category" required='required' value="Hardware"> 
		Email:<input type="checkbox" name="Category" id="Category" required='required' value="Email">
		Account:<input type="checkbox" name="Category" id="Category" required='required' value="Account"> 	
		</td> </tr>

		<tr> <td>Keywords</td> <td> <input type="text" name="Keywords" id="Keywords"  value=""> </td> </tr>
		<tr> <td>Description</td> <td> <textarea name="Description" id="Description" form="CreateTicketForm" > Please provide a description of the problem here...</textarea> </td> </tr>

		<tr>
		<td></td>
		
		<td> <input type="submit" name="Create Account" id="Create Account" value="Create Account"> <input type='reset' value='Clear' /> </td> </tr>
	</form>
	</table>
</div>
<% } %>

<% if(session.getAttribute("displayRequestUserPage").equals("ViewTickets")) { %>
<div id="ViewTicketsView">
	<h2>View Tickets</h2>

</div>
<% } %>

<% if(session.getAttribute("displayRequestUserPage").equals("KnowledgeBase")) { %>
<div id="ViewknowledgeBaseView">
	<h2>KnowledgeBase</h2>

</div>
<% } %>

<% if(session.getAttribute("displayRequestUserPage").equals("AccountSettings")) { %>
<div id="AccountSettingsView">
	<h2>Account Settings</h2>

</div>
<% 
}
} %>



</body>
</html>