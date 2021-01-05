public class Goalkeeper extends DefensivePlayer {
	private int reflexes;

	public Goalkeeper(String name, int number, int age, int stamina, int reflexes, int pass, int mental){
		super(name, number, age, stamina, mental, pass);
		this.reflexes = reflexes;
	}

	@Override
	public String getPos(){return "Goalkeeper";}

	public int getReflexes(){return reflexes;}

	@Override
	public boolean replacementChance(){
		if(this.getStamina() < 50){
			return getMental() < 90;
		}
		return true;
	}
	
	@Override
	public String toString(){
		return "Goalkeeper: "+super.toString()+"||Reflexes :"+reflexes;	
	}
	
	@Override 
	public int sumAtributes(){
		return this.getReflexes() + this.getPass() + this.getMental() + this.getStamina();
	}
}
