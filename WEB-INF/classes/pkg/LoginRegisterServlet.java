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
		else if(request.getParameter("Logout") != null)
		{
			request.getSession().invalidate();
			response.sendRedirect("MainMenu.jsp");
		}
		else
		{
			request.getSession().setAttribute("displayRequestMainPage", null);
			response.sendRedirect("MainMenu.jsp");
		}

	}

	//handles the Login and Register forms on mainMenu
	public void doPost(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException 
	{
		
		if(request.getParameter("Registration") != null)
		{


			//check the DB if this user name exists 

			//if the user doesnt already exist we can save the registration
			if(!DBhandler.findUserByName(request.getParameter("UserName")))
			{
				UserBean user = new UserBean();
				user.setUserName(request.getParameter("UserName"));
				user.setPassCode(request.getParameter("Password"));
				user.setFirstName(request.getParameter("FirstName"));
				user.setLastName(request.getParameter("LastName"));
				user.setEmail(request.getParameter("Email"));
				user.setContactNumber(request.getParameter("ContactNumber"));
				user.setUserRole(request.getParameter("Role"));
				//if we can register this name save it in the db 
				DBhandler.saveUser(user);
				//if save was successful login this account
				request.getSession().setAttribute("UserName", request.getParameter("UserName"));
				request.getSession().setAttribute("User", user);
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

		if(request.getParameter("Login") != null)
		{
			System.out.println("1");

			//check to see if userName is in the DB 
			if(DBhandler.findUserByName(request.getParameter("UserName")))
			{
				System.out.println("2");
				//check to see if password entered matches password stored in DB
				if(DBhandler.login(request.getParameter("UserName"),request.getParameter("Password")) != null)
				{
					System.out.println("3");
					UserBean user = DBhandler.login(request.getParameter("UserName"),request.getParameter("Password"));
					request.getSession().setAttribute("UserName", request.getParameter("UserName"));
					request.getSession().setAttribute("User", user);
					response.sendRedirect("UserPage.jsp");
					
				}

					else
					{
						request.getSession().setAttribute("LoginError", "True");
						response.sendRedirect("MainMenu.jsp");
					}
			}
			else
			{
				request.getSession().setAttribute("LoginError", "True");
				response.sendRedirect("MainMenu.jsp");
			}

		}
	}
}