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

			/*
			if(request.getParameter("NavBar").equals("CreateTicket"))
			{
				System.out.println(request.getParameter("NavBar"));
				request.getSession().setAttribute("displayRequestUserPage", request.getParameter("CreateTicket"));
				response.sendRedirect("UserPage.jsp");
			}

			//ViewTickets Request
			if(request.getParameter("NavBar").equals("ViewTickets"))
			{
				System.out.println(request.getParameter("NavBar"));
				request.getSession().setAttribute("displayRequestUserPage", request.getParameter("ViewTickets"));
				response.sendRedirect("UserPage.jsp");
			}

			//Knowledge Base Request
			if(request.getParameter("NavBar").equals("KnowledgeBase"))
			{
				System.out.println(request.getParameter("NavBar"));
				request.getSession().setAttribute("displayRequestUserPage", request.getParameter("KnowledgeBase"));
				response.sendRedirect("UserPage.jsp");
			}

			//AccountSettings Request
			if(request.getParameter("NavBar").equals("AccountSettings"))
			{
				System.out.println(request.getParameter("NavBar"));
				request.getSession().setAttribute("displayRequestUserPage", request.getParameter("AccountSettings"));
				response.sendRedirect("UserPage.jsp");	
			}
			*/

		}

	}

	//handles the Login and Register forms on mainMenu
	public void doPost(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException 
	{
		
	}
}