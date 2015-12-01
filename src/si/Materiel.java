package si;

import bibAgenda.Ressource;

public class Materiel extends Ressource {
	
	public String marque;
	public String processeur;
	public String hd;
	public int ram;
	public Materiel(String nom, String num,String mark,String proc,String hdd,int r) {
		super(nom, num);
		marque = mark;
		processeur = proc;
		hd = hdd;
		ram = r;
		// TODO Auto-generated constructor stub
	}

}
