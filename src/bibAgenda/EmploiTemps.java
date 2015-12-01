package bibAgenda;


public class EmploiTemps{
  static final int nbCreneauJour = 8;
  static final int nbJour = 5;
  public Tache[][] tableTache;
  

  public EmploiTemps(){
		tableTache = new Tache[nbJour][nbCreneauJour];
    for(int ptJour = 0;ptJour<nbJour;ptJour++){
      for(int ptCre = 0;ptCre<nbCreneauJour;ptCre++){
				tableTache[ptJour][ptCre] = null;
      }
    }
		//System.out.println(tableTache[1].length);
  }
	
	public boolean verifier(int jour,int creneau,int nbCreneaux){
		System.out.println("-------");
		//boolean res = true;
		Tache[] tableTacheToday = tableTache[jour];
		int ptCre = creneau;
		Tache lastTache = null;
		//tache avant
		while(ptCre>=0&&lastTache==null){
			if(tableTacheToday[ptCre]!=null&&tableTacheToday[ptCre].etat!=-1){
				lastTache = tableTacheToday[ptCre];
			}
			ptCre--;
		}
		if(lastTache!=null){
			if(creneau<=ptCre+lastTache.nbCreneaux){
				return false;
			}
		}
		//tache apres
		System.out.println("jour="+jour+"  creneau"+creneau+"  nbCreneaux"+nbCreneaux);
		//System.out.println(nbCreneauJour);
		if(creneau+nbCreneaux>nbCreneauJour){
			return false;
		}
		for(int i = 0;i<nbCreneaux;i++){
			//il existe une tache est il n'est pas annuele
			if(tableTacheToday[creneau+i]!=null && tableTacheToday[creneau+i].etat!=-1){
				return false;
			}
		}
		
		return true;		
	}
	
	
  
  public boolean ajouterTache(Tache tache){
    int nbLibre = 0;
    int ptJour = 0;
    int ptCre = 0;
		boolean flagTrouve = false;
    while((!flagTrouve)&&(ptJour<nbJour)){
			nbLibre = 0;
			ptCre = 0;
			while((!flagTrouve)&&(ptCre<nbCreneauJour)){
				if(tableTache[ptJour][ptCre]==null || tableTache[ptJour][ptCre].etat == -1){
					//donc ici le creneau est libre ou la tache a ete annuele
					nbLibre++;
					if(nbLibre>=tache.nbCreneaux&&tache.verifier(ptJour,ptCre-tache.nbCreneaux+1)){
						tableTache[ptJour][ptCre-tache.nbCreneaux+1] = tache;
						tache.etat = 1;
						flagTrouve = true;
					}
					ptCre++;
				}else{
					nbLibre = 0;
					ptCre += tableTache[ptJour][ptCre].nbCreneaux;
				}
			}
			ptJour++;
		}
		//System.out.println(flagTrouve+tache.nature);
		return flagTrouve;
  
  }
  
  
  public void ajouterTache(int jour,int creneau,Tache tache){
	  tableTache[jour][creneau] = tache;	  
  }
	
	public String toString(){
		String strRet = "j\th\tl\ttache\n";
		for(int ptJour = 0;ptJour<nbJour;ptJour++){
			for(int ptCre = 0;ptCre<nbCreneauJour;ptCre++){
				if(tableTache[ptJour][ptCre]!=null){
					strRet = strRet + (ptJour+1) +"\t"+ (ptCre+8)+"\t"+tableTache[ptJour][ptCre].toString()+"\n";
				}
			}
		}
		return strRet;
	
	
	}
	
	
	
	


}