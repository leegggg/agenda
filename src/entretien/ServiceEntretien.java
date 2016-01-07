package entretien;
import java.util.ArrayList;
import java.util.List;

import bibAgenda.Service;


public class ServiceEntretien extends Service {

	

	private static final long serialVersionUID = -3678954995401306818L;
	public List<Salle> tableSalle;
	public ServiceEntretien() {
		super();
		tableSalle = new ArrayList<Salle>();
	}
	
	public boolean ajouterSalle(String numSalle){
		return tableSalle.add(new Salle(numSalle));
	}
	
	
	
	public TacheSalle traiterDemande(String nature,int nbCreneaux,String numSalle)throws SalleNotFoundException{
		Salle salle = null;
		for(Salle s : tableSalle){
			if(s.getNumSalle().equals(numSalle)){
				salle = s;
			}
		}
		if(salle == null){
			throw new SalleNotFoundException();
		}
		
		TacheSalle tache = new TacheSalle(nature,nbCreneaux,salle);
		return (TacheSalle) traiterDemande(tache);
	}

	public List<Salle> getTableSalle() {
		return tableSalle;
	}


}
