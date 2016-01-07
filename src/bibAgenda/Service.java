package bibAgenda;

import java.io.Serializable;
import java.util.*;


public class Service implements Serializable{

	private static final long serialVersionUID = -4744540515311124371L;
	public List<Employe> tableEmploye;
	public List<Tache> tableTacheAffectes;

	
	
	public Service(){
		tableEmploye = new ArrayList<Employe>();
		tableTacheAffectes = new ArrayList<Tache>();
	}
	
	
	public boolean ajouterEmploye(String nom,String num){
		return tableEmploye.add(new Employe(nom,num));
	}
	
	public List<Employe> getListeEmploye(){
		
		return this.tableEmploye;
		
	}
	
	public EmploiTemps getEmploiTemps(Employe employe){
		return employe.getEmploiTemps();
	}
	
	
	public List<EmploiTemps> getEmploiTemps(){
		List<EmploiTemps> liste = new ArrayList<EmploiTemps>();
		for (Employe e : tableEmploye)
		{
			liste.add(e.getEmploiTemps());
		}
		return liste;		
	}
	
	
	public Tache traiterDemande(String nature,int nbCreneaux){
		Tache tache = new Tache(nature,nbCreneaux);
		return traiterDemande(tache);

	}
	
	public Tache traiterDemande(Tache tache){
		for (Employe E : tableEmploye){
			if(E.ajouterTache(tache)){
				tableTacheAffectes.add(tache);
				return tache;
			}
		}
		return null;	
	}
	
	
	public boolean annulerDemande(Tache tache){
		for (Employe E : tableEmploye){
			if(E.annulerDemande(tache)){
				tableTacheAffectes.remove(tache);
				return true;
			}
		}		
		return false;
	}
}