package si;


import java.util.ArrayList;

import bibAgenda.Service;
import bibAgenda.Tache;

public class ServiceInfo extends Service {
	public int capaciteInitLogiciel = 16;
	public int capaciteInitMateriel = 16;
	public ArrayList<Logiciel> tableLogiciel;
	public ArrayList<Materiel> tableMateriel;
	
	
	
	public boolean ajouterMateriel(String nom, String num,String mark,String proc,String hdd,int r){
		return tableMateriel.add(new Materiel(nom, num,mark,proc,hdd,r));
	}
	
	
	public boolean ajouterLogiciel(String nom, String num,String ver,String tai,String da,String edit){
		return tableLogiciel.add(new Logiciel(nom, num,ver,tai,da,edit));
	}
	//TODO ajouter logic ver edit
	public Tache ajouterTacheLogiciel(String nature,int nbCreneaux,String numLogiciel){
		Logiciel logiciel = null;
		for(Logiciel l : tableLogiciel){
			if(l.getNumRes().equals(numLogiciel)){
				logiciel = l;
				break;
			}
		}
		Tache tache = new Tache(nature,nbCreneaux);
		tache.tableRessource.add(logiciel);
		tableTache.add(tache);
		return tache;		
	}
	
	
	public boolean traiterDemandeLogiciel(String nature,int nbCreneaux,String numLogiciel){
		return traiterDemande(ajouterTacheLogiciel(nature,nbCreneaux,numLogiciel));
		
	}
	
	
	public Tache ajouterTacheMateriel(String nature,int nbCreneaux,String numMateriel){
		Materiel materiel = null;
		for(Materiel m : tableMateriel){
			if(m.getNumRes().equals(numMateriel) ){
				materiel = m;
				break;
			}
		}
		//to do return null
		Tache tache = new Tache(nature,nbCreneaux);
		tache.tableRessource.add(materiel);
		tableTache.add(tache);
		return tache;		
	}
	
	
	
	public boolean traiterDemandeMateriel(String nature,int nbCreneaux,String numMateriel){
		Tache tache = ajouterTacheMateriel(nature,nbCreneaux,numMateriel);
		if(tache==null){
			return false;
		}
		boolean res = traiterDemande(tache);
		if(!res){
			tache.etat = 0;
		}
		return res;	
	}
	
	public boolean annulerDemande(Tache tache){
		boolean res =  tache.annuler();
		if(res){
			//traiter file d'attente
			for(Tache t: tableTache){
				if(t.etat == 0 ){
					if(!traiterDemande(t)){
						t.etat = 0;
					}
				}
			}
		}
		return res;
	}
	
	

}
