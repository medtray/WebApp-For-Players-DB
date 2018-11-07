package controllers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

import model.Club;
import model.Country;
import model.Player;
import dao.example.DBAccess;

public class UsersController
{
    private Connection dbConnection = null;
    /**
     * 
     */
    public UsersController(Connection dbConnection)
    {
        this.dbConnection = dbConnection;
    }
    public int insertUser(String id, String pw, String fName, String mInit, String lName, int access)
    {
        int rc = 0;
        String template = "INSERT INTO USERS VALUES(?, ?, ?, ?, ?, ?)";
        try
        {
            PreparedStatement ps = dbConnection.prepareStatement(template);
            ps.setString(1, id);
            ps.setString(2, pw);
            ps.setString(3, fName);
            ps.setString(4, mInit);
            ps.setString(5, lName);
            ps.setInt(6, access);
            rc = ps.executeUpdate();
        }
        catch (SQLException e)
        {
            System.out.println(e.getMessage());
        } // end try catch
        return (rc);
    }
    public int updateUser(String id, String pw, String fName,  String lName)
    {
        int rc = 0;
        String template = "UPDATE USERS SET FIRST_NAME = ?,SECOND_NAME = ? where ID = ? and PASSWORD = ?";
        try
        {
            PreparedStatement ps = dbConnection.prepareStatement(template);
            ps.setString(3, fName);
       
            ps.setString(4, lName);
           
            ps.setString(1, id);
            ps.setString(2, pw);
            rc = ps.executeUpdate();
        }
        catch (SQLException e)
        {
            System.out.println(e.getMessage());
        } // end try catch
        return (rc);
    }
    public int deleteUser(String id, String pw)
    {
        int rc = 0;
        String template = "DELETE FROM USERS WHERE ID=? and PASSWORD=?";
        try
        {
            System.out.println("About to delete user " + id + " with password " + pw);
            PreparedStatement ps = dbConnection.prepareStatement(template);
            ps.setString(1, id);
            ps.setString(2, pw);
            rc = ps.executeUpdate();
        }
        catch (SQLException e)
        {
            System.out.println(e.getMessage());
        } // end try catch
        return (rc);
    }
    public boolean findUser(String id, String pw)
    {
        System.out.println("I will look for user");
        boolean rc = false;
        String template = "SELECT * FROM USERS WHERE ID = '" + id + "' AND PASSWORD = '" + pw + "'";
        try
        {
            Statement s = dbConnection.createStatement();
            ResultSet rs = s.executeQuery(template);
            if (rs.next())
            {
                rc = true;
            } // end if
        }
        catch (SQLException e)
        {
            System.out.println(e.getMessage());
        } // end try catch
        return (rc);
    }
    public ResultSet getUsersList(String keyword)
    {
        ResultSet rs = null;
        String template = "SELECT * FROM Users" + " WHERE FNAME LIKE '%" + StringUtil.fixSqlFieldValue(keyword) + "%'" + " OR LNAME LIKE '%" + StringUtil.fixSqlFieldValue(keyword) + "%'";
        try
        {
            Statement s = dbConnection.createStatement();
            rs = s.executeQuery(template);
        }
        catch (SQLException e)
        {
            System.out.println(e.getMessage());
        } // end try catch
        return (rs);
    }
    
    public ResultSet getUsersList()
    {
        ResultSet rs = null;
        String template = "SELECT * FROM Users";
        try
        {
            Statement s = dbConnection.createStatement();
            rs = s.executeQuery(template);
        }
        catch (SQLException e)
        {
            System.out.println(e.getMessage());
        } // end try catch
        return (rs);
    }

    
    public ResultSet getUserRecord(String id, String pw)
    {
        ResultSet rs = null;
        String template = "SELECT * FROM USERS WHERE ID= '" + id + "' AND PASSWORD = '" + pw + "'";
        try
        {
            Statement s = dbConnection.createStatement();
            rs = s.executeQuery(template);
        }
        catch (SQLException e)
        {
            System.out.println(e.getMessage());
        } // end try catch
        return (rs);
    }
    
