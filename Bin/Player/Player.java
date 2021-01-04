public abstract class Player{
	private String name;
	private int number, age, stamina, mental;
	
	public Player(String name, int number, int age, int stamina, int mental){ 
		this.name = name;
		this.number = number;
		this.age = age;
		this.stamina = stamina;
		this.mental = mental;
	}
	
	
	public String getName(){return name;}
	public int getNumber(){return number;}
	public int getAge(){return age;}
	public int getStamina(){return stamina;}
	public int getMental(){return mental;}
	@Override
	public String toString(){
		return name+", "+age+", "+number+"||Stamina: "+stamina+"|| Mental: "+mental+"||Pass: ";	
	}
	
	public abstract String getPos();
	public abstract int sumAtributes();
	public abstract boolean replacementChance();
	public abstract void updateMental(Team t);
}
