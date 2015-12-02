package si;

import bibAgenda.Ressource;

public class Materiel extends Ressource {
	
	public String marque;
	public String processeur;
	public String hd;
	public int ram;
	public Materiel(String nom, String num,String marque,String proc,String hdd,int tailleRAM) {
		super(nom, num);
		this.marque = marque;
		processeur = proc;
		hd = hdd;
		ram = tailleRAM;
	}
	
	public Materiel(String nom,String mark,String proc,String hdd,int tailleRAM) {
	  this(nom, nom,mark,proc,hdd,tailleRAM);
	}
	
  
}
