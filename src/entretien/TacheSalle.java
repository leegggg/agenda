package entretien;

import bibAgenda.Tache;

public class TacheSalle extends Tache {

	private static final long serialVersionUID = 5316833824730858910L;
	public Salle salle; 

	public TacheSalle(String nature, int nbCreneaux,Salle salle) {
		super(nature, nbCreneaux);
		this.salle = salle;
	}

}
