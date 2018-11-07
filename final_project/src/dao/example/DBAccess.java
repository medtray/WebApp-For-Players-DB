package dao.example;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

public class DBAccess {

	public Scanner sc = null;
	public String dbName = null;
	public String userId = null;
	public String password = null;
	public String url = null;
	public String driver = null;
	public Connection dbConnection = null;
	
	public void initializeVariables(){
        driver = "com.ibm.db2.jcc.DB2Driver";
        dbName = "m0trab01";
        userId = "m0trab01";
        password = "Spring2017";
        url = "jdbc:db2://216.249.138.85:50000/"+dbName;
    }
	
	private void establishDBConnection(){
        System.out.println("Connect to '" + dbName + "' database using JDBC type 4 driver.");
        try
        {
            Class.forName(driver).newInstance();
            dbConnection = DriverManager.getConnection(url, userId, password);
            System.out.println("Connected to database.");
        }
        catch (ClassNotFoundException cle)
        {
        	cle.printStackTrace();
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
	
	public DBAccess() {
		// TODO Auto-generated constructor stub
		System.out.println("Hello DBAccess");
		initializeVariables();
		establishDBConnection();
	}

	@Override
	protected void finalize() throws Throwable {
		// TODO Auto-generated method stub
		disconnectFromDatabase();
		super.finalize();
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		new DBAccess();
		

	}

}
