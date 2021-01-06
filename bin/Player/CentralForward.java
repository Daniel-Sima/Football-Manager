package Player;

public class CentralForward extends OffensivePlayer {

	public CentralForward(String name, int number, int age, int stamina, int mental, int finish, int dribble){
		super(name, number, age, stamina, mental, finish, dribble);;
	}

	@Override
	public String getPos(){ return "Central Forward";}

	@Override
	public boolean replacementChance(){
		if(this.getStamina() < 50){
			return getMental() < 90;  // ou this.getMental() ??? 
		}
		return true;
	}

	@Override
	public String toString(){
		return "Central Forward: "+super.toString();
	}

}
