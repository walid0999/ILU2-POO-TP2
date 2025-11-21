package controleur;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import personnages.Chef;
import personnages.Gaulois;
import villagegaulois.Etal;
import villagegaulois.Village;

class ControlTrouverEtalVendeurTest {
	Village village;
	ControlTrouverEtalVendeur controlTrouverEtalVendeur;

	@BeforeEach
	void setUp(){
		this.village = new Village("Village_test", 10, 4);
		this.controlTrouverEtalVendeur = new ControlTrouverEtalVendeur(village);
		Chef chef = new Chef("Cheff", 9, village);
		village.setChef(chef);
		
	}

	@Test
	void testControlTrouverEtalVendeur() {
		assertNotNull(controlTrouverEtalVendeur);
	}

	@Test
	void testTrouverEtalVendeur() {
		assertNull(controlTrouverEtalVendeur.trouverEtalVendeur("Gaulois_test"));
		Gaulois gaulois_test = new Gaulois("Gaulois_test", 7);
		village.ajouterHabitant(gaulois_test);
		village.installerVendeur(gaulois_test, "pommes", 10);
		Etal etal = village.rechercherEtal(gaulois_test);
		assertEquals(controlTrouverEtalVendeur.trouverEtalVendeur("Gaulois_test"), etal );
	}

}
