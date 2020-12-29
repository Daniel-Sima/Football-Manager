public class Goalkeeper extends DefensivePlayer{
	private int reflexes;

	public Goalkeeper(String name, int number, int age, int reflexes, int pass, int mental){
		super(name,number,age,pass,mental);
		this.reflexes = reflexes;
	}

	public String getPos(){return "Goalkeeper";}

	public int getReflexes(){return reflexes;}

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