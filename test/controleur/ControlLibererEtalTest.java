package controleur;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import personnages.Chef;
import personnages.Gaulois;
import villagegaulois.Etal;
import villagegaulois.Village;

class ControlLibererEtalTest {
	ControlTrouverEtalVendeur controlTrouverEtalVendeur;
	ControlLibererEtal controlLibererEtal;
	Village village;
	
	@BeforeEach
	void setUp(){
		village = new Village("Village", 10, 5);
		Chef chef = new Chef("Chef", 9, village);
		village.setChef(chef);
		controlTrouverEtalVendeur = new ControlTrouverEtalVendeur(village);
		controlLibererEtal = new ControlLibererEtal(controlTrouverEtalVendeur);
		
	}

	@Test
	void testControlLibererEtal() {
		assertNotNull(controlLibererEtal);
	}

	@Test
	void testIsVendeur() {
		assertNull(controlLibererEtal.isVendeur("Non Vendeur"));
		
		Gaulois vendeur = new Gaulois("Vendeur", 7);
		Gaulois non_vendeur = new Gaulois("Non Vendeur", 4);
		village.ajouterHabitant(vendeur);
		village.ajouterHabitant(non_vendeur);
		village.installerVendeur(vendeur, "pommes", 5);
		Etal etal = village.rechercherEtal(vendeur);
		assertEquals(controlLibererEtal.isVendeur("Vendeur"), etal);
	}

	@Test
	void testLibererEtal() {
		Gaulois vendeur = new Gaulois("Vendeur", 7);
		village.ajouterHabitant(vendeur);
		village.installerVendeur(vendeur, "pommes", 5);
		Etal etal = village.rechercherEtal(vendeur);
		String[] donneesEtal = controlLibererEtal.libererEtal("Vendeur");
		String[] verif = {"true", "Vendeur", "pommes", "5", "0"};
		for(int i=0; i<donneesEtal.length; i++) {
			assertEquals(donneesEtal[i],verif[i]);
		}
		assertEquals(donneesEtal.length, verif.length);
	}

}
