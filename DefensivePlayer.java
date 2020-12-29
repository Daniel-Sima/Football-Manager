public abstract class DefensivePlayer extends Player{
	// Player 
	protected String name;
	protected int number;
	protected int age;
	// Player technical caracteristics 
	protected int pass;
	protected int mental;

	public DefensivePlayer(String name, int number, int age, int pass, int mental) {
		this.name = name;
		this.number = number;
		this.age = age;
		this.pass = pass;
		this.mental = mental;
	}

	public String getName(){return name;}
	public int getNumber(){return number;}
	public int getAge(){return age;}
	public int getPass(){return pass;}
	public int getMental(){return mental;}

	public abstract String getPos();
	public abstract void play(Player p);
	public abstract boolean replacementChance();
	public abstract void updateMental(TeamStatistics ts);
}