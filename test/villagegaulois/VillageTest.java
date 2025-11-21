package villagegaulois;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.*;

import personnages.Chef;
import personnages.Druide;
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
		nbEtal = 1;
		village = new Village(nom, 3, nbEtal);
		Chef chef1 = new Chef(nom, nbVillageois, village);
		village.setChef(chef1);
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
		assertNotNull(chef);
	}

	@Test
	void testAjouterHabitant() {
		Gaulois gaulois = new Gaulois("Gaulois 1", 9);
		village.ajouterHabitant(gaulois);
		assertEquals(gaulois, this.villageois[0]);
		assertEquals(nbVillageois, 1);
		assertEquals(villageois.length, 1);
		Gaulois gaulois_ajout_impossiple = new Gaulois("Gaulois 2", 8);
		assertEquals(gaulois, villageois[0]);
		assertEquals(nbVillageois, 1);
		assertEquals(villageois.length, 1);
		
	}

	@Test
	void testTrouverHabitant() {
		assertEquals(village.trouverHabitant("Chef"), chef);
		assertNull(village.trouverHabitant("Gaulois 1"));
		Gaulois gaulois = new Gaulois("Gaulois 1", 9);
		village.ajouterHabitant(gaulois);
		assertEquals(village.trouverHabitant("Gaulois 1"), gaulois);
	}

	@Test
	void testDonnerVillageois() {
		String[] villageois_1 = {"Chef"};
		assertEquals(villageois_1[0], village.donnerVillageois()[0]);
		assertEquals(villageois_1.length, village.donnerEtatMarche().length);
		
		Gaulois gaulois = new Gaulois("Gaulois 1", 9);
		village.ajouterHabitant(gaulois);
		//Druide druide = new Druide("Druide",9, 2, 5);

		String[] villageois_2 = {"Chef", "Gaulois_1"};
		assertEquals(villageois_1[0], village.donnerVillageois()[0]);
		assertEquals(villageois_1[1], village.donnerVillageois()[1]);
		assertEquals(villageois_1.length, village.donnerVillageois().length);
		
	}

	@Test
	void testDonnerNbEtal() {
		assertEquals(nbEtal, village.donnerNbEtal());
	}

	@Test
	void testInstallerVendeur() {
		Gaulois gaulois = new Gaulois("Gaulois 1", 9);
		assertEquals(0,village.installerVendeur(gaulois, "pommes", 8));
		Gaulois gaulois_2 = new Gaulois("Gaulois 2", 9);
		assertEquals(-1,village.installerVendeur(gaulois_2, "bananes", 7));
	}

	@Test
	void testPartirVendeur() {
		Gaulois gaulois = new Gaulois("Gaulois 1", 9);
		village.installerVendeur(gaulois, "pommes", 5);
		village.partirVendeur(gaulois);
		Gaulois gaulois_2 = new Gaulois("Gaulois 2", 9);
		assertEquals(0,village.installerVendeur(gaulois_2, "bananes", 7));
	}

	@Test
	void testRechercherEtalVide() {
		assertTrue(village.rechercherEtalVide());
		Gaulois gaulois = new Gaulois("Gaulois 1", 9);
		village.installerVendeur(gaulois, "pommes", 5);
		assertFalse(village.rechercherEtalVide());
		
	}

	@Test
	void testRechercherVendeursProduit() {
		Gaulois gaulois = new Gaulois("Gaulois 1", 9);
		village.installerVendeur(gaulois, "pommes", 5);

		Gaulois gaulois_2 = new Gaulois("Gaulois 2", 9);
		village.installerVendeur(gaulois_2, "banane", 7);
		Gaulois[] vendeur = {gaulois};
		
		assertEquals( vendeur[0], village.rechercherVendeursProduit("poommes")[0]);
		assertEquals(vendeur.length, village.rechercherVendeursProduit("pommes"));
	}

	@Test
	void testRechercherEtal() {
		Gaulois gaulois = new Gaulois("Gaulois 1", 9);
		village.installerVendeur(gaulois, "pommes", 5);
		assertEquals(village.rechercherEtal(gaulois), null);
	}

	@Test
	void testDonnerEtatMarche() {
		Gaulois gaulois = new Gaulois("Gaulois 1", 9);
		village.installerVendeur(gaulois, "pommes", 5);
		String[] etal = {"Gulois 1", "5", "pommes"};
		assertEquals(etal[0], village.donnerEtatMarche()[0]);
		assertEquals(etal[1], village.donnerEtatMarche()[1]);
		assertEquals(etal[2], village.donnerEtatMarche()[2]);
		assertEquals(etal.length, village.donnerEtatMarche().length);
		
	}

}
