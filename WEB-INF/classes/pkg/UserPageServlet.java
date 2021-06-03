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
		
		if(request.getParameter("NewTicket") != null)
		{
			//check the DB if the ticket exists
			System.out.println("1");
			//if the ticket ticket exist save it on the db
			if(!DBhandler.findTicketByTitle(request.getParameter("Title")))
			{
				System.out.println("2");
				TicketBean ticket = new TicketBean();
				ticket.setUser(request.getParameter("userAssigned"));
				ticket.setKeyword(request.getParameter("Keywords"));
				ticket.setStatus("New");
				ticket.setTitle(request.getParameter("Title"));
				ticket.setOpened(request.getParameter("Opened"));
				ticket.setCategory(request.getParameter("Category"));
				ticket.setDescription(request.getParameter("Description"));

				//Save it in the db 
				if(DBhandler.saveTicket(ticket))
				{
					response.sendRedirect("UserPage.jsp");
				}
				
			}
			//redirect to mainpage/registrationForm with userName in use error
			else
			{
				System.out.println("3");
				request.getSession().setAttribute("displayRequestMainPage", "CreateTicketForm");
				response.sendRedirect("UserPage.jsp");
			}
		}

		else 
		{

			System.out.println("4");
		}

	}
}