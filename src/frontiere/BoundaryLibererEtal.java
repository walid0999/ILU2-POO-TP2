package frontiere;

import controleur.ControlLibererEtal;
import villagegaulois.Etal;

public class BoundaryLibererEtal {
	private ControlLibererEtal controlLibererEtal;

	public BoundaryLibererEtal(ControlLibererEtal controlLibererEtal) {
		this.controlLibererEtal = controlLibererEtal;
	}

	public void libererEtal(String nomVendeur) {
		Etal etal = controlLibererEtal.isVendeur(nomVendeur);
		boolean vendeurReconnu = etal != null;
		if(!vendeurReconnu) {
			System.out.println("Mais vous n'êtes pas inscrit sur notre marché aujourd'hui!\n");
		}
		else {
			String[] donneesEtal = controlLibererEtal.libererEtal(nomVendeur);
			if(Boolean.parseBoolean(donneesEtal[0])) {
				System.out.println("Vous avez vendu "+donneesEtal[3]+
						" sur "+ donneesEtal[3]+ " "+ donneesEtal[4]);
				System.out.println("Au revoir "+ donneesEtal[1] + ", passez une bonne journée.");
			}
		}
	}

}
