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


@WebServlet(urlPatterns = {"/LoginRegisterServlet"})
public class LoginRegisterServlet extends HttpServlet 
{   

	//handles the Login/Register display option form on mainMenu
	public void doGet(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException 
	{
		//Login/Register display option form handles in this conditional
		if(request.getParameter("Login/Register") != null)
		{
			request.getSession().setAttribute("displayRequestMainPage", request.getParameter("Login/Register"));
			response.sendRedirect("MainMenu.jsp");
		}

	}

	//handles the Login and Register forms on mainMenu
	public void doPost(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException 
	{
		
	}
}