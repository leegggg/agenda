package bibAgenda;

abstract public class Ressource {
  public String nomRes;
  public String numRes;

  public EmploiTemps emploiTemps;
	
	public Ressource(String nom, String num){
		nomRes = nom;
		numRes = num;
  
		emploiTemps = new EmploiTemps();
  }
	public String getNumRes(){
		return numRes;
	}
	

	public String getNomRes(){
		return nomRes;
	}
	
	public boolean verifier(int jour,int creneau,int nbCreneaux){
		return emploiTemps.verifier(jour,creneau,nbCreneaux);
		
	}
	
	
	public void ajouterTache(int jour,int creneau,Tache tache){
	  emploiTemps.ajouterTache(jour, creneau, tache);  
  }

	public String toString(){
		return getNumRes()+"  "+getNomRes();
	}

		
	

}