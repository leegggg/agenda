package si;



public class Materiel extends Ressource {
	
	private static final long serialVersionUID = -8673490206307555698L;
	public String marque;
	public String processeur;
	public String hd;
	public String ram;
	
	
	
	public Materiel(String nom, String marque, String processeur, String hd,String ram) {
		super(nom);
		this.marque = marque;
		this.processeur = processeur;
		this.hd = hd;
		this.ram = ram;
	}
	public boolean equals(String nom){
	      return nom.equals(this.getNom());
	}
	public String toString(){
		return getNom()+"\t"+marque+"\t"+processeur;
	}


}
