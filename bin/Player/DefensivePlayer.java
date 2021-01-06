package Player;
public abstract class DefensivePlayer extends Player {
	// Player technical caracteristics 
	protected int pass;

	public DefensivePlayer(String name, int number, int age, int stamina, int mental, int pass) {
		super(name, number, age, stamina, mental);
		this.pass = pass;
	}
	
	@Override
	public String toString(){
		return super.toString()+"||Pass :"+pass;	
	}

	public int getPass(){
		return pass;
	}
	
	public abstract String getPos();
	public abstract boolean replacementChance();
	public abstract int sumAtributes();
}
