package bibAgenda;

public class Application {
 public static void main(String[] argv) {

	Service service = new Service();
	
	
	service.ajouterEmploye("lin","0");
	service.ajouterEmploye("chen","1");
	for(int i = 0;i<=30;i++){
		
		if(service.traiterDemande("test"+i,i%5+1)){
			System.out.println("Add  "+"test"+i+"  "+i%5+1);
		}else{
			System.out.println("FAL  "+"test"+i+"  "+i%5+1);
		}
		if(i%6 == 4){
		  service.annulerDemande(service.tableTache.get(i-3));
			System.out.println("ANU  "+service.tableTache.get(i-3).toString());
		}
	}
	
	
	System.out.println(service.listeEmploye());
	System.out.println(service.getStringEmploiTemps());
	System.out.println(service.tableEmploye.get(1).emploiTemps.verifier(4,0,4));
	System.out.println(service.tableEmploye.get(1).emploiTemps.verifier(4,2,4));
	System.out.println(service.tableEmploye.get(1).emploiTemps.verifier(4,4,4));
	System.out.println(service.tableEmploye.get(1).emploiTemps.verifier(4,5,4));
	System.out.println(service.tableEmploye.get(1).emploiTemps.verifier(4,6,1));
	System.out.println(service.tableEmploye.get(1).emploiTemps.verifier(4,5,2));
	System.out.println(service.tableEmploye.get(1).emploiTemps.verifier(4,5,3));
	System.out.println(service.tableEmploye.get(1).emploiTemps.verifier(4,5,4));
	System.out.println(service.tableEmploye.get(1).emploiTemps.verifier(4,5,5));
	System.out.println(service.tableEmploye.get(1).emploiTemps.verifier(4,5,6));
	//Ranger des ouvrages:

	//Permettre a l'utilisateur d'emprunter/retourner un ouvrage
	//en demandant son code.
	//Transformer les exceptions en message d'erreur.
 }
}


/*

import java.util.*;


public class Service{
	public int capaciteInitEmploye = 16;
	public int capaciteInitTache = 16;
	public ArrayList<Employe> tableEmploye;
	public ArrayList<Tache> tableTache;
	
	
	public Service(){
		tableEmploye = new ArrayList<Employe>(capaciteInitEmploye);
		tableTache = new ArrayList<Tache>(capaciteInitTache);
		
		
	}
	
	
	public boolean ajouterEmploye(String nom,int num){
		return tableEmploye.add(new Employe(nom,num));
	}
	
	public String listeEmploye(){
		String liste = "";
		for (Employe E : tableEmploye)
		{
			liste=liste+E.getNumEmp()+":\t"+E.nomEmp+"\n";
		}
		
		return liste;
		
	}
	
	public String getStringEmploiTemps(Employe employe){
		return employe.emploiTemps.toString();
	}
	
	
	public String getStringEmploiTemps(){
		String liste = "";
		for (Employe E : tableEmploye)
		{
			liste=liste+E.getNumEmp()+":\t"+E.nomEmp+"\n"+getStringEmploiTemps(E)+"\n";
		}
		
		return liste;		
	}
	
	
	public boolean traiterDemande(String nature,int nbCreneaux){
		Tache tache = new Tache(nature,nbCreneaux);
		tableTache.add(tache);
		boolean flagTraiter = false;
		for (Employe E : tableEmploye){
			if(E.ajouterTache(tache)){
				flagTraiter = true;
			}
		}
		return flagTraiter;
	}
	
	
	public void annulerDemande(Tache tache){
		tache.annuler();		
	}
	
	
}




*/