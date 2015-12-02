package si;
import bibAgenda.*;

public class Logiciel extends Ressource {
	public String version;
	public String taille;
	public String date;
	public String editeur;
	public Logiciel(String nom, String num,String ver,String tai,String da,String edit) {
		super(nom, num);
		version = ver;
		taille = tai;
		date = da;
		editeur = edit;
	}	
	
	public Logiciel(String nom,String version,String taille,String data,String editeur) {
	  this(nom,num,ver,tai,da,edit);
	}

}
