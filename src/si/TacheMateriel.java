package si;

import bibAgenda.Tache;

public class TacheMateriel extends Tache {

	private static final long serialVersionUID = -7836820648978100743L;
	private Materiel materiel;

	public TacheMateriel(String nature, int nbCreneaux,Materiel materiel) {
		super(nature, nbCreneaux);
		this.materiel = materiel;
	}
	public String toString(){
		return super.toString()+"\t"+materiel.toString();
	}

}
