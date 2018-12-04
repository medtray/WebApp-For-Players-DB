package dao.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

import dao.PlayerDao;
import model.Club;
import model.Country;
import model.Player;
import model.Users;
import controllers.ConnectionPool;

public class PlayerDAOImpl implements PlayerDao {

	private static PlayerDAOImpl LibraryDAO = null;

	public static PlayerDao getPlayerDao() {
		
		if (LibraryDAO == null) {
			LibraryDAO = new PlayerDAOImpl();
			try {
				LibraryDAO.init();
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
		return LibraryDAO;
	}

	private void init() throws ParseException {
		// TODO Auto-generated method stub

	}
	
	private Connection openConnection() throws ClassNotFoundException, SQLException
    {
        Connection connection;
        Class.forName("com.ibm.db2.jcc.DB2Driver");
        connection = DriverManager.getConnection("jdbc:db2://216.249.138.85:50000/name", "name", "password");
        System.out.println("hani d5alt");
        return connection;
    }
	/**
	private Connection openConnection() 
    {
		Connection                connection       = null;
		ConnectionPool pool = ConnectionPool.getInstance("m0trab01");
		connection = pool.getConnection();
        return connection;
    }
    **/
    private void closeConnection(Connection connection)
    {
        if (connection != null)
            try
            {
                connection.close();
            }
            catch (SQLException e)
            {
            }
    }
	
	//Connection                connection       = null;
	public Users GetUser(String Name, String Password) {
		
	//	System.out.println("houni");
		//ConnectionPool pool = ConnectionPool.getInstance("m0trab01");
		//System.out.println("houni2");
        //connection = pool.getConnection();
        
        //System.out.println("Unable to get database connection");
		//if (connection.isClosed() == true) {
		//	System.out.println("Unable to get database connection");
			
	//	}
        DBAccess connection = new DBAccess();
        //Connection connection = null;
        //connection = openConnection();
        
		if (connection.dbConnection == null) {
			System.out.println("Unable to get database connection");
			return null;
		}
		
		String template = "SELECT * FROM USERS WHERE ID = '" + Name + "' AND PASSWORD = '" + Password + "'";
		System.out.println(template);

		Users NewUser = null;

		try {
			PreparedStatement st = connection.dbConnection.prepareStatement(template);
			//PreparedStatement st = connection.prepareStatement(template);
			ResultSet rs = st.executeQuery();
			

			int Nb = 0;

			while (rs.next()) {
				NewUser = new Users(rs.getString("ID"),rs.getString("PASSWORD"),rs.getString("FIRST_NAME"),rs.getString("SECOND_NAME"));
				++Nb;
			}

			if (Nb == 1) {
				System.out.println(Nb);
				System.out.println(NewUser.getId());
				return NewUser;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}
	
	
	public Country GetCountryInfoOfPlayer(String first_name, String second_name, String club) {
		
		
	        DBAccess connection = new DBAccess();
	        
	        //connection = openConnection();
	        
			if (connection.dbConnection == null) {
				System.out.println("Unable to get database connection");
				return null;
			}
			
			String template = "SELECT * FROM PLAYER WHERE FIRST_NAME = '" + first_name + "' AND SECOND_NAME = '" + second_name + "' AND CLUB = '"+ club+ "'";
			System.out.println(template);

			Player NewUser = null;

			try {
				//PreparedStatement st = connection.dbConnection.prepareStatement(template);
				PreparedStatement st = connection.dbConnection.prepareStatement(template);
				ResultSet rs = st.executeQuery();
				

				int Nb = 0;

				while (rs.next()) {
					NewUser = new Player(rs.getInt("ID"), rs.getString("FIRST_NAME"),rs.getString("SECOND_NAME"),rs.getString("CLUB"),rs.getString("COUNTRY"),rs.getString("POSITION"));
					++Nb;
				}

				if (Nb == 1) {
					System.out.println(Nb);
					System.out.println(NewUser.getId());
					String template2 = "SELECT * FROM COUNTRY WHERE NAME='" + NewUser.getCountry()+ "'";
					System.out.println(template2);
					 DBAccess connection2 = new DBAccess();
					PreparedStatement st1 = connection2.dbConnection.prepareStatement(template2);
					ResultSet rs1 = st1.executeQuery();
					Country NewCountry = null;
					int Nb1 = 0;
					while (rs1.next()) {
						NewCountry = new Country(rs1.getString("NAME"),rs1.getString("CAPITAL"),rs1.getString("CONTINENT"));
						++Nb1;
					}
					return NewCountry;
				}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			return null;
		}


	public List <Player> GetPlayerbyClub(String club)
    {
        
        Connection connection = null;
        Statement statement = null;
        ResultSet resultset = null;
        
        List ll = new LinkedList();
        DBAccess DB = new DBAccess();

		String query = "SELECT * FROM PLAYER WHERE CLUB='" + club+ "'";

		try {
			Statement st = DB.dbConnection.createStatement();
			ResultSet rs = st.executeQuery(query);
            
            System.out.println(query);
            
			
			
			
			while (rs.next()) {
				  
				  Player player = new Player(rs.getInt("ID"), rs.getString("FIRST_NAME"),rs.getString("SECOND_NAME"),rs.getString("CLUB"),rs.getString("COUNTRY"),rs.getString("POSITION"));

				  ll.add(player);
				}
			
			
			
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        finally
        {
            closeConnection(connection);
        }
        return ll;
    }
	
	
	public Vector<Country> GetCountry() {
		DBAccess DB = new DBAccess();

		String query = "select * from COUNTRY";

		try {
			Statement st = DB.dbConnection.createStatement();
			ResultSet rs = st.executeQuery(query);

			Vector<Country> Results = new Vector<Country>();

			while (rs.next()) {
				
				
				Country NewAuthor = new Country(rs.getString("NAME"),rs.getString("CAPITAL"),rs.getString("CONTINENT"));

				Results.addElement(NewAuthor);
			}

			return Results;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}

	public Vector<Users> GetUsers() {
		DBAccess DB = new DBAccess();

		String query = "select * from USERS";

		try {
			Statement st = DB.dbConnection.createStatement();
			ResultSet rs = st.executeQuery(query);

			Vector<Users> Results = new Vector<Users>();

			while (rs.next()) {
				
				
				Users NewAuthor = new Users(rs.getString("ID"),rs.getString("PASSWORD"),rs.getString("FIRST_NAME"),rs.getString("SECOND_NAME"));

				Results.addElement(NewAuthor);
			}

			return Results;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}
	
	@Override
	public List <Player> GetPlayerbyCountry(String country) {
		 Connection connection = null;
	        Statement statement = null;
	        ResultSet resultset = null;
	        
	        List ll = new LinkedList();
	        DBAccess DB = new DBAccess();

			String query = "SELECT * FROM PLAYER WHERE COUNTRY='" + country+ "'";

			try {
				Statement st = DB.dbConnection.createStatement();
				ResultSet rs = st.executeQuery(query);
	            
	            System.out.println(query);
	            
				
				
				
				while (rs.next()) {
					  
					  Player player = new Player(rs.getInt("ID"), rs.getString("FIRST_NAME"),rs.getString("SECOND_NAME"),rs.getString("CLUB"),rs.getString("COUNTRY"),rs.getString("POSITION"));

					  ll.add(player);
					}
				
				
				
	        }
	        catch (Exception e)
	        {
	            e.printStackTrace();
	        }
	        finally
	        {
	            closeConnection(connection);
	        }
	        return ll;
	}

	public List <Player> GetPlayerbyPosition(String position) {
		 Connection connection = null;
	        Statement statement = null;
	        ResultSet resultset = null;
	        
	        List ll = new LinkedList();
	        DBAccess DB = new DBAccess();

			String query = "SELECT * FROM PLAYER WHERE POSITION='" + position+ "'";

			try {
				Statement st = DB.dbConnection.createStatement();
				ResultSet rs = st.executeQuery(query);
	            
	            System.out.println(query);
	            
				
				
				
				while (rs.next()) {
					  
					  Player player = new Player(rs.getInt("ID"), rs.getString("FIRST_NAME"),rs.getString("SECOND_NAME"),rs.getString("CLUB"),rs.getString("COUNTRY"),rs.getString("POSITION"));

					  ll.add(player);
					}
				
				
				
	        }
	        catch (Exception e)
	        {
	            e.printStackTrace();
	        }
	        finally
	        {
	            closeConnection(connection);
	        }
	        return ll;
	}

	public Vector<Club> GetClubs() {
		DBAccess DB = new DBAccess();

		String query = "select * from CLUB";

		try {
			Statement st = DB.dbConnection.createStatement();
			ResultSet rs = st.executeQuery(query);

			Vector<Club> Results = new Vector<Club>();

			while (rs.next()) {
				
				
				Club NewAuthor = new Club(rs.getString("CLUB_NAME"),rs.getString("COUNTRY_NAME"));

				Results.addElement(NewAuthor);
			}

			return Results;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}
	
	public List <Club> GetClubbyCountry(String country) {
		 Connection connection = null;
	        Statement statement = null;
	        ResultSet resultset = null;
	        
	        List ll = new LinkedList();
	        DBAccess DB = new DBAccess();

			String query = "SELECT * FROM CLUB WHERE COUNTRY_NAME='" + country+ "'";

			try {
				Statement st = DB.dbConnection.createStatement();
				ResultSet rs = st.executeQuery(query);
	            
	            System.out.println(query);
	            
				
				
				
				while (rs.next()) {
					  
					  Club club = new Club(rs.getString("CLUB_NAME"),rs.getString("COUNTRY_NAME"));

					  ll.add(club);
					}
				
				
				
	        }
	        catch (Exception e)
	        {
	            e.printStackTrace();
	        }
	        finally
	        {
	            closeConnection(connection);
	        }
	        return ll;
	}

	
	
}
