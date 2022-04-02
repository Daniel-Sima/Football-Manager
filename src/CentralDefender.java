public class CentralDefender extends DefensivePlayer {
	private int tackles;
/*--------------------------------------------------------------------------------*/
	public CentralDefender(String name, int number, int age, int stamina, int mental, int pass, int tackles){
		super(name, number, age, stamina, mental, pass);
		this.tackles = tackles;
	}
/*--------------------------------------------------------------------------------*/
	@Override
	public boolean replacementChance(){
		if(this.getStamina() < 50){  // ~
			return this.getMental() < 90;
		}
		return true;
	}
/*-------------------------------------------------------------------------------*/	
	public int getTackles(){
		return tackles;
	}
/*--------------------------------------------------------------------------------*/
	@Override
	public String getPos(){return "Central Defender";}
/*--------------------------------------------------------------------------------*/
	@Override
	public int sumAtributes(){
		return this.getStamina() + this.getMental() + this.getPass() + this.getTackles();
	}
/*-------------------------------------------------------------------------------*/	
	@Override
	public String toString(){
		return "Central Defender: "+super.toString()+"||Tackles :"+tackles;	
	}
/*-------------------------------------------------------------------------------*/	
}
