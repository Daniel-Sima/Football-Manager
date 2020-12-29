public class CentralMidfielder extends MidfieldPlayer{

	public CentralMidfielder(String name, int number, int age, int stamina, int pass, int dribble, int mental) {
		super(name,number,age,stamina,pass,dribble,mental);
	}

	public String getPos(){return "Central Midfielder";}

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