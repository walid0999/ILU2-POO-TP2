package controleur;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import personnages.Chef;
import personnages.Gaulois;
import villagegaulois.Village;

class ControlPrendreEtalTest {
	Village village;
	ControlPrendreEtal controlPrendreEtal;
	ControlVerifierIdentite controlVerifierIdentite;

	@BeforeEach
	void setUp(){
		village = new Village("Village", 10, 1);
		Chef chef = new Chef("Chef", 9, village);
		village.setChef(chef);
		controlVerifierIdentite = new ControlVerifierIdentite(village);
		controlPrendreEtal = new ControlPrendreEtal(controlVerifierIdentite, village);
	}

	@Test
	void testControlPrendreEtal() {
		assertNotNull(controlPrendreEtal);
	}

	@Test
	void testResteEtals() {
		assertTrue(controlPrendreEtal.resteEtals());
		Gaulois vendeur = new Gaulois("Vendeur", 9);
		village.ajouterHabitant(vendeur);
		village.installerVendeur(vendeur, "pommes", 10);
		assertFalse(controlPrendreEtal.resteEtals());
	}

	@Test
	void testPrendreEtal() {
		Gaulois vendeur = new Gaulois("Vendeur", 9);
		village.ajouterHabitant(vendeur);
		int indiceEtal = controlPrendreEtal.prendreEtal("Vendeur", "pommes", 12);
		assertEquals(indiceEtal, 0); //L'unique eta qu'on a cree
	}

	@Test
	void testVerifierIdentite() {
		assertFalse(controlPrendreEtal.verifierIdentite("Gaulois"));
		Gaulois gaulois_test = new Gaulois("Gaulois", 9);
		village.ajouterHabitant(gaulois_test);
		assertTrue(controlPrendreEtal.verifierIdentite("Gaulois"));
	}

}
