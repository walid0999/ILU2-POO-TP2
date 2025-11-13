package frontiere;

import controleur.ControlAcheterProduit;

public class BoundaryAcheterProduit {
	private ControlAcheterProduit controlAcheterProduit;

	public BoundaryAcheterProduit(ControlAcheterProduit controlAcheterProduit) {
		this.controlAcheterProduit = controlAcheterProduit;
	}

	public void acheterProduit(String nomAcheteur) {
		StringBuilder question = new StringBuilder();
		question.append("1 - je veux acheter un produit");
		question.append("2 - je veux avoir uune vue d'ensemble  du marché.\n");
		question.append("3 - quitter application.\n");
		int choixUtilisateur = -1;
		do {
			choixUtilisateur = Clavier.entrerEntier(question.toString());
			switch (choixUtilisateur) {
			case 1:
				if(controlAcheterProduit.trouverHabitant(nomAcheteur)==null) {
					System.out.println("Je suis désolé "+ nomAcheteur +" mais il faut être un habitant de notre village pour commercer ici" );
					break;
				}
				StringBuilder questionProduit = new StringBuilder();
				questionProduit.append("Quelle produit voulez-vous acheter?\n");
				String choixProduit = Clavier.entrerChaine(questionProduit.toString());
				if(controlAcheterProduit.rechercherVendeursProduit(choixProduit)==null) {
					System.out.println("Désolé, personne ne vend ce produit au marché!");
					break;
				}
				StringBuilder questionCommercant = new StringBuilder();
				questionCommercant.append("Chez quel commerçant voulez-vous acheter des ");
				questionCommercant.append(choixProduit);
				questionCommercant.append("?\n");
				for(int v = 0; v<(controlAcheterProduit.getInfosMarche().length)/3; v++) {
					questionCommercant.append(v);
					questionCommercant.append(" - ");
					questionCommercant.append(controlAcheterProduit.getInfosMarche()[v*3]);
					questionCommercant.append("\n");
				}
				int choixCommerçant = Clavier.entrerEntier(questionCommercant.toString());
				String commerçant = controlAcheterProduit.getInfosMarche()[choixCommerçant*3];
				if(controlAcheterProduit.trouverHabitant(commerçant)==null) {
					System.out.println("Je suis désolé "+ commerçant +" mais il faut être un habitant de notre village pour commercer ici" );
					break;
				}
				
				System.out.println(nomAcheteur+" se déplace jusqu'à l'étal du vendeur "+ controlAcheterProduit.getInfosMarche()[(choixCommerçant-1)*3]);
				StringBuilder questionQuantite = new StringBuilder();
				questionQuantite.append("Combien de ");
				questionQuantite.append(choixProduit);
				questionQuantite.append("voulez-vous acheter?\n");
				int choixQuantite = Clavier.entrerEntier(questionQuantite.toString());
				System.out.println(nomAcheteur+" achète "+choixQuantite+" " +choixProduit+ " à "+choixCommerçant);
				break;

			case 2:
				for(int v = 0; v<(controlAcheterProduit.getInfosMarche().length)/3; v++) {
					System.out.println(nomAcheteur+", vous trouverez au marché: \n");
					System.out.println("- "+ controlAcheterProduit.getInfosMarche()[v]+ " qui vend "+
											controlAcheterProduit.getInfosMarche()[v+1]+ " "+
											controlAcheterProduit.getInfosMarche()[v+2]);
				}
				
			case 3:
				System.out.println("Au revoir client "+ nomAcheteur);
				
			default:
				System.out.println("Vous devez choisir le chiffre 1, 2 ou 3 ! \n");
				break;
			
			}
		}while(true);
		
	}}
