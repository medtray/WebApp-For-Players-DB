package controllers;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
public class ConnectionPool
{
    private static ConnectionPool pool         = null;
    private static DataSource     dataSource   = null;
    private static Context        initContext  = null;
    private ConnectionPool(String resourceName)
    {
       
        try
        {
            initContext = new InitialContext();
            Context envContext = (Context) initContext.lookup("java:/comp/env");
            dataSource = (DataSource) envContext.lookup(resourceName);
        }
        catch (NamingException e)
        {
            e.printStackTrace();
        }
    }
    
    public static ConnectionPool getInstance(String resourceName)
    {
        if (pool == null)
        {
            pool = new ConnectionPool(resourceName);
        }
        return pool;
    }
    public Connection getConnection()
    {
        try
        {
            return dataSource.getConnection();
        }
        catch (SQLException sqle)
        {
            sqle.printStackTrace();
            return null;
        }
    }
    public void freeConnection(Connection c)
    {
        try
        {
            c.close();
        }
        catch (SQLException sqle)
        {
            sqle.printStackTrace();
        }
    }
}
