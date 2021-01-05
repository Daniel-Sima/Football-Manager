public class CentralMidfielder extends MidfieldPlayer {

	public CentralMidfielder(String name, int number, int age, int stamina, int mental, int pass, int dribble){
		super(name,number,age,stamina,pass,dribble,mental);
	}
	
	@Override
	public String getPos(){ return "Central Midfielder";}

	@Override
	public boolean replacementChance(){
		if(this.getStamina() < 50){
			return this.getMental() < 90;
		}
		return true;
	}
	
	@Override
	public String toString(){
		return "Central Midfielder: "+super.toString();
	}
}
