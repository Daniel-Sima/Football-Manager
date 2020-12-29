public class CentralForward extends OffensivePlayer{

	public CentralForward(String name, int number, int age, int stamina, int finish, int dribble, int mental){
		super(name,number,age,stamina,finish,dribble,mental);
	}

	public String getPos(){return "Central Forward";}

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