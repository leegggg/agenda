package bibAgenda;


public class Employe extends Ressource {

   
//	static final int TODAY = 20151118;
//	protected Map<String,Ouvrage> ouvrages = new TreeMap<String,Ouvrage>();
//	protected ArrayList<Ouvrage> alouvrages= new ArrayList<Ouvrage>(ouvrages.values());


//methodes a programmer	 

  public Employe(String nom, String num){
		super(nom,num);
  }
	
	public boolean ajouterTache(Tache tache){
		return emploiTemps.ajouterTache(tache);
	}
	
	public String getNumEmp(){
		return getNumRes();
	}
	
	
	public String getNomEmp(){
		return getNomRes();
	}
	
	public String toString(){
		return getNumEmp()+"\t"+getNomEmp();
	}
	//provoque l'exception OuvrageInconnuException si le code d'ouvrage n'existe pas
}


