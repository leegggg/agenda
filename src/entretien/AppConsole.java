package entretien;


import java.util.List;
import java.util.Scanner;

import bibAgenda.Employe;
import bibAgenda.Tache;

public class AppConsole {

	static Scanner in = new Scanner(System.in);
	// creation de la banque :
	static ServiceEntretien service = new ServiceEntretien();
	
	public static void main(String[] args) {
		int choix = 0;
		do {
			choix = menu();
		} while (choix != 0);
		System.out.println("au revoir!");
	}

	static int menu() {
		//clean();
		
		System.out.println("\nMenu\n");
		System.out.println("11: Ajouter Employe");
		System.out.println("12: Ajouter Salle");
		System.out.println("21: Traiter Demande Salle");
		System.out.println("31: Lister les employes");
		System.out.println("32: Afficher l'emploi du Temps d'un employe");
		System.out
				.println("33: Afficher les emploi du Temps de tous les employes");
		System.out.println("4: Annuler une demande");
		System.out.println("5: Lire un fichier XML");
		System.out.println("0: Exit");
		System.out.print("votre choix? ");
		int choix = 0;
		choix = in.nextInt();
		//clean();
		switch (choix) {
		case 11:
			menuAjouterEmploye();
			break;
		case 12: // creer un nouveau compte
			menuAjouterSalle();
			break;
		case 21: // creer un nouveau compte
			menuTraitementDemandeSalle();
			break;
		case 31: // crediter un compte
			menuAfficherEmploye();
			break;
		case 32: // crediter un compte
			menuAfficherEmploiTempsUnEmploye();
			break;
		case 33: // crediter un compte
			menuAfficherEmploiTemps();
			break;
		case 30: // crediter un compte
			menuAfficher();// Test
			break;
		case 4: // crediter un compte
			menuAnnulerDemandeTache();
			break;
		case 0: // quitter
		}
		if (choix != 0) {
			System.out.println("Continue?(y/n)");
			String res = in.next();
			if (res.equals("n")) {
				choix = 0;
			}
		}

		return choix;

	}

	static void menuAjouterEmploye() {
		System.out.print("Nom? ");
		String nom = in.next();
		System.out.print("Numero? ");
		String num = in.next();
		service.ajouterEmploye(nom, num);
	}

	static void menuAjouterSalle() {
		System.out.print("Num? ");
		String num = in.next();
		service.ajouterSalle(num);
	}


	static void menuAfficherEmploye() {
		List<Employe> listEmploye = service.getListeEmploye();
		System.out.println("num\tnom");
		for (Employe employe : listEmploye) {
			System.out.println(employe.getNum() + "\t" + employe.getNom());
		}
	}

	static void menuAfficherEmploiTempsUnEmploye() {
		System.out.print("Nom de l'employe? ");
		String nom = in.next();
		Employe employe = null;
		List<Employe> listEmploye = service.getListeEmploye();
		for (Employe e : listEmploye) {
			if (e.getNom().equals(nom) ) {
				employe = e;
				break;
			}
		}
		if (employe == null) {
			System.err.println("Employe " + nom + " non trouve.");
			return;
		}
		System.out.println(service.getEmploiTemps(employe));
	}

	static void menuAfficherEmploiTemps() {
		List<Employe> listEmploye = service.getListeEmploye();
		for (Employe e : listEmploye) {
			System.out.println(e.getNom() + "  " + e.getNum());
			System.out.println(service.getEmploiTemps(e));
		}
	}

	// test
	static void menuAfficher() {
		System.out.println("Table employe\n" + service.getListeEmploye());
		System.out.println("Table empT\n");
		List<Employe> listEmploye = service.getListeEmploye();
		for (Employe e : listEmploye) {
			System.out.println(service.getEmploiTemps(e));
		}

		System.out.println("Table Materiel\n" + service.getTableSalle());
	}

	static void menuTraitementDemandeSalle() {

		System.out.print("Nature? ");
		String nature = in.next();
		System.out.print("Nombre de creneaux? ");
		int nbCreneaux = in.nextInt();
		System.out.print("Num salle? ");
		String numSalle = in.next();
		try {
			TacheSalle tacheSalle = service.traiterDemande(
					nature, nbCreneaux, numSalle);
			if (tacheSalle != null) {
				System.out.println("Tache " + tacheSalle
						+ " traitee avec success.");
			} else {
				System.out.println("On ne peut pas traiter cette demande !");
			}
		} catch (SalleNotFoundException e) {

			System.err.println("Demande non traitee. Logiciel " + numSalle
					+  "non trouves.");
			e.printStackTrace();
		}

	}



	static void menuAnnulerDemandeTache() {

		System.out.print("Nature? ");
		String nature = in.next();
		for (Tache tache : service.tableTacheAffectes) {
			if (tache.equals(nature)) {
				service.annulerDemande(tache);
				return;
			}
		}
		System.err.println("Tache " + nature + " non trouvee.");
	}



	static void clean() {
		for (int i = 0; i < 100; i++) {
			System.out.print("\n");
		}
	}

}
