public class CentralDefender extends DefensivePlayer{
	private int tackles;
	private int stamina;

	public CentralDefender(String name, int number, int age, int stamina, int tackles, int pass, int mental){
		super(name,number,age,pass,mental);
		this.tackles = tackles;
		this.stamina = stamina;
	}

	public void play(Player p){

	}

	public boolean replacementChance(){
		if(stamina < 50){
			return mental < 90;
		}
		return true;
	}

	public void updateMental(TeamStatistics ts){

	}
}