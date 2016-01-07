package si;

import java.io.Serializable;

abstract public class Ressource  implements Serializable{

	private static final long serialVersionUID = 3147239367020741353L;
	private String nom;

	public Ressource(String nom) {
		this.nom = nom;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

}