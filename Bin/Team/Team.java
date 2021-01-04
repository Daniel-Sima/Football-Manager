import java.util.ArrayList;

public class Team{ //implements TeamLogo, TacticBoard{
	private String name;
	private ArrayList<Player> players = new ArrayList<Player>();
	private final int HOME_BONUS = 5; // static final ?? 

	public Team(String name, ArrayList<Player> tabPlayer){
		this.name = name;
		for(int i=0; i < 16; i++)    //16 Players in a team
			players.add(tabPlayer.get(i));
	}

	public int sumAtributesTeam(){
		int total = 0;
		for(int i=0; i < 16; i++)
			total += players.get(i).sumAtributes();
		
		return total;
	}
	
	public Team match(Team t1, Team t2){  // retourne l'equipe gagnate
		int totalTeam1 = t1.sumAtributesTeam();
		int totalTeam2 = t2.sumAtributesTeam();
		
		totalTeam1 += (int)(Math.random()*21);
		totalTeam2 += (int)(Math.random()*21);
		
		totalTeam1 += HOME_BONUS;  // t1 plays at home
		
		if(totalTeam1 > (totalTeam2+10)) return t1; // +10 marge du match nul
		else if(totalTeam2 > (totalTeam1+10)) return t2;
		else return null;  // match nul
	}
		
		
		
	public String getTeamName(){ return name;}

	@Override
	public String toString(){
		String chaine = "Equipe "+name+":\n";
		for(int i=0; i < players.size(); i++){
			chaine += players.get(i)+"\n";
		}
	
		return chaine;
	}
}
