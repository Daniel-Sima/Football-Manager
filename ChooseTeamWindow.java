package Test;

import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;

public class ChooseTeamWindow {

	private JFrame frame;
	private JLabel twoTeams;
	private JTextField textField;

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
		twoTeams.setIcon((Icon) new ImageIcon(img2));
		
		twoTeams.setBounds(0, 0, 1000, 750);
		frame.getContentPane().add(twoTeams);
		
	}
}
