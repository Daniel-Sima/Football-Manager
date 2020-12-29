public class SideForward extends OffensivePlayer{

	public SideForward(String name, int number, int age, int stamina, int finish, int dribble, int mental){
		super(name,number,age,stamina,finish,dribble,mental);
	}

	public String getPos(){return "Side Forward";}

	public void play(DefensivePlayer p){
		
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