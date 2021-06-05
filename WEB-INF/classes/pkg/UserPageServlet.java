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

			if(request.getParameter("NavBar").equals("ViewTickets"))
			{
				ArrayList<TicketBean> tickets = DBhandler.loadTickets();
				System.out.println(tickets.size());
				request.getSession().setAttribute("TicketList", tickets);

			}
			
			if(request.getParameter("NavBar").equals("CreateTicket"))
			{
				request.getSession().setAttribute("saveTicketSuccess", null);
			}

			response.sendRedirect("UserPage.jsp");

			/*if(request.getParameter("NavBar").equals("KnowledgeBase"))
			{
				ArrayList<KnowledgeBaseBean> items = DBhandler.loadKbItems();
				System.out.println(items.size());
				request.getSession().setAttribute("KbList", items);
			}*/

		}

		if(request.getParameter("ApplyFilters") != null || request.getParameter("SortByStatus") != null)
		{
			System.out.println("122222");
		}

		if(request.getParameter("ViewTicket") != null )
		{
			System.out.println(request.getParameter("TicketToOpen"));
			ArrayList<TicketBean> tickets = DBhandler.loadTickets();
			int i = Integer.parseInt(request.getParameter("TicketToOpen"));
			TicketBean tmpTicket = tickets.get(i);
			request.getSession().setAttribute("TicketToView", tmpTicket);
			request.getSession().setAttribute("displayRequestUserPage", "ViewTicket");
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
				TicketBean ticket = new TicketBean();
				ticket.setUser(request.getParameter("userAssigned"));
				ticket.setKeyword(request.getParameter("Keywords"));
				ticket.setStatus("New");
				ticket.setTitle(request.getParameter("Title"));
				ticket.setOpened(request.getParameter("CreationTime"));
				ticket.setCategory(request.getParameter("Category"));
				ticket.setDescription(request.getParameter("Description"));

				//Save it in the db 
				if(DBhandler.saveTicket(ticket))
				{
					request.getSession().setAttribute("displayRequestMainPage", "CreateTicketForm");
					request.getSession().setAttribute("saveTicketSuccess", "True");
					response.sendRedirect("UserPage.jsp");
				}
				
			}

			else
			{
				request.getSession().setAttribute("displayRequestMainPage", "CreateTicketForm");
				request.getSession().setAttribute("saveTicketSuccess", "False");
				response.sendRedirect("UserPage.jsp");
			}
		}
	}
}