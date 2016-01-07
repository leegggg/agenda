package bibAgenda;

import java.io.Serializable;

public class Employe implements Serializable {


	private static final long serialVersionUID = 4260295417624210863L;
	private String nom;
	private String num;
	public EmploiTemps emploiTemps;


	public Employe(String nom, String num) {
		this.nom = nom;
		this.num = num;
		emploiTemps = new EmploiTemps();
	}


	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getNum() {
		return num;
	}

	public void setNum(String num) {
		this.num = num;
	}
	
	public EmploiTemps getEmploiTemps() {
		return emploiTemps;
	}
	
	



	public boolean ajouterTache(Tache tache) {
		return emploiTemps.ajouterTache(tache);
	}
	
	public boolean annulerDemande(Tache tache) {
		return emploiTemps.annulerDemande(tache);
	}

	public String toString() {
		return getNum() + "\t" + getNom();
	}

}
