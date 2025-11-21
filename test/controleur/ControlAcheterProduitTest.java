package controleur;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import personnages.Chef;
import personnages.Gaulois;
import villagegaulois.Village;

class ControlAcheterProduitTest {
	private Village village;
	private ControlAcheterProduit controlAcheterProduit;
	
	
	@BeforeEach
	void BeforeEach(){
		village = new Village("le village des irreductibles", 10, 5);
		ControlTrouverEtalVendeur controlTrouverEtalVendeur = new ControlTrouverEtalVendeur(village);
		ControlVerifierIdentite controlVerifierIdentite = new ControlVerifierIdentite(village);
		controlAcheterProduit = new ControlAcheterProduit(controlVerifierIdentite, controlTrouverEtalVendeur, village);
		Chef chef = new Chef("Chef_Test", 15, village);
		village.setChef(chef);
	}

	@Test
	void testControlAcheterProduit() {
		assertNotNull(controlAcheterProduit);
	}

	@Test
	void testGetInfosMarche() {
		String[] etatmarcheVide = new String[0];
		assertEquals(controlAcheterProduit.getInfosMarche().length, etatmarcheVide.length);
		
		Gaulois vendeur = new Gaulois("Vendeur", 7);
		village.installerVendeur(vendeur, "pommes", 5);
		String[] etatmarcheRempli = {"Vendeur", "5", "pommes"};
		for(int i = 0; i<etatmarcheRempli.length; i++) {
			assertEquals(controlAcheterProduit.getInfosMarche()[i], etatmarcheRempli[i] );
		}
		assertEquals(controlAcheterProduit.getInfosMarche().length, etatmarcheRempli.length);
		
		
	}

	@Test
	void testTrouverHabitant() {
		Gaulois gaulois_test = new Gaulois("Gaulois_Test", 9);
		assertNull(controlAcheterProduit.trouverHabitant("Gulois_Test"));
		
		village.ajouterHabitant(gaulois_test);
		assertEquals(controlAcheterProduit.trouverHabitant(gaulois_test.getNom()), gaulois_test);
	}

	@Test
	void testRechercherVendeursProduit() {
		Gaulois vendeur = new Gaulois("Vendeur", 7);
		village.installerVendeur(vendeur, "pommes", 5);
		Gaulois[] testGaulois = new Gaulois[1];
		testGaulois[0] = vendeur;
		assertEquals(controlAcheterProduit.rechercherVendeursProduit("pommes")[0], testGaulois[0]);
		assertEquals(controlAcheterProduit.rechercherVendeursProduit("pommes").length, testGaulois.length );
	}

}
