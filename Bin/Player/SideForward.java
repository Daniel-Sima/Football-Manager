public class SideForward extends OffensivePlayer{

	public SideForward(String name, int number, int age, int stamina, int mental, int finish, int dribble) {
		super(name, number, age, stamina, mental, finish, dribble);
	}

	@Override
	public String getPos(){return "Side Forward";}

	@Override
	public boolean replacementChance(){
		if(this.getStamina() < 50){
			return this.getMental() < 90;
		}
		return true;
	}

	@Override
	public void updateMental(Team t){

	}
	
	@Override
	public String toString(){
		return "Side Forward: "+super.toString();
	}
}
