<%@page import="pkg.UserBean" %>
<%@page import="pkg.TicketBean" %>
<%@page import="pkg.KnowledgeBaseBean" %>
<%@page import="java.util.ArrayList" %>
<%@page import="java.util.Date" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
	<title>IT Services App</title>
	<link href='ITServicesStyleSheet.css' rel='stylesheet' type='text/css'>
	<script type='text/javascript' src="validationScripts.js"></script>
</head>
<body>

<h1> IT Services App </h1>
<% UserBean user = (UserBean) session.getAttribute("User");
Date date = new Date();

 %>

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
<br>
</div>

<% if(session.getAttribute("displayRequestUserPage") != null && session.getAttribute("displayRequestUserPage").equals("CreateTicket")) { %>
<div id="CreateTicketView">
	<h2>Create Ticket</h2>
	<table>
		<form  method="POST" id="CreateTicketForm" action="UserPageServlet">
		<input type="hidden" name="NewTicket" id="NewTicket" required='required' value="NewTicket">
		<input type="hidden" name="userAssigned" id="userAssigned" required='required' value="<%=user.getUserName()%>">
		<input type="hidden" name="CreationTime" id="CreationTime" required='required' value="<%=date.toString()%>">
		<tr> <td>Title</td> <td> <input type="text" name="Title" id="Title" required='required' value=""> </td> </tr>

		<tr> <td>Category</td> <td> 
		Network:<input type="radio" name="Category" value="Network"> 
		Software:<input type="radio" name="Category" value="Software"> 
		Hardware:<input type="radio" name="Category" value="Hardware"> 
		Email:<input type="radio" name="Category" value="Email">
		Account:<input type="radio" name="Category" value="Account"> 	
		</td> </tr>

		<tr> <td>Keywords</td> <td> <input type="text" name="Keywords" id="Keywords"  value=""> </td> </tr>
		<tr> <td>Description</td> <td> <textarea name="Description" id="Description" required='required' form="CreateTicketForm" > Please provide a description of the problem here...</textarea> </td> </tr>

		<tr>
		<td></td>
		<td> <input type="submit" name="Create Ticket" id="CreateTicket" value="Create Ticket"> <input type='reset' value='Clear' /> </td> </tr>
	</form>
	</table>
<% if(session.getAttribute("saveTicketSuccess") != null && session.getAttribute("saveTicketSuccess").equals("True"))
	{ %>
	<p>Ticket Was Created!</p>
<% } %>

<% if(session.getAttribute("saveTicketSuccess") != null && session.getAttribute("saveTicketSuccess").equals("False"))
	{ %>
	<p>Ticket Creation Error</p>
<% } %>
</div>
<% } %>

<% if(session.getAttribute("displayRequestUserPage") != null && session.getAttribute("displayRequestUserPage").equals("ViewTickets") && session.getAttribute("displayRequestUserPage") != null) { %>
<div id="ViewTicketsView">
	<h2>View Tickets</h2>
<% ArrayList<TicketBean> tickets = (ArrayList<TicketBean>) session.getAttribute("TicketList"); %>
<table>
	<tr>
	<th>Sort by Status </th>
	<th>Status Filter</th>
	<th>Keyword Search</th>
	<th>Category Filter</th>
	</tr>

	<tr>
		<form method="GET" id="SortByStatus" action="UserPageServlet">
		<td>
		<input type="submit" name="SortByStatus" value="Sort">
		</form>
		</td>
		<form  method="GET" id="ViewTicketsForm" action="UserPageServlet">
		<td> 
		New:<input type="radio" name="StatusFilter" value="New"> 
		In Progress:<input type="radio" name="StatusFilter" value="InProgress"> 
		Completed:<input type="radio" name="StatusFilter" value="Completed"> 
		Resolved:<input type="radio" name="StatusFilter" value="Resolved"> <br> 	
		</td>
		<td><input type="text" name="KeywordsSearch" id="KeywordsSearch"  value=""></td>
		<td> 
		Network:<input type="checkbox" name="CategoryFilter"  value="Network"> 
		Software:<input type="checkbox" name="CategoryFilter" value="Software"> 
		Hardware:<input type="checkbox" name="CategoryFilter" value="Hardware"> 
		Email:<input type="checkbox" name="CategoryFilter"  value="Email"> <br>
		Account:<input type="checkbox" name="CategoryFilter" value="Account"> 	
		</td>
	</tr>
<tr><input type="submit" name="ApplyFilters" id="ApplyFilters" value="ApplyFilters"/> <input type='reset' value='Clear' /></tr>
</form>
</table>
<br>
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
<% for(int i = 0; i < tickets.size(); i++ )
{ %>
<tr>
	<td><%= tickets.get(i).getTitle()%></td>
	<td><%= tickets.get(i).getStatus()%></td>
	<td><%= tickets.get(i).getCategory()%></td>
	<td><%= tickets.get(i).getOpened() %></td>
	<td><%= tickets.get(i).getKeyword()%></td>
	<td><%= tickets.get(i).getDescription()%></td>
	<form method="GET"  action="UserPageServlet">
	<td><input type="hidden" name="TicketToOpen" value="<%= i%>">
		<input type="submit" name="ViewTicket" value="ViewTicket"></td>
	</form>
</tr>

<% } %>
</table>
</div>
<% } %>

