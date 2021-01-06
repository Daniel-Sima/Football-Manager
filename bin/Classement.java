import java.awt.*;
import java.util.concurrent.TimeUnit;

import javax.swing.*;

public class Classement extends JFrame {
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	private Dimension currentScreenSize;

	public Classement() {
		Simulation championnat = new Simulation("database/Teams.txt", "PremierLeague");
		championnat.setDays("database/schedule.txt");
		currentScreenSize = Toolkit.getDefaultToolkit().getScreenSize();

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Classement");
		setLocation((int)currentScreenSize.getWidth()/2, (int)currentScreenSize.getWidth()/21);
		setSize(680, 750);

		JPanel startPanel = new JPanel();
		startPanel.add(new WelcomePage());

		add(startPanel);
		setVisible(true);
		try {
			TimeUnit.SECONDS.sleep(3);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
		championnat.readChampionship("database/scoreboard.txt");
		add(new TeamRankings(championnat));
		revalidate();
		for (int i = 0; i < championnat.getDays(); i++) {
			try {
				championnat.updateChampionship("database/schedule.txt", "database/scoreboard.txt");
				championnat.readChampionship("database/scoreboard.txt");
				add(new TeamRankings(championnat));
				revalidate();
				TimeUnit.SECONDS.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
		}
	}

	public static void main(String [] args) {
		new Classement();
	}
}