    public int deletePlayer(String id)
    {
        int rc = 0;
        String template = "DELETE FROM PLAYER WHERE ID=?";
        try
        {
            
            PreparedStatement ps = dbConnection.prepareStatement(template);
            ps.setString(1, id);
            
            rc = ps.executeUpdate();
        }
        catch (SQLException e)
        {
            System.out.println(e.getMessage());
        } // end try catch
        return (rc);
    }
    
    
    public List <Player> GetPlayerbyCountry(String country) {
		 
	        ResultSet rs = null;
	        
	        List ll = new LinkedList();
	      

			String query = "SELECT * FROM PLAYER WHERE COUNTRY='" + country+ "'";
			
			 
		       
		        try
		        {
		            Statement s = dbConnection.createStatement();
		            rs = s.executeQuery(query);
	            
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
	      
	        return ll;
	}
    
    
    
    public ResultSet GetPlayerbyCountry1(String country) {
		 
	        ResultSet rs = null;
	        
	       
	      

			String query = "SELECT * FROM PLAYER WHERE COUNTRY='" + country+ "'";
			
			 
		       
		        try
		        {
		            Statement s = dbConnection.createStatement();
		            rs = s.executeQuery(query);
	            
	            System.out.println(query);
	            
				
							
				
	        }
	        catch (Exception e)
	        {
	            e.printStackTrace();
	        }
	      
	        return rs;
	}
    
    
    public ResultSet GetPlayerbyClub(String club) {
		 
        ResultSet rs = null;
        
       
      

		String query = "SELECT * FROM PLAYER WHERE CLUB='" + club+ "'";
		
		 
	       
	        try
	        {
	            Statement s = dbConnection.createStatement();
	            rs = s.executeQuery(query);
            
            System.out.println(query);
            
			
						
			
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
      
        return rs;
}
    
    public ResultSet GetPlayerbyPosition(String position) {
		 
        ResultSet rs = null;
        
       
      

		String query = "SELECT * FROM PLAYER WHERE POSITION='" + position+ "'";
		
		 
	       
	        try
	        {
	            Statement s = dbConnection.createStatement();
	            rs = s.executeQuery(query);
            
            System.out.println(query);
            
			
						
			
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
      
        return rs;
}
    
    
    public ResultSet GetICountryByPlayer(String first_name, String second_name, String club) {
		 
        ResultSet rs = null;
        ResultSet rs1 = null;
        
       
      

		String query = "SELECT * FROM PLAYER WHERE FIRST_NAME = '" + first_name + "' AND SECOND_NAME = '" + second_name + "' AND CLUB = '"+ club+ "'";

		
		 
	       
	        try
	        {
	            Statement s = dbConnection.createStatement();
	            rs = s.executeQuery(query);
            
            System.out.println(query);
            
            int Nb = 0;
            Player NewUser = null;
            
			while (rs.next()) {
				NewUser = new Player(rs.getInt("ID"), rs.getString("FIRST_NAME"),rs.getString("SECOND_NAME"),rs.getString("CLUB"),rs.getString("COUNTRY"),rs.getString("POSITION"));
				++Nb;
			}
			if(Nb==0){
			return rs;
			}
			if (Nb == 1) {
				System.out.println(Nb);
				System.out.println(NewUser.getId());
				String template2 = "SELECT * FROM COUNTRY WHERE NAME='" + NewUser.getCountry()+ "'";
				System.out.println(template2);
				Statement st1 = dbConnection.createStatement();
			    rs1 = st1.executeQuery(template2);
				
			
        }
	        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
      
        return rs1;
}
    
    
    public ResultSet GetICountryByClub(String club) {
		 
        ResultSet rs = null;
        ResultSet rs1 = null;
        
       
      

		String query = "SELECT * FROM CLUB WHERE CLUB_NAME = '" + club + "'";

		
		 
	       
	        try
	        {
	            Statement s = dbConnection.createStatement();
	            rs = s.executeQuery(query);
            
            System.out.println(query);
            
            int Nb = 0;
            Club NewUser = null;
            
			while (rs.next()) {
				NewUser = new Club(rs.getString("CLUB_NAME"),rs.getString("COUNTRY_NAME"));
				++Nb;
			}
			if(Nb==0){
			return rs;
			}
			if (Nb == 1) {
				System.out.println(Nb);
				
				String template2 = "SELECT * FROM COUNTRY WHERE NAME='" + NewUser.getCountry_name()+ "'";
				System.out.println(template2);
				Statement st1 = dbConnection.createStatement();
			    rs1 = st1.executeQuery(template2);
				
			
        }
	        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
      
        return rs1;
}
    
    public int deleteClub(String id)
    {
        int rc = 0;
        String template = "DELETE FROM CLUB WHERE CLUB_NAME=?";
        try
        {
            
            PreparedStatement ps = dbConnection.prepareStatement(template);
            ps.setString(1, id);
            
            rc = ps.executeUpdate();
        }
        catch (SQLException e)
        {
            System.out.println(e.getMessage());
        } // end try catch
        return (rc);
    }
    
    public int deleteCountry(String id)
    {
        int rc = 0;
        String template = "DELETE FROM COUNTRY WHERE NAME=?";
        try
        {
            
            PreparedStatement ps = dbConnection.prepareStatement(template);
            ps.setString(1, id);
            
            rc = ps.executeUpdate();
        }
        catch (SQLException e)
        {
            System.out.println(e.getMessage());
        } // end try catch
        return (rc);
    }
    
    public Player selectPlayer(String player) {
		 
        ResultSet rs = null;
        Player NewUser = null;
       
      

		String query = "SELECT * FROM PLAYER WHERE ID='" + player+ "'";
		
		 
	       
	        try
	        {
	            Statement s = dbConnection.createStatement();
	            rs = s.executeQuery(query);
            
            System.out.println(query);
            int Nb = 0;
            
            
			while (rs.next()) {
				NewUser = new Player(rs.getInt("ID"),rs.getString("FIRST_NAME"),rs.getString("SECOND_NAME"),rs.getString("CLUB"),rs.getString("COUNTRY"),rs.getString("POSITION"));
				++Nb;
			}
            
			
						
			
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
      
        return NewUser;
}
}