<% if(session.getAttribute("displayRequestUserPage") != null && session.getAttribute("displayRequestUserPage").equals("KnowledgeBase")) { %>
<div id="ViewknowledgeBaseView">
	<h2>Knowledge Base</h2>
	<% ArrayList<TicketBean> tickets = (ArrayList<TicketBean>) session.getAttribute("TicketList"); %>
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

	<% for(int i = 0; i < tickets.size(); i++ )
	{ %>
	<tr>
		<td><%= tickets.get(i).getTitle()%></td>
		<td><%= tickets.get(i).getCategory()%></td>
		<td><%= tickets.get(i).getOpened() %></td>
		<td>-------------</td>
		<td><%= tickets.get(i).getKeyword()%></td>
		<td><%= tickets.get(i).getDescription()%></td>
		<td>-------------</td>
		<form method="GET"  action="UserPageServlet">
		<td><input type="hidden" name="TicketToOpen" value="<%= i%>">
		<input type="submit" name="ViewTicket" value="View Item"></td>
	</form>
	</tr>
	
	<% } %>
</table>
</div>
<% } %> 
<% if(session.getAttribute("displayRequestUserPage") != null && session.getAttribute("displayRequestUserPage").equals("ViewTicket")){ %>
<div id="ViewTicketView">
<% TicketBean ticket = (TicketBean) session.getAttribute("TicketToView"); %>
<h2>View Ticket</h2>
	<table>
		<form  method="POST" id="EditTicketForm" action="UserPageServlet">
		<tr> <td>Title</td> <td> <%= ticket.getTitle()%> </td> </tr>

		<tr> 
			<td>Category</td> 
			 <td> <%= ticket.getCategory()%></td> 
		</tr>

		<tr> <td>Keywords</td> <td>  <%= ticket.getKeyword()%> </td> </tr>

		<tr> <td>Description</td> <td>  <%= ticket.getDescription()%></td> </tr>

		<tr> <td>Status</td> <td>  <%= ticket.getStatus()%></td> </tr>

		<tr> <td>Keywords</td> <td>  <%= ticket.getKeyword()%></td> </tr>

		<tr> <td>Creation Time</td> <td>  <%= ticket.getOpened()%></td> </tr>

		<tr> <td>Comments</td> <td> No Comment Field yet</td> </tr>

		<tr> <td>Created By: </td> <td>  <%= ticket.getUser()%></td> </tr>

		<tr> <td>New Comment</td> <td> <textarea name="Description" id="Description" required='required' form="EditTicketForm" > Please provide a description of the problem here...</textarea></td> </tr>

		<tr>
		<td></td>
		<td> <input type="submit" name="Create Ticket" id="CreateTicket" value="Add Comment"> <input type='reset' value='Clear' /> </td> </tr>
	</form>
	</table>
</div>






<% } %>

<% if(session.getAttribute("displayRequestUserPage") != null && session.getAttribute("displayRequestUserPage").equals("ViewArticle")) { %>
<div id="ViewArticleView">

</div>

<% }  %>



</body>
</html>