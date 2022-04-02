import java.awt.*;
import java.util.concurrent.TimeUnit;

import javax.swing.*;

public class Simulation extends JFrame implements Files{
	private static final long serialVersionUID = 1L;
	private Dimension currentScreenSize;
/*-----------------------------------------------------------------------------*/
	public Simulation() {
		Championnat championnat = new Championnat(teamsLocation, "PremierLeague");
		championnat.setDays(scheduleLocation);
		currentScreenSize = Toolkit.getDefaultToolkit().getScreenSize();

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Classement");
		setLocation((int)currentScreenSize.getWidth()/2, (int)currentScreenSize.getWidth()/21);
		setSize(680, 750);

		JPanel startPanel = new JPanel();
		startPanel.add(new WelcomePage());

		add(startPanel); // on ajoute la WelcomePage puis on charge la frame
		setVisible(true);
		try {
			TimeUnit.SECONDS.sleep(3);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
		FileTools.clearFile(scoreboardLocation); // vide le fichier scoreboard
		championnat.readChampionship(scoreboardLocation);
		add(new TeamRankings(championnat));
		revalidate();
		for (int i = 0; i < championnat.getDays(); i++) {
			try {
				championnat.updateChampionship(scheduleLocation, scoreboardLocation);
				championnat.readChampionship(scoreboardLocation);
				add(new TeamRankings(championnat));
				revalidate();
				TimeUnit.SECONDS.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
/*-----------------------------------------------------------------------------*/
	public static void main(String [] args) {
		new Simulation();
	}
/*-----------------------------------------------------------------------------*/
}
