// Alessandro Pirillo
// c3260180

package pkg;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;
import javax.sql.*;
import java.sql.*;
import java.util.*;


@WebServlet(urlPatterns = {"/UserPageServlet"})
public class UserPageServlet extends HttpServlet 
{   

	// handles the nav bar,
	public void doGet(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException 
	{
		//avoid null pointer exception
		if(request.getParameter("NavBar") != null)
		{
			
			request.getSession().setAttribute("displayRequestUserPage", request.getParameter("NavBar"));
			response.sendRedirect("UserPage.jsp");

		}

	}

	//
	public void doPost(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException 
	{
		
		if(request.getParameter("Registration") != null)
		{
			//check the DB if the ticket exists

			//if the ticket ticket exist save it on the db
			if(!DBhandler.findTicketByTitle(request.getParameter("ticketTitle")))
			{
				TicketBean ticket = new TicketBean();
				ticket.setUser(request.getParameter("userAssigned"));
				ticket.setID(request.getParameter("ticketID"));
				ticket.setKeyword(request.getParameter("ticketKeyword"));
				ticket.setStatus(request.getParameter("ticketStatus"));
				ticket.setTitle(request.getParameter("ticketTitle"));
				ticket.setOpened(request.getParameter("ticketOpened"));
				ticket.setCategory(request.getParameter("ticketCategory"));
				ticket.setDescription(request.getParameter("ticketDescription"));

				//Save it in the db 
				DBhandler.saveTicket(ticket);
				//if save was successful login this account
				request.getSession().setAttribute("UserName", request.getParameter("UserName"));
				request.getSession().setAttribute("Ticket", ticket);
				response.sendRedirect("UserPage.jsp");
			}
			//redirect to mainpage/registrationForm with userName in use error
			else
			{
				request.getSession().setAttribute("displayRequestMainPage", "Register");
				request.getSession().setAttribute("userNameTakenError", "True");
				response.sendRedirect("MainMenu.jsp");
			}
		}
	}
}