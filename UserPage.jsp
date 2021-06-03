<%@page import="pkg.UserBean" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
	<title>IT Services App</title>
	<link href='ITServicesStyleSheet.css' rel='stylesheet' type='text/css'>
</head>
<body>

<h1> IT Services App </h1>
<% UserBean user = (UserBean) session.getAttribute("User"); %>

<div id="fixedDisplay">

<p>Logged in as: <%=user.getUserName()%>  		</p>	
<form method="GET" id="LogoutForm" action="LoginRegisterServlet">
	<input type="submit" name="Logout" id="Logout" value="Logout">
</form>


<table >
	<tr>
		<th>Create Ticket</th>
		<th>View Tickets</th>
		<th>Knowledge Base</th>
	</tr>
	<tr>
		<td>
			<form method="GET" id="NavBarCreateTicket" action="UserPageServlet">
			<input type="submit" name="NavBar" value="CreateTicket">
			</form>
		</td>
		<td>
			<form method="GET" id="NavBarViewTickets" action="UserPageServlet">
			<input type="submit" name="NavBar" value="ViewTickets">
			</form>
		</td>
		<td>
			<form method="GET" id="NavBarKnowledgeBase" action="UserPageServlet">
			<input type="submit" name="NavBar" value="KnowledgeBase">
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
		<input type="hidden" name="NewTicket" id="NewTicket" required='required' value="NewTicket">
		<!--<input type="hidden" name="Status" id="Status" required='required' value="New">-->
		<input type="hidden" name="userAssigned" id="userAssigned" required='required' value="<%=user.getUserName()%>">
		<tr> <td>Title</td> <td> <input type="text" name="Title" id="Title" required='required' value=""> </td> </tr>

		<tr> <td>Category</td> <td> 
		Network:<input type="checkbox" name="Category" value="Network"> 
		Software:<input type="checkbox" name="Category" value="Software"> 
		Hardware:<input type="checkbox" name="Category" value="Hardware"> 
		Email:<input type="checkbox" name="Category" value="Email">
		Account:<input type="checkbox" name="Category" value="Account"> 	
		</td> </tr>

		<tr> <td>Keywords</td> <td> <input type="text" name="Keywords" id="Keywords"  value=""> </td> </tr>
		<tr> <td>Description</td> <td> <textarea name="Description" id="Description" required='required' form="CreateTicketForm" > Please provide a description of the problem here...</textarea> </td> </tr>

		<tr>
		<td></td>
		<td> <input type="submit" name="Create Ticket" id="CreateTicket" value="Create Ticket"> <input type='reset' value='Clear' /> </td> </tr>
	</form>
	</table>
</div>
<% } %>

<% if(session.getAttribute("displayRequestUserPage").equals("ViewTickets")) { %>
<div id="ViewTicketsView">
	<h2>View Tickets</h2>

<table>
	<form  method="POST" id="ViewTicketsForm" action="UserPageServlet">
	<tr>
	<th>Filter Status</th>
	<th>Sort by Status</th>
	<th>Keyword Search</th>
	<th>Category Filter</th>
	</tr>

	<tr>
		<td> 
		New:<input type="radio" name="Filter Status" id="FilterStatus" value="Network"> 
		In Progress:<input type="radio" name="Filter Status" id="FilterStatus" value="Software"> 
		Completed:<input type="radio" name="Filter Status" id="FilterStatus" value="Hardware"> 
		Resolved:<input type="radio" name="Filter Status" id="FilterStatus" value="Email"> <br> 	
		</td>
		<td>placeholder</td>
		<td><input type="text" name="KeywordsSearch" id="KeywordsSearch"  value=""></td>
		<td> 
		Network:<input type="checkbox" name="CategoryFilter"  value="Network"> 
		Software:<input type="checkbox" name="CategoryFilter" value="Software"> 
		Hardware:<input type="checkbox" name="CategoryFilter" value="Hardware"> 
		Email:<input type="checkbox" name="CategoryFilter"  value="Email"> <br>
		Account:<input type="checkbox" name="CategoryFilter" value="Account"> 	
		</td>
	</tr>

</table>
<input type="submit" name="Create Ticket" id="ApplyFilters" value="ApplyFilters"> <input type='reset' value='Clear' />
</form>
<table>
	<tr>
	<th>Title</th>
	<th>Status</th>
	<th>Category</th>
	<th>Ticket Creation</th>
	<th>Keywords</th>
	<th>Description</th>
	<th></th>
	</tr>
	
</table>
</div>
<% } %>

<% if(session.getAttribute("displayRequestUserPage").equals("KnowledgeBase")) { %>
<div id="ViewknowledgeBaseView">
	<h2>Knowledge Base</h2>
<table>
	<form  method="POST" id="ViewTicketsForm" action="UserPageServlet">
	<tr>
	<th>Keyword Search</th>
	<th>Category Filter</th>
	</tr>

	<tr>

		<td><input type="text" name="KeywordsSearch" id="KeywordsSearch"  value=""></td>
		<td> 
		Network:<input type="checkbox" name="CategoryFilter"  value="Network"> 
		Software:<input type="checkbox" name="CategoryFilter" value="Software"> 
		Hardware:<input type="checkbox" name="CategoryFilter" value="Hardware"> 
		Email:<input type="checkbox" name="CategoryFilter"  value="Email"> <br>
		Account:<input type="checkbox" name="CategoryFilter" value="Account"> 	
		</td>
	</tr>

</table>
<input type="submit" name="Create Ticket" id="ApplyFilters" value="ApplyFilters"> <input type='reset' value='Clear' />
</form>

<table>
	<tr>
	<th>Title</th>
	<th>Category</th>
	<th>Ticket Creation</th>
	<th>Ticket Completion</th>
	<th>Keywords</th>
	<th>Description</th>
	<th>Resolution</th>
	<th></th>
	</tr>
	
</table>
</div>
<% } %>

<% } %>



</body>
</html>