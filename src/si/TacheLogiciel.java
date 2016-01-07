package si;

import bibAgenda.Tache;

public class TacheLogiciel extends Tache {

	private static final long serialVersionUID = -1588504274612560197L;
	private Logiciel logiciel;

	public TacheLogiciel(String nature, int nbCreneaux,Logiciel logiciel) {
		super(nature, nbCreneaux);
		this.logiciel = logiciel;
	}
	
	public String toString(){
		return super.toString()+"\t"+logiciel.toString();
	}

}
