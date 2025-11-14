package controleur;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import personnages.Chef;
import villagegaulois.Village;

class ControlAfficherMarcheTest {
	
    private Village village_test;
    private ControlAfficherMarche controlAfficherMarche_test;
   
    @BeforeEach
    public void init(){
		Village village = new Village("le village des irreductibles", 10, 5);
		controlAfficherMarche_test = new ControlAfficherMarche(village);
	}
    
	@Test
	void testControlAfficherMarche() {
		assertNotNull(controlAfficherMarche_test);
	}

	@Test
	void testDonnerInfosMarche() {
		String[] tab_test = controlAfficherMarche_test.donnerInfosMarche();
		assertEquals(tab_test.length,0);
	}
}
