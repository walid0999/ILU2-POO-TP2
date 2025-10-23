package frontiere;

import controleur.ControlPrendreEtal;

public class BoundaryPrendreEtal {
	private ControlPrendreEtal controlPrendreEtal;

	public BoundaryPrendreEtal(ControlPrendreEtal controlChercherEtal) {
		this.controlPrendreEtal = controlChercherEtal;
	}

	public void prendreEtal(String nomVendeur) {
		boolean verif = controlPrendreEtal.verifierIdentite(nomVendeur);
		if(!verif) {
			System.out.println("Je suis désolée " + nomVendeur+ " mais il faut être un habitant de notre village pour commencer ici. \n");
		}
		else {
			System.out.println("Bonjour "+nomVendeur+" ,je vais regarder si je peux vous trouver un étal.\n");
			if(!controlPrendreEtal.resteEtals()) {
				System.out.println("Désolée "+nomVendeur+ " je n'ai plus d'étal qui ne soit pas déjà occupé. \n");
			}
			else {
				installerVendeur(nomVendeur);
			}
		}
	}

	private void installerVendeur(String nomVendeur) {
		//TODO a completer
		StringBuilder questionProduit = new StringBuilder();
		questionProduit.append("C'est parfait, il me rest un étal pour vous!\n");
		questionProduit.append("Il me faudrait quelques renseignements:\n");
		questionProduit.append("Quelle produit souhaitez-vous vendre?\n");
		String produit =Clavier.entrerChaine(questionProduit.toString());
		
		StringBuilder questionnbProduit = new StringBuilder();
		questionnbProduit.append("Combien souhaitez-vous en vendre?\n");
		int nbProduit =Clavier.entrerEntier(questionnbProduit.toString());
		int numeroEtal = controlPrendreEtal.prendreEtal(nomVendeur, produit, nbProduit);
		if(numeroEtal != -1) {
			System.out.println("Le vendeur "+ nomVendeur+ " s'est installé à l'étal n°"+ numeroEtal);
		}
	}
}
