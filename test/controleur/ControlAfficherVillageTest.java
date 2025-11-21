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
		this.village_test = new Village("Village test", 20, 15);
		Chef chef_test= new Chef("Obelix", 15, village_test);
		this.village_test.setChef(chef_test);
		this.controlAfficherVillageTest = new ControlAfficherVillage(village_test);
		
	
	}

	@Test
	void testControlAfficherVillage() {
		controlAfficherVillageTest = new ControlAfficherVillage(village_test);
		assertNotNull(controlAfficherVillageTest);
	}

	@Test
	void testDonnerNomsVillageois() {
		assertEquals(controlAfficherVillageTest.donnerNomsVillageois()[0], "Obelix");
		assertEquals(controlAfficherVillageTest.donnerNomsVillageois().length, 1);
	}

	@Test
	void testDonnerNomVillage() {
		assertEquals(controlAfficherVillageTest.donnerNomVillage(), "Village test");
	}

	@Test
	void testDonnerNbEtals() {
		assertEquals(controlAfficherVillageTest.donnerNbEtals(), 15); //Voir constructeur
	}

}
