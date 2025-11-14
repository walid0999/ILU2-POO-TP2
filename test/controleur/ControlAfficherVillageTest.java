package controleur;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.*;

import personnages.Chef;
import personnages.Gaulois;
import villagegaulois.Village;

class ControlAfficherVillageTest {
	private Village village_test;
	private ControlAfficherVillage controlAfficherVillageTest;
	
	@BeforeEach
	public void initControlAfficherVillageTest() {
		village_test = new Village("Village test", 20, 15);
	}

	@Test
	void testControlAfficherVillage() {
		controlAfficherVillageTest = new ControlAfficherVillage(village_test);
		assertNotNull(controlAfficherVillageTest);
	}

	@Test
	void testDonnerNomsVillageois() {
		for(int i=0; i<controlAfficherVillageTest.donnerNomsVillageois().length; i++) {
			assertNull(controlAfficherVillageTest.donnerNomsVillageois()[i]);
		}
		
		Chef chef_test= new Chef("Obelix", 15, village_test);
		village_test.setChef(chef_test);
		assertEquals(controlAfficherVillageTest.donnerNomsVillageois()[0], "Asterix");
	}

	@Test
	void testDonnerNomVillage() {
		assertEquals(controlAfficherVillageTest.donnerNomVillage(), "Village test");
	}

	@Test
	void testDonnerNbEtals() {
		assertEquals(controlAfficherVillageTest.donnerNbEtals(), 15);
	}

}
