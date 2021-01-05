import java.io.*;
import java.util.*;

public class Simulation{
	private String name;
    public ArrayList<Team> championship = new ArrayList<Team>();
	private static int days = 0;
	
	public Simulation(String fileName, String name){
		this.name = name;
		championship = loadChampionship(fileName);
	}
	
	public String getChampionshipName(){ return name;}
	
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
		Scanner s = null;
		try{
			s = new Scanner(new BufferedReader(new FileReader(scoreboardFile)));
			while(s.hasNext()){
				System.out.println(s.nextLine());
			}
		}catch(FileNotFoundException e){
			System.out.println("File not found\n");
		}finally{
			if(s != null)
				s.close();
		}
    }
    
    public void updateChampionship(String scheduleFile) {
        try {
            BufferedReader br = new BufferedReader(new FileReader(scheduleFile));
            String ligne = br.readLine();
            while(ligne != null){
                String [] tabI = ligne.split(" ");
                int indexT1 = Integer.parseInt(tabI[0]);
                int indexT2 = Integer.parseInt(tabI[1]);
                Team t1 = championship.get(indexT1);
                Team t2 = championship.get(indexT2);

                Team winner = Team.match(t1,t2);
                //on utilise l'égalité pour identifier le vainqueur
                if(winner != null){
                    updatePlayers(t1, (t1 == winner));
                    updatePlayers(t2, (t2 == winner));
                }
                ligne = br.readLine();
            }
            days++; // on augmente le compteur de journées
            br.close();
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }catch(IOException e){
            System.out.println(e.getMessage());
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
    
    public static void main(String[] args) {
        Simulation test = new Simulation("Teams.txt", "Test");
        System.out.println(test.championship.get(3).toString());
        test.updateChampionship("schedule.txt");
        System.out.println(test.championship.get(3).toString());
    }
	
}
	
	
	
