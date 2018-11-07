package controllers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class DatabaseConnectionController
{
    private String     dbName       = null;
    private String     userId       = null;
    private String     password     = null;
    private String     host         = null;
    private String     url          = null;
    private String     driver       = null;
    private Connection dbConnection = null;
    /**
     * @param dbName
     */
    public DatabaseConnectionController(String dbName)
    {
        super();
        this.dbName = dbName;
        initializeDBConnectionParameters();
    }
    public void initializeDBConnectionParameters()
    {
        driver = "com.ibm.db2.jcc.DB2Driver";
        userId = "m0trab01";
        password = "Spring2017";
        host = "jdbc:db2://216.249.138.85:50000/";
        url = "jdbc:db2://216.249.138.85:50000/m0trab01";
    }
    public void establishDBConnection()
    {
        System.out.println("We are connecting to '" + dbName + "' database using com.ibm.db2.jcc.DB2Driver driver.");
        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        try
        {
            Class.forName(driver).newInstance();
            dbConnection = DriverManager.getConnection(url, userId, password);
            System.out.println("Connected to '" + dbName);
            System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        }
        catch (ClassNotFoundException cle)
        {
            System.out.println("  Driver class not found, please check the PATH" + " and CLASSPATH system variables to ensure they are correct");
        }
        catch (SQLException sqle)
        {
            System.out.println("  Could not open connection");
            sqle.printStackTrace();
        }
        catch (Exception ne)
        {
            System.out.println("  Unexpected Error");
            ne.printStackTrace();
        }
    }
    public void disconnectFromDatabase()
    {
        if (dbConnection != null)
        {
            try
            {
                System.out.println("Disconnecting from database ...");
                dbConnection.close();
                System.out.println("Disconnected from database.");
            }
            catch (Exception sqle)
            {
                System.out.println("Error closing connection");
                sqle.printStackTrace();
            }
        }
    }
    public Connection getDbConnection()
    {
        return dbConnection;
    }
}