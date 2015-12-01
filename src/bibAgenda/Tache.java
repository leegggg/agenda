package bibAgenda;

import java.util.*;


public class Tache{
  public String nature;
  public int nbCreneaux;
  public int etat;
	public int capaciteInitRes = 3;
	public ArrayList<Ressource> tableRessource;
  //public Employe employe;
  //public Service service;
   

  public boolean verifier(int jour,int creneau){
		boolean res = true;
		for(Ressource R:tableRessource){
			res = res&&R.verifier(jour,creneau,nbCreneaux);
		}
		return res;
	}
  
  public void addEmploiTempsRessource(int jour,int creneau){
		for(Ressource R:tableRessource){
			R.emploiTemps.ajouterTache(jour, creneau, this);
		}
	}
//methodes a programmer	 
  public Tache(String nat, int nbc){
		tableRessource = new ArrayList<Ressource>(capaciteInitRes);
    nature = nat;
    nbCreneaux = nbc;
    etat = 0;
    //Employe = null;
  }
	//annuler
	public boolean annuler(){
		boolean res = (etat!=-1);
		etat = -1;
		return res;
	}
	
	public String toString(){
		String res = nbCreneaux+"  "+nature+"  ";

		for(Ressource r: tableRessource){
			res+=r.toString();			
		}
		return res;
		
	}
	
	

}