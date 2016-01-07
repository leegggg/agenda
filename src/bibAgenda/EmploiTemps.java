package bibAgenda;

import java.io.Serializable;

public class EmploiTemps implements Serializable {

	private static final long serialVersionUID = -6333767205805379664L;
	static final int nbCreneauJour = 8;
	static final int nbJour = 5;
	public Tache[][] tableTache;

	public EmploiTemps() {
		tableTache = new Tache[nbJour][nbCreneauJour];
		for (int ptJour = 0; ptJour < nbJour; ptJour++) {
			for (int ptCre = 0; ptCre < nbCreneauJour; ptCre++) {
				tableTache[ptJour][ptCre] = null;
			}
		}
	}

	public boolean ajouterTache(Tache tache) {
		int nbCreneauDispo = 0;
		int ptJour = 0;
		int ptCre = 0;

		while (ptJour < nbJour) {
			nbCreneauDispo = 0;
			ptCre = 0;
			while (ptCre < nbCreneauJour) {
				if (tableTache[ptJour][ptCre] == null) {
					// donc ici le creneau est libre
					nbCreneauDispo++;
					if (nbCreneauDispo >= tache.nbCreneaux) {
						tableTache[ptJour][ptCre - tache.nbCreneaux + 1] = tache;
						return true;
					}
					ptCre++;
				} else {
					nbCreneauDispo = 0;
					ptCre += tableTache[ptJour][ptCre].nbCreneaux;
				}
			}
			ptJour++;
		}
		return false;

	}

	public String toString() {
		String strRet = "jour\thour\tlongeur\tnature\n";
		for (int ptJour = 0; ptJour < nbJour; ptJour++) {
			for (int ptCre = 0; ptCre < nbCreneauJour; ptCre++) {
				if (tableTache[ptJour][ptCre] != null) {
					strRet = strRet + (ptJour + 1) + "\t" + (ptCre + 8) + "\t"
							+ tableTache[ptJour][ptCre].toString() + "\n";
				}
			}
		}
		return strRet;

	}

	public boolean annulerDemande(Tache tache) {
		//System.out.println("a annuler: "+tache);

		for (int ptJour = 0; ptJour < nbJour; ptJour++) {
			for (int ptCre = 0; ptCre < nbCreneauJour; ptCre++) {
				if (tache.equals(tableTache[ptJour][ptCre])) {
					tableTache[ptJour][ptCre] = null;
					return true;
				}
			}
		}
		return false;

	}

}