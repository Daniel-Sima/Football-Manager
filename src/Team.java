import java.util.ArrayList;

public class Team {
	public String name;
	protected ArrayList<Player> players = new ArrayList<Player>();
	private static final int HOME_BONUS = 60; // bonus constant du match a domicile
	private static int cpt = 0; //compteur d'index d'equipe pour gestion du schedule
	private int index;
	private boolean playHome;
/*----------------------------------------------------------------------------*/	
	public Team(String name, ArrayList<Player> tabPlayer) throws ExceptionArrayPlayerFull{
		this.name = name;
		this.index = cpt++;
		playHome = false;

		// Si probleme dans le Teams.txt ou dans l'appel du constructeur Team
		if(tabPlayer.size() > 16)
			throw new ExceptionArrayPlayerFull("Tableau de joueurs plein");

		for(int i=0; i < 16; i++)    //16 Players in a team
			players.add(tabPlayer.get(i));
		
	}
/*----------------------------------------------------------------------------*/
	public int sumAtributesTeam(){
		int total = 0;
		for(int i=0; i < 16; i++)
			total += players.get(i).sumAtributes();
		
		return total;
	}
/*----------------------------------------------------------------------------*/	
	public Team match(Team t){  // retourne l'equipe gagnate
		int totalTeam1 = this.sumAtributesTeam();
		int totalTeam2 = t.sumAtributesTeam();
		this.setPlayHome(true);
		t.setPlayHome(false);
		
		totalTeam1 += (int)(Math.random()*21);
		totalTeam2 += (int)(Math.random()*21);
		
		totalTeam1 += HOME_BONUS;  // t1 plays at home
		
		if(totalTeam1 > (totalTeam2+50)) return this; // +10 marge du match nul
		else if(totalTeam2 > (totalTeam1+50)) return t;
		else return null;  // match nul
	}
/*----------------------------------------------------------------------------*/
	public String getResult(Team t, Team winner){  // retourne le score des deux teams
		int scoreTeam1 = 0, scoreTeam2 = 0;  // pour eviter les warnings
		
		if(winner == null){ // draw
			scoreTeam1 = (int)(Math.random()*6); // 5 score max  a decider 
			scoreTeam2 = scoreTeam1;
			if(this.getPlayHome())
				return this.getTeamName()+" "+scoreTeam1+" - "+scoreTeam2+" "+t.getTeamName()+"\n";
			else
				return t.getTeamName()+" "+scoreTeam1+" - "+scoreTeam2+" "+t.getTeamName()+"\n"; 
		}
		if(winner.getPlayHome()){
			while(scoreTeam1 <= scoreTeam2){
				scoreTeam1 = (int)(Math.random()*6);
				scoreTeam2 = (int)(Math.random()*6);
			}
			if(winner == t)
				return winner.getTeamName()+" "+scoreTeam1+" - "+scoreTeam2+" "+this.getTeamName()+"\n"; 
			else
				return winner.getTeamName()+" "+scoreTeam1+" - "+scoreTeam2+" "+t.getTeamName()+"\n"; 
		}
		else{ // winner ne joue pas a domicile mais this. joue a domicile
			while(scoreTeam2 <= scoreTeam1){
				scoreTeam1 = (int)(Math.random()*6);
				scoreTeam2 = (int)(Math.random()*6);
			}
			if(winner == t)
				return this.getTeamName()+" "+scoreTeam1+" - "+scoreTeam2+" "+winner.getTeamName()+"\n"; 
			else
				return t.getTeamName()+" "+scoreTeam1+" - "+scoreTeam2+" "+winner.getTeamName()+"\n"; 
		}
	}	
/*----------------------------------------------------------------------------*/ 	
 	public String getScorersAssists(Team teamOutside, String result){  // retourne les buteurs et assists
 		String resultBis = result;
 		String[] tab = result.split(" ");
 		int scoreTeam1 = Integer.parseInt(tab[1]), scoreTeam2 = Integer.parseInt(tab[2]);
 		
 		for(int i=0; i < scoreTeam1; i++){
 			int opportunity = (int)(Math.random()*101);
 			if(opportunity >= 50) // the attackers score
 				resultBis += this.getPlayerByPosition("Offensive")+"("+getAssist()+")";
 			else if((opportunity < 50) && (opportunity >= 14)) // midfielder scores
 				resultBis += getPlayerByPosition("Midfield")+"("+getAssist()+")";
 			else if((opportunity < 14) && (opportunity >= 0)) // defenders scores
 				resultBis += getPlayerByPosition("Defensive")+"("+getAssist()+")";
 			}
 			resultBis += " || "; // a redefinir si jamais pour la lecture
 			
 			for(int i=0; i < scoreTeam2; i++){
 			int opportunity = (int)(Math.random()*101);
 			if(opportunity >= 50) // the attackers score
 				resultBis += teamOutside.getPlayerByPosition("Offensive")+"("+teamOutside.getAssist()+")";
 			else if((opportunity < 50) && (opportunity >= 14)) // midfielder scores
 				resultBis += teamOutside.getPlayerByPosition("Midfield")+"("+teamOutside.getAssist()+")";
 			else if((opportunity < 14) && (opportunity >= 0)) // defenders scores
 				resultBis += teamOutside.getPlayerByPosition("Defensive")+"("+teamOutside.getAssist()+")";
 			}
 			
 			return resultBis +"\n";
 		}
/*----------------------------------------------------------------------------*/ 		
	public String getAssist(){  // utilisé dans getScorersAssists
 		int opportunity = (int)(Math.random()*101);
 		if(opportunity >= 50) // the attackers assist
 			return getPlayerByPosition("Offensive");
 		else if((opportunity < 50) && (opportunity >= 14)) // midfielder assist
 			return this.getPlayerByPosition("Midfield");
 		else // defenders assist
 			return this.getPlayerByPosition("Defensive");
	}
/*----------------------------------------------------------------------------*/	
	public String getPlayerByPosition(String position){  // Offensive or Midfield or Defensive Player
		do{
			int i = (int)(Math.random()*16);
			if(position == "Offensive"){
				if(players.get(i) instanceof OffensivePlayer)
					return players.get(i).getName();
			}
			else if(position == "Midfield"){
				if(players.get(i) instanceof MidfieldPlayer)
					return players.get(i).getName();
			}
			else if(position == "Defensive"){
				if((players.get(i) instanceof DefensivePlayer) && !(players.get(i) instanceof Goalkeeper)) // a revoir pour les assists
					return players.get(i).getName();
			}
		}while(true); // a revoir
	}
/*----------------------------------------------------------------------------*/	
	public String getTeamName(){return name;}
/*----------------------------------------------------------------------------*/	
	public int getIndex(){return index;}
/*----------------------------------------------------------------------------*/	
	public void setPlayHome(boolean bool){
		playHome = bool;
	}
/*----------------------------------------------------------------------------*/	
	public boolean getPlayHome(){
		return playHome;
	}
/*----------------------------------------------------------------------------*/
	@Override
	public String toString(){
		String chaine = "Equipe "+name+":\n";
		for(int i=0; i < players.size(); i++){
			chaine += players.get(i)+"\n";
		}
	
		return chaine;
/*----------------------------------------------------------------------------*/
	}
}
