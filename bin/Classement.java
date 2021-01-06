import java.awt.BorderLayout;

import javax.swing.*;

public class Classement extends JFrame {
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	public Classement() {
		Simulation championnat = new Simulation("database/Teams.txt","PremierLeague");

		Team[] TabTeams = new Team[2];
		String [][] rec;
		String [] header = {"Team","Played","Win","Draw","Loose","Points"};;

		JPanel panel = new JPanel();
		add(panel, BorderLayout.CENTER);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Classement");
		setSize(550,400);
		setVisible(true);
		TabTeams = championnat.updateChampionship("database/schedule.txt", "database/scoreboard.txt");
		championnat.readChampionship("database/scoreboard.txt");
		new TeamRankings(championnat);

		// Team1, Team2
		new TeamsWindow(TabTeams[0].getTeamName(), TabTeams[1].getTeamName());

		new WelcomePage();


		rec = championnat.setStringClassement();
		JTable teamTable = new JTable(rec, header);
		panel.add(new JScrollPane(teamTable));
	}

	public static void main(String [] args) {
		new Classement();
	}
}
