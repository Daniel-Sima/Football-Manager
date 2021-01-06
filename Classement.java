
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
		Simulation championnat = new Simulation("Teams.txt", "PremierLeague");

		new WelcomePage();

		JPanel panel = new JPanel();
		panel.setBorder(BorderFactory.createTitledBorder( BorderFactory.createEtchedBorder(),
						"ODI Rankings", TitledBorder.CENTER, TitledBorder.TOP));

		String [][] rec = championnat.setStringClassement();
		String [] header = {"Team","Played","Win","Draw","Loose"};
		JTable teamTable = new JTable(rec, header);

		panel.add(new JScrollPane(teamTable));
		add(panel, BorderLayout.CENTER);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Classement");
		setSize(550,400);
		setVisible(true);

		while(Simulation.getDays() < 5){
			new TeamsWindow();
			try {
				setVisible(true);
				TimeUnit.SECONDS.sleep(1);
				championnat.updateChampionship("schedule.txt", "scoreboard.txt");
				championnat.readChampionship("scoreboard.txt");
				dispose();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}

	public static void main(String [] args) {
		FileOutputStream fout = null;

		try {
			fout = new FileOutputStream("scoreboard.txt");
			System.out.println("tamerelapute");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}finally {
			if(fout != null)
				try {
					fout.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
		}
	}
}
