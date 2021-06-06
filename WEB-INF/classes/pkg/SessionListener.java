package pkg;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import javax.servlet.annotation.WebListener;


@WebListener
public class SessionListener implements HttpSessionListener 
{
		
	@Override
	public void sessionCreated(HttpSessionEvent e) 
	{
		System.out.println("Session created for:  " + ((String) e.getSession().getAttribute("UserName")));
	}


	@Override
	public void sessionDestroyed(HttpSessionEvent e) 
	{
		

		//System.out.println("Session closed for: " + user );
		

	}		
}