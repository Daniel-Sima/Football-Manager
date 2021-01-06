import java.io.*;
import java.util.*;

public class Simulation{
	private String name;
    private ArrayList<Team> championship = new ArrayList<Team>();
    private int [][] tabClassement;
	private static int days = 0;

	public Simulation(String fileName, String name){
		this.name = name;
		championship = loadChampionship(fileName);
		tabClassement = new int[championship.size()][6];
		for(int i=0; i<championship.size(); i++) {
			tabClassement[i][0] = championship.get(i).getIndex();
			for(int j=1;j<6;j++) {
				tabClassement[i][j] = 0;
			}
		}
	}

	public String getChampionshipName(){ return name;}
	public static int getDays() {return days;}

	public ArrayList<Team> loadChampionship(String teamsFile) {
		ArrayList<Player> tabPlayer = new ArrayList<Player>();
        ArrayList<Team> tabTeam = new ArrayList<Team>();
        String teamName = "";

        try{
            FileReader fr = new FileReader(new File(teamsFile));
            BufferedReader br = new BufferedReader(fr);

            String ligne = br.readLine();
            while(ligne != null){  // lecture ligne par ligne jusqu'a la fin du fichier
                int i = 0;
                while(i < 17){ // 17 lignes par equipe
                    String[] liste = ligne.split(" ");
                    if(liste.length == 1){
                        teamName = liste[0];
                        tabPlayer = new ArrayList<Player>();
                    }
                    else{   // Exception NumberFormatException
                        try{
                            Player p;
                            switch(liste[0]){
                                case "Goalkeeper":
                                    p = new Goalkeeper(liste[1], Integer.parseInt(liste[2]), Integer.parseInt(liste[3]), Integer.parseInt(liste[4]), Integer.parseInt(liste[5]), Integer.parseInt(liste[6]), Integer.parseInt(liste[7]));
                                    break;
                                case "Fullback":
                                    p = new Fullback(liste[1], Integer.parseInt(liste[2]), Integer.parseInt(liste[3]), Integer.parseInt(liste[4]), Integer.parseInt(liste[5]), Integer.parseInt(liste[6]), Integer.parseInt(liste[7]));
                                break;
                                case "CentralDefender":
                                    p = new CentralDefender(liste[1], Integer.parseInt(liste[2]), Integer.parseInt(liste[3]), Integer.parseInt(liste[4]), Integer.parseInt(liste[5]), Integer.parseInt(liste[6]), Integer.parseInt(liste[7]));
                                break;
                                case "CentralMidfielder":
                                    p = new CentralMidfielder(liste[1], Integer.parseInt(liste[2]), Integer.parseInt(liste[3]), Integer.parseInt(liste[4]), Integer.parseInt(liste[5]), Integer.parseInt(liste[6]), Integer.parseInt(liste[7]));
                                break;
                                case "SideMidfielder":
                                    p = new SideMidfielder(liste[1], Integer.parseInt(liste[2]), Integer.parseInt(liste[3]), Integer.parseInt(liste[4]), Integer.parseInt(liste[5]), Integer.parseInt(liste[6]), Integer.parseInt(liste[7]));
                                break;
                                case "SideForward":
                                    p = new SideForward(liste[1], Integer.parseInt(liste[2]), Integer.parseInt(liste[3]), Integer.parseInt(liste[4]), Integer.parseInt(liste[5]), Integer.parseInt(liste[6]), Integer.parseInt(liste[7]));
                                break;
                                default:
                                    p = new CentralForward(liste[1], Integer.parseInt(liste[2]), Integer.parseInt(liste[3]), Integer.parseInt(liste[4]), Integer.parseInt(liste[5]), Integer.parseInt(liste[6]), Integer.parseInt(liste[7]));
                                break;
                            }
                            tabPlayer.add(p);
                        }catch(NumberFormatException e){
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
        }catch(NullPointerException e){
            System.out.println(e);
        }catch(FileNotFoundException e){
            System.out.println(e);
        }catch(IOException e){
            System.out.println(e);
        }
        return tabTeam;
    }

	public void readChampionship(String scoreboardFile){   // afficher le championnat
		try {
            BufferedReader br = new BufferedReader(new FileReader(scoreboardFile));
            String ligne = br.readLine();
            while(ligne != null){
            	//on recupere l'id des 2 equipes ainsi que l'id de l'equipe gagnante dans le ficher scoreboard
            	String [] tabI = ligne.split(" ");
                int indexT1 = Integer.parseInt(tabI[0]);
                int indexT2 = Integer.parseInt(tabI[1]);
                int winner = Integer.parseInt(tabI[2]);

                //on parcourt le tabClassement pour identifier les 2 equipes et mettre a jour leurs points
            	for(int i=0;i<championship.size();i++) {
        			if(tabClassement[i][0] == indexT1) {
        				tabClassement[i][1]++;
        				if(winner == indexT1) {
        					tabClassement[i][2]++;
        					tabClassement[i][5] += 3;
        				}
        				else if(winner == -1) {
        					tabClassement[i][3]++;
        					tabClassement[i][5] += 1;
        				}
        				else tabClassement[i][4]++;
        			}
        			if(tabClassement[i][0] == indexT2) {
        				tabClassement[i][1]++;
        				if(winner == indexT2) {
        					tabClassement[i][2]++;
        					tabClassement[i][5] += 3;
        				}
        				else if(winner == -1) {
        					tabClassement[i][3]++;
        					tabClassement[i][5] += 1;
        				}
        				else tabClassement[i][4]++;
        			}
            	}

            	ligne = br.readLine();
            }
            br.close();
		}catch(FileNotFoundException e) {
			System.out.println(e.getMessage());
    	}catch(IOException e) {
    		System.out.println(e.getMessage());
    	}
    }

    public Team[] updateChampionship(String scheduleFile, String scoreboardFile) {
			Team t1 = null;
			Team t2 = null;
			Team winner = null;
        try {
        	//on utilise un BufferedReader pour lire le scheduleFile ligne par ligne
            BufferedReader br = new BufferedReader(new FileReader(scheduleFile));
            //on utilise un BufferedWriter pour ecrire le score ligne par ligne
            File scoreboard = new File(scoreboardFile);
            scoreboard.createNewFile();
            BufferedWriter bw = new BufferedWriter(new FileWriter(scoreboard));

            String ligne = br.readLine();
            while(ligne != null){
                String [] tabI = ligne.split(" ");
                int indexT1 = Integer.parseInt(tabI[0]);
                int indexT2 = Integer.parseInt(tabI[1]);
                for(int i=0;i<championship.size();i++) {
                	if(championship.get(i).getIndex() == indexT1)
                		t1 = championship.get(i);
                	if(championship.get(i).getIndex() == indexT2)
                		t2 = championship.get(i);
                }
                winner = Team.match(t1,t2);
                //on utilise l'egalite pour identifier le vainqueur
                if(winner != null){
                    updatePlayers(t1, (t1 == winner));
                    updatePlayers(t2, (t2 == winner));
                    bw.write(t1.getIndex()+" "+t2.getIndex()+" "+winner.getIndex());
                }
                else bw.write(t1.getIndex()+" "+t2.getIndex()+" "+(-1));
                ligne = br.readLine();
            }
            days++; // on augmente le compteur de journees
            br.close();
            bw.close();
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }catch(IOException e){
            System.out.println(e.getMessage());
        }
				Team[] TabTeams = new Team[2];
				TabTeams[0] = team1;
				TabTeams[1] = team2;


			return TabTeams;
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
    		for(int j=1; j<6; j++) {
    			tab[i][j] = String.valueOf(tabClassement[i][j]);
    		}
    	}
    	return tab;
    }
}
