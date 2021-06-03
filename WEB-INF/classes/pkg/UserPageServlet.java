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
		
	}
}