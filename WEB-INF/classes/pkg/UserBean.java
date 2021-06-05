package pkg;

import javax.sql.*;
import java.sql.*;
import javax.naming.*;

public class UserBean {

    private String userName;
    private String passCode;
    private String firstName;
    private String lastName;
    private String email;
    private String contactNumber;
    private String userRole;

    public UserBean()
    {
        userName = "";
        passCode = "";
        firstName = "";
        lastName = "";
        contactNumber = "";
        userRole = "";
    }

    public synchronized void setUserName(String userName)
    {
        this.userName = userName;
    }

    public synchronized void setPassCode(String passCode)
    {
        this.passCode = passCode;
    }

    public synchronized void setFirstName(String firstName)
    {
        this.firstName = firstName;
    }

    public synchronized void setLastName(String lastName)
    {
        this.lastName = lastName;
    }

    public synchronized void setContactNumber(String contactNumber)
    {
        this.contactNumber = contactNumber;
    }

    public synchronized void setUserRole(String userRole)
    {
        this.userRole = userRole;
    }

    public synchronized void setEmail(String email)
    {
        this.email = email;
    }

    public synchronized String getUserName()
    {
        return userName;
    }

    public synchronized String getPassCode()
    {
        return passCode;
    }

    public synchronized String getFirstName()
    {
        return firstName;
    }

    public synchronized String getLastName()
    {
        return lastName;
    }

    public synchronized String getContactNumber()
    {
        return contactNumber;
    }

    public synchronized String getUserRole()
    {
        return userRole;
    }

     public synchronized String getEmail()
    {
        return email;
    }
    
}