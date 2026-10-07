package frontiere;

import controleur.ControlPrendreEtal;

public class BoundaryPrendreEtal {
	private ControlPrendreEtal controlPrendreEtal;

	public BoundaryPrendreEtal(ControlPrendreEtal controlChercherEtal) {
		this.controlPrendreEtal = controlChercherEtal;
	}

	public void prendreEtal(String nomVendeur) {
		if(!controlPrendreEtal.verifierIdentite(nomVendeur)) {
			System.out.println("Je suis désolée "+ nomVendeur+ " mais il faut être un habitant de notre village pour commercer ici. \n");
			
		}
		else {
			System.out.println("Bonjour " +  nomVendeur+" ,je vais regarder si je peux vous trouver un étal.");
			if(!controlPrendreEtal.resteEtals()) {
				System.out.println("Désolée "+ nomVendeur+" je n'ai plus d'étal qui ne soit pas déjà occupé. \n");
				
			}
			else{
				installerVendeur(nomVendeur);
			}
		}
		
	}

	private void installerVendeur(String nomVendeur) {
		StringBuilder question_produit = new StringBuilder();
		question_produit.append("C'est parfait, il me reste un étal pour vous! \n");
		question_produit.append("Il me faudrait quelques renseignements: \n");
		question_produit.append("Quel produit souhaitez-vous vendre? \n");
		String produit = Clavier.entrerChaine(question_produit.toString());
		
		StringBuilder question_nbProduit = new StringBuilder();
		question_nbProduit.append("Combien souhaitez-vous en vendre ?\n");
		int nbProduit = Clavier.entrerEntier(question_nbProduit.toString());
		
		int numeroEtal = controlPrendreEtal.prendreEtal(nomVendeur, produit, nbProduit);
		if(numeroEtal != -1) {
			System.out.println("Le vendeur "+ nomVendeur+ " s'est installé à l'étal n°"+ numeroEtal);
		}
		
	}
}
