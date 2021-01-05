public class Fullback extends DefensivePlayer {
	private int tackles;

	public Fullback(String name, int number, int age, int stamina, int mental, int pass, int tackles){
		super(name, number, age, stamina, mental, pass);
		this.tackles = tackles;
	}
	
	@Override
	public String getPos(){return "Fullback";}

	@Override
	public boolean replacementChance(){
		if(this.getStamina() < 50){
			return this.getMental() < 90;
		}
		return true;
	}
	
	@Override
	public String toString(){
		return "Fullback: "+super.toString()+"||Tackles :"+tackles;	
	}

	public int getTackles(){
		return tackles;
	}
	
	@Override
	public int sumAtributes(){
		return this.getStamina() + this.getMental() + this.getPass() + this.getTackles();
	}
}
