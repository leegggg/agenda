package entretien;

import java.util.ArrayList;

import bibAgenda.Service;
import bibAgenda.Tache;

public class ServiceEntretien extends Service {
	public int capaciteInitSalle = 16;
	
	public ArrayList<Salle> tableSalle;
	public ServiceEntretien() {
		super();
		tableSalle = new ArrayList<Salle>(capaciteInitSalle);
	}
	
	public boolean ajouterSalle(String nom,String num){
		return tableSalle.add(new Salle(nom,num));
	}
	
	public Tache ajouterTache(String nature,int nbCreneaux,String numSalle){
		Salle salle = null;
		for(Salle s : tableSalle){
			if(s.getNumRes().equals(numSalle)){
				salle = s;
			}
		}
		if(salle == null){
			return null;
		}
		Tache tache = new Tache(nature,nbCreneaux);
		tache.tableRessource.add(salle);
		tableTache.add(tache);
		return tache;		
	}
	
	
	
	public boolean traiterDemande(String nature,int nbCreneaux,String numSalle){
		return traiterDemande(ajouterTache(nature,nbCreneaux,numSalle));
	}
}
