package si;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;
import java.util.Scanner;

import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import si.ServiceInfo;
import si.parseur.SIHandler;
import bibAgenda.Employe;
import bibAgenda.Tache;

public class AppConsole {

	static Scanner in = new Scanner(System.in);
	// creation de la banque :
	static ServiceInfo service = new ServiceInfo();
	public final static String PATH_DATA_FILE = "data.bin";

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
		System.out.println("12: Ajouter Logiciel");
		System.out.println("13: Ajouter Materiel");
		System.out.println("21: Traiter Demande Logiciel");
		System.out.println("22: Traiter Demande Materiel");
		System.out.println("31: Lister les employes");
		System.out.println("32: Afficher l'emploi du Temps d'un employe");
		System.out
				.println("33: Afficher les emploi du Temps de tous les employes");
		System.out.println("4: Annuler une demande");
		System.out.println("5: Lire un fichier XML");
		System.out.println("60: Sauvegarder");
		System.out.println("61: Charger les donnees sauvegarde");
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
			menuAjouterLogiciel();
			break;
		case 13: // creer un nouveau compte
			menuAjouterMateriel();
			break;
		case 21: // creer un nouveau compte
			menuTraitementDemandeLogiciel();
			break;
		case 22: // creer un nouveau compte
			menuTraitementDemandeMateriel();
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
		case 5: // crediter un compte
			menuLireXML();
			break;
		case 50: // crediter un compte
			menuLireXMLDef();
			break;
		case 60: // crediter un compte
			try {
				menuSave();
			} catch (IOException e) {
				System.err.println("Attention! Veuillez entrer le fichier a lire");
				e.printStackTrace();
			}
			break;
		case 61:
			try {
				menuLoad();
			} catch (ClassNotFoundException e) {
				System.err.println("Attention! Veuillez entrer le fichier a lire");
				e.printStackTrace();
			} catch (IOException e) {
				System.err.println("Attention! Veuillez entrer le fichier a lire");
				e.printStackTrace();
			}
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

	static void menuAjouterMateriel() {
		System.out.print("Nom? ");
		String nom = in.next();
		System.out.print("Marque? ");
		String marque = in.next();
		System.out.print("Processeur? ");
		String processeur = in.next();
		System.out.print("HD? ");
		String hd = in.next();
		System.out.print("Ram? ");
		String ram = in.next();
		service.ajouterMateriel(nom, marque, processeur, hd, ram);
	}

	static void menuAjouterLogiciel() {
		System.out.print("Nom? ");
		String nom = in.next();
		System.out.print("Version? ");
		String version = in.next();
		System.out.print("Date? ");
		String date = in.next();
		System.out.print("Taille? ");
		String taille = in.next();
		System.out.print("Editeur? ");
		String editeur = in.next();
		service.ajouterLogiciel(nom, version, taille, date, editeur);

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
		System.out.println("Table logiciel\n" + service.getTableLogiciel());
		System.out.println("Table Materiel\n" + service.getTableMateriel());
		System.out.println("File d attente\n" + service.getFileAttente());
	}

	static void menuTraitementDemandeLogiciel() {

		System.out.print("Nature? ");
		String nature = in.next();
		System.out.print("Nombre de creneaux? ");
		int nbCreneaux = in.nextInt();
		System.out.print("Nom logiciel? ");
		String nomLogiciel = in.next();
		System.out.print("Version ");
		String version = in.next();
		try {
			TacheLogiciel tacheLogiciel = service.traiterDemandeLogiciel(
					nature, nbCreneaux, nomLogiciel, version);
			if (tacheLogiciel != null) {
				System.out.println("Tache " + tacheLogiciel
						+ " traitee avec success.");
			} else {
				System.out.println("On ne peut pas traiter cette demande !");
			}
		} catch (LogicielNotFoundException e) {

			System.err.println("Demande non traitee. Logiciel " + nomLogiciel
					+ " version " + version + "non trouves.");
			e.printStackTrace();
		}

	}

	static void menuTraitementDemandeMateriel() {

		System.out.print("Nature? ");
		String nature = in.next();
		System.out.print("Nombre de creneaux? ");
		int nbCreneaux = in.nextInt();
		System.out.print("Nom materiel? ");
		String nomMateriel = in.next();

		try {

			TacheMateriel tacheMateriel = service.traiterDemandeMateriel(
					nature, nbCreneaux, nomMateriel);
			if (tacheMateriel != null) {
				System.out.println("Tache " + tacheMateriel
						+ "traitee avec success.");
			} else {
				System.out
						.println("Tache non traitee! mise dans la file d'attente");
			}
		} catch (MaterielNotFoundException e) {

			System.err.println("Demande non traitee. Materiel " + nomMateriel
					+ " non trouve.");
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
		for (Tache tache : service.fileAttente) {
			if (tache.equals(nature)) {
				service.annulerDemande(tache);
				return;
			}
		}
		System.err.println("Tache " + nature + " non trouvee.");
	}

	static void menuLireXML() {
		System.out.print("Fichier XML? ");
		String path = in.next();

		XMLReader reader = null;

		try {
			reader = XMLReaderFactory
					.createXMLReader("org.apache.xerces.parsers.SAXParser");
		} catch (SAXException e) {
			System.err.println("Attention! Verifiez si le fichier est de format XML ");
			e.printStackTrace();
		}

		// Creation d'un flot XML sur le fichier d'entree

		InputSource input;
		try {
			input = new InputSource(new FileInputStream(path));
		} catch (FileNotFoundException e) {
			System.err.println("Attention! Veuillez entrer le fichier a lire");
			e.printStackTrace();
			return;
		}

		// Connexion du ContentHandler
		SIHandler handler = new SIHandler();
		reader.setContentHandler(handler);
		// Lancement du traitement...
		try {
			reader.parse(input);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		}

		service.getTableLogiciel().addAll(handler.getListLogiciels());
		service.getTableMateriel().addAll(handler.getListMateriels());

	}

	static void menuLireXMLDef() {
		System.out.print("Fichier XML? ");
		String path = "parc.xml";

		XMLReader reader = null;

		try {
			reader = XMLReaderFactory
					.createXMLReader("org.apache.xerces.parsers.SAXParser");
		} catch (SAXException e) {
			e.printStackTrace();
		}

		// Creation d'un flot XML sur le fichier d'entree

		InputSource input;
		try {
			input = new InputSource(new FileInputStream(path));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return;
		}

		// Connexion du ContentHandler
		SIHandler handler = new SIHandler();
		reader.setContentHandler(handler);
		// Lancement du traitement...
		try {
			reader.parse(input);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		}

		service.getTableLogiciel().addAll(handler.getListLogiciels());
		service.getTableMateriel().addAll(handler.getListMateriels());

		service.ajouterEmploye("cococ", "11");

	}

	static void menuSave() throws IOException {
		ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(
				PATH_DATA_FILE));
		out.writeObject(service);
		out.close();
		System.out.println("Sauvegarder avec succes.");
		

	}
	
	static void menuLoad() throws IOException, ClassNotFoundException {
		ObjectInputStream in = new ObjectInputStream(new FileInputStream(
				PATH_DATA_FILE));
		service = (ServiceInfo)in.readObject();
		in.close();
		System.out.println("Charger les donnees  avec succes.");

	}
	

	static void clean() {
		for (int i = 0; i < 100; i++) {
			System.out.print("\n");
		}
	}

}
