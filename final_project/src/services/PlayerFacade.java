package services;

import java.util.List;
import java.util.Vector;








import model.Club;
import model.Country;
import model.Users;
import model.Player;

public interface PlayerFacade {
	
	public Users CheckUser(String Name,String Password);
	public List <Player> ListPlayersOfClub(String club);
	public List <Player> ListPlayersOfCountry(String country);
	public List <Player> ListPlayersOfPosition(String position);
	public Vector <Country> ListCOUNTRIES();
	public Country CheckCountryInfoOfPlayer(String first_name, String second_name, String club);
	
	
}
