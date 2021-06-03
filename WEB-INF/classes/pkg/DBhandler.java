package pkg;
import javax.sql.*;
import java.sql.*;
import java.util.*;

public class DBhandler
{   
/*

	public static TicketBean loadTickets()
	{

	}

	public static void saveTickets()
	{

	}

	public static TicketBean loadTicket()
	{

	}

	public static  void saveTicket()
	{

	}

	public static KnowledgeBaseBean loadKnowledgeBase()
	{

	}

	public static void saveKnowledgeBase()
	{
		
	}

	public static KnowledgeBaseBean loadKnowledgeBaseItem()
	{

	}

	public static void saveKnowledgeBaseItem()
	{
		
	}
*/
	public static boolean saveUser(UserBean user)
	{
		String insertQuery = "INSERT INTO userAccount VALUES (?,?,?,?,?,?,?)";
		try(Connection connection = ConfigBean.getConnection();
			PreparedStatement insertStatement = connection.prepareStatement(insertQuery);)
		{
			//name not found
			if(!findUserByName(user.getUserName()))
			{
				insertStatement.setString(1, user.getUserName());
				insertStatement.setString(2, user.getPassCode());
				insertStatement.setString(3, user.getFirstName());
				insertStatement.setString(4, user.getLastName());
				insertStatement.setString(5, user.getEmail());
				insertStatement.setString(6, user.getContactNumber());
				insertStatement.setString(7, user.getUserRole());
				
				insertStatement.execute();
				return true;
			}
			//if the name was found
			else
			{
				//may or may not need to implement this
				return false;
			}
		}

		catch(SQLException e)
		{
			System.out.println("saveUser() failed");
			System.err.println(e.getMessage());
			System.err.println(e.getStackTrace());
		}

		return false;

	}

	public static boolean findUserByName(String userName)
	{
		String selectByNameQuery = "SELECT * FROM userAccount WHERE userName = ?";
		try(Connection connection = ConfigBean.getConnection();
			PreparedStatement selectByNameStatement = connection.prepareStatement(selectByNameQuery);)
		{
			String name = userName;
			selectByNameStatement.setString(1, name);
			ResultSet nameResult = selectByNameStatement.executeQuery();

			//userName found 
			if(nameResult.next())
			{
				System.out.println("Name match found");
				return true;
			}

			//userName not found
			else
			{
				return false;
			}
		}

		catch(SQLException e)
		{
			System.out.println("findUserByName() failed");
			System.err.println(e.getMessage());
			System.err.println(e.getStackTrace());
		}
		return false;

	}

	public static UserBean login(String userName, String password)
	{
		String selectQuery = "SELECT * FROM userAccount WHERE userName = ? AND passCode = ?";
		try(Connection connection = ConfigBean.getConnection();
			PreparedStatement selectStatement = connection.prepareStatement(selectQuery);)
		{
			selectStatement.setString(1, userName);
			selectStatement.setString(2, password);
			ResultSet nameResult = selectStatement.executeQuery();

			//valid login
			if(nameResult.next())
			{
				System.out.println("valid login");
				UserBean user = new UserBean();
				user.setUserName(nameResult.getString(1));
				user.setPassCode(nameResult.getString(2));
				user.setFirstName(nameResult.getString(3));
				user.setLastName(nameResult.getString(4));
				user.setEmail(nameResult.getString(5));
				user.setContactNumber(nameResult.getString(6));
				user.setUserRole(nameResult.getString(7));
				return user;
			}

			//userName password missmatch
			else
			{
				System.out.println("userName password missmatch");
				return null;
			}
		}

		catch(SQLException e)
		{
			System.out.println("findUserByName() failed");
			System.err.println(e.getMessage());
			System.err.println(e.getStackTrace());
		}
		return null;
	}

}