package pkg;
import javax.sql.*;
import java.sql.*;
import java.util.*;
import java.util.ArrayList; 

public class DBhandler
{   
/*


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

//-------------------- User Functions ---------------------------
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

	//-------------------- Ticket Functions ---------------------------
	public static boolean saveTicket(TicketBean ticket)
	{
		String insertQuery = "INSERT INTO ticket VALUES (?,?,?,?,?,?,?)";
		try(Connection connection = ConfigBean.getConnection();
			PreparedStatement insertStatement = connection.prepareStatement(insertQuery);)
		{
			//Ticket not found
			if(!findTicketByTitle(ticket.getTitle()))
			{
				insertStatement.setString(1, ticket.getUser());
				insertStatement.setString(2, ticket.getKeyword());
				insertStatement.setString(3, ticket.getStatus());
				insertStatement.setString(4, ticket.getTitle());
				insertStatement.setString(5, ticket.getOpened());
				insertStatement.setString(6, ticket.getCategory());
				insertStatement.setString(7, ticket.getDescription());
				
				insertStatement.execute();
				return true;
			}
			//if the ticket was found
			else
			{
				//may or may not need to implement this
				return false;
			}
		}

		catch(SQLException e)
		{
			System.out.println("saveTicket() failed");
			System.err.println(e.getMessage());
			System.err.println(e.getStackTrace());
		}

		return false;

	}

	public static boolean findTicketByTitle(String title)
	{
		String selectByNameQuery = "SELECT * FROM ticket WHERE ticketTitle = ?";
		try(Connection connection = ConfigBean.getConnection();
			PreparedStatement selectByNameStatement = connection.prepareStatement(selectByNameQuery);)
		{
			String ticketTitle = title;
			selectByNameStatement.setString(1, ticketTitle);
			ResultSet titleResult = selectByNameStatement.executeQuery();

			// If ticket found 
			if(titleResult.next())
			{
				System.out.println("Title match found");
				return true;
			}

			//If ticket not found
			else
			{
				return false;
			}
		}

		catch(SQLException e)
		{
			System.out.println("findTicketByTitle() failed");
			System.err.println(e.getMessage());
			System.err.println(e.getStackTrace());
		}
		return false;

	}

	/*public static ArrayList<TicketBean> loadTickets()
	{
		String selectByNameQuery = "SELECT * FROM ticket WHERE ticketTitle = ?";
		try(Connection connection = ConfigBean.getConnection();
			PreparedStatement selectByNameStatement = connection.prepareStatement(selectByNameQuery);)
		{
	}*/

	//-------------------- Knowledge Base Functions ---------------------------
	public static boolean saveEntry(KnowledgeBaseBean item)
	{
		String insertQuery = "INSERT INTO knoewledgeBase VALUES (?,?,?,?,?,?,?,?,?,?)";
		try(Connection connection = ConfigBean.getConnection();
			PreparedStatement insertStatement = connection.prepareStatement(insertQuery);)
		{
			//Ticket not found
			if(!findTicketByTitle(item.getTitle()))
			{
				insertStatement.setString(1, item.getUser());
				insertStatement.setString(4, item.getTitle());
				insertStatement.setString(6, item.getCategory());
				insertStatement.setString(5, item.getKbOpened());
				insertStatement.setString(5, item.getKbClosed());
				insertStatement.setString(7, item.getDescription());
				insertStatement.setString(2, item.getKeyword());
				insertStatement.setString(3, item.getKbComment());
				insertStatement.setString(3, item.getResolution());
				
				insertStatement.execute();
				return true;
			}
			//if the ticket was found
			else
			{
				//may or may not need to implement this
				return false;
			}
		}

		catch(SQLException e)
		{
			System.out.println("saveEntry() failed");
			System.err.println(e.getMessage());
			System.err.println(e.getStackTrace());
		}

		return false;

	}
	
	public static boolean findKbItem(String kbItemTitle)
	{
		String selectByNameQuery = "SELECT * FROM knowledgeBase WHERE kbTitle = ?";
		try(Connection connection = ConfigBean.getConnection();
			PreparedStatement selectByNameStatement = connection.prepareStatement(selectByNameQuery);)
		{
			String kbTitle = kbItemTitle;
			selectByNameStatement.setString(1, kbTitle);
			ResultSet kbResult = selectByNameStatement.executeQuery();

			// If ticket found 
			if(kbResult.next())
			{
				System.out.println("Title match found");
				return true;
			}

			//If ticket not found
			else
			{
				return false;
			}
		}

		catch(SQLException e)
		{
			System.out.println("findKbItem() failed");
			System.err.println(e.getMessage());
			System.err.println(e.getStackTrace());
		}
		return false;

	}
}