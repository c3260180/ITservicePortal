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
				request.getSession().setAttribute("TicketList", tickets);
			}

			if(request.getParameter("NavBar").equals("CreateTicket"))
			{
				request.getSession().setAttribute("saveTicketSuccess", null);
			}
			response.sendRedirect("UserPage.jsp");

		}

		if(request.getParameter("ApplyFilters") != null || request.getParameter("SortByStatus") != null)
		{
			if(request.getParameter("ApplyFilters") != null && request.getParameter("ApplyFilters").equals("ApplyFilters"))
			{
				//status filter  
				if(request.getParameter("StatusFilter") != null )
				{
					ArrayList<TicketBean> tmpTickets =  DBhandler.loadTickets();
					ArrayList<TicketBean> filteredTickets = new ArrayList<TicketBean>();
					System.out.println(tmpTickets.get(0));
					if(request.getParameter("StatusFilter").equals("New"))
					{

						for(int i = 0; i < tmpTickets.size(); i++)
						{
							if(tmpTickets.get(i).getStatus().equals("New"))
							{
								filteredTickets.add(tmpTickets.get(i));
							}
							
						}
						request.getSession().setAttribute("TicketList", filteredTickets);
						response.sendRedirect("UserPage.jsp");
					}

					if(request.getParameter("StatusFilter").equals("InProgress"))
					{

						
						for(int i = 0; i < tmpTickets.size(); i++)
						{
							if(tmpTickets.get(i).getStatus().equals("InProgress"))
							{
								filteredTickets.add(tmpTickets.get(i));
							}
							
						}
						request.getSession().setAttribute("TicketList", filteredTickets);
						response.sendRedirect("UserPage.jsp");
					}

					if(request.getParameter("StatusFilter").equals("Completed"))
					{
						for(int i = 0; i < tmpTickets.size(); i++)
						{
							if(tmpTickets.get(i).getStatus().equals("InProgress"))
							{
								filteredTickets.add(tmpTickets.get(i));
							}
							
						}
						request.getSession().setAttribute("TicketList", filteredTickets);
						response.sendRedirect("UserPage.jsp");
					}

					if(request.getParameter("StatusFilter").equals("Resolved"))
					{
						for(int i = 0; i < tmpTickets.size(); i++)
						{
							if(tmpTickets.get(i).getStatus().equals("InProgress"))
							{
								filteredTickets.add(tmpTickets.get(i));
							}
							
						}
						request.getSession().setAttribute("TicketList", filteredTickets);
						response.sendRedirect("UserPage.jsp");
					}
				}
				//keyword search
				if(request.getParameter("ApplyFilters") != null && request.getParameter("ApplyFilters").equals("ApplyFilters"))
				{

				}
				//category filter
				if(request.getParameter("ApplyFilters") != null && request.getParameter("ApplyFilters").equals("ApplyFilters"))
				{

				}
			}

			if(request.getParameter("SortByStatus") != null)
			{
				
			}
		}

		if(request.getParameter("ViewTicket") != null && request.getParameter("ViewTicket").equals("ViewTicket"))
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