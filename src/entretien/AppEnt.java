package entretien;

import entretien.ServiceEntretien;

public class AppEnt {

	public static void main(String[] args) {

		ServiceEntretien service = new ServiceEntretien();
		
		
		service.ajouterEmploye("lin","0");
		service.ajouterEmploye("chen","1");
		service.ajouterSalle("B301","1");
		service.ajouterSalle("C101","2");
		for(int i = 0;i<=70;i++){
			
			if(service.traiterDemande("test"+i,i%5+1,Integer.toString(i%2+1))){
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
