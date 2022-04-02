import java.io.*;

public class FileTools {
	// classe static contenant methodes utiles pour la simulation
    private  FileTools(){}
/*-----------------------------------------------------------------------------*/    
	// methode pour ecrire dans un fichier en argument
    public static void writeFile(String file, String data) {
		BufferedWriter writer = null;
		try {
			writer = new BufferedWriter(new FileWriter(file, true));
			writer.write(data);
		} catch (IOException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if (writer != null)
					writer.close();
			} catch (IOException ex) {
				System.out.println(ex.getMessage());
			}
		}
	}
/*-----------------------------------------------------------------------------*/
	// methode pour reinitialiser le contenu d'un fichier
	public static void clearFile(String file) {
        try {
            FileWriter f = new FileWriter(file, false);
            PrintWriter pw = new PrintWriter(f, false);
            pw.flush();
            pw.close();
            f.close();
        } catch (IOException e) {
            e.printStackTrace();
        }	
	}
/*-----------------------------------------------------------------------------*/
	// trie un tableau d'elements en ordre decroissant
	public static Element[] trier(int[][] tab){
		Element[] tableau = new Element[tab.length];
		for(int i=0;i<tab.length;i++){
			for(int j=0;j<6;j++){
				tableau[i] = new Element(tab[i][0],tab[i][1],tab[i][2],tab[i][3],tab[i][4], tab[i][5]);
			}
		}

		Element temp;
		int max;
		for (int index = 0; index < tableau.length - 1; index++){
			max = index;
			for (int i = index + 1; i < tableau.length; i++)
				if (tableau[i].getElemPts() > tableau[max].getElemPts())
					max = i;

			temp = tableau[max];
			tableau[max] = tableau[index];
			tableau[index] = temp;
		}
		return tableau;
	} 
/*-----------------------------------------------------------------------------*/
}
