package Tests;

import static org.junit.Assert.*;

import java.util.Vector;

import org.junit.Before;
import org.junit.Test;

import dao.PlayerDao;
import dao.example.PlayerDAOImpl;

import model.Users;

public class PLayertest2 {

	
	PlayerDao libraryDAO;
	
	@Before
	public void setUp() throws Exception {
		libraryDAO = new PlayerDAOImpl();
	}

	
	@Test
	public void checkGetUser1() {
		assertTrue(libraryDAO.GetUser("Mahdi", "1357").getId().compareTo("Moalla")==0);
	}
	
	
	
	
	
	
	

}
