import java.io.*;
import java.util.*;

public class Simulation{
	private String name;
	private ArrayList<Team> championship = new ArrayList<Team>();
	private static int days = 0;
	
	public Simulation(String fileName, String name){
		this.name = name;
		championship = loadChampionship(fileName);
	}
	
	public String getChampionshipName(){ return name;}
	
	public ArrayList<Team> loadChampionship(String fileName) {
		ArrayList<Player> tabPlayer = new ArrayList<Player>();
    ArrayList<Team> tabTeam = new ArrayList<Team>();
    Team t;
    String teamName = "";
    
    try{
    	FileReader fr = new FileReader(new File(fileName));
      BufferedReader br = new BufferedReader(fr);
            
      String ligne = br.readLine();
      	while(ligne != null){  //
        	int i = 0;
          while(i < 17){ // 17 lignes par equipe 
          	String[] liste = ligne.split(" ");
            if(liste.length == 1)
            	teamName = liste[0];
            else{   // Exception NumberFormatException
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
        }finally{
            return tabTeam;
        }
	}	
		
	
	public void readChampionship(String fichier){   // afficher le championnat
		Scanner s = null;
		try{
			s = new Scanner(new BufferedReader(new FileReader(fichier)));
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
	
	@Override
	public String toString(){
		String chaine = "";
		for(int i=0; i < championship.size(); i++)
			chaine += championship.get(i) + "\n";
		
		return chaine;
	}
	
}
	
	
	
