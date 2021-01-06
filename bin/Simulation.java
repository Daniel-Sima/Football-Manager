import java.io.*;
import java.util.*;
import java.util.concurrent.TimeUnit;

import Player.*;

public class Simulation {
	private String name;
	private ArrayList<Team> championship = new ArrayList<Team>();
	private int[][] tabClassement;
	private int days = 1;
	private int ligneIndex;

	public Simulation(String fileName, String name) {
		this.name = name;
		championship = loadChampionship(fileName);
		tabClassement = new int[championship.size()][6];
		for (int i = 0; i < championship.size(); i++) {
			tabClassement[i][0] = championship.get(i).getIndex();
			for (int j = 1; j < 6; j++) {
				tabClassement[i][j] = 0;
			}
		}
		ligneIndex = 0;
	}

	public String getChampionshipName() {
		return name;
	}

	public int getDays() {
		return days;
	}

	public void setDays(String schedule) {
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader(schedule));

			String ligne;
			ligne = br.readLine();
			while (ligne != null) {
				if (ligne.length() == 0)
					days++;
				ligne = br.readLine();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (br != null)
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
		}

	}

	public ArrayList<Team> loadChampionship(String teamsFile) {
		ArrayList<Player> tabPlayer = new ArrayList<Player>();
		ArrayList<Team> tabTeam = new ArrayList<Team>();
		String teamName = "";

		try {
			FileReader fr = new FileReader(new File(teamsFile));
			BufferedReader br = new BufferedReader(fr);

			String ligne = br.readLine();
			while (ligne != null) { // lecture ligne par ligne jusqu'a la fin du fichier
				int i = 0;
				while (i < 17) { // 17 lignes par equipe
					String[] liste = ligne.split(" ");
					if (liste.length == 1) {
						teamName = liste[0];
						tabPlayer = new ArrayList<Player>();
					} else { // Exception NumberFormatException
						try {
							Player p;
							switch (liste[0]) {
								case "Goalkeeper":
									p = new Goalkeeper(liste[1], Integer.parseInt(liste[2]), Integer.parseInt(liste[3]),
											Integer.parseInt(liste[4]), Integer.parseInt(liste[5]),
											Integer.parseInt(liste[6]), Integer.parseInt(liste[7]));
									break;
								case "Fullback":
									p = new Fullback(liste[1], Integer.parseInt(liste[2]), Integer.parseInt(liste[3]),
											Integer.parseInt(liste[4]), Integer.parseInt(liste[5]),
											Integer.parseInt(liste[6]), Integer.parseInt(liste[7]));
									break;
								case "CentralDefender":
									p = new CentralDefender(liste[1], Integer.parseInt(liste[2]),
											Integer.parseInt(liste[3]), Integer.parseInt(liste[4]),
											Integer.parseInt(liste[5]), Integer.parseInt(liste[6]),
											Integer.parseInt(liste[7]));
									break;
								case "CentralMidfielder":
									p = new CentralMidfielder(liste[1], Integer.parseInt(liste[2]),
											Integer.parseInt(liste[3]), Integer.parseInt(liste[4]),
											Integer.parseInt(liste[5]), Integer.parseInt(liste[6]),
											Integer.parseInt(liste[7]));
									break;
								case "SideMidfielder":
									p = new SideMidfielder(liste[1], Integer.parseInt(liste[2]),
											Integer.parseInt(liste[3]), Integer.parseInt(liste[4]),
											Integer.parseInt(liste[5]), Integer.parseInt(liste[6]),
											Integer.parseInt(liste[7]));
									break;
								case "SideForward":
									p = new SideForward(liste[1], Integer.parseInt(liste[2]),
											Integer.parseInt(liste[3]), Integer.parseInt(liste[4]),
											Integer.parseInt(liste[5]), Integer.parseInt(liste[6]),
											Integer.parseInt(liste[7]));
									break;
								default:
									p = new CentralForward(liste[1], Integer.parseInt(liste[2]),
											Integer.parseInt(liste[3]), Integer.parseInt(liste[4]),
											Integer.parseInt(liste[5]), Integer.parseInt(liste[6]),
											Integer.parseInt(liste[7]));
									break;
							}
							tabPlayer.add(p);
						} catch (NumberFormatException e) {
							System.out.println(e.getMessage());
						}
					}
					i++;
					ligne = br.readLine();
				}
				tabTeam.add(new Team(teamName, tabPlayer));
			}
			br.close();
			fr.close();
		} catch (NullPointerException e) {
			System.out.println(e);
		} catch (FileNotFoundException e) {
			System.out.println(e);
		} catch (IOException e) {
			System.out.println(e);
		}
		return tabTeam;
	}

	public void readChampionship(String scoreboardFile) { // afficher le championnat
		BufferedReader br = null;
		String ligne;

		try {
			br = new BufferedReader(new FileReader(scoreboardFile));
			ligne = br.readLine();
			while (ligne != null) {
				// on recupere l'id des 2 equipes ainsi que l'id de l'equipe gagnante dans le
				// ficher scoreboard
				String[] tabI = ligne.split(" ");
				// System.out.println(ligne);
				int indexT1 = Integer.parseInt(tabI[0]);
				// System.out.println(indexT1);
				int indexT2 = Integer.parseInt(tabI[1]);
				int winner = Integer.parseInt(tabI[2]);
				// int score1 = Integer.parseInt(tabI[3]);
				// int score2 = Integer.parseInt(tabI[4]);

				// on parcourt le tabClassement pour identifier les 2 equipes et mettre a jour
				// leurs points
				for (int i = 0; i < championship.size(); i++) {
					if (tabClassement[i][0] == indexT1) {
						tabClassement[i][1]++;
						if (winner == indexT1) { // T1 win
							tabClassement[i][2]++;
							tabClassement[i][5] += 3;
						} else if (winner == -1) { // draw
							tabClassement[i][3]++;
							tabClassement[i][5] += 1;
						} else
							tabClassement[i][4]++;
					}
					if (tabClassement[i][0] == indexT2) {
						tabClassement[i][1]++;
						if (winner == indexT2) { // T2 win
							tabClassement[i][2]++;
							tabClassement[i][5] += 3;
						} else if (winner == -1) {
							tabClassement[i][3]++;
							tabClassement[i][5] += 1;
						} else
							tabClassement[i][4]++;
					}
				}

				ligne = br.readLine();
			}
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if (br != null)
					br.close();
			} catch (IOException ex) {
				System.out.println(ex.getMessage());
			}
		}
	}

	public void updateChampionship(String scheduleFile, String scoreboardFile) {
		BufferedReader br = null;
		BufferedWriter bw = null;
		String ligne;
		Team t1 = null;
		Team t2 = null;

		try {
			// on utilise un BufferedReader pour lire le scheduleFile ligne par ligne
			br = new BufferedReader(new FileReader(scheduleFile));
			// on utilise un BufferedWriter pour ecrire le score ligne par ligne
			File scoreboard = new File(scoreboardFile);
			// scoreboard.createNewFile();
			bw = new BufferedWriter(new FileWriter(scoreboard));

			for(int i=0;i<ligneIndex;i++) br.readLine();
			ligne = br.readLine();
			while (ligne.length() != 0) {
				String[] tabI = ligne.split(" ");
				int indexT1 = Integer.parseInt(tabI[0]);
				int indexT2 = Integer.parseInt(tabI[1]);
				t1 = null;
				t2 = null;
				for (int i = 0; i < championship.size(); i++) {
					if (championship.get(i).getIndex() == indexT1)
						t1 = championship.get(i);
					if (championship.get(i).getIndex() == indexT2)
						t2 = championship.get(i);
				}
				Team winner = t1.match(t2);
				// on utilise l'egalite pour identifier le vainqueur
				if (winner != null) {
					updatePlayers(t1, (t1 == winner));
					updatePlayers(t2, (t2 == winner));
					String data = t1.getIndex() + " " + t2.getIndex() + " " + winner.getIndex() + "\n";
					writeFile(scoreboardFile, data);
				} else {
					String data = t1.getIndex() + " " + t2.getIndex() + " " + (-1) + "\n";
					writeFile(scoreboardFile, data);
				}

				new TeamsWindow(t1.getTeamName(), t2.getTeamName());


				try {
					TimeUnit.SECONDS.sleep(1);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				
                ligne = br.readLine();
			}
			ligneIndex += 11;
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		}catch(IOException e){
			System.out.println(e.getMessage());
		}finally{
			try{
				if(br != null)
					br.close();
				if(bw != null)
					bw.close();
			}catch(IOException ex){
				System.out.println(ex.getMessage());
			}
		}
    }

    public void updatePlayers(Team t, boolean result){
        //on utilise un boolean pour : win / loose
        //(un draw etant percu comme une defaite pour tout footballer qui se respecte !)
        for(int i=0;i<t.players.size();i++){
            t.players.get(i).updateMental(result);
        }
    }
	
	@Override
	public String toString(){
		String chaine = "";
		for(int i=0; i < championship.size(); i++)
			chaine += championship.get(i) + "\n";
		
		return chaine;
    }
	
	public Team getTeamById(int id) {
		for(int i=0;i<championship.size();i++) {
			if(id == championship.get(i).getIndex())
				return championship.get(i);
		}
		return null;
	}
	
    public String[][] setStringClassement(){
    	String [][] tab = new String[championship.size()][6];
    	for(int i=0;i<championship.size(); i++) {
    		tab[i][0] = getTeamById(tabClassement[i][0]).getTeamName();
    		for(int j=1; j<6; j++){
    			//System.out.println(tabClassement[i][j]);
    			tab[i][j] = ""+tabClassement[i][j];
    		}
    	}
    	return tab;
    }
    
   /* 
    public int[][] setRealClassament(){
    	int[][] tab = tabClassement;
    	int[][] tabRes = new int[championship.size()][6];
    	for(int i=0;i<championship.size();i++){
    		tabRes[i] = getTabFirst(tab);
    		tab
    	}

  		return tabBis;
  	}
  	
  	public int[] getTabFirst(int [][] tab){
  		int[] tabRes = new int[6];
			int tmpId = 0, tmpPts = tab[0][5];
			for(int i = 0; i < championship.size(); i++){
				if(tab[i][5] > tmpPts){
					for(int j=0;j<6;j++){
						tmpPts = tab[i][5];
						tabRes[j] = tab[i][j];
					}
				}
			}
			for(int i = 0;i<championship.size();i++){
				if(tab[i] = tabRes){
					
				}
			}
			return tabRes;
		}
		
		public void supprimerElement(int[] propo){ 
		 	for( int i=0; i<tailleTableau; i++){
				if(propo==tab[i]){     
	 
				for(int j=i+1; j<tailleTableau; j++)
					{ 
					tab[j-1]=tab[j];
					//System.out.println(tab[j]);		
					      }
					tailleTableau=tailleTableau-1;	
					for(int k=0; k<tailleTableau; k++)
					{System.out.println(tab[k]);
					}
				}
			}
	  }
  	*/	  
   public void writeFile(String file, String data) throws IOException{
			BufferedWriter writer = null;
			try{
			 	writer = new BufferedWriter(new FileWriter(file, true));
				writer.write(data);
			}catch(IOException e){
				System.out.println(e.getMessage());
			}finally{
				try{
					if(writer != null)
						writer.close();
				}catch(IOException ex){
					System.out.println(ex.getMessage());
				}
			}
	} 
}
	
	
	
