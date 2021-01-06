
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

	private static final long serialVersionUID = 1L;

	public Classement() {

		Simulation championnat = new Simulation("Teams.txt", "PremierLeague");

		Team[] TabTeams = new Team[2];

		while(Simulation.getDays() < 5){
			try {
				setVisible(true);
				TimeUnit.SECONDS.sleep(1);
				TabTeams = championnat.updateChampionship("schedule.txt", "scoreboard.txt");
				championnat.readChampionship("scoreboard.txt");
				dispose();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			// Team1, Team2
			new TeamsWindow(TabTeams[0].getTeamName(), TabTeams[1].getTeamName());

		}

		new WelcomePage();

		new TeamRankings(championnat);
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
