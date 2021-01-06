package Player;

public class SideMidfielder extends MidfieldPlayer {

	public SideMidfielder(String name, int number, int age, int stamina, int mental, int pass, int dribble){
		super(name,number,age,stamina,pass,dribble,mental);
	}

	@Override
	public String getPos(){ return "Side Midfielder";}

	@Override
	public boolean replacementChance(){
		if(this.getStamina() < 50){
			return this.getMental() < 90;
		}
		return true;
	}
	
	@Override
	public String toString(){
		return "Side Midfielder: "+super.toString();
	}
}
