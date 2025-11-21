package villagegaulois;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import personnages.Gaulois;

class EtalTest {
	private Gaulois vendeur;
	private String produit;
	private int quantiteDebutMarche;
	private int quantite;
	private boolean etalOccupe = false;
	Etal etal;

	@BeforeEach
	void setUp(){
		etal = new Etal();
		vendeur = new Gaulois("Gaulois", 9);
		quantite =5;
		quantiteDebutMarche = 7;
		produit = "pommes";
	}

	@Test
	void testIsEtalOccupe() {
		assertFalse(etalOccupe);
	}

	@Test
	void testGetVendeur() {
		assertEquals(etal.getVendeur(), vendeur);
	}

	@Test
	void testGetQuantite() {
		assertEquals(etal.getQuantite(), quantite);
	}

	@Test
	void testGetProduit() {
		assertEquals(etal.getProduit(), produit);
	}

	@Test
	void testOccuperEtal() {
		fail("Not yet implemented");
	}

	@Test
	void testContientProduit() {
		fail("Not yet implemented");
	}

	@Test
	void testAcheterProduit() {
		fail("Not yet implemented");
	}

	@Test
	void testLibererEtal() {
		fail("Not yet implemented");
	}

	@Test
	void testEtatEtal() {
		fail("Not yet implemented");
	}

}
