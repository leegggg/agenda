package entretien;
import bibAgenda.Ressource;


public class Salle extends Ressource {
	
	public Salle(String nom, String num) {
		super(nom, num);
	}
  public Salle(String nom) {
		super(nom, nom);
	}

}