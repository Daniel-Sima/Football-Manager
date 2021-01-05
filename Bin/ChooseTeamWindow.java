package Test;

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

public class ChooseTeamWindow {

	private JFrame frame;
	private JLabel twoTeams;
	private JTextArea InfoTeams;


	/**
	 * Launch the application.
	 */
	public static void newScreen() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ChooseTeamWindow window = new ChooseTeamWindow();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ChooseTeamWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1000, 750);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		twoTeams = new JLabel("twoTeams");
		twoTeams.setHorizontalAlignment(SwingConstants.CENTER);
		
		Image img2 = new ImageIcon(this.getClass().getResource("/Game.jpg")).getImage();
		
		InfoTeams = new JTextArea();
		InfoTeams.setBackground(new Color(202, 235, 252));
		InfoTeams.setForeground(new Color(0, 102, 0));
		InfoTeams.setFont(new Font("Comic Sans MS", Font.PLAIN, 22));
		InfoTeams.setText("Team1 vs Team2\nScore1 : Score2"); //Il faudra utiliser getTeamName et getTeamScore
		InfoTeams.setBounds(390, 576, 177, 65);
		frame.getContentPane().add(InfoTeams);
		twoTeams.setIcon((Icon) new ImageIcon(img2));
		
		twoTeams.setBounds(0, 0, 1000, 750);
		frame.getContentPane().add(twoTeams);
		
	}
}
