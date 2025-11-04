package villagegaulois;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.*;

import personnages.Chef;
import personnages.Gaulois;

class VillageTest {
	private String nom;
	private Chef chef;
	private Gaulois[] villageois;
	private int nbVillageois = 0;
	private Village village;
	private int nbEtal;
	
	@BeforeEach
	public void initialiserSituation() {
		nom = "Village test";
		nbVillageois = 5;
		nbEtal = 5;
		village = new Village(nom, nbVillageois, nbEtal);
		chef = new Chef(nom, nbVillageois, village);
	}
	
	@Test
	void testVillage() {
		assertNotNull(nom);
		assertNotNull(village);
	}

	@Test
	void testGetNom() {
		assertEquals(nom, village.getNom());
	}

	@Test
	void testSetChef() {
		village.setChef(chef);
		assertNotNull(chef);
	}

	@Test
	void testAjouterHabitant() {
		Gaulois gaulois = new Gaulois("gaulois test", 9);
		int testnbVillageois = nbVillageois;
		village.ajouterHabitant(gaulois);
		assertTrue(nbVillageois < villageois.length);
		assertEquals(villageois[testnbVillageois], gaulois);
		assertEquals(nbVillageois, testnbVillageois+1);
		
	}

	@Test
	void testTrouverHabitant() {
		fail("Not yet implemented");
	}

	@Test
	void testDonnerVillageois() {
		fail("Not yet implemented");
	}

	@Test
	void testDonnerNbEtal() {
		assertEquals(nbEtal, village.donnerNbEtal());
	}

	@Test
	void testInstallerVendeur() {
		fail("Not yet implemented");
	}

	@Test
	void testPartirVendeur() {
		fail("Not yet implemented");
	}

	@Test
	void testRechercherEtalVide() {
		fail("Not yet implemented");
	}

	@Test
	void testRechercherVendeursProduit() {
		fail("Not yet implemented");
	}

	@Test
	void testRechercherEtal() {
		fail("Not yet implemented");
	}

	@Test
	void testDonnerEtatMarche() {
		fail("Not yet implemented");
	}

}
