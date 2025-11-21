package controleur;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import personnages.Chef;
import personnages.Gaulois;
import villagegaulois.Village;

class ControlVerifierIdentiteTest {
	Village village;
	ControlVerifierIdentite controlVerifierIdentite;

	@BeforeEach
	void setUp(){
		village = new Village("Village_Test", 15, 5);
		Chef chef = new Chef("Chef_test", 7, village);
		village.setChef(chef);
		controlVerifierIdentite = new ControlVerifierIdentite(village);
	}

	@Test
	void testControlVerifierIdentite() {
		assertNotNull(controlVerifierIdentite);
	}

	@Test
	void testVerifierIdentite() {
		assertFalse(controlVerifierIdentite.verifierIdentite("Gaulois_test"));
		Gaulois gaulois_testGaulois = new Gaulois("Gaulois_test", 9);
		village.ajouterHabitant(gaulois_testGaulois);
		assertTrue(controlVerifierIdentite.verifierIdentite("Gaulois_test"));
	}

}
