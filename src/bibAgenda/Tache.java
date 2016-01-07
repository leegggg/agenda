package bibAgenda;

import java.io.Serializable;

public class Tache implements Serializable {

	private static final long serialVersionUID = 5729248042669755683L;
	public String nature;
	public int nbCreneaux;

	// methodes a programmer
	public Tache(String nature, int nbCreneaux) {

		this.nature = nature;
		this.nbCreneaux = nbCreneaux;
	}
	// annuler

	public String toString() {
		String res = nbCreneaux + "\t" + nature;

		return res;

	}

	public boolean equals(String nature) {
		return this.nature == nature;
	}

}