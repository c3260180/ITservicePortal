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

    public void setUserName(String userName)
    {
        this.userName = userName;
    }

    public void setPassCode(String passCode)
    {
        this.passCode = passCode;
    }

    public void setFirstName(String firstName)
    {
        this.firstName = firstName;
    }

    public void setLastName(String lastName)
    {
        this.lastName = lastName;
    }

    public void setContactNumber(String contactNumber)
    {
        this.contactNumber = contactNumber;
    }

    public void setUserRole(String userRole)
    {
        this.userRole = userRole;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    public String getUserName()
    {
        return userName;
    }

    public String getPassCode()
    {
        return passCode;
    }

    public String getFirstName()
    {
        return firstName;
    }

    public String getLastName()
    {
        return lastName;
    }

    public String getContactNumber()
    {
        return contactNumber;
    }

    public String getUserRole()
    {
        return userRole;
    }

     public String getEmail()
    {
        return email;
    }
    
}