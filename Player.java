public abstract class Player{
	public abstract String getName();
	public abstract int getNumber();
	public abstract int getAge();
	public abstract String getPos();
	
	public abstract void play(Player p);
	public abstract boolean replacementChance();
	public abstract void updateMental(TeamStatistics ts);
}