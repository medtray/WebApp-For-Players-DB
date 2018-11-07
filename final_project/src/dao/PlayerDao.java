package dao;
import java.util.List;
import java.util.Vector;






import com.ibm.db2.jcc.am.ResultSet;

import model.Users;
import model.Country;
import model.Club;
import model.Player;

public interface PlayerDao {
	
	public Users GetUser(String id,String Password);
	public Vector<Users> GetUsers();
	
	public Vector<Club> GetClubs();
	public List <Club> GetClubbyCountry(String country);
	public Vector<Country> GetCountry();
	
	public List <Player> GetPlayerbyClub(String club);
	public List <Player> GetPlayerbyCountry(String country);
	public List <Player> GetPlayerbyPosition(String position);
	public Country GetCountryInfoOfPlayer(String first_name, String second_name, String club);
	
	

}