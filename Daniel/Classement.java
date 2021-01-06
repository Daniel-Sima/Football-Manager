
import java.awt.BorderLayout;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import javax.swing.*;
import javax.swing.border.TitledBorder;

public class Classement extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Classement() {
		Simulation championnat = new Simulation("Teams.txt","PremierLeague");
		
		JPanel panel = new JPanel();
		panel.setBorder(BorderFactory.createTitledBorder( BorderFactory.createEtchedBorder(),
						"ODI Rankings", TitledBorder.CENTER, TitledBorder.TOP));
		
		championnat.updateChampionship("schedule.txt", "scoreboard.txt");
		championnat.readChampionship("scoreboard.txt");
		
		
		String [][] rec = championnat.setStringClassement();
		String [] header = {"Team","Played","Win","Draw","Loose","Points"};
		JTable teamTable = new JTable(rec, header);
		
		panel.add(new JScrollPane(teamTable));
		add(panel, BorderLayout.CENTER);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Classement");
		setSize(550,400);
		setVisible(true);
		
	}
	
	public static void main(String [] args) {
		new Classement();
	}
}
