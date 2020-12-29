public class Ball{
	private int posX, posY, shootProb;
	private boolean ballTeam1, ballTeam2;
	
	public Ball(){
		posX = 120/2;  // 120m length
		posY = 80/2;   // 40m width
		shootProb = 0;  // 0 beacause midfield
		// la balle n'appartient a personne pour l'instant 
		ballTeam1 = false; 
		ballTeam2 = false; 
	}
	
	public void drawBall(Team t1, Team t2){  // retourne l'equipe qui a le ballon en 
		int numT1, numT2;											 // 1ere MT
		
		numT1 = (int)(Math.random()*101);  // between 0 and 100
		numT2 = (int)(Math.random()*101);  // between 0 and 100
		
		if(numT1 >= numT2) ballTeam1 = true; 
		else ballTeam2 = true; 
	}
	
	public void nextAction(Player p1, Player p2){   // posY a faire 
		int pointsP1 = p1.getSumStats() + (int)(Math.random()*5); // + ajout aleatoire
		int pointsP2 = p2.getSumStats() + (int)(Math.random()*5); // + ajout aleatoire

		do{
		if(pointsP1 > pointsP2)
			posX += 20;  // +20 car la moitie de terrain d'une Team = 60 
									 // et on divise par 3 car 3 parties principales: 
									 // attaque, milieu et defense		
		if(pointsP1 < pointsP2)
			posX -= 20;  //  même chose
		else{
			pointsP1 += Math.random();
			pointsP2 += Math.random(); 
		}
		}while(pointsP1 == pointsP2);
		
		if(posX == 60) shootProb = 0;
		if(posX == 80 || posX == 40) shootProb = 20;
		if(posX == 100 || posX == 20) shootProb = 50; 
		if(posX > 100 || posX < 20) shootProb = 80;	
	}
	
	public boolean goal(Goalkeeper p1, Player p2){  // tir (a mettre 2/3 fois par MT)
		if(shootProb == 0) return false;
		int pointsP1 = p1.getSumStats() + (shootProb-shootProb%10) + (int)(Math.random()*21); // + ajout aleatoire
		int pointsP2 = p2.getSumStats() + shootProb + (int)(Math.random()*21); // + ajout aleatoire
	
		if(pointsP2 > pointsP1){
			ball();
			ballTeam1 = true;
			return true; // goal
		}
		else return false;
	}
	
	@Override
	public String toString(){
		return "Ball position : ["+posX+", "+posY+"]";
	}		
}
