public abstract class MidfieldPlayer extends Player {
	// Player technical caracteristics 
	protected int pass;
	protected int dribble;
/*--------------------------------------------------------------------------------*/
	public MidfieldPlayer(String name, int number, int age, int stamina, int mental, int pass, int dribble){
		super(name, number, age, stamina, mental);
		this.pass = pass;
		this.dribble = dribble;
	}
/*--------------------------------------------------------------------------------*/
	@Override
	public String toString(){
		return super.toString()+"||Pass :"+pass+"||Dribble :"+dribble;	
	}
/*--------------------------------------------------------------------------------*/
	public int getPass(){
		return pass;
	}
/*--------------------------------------------------------------------------------*/	
	public int getDribble(){
		return dribble;
	}
/*--------------------------------------------------------------------------------*/	
	@Override
	public int sumAtributes(){
		return this.getStamina() + this.getMental() + this.getPass() + this.getDribble();
	}
/*-------------------------------------------------------------------------------*/	
	public abstract String getPos();
	public abstract boolean replacementChance();
/*--------------------------------------------------------------------------------*/
}
