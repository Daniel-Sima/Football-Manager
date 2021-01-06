
import java.awt.EventQueue;

import java.awt.Image;
import javax.swing.Icon;
import javax.swing.ImageIcon;

import javax.swing.JFrame;

import javax.swing.JLabel;
import javax.swing.SwingConstants;

import javax.swing.JTextArea;
import java.awt.Font;
import java.awt.Color;

public class TeamsWindow extends JFrame {
	private static String team1 = "";
	private static String team2 = "";


	public TeamsWindow(String team1, String team2){
		this.team1 = team1;
		this.team2 = team2;

		new JFrame();
		setBounds(100, 100, 1000, 750);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);

		JLabel twoTeams = new JLabel("twoTeams");
		twoTeams.setHorizontalAlignment(SwingConstants.CENTER);

		Image img2 = new ImageIcon(this.getClass().getResource("/Game.jpg")).getImage();

		JTextArea InfoTeams = new JTextArea();

		InfoTeams.setBackground(new Color(202, 235, 252));
		InfoTeams.setForeground(new Color(0, 102, 0));
		InfoTeams.setFont(new Font("Comic Sans MS", Font.PLAIN, 22));

		InfoTeams.setText(team1 +" vs " + team2 + "\nScore1 : Score2");

		InfoTeams.setBounds(390, 576, 177, 65);
		getContentPane().add(InfoTeams);


		twoTeams.setIcon((Icon) new ImageIcon(img2));

		twoTeams.setBounds(0, 0, 1000, 750);
		getContentPane().add(twoTeams);

		setVisible(true);

	}

	public static void main(String[] args){
		new TeamsWindow(team1, team2);
	}
}
