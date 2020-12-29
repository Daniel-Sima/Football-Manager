import java.util.ArrayList;

public class Team implements TeamLogo, TacticBoard{
	private String name;
	protected ArrayList<Player> mainPlayers = new ArrayList<Player>();
	protected ArrayList<Player> reservePlayers = new ArrayList<Player>();

	public Team(String name, ArrayList<Player> tabPlayer) {
		this.name = name;
		for(int i=0; i < 11; i++){
			mainPlayers.add(tabPlayer.get(i));
		}
		for(int i=11; i < tabPlayer.size(); i++) {
			mainPlayers.add(tabPlayer.get(i));
		}
	}

	public String getName(){return name;}

	public boolean isMainPlayer(Player p){
		return mainPlayers.contains(p);
	}

	public boolean isReservePlayer(Player p){
		return reservePlayers.contains(p);
	}

	public String toString(){
		String chaine = "Equipe type : \n";
		for(int i=0; i < mainPlayers.size(); i++){
			Player p = mainPlayers.get(i);
			chaine += p.getName()+" "+p.getNumber()+" : "+p.getPos()+"\n";
		}
		chaine += "\nReserve : \n";
		for(int i=0; i < reservePlayers.size(); i++){
			Player p = reservePlayers.get(i);
			chaine += p.getName()+" "+p.getNumber()+" : "+p.getPos()+"\n";
		}
	}
}