package bibAgenda;

import java.util.*;


public class Tache{
  public String nature;
  public int nbCreneaux;
  public int etat;
	//public int capaciteInitRes = 3;
	public List<Ressource> tableRessource;
  //public Employe employe;
  //public Service service;
	
	public static boolean exist(Tache t){
		return (t!=null)&&(t.etat!=-1);
	}
   

  public boolean verifier(int jour,int creneau){
		boolean res = true;
		for(Ressource R:tableRessource){
			res = res&&R.verifier(jour,creneau,nbCreneaux);
		}
		return res;
	}
  
  public void addEmploiTempsRessource(int jour,int creneau){
		for(Ressource r:tableRessource){
			r.emploiTemps.ajouterTache(jour, creneau, this);
		}
	}
//methodes a programmer	 
  public Tache(String nat, int nbc){
		tableRessource = new ArrayList<Ressource>();
    nature = nat;
    nbCreneaux = nbc;
    etat = 0;
    //Employe = null;
  }
	//annuler
	public boolean annuler(){
		boolean res = (etat==0);
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