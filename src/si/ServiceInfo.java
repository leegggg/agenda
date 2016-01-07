package si;


import java.util.ArrayList;
import java.util.List;

import bibAgenda.Service;
import bibAgenda.Tache;

public class ServiceInfo extends Service{


	private static final long serialVersionUID = -2173029530081379256L;
	public List<Logiciel> tableLogiciel;
	public List<Materiel> tableMateriel;
	public List<TacheMateriel> fileAttente;// liste d`attente taches materielles
	
	
	
	
	
	public List<Logiciel> getTableLogiciel() {
		return tableLogiciel;
	}

	public List<Materiel> getTableMateriel() {
		return tableMateriel;
	}

	public List<TacheMateriel> getFileAttente() {
		return fileAttente;
	}

	public ServiceInfo() {
		super();
		this.tableLogiciel = new ArrayList<Logiciel>();
		this.tableMateriel = new ArrayList<Materiel>();
		this.fileAttente = new ArrayList<TacheMateriel>();
	}	
	
	public boolean ajouterMateriel(String nom,String marque,String processeur,String hd,String ram){
		return tableMateriel.add(new Materiel( nom,marque,processeur,hd,ram));
	}
	
	
	public boolean ajouterLogiciel(String nom,String version,String taille,String date,String editeur){
		return tableLogiciel.add(new Logiciel(nom,version,taille,date,editeur));
	}
	
	
	public TacheLogiciel traiterDemandeLogiciel(String nature,int nbCreneaux,String nomLogiciel,String version) throws LogicielNotFoundException{
		Logiciel logiciel = null;
		for(Logiciel l : tableLogiciel){
			if(l.equals(nomLogiciel,version)){
				logiciel = l;
				break;
			}
		}
		if(logiciel == null){
			throw new LogicielNotFoundException();
		}
		TacheLogiciel tache = new TacheLogiciel(nature, nbCreneaux, logiciel);
		return (TacheLogiciel) traiterDemande(tache);
	}
	
	
	
	
	public TacheMateriel traiterDemandeMateriel(String nature,int nbCreneaux,String nomMateriel) throws MaterielNotFoundException{
		Materiel materiel = null;
		for(Materiel m : tableMateriel){
			if(m.equals(nomMateriel) ){
				materiel = m;
				break;
			}
		}
		if(materiel == null){
			throw new MaterielNotFoundException();
		}
		
		TacheMateriel tache = new TacheMateriel(nature, nbCreneaux, materiel);
		TacheMateriel tacheTraite =  (TacheMateriel) traiterDemande(tache);
		if(tacheTraite==null){
			this.fileAttente.add(tache);
		}
		return tacheTraite;
		
	}
	
	public boolean annulerDemande(Tache tache){
		if(!super.annulerDemande(tache)){ 
			if(tache instanceof TacheMateriel){
				fileAttente.remove(tache);
			}
		}
		
		List<TacheMateriel> tacheTraite = new ArrayList<TacheMateriel>();
		for(TacheMateriel tm:fileAttente){
			if(traiterDemande(tm)!=null){
				tacheTraite.add(tm);
			}
		}
		
		for(TacheMateriel tm:tacheTraite){
			fileAttente.remove(tm);
		}
		return true;
	}
	
	

}
