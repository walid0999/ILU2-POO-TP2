package frontiere;

import controleur.ControlLibererEtal;

public class BoundaryLibererEtal {
	private ControlLibererEtal controlLibererEtal;

	public BoundaryLibererEtal(ControlLibererEtal controlLibererEtal) {
		this.controlLibererEtal = controlLibererEtal;
	}

	public void libererEtal(String nomVendeur) {
		boolean vendeurReconnu = controlLibererEtal.isVendeur(nomVendeur);
		if(!vendeurReconnu) {
			System.out.println("Mais vous n'êtes pas inscrit sur notre marché aujourd'hui !\n");
			
		}
		else {
			String[] donnesEtal = controlLibererEtal.libererEtal(nomVendeur);
			boolean etalOccupe = Boolean.parseBoolean(donnesEtal[0]);
			if(etalOccupe) {
				String produit = donnesEtal[2];
				int quantiteInitial = Integer.parseInt(donnesEtal[3]);
				int quantiteVendu =Integer.parseInt( donnesEtal[4]);
				System.out.println("Vous avez vendu "+quantiteVendu+" sur "+ quantiteInitial+ " "+ produit+ ".\n");
				System.out.println("Au revoir "+ nomVendeur+", passez une bonne journée. \n");
			}
		}
	}

}
