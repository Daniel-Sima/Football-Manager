public class SideMidfielder extends MidfieldPlayer{

	public SideMidfielder(String name, int number, int age, int stamina, int pass, int dribble, int mental) {
		super(name,number,age,stamina,pass,dribble,mental);
	}

	public String getPos(){return "Side Midfielder";}

	public void play(Player p){

	}

	public boolean replacementChance(){
		if(super.stamina < 50){
			return super.mental < 90;
		}
		return true;
	}

	public void updateMental(TeamStatistics ts){

	}
}