package pkg;

import javax.sql.*;
import java.sql.*;
import javax.naming.*;

public class ConfigBean {
    private static final DataSource dataSource = makeDataSource();
    
    private static DataSource makeDataSource() 
    {
        try 
        {
            InitialContext ctx = new InitialContext();
            return (DataSource) ctx.lookup("java:/comp/env/jdbc/dealdata");
        } 
        catch (NamingException e) 
        { 
            throw new RuntimeException(e); 
        }
    }

    public static Connection getConnection() throws SQLException 
    {
        return dataSource.getConnection();
    } 

    public static void closeConnection() throws SQLException 
    {
        dataSource.getConnection().close();
    }
}