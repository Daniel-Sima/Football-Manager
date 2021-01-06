import java.awt.BorderLayout;
import java.util.concurrent.TimeUnit;

import javax.swing.*;

public class Classement extends JFrame {
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	public Classement() {
		Simulation championnat = new Simulation("database/Teams.txt", "PremierLeague");

		Team[] TabTeams = new Team[2];
		String[][] rec;
		String[] header = { "Team", "Played", "Win", "Draw", "Loose", "Points" };
		;

		JPanel panel = new JPanel();
		add(panel, BorderLayout.CENTER);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Classement");
		setSize(550, 400);
		setVisible(true);

		for (int i = 0; i < 2; i++) {
			try {
				TabTeams = championnat.updateChampionship("database/schedule.txt", "database/scoreboard.txt");
				championnat.readChampionship("database/scoreboard.txt");
				rec = championnat.setStringClassement();
				JTable teamTable = new JTable(rec, header);
				panel.add(new JScrollPane(teamTable));
				
				new TeamRankings(championnat);
				TimeUnit.SECONDS.sleep(1);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		
	}

	public static void main(String [] args) {
		new Classement();
	}
}
