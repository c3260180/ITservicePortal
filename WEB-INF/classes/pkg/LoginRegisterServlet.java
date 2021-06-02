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
		if(request.getParameter("Registration") != null)
		{
			System.out.println(request.getParameter("UserName"));
			System.out.println(request.getParameter("Password"));
			System.out.println(request.getParameter("FirstName"));
			System.out.println(request.getParameter("LastName"));
			System.out.println(request.getParameter("Email"));
			System.out.println(request.getParameter("ContactNumber"));
			System.out.println(request.getParameter("Role"));


			//check the DB if this user name exists 

			//if we can register this name save it in the db 

			//if save was successful login this account

			//redirect to userAccountPage if it works 

			//
		}
	}
}