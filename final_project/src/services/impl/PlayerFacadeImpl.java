package services.impl;

import java.util.List;
import java.util.Vector;

import dao.PlayerDao;
import model.Club;
import model.Country;
import model.Users;
import services.PlayerFacade;
import model.Player;

public class PlayerFacadeImpl implements PlayerFacade {
	
	private PlayerDao playerDAO ;

	

	public PlayerDao getPlayerDAO() {
		return playerDAO;
	}



	public void setPlayerDAO(PlayerDao playerDAO) {
		this.playerDAO = playerDAO;
	}



	@Override
	public Users CheckUser(String Name, String Password) {
		System.out.println("aya kifeh");
		return playerDAO.GetUser(Name, Password);
		
	}
	
	public List <Player> ListPlayersOfClub(String club) {
		System.out.println("aya kifeh");
		return playerDAO.GetPlayerbyClub(club);
		
	}

	public List <Player> ListPlayersOfCountry(String country) {
		System.out.println("aya kifeh");
		return playerDAO.GetPlayerbyCountry(country);
		
	}
	
	public List <Player> ListPlayersOfPosition(String position) {
		System.out.println("aya kifeh");
		return playerDAO.GetPlayerbyPosition(position);
		
	}

	@Override
	public Vector <Country> ListCOUNTRIES() {
		// TODO Auto-generated method stub
		Vector <Country> va=playerDAO.GetCountry();
		return va;
	}

	public Country CheckCountryInfoOfPlayer(String first_name, String second_name, String club) {
		System.out.println("aya kifeh");
		return playerDAO.GetCountryInfoOfPlayer(first_name, second_name, club);
		
	}

	

	

}
