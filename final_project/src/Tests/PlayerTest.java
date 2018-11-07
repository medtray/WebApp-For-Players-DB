package Tests;

import static org.junit.Assert.*;

import java.util.Vector;

import junit.framework.TestCase;

import org.junit.Before;
import org.junit.Test;

import services.PlayerFacade;
import services.impl.PlayerFacadeImpl;
import services.impl.PlayerFacadeImpl;
import dao.PlayerDao;
import dao.example.PlayerDAOImpl;
import dao.example.PlayerDAOImpl;
import model.Club;
import model.Country;
import model.Player;
import model.Users;


public class PlayerTest  extends TestCase {

	
	PlayerFacade playerDAO;
	
	
	public void setUp() throws Exception {
		 System.out.println("aa");
		 super.setUp();
		 playerDAO = new PlayerFacadeImpl();
	        ((PlayerFacadeImpl) playerDAO).setPlayerDAO(PlayerDAOImpl.getPlayerDao());
	        System.out.println("aa");
		
	}

	
	@Test
	public void testCheckUser() {
		
		assertTrue(playerDAO.CheckUser("m0trab01", "Spring2017").getFirst_name().equals("Mohamed"));
	}
	
	//public void testListPlayersOfClub() {
		
	//	Country country1 = new Country("Tunisia","Tounes","Africa");
	//	Club club1 = new Club("CSS",country1);
	//	assertTrue(playerDAO.ListPlayersOfClub(club1).getClub().equals(club1.getClub_name()));
	
	//}
	
	public void testListCOUNTRIES() {
		assertFalse(playerDAO.ListCOUNTRIES().isEmpty());

}
	
	public void testListPlayersOfClub() {
		assertFalse(playerDAO.ListPlayersOfClub("CSS").isEmpty());

}
	
	public void testListPlayersOfCountry() {
		assertFalse(playerDAO.ListPlayersOfCountry("Tunisia").isEmpty());

}
	public void testCheckCountryInfoOfPlayer() {
	
	assertTrue(playerDAO.CheckCountryInfoOfPlayer("aa","aa","CSS").getName().equals("Tunisia"));
	}
}
