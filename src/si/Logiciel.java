package si;


public class Logiciel extends Ressource {

	private static final long serialVersionUID = 8628584054795861963L;
	public String version;
	public String taille;
	public String date;
	public String editeur;

	
	public Logiciel(String nom, String version, String taille, String date, String editeur) {
		super(nom);
		this.version = version;
		this.taille = taille;
		this.date = date;
		this.editeur = editeur;
	}
	
	public boolean equals(String nom,String version){
	      return ((nom.equals(this.getNom()))&&(version.equals(this.version)));
	}
	
	public String toString(){
		return getNom()+"\t"+version;
	}


}
