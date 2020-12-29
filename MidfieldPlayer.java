public abstract class MidfieldPlayer extends Player{
	// Player 
	protected String name;
	protected int number;
	protected int age;
	// Player technical caracteristics 
	protected int stamina;
	protected int pass;
	protected int dribble;
	protected int mental;

	public MidfieldPlayer(String name, int number, int age, int stamina, int pass, int dribble, int mental) {
		this.name = name;
		this.number = number;
		this.age = age;
		this.stamina = stamina;
		this.pass = pass;
		this.dribble = dribble;
		this.mental = mental;
	}

	public String getName(){return name;}
	public int getNumber(){return number;}
	public int getAge(){return age;}
	public int getStamina(){return stamina;}
	public int getPass(){return pass;}
	public int getDribble(){return dribble;}
	public int getMental(){return mental;}

	public abstract String getPos();
	public abstract void play(Player p);
	public abstract boolean replacementChance();
	public abstract void updateMental(TeamStatistics ts);
}