package controleur;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import personnages.Chef;
import personnages.Druide;
import personnages.Gaulois;
import villagegaulois.Village;

class ControlEmmenagerTest {
	
	
	private Village village;
	private Chef abraracourcix;
	private ControlEmmenager controlEmmenager;

	@BeforeEach
	public void initialiserSituation() {
		village = new Village("le village des irreductibles", 10, 5);
		abraracourcix = new Chef("Abraracourcix", 10, village);
		village.setChef(abraracourcix);
		controlEmmenager = new ControlEmmenager(village);
	}
	
	
	@Test
	void testControlEmmenager() {
		controlEmmenager = new ControlEmmenager(village);
		assertNotNull(controlEmmenager);
	}

	@Test
	void testIsHabitant() {
		Gaulois gaulois_test = new Gaulois("Asterix", 5);
		assertFalse(controlEmmenager.isHabitant("Asterix"));
		controlEmmenager.ajouterGaulois(gaulois_test.getNom(), gaulois_test.getForce());
		assertTrue(controlEmmenager.isHabitant("Asterix"));
	}

	@Test
	void testAjouterDruide() {
		String druide_nom = "Druide_test";
		Druide druide_test = new Druide(druide_nom, 5, 3, 7);
		assertFalse(controlEmmenager.isHabitant(druide_nom));
		controlEmmenager.ajouterDruide(druide_nom,5, 3, 7);
		assertTrue(controlEmmenager.isHabitant(druide_nom));
	}

	@Test
	void testAjouterGaulois() {
		String gaulois_nom = "Gaulois_test";
		Gaulois gaulois_test = new Gaulois(gaulois_nom, 5);
		assertFalse(controlEmmenager.isHabitant(gaulois_nom));
		controlEmmenager.ajouterGaulois(gaulois_nom,5);
		assertTrue(controlEmmenager.isHabitant(gaulois_nom));
	}

}
