package Player;

public abstract class OffensivePlayer extends Player {
	// Player technical caracteristics 
	protected int finish;
	protected int dribble;

	public OffensivePlayer(String name, int number, int age, int stamina, int mental, int finish, int dribble) {
		super(name, number, age, stamina, mental);
		this.finish = finish;
		this.dribble = dribble;
	}

	@Override
	public String toString(){
		return super.toString()+"||Finish :"+finish+"||Dribble :"+dribble;	
	}
	
	public int getFinish(){
		return finish;
	}
	
	public int getDribble(){
		return dribble;
	}
	
	@Override
	public int sumAtributes(){
		return this.getStamina() + this.getMental() + this.getFinish() + this.getDribble();
	}
	
	public abstract String getPos();
	public abstract boolean replacementChance();
}
