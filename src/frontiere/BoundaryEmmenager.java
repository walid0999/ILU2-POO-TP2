package frontiere;

import controleur.ControlEmmenager;

public class BoundaryEmmenager {
	private ControlEmmenager controlEmmenager;

	public BoundaryEmmenager(ControlEmmenager controlEmmenager) {
		this.controlEmmenager = controlEmmenager;
	}

	public void emmenager(String nomVisiteur) {
		if (controlEmmenager.isHabitant(nomVisiteur)) {
			System.out.println(
					"Mais vous êtes déjà un habitant du village !");
		} else {
			StringBuilder question = new StringBuilder();
			question.append("Êtes-vous :\n");
			question.append("1 - un druide.\n");
			question.append("2 - un gaulois.\n");
			int choixUtilisateur = -1;
			do {
				choixUtilisateur = Clavier.entrerEntier(question.toString());
				switch (choixUtilisateur) {
				case 1:
					emmenagerDruide(nomVisiteur);
					break;

				case 2:
					StringBuilder question_force = new StringBuilder();
					question_force.append("Bienvenue villageois" + nomVisiteur+ "\n");
					question_force.append("Quelle est votre force ? \n");
					int force = Clavier.entrerEntier(question_force.toString());
					controlEmmenager.ajouterGaulois(nomVisiteur, force);
					break;

				default:
					System.out
							.println("Vous devez choisir le chiffre 1 ou 2 !");
					break;
				}
			} while (choixUtilisateur != 1 && choixUtilisateur != 2);
		}
	}

	private void emmenagerDruide(String nomVisiteur) {
		StringBuilder question_force = new StringBuilder();
		question_force.append("Bienvenue druide" + nomVisiteur+ "\n");
		question_force.append("Quelle est votre force ? \n");
		int forceDruide = Clavier.entrerEntier(question_force.toString());
		int effetPotionMax = -1;
		int effetPotionMin = 0;
		while(effetPotionMax < effetPotionMin) {
			StringBuilder quest_potion_min = new StringBuilder();
			quest_potion_min.append("Quelle est la foce de potion la plus faible que vous produisez?\n");
			effetPotionMin = Clavier.entrerEntier(quest_potion_min.toString());
			
			StringBuilder quest_potion_max = new StringBuilder();
			quest_potion_max.append("Quelle est la foce de potion la plus forte que vous produisez?\n");
			effetPotionMax = Clavier.entrerEntier(quest_potion_max.toString());
			
			if(effetPotionMax < effetPotionMin) {
				System.out.println("Attention Druide, vous vous êtes trompé entre le minimum et le maximum \n");
			}
		}
		
		controlEmmenager.ajouterDruide(nomVisiteur, forceDruide, effetPotionMin, effetPotionMax);
	}
}
