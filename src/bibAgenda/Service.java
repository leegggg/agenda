package bibAgenda;

import java.util.*;


public class Service{
	public int capaciteInitEmploye = 16;
	public int capaciteInitTache = 16;
	public ArrayList<Employe> tableEmploye;
	public ArrayList<Tache> tableTache;
	
	
	public Service(){
		tableEmploye = new ArrayList<Employe>(capaciteInitEmploye);
		tableTache = new ArrayList<Tache>(capaciteInitTache);
		
		
	}
	
	
	public boolean ajouterEmploye(String nom,String num){
		return tableEmploye.add(new Employe(nom,num));
	}
	
	public String listeEmploye(){
		String liste = "";
		for (Employe E : tableEmploye)
		{
			liste=liste+E.toString()+"\n";
		}
		
		return liste;
		
	}
	
	public String getStringEmploiTemps(Employe employe){
		return employe.emploiTemps.toString();
	}
	
	
	public String getStringEmploiTemps(){
		String liste = "";
		for (Employe E : tableEmploye)
		{
			liste=liste+E.toString()+"\n"+getStringEmploiTemps(E)+"\n";
		}
		
		return liste;		
	}
	
	public boolean traiterDemande(String nature,int nbCreneaux){
		return traiterDemande(ajouterTache(nature,nbCreneaux));
	}
	
	
	public Tache ajouterTache(String nature,int nbCreneaux){
		Tache tache = new Tache(nature,nbCreneaux);
		tableTache.add(tache);
		return tache;
	}
	
	
	public boolean traiterDemande(Tache tache){
		if(tache==null){
			return false;
		}
		boolean flagTraiter = false;
		for (Employe E : tableEmploye){
			if(E.ajouterTache(tache)){
				flagTraiter = true;
				break;
			}
		}
		if(!flagTraiter){
			annulerDemande(tache);
		}
		return flagTraiter;
	}
	
	
	public boolean annulerDemande(Tache tache){
		return tache.annuler();
	}
	
	
}